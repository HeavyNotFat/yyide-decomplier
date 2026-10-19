package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityLogin3Binding implements ViewBinding {
    public final TextView config;
    public final Button go2account;
    public final TextView go2qrcode;
    public final LinearLayout llAccount;
    public final LinearLayout llQrcode;
    public final ProgressBar progress;
    public final YDEditText psd;
    public final ImageView qrcode;
    private final FrameLayout rootView;
    public final TextView tips;
    public final YDEditText user;

    private ActivityLogin3Binding(FrameLayout frameLayout, TextView textView, Button button, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, YDEditText yDEditText, ImageView imageView, TextView textView3, YDEditText yDEditText2) {
        this.rootView = frameLayout;
        this.config = textView;
        this.go2account = button;
        this.go2qrcode = textView2;
        this.llAccount = linearLayout;
        this.llQrcode = linearLayout2;
        this.progress = progressBar;
        this.psd = yDEditText;
        this.qrcode = imageView;
        this.tips = textView3;
        this.user = yDEditText2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLogin3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityLogin3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_login3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLogin3Binding bind(View view) {
        int i = R.id.config;
        TextView textView = (TextView) view.findViewById(R.id.config);
        if (textView != null) {
            i = R.id.go2account;
            Button button = (Button) view.findViewById(R.id.go2account);
            if (button != null) {
                i = R.id.go2qrcode;
                TextView textView2 = (TextView) view.findViewById(R.id.go2qrcode);
                if (textView2 != null) {
                    i = R.id.ll_account;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_account);
                    if (linearLayout != null) {
                        i = R.id.ll_qrcode;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_qrcode);
                        if (linearLayout2 != null) {
                            i = R.id.progress;
                            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);
                            if (progressBar != null) {
                                i = R.id.psd;
                                YDEditText yDEditText = (YDEditText) view.findViewById(R.id.psd);
                                if (yDEditText != null) {
                                    i = R.id.qrcode;
                                    ImageView imageView = (ImageView) view.findViewById(R.id.qrcode);
                                    if (imageView != null) {
                                        i = R.id.tips;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tips);
                                        if (textView3 != null) {
                                            i = R.id.user;
                                            YDEditText yDEditText2 = (YDEditText) view.findViewById(R.id.user);
                                            if (yDEditText2 != null) {
                                                return new ActivityLogin3Binding((FrameLayout) view, textView, button, textView2, linearLayout, linearLayout2, progressBar, yDEditText, imageView, textView3, yDEditText2);
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
