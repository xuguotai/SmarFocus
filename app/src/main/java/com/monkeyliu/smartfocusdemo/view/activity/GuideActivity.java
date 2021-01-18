package com.monkeyliu.smartfocusdemo.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.monkeyliu.smartfocusdemo.R;
import com.monkeyliu.smartfocusdemo.databinding.ActivityGuideBinding;
import com.monkeyliu.smartfocusdemo.view.base.BaseActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * ***********************
 * 项目名称：SmartFocus
 *
 * @Author atai
 * 创建时间： 2020/12/16 11:59
 * 用途 引导页
 * ***********************
 */
public class GuideActivity extends BaseActivity<ActivityGuideBinding> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setLayout() {
        return  R.layout.activity_guide;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }
}
