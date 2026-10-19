package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes4.dex */
public class RoundImageView extends ImageView {
    private final Paint maskPaint;
    private float rect_adius;
    private final RectF roundRect;
    private final Paint zonePaint;

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.roundRect = new RectF();
        this.rect_adius = 6.0f;
        this.maskPaint = new Paint();
        this.zonePaint = new Paint();
        init();
    }

    public RoundImageView(Context context) {
        super(context);
        this.roundRect = new RectF();
        this.rect_adius = 6.0f;
        this.maskPaint = new Paint();
        this.zonePaint = new Paint();
        init();
    }

    private void init() {
        this.maskPaint.setAntiAlias(true);
        this.maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.zonePaint.setAntiAlias(true);
        this.zonePaint.setColor(-1);
        this.rect_adius *= getResources().getDisplayMetrics().density;
    }

    public void setRectAdius(float f) {
        this.rect_adius = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.roundRect.set(0.0f, 0.0f, getWidth(), getHeight() + this.rect_adius);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.roundRect, this.zonePaint, 31);
        RectF rectF = this.roundRect;
        float f = this.rect_adius;
        canvas.drawRoundRect(rectF, f, f, this.zonePaint);
        canvas.saveLayer(this.roundRect, this.maskPaint, 31);
        super.draw(canvas);
        canvas.restore();
    }
}
