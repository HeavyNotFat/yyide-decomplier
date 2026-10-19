package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class SelectMsgLayoutBinding implements ViewBinding {
    public final TextView cancel;
    public final TextView msg;
    private final LinearLayout rootView;
    public final TextView yes;

    private SelectMsgLayoutBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.cancel = textView;
        this.msg = textView2;
        this.yes = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SelectMsgLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SelectMsgLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.select_msg_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SelectMsgLayoutBinding bind(View view) {
        int i = R.id.cancel;
        TextView textView = (TextView) view.findViewById(R.id.cancel);
        if (textView != null) {
            i = R.id.msg;
            TextView textView2 = (TextView) view.findViewById(R.id.msg);
            if (textView2 != null) {
                i = R.id.yes;
                TextView textView3 = (TextView) view.findViewById(R.id.yes);
                if (textView3 != null) {
                    return new SelectMsgLayoutBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
