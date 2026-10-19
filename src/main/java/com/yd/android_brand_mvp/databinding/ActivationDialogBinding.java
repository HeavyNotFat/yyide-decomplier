package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivationDialogBinding implements ViewBinding {
    public final YDEditText activationEdittext;
    public final TextView activotionTitle;
    public final Button btnDialogActivationSubmit;
    public final TextView getActivationCode;
    public final TextView noActivationCode;
    private final ConstraintLayout rootView;

    private ActivationDialogBinding(ConstraintLayout constraintLayout, YDEditText yDEditText, TextView textView, Button button, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.activationEdittext = yDEditText;
        this.activotionTitle = textView;
        this.btnDialogActivationSubmit = button;
        this.getActivationCode = textView2;
        this.noActivationCode = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivationDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivationDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activation_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivationDialogBinding bind(View view) {
        int i = R.id.activation_edittext;
        YDEditText yDEditText = (YDEditText) view.findViewById(R.id.activation_edittext);
        if (yDEditText != null) {
            i = R.id.activotionTitle;
            TextView textView = (TextView) view.findViewById(R.id.activotionTitle);
            if (textView != null) {
                i = R.id.btn_dialog_activation_submit;
                Button button = (Button) view.findViewById(R.id.btn_dialog_activation_submit);
                if (button != null) {
                    i = R.id.getActivationCode;
                    TextView textView2 = (TextView) view.findViewById(R.id.getActivationCode);
                    if (textView2 != null) {
                        i = R.id.noActivationCode;
                        TextView textView3 = (TextView) view.findViewById(R.id.noActivationCode);
                        if (textView3 != null) {
                            return new ActivationDialogBinding((ConstraintLayout) view, yDEditText, textView, button, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
