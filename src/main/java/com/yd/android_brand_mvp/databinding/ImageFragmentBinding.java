package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.ChildViewPager;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageFragmentBinding implements ViewBinding {
    public final MagicIndicator indicatorBanner;
    private final FrameLayout rootView;
    public final ChildViewPager viewpager;

    private ImageFragmentBinding(FrameLayout frameLayout, MagicIndicator magicIndicator, ChildViewPager childViewPager) {
        this.rootView = frameLayout;
        this.indicatorBanner = magicIndicator;
        this.viewpager = childViewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ImageFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ImageFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.image_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ImageFragmentBinding bind(View view) {
        int i = R.id.indicatorBanner;
        MagicIndicator magicIndicator = (MagicIndicator) view.findViewById(R.id.indicatorBanner);
        if (magicIndicator != null) {
            i = R.id.viewpager;
            ChildViewPager childViewPager = (ChildViewPager) view.findViewById(R.id.viewpager);
            if (childViewPager != null) {
                return new ImageFragmentBinding((FrameLayout) view, magicIndicator, childViewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
