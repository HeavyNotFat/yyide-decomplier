package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentPhotoAlbum1Binding implements ViewBinding {
    public final LinearLayout llIndicator;
    public final MultiStateView mu;
    private final FrameLayout rootView;
    public final ViewPager2 viewPager2;

    private FragmentPhotoAlbum1Binding(FrameLayout frameLayout, LinearLayout linearLayout, MultiStateView multiStateView, ViewPager2 viewPager2) {
        this.rootView = frameLayout;
        this.llIndicator = linearLayout;
        this.mu = multiStateView;
        this.viewPager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPhotoAlbum1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentPhotoAlbum1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_photo_album1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentPhotoAlbum1Binding bind(View view) {
        int i = R.id.ll_indicator;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator);
        if (linearLayout != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                i = R.id.view_pager2;
                ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.view_pager2);
                if (viewPager2 != null) {
                    return new FragmentPhotoAlbum1Binding((FrameLayout) view, linearLayout, multiStateView, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
