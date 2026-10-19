package com.yd.android_brand_mvp.utils.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.yd.android_brand_mvp.R;
import com.youth.banner.indicator.BaseIndicator;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class CircleIndicator extends BaseIndicator {
    Context context;
    private int mNormalRadius;
    private int mSelectedRadius;
    private int maxRadius;

    public CircleIndicator(Context context) {
        this(context, null);
        this.context = context;
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNormalRadius = this.config.getNormalWidth() / 2;
        this.mSelectedRadius = this.config.getSelectedWidth() / 2;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        this.mNormalRadius = this.config.getNormalWidth() / 2;
        int selectedWidth = this.config.getSelectedWidth() / 2;
        this.mSelectedRadius = selectedWidth;
        this.maxRadius = Math.max(selectedWidth, this.mNormalRadius);
        int i3 = indicatorSize - 1;
        setMeasuredDimension((this.config.getIndicatorSpace() * i3) + this.config.getSelectedWidth() + (this.config.getNormalWidth() * i3), Math.max(this.config.getNormalWidth(), this.config.getSelectedWidth()));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        SkinCompatResources skinCompatResources;
        int i;
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        float indicatorSpace = 0.0f;
        if (this.context != null) {
            int i2 = 0;
            while (i2 < indicatorSize) {
                Paint paint = this.mPaint;
                if (this.config.getCurrentPosition() == i2) {
                    skinCompatResources = SkinCompatResources.getInstance();
                    i = R.color.white;
                } else {
                    skinCompatResources = SkinCompatResources.getInstance();
                    i = R.color.purple2;
                }
                paint.setColor(skinCompatResources.getColor(i));
                int selectedWidth = this.config.getCurrentPosition() == i2 ? this.config.getSelectedWidth() : this.config.getNormalWidth();
                float f = this.config.getCurrentPosition() == i2 ? this.mSelectedRadius : this.mNormalRadius;
                canvas.drawCircle(indicatorSpace + f, this.maxRadius, f, this.mPaint);
                indicatorSpace += selectedWidth + this.config.getIndicatorSpace();
                i2++;
            }
        }
    }
}
