package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAttenceL2x2ListPBinding implements ViewBinding {
    public final FrameLayout content;
    public final ViewPager pager;
    private final FrameLayout rootView;

    private FragmentAttenceL2x2ListPBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ViewPager viewPager) {
        this.rootView = frameLayout;
        this.content = frameLayout2;
        this.pager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAttenceL2x2ListPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAttenceL2x2ListPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_attence_l2x2_list_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAttenceL2x2ListPBinding bind(View view) {
        int i = R.id.content;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
        if (frameLayout != null) {
            i = R.id.pager;
            ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
            if (viewPager != null) {
                return new FragmentAttenceL2x2ListPBinding((FrameLayout) view, frameLayout, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
