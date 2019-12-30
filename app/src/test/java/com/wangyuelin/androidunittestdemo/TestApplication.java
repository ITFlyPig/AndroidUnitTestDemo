package com.wangyuelin.androidunittestdemo;

import android.app.Application;

//在实际的项目中，Application可能创建时可能会初始化一些其他的依赖库，不太方便单元测试，这里额外创建一个Application类，不需要在清单文件注册，直接写在本地测试目录即可。
public class TestApplication extends Application {
}
