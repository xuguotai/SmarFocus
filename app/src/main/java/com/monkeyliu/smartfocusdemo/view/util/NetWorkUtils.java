package com.monkeyliu.smartfocusdemo.view.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.monkeyliu.smartfocusdemo.retrofit.Constans;

import okhttp3.Request;

/**
 * ***********************
 * 项目名称：SmartFocus
 *
 * @Author atai
 * 创建时间：2020/12/16  16:51
 * 用途 网络工具类
 * ***********************
 */
public class NetWorkUtils {


    /**
     *@Author
     *@Time 2020/12/16 16:56
     *@Description 判断网络是否连接
     */
    public static boolean isNetWorkAvailable(Context context) {

        //网络连接管理器
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //网络信息
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null) {
            return true;
        }
        return false;

    }

    /**
     *@Author
     *@Time 2020/12/16 16:57
     *@Description 判断是否是wifi
     */
    public static boolean isWifi(Context context) {
        //网络连接管理器
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //网络信息
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.getType() == connectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

    /**
    *@Author
    *@Time 2020/12/16 16:59
    *@Description 判断是否是手机流量
    */
    public static boolean isMobile(Context context) {
        //网络连接管理器
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //网络信息
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.getType() == connectivityManager.TYPE_MOBILE) {
            return true;
        }
        return false;

    }

    /**
    *@Author
    *@Time 2020/12/17 10:47
    *@Description  判断那些接口不需要Token验证
    */
    public static boolean needAddToken(Request request) {
        if (request.url().toString().equals(Constans.BaseUrl)){
            return false;
        }
        return true;
    }
}
