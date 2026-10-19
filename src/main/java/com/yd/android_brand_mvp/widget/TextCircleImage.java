package com.yd.android_brand_mvp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class TextCircleImage extends AppCompatImageView {
    private int mCenterX;
    private int mCenterY;
    private int mCircleColor;
    private int mCircleTextColor;
    private Context mContext;
    private Paint.FontMetrics mFontMetrics;
    private Paint mPaint;
    private Paint mPaintTextBackground;
    private Paint mPaintTextForeground;
    private int mRadius;
    private boolean mSubFirstCharacter;
    private String mText;
    private boolean mUseRandomBackgroundColor;
    private float textSizeRatio;

    public TextCircleImage(Context context) {
        super(context);
        this.mCircleColor = SupportMenu.CATEGORY_MASK;
        this.mCircleTextColor = -1;
        this.mUseRandomBackgroundColor = false;
        this.mSubFirstCharacter = false;
        this.mPaint = new Paint(1);
        this.textSizeRatio = SizeUtils.sp2px(10.0f);
        init();
    }

    public TextCircleImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCircleColor = SupportMenu.CATEGORY_MASK;
        this.mCircleTextColor = -1;
        this.mUseRandomBackgroundColor = false;
        this.mSubFirstCharacter = false;
        this.mPaint = new Paint(1);
        this.textSizeRatio = SizeUtils.sp2px(10.0f);
        initAttr(context, attributeSet);
        init();
    }

    public TextCircleImage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCircleColor = SupportMenu.CATEGORY_MASK;
        this.mCircleTextColor = -1;
        this.mUseRandomBackgroundColor = false;
        this.mSubFirstCharacter = false;
        this.mPaint = new Paint(1);
        this.textSizeRatio = SizeUtils.sp2px(10.0f);
        initAttr(context, attributeSet);
        init();
    }

    private void initAttr(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextCircleImage);
        this.mCircleColor = typedArrayObtainStyledAttributes.getColor(0, -16711936);
        this.mCircleTextColor = typedArrayObtainStyledAttributes.getColor(1, -1);
        this.mUseRandomBackgroundColor = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.mSubFirstCharacter = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.textSizeRatio = typedArrayObtainStyledAttributes.getDimension(4, SizeUtils.sp2px(10.0f));
        this.mContext = context;
        typedArrayObtainStyledAttributes.recycle();
    }

    private void init() {
        this.mPaint.setAntiAlias(true);
        Paint paint = new Paint();
        this.mPaintTextForeground = paint;
        paint.setColor(this.mCircleTextColor);
        this.mPaintTextForeground.setAntiAlias(true);
        this.mPaintTextForeground.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint();
        this.mPaintTextBackground = paint2;
        paint2.setColor(this.mCircleTextColor);
        this.mPaintTextBackground.setAntiAlias(true);
        this.mPaintTextBackground.setStyle(Paint.Style.FILL);
        if (this.mUseRandomBackgroundColor) {
            this.mPaint.setColor(ContextCompat.getColor(getContext(), R.color.white));
        } else {
            this.mPaint.setColor(this.mCircleColor);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        String str = this.mText;
        if (str == null || str.trim().equals("")) {
            if (mode != 1073741824) {
                size = mode == Integer.MIN_VALUE ? Math.min(200, size) : 200;
            }
            if (mode2 != 1073741824) {
                size2 = mode2 == Integer.MIN_VALUE ? Math.min(200, size2) : 200;
            }
        } else {
            this.mPaintTextForeground.setTextSize(this.textSizeRatio);
            Paint paint = this.mPaintTextForeground;
            String str2 = this.mText;
            int iMeasureText = ((int) paint.measureText(str2, 0, str2.length())) + 60;
            int i3 = iMeasureText >= 200 ? iMeasureText : 200;
            if (mode != 1073741824) {
                size = i3;
            }
            if (mode2 != 1073741824) {
                size2 = i3;
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        int iMin = Math.min(width, height) / 2;
        String str = this.mText;
        if (str != null && !str.trim().equals("")) {
            drawText(canvas);
        } else {
            canvas.drawCircle(width / 2, height / 2, iMin, this.mPaint);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = (i - paddingLeft) - getPaddingRight();
        int paddingBottom = (i2 - paddingTop) - getPaddingBottom();
        int i5 = paddingRight < paddingBottom ? paddingRight / 2 : paddingBottom / 2;
        this.mRadius = i5;
        this.mCenterX = paddingLeft + i5;
        this.mCenterY = paddingTop + i5;
        refreshTextSizeConfig();
    }

    private void drawText(Canvas canvas) {
        this.mPaintTextBackground.setColor(this.mCircleTextColor);
        canvas.drawCircle(this.mCenterX, this.mCenterY, this.mRadius, this.mPaint);
        String str = this.mText;
        canvas.drawText(str, 0, str.length(), this.mCenterX, this.mCenterY + (Math.abs(this.mFontMetrics.top + this.mFontMetrics.bottom) / 2.0f), this.mPaintTextForeground);
    }

    private void refreshTextSizeConfig() {
        this.mPaintTextForeground.setTextSize(this.textSizeRatio);
        this.mFontMetrics = this.mPaintTextForeground.getFontMetrics();
    }

    public void setText4CircleImage(String str) {
        if (str.isEmpty()) {
            return;
        }
        if (this.mSubFirstCharacter) {
            this.mText = str.substring(0, 1);
        } else {
            this.mText = str;
        }
        invalidate();
    }

    public void setTextBackGround(int i) {
        this.mCircleColor = i;
        invalidate();
    }
}
