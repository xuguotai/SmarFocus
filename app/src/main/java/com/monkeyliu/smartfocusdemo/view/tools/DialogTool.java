package com.monkeyliu.smartfocusdemo.view.tools;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.monkeyliu.smartfocusdemo.R;

public class DialogTool {
    public static final int DEFAULT_ICON = -2;
    public static final int NO_ICON = -1;

    public static Dialog createMessageDialog(Context context, String title, String message, String btnName, DialogInterface.OnClickListener listener, int iconId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (iconId == -2) {
            builder.setIcon(R.mipmap.dialog_icon);
        } else if (iconId != -1) {
            builder.setIcon(iconId);
        }
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(btnName, listener);
        builder.setInverseBackgroundForced(false);
        Dialog dialog = builder.create();
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog createConfirmDialog(Context context, String title, String message, String positiveBtnName, String negativeBtnName, DialogInterface.OnClickListener positiveBtnListener, DialogInterface.OnClickListener negativeBtnListener, int iconId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (iconId == -2) {
            builder.setIcon(R.mipmap.dialog_icon);
        } else if (iconId != -1) {
            builder.setIcon(iconId);
        }
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveBtnName, positiveBtnListener);
        builder.setNegativeButton(negativeBtnName, negativeBtnListener);
        Dialog dialog = builder.create();
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog createSingleChoiceDialog(Context context, String title, String[] itemsString, String positiveBtnName, String negativeBtnName, DialogInterface.OnClickListener positiveBtnListener, DialogInterface.OnClickListener negativeBtnListener, DialogInterface.OnClickListener itemClickListener, int iconId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (iconId == -2) {
            builder.setIcon(R.mipmap.dialog_icon);
        } else if (iconId != -1) {
            builder.setIcon(iconId);
        }
        builder.setTitle(title);
        builder.setSingleChoiceItems(itemsString, 0, itemClickListener);
        builder.setPositiveButton(positiveBtnName, positiveBtnListener);
        builder.setNegativeButton(negativeBtnName, negativeBtnListener);
        return builder.create();
    }

    public static Dialog createMultiChoiceDialog(Context context, String title, String[] itemsString, String positiveBtnName, String negativeBtnName, DialogInterface.OnClickListener positiveBtnListener, DialogInterface.OnClickListener negativeBtnListener, DialogInterface.OnMultiChoiceClickListener itemClickListener, int iconId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (iconId == -2) {
            builder.setIcon(R.mipmap.dialog_icon);
        } else if (iconId != -1) {
            builder.setIcon(iconId);
        }
        builder.setTitle(title);
        builder.setMultiChoiceItems(itemsString, (boolean[]) null, itemClickListener);
        builder.setPositiveButton(positiveBtnName, positiveBtnListener);
        builder.setNegativeButton(negativeBtnName, negativeBtnListener);
        Dialog dialog = builder.create();
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog createListDialog(Context context, String title, String[] itemsString, String negativeBtnName, DialogInterface.OnClickListener negativeBtnListener, DialogInterface.OnClickListener itemClickListener, int iconId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (iconId == -2) {
            builder.setIcon(R.mipmap.dialog_icon);
        } else if (iconId != -1) {
            builder.setIcon(iconId);
        }
        builder.setTitle(title);
        builder.setItems(itemsString, itemClickListener);
        builder.setNegativeButton(negativeBtnName, negativeBtnListener);
        Dialog dialog = builder.create();
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog createRandomDialog(Context context, String title, String positiveBtnName, String negativeBtnName, DialogInterface.OnClickListener positiveBtnListener, DialogInterface.OnClickListener negativeBtnListener, View view, int iconId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (iconId == -2) {
            builder.setIcon(R.mipmap.dialog_icon);
        } else if (iconId != -1) {
            builder.setIcon(iconId);
        }
        builder.setTitle(title);
        builder.setView(view);
        builder.setPositiveButton(positiveBtnName, positiveBtnListener);
        builder.setNegativeButton(negativeBtnName, negativeBtnListener);
        Dialog dialog = builder.create();
        dialog.setCancelable(false);
        return dialog;
    }

    @TargetApi(11)
    public static Dialog createRandomDialog(Context context, View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, 3);
        builder.setView(view);
        return builder.create();
    }
}
