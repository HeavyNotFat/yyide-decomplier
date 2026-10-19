package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewCollectFormSingleSelectBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvViewCollectFormSelect;
    public final TextView tvViewCollectFormSelectName;
    public final TextView tvViewCollectFormSelectRequired;

    private ViewCollectFormSingleSelectBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvViewCollectFormSelect = textView;
        this.tvViewCollectFormSelectName = textView2;
        this.tvViewCollectFormSelectRequired = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormSingleSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormSingleSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_single_select, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormSingleSelectBinding bind(View view) {
        int i = R.id.tv_view_collect_form_select;
        TextView textView = (TextView) view.findViewById(R.id.tv_view_collect_form_select);
        if (textView != null) {
            i = R.id.tv_view_collect_form_select_name;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_select_name);
            if (textView2 != null) {
                i = R.id.tv_view_collect_form_select_required;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_view_collect_form_select_required);
                if (textView3 != null) {
                    return new ViewCollectFormSingleSelectBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
