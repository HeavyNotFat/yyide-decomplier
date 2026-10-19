package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemFaceValueBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvDesc;
    public final TextView tvName;
    public final TextView tvStatus;

    private ItemFaceValueBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvDesc = textView;
        this.tvName = textView2;
        this.tvStatus = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemFaceValueBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemFaceValueBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_face_value, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemFaceValueBinding bind(View view) {
        int i = R.id.tvDesc;
        TextView textView = (TextView) view.findViewById(R.id.tvDesc);
        if (textView != null) {
            i = R.id.tvName;
            TextView textView2 = (TextView) view.findViewById(R.id.tvName);
            if (textView2 != null) {
                i = R.id.tvStatus;
                TextView textView3 = (TextView) view.findViewById(R.id.tvStatus);
                if (textView3 != null) {
                    return new ItemFaceValueBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
