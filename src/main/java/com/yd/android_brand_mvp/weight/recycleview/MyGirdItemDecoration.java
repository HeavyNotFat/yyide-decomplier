package com.yd.android_brand_mvp.weight.recycleview;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes4.dex */
public class MyGirdItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {R.attr.listDivider};
    private Paint mColorPaint;
    private Drawable mDivider;
    private int mDividerHeight;

    public MyGirdItemDecoration(Context context) {
        this.mDividerHeight = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        this.mDivider = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public MyGirdItemDecoration(Context context, int i, int i2) {
        this(context);
        Paint paint = new Paint();
        this.mColorPaint = paint;
        paint.setColor(i);
        this.mDividerHeight = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawHorizontal(canvas, recyclerView);
        drawVertical(canvas, recyclerView);
    }

    private int getSpanCount(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    public void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        int spanCount = getSpanCount(recyclerView);
        if (childCount % spanCount == 0) {
            childCount -= spanCount;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int left = childAt.getLeft() - layoutParams.leftMargin;
            int right = childAt.getRight() + layoutParams.rightMargin + this.mDivider.getIntrinsicWidth();
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            int intrinsicHeight = this.mDivider.getIntrinsicHeight() + bottom;
            Paint paint = this.mColorPaint;
            if (paint != null) {
                canvas.drawRect(left, bottom, right, bottom + this.mDividerHeight, paint);
            } else {
                this.mDivider.setBounds(left, bottom, right, intrinsicHeight);
                this.mDivider.draw(canvas);
            }
        }
    }

    public void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        int spanCount = getSpanCount(recyclerView);
        for (int i = 0; i < childCount; i++) {
            if (i % spanCount != spanCount - 1) {
                View childAt = recyclerView.getChildAt(i);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int top = childAt.getTop() - layoutParams.topMargin;
                int bottom = childAt.getBottom() + layoutParams.bottomMargin;
                int right = childAt.getRight() + layoutParams.rightMargin;
                int intrinsicWidth = this.mDivider.getIntrinsicWidth() + right;
                Paint paint = this.mColorPaint;
                if (paint != null) {
                    canvas.drawRect(right, top, right + this.mDividerHeight, bottom, paint);
                } else {
                    this.mDivider.setBounds(right, top, intrinsicWidth, bottom);
                    this.mDivider.draw(canvas);
                }
            }
        }
    }

    private boolean isLastColum(RecyclerView recyclerView, int i, int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return (i + 1) % i2 == 0;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
                if ((i + 1) % i2 == 0) {
                    return true;
                }
            } else if (i >= i3 - (i3 % i2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isLastRaw(RecyclerView recyclerView, int i, int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return i >= i3 - (i3 % i2);
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1) {
                if (i >= i3 - (i3 % i2)) {
                    return true;
                }
            } else if ((i + 1) % i2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int spanCount = getSpanCount(recyclerView);
        if (recyclerView.getAdapter() == null) {
            return;
        }
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (isLastRaw(recyclerView, childAdapterPosition, spanCount, itemCount)) {
            rect.set(0, 0, this.mDivider.getIntrinsicWidth(), 0);
        } else if (isLastColum(recyclerView, childAdapterPosition, spanCount, itemCount)) {
            rect.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.mDivider.getIntrinsicWidth(), this.mDivider.getIntrinsicHeight());
        }
    }
}
