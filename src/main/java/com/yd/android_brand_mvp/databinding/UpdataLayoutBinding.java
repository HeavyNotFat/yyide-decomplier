package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdataLayoutBinding implements ViewBinding {
    public final TextView close;
    public final FrameLayout contentLayout;
    private final LinearLayout rootView;
    public final TextView version;

    private UpdataLayoutBinding(LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, TextView textView2) {
        this.rootView = linearLayout;
        this.close = textView;
        this.contentLayout = frameLayout;
        this.version = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UpdataLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UpdataLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.updata_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UpdataLayoutBinding bind(View view) {
        int i = R.id.close;
        TextView textView = (TextView) view.findViewById(R.id.close);
        if (textView != null) {
            i = R.id.content_layout;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
            if (frameLayout != null) {
                i = R.id.version;
                TextView textView2 = (TextView) view.findViewById(R.id.version);
                if (textView2 != null) {
                    return new UpdataLayoutBinding((LinearLayout) view, textView, frameLayout, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
