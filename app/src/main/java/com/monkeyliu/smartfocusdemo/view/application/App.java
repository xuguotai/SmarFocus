package com.monkeyliu.smartfocusdemo.view.application;

import android.app.Application;
import android.content.Context;

import com.monkeyliu.smartfocusdemo.view.util.SPUtil;

/**
*@Author tai
*@Time 2020/12/16 11:57
*@Description
*/
public class App extends Application {
    public static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
       // CrashHandler.getInstance().init(getApplicationContext());
        SPUtil.getInstance(getApplicationContext()).getSelectLanguage();
    }
}
