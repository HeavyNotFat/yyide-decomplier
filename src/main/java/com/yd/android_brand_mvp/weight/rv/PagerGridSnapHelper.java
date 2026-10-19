package com.yd.android_brand_mvp.weight.rv;

import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* JADX INFO: loaded from: classes4.dex */
public class PagerGridSnapHelper extends SnapHelper {
    private RecyclerView mRecyclerView;

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        return layoutManager instanceof PagerGridLayoutManager ? ((PagerGridLayoutManager) layoutManager).getSnapOffset(layoutManager.getPosition(view)) : new int[2];
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof PagerGridLayoutManager) {
            return ((PagerGridLayoutManager) layoutManager).findSnapView();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            PagerGridLayoutManager pagerGridLayoutManager = (PagerGridLayoutManager) layoutManager;
            if (pagerGridLayoutManager.canScrollHorizontally()) {
                if (i > PagerConfig.getFlingThreshold()) {
                    return pagerGridLayoutManager.findNextPageFirstPos();
                }
                if (i < (-PagerConfig.getFlingThreshold())) {
                    return pagerGridLayoutManager.findPrePageFirstPos();
                }
            } else if (pagerGridLayoutManager.canScrollVertically()) {
                if (i2 > PagerConfig.getFlingThreshold()) {
                    return pagerGridLayoutManager.findNextPageFirstPos();
                }
                if (i2 < (-PagerConfig.getFlingThreshold())) {
                    return pagerGridLayoutManager.findPrePageFirstPos();
                }
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.SnapHelper, androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i, int i2) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int flingThreshold = PagerConfig.getFlingThreshold();
        return (Math.abs(i2) > flingThreshold || Math.abs(i) > flingThreshold) && snapFromFling(layoutManager, i, i2);
    }

    private boolean snapFromFling(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        LinearSmoothScroller linearSmoothScrollerCreateSnapScroller;
        int iFindTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (linearSmoothScrollerCreateSnapScroller = createSnapScroller(layoutManager)) == null || (iFindTargetSnapPosition = findTargetSnapPosition(layoutManager, i, i2)) == -1) {
            return false;
        }
        linearSmoothScrollerCreateSnapScroller.setTargetPosition(iFindTargetSnapPosition);
        layoutManager.startSmoothScroll(linearSmoothScrollerCreateSnapScroller);
        return true;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new PagerGridSmoothScroller(this.mRecyclerView);
        }
        return null;
    }

    public void setFlingThreshold(int i) {
        PagerConfig.setFlingThreshold(i);
    }
}
