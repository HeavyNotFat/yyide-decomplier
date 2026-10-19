package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ExitSystemLayoutBinding implements ViewBinding {
    public final TextView cancel;
    private final LinearLayout rootView;
    public final TextView yes;

    private ExitSystemLayoutBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.cancel = textView;
        this.yes = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ExitSystemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ExitSystemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.exit_system_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExitSystemLayoutBinding bind(View view) {
        int i = R.id.cancel;
        TextView textView = (TextView) view.findViewById(R.id.cancel);
        if (textView != null) {
            i = R.id.yes;
            TextView textView2 = (TextView) view.findViewById(R.id.yes);
            if (textView2 != null) {
                return new ExitSystemLayoutBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
