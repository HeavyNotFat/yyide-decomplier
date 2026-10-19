package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentVerificationCodeBinding implements ViewBinding {
    public final TextView btnConfirm;
    public final EditText editText;
    public final ImageView ivQrcode;
    private final ConstraintLayout rootView;
    public final TextView tvCountdown;

    private FragmentVerificationCodeBinding(ConstraintLayout constraintLayout, TextView textView, EditText editText, ImageView imageView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnConfirm = textView;
        this.editText = editText;
        this.ivQrcode = imageView;
        this.tvCountdown = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVerificationCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentVerificationCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_verification_code, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentVerificationCodeBinding bind(View view) {
        int i = R.id.btnConfirm;
        TextView textView = (TextView) view.findViewById(R.id.btnConfirm);
        if (textView != null) {
            i = R.id.editText;
            EditText editText = (EditText) view.findViewById(R.id.editText);
            if (editText != null) {
                i = R.id.ivQrcode;
                ImageView imageView = (ImageView) view.findViewById(R.id.ivQrcode);
                if (imageView != null) {
                    i = R.id.tvCountdown;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvCountdown);
                    if (textView2 != null) {
                        return new FragmentVerificationCodeBinding((ConstraintLayout) view, textView, editText, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
