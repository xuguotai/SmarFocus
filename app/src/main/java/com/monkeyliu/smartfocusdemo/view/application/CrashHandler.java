package com.monkeyliu.smartfocusdemo.view.application;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

import com.monkeyliu.smartfocusdemo.view.util.SdcardConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 *错误日志
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static CrashHandler INSTANCE = new CrashHandler();
    //public static final String TAG = "CrashHandler";
    private static final String TAG = CrashHandler.class.getName();
    /* access modifiers changed from: private */
    public Context context;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    /**
     * 日期格式器
     */
    private DateFormat mFormatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");


    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    public void init(Context context2) {
        this.context = context2;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable ex) {
        if (handleException(ex) || this.mDefaultHandler == null) {
            Process.killProcess(Process.myPid());
            System.exit(1);
            return;
        }
        this.mDefaultHandler.uncaughtException(thread, ex);
    }

    private boolean handleException(final Throwable ex) {
        if (ex == null) {
            return false;
        }
        String crashReport = getCrashReport(ex);
       /* ErrorReqVO errorReqVO = new ErrorReqVO();
        errorReqVO.setErrorMsg(crashReport);
        AppExecutors.getInstance().networkIO().execute(new Runnable() {
            @Override
            public void run() {
                Log.i("1111111","http://192.168.1.170:8082"+ com.YouYa.TransactionManagement.zhyh.Constants.appLogs);
                HTTPAPKCommunicate httpapkCommunicate = new HTTPAPKCommunicate("http://192.168.1.170:8082"+ com.YouYa.TransactionManagement.zhyh.Constants.appLogs,"post");
                httpapkCommunicate.getResponseVO(errorReqVO);
                ActivitysManager.getInstance().exit(false);
            }
        });*/
        // 保存到sd卡
        saveExceptionToSdcard(crashReport);
        return true;
    }

    /**
     * 获取异常信息
     * @param ex
     * @return
     */
    private String getCrashReport(Throwable ex) {
        StringBuffer exceptionStr = new StringBuffer();
            if (ex != null) {
                //手机系统信息
                exceptionStr.append("OS Version：" + Build.VERSION.RELEASE);
                exceptionStr.append("_");
                exceptionStr.append(Build.VERSION.SDK_INT + "\n");
                //手机制造商
                exceptionStr.append("Vendor: " + Build.MANUFACTURER+ "\n");
                //手机型号
                exceptionStr.append("Model: " + Build.MODEL+ "\n");
                String errorStr = ex.getLocalizedMessage();
                if (TextUtils.isEmpty(errorStr)) {
                    errorStr = ex.getMessage();
                }
                if (TextUtils.isEmpty(errorStr)) {
                    errorStr = ex.toString();
                }
                exceptionStr.append("Exception: " + errorStr + "\n");
                StackTraceElement[] elements = ex.getStackTrace();
                if (elements != null) {
                    for (int i = 0; i < elements.length; i++) {
                        exceptionStr.append(elements[i].toString() + "\n");
                    }
                }
            } else {
                exceptionStr.append("no exception. Throwable is null\n");
            }
            return exceptionStr.toString();
        }


    /**
     * 保存错误报告到sd卡
     * @param errorReason
     */
    private void saveExceptionToSdcard(String errorReason) {
        try {
            String time = mFormatter.format(new Date());
            String fileName = "Crash-" + time + ".log";
            if (SdcardConfig.getInstance().hasSDCard()) {
                String path = SdcardConfig.LOG_FOLDER;
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(path + fileName);
                fos.write(errorReason.getBytes());
                fos.close();
            }
        } catch (Exception e) {
            Log.e("CrashDemo", "an error occured while writing file..." + e.getMessage());
        }
    }

}
