package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentWifiBinding implements ViewBinding {
    public final CheckedTextView checkbox;
    public final RecyclerView rcView;
    public final RelativeLayout rlBg;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final TextView tvYt;
    public final LinearLayout wifiBack;
    public final FrameLayout wifiLayout;

    private FragmentWifiBinding(ConstraintLayout constraintLayout, CheckedTextView checkedTextView, RecyclerView recyclerView, RelativeLayout relativeLayout, TextView textView, TextView textView2, LinearLayout linearLayout, FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.checkbox = checkedTextView;
        this.rcView = recyclerView;
        this.rlBg = relativeLayout;
        this.title = textView;
        this.tvYt = textView2;
        this.wifiBack = linearLayout;
        this.wifiLayout = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWifiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_wifi, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentWifiBinding bind(View view) {
        int i = R.id.checkbox;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.checkbox);
        if (checkedTextView != null) {
            i = R.id.rc_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rc_view);
            if (recyclerView != null) {
                i = R.id.rl_bg;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_bg);
                if (relativeLayout != null) {
                    i = R.id.title;
                    TextView textView = (TextView) view.findViewById(R.id.title);
                    if (textView != null) {
                        i = R.id.tv_yt;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_yt);
                        if (textView2 != null) {
                            i = R.id.wifi_back;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.wifi_back);
                            if (linearLayout != null) {
                                i = R.id.wifi_layout;
                                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.wifi_layout);
                                if (frameLayout != null) {
                                    return new FragmentWifiBinding((ConstraintLayout) view, checkedTextView, recyclerView, relativeLayout, textView, textView2, linearLayout, frameLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
