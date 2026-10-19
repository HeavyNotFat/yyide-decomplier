package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutDialogBootTipBinding implements ViewBinding {
    public final Button btnConfirm;
    private final ConstraintLayout rootView;
    public final TextView tvTipCountdown;
    public final TextView tvTitle;

    private LayoutDialogBootTipBinding(ConstraintLayout constraintLayout, Button button, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnConfirm = button;
        this.tvTipCountdown = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDialogBootTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutDialogBootTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_boot_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutDialogBootTipBinding bind(View view) {
        int i = R.id.btnConfirm;
        Button button = (Button) view.findViewById(R.id.btnConfirm);
        if (button != null) {
            i = R.id.tvTipCountdown;
            TextView textView = (TextView) view.findViewById(R.id.tvTipCountdown);
            if (textView != null) {
                i = R.id.tvTitle;
                TextView textView2 = (TextView) view.findViewById(R.id.tvTitle);
                if (textView2 != null) {
                    return new LayoutDialogBootTipBinding((ConstraintLayout) view, button, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
