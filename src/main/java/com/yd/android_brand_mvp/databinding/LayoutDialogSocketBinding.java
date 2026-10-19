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
public final class LayoutDialogSocketBinding implements ViewBinding {
    public final YDEditText edit;
    public final TextView qd;
    private final LinearLayout rootView;

    private LayoutDialogSocketBinding(LinearLayout linearLayout, YDEditText yDEditText, TextView textView) {
        this.rootView = linearLayout;
        this.edit = yDEditText;
        this.qd = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDialogSocketBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutDialogSocketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_socket, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutDialogSocketBinding bind(View view) {
        int i = R.id.edit;
        YDEditText yDEditText = (YDEditText) view.findViewById(R.id.edit);
        if (yDEditText != null) {
            i = R.id.qd;
            TextView textView = (TextView) view.findViewById(R.id.qd);
            if (textView != null) {
                return new LayoutDialogSocketBinding((LinearLayout) view, yDEditText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
