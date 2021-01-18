package com.monkeyliu.smartfocusdemo.view.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.trello.rxlifecycle2.components.RxFragment;

/**
 * ***********************
 * 项目名称：SmartFocus
 *
 * @Author atai
 * 创建时间：2020/12/25  9:52
 * 用途
 * ***********************
 */
public abstract class BaseFragment<T extends ViewDataBinding> extends RxFragment  {

    private T mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,setLayout(), container, false);
        View view = mBinding.getRoot();

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public abstract int setLayout();

    //数据加载
    protected abstract void initData();

    //事件监听
    protected abstract void initEvent();

    /**
     * [防止快速点击]
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }
}
