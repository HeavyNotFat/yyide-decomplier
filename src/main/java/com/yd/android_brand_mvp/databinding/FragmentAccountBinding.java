package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAccountBinding implements ViewBinding {
    public final YDEditText edit;
    public final TextView qd;
    private final FrameLayout rootView;

    private FragmentAccountBinding(FrameLayout frameLayout, YDEditText yDEditText, TextView textView) {
        this.rootView = frameLayout;
        this.edit = yDEditText;
        this.qd = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_account, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAccountBinding bind(View view) {
        int i = R.id.edit;
        YDEditText yDEditText = (YDEditText) view.findViewById(R.id.edit);
        if (yDEditText != null) {
            i = R.id.qd;
            TextView textView = (TextView) view.findViewById(R.id.qd);
            if (textView != null) {
                return new FragmentAccountBinding((FrameLayout) view, yDEditText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
