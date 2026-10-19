package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class BigMsgLayoutBinding implements ViewBinding {
    public final YDEditText msg;
    private final LinearLayout rootView;

    private BigMsgLayoutBinding(LinearLayout linearLayout, YDEditText yDEditText) {
        this.rootView = linearLayout;
        this.msg = yDEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BigMsgLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BigMsgLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.big_msg_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BigMsgLayoutBinding bind(View view) {
        YDEditText yDEditText = (YDEditText) view.findViewById(R.id.msg);
        if (yDEditText != null) {
            return new BigMsgLayoutBinding((LinearLayout) view, yDEditText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.msg)));
    }
}
