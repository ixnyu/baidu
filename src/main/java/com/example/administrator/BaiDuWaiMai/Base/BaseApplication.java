package com.example.administrator.BaiDuWaiMai.Base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.example.administrator.BaiDuWaiMai.tools.LogUtils;

/**
 * 代表当前应用程序
 * @author itcast
 *
 */
public class BaseApplication extends Application {
    private static BaseApplication application;
    private static int mainTid;
    private static Handler handler;
    @Override
//  在主线程运行的
    public void onCreate() {
        super.onCreate();
        LogUtils.w("BaseApplication 创建完成");
        application=this;
        mainTid = android.os.Process.myTid();
        handler=new Handler();
    }
    public static Context getApplication() {
        return application;
    }
    public static int getMainTid() {
        return mainTid;
    }
    public static Handler getHandler() {
        return handler;
    }


}
