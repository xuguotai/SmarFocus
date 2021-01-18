package com.monkeyliu.smartfocusdemo.view.util;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferenceUtils {
    private SharedPreferences sharedPreferences;

    public SharedPreferenceUtils(Context ctx) {
        this.sharedPreferences = ctx.getSharedPreferences("frameworkSharedPreferences", 0);
    }

    public String getPinsCode() {
        return this.sharedPreferences.getString("ActiveCode", (String) null);
    }

    public void setPinsCode(String activeCode) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString("ActiveCode", activeCode);
        editor.commit();
    }

    public void deletePinsCode() {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.remove("ActiveCode");
        editor.commit();
    }



    public boolean isFirstLoad() {
        return this.sharedPreferences.getBoolean("isFirstLoad", true);
    }

    public void setFistLoad(boolean isFirstLoad) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putBoolean("isFirstLoad", isFirstLoad);
        editor.commit();
    }


    public int getWelcomeADIndex() {
        return this.sharedPreferences.getInt("welcomeADIndex", 0);
    }

    public void setWelcomeADIndex(int welcomeADIndex) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putInt("welcomeADIndex", welcomeADIndex);
        editor.commit();
    }




    public String getZHMarketInfo() {
        return this.sharedPreferences.getString("zhmarketinfo", "");
    }

    public void setZHMarketInfo(String marketJson) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString("zhmarketinfo", marketJson);
        editor.commit();
    }

    public void clearMarketInfo() {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.remove("marketinfo");
        editor.commit();
    }

    public void clearMemberInfo() {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.remove("memberinfo");
        editor.commit();
    }



    public void setHomeGuide(boolean flag) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putBoolean("home_guide", flag);
        editor.commit();
    }

    public boolean getHomeGuide() {
        return this.sharedPreferences.getBoolean("home_guide", true);
    }


    public void setMarketUpdateTime(long time) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putLong("MARKET_UPDATE_TIME", time);
        editor.commit();
    }

    public long getMarketUpdateTime() {
        return this.sharedPreferences.getLong("MARKET_UPDATE_TIME", 0);
    }
}
