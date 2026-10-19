package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassesOverBinding implements ViewBinding {
    public final Button btnOver;
    public final ConstraintLayout content;
    public final ImageView imageView11;
    public final CircularProgressIndicator progressBar;
    private final ConstraintLayout rootView;
    public final TextView textView32;
    public final TextView tvClassName;
    public final TextView tvDesc;
    public final View view4;

    private FragmentClassesOverBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ImageView imageView, CircularProgressIndicator circularProgressIndicator, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = constraintLayout;
        this.btnOver = button;
        this.content = constraintLayout2;
        this.imageView11 = imageView;
        this.progressBar = circularProgressIndicator;
        this.textView32 = textView;
        this.tvClassName = textView2;
        this.tvDesc = textView3;
        this.view4 = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassesOverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassesOverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_classes_over, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassesOverBinding bind(View view) {
        int i = R.id.btn_over;
        Button button = (Button) view.findViewById(R.id.btn_over);
        if (button != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.imageView11;
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView11);
            if (imageView != null) {
                i = R.id.progressBar;
                CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) view.findViewById(R.id.progressBar);
                if (circularProgressIndicator != null) {
                    i = R.id.textView32;
                    TextView textView = (TextView) view.findViewById(R.id.textView32);
                    if (textView != null) {
                        i = R.id.tv_class_name;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_class_name);
                        if (textView2 != null) {
                            i = R.id.tv_desc;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_desc);
                            if (textView3 != null) {
                                i = R.id.view4;
                                View viewFindViewById = view.findViewById(R.id.view4);
                                if (viewFindViewById != null) {
                                    return new FragmentClassesOverBinding(constraintLayout, button, constraintLayout, imageView, circularProgressIndicator, textView, textView2, textView3, viewFindViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
