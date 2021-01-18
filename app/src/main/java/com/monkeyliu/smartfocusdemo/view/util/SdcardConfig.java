package com.monkeyliu.smartfocusdemo.view.util;

import android.os.Environment;

import java.io.File;

/**
*@Author atai
*@Time 2020/12/10 16:21
*@Description 错误日志
*/
public class SdcardConfig {
    /**
     * sdcard
     */
    public static final String SDCARD_FOLDER = Environment.getExternalStorageDirectory().toString();

    /**
     * 错误根目录
     */
    public static final String ROOT_FOLDER = SDCARD_FOLDER + "/ErrorLog/";

    /**
     * 日志目录
     */
    public static final String LOG_FOLDER = ROOT_FOLDER + "log/";

    private static SdcardConfig sSdcardConfig;

    public static synchronized SdcardConfig getInstance() {
        if (sSdcardConfig == null) {
            sSdcardConfig = new SdcardConfig();
        }
        return sSdcardConfig;
    }

    /**
     * sd卡初始化
     */
    public void initSdcard() {
        if (!hasSDCard())
            return;
        File logFile = new File(LOG_FOLDER);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }
    }

    /**
     * 判断是否存在SDCard
     *
     * @return
     */
    public boolean hasSDCard() {
        String status = Environment.getExternalStorageState();
        return status.equals(Environment.MEDIA_MOUNTED);
    }

}
