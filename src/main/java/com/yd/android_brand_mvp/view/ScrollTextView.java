package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class ScrollTextView extends SurfaceView implements SurfaceHolder.Callback {
    private final String TAG;
    private Canvas canvas;
    private boolean clickEnable;
    private int count;
    private long intervalTime;
    public boolean isHorizontal;
    boolean isScrollCount;
    boolean isScrollForever;
    boolean isSetNewText;
    private MarqueeTextCallBack mMarqueeTextCallBack;
    private int needScrollTimes;
    private Paint paint;
    private boolean pauseScroll;
    private ScheduledExecutorService scheduledExecutorService;
    private int speed;
    private boolean stopScroll;
    private SurfaceHolder surfaceHolder;
    private String text;
    private int textBackColor;
    private int textColor;
    private float textSize;
    private float textWidth;
    private float textX;
    private float textY;
    private int viewHeight;
    private int viewWidth;
    private float viewWidth_plus_textLength;

    public interface MarqueeTextCallBack {
        void end();
    }

    static /* synthetic */ int access$1006(ScrollTextView scrollTextView) {
        int i = scrollTextView.needScrollTimes - 1;
        scrollTextView.needScrollTimes = i;
        return i;
    }

    static /* synthetic */ float access$516(ScrollTextView scrollTextView, float f) {
        float f2 = scrollTextView.textX + f;
        scrollTextView.textX = f2;
        return f2;
    }

    public ScrollTextView(Context context) {
        super(context);
        this.TAG = "ScrollTextView";
        this.paint = null;
        this.stopScroll = false;
        this.pauseScroll = false;
        this.clickEnable = false;
        this.isHorizontal = true;
        this.speed = 4;
        this.count = -1;
        this.intervalTime = 0L;
        this.text = "";
        this.textSize = 20.0f;
        this.textBackColor = 0;
        this.needScrollTimes = Integer.MAX_VALUE;
        this.viewWidth = 0;
        this.viewHeight = 0;
        this.textWidth = 0.0f;
        this.textX = 0.0f;
        this.textY = 0.0f;
        this.viewWidth_plus_textLength = 0.0f;
        this.isSetNewText = false;
        this.isScrollForever = true;
        this.isScrollCount = false;
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "ScrollTextView";
        this.paint = null;
        this.stopScroll = false;
        this.pauseScroll = false;
        this.clickEnable = false;
        this.isHorizontal = true;
        this.speed = 4;
        this.count = -1;
        this.intervalTime = 0L;
        this.text = "";
        this.textSize = 20.0f;
        this.textBackColor = 0;
        this.needScrollTimes = Integer.MAX_VALUE;
        this.viewWidth = 0;
        this.viewHeight = 0;
        this.textWidth = 0.0f;
        this.textX = 0.0f;
        this.textY = 0.0f;
        this.viewWidth_plus_textLength = 0.0f;
        this.isSetNewText = false;
        this.isScrollForever = true;
        this.isScrollCount = false;
        SurfaceHolder holder = getHolder();
        this.surfaceHolder = holder;
        holder.addCallback(this);
        this.paint = new Paint();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ScrollTextView);
        this.clickEnable = typedArrayObtainStyledAttributes.getBoolean(0, this.clickEnable);
        this.isHorizontal = typedArrayObtainStyledAttributes.getBoolean(2, this.isHorizontal);
        this.speed = typedArrayObtainStyledAttributes.getInteger(5, this.speed);
        this.count = typedArrayObtainStyledAttributes.getInteger(1, -1);
        this.isScrollCount = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.text = typedArrayObtainStyledAttributes.getString(6);
        this.textColor = typedArrayObtainStyledAttributes.getColor(7, -1);
        this.textSize = typedArrayObtainStyledAttributes.getDimension(8, this.textSize);
        this.needScrollTimes = typedArrayObtainStyledAttributes.getInteger(9, Integer.MAX_VALUE);
        this.isScrollForever = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setFlags(1);
        this.paint.setAntiAlias(true);
        this.paint.setFilterBitmap(true);
        setZOrderOnTop(true);
        getHolder().setFormat(-3);
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int fontHeight = getFontHeight(this.textSize);
        this.viewWidth = View.MeasureSpec.getSize(i);
        this.viewHeight = View.MeasureSpec.getSize(i2);
        if (getLayoutParams().width == -2 && getLayoutParams().height == -2) {
            setMeasuredDimension(this.viewWidth, fontHeight);
            this.viewHeight = fontHeight;
        } else if (getLayoutParams().width == -2) {
            setMeasuredDimension(this.viewWidth, this.viewHeight);
        } else if (getLayoutParams().height == -2) {
            setMeasuredDimension(this.viewWidth, fontHeight);
            this.viewHeight = fontHeight;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Log.d("ScrollTextView", "arg0:" + surfaceHolder.toString() + "  arg1:" + i + "  arg2:" + i2 + "  arg3:" + i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.stopScroll = false;
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.scheduledExecutorService = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new ScrollTextThread(), 100L, 100L, TimeUnit.MILLISECONDS);
        Log.d("ScrollTextView", "ScrollTextTextView is created");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this) {
            this.stopScroll = true;
        }
        this.scheduledExecutorService.shutdownNow();
        Log.d("ScrollTextView", "ScrollTextTextView is destroyed");
    }

    private int getFontHeight(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    public int getBackgroundColor() {
        return this.textBackColor;
    }

    public void setScrollTextBackgroundColor(int i) {
        setBackgroundColor(i);
        this.textBackColor = i;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getText() {
        return this.text;
    }

    public float getTextSize() {
        return px2sp(getContext(), this.textSize);
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTimes(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("times was invalid integer, it must between > 0");
        }
        this.needScrollTimes = i;
        this.isScrollForever = false;
    }

    public void setTextSize(float f) {
        float f2 = this.textSize;
        if (f2 < 20.0f) {
            throw new IllegalArgumentException("textSize must  > 20");
        }
        if (f2 > 900.0f) {
            throw new IllegalArgumentException("textSize must  < 900");
        }
        float fSp2px = sp2px(getContext(), f);
        this.textSize = fSp2px;
        this.paint.setTextSize(fSp2px);
        measureVarious();
        int fontHeight = getFontHeight(f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.viewWidth;
        layoutParams.height = dip2px(getContext(), fontHeight);
        setLayoutParams(layoutParams);
        this.isSetNewText = true;
    }

    private int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void setHorizontal(boolean z) {
        this.isHorizontal = z;
    }

    public void setText(String str) {
        this.isSetNewText = true;
        this.stopScroll = false;
        this.text = str;
        measureVarious();
    }

    public void setTextColor(int i) {
        this.textColor = i;
        this.paint.setColor(i);
    }

    public void setSpeed(int i) {
        if (i > 10 || i < 1) {
            throw new IllegalArgumentException("Speed was invalid integer, it must between 1 and 10");
        }
        this.speed = i;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setIntervalTime(long j) {
        this.intervalTime = j;
    }

    public void setScrollForever(boolean z) {
        this.isScrollForever = z;
    }

    public void setScrollCount(boolean z) {
        this.isScrollCount = z;
    }

    public boolean isPauseScroll() {
        return this.pauseScroll;
    }

    public void setPauseScroll(boolean z) {
        this.pauseScroll = z;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.clickEnable) {
            return true;
        }
        motionEvent.getAction();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawVerticalScroll() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < this.text.length()) {
            while (this.paint.measureText(this.text.substring(i2, i)) < this.viewWidth && i < this.text.length()) {
                i++;
            }
            if (i == this.text.length()) {
                arrayList.add(this.text.substring(i2, i));
                break;
            } else {
                i--;
                arrayList.add(this.text.substring(i2, i));
                i2 = i;
            }
        }
        float f = this.paint.getFontMetrics().bottom - this.paint.getFontMetrics().top;
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        float f2 = (this.viewHeight / 2) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            for (float f3 = this.viewHeight + f; f3 > (-f); f3 -= 3.0f) {
                if (this.stopScroll || this.isSetNewText) {
                    return;
                }
                if (this.pauseScroll) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        Log.e("ScrollTextView", e.toString());
                    }
                } else {
                    try {
                        Canvas canvasLockCanvas = this.surfaceHolder.lockCanvas();
                        this.canvas = canvasLockCanvas;
                        canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        this.canvas.drawText((String) arrayList.get(i3), 0.0f, f3, this.paint);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        this.surfaceHolder.unlockCanvasAndPost(this.canvas);
                        throw th;
                    }
                    this.surfaceHolder.unlockCanvasAndPost(this.canvas);
                    float f4 = f3 - f2;
                    if (f4 < 4.0f && f4 > 0.0f) {
                        if (this.stopScroll) {
                            return;
                        }
                        try {
                            Thread.sleep(((long) this.speed) * 1000);
                        } catch (InterruptedException e2) {
                            Log.e("ScrollTextView", e2.toString());
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void draw(float f, float f2) {
        SurfaceHolder surfaceHolder;
        Canvas canvas;
        try {
            Canvas canvasLockCanvas = this.surfaceHolder.lockCanvas();
            this.canvas = canvasLockCanvas;
            canvasLockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.canvas.drawText(this.text, f, f2, this.paint);
            if (this.isScrollCount && this.count > 0 && ((int) f) == ScreenUtils.getScreenWidth()) {
                this.count--;
                Log.d("ScrollTextView", "count: " + this.count);
                if (this.count == 0 && this.mMarqueeTextCallBack != null) {
                    this.mMarqueeTextCallBack.end();
                }
            }
            if (this.intervalTime > 0 && ((int) f) == ScreenUtils.getScreenWidth()) {
                this.pauseScroll = true;
                try {
                    Thread.sleep(this.intervalTime);
                } catch (InterruptedException e) {
                    Log.e("ScrollTextView", e.toString());
                }
                this.pauseScroll = false;
            }
            surfaceHolder = this.surfaceHolder;
            canvas = this.canvas;
        } catch (Exception unused) {
            surfaceHolder = this.surfaceHolder;
            canvas = this.canvas;
        } catch (Throwable th) {
            this.surfaceHolder.unlockCanvasAndPost(this.canvas);
            throw th;
        }
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void measureVarious() {
        float fMeasureText = this.paint.measureText(this.text);
        this.textWidth = fMeasureText;
        int i = this.viewWidth;
        this.viewWidth_plus_textLength = i + fMeasureText;
        this.textX = i - (i / 5);
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        this.textY = (this.viewHeight / 2) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom);
    }

    class ScrollTextThread implements Runnable {
        ScrollTextThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollTextView.this.measureVarious();
            while (!ScrollTextView.this.stopScroll && ScrollTextView.this.surfaceHolder != null && !Thread.currentThread().isInterrupted()) {
                if (ScrollTextView.this.isHorizontal) {
                    if (ScrollTextView.this.pauseScroll) {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            Log.e("ScrollTextView", e.toString());
                        }
                    } else {
                        ScrollTextView scrollTextView = ScrollTextView.this;
                        scrollTextView.draw(scrollTextView.viewWidth - ScrollTextView.this.textX, ScrollTextView.this.textY);
                        ScrollTextView scrollTextView2 = ScrollTextView.this;
                        ScrollTextView.access$516(scrollTextView2, scrollTextView2.speed);
                        if (ScrollTextView.this.textX > ScrollTextView.this.viewWidth_plus_textLength) {
                            ScrollTextView.this.textX = 0.0f;
                            ScrollTextView.access$1006(ScrollTextView.this);
                        }
                    }
                } else {
                    ScrollTextView.this.drawVerticalScroll();
                    ScrollTextView.this.isSetNewText = false;
                    ScrollTextView.access$1006(ScrollTextView.this);
                }
                if (ScrollTextView.this.needScrollTimes <= 0 && ScrollTextView.this.isScrollForever) {
                    ScrollTextView.this.stopScroll = true;
                }
            }
        }
    }

    public void setMarqueeTextCallBack(MarqueeTextCallBack marqueeTextCallBack) {
        this.mMarqueeTextCallBack = marqueeTextCallBack;
    }
}
