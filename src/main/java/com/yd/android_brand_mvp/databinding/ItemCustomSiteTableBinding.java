package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCustomSiteTableBinding implements ViewBinding {
    public final ConstraintLayout layoutTableItem;
    private final ConstraintLayout rootView;
    public final TextView tvTableName;
    public final TextView tvTableTime;
    public final TextView tvTeacherName;

    private ItemCustomSiteTableBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.layoutTableItem = constraintLayout2;
        this.tvTableName = textView;
        this.tvTableTime = textView2;
        this.tvTeacherName = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemCustomSiteTableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemCustomSiteTableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_custom_site_table, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCustomSiteTableBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.tv_table_name;
        TextView textView = (TextView) view.findViewById(R.id.tv_table_name);
        if (textView != null) {
            i = R.id.tv_table_time;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_table_time);
            if (textView2 != null) {
                i = R.id.tv_teacher_name;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_teacher_name);
                if (textView3 != null) {
                    return new ItemCustomSiteTableBinding(constraintLayout, constraintLayout, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
