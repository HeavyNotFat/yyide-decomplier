package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogListMessageBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnConfirm;
    public final Guideline guideline;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvTop;
    public final View view;

    private DialogListMessageBinding(ConstraintLayout constraintLayout, Button button, Button button2, Guideline guideline, RecyclerView recyclerView, TextView textView, View view) {
        this.rootView = constraintLayout;
        this.btnCancel = button;
        this.btnConfirm = button2;
        this.guideline = guideline;
        this.recyclerView = recyclerView;
        this.tvTop = textView;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogListMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogListMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_list_message, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogListMessageBinding bind(View view) {
        int i = R.id.btn_cancel;
        Button button = (Button) view.findViewById(R.id.btn_cancel);
        if (button != null) {
            i = R.id.btn_confirm;
            Button button2 = (Button) view.findViewById(R.id.btn_confirm);
            if (button2 != null) {
                i = R.id.guideline;
                Guideline guideline = (Guideline) view.findViewById(R.id.guideline);
                if (guideline != null) {
                    i = R.id.recyclerView;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                    if (recyclerView != null) {
                        i = R.id.tvTop;
                        TextView textView = (TextView) view.findViewById(R.id.tvTop);
                        if (textView != null) {
                            i = R.id.view;
                            View viewFindViewById = view.findViewById(R.id.view);
                            if (viewFindViewById != null) {
                                return new DialogListMessageBinding((ConstraintLayout) view, button, button2, guideline, recyclerView, textView, viewFindViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
