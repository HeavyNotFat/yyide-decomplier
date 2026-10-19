package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityStudentLogin2Binding implements ViewBinding {
    public final CheckedTextView btn1;
    public final CheckedTextView btn2;
    public final CheckedTextView btn3;
    public final FrameLayout content;
    public final TextView line1;
    public final TextView line2;
    public final TextView line3;
    private final LinearLayout rootView;

    private ActivityStudentLogin2Binding(LinearLayout linearLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btn1 = checkedTextView;
        this.btn2 = checkedTextView2;
        this.btn3 = checkedTextView3;
        this.content = frameLayout;
        this.line1 = textView;
        this.line2 = textView2;
        this.line3 = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityStudentLogin2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityStudentLogin2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_student_login2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityStudentLogin2Binding bind(View view) {
        int i = R.id.btn1;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.btn1);
        if (checkedTextView != null) {
            i = R.id.btn2;
            CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.btn2);
            if (checkedTextView2 != null) {
                i = R.id.btn3;
                CheckedTextView checkedTextView3 = (CheckedTextView) view.findViewById(R.id.btn3);
                if (checkedTextView3 != null) {
                    i = R.id.content;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
                    if (frameLayout != null) {
                        i = R.id.line1;
                        TextView textView = (TextView) view.findViewById(R.id.line1);
                        if (textView != null) {
                            i = R.id.line2;
                            TextView textView2 = (TextView) view.findViewById(R.id.line2);
                            if (textView2 != null) {
                                i = R.id.line3;
                                TextView textView3 = (TextView) view.findViewById(R.id.line3);
                                if (textView3 != null) {
                                    return new ActivityStudentLogin2Binding((LinearLayout) view, checkedTextView, checkedTextView2, checkedTextView3, frameLayout, textView, textView2, textView3);
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
