package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewCollectFormCheckBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvViewCollectFormCheckOption;
    public final TextView tvViewCollectFormCheckName;
    public final TextView tvViewCollectFormCheckRequired;

    private ViewCollectFormCheckBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.rvViewCollectFormCheckOption = recyclerView;
        this.tvViewCollectFormCheckName = textView;
        this.tvViewCollectFormCheckRequired = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormCheckBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormCheckBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_check, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormCheckBinding bind(View view) {
        int i = R.id.rv_view_collect_form_check_option;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_view_collect_form_check_option);
        if (recyclerView != null) {
            i = R.id.tv_view_collect_form_check_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_view_collect_form_check_name);
            if (textView != null) {
                i = R.id.tv_view_collect_form_check_required;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_check_required);
                if (textView2 != null) {
                    return new ViewCollectFormCheckBinding((ConstraintLayout) view, recyclerView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
