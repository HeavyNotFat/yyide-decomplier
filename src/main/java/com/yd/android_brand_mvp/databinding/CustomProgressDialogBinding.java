package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class CustomProgressDialogBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvMessage;
    public final ProgressBar updateProgress;

    private CustomProgressDialogBinding(LinearLayout linearLayout, TextView textView, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.tvMessage = textView;
        this.updateProgress = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomProgressDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CustomProgressDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.custom_progress_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomProgressDialogBinding bind(View view) {
        int i = R.id.tv_message;
        TextView textView = (TextView) view.findViewById(R.id.tv_message);
        if (textView != null) {
            i = R.id.update_progress;
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.update_progress);
            if (progressBar != null) {
                return new CustomProgressDialogBinding((LinearLayout) view, textView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
