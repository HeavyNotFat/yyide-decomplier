package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityRegisterBinding implements ViewBinding {
    public final TextView activateBtn;
    public final TextView config;
    public final TextView getCode;
    public final LinearLayout llAccount;
    public final ProgressBar progress;
    public final YDEditText register;
    public final TextView registerBtn;
    private final FrameLayout rootView;
    public final TextView tips;

    private ActivityRegisterBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, ProgressBar progressBar, YDEditText yDEditText, TextView textView4, TextView textView5) {
        this.rootView = frameLayout;
        this.activateBtn = textView;
        this.config = textView2;
        this.getCode = textView3;
        this.llAccount = linearLayout;
        this.progress = progressBar;
        this.register = yDEditText;
        this.registerBtn = textView4;
        this.tips = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRegisterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRegisterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_register, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRegisterBinding bind(View view) {
        int i = R.id.activateBtn;
        TextView textView = (TextView) view.findViewById(R.id.activateBtn);
        if (textView != null) {
            i = R.id.config;
            TextView textView2 = (TextView) view.findViewById(R.id.config);
            if (textView2 != null) {
                i = R.id.getCode;
                TextView textView3 = (TextView) view.findViewById(R.id.getCode);
                if (textView3 != null) {
                    i = R.id.ll_account;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_account);
                    if (linearLayout != null) {
                        i = R.id.progress;
                        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);
                        if (progressBar != null) {
                            i = R.id.register;
                            YDEditText yDEditText = (YDEditText) view.findViewById(R.id.register);
                            if (yDEditText != null) {
                                i = R.id.registerBtn;
                                TextView textView4 = (TextView) view.findViewById(R.id.registerBtn);
                                if (textView4 != null) {
                                    i = R.id.tips;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tips);
                                    if (textView5 != null) {
                                        return new ActivityRegisterBinding((FrameLayout) view, textView, textView2, textView3, linearLayout, progressBar, yDEditText, textView4, textView5);
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
