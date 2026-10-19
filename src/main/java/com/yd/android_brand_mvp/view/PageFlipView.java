package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.util.Log;
import com.eschao.android.widget.pageflip.PageFlip;
import com.eschao.android.widget.pageflip.PageFlipException;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes4.dex */
public class PageFlipView extends GLSurfaceView implements GLSurfaceView.Renderer {
    public static final String PREF_DURATION = "Duration";
    public static final String PREF_MESH_PIXELS = "MeshPixels";
    public static final String PREF_PAGE_MODE = "PageMode";
    private static final String TAG = "PageFlipView";
    ReentrantLock mDrawLock;
    int mDuration;
    Handler mHandler;
    PageFlip mPageFlip;
    int mPageNo;
    PageRender mPageRender;

    public PageFlipView(Context context) {
        super(context);
        init(context);
    }

    public PageFlipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        newHandler();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mDuration = defaultSharedPreferences.getInt(PREF_DURATION, 1000);
        int i = defaultSharedPreferences.getInt(PREF_MESH_PIXELS, 10);
        boolean z = defaultSharedPreferences.getBoolean(PREF_PAGE_MODE, true);
        PageFlip pageFlip = new PageFlip(context);
        this.mPageFlip = pageFlip;
        pageFlip.setSemiPerimeterRatio(0.8f).setShadowWidthOfFoldEdges(5.0f, 60.0f, 0.3f).setShadowWidthOfFoldBase(5.0f, 80.0f, 0.4f).setPixelsOfMesh(i).enableAutoPage(z);
        setEGLContextClientVersion(2);
        this.mPageNo = 1;
        this.mDrawLock = new ReentrantLock();
        this.mPageRender = new SinglePageRender(context, this.mPageFlip, this.mHandler, this.mPageNo);
        setRenderer(this);
        setRenderMode(0);
    }

    public boolean isAutoPageEnabled() {
        return this.mPageFlip.isAutoPageEnabled();
    }

    public void enableAutoPage(boolean z) {
        if (this.mPageFlip.enableAutoPage(z)) {
            try {
                this.mDrawLock.lock();
                if (this.mPageFlip.getSecondPage() != null && (this.mPageRender instanceof SinglePageRender)) {
                    DoublePagesRender doublePagesRender = new DoublePagesRender(getContext(), this.mPageFlip, this.mHandler, this.mPageNo);
                    this.mPageRender = doublePagesRender;
                    doublePagesRender.onSurfaceChanged(this.mPageFlip.getSurfaceWidth(), this.mPageFlip.getSurfaceHeight());
                } else if (this.mPageFlip.getSecondPage() == null && (this.mPageRender instanceof DoublePagesRender)) {
                    SinglePageRender singlePageRender = new SinglePageRender(getContext(), this.mPageFlip, this.mHandler, this.mPageNo);
                    this.mPageRender = singlePageRender;
                    singlePageRender.onSurfaceChanged(this.mPageFlip.getSurfaceWidth(), this.mPageFlip.getSurfaceHeight());
                }
                requestRender();
            } finally {
                this.mDrawLock.unlock();
            }
        }
    }

    public int getAnimateDuration() {
        return this.mDuration;
    }

    public void setAnimateDuration(int i) {
        this.mDuration = i;
    }

    public int getPixelsOfMesh() {
        return this.mPageFlip.getPixelsOfMesh();
    }

    public void onFingerDown(float f, float f2) {
        if (this.mPageFlip.isAnimating() || this.mPageFlip.getFirstPage() == null) {
            return;
        }
        this.mPageFlip.onFingerDown(f, f2);
    }

    public void onFingerMove(float f, float f2) {
        if (this.mPageFlip.isAnimating()) {
            return;
        }
        if (this.mPageFlip.canAnimate(f, f2)) {
            onFingerUp(f, f2);
            return;
        }
        if (this.mPageFlip.onFingerMove(f, f2)) {
            try {
                this.mDrawLock.lock();
                if (this.mPageRender != null && this.mPageRender.onFingerMove(f, f2)) {
                    requestRender();
                }
            } finally {
                this.mDrawLock.unlock();
            }
        }
    }

    public void onFingerUp(float f, float f2) {
        if (this.mPageFlip.isAnimating()) {
            return;
        }
        this.mPageFlip.onFingerUp(f, f2, this.mDuration);
        try {
            this.mDrawLock.lock();
            if (this.mPageRender != null && this.mPageRender.onFingerUp(f, f2)) {
                requestRender();
            }
        } finally {
            this.mDrawLock.unlock();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        try {
            this.mDrawLock.lock();
            if (this.mPageRender != null) {
                this.mPageRender.onDrawFrame();
            }
        } finally {
            this.mDrawLock.unlock();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        try {
            this.mPageFlip.onSurfaceChanged(i, i2);
            int pageNo = this.mPageRender.getPageNo();
            if (this.mPageFlip.getSecondPage() != null && i > i2) {
                if (!(this.mPageRender instanceof DoublePagesRender)) {
                    this.mPageRender.release();
                    this.mPageRender = new DoublePagesRender(getContext(), this.mPageFlip, this.mHandler, pageNo);
                }
            } else if (!(this.mPageRender instanceof SinglePageRender)) {
                this.mPageRender.release();
                this.mPageRender = new SinglePageRender(getContext(), this.mPageFlip, this.mHandler, pageNo);
            }
            this.mPageRender.onSurfaceChanged(i, i2);
        } catch (PageFlipException unused) {
            Log.e(TAG, "Failed to run PageFlipFlipRender:onSurfaceChanged");
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) throws Throwable {
        try {
            this.mPageFlip.onSurfaceCreated();
        } catch (PageFlipException unused) {
            Log.e(TAG, "Failed to run PageFlipFlipRender:onSurfaceCreated");
        }
    }

    private void newHandler() {
        this.mHandler = new Handler() { // from class: com.yd.android_brand_mvp.view.PageFlipView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                try {
                    PageFlipView.this.mDrawLock.lock();
                    if (PageFlipView.this.mPageRender != null && PageFlipView.this.mPageRender.onEndedDrawing(message.arg1)) {
                        PageFlipView.this.requestRender();
                    }
                } finally {
                    PageFlipView.this.mDrawLock.unlock();
                }
            }
        };
    }
}
