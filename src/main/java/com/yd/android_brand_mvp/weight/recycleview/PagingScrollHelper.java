package com.yd.android_brand_mvp.weight.recycleview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class PagingScrollHelper {
    onPageChangeListener mOnPageChangeListener;
    RecyclerView mRecyclerView = null;
    private MyOnScrollListener mOnScrollListener = new MyOnScrollListener();
    private MyOnFlingListener mOnFlingListener = new MyOnFlingListener();
    private int offsetY = 0;
    private int offsetX = 0;
    int startY = 0;
    int startX = 0;
    private ORIENTATION mOrientation = ORIENTATION.HORIZONTAL;
    ValueAnimator mAnimator = null;
    private MyOnTouchListener mOnTouchListener = new MyOnTouchListener();
    private boolean firstTouch = true;

    enum ORIENTATION {
        HORIZONTAL,
        VERTICAL,
        NULL
    }

    public interface onPageChangeListener {
        void onPageChange(int i);
    }

    static /* synthetic */ int access$212(PagingScrollHelper pagingScrollHelper, int i) {
        int i2 = pagingScrollHelper.offsetY + i;
        pagingScrollHelper.offsetY = i2;
        return i2;
    }

    static /* synthetic */ int access$312(PagingScrollHelper pagingScrollHelper, int i) {
        int i2 = pagingScrollHelper.offsetX + i;
        pagingScrollHelper.offsetX = i2;
        return i2;
    }

    public void setUpRecycleView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            throw new IllegalArgumentException("recycleView must be not null");
        }
        this.mRecyclerView = recyclerView;
        recyclerView.setOnFlingListener(this.mOnFlingListener);
        recyclerView.setOnScrollListener(this.mOnScrollListener);
        recyclerView.setOnTouchListener(this.mOnTouchListener);
        updateLayoutManger();
    }

    public void updateLayoutManger() {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager.canScrollVertically()) {
                this.mOrientation = ORIENTATION.VERTICAL;
            } else if (layoutManager.canScrollHorizontally()) {
                this.mOrientation = ORIENTATION.HORIZONTAL;
            } else {
                this.mOrientation = ORIENTATION.NULL;
            }
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.startX = 0;
            this.startY = 0;
            this.offsetX = 0;
            this.offsetY = 0;
        }
    }

    public int getPageCount() {
        if (this.mRecyclerView == null || this.mOrientation == ORIENTATION.NULL) {
            return 0;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL && this.mRecyclerView.computeVerticalScrollExtent() != 0) {
            return this.mRecyclerView.computeVerticalScrollRange() / this.mRecyclerView.computeVerticalScrollExtent();
        }
        if (this.mRecyclerView.computeHorizontalScrollExtent() != 0) {
            Log.i("zzz", "rang=" + this.mRecyclerView.computeHorizontalScrollRange() + " extent=" + this.mRecyclerView.computeHorizontalScrollExtent());
            return this.mRecyclerView.computeHorizontalScrollRange() / this.mRecyclerView.computeHorizontalScrollExtent();
        }
        return 0;
    }

    public void scrollToPosition(int i) {
        int width;
        if (this.mAnimator == null) {
            this.mOnFlingListener.onFling(0, 0);
        }
        if (this.mAnimator != null) {
            int i2 = this.mOrientation == ORIENTATION.VERTICAL ? this.offsetY : this.offsetX;
            if (this.mOrientation == ORIENTATION.VERTICAL) {
                width = this.mRecyclerView.getHeight();
            } else {
                width = this.mRecyclerView.getWidth();
            }
            int i3 = width * i;
            if (i2 != i3) {
                this.mAnimator.setIntValues(i2, i3);
                this.mAnimator.start();
            }
        }
    }

    public class MyOnFlingListener extends RecyclerView.OnFlingListener {
        public MyOnFlingListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
        public boolean onFling(int i, int i2) {
            int width;
            int i3;
            if (PagingScrollHelper.this.mOrientation == ORIENTATION.NULL) {
                return false;
            }
            int startPageIndex = PagingScrollHelper.this.getStartPageIndex();
            if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                i3 = PagingScrollHelper.this.offsetY;
                if (i2 < 0) {
                    startPageIndex--;
                } else if (i2 > 0) {
                    startPageIndex++;
                }
                width = startPageIndex * PagingScrollHelper.this.mRecyclerView.getHeight();
            } else {
                int i4 = PagingScrollHelper.this.offsetX;
                if (i < 0) {
                    startPageIndex--;
                } else if (i > 0) {
                    startPageIndex++;
                }
                width = startPageIndex * PagingScrollHelper.this.mRecyclerView.getWidth();
                i3 = i4;
            }
            if (width < 0) {
                width = 0;
            }
            if (PagingScrollHelper.this.mAnimator == null) {
                PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
                new ValueAnimator();
                pagingScrollHelper.mAnimator = ValueAnimator.ofInt(i3, width);
                PagingScrollHelper.this.mAnimator.setDuration(300L);
                PagingScrollHelper.this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper.MyOnFlingListener.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                            PagingScrollHelper.this.mRecyclerView.scrollBy(0, iIntValue - PagingScrollHelper.this.offsetY);
                        } else {
                            PagingScrollHelper.this.mRecyclerView.scrollBy(iIntValue - PagingScrollHelper.this.offsetX, 0);
                        }
                    }
                });
                PagingScrollHelper.this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper.MyOnFlingListener.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (PagingScrollHelper.this.mOnPageChangeListener != null) {
                            PagingScrollHelper.this.mOnPageChangeListener.onPageChange(PagingScrollHelper.this.getPageIndex());
                        }
                        PagingScrollHelper.this.mRecyclerView.stopScroll();
                        PagingScrollHelper.this.startY = PagingScrollHelper.this.offsetY;
                        PagingScrollHelper.this.startX = PagingScrollHelper.this.offsetX;
                    }
                });
            } else {
                PagingScrollHelper.this.mAnimator.cancel();
                PagingScrollHelper.this.mAnimator.setIntValues(i3, width);
            }
            PagingScrollHelper.this.mAnimator.start();
            return true;
        }
    }

    public class MyOnScrollListener extends RecyclerView.OnScrollListener {
        public MyOnScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 0 || PagingScrollHelper.this.mOrientation == ORIENTATION.NULL) {
                return;
            }
            int i2 = -1000;
            int i3 = 0;
            if (PagingScrollHelper.this.mOrientation == ORIENTATION.VERTICAL) {
                if (Math.abs(PagingScrollHelper.this.offsetY - PagingScrollHelper.this.startY) > recyclerView.getHeight() / 2) {
                    if (PagingScrollHelper.this.offsetY - PagingScrollHelper.this.startY >= 0) {
                        i2 = 1000;
                    }
                }
                PagingScrollHelper.this.mOnFlingListener.onFling(i3, i2);
            }
            if (Math.abs(PagingScrollHelper.this.offsetX - PagingScrollHelper.this.startX) > recyclerView.getWidth() / 2) {
                i3 = PagingScrollHelper.this.offsetX - PagingScrollHelper.this.startX >= 0 ? 1000 : -1000;
            }
            i2 = 0;
            PagingScrollHelper.this.mOnFlingListener.onFling(i3, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            PagingScrollHelper.access$212(PagingScrollHelper.this, i2);
            PagingScrollHelper.access$312(PagingScrollHelper.this, i);
        }
    }

    public class MyOnTouchListener implements View.OnTouchListener {
        public MyOnTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (PagingScrollHelper.this.firstTouch) {
                PagingScrollHelper.this.firstTouch = false;
                PagingScrollHelper pagingScrollHelper = PagingScrollHelper.this;
                pagingScrollHelper.startY = pagingScrollHelper.offsetY;
                PagingScrollHelper pagingScrollHelper2 = PagingScrollHelper.this;
                pagingScrollHelper2.startX = pagingScrollHelper2.offsetX;
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                PagingScrollHelper.this.firstTouch = true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPageIndex() {
        if (this.mRecyclerView.getHeight() == 0 || this.mRecyclerView.getWidth() == 0) {
            return 0;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            return this.offsetY / this.mRecyclerView.getHeight();
        }
        return this.offsetX / this.mRecyclerView.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStartPageIndex() {
        if (this.mRecyclerView.getHeight() == 0 || this.mRecyclerView.getWidth() == 0) {
            return 0;
        }
        if (this.mOrientation == ORIENTATION.VERTICAL) {
            return this.startY / this.mRecyclerView.getHeight();
        }
        return this.startX / this.mRecyclerView.getWidth();
    }

    public void setOnPageChangeListener(onPageChangeListener onpagechangelistener) {
        this.mOnPageChangeListener = onpagechangelistener;
    }
}
