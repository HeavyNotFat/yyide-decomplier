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
public final class FragmentScanCodeLoginBinding implements ViewBinding {
    public final ImageView qrcode;
    private final ConstraintLayout rootView;
    public final TextView tvMsg;

    private FragmentScanCodeLoginBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.qrcode = imageView;
        this.tvMsg = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentScanCodeLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentScanCodeLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_scan_code_login, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentScanCodeLoginBinding bind(View view) {
        int i = R.id.qrcode;
        ImageView imageView = (ImageView) view.findViewById(R.id.qrcode);
        if (imageView != null) {
            i = R.id.tvMsg;
            TextView textView = (TextView) view.findViewById(R.id.tvMsg);
            if (textView != null) {
                return new FragmentScanCodeLoginBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
