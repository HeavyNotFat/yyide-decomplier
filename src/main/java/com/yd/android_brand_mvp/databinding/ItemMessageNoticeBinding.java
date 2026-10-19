package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMessageNoticeBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvTime;
    public final TextView tvTitle;
    public final View view;

    private ItemMessageNoticeBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.tvTime = textView;
        this.tvTitle = textView2;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemMessageNoticeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemMessageNoticeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_message_notice, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemMessageNoticeBinding bind(View view) {
        int i = R.id.tvTime;
        TextView textView = (TextView) view.findViewById(R.id.tvTime);
        if (textView != null) {
            i = R.id.tvTitle;
            TextView textView2 = (TextView) view.findViewById(R.id.tvTitle);
            if (textView2 != null) {
                i = R.id.view;
                View viewFindViewById = view.findViewById(R.id.view);
                if (viewFindViewById != null) {
                    return new ItemMessageNoticeBinding((ConstraintLayout) view, textView, textView2, viewFindViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
