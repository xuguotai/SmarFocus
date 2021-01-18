package com.monkeyliu.smartfocusdemo.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.monkeyliu.smartfocusdemo.R;
import com.monkeyliu.smartfocusdemo.databinding.ActivityStartPageBinding;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * ***********************
 * 项目名称：SmartFocus
 *
 * @Author atai
 * 创建时间：2020/12/16 12:01
 * 用途 启动页
 * ***********************
 */
public class StartPageActivity extends RxAppCompatActivity {
    private ActivityStartPageBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_start_page);
    }
}
