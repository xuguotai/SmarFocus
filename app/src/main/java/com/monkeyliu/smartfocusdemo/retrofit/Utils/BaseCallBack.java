package com.monkeyliu.smartfocusdemo.retrofit.Utils;

import com.monkeyliu.smartfocusdemo.retrofit.bean.Bean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ***********************
 * 项目名称：SmartFocus
 *
 * @Author atai
 * 创建时间：2020/12/17  9:56
 * 用途
 * ***********************
 */
public abstract class BaseCallBack<T> implements Callback<Bean> {


    @Override
    public void onResponse(Call<Bean> call, Response<Bean> response) {
       if (response.body().getRes_code()==200){
           onSuccess((T) response.body().getData());
       }else{
           onFailure(null,response.body().getErr_msg());
       }
    }

    @Override
    public void onFailure(Call<Bean> call, Throwable t) {
        onFailure(t, RxExceptionUtil.exceptionHandler(t));
    }
    public abstract void onSuccess(T result);

    public abstract void onFailure(Throwable e,String errorMsg);
}
