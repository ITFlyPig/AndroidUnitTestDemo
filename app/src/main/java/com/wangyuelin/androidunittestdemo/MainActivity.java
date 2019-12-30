package com.wangyuelin.androidunittestdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("wyl", "Android单元测试");
        TextView textView = findViewById(R.id.textview);
        textView.setOnClickListener(view -> {
            Log.d("wyl", "按钮被点击了");
        });

    }
}
