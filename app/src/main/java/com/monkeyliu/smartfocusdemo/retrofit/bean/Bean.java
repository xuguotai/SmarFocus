package com.monkeyliu.smartfocusdemo.retrofit.bean;

/**
 * {
 *     "res_code": 200,
 *     "err_msg": "Web page does not exist",
 *     "data": {
 *         "id": "1001",
 *         "appid": "1021",
 *         "name": "sss",
 *         "showtype": "text"
 *     }
 * }
 */
public class Bean<T> {

    private int res_code;
    private int err_code;
    private String err_msg;
    private T data;

    public int getRes_code() {
        return res_code;
    }

    public void setRes_code(int res_code) {
        this.res_code = res_code;
    }

    public int getErr_code() {
        return err_code;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
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
