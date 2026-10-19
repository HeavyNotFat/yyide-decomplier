package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutFaceHintBinding implements ViewBinding {
    public final LinearLayout llTopHint;
    private final RelativeLayout rootView;
    public final TextView tvTopLint;

    private LayoutFaceHintBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.llTopHint = linearLayout;
        this.tvTopLint = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutFaceHintBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutFaceHintBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_face_hint, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutFaceHintBinding bind(View view) {
        int i = R.id.ll_top_hint;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_top_hint);
        if (linearLayout != null) {
            i = R.id.tv_top_lint;
            TextView textView = (TextView) view.findViewById(R.id.tv_top_lint);
            if (textView != null) {
                return new LayoutFaceHintBinding((RelativeLayout) view, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
