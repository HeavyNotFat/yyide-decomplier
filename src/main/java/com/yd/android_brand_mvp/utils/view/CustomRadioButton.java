package com.yd.android_brand_mvp.utils.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* JADX INFO: loaded from: classes4.dex */
public class CustomRadioButton extends RadioButton {
    public CustomRadioButton(Context context) {
        super(context);
    }

    public CustomRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = getCompoundDrawables()[0];
        int width = getGravity() == 17 ? (int) ((getWidth() / 2) - getPaint().measureText(getText().toString())) : 0;
        if (drawable != null) {
            drawable.setBounds(width, 0, drawable.getIntrinsicWidth() + width, drawable.getIntrinsicHeight());
        }
    }
}
