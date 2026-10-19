package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import com.yd.android_brand_mvp.R;
import java.util.LinkedList;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public final class LoadBitmapTask implements Runnable {
    static final int BG_COUNT = 10;
    static final int LARGE_BG = 2;
    static final int MEDIUM_BG = 1;
    static final int SMALL_BG = 0;
    private static final String TAG = "LoadBitmapTask";
    private static LoadBitmapTask __object;
    Resources mResources;
    Random mBGRandom = new Random();
    int mBGSizeIndex = 0;
    boolean mStop = false;
    Thread mThread = null;
    int mPreRandomNo = 0;
    boolean mIsLandscape = false;
    int mQueueMaxSize = 1;
    LinkedList<Bitmap> mQueue = new LinkedList<>();
    int[][] mPortraitBGs = {new int[]{R.drawable.page_1, R.drawable.page_2, R.drawable.page_3, R.drawable.page_4, R.drawable.page_5, R.drawable.page_6, R.drawable.page_7, R.drawable.page_8, R.drawable.page_9, R.drawable.page_10}, new int[]{R.drawable.page_1, R.drawable.page_2, R.drawable.page_3, R.drawable.page_4, R.drawable.page_5, R.drawable.page_6, R.drawable.page_7, R.drawable.page_8, R.drawable.page_9, R.drawable.page_10}, new int[]{R.drawable.page_1, R.drawable.page_2, R.drawable.page_3, R.drawable.page_4, R.drawable.page_5, R.drawable.page_6, R.drawable.page_7, R.drawable.page_8, R.drawable.page_9, R.drawable.page_10}};

    public static LoadBitmapTask get(Context context) {
        if (__object == null) {
            __object = new LoadBitmapTask(context);
        }
        return __object;
    }

    private LoadBitmapTask(Context context) {
        this.mResources = context.getResources();
    }

    public Bitmap getBitmap() {
        Bitmap bitmapPop;
        synchronized (this) {
            bitmapPop = this.mQueue.size() > 0 ? this.mQueue.pop() : null;
            notify();
        }
        if (bitmapPop != null) {
            return bitmapPop;
        }
        Log.d(TAG, "Load bitmap instantly!");
        return getRandomBitmap();
    }

    public boolean isRunning() {
        Thread thread = this.mThread;
        return thread != null && thread.isAlive();
    }

    public synchronized void start() {
        if (this.mThread == null || !this.mThread.isAlive()) {
            this.mStop = false;
            Thread thread = new Thread(this);
            this.mThread = thread;
            thread.start();
        }
    }

    public void stop() {
        synchronized (this) {
            this.mStop = true;
            notify();
        }
        for (int i = 0; i < 3 && this.mThread.isAlive(); i++) {
            Log.d(TAG, "Waiting thread to stop ...");
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
        }
        if (this.mThread.isAlive()) {
            Log.d(TAG, "Thread is still alive after waited 1.5s!");
        }
    }

    public void set(int i, int i2, int i3) {
        int i4;
        if ((i > 480 || i2 > 854) && (i > 854 || i2 > 480)) {
            i4 = ((i > 800 || i2 > 1280) && (i2 > 800 || i > 1280)) ? 2 : 1;
        } else {
            i4 = 0;
        }
        this.mIsLandscape = i > i2;
        if (i3 != this.mQueueMaxSize) {
            this.mQueueMaxSize = i3;
        }
        if (i4 != this.mBGSizeIndex) {
            this.mBGSizeIndex = i4;
            synchronized (this) {
                cleanQueue();
                notify();
            }
        }
    }

    private Bitmap getRandomBitmap() {
        int iNextInt = this.mPreRandomNo;
        while (iNextInt == this.mPreRandomNo) {
            iNextInt = this.mBGRandom.nextInt(10);
        }
        this.mPreRandomNo = iNextInt;
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.mResources, this.mPortraitBGs[this.mBGSizeIndex][iNextInt]);
        if (!this.mIsLandscape) {
            return bitmapDecodeResource;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix, true);
        bitmapDecodeResource.recycle();
        return bitmapCreateBitmap;
    }

    private void cleanQueue() {
        for (int i = 0; i < this.mQueue.size(); i++) {
            this.mQueue.get(i).recycle();
        }
        this.mQueue.clear();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            synchronized (this) {
                if (this.mStop) {
                    cleanQueue();
                    return;
                }
                if (this.mQueue.size() < 1) {
                    for (int i = 0; i < this.mQueueMaxSize; i++) {
                        Log.d(TAG, "Load Queue:" + i + " in background!");
                        this.mQueue.push(getRandomBitmap());
                    }
                }
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }
}
