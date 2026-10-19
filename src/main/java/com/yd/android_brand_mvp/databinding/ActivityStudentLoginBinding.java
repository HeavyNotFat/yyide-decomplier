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
public final class ActivityStudentLoginBinding implements ViewBinding {
    public final CheckedTextView btn1;
    public final CheckedTextView btn2;
    public final CheckedTextView btn3;
    public final CheckedTextView btn4;
    public final FrameLayout content;
    public final LinearLayout layout4;
    public final LinearLayout layoutContent;
    public final TextView line1;
    public final TextView line2;
    public final TextView line3;
    public final TextView line4;
    private final LinearLayout rootView;
    public final LinearLayout tab1;
    public final LinearLayout tab2;
    public final LinearLayout tab3;

    private ActivityStudentLoginBinding(LinearLayout linearLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, CheckedTextView checkedTextView4, FrameLayout frameLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6) {
        this.rootView = linearLayout;
        this.btn1 = checkedTextView;
        this.btn2 = checkedTextView2;
        this.btn3 = checkedTextView3;
        this.btn4 = checkedTextView4;
        this.content = frameLayout;
        this.layout4 = linearLayout2;
        this.layoutContent = linearLayout3;
        this.line1 = textView;
        this.line2 = textView2;
        this.line3 = textView3;
        this.line4 = textView4;
        this.tab1 = linearLayout4;
        this.tab2 = linearLayout5;
        this.tab3 = linearLayout6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityStudentLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityStudentLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_student_login, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityStudentLoginBinding bind(View view) {
        int i = R.id.btn1;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.btn1);
        if (checkedTextView != null) {
            i = R.id.btn2;
            CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.btn2);
            if (checkedTextView2 != null) {
                i = R.id.btn3;
                CheckedTextView checkedTextView3 = (CheckedTextView) view.findViewById(R.id.btn3);
                if (checkedTextView3 != null) {
                    i = R.id.btn4;
                    CheckedTextView checkedTextView4 = (CheckedTextView) view.findViewById(R.id.btn4);
                    if (checkedTextView4 != null) {
                        i = R.id.content;
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
                        if (frameLayout != null) {
                            i = R.id.layout4;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout4);
                            if (linearLayout != null) {
                                i = R.id.layout_content;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout_content);
                                if (linearLayout2 != null) {
                                    i = R.id.line1;
                                    TextView textView = (TextView) view.findViewById(R.id.line1);
                                    if (textView != null) {
                                        i = R.id.line2;
                                        TextView textView2 = (TextView) view.findViewById(R.id.line2);
                                        if (textView2 != null) {
                                            i = R.id.line3;
                                            TextView textView3 = (TextView) view.findViewById(R.id.line3);
                                            if (textView3 != null) {
                                                i = R.id.line4;
                                                TextView textView4 = (TextView) view.findViewById(R.id.line4);
                                                if (textView4 != null) {
                                                    i = R.id.tab1;
                                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.tab1);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.tab2;
                                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.tab2);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.tab3;
                                                            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.tab3);
                                                            if (linearLayout5 != null) {
                                                                return new ActivityStudentLoginBinding((LinearLayout) view, checkedTextView, checkedTextView2, checkedTextView3, checkedTextView4, frameLayout, linearLayout, linearLayout2, textView, textView2, textView3, textView4, linearLayout3, linearLayout4, linearLayout5);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
