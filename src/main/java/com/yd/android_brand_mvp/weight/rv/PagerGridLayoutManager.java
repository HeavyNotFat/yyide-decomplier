package com.yd.android_brand_mvp.weight.rv;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class PagerGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 1;
    private static final String TAG = PagerGridLayoutManager.class.getSimpleName();
    public static final int VERTICAL = 0;
    private int mColumns;
    private int mMaxScrollX;
    private int mMaxScrollY;
    private int mOnePageSize;
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mRows;
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int mItemWidth = 0;
    private int mItemHeight = 0;
    private int mWidthUsed = 0;
    private int mHeightUsed = 0;
    private int mScrollState = 0;
    private boolean mAllowContinuousScroll = true;
    private boolean mChangeSelectInScrolling = true;
    private int mLastPageCount = -1;
    private int mLastPageIndex = -1;
    private PageListener mPageListener = null;
    private SparseArray<Rect> mItemFrames = new SparseArray<>();

    public @interface OrientationType {
    }

    public interface PageListener {
        void onPageSelect(int i);

        void onPageSizeChanged(int i);
    }

    public PagerGridLayoutManager(int i, int i2, int i3) {
        this.mOrientation = i3;
        this.mRows = i;
        this.mColumns = i2;
        this.mOnePageSize = i * i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout() || !state.didStructureChange()) {
            return;
        }
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            setPageCount(0);
            setPageIndex(0, false);
            return;
        }
        setPageCount(getTotalPageCount());
        setPageIndex(getPageIndexByOffset(), false);
        int itemCount = getItemCount() / this.mOnePageSize;
        if (getItemCount() % this.mOnePageSize != 0) {
            itemCount++;
        }
        if (canScrollHorizontally()) {
            int usableWidth = (itemCount - 1) * getUsableWidth();
            this.mMaxScrollX = usableWidth;
            this.mMaxScrollY = 0;
            if (this.mOffsetX > usableWidth) {
                this.mOffsetX = usableWidth;
            }
        } else {
            this.mMaxScrollX = 0;
            int usableHeight = (itemCount - 1) * getUsableHeight();
            this.mMaxScrollY = usableHeight;
            if (this.mOffsetY > usableHeight) {
                this.mOffsetY = usableHeight;
            }
        }
        if (this.mItemWidth <= 0) {
            this.mItemWidth = getUsableWidth() / this.mColumns;
        }
        if (this.mItemHeight <= 0) {
            this.mItemHeight = getUsableHeight() / this.mRows;
        }
        this.mWidthUsed = getUsableWidth() - this.mItemWidth;
        this.mHeightUsed = getUsableHeight() - this.mItemHeight;
        for (int i = 0; i < this.mOnePageSize * 2; i++) {
            getItemFrameByPosition(i);
        }
        if (this.mOffsetX == 0 && this.mOffsetY == 0) {
            for (int i2 = 0; i2 < this.mOnePageSize && i2 < getItemCount(); i2++) {
                View viewForPosition = recycler.getViewForPosition(i2);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, this.mWidthUsed, this.mHeightUsed);
            }
        }
        recycleAndFillItems(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (state.isPreLayout()) {
            return;
        }
        setPageCount(getTotalPageCount());
        setPageIndex(getPageIndexByOffset(), false);
    }

    private void recycleAndFillItems(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        if (state.isPreLayout()) {
            return;
        }
        Rect rect = new Rect(this.mOffsetX - this.mItemWidth, this.mOffsetY - this.mItemHeight, getUsableWidth() + this.mOffsetX + this.mItemWidth, getUsableHeight() + this.mOffsetY + this.mItemHeight);
        rect.intersect(0, 0, this.mMaxScrollX + getUsableWidth(), this.mMaxScrollY + getUsableHeight());
        int pageIndexByOffset = getPageIndexByOffset();
        int i = this.mOnePageSize;
        int i2 = (pageIndexByOffset * i) - (i * 2);
        int i3 = i2 >= 0 ? i2 : 0;
        int itemCount = (this.mOnePageSize * 4) + i3;
        if (itemCount > getItemCount()) {
            itemCount = getItemCount();
        }
        detachAndScrapAttachedViews(recycler);
        if (z) {
            while (i3 < itemCount) {
                addOrRemove(recycler, rect, i3);
                i3++;
            }
        } else {
            for (int i4 = itemCount - 1; i4 >= i3; i4--) {
                addOrRemove(recycler, rect, i4);
            }
        }
    }

    private void addOrRemove(RecyclerView.Recycler recycler, Rect rect, int i) {
        View viewForPosition = recycler.getViewForPosition(i);
        Rect itemFrameByPosition = getItemFrameByPosition(i);
        if (!Rect.intersects(rect, itemFrameByPosition)) {
            removeAndRecycleView(viewForPosition, recycler);
            return;
        }
        addView(viewForPosition);
        measureChildWithMargins(viewForPosition, this.mWidthUsed, this.mHeightUsed);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
        layoutDecorated(viewForPosition, (itemFrameByPosition.left - this.mOffsetX) + layoutParams.leftMargin + getPaddingLeft(), (itemFrameByPosition.top - this.mOffsetY) + layoutParams.topMargin + getPaddingTop(), ((itemFrameByPosition.right - this.mOffsetX) - layoutParams.rightMargin) + getPaddingLeft(), ((itemFrameByPosition.bottom - this.mOffsetY) - layoutParams.bottomMargin) + getPaddingTop());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.mOffsetX;
        int i3 = i2 + i;
        int i4 = this.mMaxScrollX;
        if (i3 > i4) {
            i = i4 - i2;
        } else if (i3 < 0) {
            i = 0 - i2;
        }
        this.mOffsetX += i;
        setPageIndex(getPageIndexByOffset(), true);
        offsetChildrenHorizontal(-i);
        if (i > 0) {
            recycleAndFillItems(recycler, state, true);
        } else {
            recycleAndFillItems(recycler, state, false);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.mOffsetY;
        int i3 = i2 + i;
        int i4 = this.mMaxScrollY;
        if (i3 > i4) {
            i = i4 - i2;
        } else if (i3 < 0) {
            i = 0 - i2;
        }
        this.mOffsetY += i;
        setPageIndex(getPageIndexByOffset(), true);
        offsetChildrenVertical(-i);
        if (i > 0) {
            recycleAndFillItems(recycler, state, true);
        } else {
            recycleAndFillItems(recycler, state, false);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        this.mScrollState = i;
        super.onScrollStateChanged(i);
        if (i == 0) {
            setPageIndex(getPageIndexByOffset(), false);
        }
    }

    private Rect getItemFrameByPosition(int i) {
        int usableHeight;
        Rect rect = this.mItemFrames.get(i);
        if (rect == null) {
            rect = new Rect();
            int i2 = i / this.mOnePageSize;
            int usableWidth = 0;
            if (canScrollHorizontally()) {
                usableWidth = (getUsableWidth() * i2) + 0;
                usableHeight = 0;
            } else {
                usableHeight = (getUsableHeight() * i2) + 0;
            }
            int i3 = i % this.mOnePageSize;
            int i4 = this.mColumns;
            int i5 = i3 / i4;
            int i6 = usableWidth + ((i3 - (i4 * i5)) * this.mItemWidth);
            int i7 = usableHeight + (i5 * this.mItemHeight);
            rect.left = i6;
            rect.top = i7;
            rect.right = i6 + this.mItemWidth;
            rect.bottom = i7 + this.mItemHeight;
            this.mItemFrames.put(i, rect);
        }
        return rect;
    }

    private int getUsableWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int getUsableHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getTotalPageCount() {
        if (getItemCount() <= 0) {
            return 0;
        }
        int itemCount = getItemCount() / this.mOnePageSize;
        return getItemCount() % this.mOnePageSize != 0 ? itemCount + 1 : itemCount;
    }

    private int getPageIndexByPos(int i) {
        return i / this.mOnePageSize;
    }

    private int getPageIndexByOffset() {
        int i;
        if (canScrollVertically()) {
            int usableHeight = getUsableHeight();
            int i2 = this.mOffsetY;
            if (i2 <= 0 || usableHeight <= 0) {
                return 0;
            }
            i = i2 / usableHeight;
            if (i2 % usableHeight <= usableHeight / 2) {
                return i;
            }
        } else {
            int usableWidth = getUsableWidth();
            int i3 = this.mOffsetX;
            if (i3 <= 0 || usableWidth <= 0) {
                return 0;
            }
            i = i3 / usableWidth;
            if (i3 % usableWidth <= usableWidth / 2) {
                return i;
            }
        }
        return i + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        super.onMeasure(recycler, state, i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && size > 0) {
            mode = 1073741824;
        }
        if (mode2 != 1073741824 && size2 > 0) {
            mode2 = 1073741824;
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 0;
    }

    int findNextPageFirstPos() {
        int totalPageCount = this.mLastPageIndex + 1;
        if (totalPageCount >= getTotalPageCount()) {
            totalPageCount = getTotalPageCount() - 1;
        }
        return totalPageCount * this.mOnePageSize;
    }

    int findPrePageFirstPos() {
        int i = this.mLastPageIndex - 1;
        if (i < 0) {
            i = 0;
        }
        return i * this.mOnePageSize;
    }

    public int getOffsetX() {
        return this.mOffsetX;
    }

    public int getOffsetY() {
        return this.mOffsetY;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        PointF pointF = new PointF();
        int[] snapOffset = getSnapOffset(i);
        pointF.x = snapOffset[0];
        pointF.y = snapOffset[1];
        return pointF;
    }

    int[] getSnapOffset(int i) {
        int[] pageLeftTopByPosition = getPageLeftTopByPosition(i);
        return new int[]{pageLeftTopByPosition[0] - this.mOffsetX, pageLeftTopByPosition[1] - this.mOffsetY};
    }

    private int[] getPageLeftTopByPosition(int i) {
        int[] iArr = new int[2];
        int pageIndexByPos = getPageIndexByPos(i);
        if (canScrollHorizontally()) {
            iArr[0] = pageIndexByPos * getUsableWidth();
            iArr[1] = 0;
        } else {
            iArr[0] = 0;
            iArr[1] = pageIndexByPos * getUsableHeight();
        }
        return iArr;
    }

    public View findSnapView() {
        if (getFocusedChild() != null) {
            return getFocusedChild();
        }
        if (getChildCount() <= 0) {
            return null;
        }
        int pageIndexByOffset = getPageIndexByOffset() * this.mOnePageSize;
        for (int i = 0; i < getChildCount(); i++) {
            if (getPosition(getChildAt(i)) == pageIndexByOffset) {
                return getChildAt(i);
            }
        }
        return getChildAt(0);
    }

    private void setPageCount(int i) {
        if (i >= 0) {
            PageListener pageListener = this.mPageListener;
            if (pageListener != null && i != this.mLastPageCount) {
                pageListener.onPageSizeChanged(i);
            }
            this.mLastPageCount = i;
        }
    }

    private void setPageIndex(int i, boolean z) {
        PageListener pageListener;
        if (i == this.mLastPageIndex) {
            return;
        }
        if (isAllowContinuousScroll() || !z) {
            this.mLastPageIndex = i;
        }
        if ((!z || this.mChangeSelectInScrolling) && i >= 0 && (pageListener = this.mPageListener) != null) {
            pageListener.onPageSelect(i);
        }
    }

    public void setChangeSelectInScrolling(boolean z) {
        this.mChangeSelectInScrolling = z;
    }

    public int setOrientationType(int i) {
        if (this.mOrientation == i || this.mScrollState != 0) {
            return this.mOrientation;
        }
        this.mOrientation = i;
        this.mItemFrames.clear();
        int i2 = this.mOffsetX;
        this.mOffsetX = (this.mOffsetY / getUsableHeight()) * getUsableWidth();
        this.mOffsetY = (i2 / getUsableWidth()) * getUsableHeight();
        int i3 = this.mMaxScrollX;
        this.mMaxScrollX = (this.mMaxScrollY / getUsableHeight()) * getUsableWidth();
        this.mMaxScrollY = (i3 / getUsableWidth()) * getUsableHeight();
        return this.mOrientation;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        smoothScrollToPage(getPageIndexByPos(i));
    }

    public void smoothPrePage() {
        smoothScrollToPage(getPageIndexByOffset() - 1);
    }

    public void smoothNextPage() {
        smoothScrollToPage(getPageIndexByOffset() + 1);
    }

    public void smoothScrollToPage(int i) {
        if (i < 0 || i >= this.mLastPageCount) {
            Log.e(TAG, "pageIndex is outOfIndex, must in [0, " + this.mLastPageCount + ").");
            return;
        }
        if (this.mRecyclerView == null) {
            Log.e(TAG, "RecyclerView Not Found!");
            return;
        }
        int pageIndexByOffset = getPageIndexByOffset();
        if (Math.abs(i - pageIndexByOffset) > 3) {
            if (i > pageIndexByOffset) {
                scrollToPage(i - 3);
            } else if (i < pageIndexByOffset) {
                scrollToPage(i + 3);
            }
        }
        PagerGridSmoothScroller pagerGridSmoothScroller = new PagerGridSmoothScroller(this.mRecyclerView);
        pagerGridSmoothScroller.setTargetPosition(i * this.mOnePageSize);
        startSmoothScroll(pagerGridSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        scrollToPage(getPageIndexByPos(i));
    }

    public void prePage() {
        scrollToPage(getPageIndexByOffset() - 1);
    }

    public void nextPage() {
        scrollToPage(getPageIndexByOffset() + 1);
    }

    public void scrollToPage(int i) {
        int usableWidth;
        int usableHeight;
        if (i < 0 || i >= this.mLastPageCount) {
            Log.e(TAG, "pageIndex = " + i + " is out of bounds, mast in [0, " + this.mLastPageCount + ")");
            return;
        }
        if (this.mRecyclerView == null) {
            Log.e(TAG, "RecyclerView Not Found!");
            return;
        }
        if (canScrollVertically()) {
            usableHeight = (getUsableHeight() * i) - this.mOffsetY;
            usableWidth = 0;
        } else {
            usableWidth = (getUsableWidth() * i) - this.mOffsetX;
            usableHeight = 0;
        }
        this.mRecyclerView.scrollBy(usableWidth, usableHeight);
        setPageIndex(i, false);
    }

    public boolean isAllowContinuousScroll() {
        return this.mAllowContinuousScroll;
    }

    public void setAllowContinuousScroll(boolean z) {
        this.mAllowContinuousScroll = z;
    }

    public void setPageListener(PageListener pageListener) {
        this.mPageListener = pageListener;
    }
}
