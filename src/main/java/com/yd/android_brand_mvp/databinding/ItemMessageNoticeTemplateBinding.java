package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemMessageNoticeTemplateBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvDate;
    public final TextView tvTitle;
    public final TextView tvTop;

    private ItemMessageNoticeTemplateBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvDate = textView;
        this.tvTitle = textView2;
        this.tvTop = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemMessageNoticeTemplateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemMessageNoticeTemplateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_message_notice_template, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemMessageNoticeTemplateBinding bind(View view) {
        int i = R.id.tvDate;
        TextView textView = (TextView) view.findViewById(R.id.tvDate);
        if (textView != null) {
            i = R.id.tvTitle;
            TextView textView2 = (TextView) view.findViewById(R.id.tvTitle);
            if (textView2 != null) {
                i = R.id.tvTop;
                TextView textView3 = (TextView) view.findViewById(R.id.tvTop);
                if (textView3 != null) {
                    return new ItemMessageNoticeTemplateBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
