package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemBbSubjectBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvName;
    public final TextView tvNumber;

    private ItemBbSubjectBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.tvName = textView;
        this.tvNumber = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemBbSubjectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBbSubjectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_bb_subject, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemBbSubjectBinding bind(View view) {
        int i = R.id.tvName;
        TextView textView = (TextView) view.findViewById(R.id.tvName);
        if (textView != null) {
            i = R.id.tvNumber;
            TextView textView2 = (TextView) view.findViewById(R.id.tvNumber);
            if (textView2 != null) {
                return new ItemBbSubjectBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
