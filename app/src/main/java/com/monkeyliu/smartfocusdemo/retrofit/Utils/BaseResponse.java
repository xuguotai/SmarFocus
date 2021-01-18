package com.monkeyliu.smartfocusdemo.retrofit.Utils;

/**
 * 统一响应
 * @param <T>
 */
public class BaseResponse<T> {
    private int res_code;
    private String err_msg;
    private T data;
    public int getRes_code() {
        return res_code;
    }
    public void setRes_code(int res_code) {
        this.res_code = res_code;
    }
    public String getErr_msg() {
        return err_msg;
    }
    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
