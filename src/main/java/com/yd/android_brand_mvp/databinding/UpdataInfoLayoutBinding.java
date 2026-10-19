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
public final class UpdataInfoLayoutBinding implements ViewBinding {
    public final TextView cancel;
    public final TextView close;
    public final FrameLayout contentLayout;
    public final TextView qd;
    private final LinearLayout rootView;
    public final TextView version;

    private UpdataInfoLayoutBinding(LinearLayout linearLayout, TextView textView, TextView textView2, FrameLayout frameLayout, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.cancel = textView;
        this.close = textView2;
        this.contentLayout = frameLayout;
        this.qd = textView3;
        this.version = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UpdataInfoLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UpdataInfoLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.updata_info_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UpdataInfoLayoutBinding bind(View view) {
        int i = R.id.cancel;
        TextView textView = (TextView) view.findViewById(R.id.cancel);
        if (textView != null) {
            i = R.id.close;
            TextView textView2 = (TextView) view.findViewById(R.id.close);
            if (textView2 != null) {
                i = R.id.content_layout;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
                if (frameLayout != null) {
                    i = R.id.qd;
                    TextView textView3 = (TextView) view.findViewById(R.id.qd);
                    if (textView3 != null) {
                        i = R.id.version;
                        TextView textView4 = (TextView) view.findViewById(R.id.version);
                        if (textView4 != null) {
                            return new UpdataInfoLayoutBinding((LinearLayout) view, textView, textView2, frameLayout, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
