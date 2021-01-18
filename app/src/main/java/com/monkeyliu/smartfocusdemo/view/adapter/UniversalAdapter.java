package com.monkeyliu.smartfocusdemo.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.monkeyliu.smartfocusdemo.retrofit.Constans;
import com.monkeyliu.smartfocusdemo.view.holder.BindingViewHolder;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ***********************
 * 项目名称：SmartFocus
 *
 * @Author atai
 * 创建时间：2021/1/2  15:24
 * 用途 通用 recycle View Adapter
 * ***********************
 */
public class UniversalAdapter<T> extends RecyclerView.Adapter<BindingViewHolder> {
    private static final int ITEM_TYPE_ON = 1;
    private static final int ITEM_TYPE_YES = 2;
    private List<T> list;
    private Map<Integer, Integer> hashMap;
    private OnItemClickListener  mListener;


    public interface OnItemClickListener<T> {
        void onClick(T t);
    }

    public UniversalAdapter(List<T> list,  Map<Integer, Integer> hashMap) {
        this.list = list;
        this.hashMap = hashMap;
    }

    /**
     * map可以入参多个，也就是添加多布局，至少需要传一个，map中的key代表布局id,value对应布局中实体类的BR id
     *默认取第一个，也就是把布局id取出来
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        Set<Integer> integers = hashMap.keySet();
        return integers.iterator().next();
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        ViewDataBinding inflate = DataBindingUtil.inflate(from, viewType, parent, false);//引入布局
        return new BindingViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
            final T t = list.get(position);
            holder.getDataBinding().setVariable(BR._all,t);
            holder.getDataBinding().executePendingBindings();
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(t);
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public void addList(List<T> t){
        list.addAll(t);
    }

}
