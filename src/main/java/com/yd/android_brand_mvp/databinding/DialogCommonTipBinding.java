package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogCommonTipBinding implements ViewBinding {
    public final TextView btnDialogCommonTipNegative;
    public final TextView btnDialogCommonTipPositive;
    private final ConstraintLayout rootView;
    public final TextView tvDialogCommonTip;

    private DialogCommonTipBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnDialogCommonTipNegative = textView;
        this.btnDialogCommonTipPositive = textView2;
        this.tvDialogCommonTip = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogCommonTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCommonTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_common_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogCommonTipBinding bind(View view) {
        int i = R.id.btn_dialog_common_tip_negative;
        TextView textView = (TextView) view.findViewById(R.id.btn_dialog_common_tip_negative);
        if (textView != null) {
            i = R.id.btn_dialog_common_tip_positive;
            TextView textView2 = (TextView) view.findViewById(R.id.btn_dialog_common_tip_positive);
            if (textView2 != null) {
                i = R.id.tv_dialog_common_tip;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_dialog_common_tip);
                if (textView3 != null) {
                    return new DialogCommonTipBinding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
