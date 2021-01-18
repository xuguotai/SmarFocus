package com.monkeyliu.smartfocusdemo.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * ***********************
 * 项目名称：SmartFocus
 *
 * @Author atai
 * 创建时间：2021/1/2  14:42
 * 用途 通用viewPage adapter
 *
 * ***********************
 */
public class GuideAdapter<D> extends PagerAdapter {
    private List<D> list;
    private int layoutId;
    private int variableId;
    private Pools.Pool<View> pool = new Pools.SimplePool<>(4);

    public GuideAdapter(List<D> list,int layoutId,int variableId){
        this.list = list;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = pool.acquire();
        if (view == null){
            view = DataBindingUtil.inflate(LayoutInflater.from(container.getContext()),layoutId,container,false).getRoot();
        }
        ViewDataBinding dataBinding = DataBindingUtil.bind(view);
        dataBinding.setVariable(variableId,list.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
        pool.release(view);
    }
}
