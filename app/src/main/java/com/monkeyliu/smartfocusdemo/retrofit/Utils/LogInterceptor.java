package com.monkeyliu.smartfocusdemo.retrofit.Utils;

import android.net.Uri;

import com.monkeyliu.smartfocusdemo.view.util.LogUtils;
import com.monkeyliu.smartfocusdemo.view.util.NetWorkUtils;

import java.io.IOException;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;

/**
 *  TODO Log拦截器代码
 */
public class LogInterceptor implements Interceptor{
    private String TAG = "okhttp";

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        LogUtils.e("request:" + request.toString());
        String url = request.url().toString();
        if (NetWorkUtils.needAddToken(request)) {
            Uri uri = Uri.parse(url);
            Set<String> oldParam = uri.getQueryParameterNames();
            /*if (!oldParam.contains("token")) {
                String token = getToken();
                if (oldParam.size() > 0) {
                    url += "&token=" + token;
                } else {
                    url += "?token=" + token;
                }
            }*/
        }
      /*  CacheControl.Builder cacheBuilder =new CacheControl.Builder();
        cacheBuilder.maxAge(0, TimeUnit.SECONDS);
        cacheBuilder.maxStale(30,TimeUnit.DAYS);
        CacheControl cacheControl = cacheBuilder.build();
        String method = request.method();
        if (method.toUpperCase()=="GET"){
            request =request.newBuilder().url(url).cacheControl(cacheControl).build();
        }*/
        request =request.newBuilder().url(url).build();
        okhttp3.Response response = chain.proceed(request);
      /*  if (NetWorkUtils.isNetWorkAvailable(App.mAppContext)){
            int maxAge = 0 ; // read from cache
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public ,max-age=$"+maxAge)
                    .build();
        }else {
            int maxStale = 60 * 60 * 24 * 28;// 4周
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=$"+maxStale)
                    .build();
        }*/
      return response;
    }
}
