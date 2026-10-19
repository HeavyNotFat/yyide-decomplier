package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemRepairListBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvItemRepairListName;
    public final TextView tvItemRepairListStatus;
    public final TextView tvItemRepairListTime;

    private ItemRepairListBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvItemRepairListName = textView;
        this.tvItemRepairListStatus = textView2;
        this.tvItemRepairListTime = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemRepairListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemRepairListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_repair_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemRepairListBinding bind(View view) {
        int i = R.id.tv_item_repair_list_name;
        TextView textView = (TextView) view.findViewById(R.id.tv_item_repair_list_name);
        if (textView != null) {
            i = R.id.tv_item_repair_list_status;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_repair_list_status);
            if (textView2 != null) {
                i = R.id.tv_item_repair_list_time;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_item_repair_list_time);
                if (textView3 != null) {
                    return new ItemRepairListBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
