package com.yd.android_brand_mvp.utils;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class LongClickUtils {
    private static final String TAG = "LongClickUtils";

    public static void setLongClick(final Handler handler, final View view, final long j, final View.OnLongClickListener onLongClickListener) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.utils.LongClickUtils.1
            private int mLastMotionX;
            private int mLastMotionY;
            private int TOUCH_MAX = 50;
            private Runnable r = new Runnable() { // from class: com.yd.android_brand_mvp.utils.LongClickUtils.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (onLongClickListener != null) {
                        onLongClickListener.onLongClick(view);
                    }
                }
            };

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int action = motionEvent.getAction();
                if (action == 0) {
                    handler.removeCallbacks(this.r);
                    this.mLastMotionX = x;
                    this.mLastMotionY = y;
                    handler.postDelayed(this.r, j);
                } else if (action == 1) {
                    handler.removeCallbacks(this.r);
                } else if (action == 2 && (Math.abs(this.mLastMotionX - x) > this.TOUCH_MAX || Math.abs(this.mLastMotionY - y) > this.TOUCH_MAX)) {
                    handler.removeCallbacks(this.r);
                }
                return true;
            }
        });
    }
}
