/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dcbd.base;

import android.app.Application;
import android.content.Context;

import com.dcbd.bean.DCBD_Info;

public class BaseApp extends Application {

    public static Context applicationContext;
    // 当前登录的化妆品公司用户信息
    public static DCBD_Info dcbd_info;
    private static BaseApp instance;
    private boolean isDownload;

    public static BaseApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationContext = this;
        instance = this;
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

}
