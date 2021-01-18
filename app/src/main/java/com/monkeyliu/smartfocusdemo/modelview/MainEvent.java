package com.monkeyliu.smartfocusdemo.modelview;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.monkeyliu.smartfocusdemo.model.User;

public class MainEvent {
    public Context mContext;
    public MainEvent(Context context) {
        this.mContext = context;
    }

    public void onClick(View view){
        Toast.makeText(mContext, "user.getName()", Toast.LENGTH_SHORT).show();
    }
    public void onClickBinding(User user){
        Toast.makeText(mContext, user.getName(), Toast.LENGTH_SHORT).show();
    }
}
