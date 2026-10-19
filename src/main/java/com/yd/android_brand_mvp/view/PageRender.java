package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import com.eschao.android.widget.pageflip.OnPageFlipListener;
import com.eschao.android.widget.pageflip.PageFlip;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PageRender implements OnPageFlipListener {
    static final int DRAW_ANIMATING_FRAME = 1;
    static final int DRAW_FULL_PAGE = 2;
    static final int DRAW_MOVING_FRAME = 0;
    static final int MAX_PAGES = 30;
    public static final int MSG_ENDED_DRAWING_FRAME = 1;
    private static final String TAG = "PageRender";
    Bitmap mBackgroundBitmap;
    Bitmap mBitmap;
    Context mContext;
    Handler mHandler;
    PageFlip mPageFlip;
    int mPageNo;
    int mDrawCommand = 2;
    Canvas mCanvas = new Canvas();

    abstract void onDrawFrame();

    abstract boolean onEndedDrawing(int i);

    abstract void onSurfaceChanged(int i, int i2);

    public PageRender(Context context, PageFlip pageFlip, Handler handler, int i) {
        this.mContext = context;
        this.mPageFlip = pageFlip;
        this.mPageNo = i;
        this.mPageFlip.setListener(this);
        this.mHandler = handler;
    }

    public int getPageNo() {
        return this.mPageNo;
    }

    public void release() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBitmap = null;
        }
        this.mPageFlip.setListener(null);
        this.mCanvas = null;
        this.mBackgroundBitmap = null;
    }

    public boolean onFingerMove(float f, float f2) {
        this.mDrawCommand = 0;
        return true;
    }

    public boolean onFingerUp(float f, float f2) {
        if (!this.mPageFlip.animating()) {
            return false;
        }
        this.mDrawCommand = 1;
        return true;
    }

    protected int calcFontSize(int i) {
        return (int) (i * this.mContext.getResources().getDisplayMetrics().scaledDensity);
    }
}
