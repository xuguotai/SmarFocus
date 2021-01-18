package com.monkeyliu.smartfocusdemo.view.activity;


import android.graphics.Color;

import com.monkeyliu.smartfocus.ColorFocusBorder;
import com.monkeyliu.smartfocusdemo.R;
import com.monkeyliu.smartfocusdemo.databinding.ActivityFocusBinding;
import com.monkeyliu.smartfocusdemo.model.User;
import com.monkeyliu.smartfocusdemo.modelview.MainEvent;
import com.monkeyliu.smartfocusdemo.retrofit.Constans;
import com.monkeyliu.smartfocusdemo.retrofit.Utils.BaseCallBack;
import com.monkeyliu.smartfocusdemo.retrofit.Utils.RetrofitUtils;
import com.monkeyliu.smartfocusdemo.retrofit.bean.Demo;
import com.monkeyliu.smartfocusdemo.view.base.BaseActivity;

/**
 * @author atai
 * @date 2019-06-23
 * 引导
 */
public class FocusDemoActivity extends BaseActivity<ActivityFocusBinding> {

    @Override
    public int setLayout() {
        return R.layout.activity_focus;
    }

    @Override
    protected void initData() {
        User user = new User();
        user.setName("Kot");
        binding.setUserInfo(user);
        MainEvent person = new MainEvent(this);
        binding.setPerson(person);

    }

    @Override
    protected void initEvent() {
        //自定义焦点框的效果
        binding.focusFramelayout.setFocusBorderBuilder(new ColorFocusBorder.Builder(this)
                .borderWidth(4) //border宽度
                .borderColor(Color.RED) //border颜色
                .borderRadius(2) //border圆角半径
                .shadowWidth(10) //shadow半径
                .shadowColor(Color.RED) //shadow颜色
                .padding(3) //内边距
                .scaleX(1.1f) //X方向缩放倍数
                .scaleY(1.1f) //Y方向缩放倍数
                .enableShimmer()); //使用闪光特效

        RetrofitUtils.getApiUrl(Constans.BaseUrl).getRetrofit().enqueue(new BaseCallBack<Demo>() {
            @Override
            public void onSuccess(Demo result) {

            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {

            }
        });
    }


}
