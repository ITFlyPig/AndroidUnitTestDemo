package com.wangyuelin.androidunittestdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;


@RunWith(RobolectricTestRunner.class)
@Config(shadows = {ShadowLog.class}, sdk = 28, application = TestApplication.class)
public class MainActivityTest {

    @Before
    public void setUp() throws Exception {
        ShadowLog.stream = System.out;
    }

    @Test
    public void onCreate() {

        //获得application实例
        Log.d("wyl", "开始获取Application实例");
        TestApplication application = ApplicationProvider.getApplicationContext();
        application.onCreate();

        //启动activity

        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            scenario.onActivity(activity -> {
                Log.d("wyl", "onActivity");
                TextView textView = activity.findViewById(R.id.textview);
                Log.d("wly", "按钮的文字：" + textView.getText());
                //模拟点击
                textView.performClick();

                SharedPreferences sp = activity.getSharedPreferences("test", Context.MODE_PRIVATE);
                sp.edit().putString("name", "wangyuelin").commit();

                Log.d("wyl", "存如的数据：" + sp.getString("name", "null"));
            });
            //改变Activity的状态
//            scenario.moveToState(Lifecycle.State.CREATED);
//            scenario.moveToState(Lifecycle.State.RESUMED);
        }

    }
}