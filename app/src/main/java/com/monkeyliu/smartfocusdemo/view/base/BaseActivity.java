package com.monkeyliu.smartfocusdemo.view.base;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.monkeyliu.smartfocusdemo.databinding.ActivityFocusBinding;
import com.monkeyliu.smartfocusdemo.view.manager.ActivityManager;
import com.monkeyliu.smartfocusdemo.view.util.StatusBarUtil;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

/**
 * ***********************
 * 项目名称：SmartFocus
 *
 * @Author atai
 * 创建时间：2020/12/23  9:29
 * 用途
 * ***********************
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends RxFragmentActivity {
    private int layout;

    /** 是否允许全屏 **/
    private boolean mAllowFullScreen = false;
    /** 是否禁止旋转屏幕 **/
    private boolean isAllowScreenRoate = true;
    public T binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        if (mAllowFullScreen) {
            this.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        binding = DataBindingUtil.setContentView(this, setLayout());
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this,true);
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this, Color.RED);
        }
        if (!isAllowScreenRoate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        initData();
        initEvent();
    }

    public void onBackPressed() {
        if (ActivityManager.getActivityStack().size() == 1) {
            ActivityManager.getInstance().exit(true);
        } else {
            super.onBackPressed();
        }
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
