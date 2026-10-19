package com.yd.android_brand_mvp.landscape.moraleducation.custom.view;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmoothScrollLayoutManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/custom/view/SmoothScrollLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "smoothScrollToPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "position", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SmoothScrollLayoutManager extends LinearLayoutManager {
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothScrollLayoutManager(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        final Context context = recyclerView.getContext();
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(context) { // from class: com.yd.android_brand_mvp.landscape.moraleducation.custom.view.SmoothScrollLayoutManager$smoothScrollToPosition$smoothScroller$1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
                return 150.0f / displayMetrics.densityDpi;
            }
        };
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }
}
