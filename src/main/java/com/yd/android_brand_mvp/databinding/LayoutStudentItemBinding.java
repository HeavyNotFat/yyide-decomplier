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
public final class LayoutStudentItemBinding implements ViewBinding {
    public final ImageView img;
    public final TextView msg;
    public final TextView name;
    private final LinearLayout rootView;

    private LayoutStudentItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.img = imageView;
        this.msg = textView;
        this.name = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutStudentItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutStudentItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_student_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutStudentItemBinding bind(View view) {
        int i = R.id.img;
        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        if (imageView != null) {
            i = R.id.msg;
            TextView textView = (TextView) view.findViewById(R.id.msg);
            if (textView != null) {
                i = R.id.name;
                TextView textView2 = (TextView) view.findViewById(R.id.name);
                if (textView2 != null) {
                    return new LayoutStudentItemBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
