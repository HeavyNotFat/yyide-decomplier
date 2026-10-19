package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutTableItem22lBinding implements ViewBinding {
    public final ConstraintLayout clContent;
    private final ConstraintLayout rootView;
    public final TextView tvTableName;
    public final TextView tvTeacherName;
    public final TextView tvTime;

    private LayoutTableItem22lBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.tvTableName = textView;
        this.tvTeacherName = textView2;
        this.tvTime = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTableItem22lBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTableItem22lBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_table_item2_2l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutTableItem22lBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.tvTableName;
        TextView textView = (TextView) view.findViewById(R.id.tvTableName);
        if (textView != null) {
            i = R.id.tvTeacherName;
            TextView textView2 = (TextView) view.findViewById(R.id.tvTeacherName);
            if (textView2 != null) {
                i = R.id.tvTime;
                TextView textView3 = (TextView) view.findViewById(R.id.tvTime);
                if (textView3 != null) {
                    return new LayoutTableItem22lBinding(constraintLayout, constraintLayout, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
