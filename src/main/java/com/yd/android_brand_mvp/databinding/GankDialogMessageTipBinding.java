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
public final class GankDialogMessageTipBinding implements ViewBinding {
    public final Button btnDialogMessageSubmit;
    private final ConstraintLayout rootView;
    public final TextView tvDialogMessageTip;

    private GankDialogMessageTipBinding(ConstraintLayout constraintLayout, Button button, TextView textView) {
        this.rootView = constraintLayout;
        this.btnDialogMessageSubmit = button;
        this.tvDialogMessageTip = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GankDialogMessageTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GankDialogMessageTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.gank_dialog_message_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static GankDialogMessageTipBinding bind(View view) {
        int i = R.id.btn_dialog_message_submit;
        Button button = (Button) view.findViewById(R.id.btn_dialog_message_submit);
        if (button != null) {
            i = R.id.tv_dialog_message_tip;
            TextView textView = (TextView) view.findViewById(R.id.tv_dialog_message_tip);
            if (textView != null) {
                return new GankDialogMessageTipBinding((ConstraintLayout) view, button, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
