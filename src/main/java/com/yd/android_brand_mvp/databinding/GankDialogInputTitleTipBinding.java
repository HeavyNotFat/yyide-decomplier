package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class GankDialogInputTitleTipBinding implements ViewBinding {
    public final Button btnDialogMessageCancel;
    public final Button btnDialogMessageSubmit;
    public final EditText etDialogInputTitle;
    private final ConstraintLayout rootView;

    private GankDialogInputTitleTipBinding(ConstraintLayout constraintLayout, Button button, Button button2, EditText editText) {
        this.rootView = constraintLayout;
        this.btnDialogMessageCancel = button;
        this.btnDialogMessageSubmit = button2;
        this.etDialogInputTitle = editText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GankDialogInputTitleTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GankDialogInputTitleTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.gank_dialog_input_title_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static GankDialogInputTitleTipBinding bind(View view) {
        int i = R.id.btn_dialog_message_cancel;
        Button button = (Button) view.findViewById(R.id.btn_dialog_message_cancel);
        if (button != null) {
            i = R.id.btn_dialog_message_submit;
            Button button2 = (Button) view.findViewById(R.id.btn_dialog_message_submit);
            if (button2 != null) {
                i = R.id.et_dialog_input_title;
                EditText editText = (EditText) view.findViewById(R.id.et_dialog_input_title);
                if (editText != null) {
                    return new GankDialogInputTitleTipBinding((ConstraintLayout) view, button, button2, editText);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
