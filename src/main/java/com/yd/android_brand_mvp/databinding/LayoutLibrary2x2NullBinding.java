package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutLibrary2x2NullBinding implements ViewBinding {
    public final TextView msg;
    private final LinearLayoutCompat rootView;

    private LayoutLibrary2x2NullBinding(LinearLayoutCompat linearLayoutCompat, TextView textView) {
        this.rootView = linearLayoutCompat;
        this.msg = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static LayoutLibrary2x2NullBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutLibrary2x2NullBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_library_2x2_null, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutLibrary2x2NullBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.msg);
        if (textView != null) {
            return new LayoutLibrary2x2NullBinding((LinearLayoutCompat) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.msg)));
    }
}
