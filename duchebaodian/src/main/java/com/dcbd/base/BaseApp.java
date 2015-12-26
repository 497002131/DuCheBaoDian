package com.dcbd.base;

import android.app.Application;
import android.content.Context;

import com.dcbd.bean.DCBD_Info;

public class BaseApp extends Application {
    public static Context applicationContext;
    // 当前登录的化妆品公司用户信息
    public static DCBD_Info dcbd_info;
    //是否正在更新下载
    private boolean isDownload;
    /**
     * private的构造函数用于避免外界直接使用new来实例化对象
     */
    private BaseApp() {
    }

    public static BaseApp getInstance() {
        return SingletonHolder.INSTANCE;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        applicationContext = this;
        isDownload = false;

        // 初始化用户信息
        dcbd_info = new DCBD_Info(applicationContext);

    }

    public boolean isDownload() {
        return isDownload;
    }

    public void setDownload(boolean isDownload) {
        this.isDownload = isDownload;
    }

    private static class SingletonHolder {
        /**
         * 单例对象实例
         */
        static final BaseApp INSTANCE = new BaseApp();
    }
}
