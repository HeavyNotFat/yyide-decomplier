package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemDormitoryNumberBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvClasses;
    public final TextView tvName;
    public final TextView tvNumber;

    private ItemDormitoryNumberBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvClasses = textView;
        this.tvName = textView2;
        this.tvNumber = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemDormitoryNumberBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDormitoryNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_dormitory_number, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemDormitoryNumberBinding bind(View view) {
        int i = R.id.tvClasses;
        TextView textView = (TextView) view.findViewById(R.id.tvClasses);
        if (textView != null) {
            i = R.id.tvName;
            TextView textView2 = (TextView) view.findViewById(R.id.tvName);
            if (textView2 != null) {
                i = R.id.tvNumber;
                TextView textView3 = (TextView) view.findViewById(R.id.tvNumber);
                if (textView3 != null) {
                    return new ItemDormitoryNumberBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
