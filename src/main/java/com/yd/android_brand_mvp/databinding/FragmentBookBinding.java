package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentBookBinding implements ViewBinding {
    public final TextView dj;
    public final FrameLayout layout;
    private final LinearLayout rootView;

    private FragmentBookBinding(LinearLayout linearLayout, TextView textView, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.dj = textView;
        this.layout = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBookBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBookBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_book, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBookBinding bind(View view) {
        int i = R.id.dj;
        TextView textView = (TextView) view.findViewById(R.id.dj);
        if (textView != null) {
            i = R.id.layout;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.layout);
            if (frameLayout != null) {
                return new FragmentBookBinding((LinearLayout) view, textView, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
