package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutDialogNetErrBinding implements ViewBinding {
    public final TextView cancel;
    public final TextView qd;
    private final LinearLayout rootView;
    public final TextView title;

    private LayoutDialogNetErrBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.cancel = textView;
        this.qd = textView2;
        this.title = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDialogNetErrBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutDialogNetErrBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_net_err, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutDialogNetErrBinding bind(View view) {
        int i = R.id.cancel;
        TextView textView = (TextView) view.findViewById(R.id.cancel);
        if (textView != null) {
            i = R.id.qd;
            TextView textView2 = (TextView) view.findViewById(R.id.qd);
            if (textView2 != null) {
                i = R.id.title;
                TextView textView3 = (TextView) view.findViewById(R.id.title);
                if (textView3 != null) {
                    return new LayoutDialogNetErrBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
