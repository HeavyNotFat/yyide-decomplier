package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListenerConstraint.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/view/ListenerConstraint;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOnInterceptTouchEventListener", "Lcom/yd/android_brand_mvp/view/OnInterceptTouchEventListener;", "getMOnInterceptTouchEventListener", "()Lcom/yd/android_brand_mvp/view/OnInterceptTouchEventListener;", "setMOnInterceptTouchEventListener", "(Lcom/yd/android_brand_mvp/view/OnInterceptTouchEventListener;)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ListenerConstraint extends ConstraintLayout {
    private OnInterceptTouchEventListener mOnInterceptTouchEventListener;

    public final OnInterceptTouchEventListener getMOnInterceptTouchEventListener() {
        return this.mOnInterceptTouchEventListener;
    }

    public final void setMOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.mOnInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListenerConstraint(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenerConstraint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.mOnInterceptTouchEventListener;
        if (onInterceptTouchEventListener != null) {
            return onInterceptTouchEventListener.onInterceptTouchEvent(ev);
        }
        return false;
    }
}
