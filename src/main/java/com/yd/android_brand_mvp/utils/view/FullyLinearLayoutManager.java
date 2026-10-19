package com.yd.android_brand_mvp.utils.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes4.dex */
public class FullyLinearLayoutManager extends LinearLayoutManager {
    private static final int CHILD_HEIGHT = 1;
    private static final int CHILD_WIDTH = 0;
    private static final int DEFAULT_CHILD_SIZE = 100;
    private static boolean canMakeInsetsDirty = true;
    private static Field insetsDirtyField;
    private final int[] childDimensions;
    private int childSize;
    private boolean hasChildSize;
    private int overScrollMode;
    private final Rect tmpRect;
    private final RecyclerView view;

    private void logMeasureWarning(int i) {
    }

    public FullyLinearLayoutManager(Context context) {
        super(context);
        this.childDimensions = new int[2];
        this.childSize = 100;
        this.overScrollMode = 0;
        this.tmpRect = new Rect();
        this.view = null;
    }

    public FullyLinearLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        this.childDimensions = new int[2];
        this.childSize = 100;
        this.overScrollMode = 0;
        this.tmpRect = new Rect();
        this.view = null;
    }

    public FullyLinearLayoutManager(RecyclerView recyclerView) {
        super(recyclerView.getContext());
        this.childDimensions = new int[2];
        this.childSize = 100;
        this.overScrollMode = 0;
        this.tmpRect = new Rect();
        this.view = recyclerView;
        this.overScrollMode = ViewCompat.getOverScrollMode(recyclerView);
    }

    public FullyLinearLayoutManager(RecyclerView recyclerView, int i, boolean z) {
        super(recyclerView.getContext(), i, z);
        this.childDimensions = new int[2];
        this.childSize = 100;
        this.overScrollMode = 0;
        this.tmpRect = new Rect();
        this.view = recyclerView;
        this.overScrollMode = ViewCompat.getOverScrollMode(recyclerView);
    }

    public void setOverScrollMode(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Unknown overscroll mode: " + i);
        }
        RecyclerView recyclerView = this.view;
        if (recyclerView == null) {
            throw new IllegalStateException("view == null");
        }
        this.overScrollMode = i;
        ViewCompat.setOverScrollMode(recyclerView, i);
    }

    public static int makeUnspecifiedSpec() {
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int paddingLeft;
        int paddingTop;
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        char c = 1;
        boolean z = mode != 0;
        boolean z2 = mode2 != 0;
        boolean z3 = mode == 1073741824;
        boolean z4 = mode2 == 1073741824;
        int iMakeUnspecifiedSpec = makeUnspecifiedSpec();
        if (z3 && z4) {
            super.onMeasure(recycler, state, i, i2);
            return;
        }
        boolean z5 = getOrientation() == 1;
        initChildDimensions(size, size2, z5);
        recycler.clear();
        int itemCount = state.getItemCount();
        int itemCount2 = getItemCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i5 >= itemCount2) {
                z5 = z5;
                break;
            }
            if (z5) {
                if (this.hasChildSize) {
                    i4 = i5;
                } else if (i5 < itemCount) {
                    measureChild(recycler, i5, size, iMakeUnspecifiedSpec, this.childDimensions);
                    i4 = i5;
                } else {
                    i4 = i5;
                    logMeasureWarning(i4);
                }
                int[] iArr = this.childDimensions;
                int i8 = i7 + iArr[c];
                if (i4 == 0) {
                    i6 = iArr[0];
                }
                if (z2 && i8 >= size2) {
                    i7 = i8;
                    break;
                }
                i7 = i8;
                i3 = i4;
                i5 = i3 + 1;
                itemCount2 = itemCount2;
                itemCount = itemCount;
                z5 = z5;
                c = 1;
            } else {
                itemCount2 = itemCount2;
                itemCount = itemCount;
                z5 = z5;
                int i9 = i5;
                if (this.hasChildSize) {
                    i3 = i9;
                } else if (i9 < itemCount) {
                    itemCount = itemCount;
                    i3 = i9;
                    measureChild(recycler, i9, iMakeUnspecifiedSpec, size2, this.childDimensions);
                } else {
                    itemCount = itemCount;
                    i3 = i9;
                    logMeasureWarning(i3);
                }
                int[] iArr2 = this.childDimensions;
                int i10 = i6 + iArr2[0];
                if (i3 == 0) {
                    i7 = iArr2[1];
                }
                if (z && i10 >= size) {
                    i6 = i10;
                    break;
                }
                i6 = i10;
                i5 = i3 + 1;
                itemCount2 = itemCount2;
                itemCount = itemCount;
                z5 = z5;
                c = 1;
            }
        }
        if (z3) {
            paddingLeft = size;
        } else {
            paddingLeft = i6 + getPaddingLeft() + getPaddingRight();
            if (z) {
                paddingLeft = Math.min(paddingLeft, size);
            }
        }
        if (z4) {
            paddingTop = size2;
        } else {
            paddingTop = i7 + getPaddingTop() + getPaddingBottom();
            if (z2) {
                paddingTop = Math.min(paddingTop, size2);
            }
        }
        setMeasuredDimension(paddingLeft, paddingTop);
        if (this.view == null || this.overScrollMode != 1) {
            return;
        }
        ViewCompat.setOverScrollMode(this.view, (z5 && (!z2 || paddingTop < size2)) || (!z5 && (!z || paddingLeft < size)) ? 2 : 0);
    }

    private void initChildDimensions(int i, int i2, boolean z) {
        int[] iArr = this.childDimensions;
        if (iArr[0] == 0 && iArr[1] == 0) {
            if (z) {
                iArr[0] = i;
                iArr[1] = this.childSize;
            } else {
                iArr[0] = this.childSize;
                iArr[1] = i2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setOrientation(int i) {
        if (this.childDimensions != null && getOrientation() != i) {
            int[] iArr = this.childDimensions;
            iArr[0] = 0;
            iArr[1] = 0;
        }
        super.setOrientation(i);
    }

    public void clearChildSize() {
        this.hasChildSize = false;
        setChildSize(100);
    }

    public void setChildSize(int i) {
        this.hasChildSize = true;
        if (this.childSize != i) {
            this.childSize = i;
            requestLayout();
        }
    }

    private void measureChild(RecyclerView.Recycler recycler, int i, int i2, int i3, int[] iArr) {
        try {
            View viewForPosition = recycler.getViewForPosition(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int i4 = layoutParams.leftMargin + layoutParams.rightMargin;
            int i5 = layoutParams.topMargin + layoutParams.bottomMargin;
            makeInsetsDirty(layoutParams);
            calculateItemDecorationsForChild(viewForPosition, this.tmpRect);
            viewForPosition.measure(getChildMeasureSpec(i2, paddingLeft + i4 + getRightDecorationWidth(viewForPosition) + getLeftDecorationWidth(viewForPosition), layoutParams.width, canScrollHorizontally()), getChildMeasureSpec(i3, paddingTop + i5 + getTopDecorationHeight(viewForPosition) + getBottomDecorationHeight(viewForPosition), layoutParams.height, canScrollVertically()));
            iArr[0] = getDecoratedMeasuredWidth(viewForPosition) + layoutParams.leftMargin + layoutParams.rightMargin;
            iArr[1] = getDecoratedMeasuredHeight(viewForPosition) + layoutParams.bottomMargin + layoutParams.topMargin;
            makeInsetsDirty(layoutParams);
            recycler.recycleView(viewForPosition);
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private static void makeInsetsDirty(RecyclerView.LayoutParams layoutParams) {
        if (canMakeInsetsDirty) {
            try {
                if (insetsDirtyField == null) {
                    Field declaredField = RecyclerView.LayoutParams.class.getDeclaredField("mInsetsDirty");
                    insetsDirtyField = declaredField;
                    declaredField.setAccessible(true);
                }
                insetsDirtyField.set(layoutParams, true);
            } catch (IllegalAccessException unused) {
                onMakeInsertDirtyFailed();
            } catch (NoSuchFieldException unused2) {
                onMakeInsertDirtyFailed();
            }
        }
    }

    private static void onMakeInsertDirtyFailed() {
        canMakeInsetsDirty = false;
    }
}
