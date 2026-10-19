package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemActiveApply2x2Binding implements ViewBinding {
    private final LinearLayoutCompat rootView;
    public final TextView tvActiveName;
    public final TextView tvActiveStatus;

    private ItemActiveApply2x2Binding(LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2) {
        this.rootView = linearLayoutCompat;
        this.tvActiveName = textView;
        this.tvActiveStatus = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ItemActiveApply2x2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemActiveApply2x2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_active_apply_2x2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemActiveApply2x2Binding bind(View view) {
        int i = R.id.tv_active_name;
        TextView textView = (TextView) view.findViewById(R.id.tv_active_name);
        if (textView != null) {
            i = R.id.tv_active_status;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_active_status);
            if (textView2 != null) {
                return new ItemActiveApply2x2Binding((LinearLayoutCompat) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
