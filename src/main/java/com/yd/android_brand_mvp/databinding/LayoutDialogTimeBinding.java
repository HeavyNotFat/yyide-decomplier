package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutDialogTimeBinding implements ViewBinding {
    public final TextView cancel;
    public final TextView close;
    public final TextView open;
    public final TextView qd;
    private final LinearLayout rootView;

    private LayoutDialogTimeBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.cancel = textView;
        this.close = textView2;
        this.open = textView3;
        this.qd = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDialogTimeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutDialogTimeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_time, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutDialogTimeBinding bind(View view) {
        int i = R.id.cancel;
        TextView textView = (TextView) view.findViewById(R.id.cancel);
        if (textView != null) {
            i = R.id.close;
            TextView textView2 = (TextView) view.findViewById(R.id.close);
            if (textView2 != null) {
                i = R.id.open;
                TextView textView3 = (TextView) view.findViewById(R.id.open);
                if (textView3 != null) {
                    i = R.id.qd;
                    TextView textView4 = (TextView) view.findViewById(R.id.qd);
                    if (textView4 != null) {
                        return new LayoutDialogTimeBinding((LinearLayout) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
