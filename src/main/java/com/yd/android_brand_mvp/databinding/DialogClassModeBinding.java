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
public final class DialogClassModeBinding implements ViewBinding {
    public final ConstraintLayout gankConstraintlayout2;
    public final ImageView ivView;
    private final ConstraintLayout rootView;
    public final TextView tvAttendClass;
    public final TextView tvCountdown;
    public final TextView tvSubject;
    public final TextView tvTeacherName;

    private DialogClassModeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.gankConstraintlayout2 = constraintLayout2;
        this.ivView = imageView;
        this.tvAttendClass = textView;
        this.tvCountdown = textView2;
        this.tvSubject = textView3;
        this.tvTeacherName = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogClassModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogClassModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_class_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogClassModeBinding bind(View view) {
        int i = R.id.gank_constraintlayout2;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.gank_constraintlayout2);
        if (constraintLayout != null) {
            i = R.id.ivView;
            ImageView imageView = (ImageView) view.findViewById(R.id.ivView);
            if (imageView != null) {
                i = R.id.tvAttendClass;
                TextView textView = (TextView) view.findViewById(R.id.tvAttendClass);
                if (textView != null) {
                    i = R.id.tv_countdown;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_countdown);
                    if (textView2 != null) {
                        i = R.id.tv_subject;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_subject);
                        if (textView3 != null) {
                            i = R.id.tv_teacher_name;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_teacher_name);
                            if (textView4 != null) {
                                return new DialogClassModeBinding((ConstraintLayout) view, constraintLayout, imageView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
