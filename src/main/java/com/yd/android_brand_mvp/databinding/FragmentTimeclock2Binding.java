package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentTimeclock2Binding implements ViewBinding {
    public final FrameLayout content;
    private final FrameLayout rootView;

    private FragmentTimeclock2Binding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.content = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTimeclock2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTimeclock2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timeclock2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTimeclock2Binding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
        if (frameLayout != null) {
            return new FragmentTimeclock2Binding((FrameLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.content)));
    }
}
