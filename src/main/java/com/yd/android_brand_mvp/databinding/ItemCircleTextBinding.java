package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.TextCircleImage;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCircleTextBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextCircleImage tvCircleName;
    public final TextView tvName;

    private ItemCircleTextBinding(ConstraintLayout constraintLayout, TextCircleImage textCircleImage, TextView textView) {
        this.rootView = constraintLayout;
        this.tvCircleName = textCircleImage;
        this.tvName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemCircleTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemCircleTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_circle_text, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCircleTextBinding bind(View view) {
        int i = R.id.tvCircleName;
        TextCircleImage textCircleImage = (TextCircleImage) view.findViewById(R.id.tvCircleName);
        if (textCircleImage != null) {
            i = R.id.tvName;
            TextView textView = (TextView) view.findViewById(R.id.tvName);
            if (textView != null) {
                return new ItemCircleTextBinding((ConstraintLayout) view, textCircleImage, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
