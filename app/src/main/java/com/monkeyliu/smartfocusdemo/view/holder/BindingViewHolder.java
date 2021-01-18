package com.monkeyliu.smartfocusdemo.view.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

/**
 * ***********************
 * 项目名称：SmartFocus
 *
 * @Author atai
 * 创建时间：2021/1/2  14:45
 * 用途 通用
 * ***********************
 */
public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{

    private T dataBinding;

    public BindingViewHolder(@NonNull T binding) {
        super(binding.getRoot());
        this.dataBinding = binding;
    }

    public T getDataBinding() {
        return dataBinding;
    }
}
