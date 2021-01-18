package com.monkeyliu.smartfocusdemo.retrofit.bean;

/**
*@Author atai
*@Time 2020/12/14 9:49
*@Description
*/
public class User {

    private String id;
    private String name;
    private String agar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgar() {
        return agar;
    }

    public void setAgar(String agar) {
        this.agar = agar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", agar='" + agar + '\'' +
                '}';
    }
}
