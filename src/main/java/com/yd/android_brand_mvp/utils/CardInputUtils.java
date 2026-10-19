package com.yd.android_brand_mvp.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class CardInputUtils implements View.OnKeyListener, DialogInterface.OnKeyListener {
    private static StringBuffer mCardNumBuff = new StringBuffer();
    private String cardNum;
    private Dialog mDialog;
    private View mView;

    public String getCardNum() {
        return this.cardNum;
    }

    public CardInputUtils(View view) {
        this.mView = view;
        view.setOnKeyListener(this);
    }

    public CardInputUtils(Dialog dialog) {
        this.mDialog = dialog;
        dialog.setOnKeyListener(this);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        Boolean bool = getaBoolean(i, keyEvent);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Boolean bool = getaBoolean(i, keyEvent);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private Boolean getaBoolean(int i, KeyEvent keyEvent) {
        if (i == 66 || i == 160) {
            return true;
        }
        if ((i >= 7 && i <= 16) || (i >= 144 && i <= 153)) {
            if (keyEvent.getAction() == 1) {
                mCardNumBuff.append(i - 7);
                if (mCardNumBuff.length() == 10) {
                    this.cardNum = mCardNumBuff.toString();
                    mCardNumBuff = null;
                    mCardNumBuff = new StringBuffer();
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static String cleanCardZero(String str) {
        return cleanZero(0, str);
    }

    public static String cleanZero(int i, String str) {
        return (str.length() == 1 || !"0".equals(str.substring(0, 1))) ? str : cleanZero(i + 1, str.substring(1));
    }
}
