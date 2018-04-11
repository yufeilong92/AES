package com.example.administrator.myapplication.MyApplication;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.example.administrator.myapplication.MyApplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/4/8 17:15
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class Aption extends Application {

    public static OkHttpClient okHttpClient;

    public Aption getInstance() {
        return new Aption();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initHttpClient();
    }

    private void initHttpClient() {
        if (okHttpClient == null) {
            synchronized (OkHttpClient.class) {
                if (okHttpClient == null) {
                    //其他配置
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new LoggerInterceptor("TAG"))
                            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                            .readTimeout(10000L, TimeUnit.MILLISECONDS)
                            //其他配置
                            .build();
                }
            }
        }
        OkHttpUtils.initClient(okHttpClient);
    }
}
