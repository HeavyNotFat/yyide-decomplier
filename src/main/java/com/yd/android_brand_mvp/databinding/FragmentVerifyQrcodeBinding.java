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
public final class FragmentVerifyQrcodeBinding implements ViewBinding {
    public final ImageView ivFragmentVerifyQrCode;
    private final ConstraintLayout rootView;
    public final TextView tvFragmentVerifyQrcodeRequest;

    private FragmentVerifyQrcodeBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivFragmentVerifyQrCode = imageView;
        this.tvFragmentVerifyQrcodeRequest = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVerifyQrcodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentVerifyQrcodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_verify_qrcode, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentVerifyQrcodeBinding bind(View view) {
        int i = R.id.iv_fragment_verify_qrCode;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_verify_qrCode);
        if (imageView != null) {
            i = R.id.tv_fragment_verify_qrcode_request;
            TextView textView = (TextView) view.findViewById(R.id.tv_fragment_verify_qrcode_request);
            if (textView != null) {
                return new FragmentVerifyQrcodeBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
