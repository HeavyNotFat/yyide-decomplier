package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutDialogWifiBinding implements ViewBinding {
    public final TextView cancel;
    public final YDEditText edit;
    public final TextView qd;
    private final LinearLayout rootView;

    private LayoutDialogWifiBinding(LinearLayout linearLayout, TextView textView, YDEditText yDEditText, TextView textView2) {
        this.rootView = linearLayout;
        this.cancel = textView;
        this.edit = yDEditText;
        this.qd = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDialogWifiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutDialogWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_wifi, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutDialogWifiBinding bind(View view) {
        int i = R.id.cancel;
        TextView textView = (TextView) view.findViewById(R.id.cancel);
        if (textView != null) {
            i = R.id.edit;
            YDEditText yDEditText = (YDEditText) view.findViewById(R.id.edit);
            if (yDEditText != null) {
                i = R.id.qd;
                TextView textView2 = (TextView) view.findViewById(R.id.qd);
                if (textView2 != null) {
                    return new LayoutDialogWifiBinding((LinearLayout) view, textView, yDEditText, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
