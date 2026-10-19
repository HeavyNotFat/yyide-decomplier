package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAllPhotoAlbumBinding implements ViewBinding {
    public final CommonTabLayout ctlTab;
    public final MultiStateView mu;
    private final LinearLayout rootView;
    public final ViewPager vpList;

    private FragmentAllPhotoAlbumBinding(LinearLayout linearLayout, CommonTabLayout commonTabLayout, MultiStateView multiStateView, ViewPager viewPager) {
        this.rootView = linearLayout;
        this.ctlTab = commonTabLayout;
        this.mu = multiStateView;
        this.vpList = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAllPhotoAlbumBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAllPhotoAlbumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_all_photo_album, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAllPhotoAlbumBinding bind(View view) {
        int i = R.id.ctl_tab;
        CommonTabLayout commonTabLayout = (CommonTabLayout) view.findViewById(R.id.ctl_tab);
        if (commonTabLayout != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                i = R.id.vpList;
                ViewPager viewPager = (ViewPager) view.findViewById(R.id.vpList);
                if (viewPager != null) {
                    return new FragmentAllPhotoAlbumBinding((LinearLayout) view, commonTabLayout, multiStateView, viewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
