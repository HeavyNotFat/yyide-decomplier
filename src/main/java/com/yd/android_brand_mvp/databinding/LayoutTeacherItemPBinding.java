package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutTeacherItemPBinding implements ViewBinding {
    public final ImageView img;
    public final TextView name;
    private final LinearLayout rootView;
    public final TextView type;

    private LayoutTeacherItemPBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.img = imageView;
        this.name = textView;
        this.type = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTeacherItemPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTeacherItemPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_teacher_item_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutTeacherItemPBinding bind(View view) {
        int i = R.id.img;
        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        if (imageView != null) {
            i = R.id.name;
            TextView textView = (TextView) view.findViewById(R.id.name);
            if (textView != null) {
                i = R.id.type;
                TextView textView2 = (TextView) view.findViewById(R.id.type);
                if (textView2 != null) {
                    return new LayoutTeacherItemPBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
