package com.monkeyliu.smartfocusdemo.retrofit.Utils;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.monkeyliu.smartfocusdemo.retrofit.ApiUrl;
import com.monkeyliu.smartfocusdemo.retrofit.Constans;

import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit封装
 */
public class RetrofitUtils {
    private static final String TAG = "RetrofitUtils";
    private static ApiUrl mApiUrl;
    /**
     * 单例模式
     */
    public static ApiUrl getApiUrl() {
        if (mApiUrl == null) {
            synchronized (RetrofitUtils.class) {
                if (mApiUrl == null) {
                    mApiUrl = new RetrofitUtils().getRetrofit();
                }
            }
        }
        return mApiUrl;
    }

    public static ApiUrl getApiUrl(String url) {
        return new RetrofitUtils().getRetrofit(url);
    }
    private RetrofitUtils(){}

    public ApiUrl getRetrofit() {
        // 初始化Retrofit
        ApiUrl apiUrl = initRetrofit(initOkHttp(),null) .create(ApiUrl.class);
        return apiUrl;
    }

    public ApiUrl getRetrofit(String url) {
        // 初始化Retrofit
        ApiUrl apiUrl = initRetrofit(initOkHttp(),url) .create(ApiUrl.class);
        return apiUrl;
    }

    /**
     * 初始化Retrofit
     */
    @NonNull
    private Retrofit initRetrofit(OkHttpClient client,String url) {
        return new Retrofit.Builder()
                    .client(client)
                    .baseUrl(url)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }

    /**
     * 初始化okhttp
     */
    @NonNull
    private OkHttpClient initOkHttp() {
        return new OkHttpClient().newBuilder()
                    .readTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                    .connectTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                    .writeTimeout(Constans.DEFAULT_TIME,TimeUnit.SECONDS)//设置写入超时时间
                    .addInterceptor(new LogInterceptor())//添加打印拦截器
                    .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                    .build();
    }
}

