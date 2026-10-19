package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class TextSwitchView extends TextSwitcher implements ViewSwitcher.ViewFactory {
    private Context mContext;

    public TextSwitchView(Context context) {
        this(context, null);
    }

    public TextSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        setFactory(this);
        setInAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.in_animation));
        setOutAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.out_animation));
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        return new TextView(this.mContext);
    }
}
