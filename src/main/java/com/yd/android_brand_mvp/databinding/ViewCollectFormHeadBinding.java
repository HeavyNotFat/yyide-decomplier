package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewCollectFormHeadBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvViewCollectFormHeadTip;
    public final TextView tvViewCollectFormHeadTitle;

    private ViewCollectFormHeadBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.tvViewCollectFormHeadTip = textView;
        this.tvViewCollectFormHeadTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormHeadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_head, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormHeadBinding bind(View view) {
        int i = R.id.tv_view_collect_form_head_tip;
        TextView textView = (TextView) view.findViewById(R.id.tv_view_collect_form_head_tip);
        if (textView != null) {
            i = R.id.tv_view_collect_form_head_title;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_head_title);
            if (textView2 != null) {
                return new ViewCollectFormHeadBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
