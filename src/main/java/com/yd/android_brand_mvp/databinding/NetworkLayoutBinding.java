package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class NetworkLayoutBinding implements ViewBinding {
    public final LinearLayout btnClose;
    public final FrameLayout content;
    public final RelativeLayout rlTitle;
    private final LinearLayout rootView;
    public final TextView title;
    public final TextView tvTest;
    public final TextView type;

    private NetworkLayoutBinding(LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnClose = linearLayout2;
        this.content = frameLayout;
        this.rlTitle = relativeLayout;
        this.title = textView;
        this.tvTest = textView2;
        this.type = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NetworkLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NetworkLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.network_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NetworkLayoutBinding bind(View view) {
        int i = R.id.btn_close;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.btn_close);
        if (linearLayout != null) {
            i = R.id.content;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
            if (frameLayout != null) {
                i = R.id.rl_title;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_title);
                if (relativeLayout != null) {
                    i = R.id.title;
                    TextView textView = (TextView) view.findViewById(R.id.title);
                    if (textView != null) {
                        i = R.id.tvTest;
                        TextView textView2 = (TextView) view.findViewById(R.id.tvTest);
                        if (textView2 != null) {
                            i = R.id.type;
                            TextView textView3 = (TextView) view.findViewById(R.id.type);
                            if (textView3 != null) {
                                return new NetworkLayoutBinding((LinearLayout) view, linearLayout, frameLayout, relativeLayout, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
