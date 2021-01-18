package com.monkeyliu.smartfocusdemo.view.manager;

import android.app.Activity;
import android.content.DialogInterface;

import com.monkeyliu.smartfocusdemo.R;
import com.monkeyliu.smartfocusdemo.view.base.BaseActivity;
import com.monkeyliu.smartfocusdemo.view.tools.DialogTool;
import com.monkeyliu.smartfocusdemo.view.util.LogUtils;

import java.util.Iterator;
import java.util.Stack;

/**
 * ***********************
 * 项目名称：SmartFocus
 *
 * @Author atai
 * 创建时间：2020/12/23  9:32
 * 用途
 * ***********************
 */
public class ActivityManager {
    private static Stack<BaseActivity> activityStack;
    private static ActivityManager instance;
    private boolean stop = true;
    private String tag = getClass().getName();

    private ActivityManager() {
    }

    public static ActivityManager getInstance() {
        if (instance == null) {
            synchronized (ActivityManager.class) {
                if (instance == null) {
                    instance = new ActivityManager();
                }
            }
        }
        return instance;
    }

    public void addActivity(BaseActivity activity) {
        if (activityStack == null) {
            activityStack = new Stack();
        }
        LogUtils.d("add activity:" + activity.toString());
        activityStack.push(activity);
    }

    public void removeActivity(Activity activity) {
        LogUtils.d( "remove  activity:" + activity.toString());
        if (getActivityStack().size() == 1) {
            getInstance().exit(false);
        } else {
            activityStack.remove(activity);
        }
    }


    public static Stack<BaseActivity> getActivityStack() {
        return activityStack;
    }

    public static BaseActivity getActivity(String className) {
        if (activityStack == null) {
            return null;
        }
        Iterator<BaseActivity> iterator = activityStack.iterator();
        while (iterator.hasNext()) {
            BaseActivity baseActivity = (BaseActivity) iterator.next();
            if (baseActivity.getClass().getName().equals(className)) {
                return baseActivity;
            }
        }
        return null;
    }

    public void exit(boolean isDisplayDialog) {
        if (activityStack != null && activityStack.size() != 0) {
            final Activity context = (Activity) activityStack.lastElement();
            if (context == null) {
                return;
            }
            if (isDisplayDialog) {
                try {
                    DialogTool.createConfirmDialog(context, context.getString(R.string.confirmDialogTitle), context.getString(R.string.exitMessage), context.getString(R.string.confirmDialogPositiveBtnName), context.getString(R.string.confirmDialogNegativeBtnName), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityManager.this.exit(context);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }, -1).show();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            exit(context);
        }
    }

    private void exit(final Activity context) {
        while (!activityStack.empty()) {
            Activity activity = (Activity) activityStack.pop();
            LogUtils.d("finish activity:" + activity.toString());
            activity.finish();
        }
        this.stop = true;
    }

    public boolean getStop() {
        return this.stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
