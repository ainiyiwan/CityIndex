package com.zy.xxl.cityindex;

import android.app.Application;

import com.google.gson.Gson;
import com.squareup.leakcanary.LeakCanary;
import com.zy.xxl.cityindex.common.ModelManager;
import com.zy.xxl.cityindex.common.TaskScheduler;
import com.zy.xxl.cityindex.db.DBManage;
import com.zy.xxl.cityindex.util.LogHelper;

/**
 * Author ： zhangyang
 * Date   ： 2017/11/15
 * Email  :  18610942105@163.com
 * Description  :
 */

public class MyApplication extends Application {

    private static Application sApplication;
    private static Gson sGson = new Gson();

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        sApplication = this;

        TaskScheduler.init();

        DBManage.getInstance().copyCitysToDB();

        if (BuildConfig.DEBUG) {

            LogHelper.debugInit();
        } else {
            LogHelper.releaseInit();
        }
    }

    public static Gson getGson() {
        return sGson;
    }

    public static Application getContext() {
        return sApplication;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ModelManager.unSubscribeAll();
    }
}
