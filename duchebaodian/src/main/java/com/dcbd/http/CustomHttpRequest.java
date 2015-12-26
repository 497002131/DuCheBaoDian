package com.dcbd.http;

import android.content.Context;

import com.dcbd.R;
import com.dcbd.common.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.entity.StringEntity;


/**
 * 自定义网络请求公共类
 */
public class CustomHttpRequest {

    private static AsyncHttpClient httpClient;

    /**
     * get方法
     *
     * @param context             方法入口
     * @param url                 请求地址
     * @param httpRequestCallback 请求结果的回调
     */
    public static void get(final Context context, String url, final HttpRequestCallback httpRequestCallback) {

        if (!Utils.isNetWorkConnected(context)) {
            httpRequestCallback.fial(context.getResources().getString(R.string.connect_failuer_toast));
            return;
        }

        if (httpClient == null) {
            httpClient = new AsyncHttpClient();
        }

        httpClient.get(context, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                httpRequestCallback.success(content);
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                httpRequestCallback.fial(context.getResources().getString(R.string.connect_failuer_toast));
            }
        });

    }

    /**
     * post方法
     *
     * @param context             方法入口
     * @param url                 请求地址
     * @param jsonString          将json格式的数据转换为string
     * @param httpRequestCallback 请求结果的回调
     */
    public static void post(final Context context, String url, String jsonString, final HttpRequestCallback httpRequestCallback) {

        if (!Utils.isNetWorkConnected(context)) {
            httpRequestCallback.fial(context.getResources().getString(R.string.connect_failuer_toast));
            return;
        }
        StringEntity entity = new StringEntity(jsonString, "UTF_8");
        if (httpClient == null) {
            httpClient = new AsyncHttpClient();
        }
        httpClient.post(context, url, entity, "application/json",
                new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(String content) {
                        super.onSuccess(content);
                        httpRequestCallback.success(content);
                    }

                    @Override
                    public void onFailure(Throwable error, String content) {
                        super.onFailure(error, content);
                        httpRequestCallback.fial(context.getResources().getString(R.string.connect_failuer_toast));
                    }
                });
    }

    public interface HttpRequestCallback {
        public abstract void success(String success);

        public abstract void fial(String fial);
    }

}
