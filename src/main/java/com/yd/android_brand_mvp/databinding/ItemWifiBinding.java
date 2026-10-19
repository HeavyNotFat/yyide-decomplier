package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemWifiBinding implements ViewBinding {
    public final CheckedTextView ctWifi;
    public final TextView desc;
    public final RelativeLayout llWifi;
    public final TextView name;
    private final RelativeLayout rootView;

    private ItemWifiBinding(RelativeLayout relativeLayout, CheckedTextView checkedTextView, TextView textView, RelativeLayout relativeLayout2, TextView textView2) {
        this.rootView = relativeLayout;
        this.ctWifi = checkedTextView;
        this.desc = textView;
        this.llWifi = relativeLayout2;
        this.name = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemWifiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_wifi, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemWifiBinding bind(View view) {
        int i = R.id.ct_wifi;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.ct_wifi);
        if (checkedTextView != null) {
            i = R.id.desc;
            TextView textView = (TextView) view.findViewById(R.id.desc);
            if (textView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = R.id.name;
                TextView textView2 = (TextView) view.findViewById(R.id.name);
                if (textView2 != null) {
                    return new ItemWifiBinding(relativeLayout, checkedTextView, textView, relativeLayout, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
