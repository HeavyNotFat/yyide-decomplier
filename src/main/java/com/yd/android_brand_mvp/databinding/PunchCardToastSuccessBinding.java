package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class PunchCardToastSuccessBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvMsg;

    private PunchCardToastSuccessBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.tvMsg = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PunchCardToastSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PunchCardToastSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.punch_card_toast_success, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PunchCardToastSuccessBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_msg);
        if (textView != null) {
            return new PunchCardToastSuccessBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_msg)));
    }
}
