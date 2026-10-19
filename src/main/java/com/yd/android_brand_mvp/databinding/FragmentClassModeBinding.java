package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassModeBinding implements ViewBinding {
    public final TextView gankTextview2;
    public final ImageView ivBg;
    private final ConstraintLayout rootView;
    public final TextView tv1;
    public final TextView tvClassName;
    public final TextView tvClassTime;
    public final TextView tvTeacherName;

    private FragmentClassModeBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.gankTextview2 = textView;
        this.ivBg = imageView;
        this.tv1 = textView2;
        this.tvClassName = textView3;
        this.tvClassTime = textView4;
        this.tvTeacherName = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassModeBinding bind(View view) {
        int i = R.id.gank_textview2;
        TextView textView = (TextView) view.findViewById(R.id.gank_textview2);
        if (textView != null) {
            i = R.id.ivBg;
            ImageView imageView = (ImageView) view.findViewById(R.id.ivBg);
            if (imageView != null) {
                i = R.id.tv1;
                TextView textView2 = (TextView) view.findViewById(R.id.tv1);
                if (textView2 != null) {
                    i = R.id.tv_class_name;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_class_name);
                    if (textView3 != null) {
                        i = R.id.tv_class_time;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_class_time);
                        if (textView4 != null) {
                            i = R.id.tv_teacher_name;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_teacher_name);
                            if (textView5 != null) {
                                return new FragmentClassModeBinding((ConstraintLayout) view, textView, imageView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
