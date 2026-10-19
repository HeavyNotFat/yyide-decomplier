package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdataProgressBinding implements ViewBinding {
    public final FrameLayout contentLayout;
    public final TextView message;
    public final TextView pause;
    private final LinearLayout rootView;
    public final ProgressBar updateProgress;

    private UpdataProgressBinding(LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, TextView textView2, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.contentLayout = frameLayout;
        this.message = textView;
        this.pause = textView2;
        this.updateProgress = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UpdataProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UpdataProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.updata_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UpdataProgressBinding bind(View view) {
        int i = R.id.content_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
        if (frameLayout != null) {
            i = R.id.message;
            TextView textView = (TextView) view.findViewById(R.id.message);
            if (textView != null) {
                i = R.id.pause;
                TextView textView2 = (TextView) view.findViewById(R.id.pause);
                if (textView2 != null) {
                    i = R.id.update_progress;
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.update_progress);
                    if (progressBar != null) {
                        return new UpdataProgressBinding((LinearLayout) view, frameLayout, textView, textView2, progressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
