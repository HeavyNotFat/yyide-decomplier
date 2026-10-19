package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemActiveApply2x4Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvActiveApplyDate;
    public final TextView tvActiveDate;
    public final TextView tvActiveObject;
    public final TextView tvActiveStatus;
    public final TextView tvActiveTitle;

    private ItemActiveApply2x4Binding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.tvActiveApplyDate = textView;
        this.tvActiveDate = textView2;
        this.tvActiveObject = textView3;
        this.tvActiveStatus = textView4;
        this.tvActiveTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemActiveApply2x4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemActiveApply2x4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_active_apply_2x4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemActiveApply2x4Binding bind(View view) {
        int i = R.id.tv_active_apply_date;
        TextView textView = (TextView) view.findViewById(R.id.tv_active_apply_date);
        if (textView != null) {
            i = R.id.tv_active_date;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_active_date);
            if (textView2 != null) {
                i = R.id.tv_active_object;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_active_object);
                if (textView3 != null) {
                    i = R.id.tv_active_status;
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_active_status);
                    if (textView4 != null) {
                        i = R.id.tv_active_title;
                        TextView textView5 = (TextView) view.findViewById(R.id.tv_active_title);
                        if (textView5 != null) {
                            return new ItemActiveApply2x4Binding((ConstraintLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
