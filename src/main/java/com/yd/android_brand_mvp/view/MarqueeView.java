package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes4.dex */
public class MarqueeView extends AppCompatTextView {
    private static final String TAG = "MarqueeView";

    public MarqueeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(true);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    private void init() {
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setMarqueeRepeatLimit(-1);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void setMarqueeSpeed(float f) {
        try {
            Field declaredField = Class.forName("android.widget.TextView").getDeclaredField("mMarquee");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            if (obj == null) {
                return;
            }
            Field declaredField2 = obj.getClass().getDeclaredField("mPixelsPerSecond");
            declaredField2.setAccessible(true);
            float fFloatValue = ((Float) declaredField2.get(obj)).floatValue();
            declaredField2.set(obj, Float.valueOf(f));
            Log.i(TAG, "setMarqueeSpeed: " + fFloatValue);
            Log.i(TAG, "setMarqueeSpeed: " + f);
        } catch (ClassNotFoundException e) {
            e = e;
            Log.e(TAG, "setMarqueeSpeed: 设置跑马灯速度失败", e);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e = e3;
            Log.e(TAG, "setMarqueeSpeed: 设置跑马灯速度失败", e);
        }
    }
}
