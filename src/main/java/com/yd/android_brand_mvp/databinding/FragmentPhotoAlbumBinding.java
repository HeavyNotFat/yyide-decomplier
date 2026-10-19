package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.banner.manager.ChangeBanner;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentPhotoAlbumBinding implements ViewBinding {
    public final ChangeBanner banner;
    public final MultiStateView mu;
    private final FrameLayout rootView;

    private FragmentPhotoAlbumBinding(FrameLayout frameLayout, ChangeBanner changeBanner, MultiStateView multiStateView) {
        this.rootView = frameLayout;
        this.banner = changeBanner;
        this.mu = multiStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPhotoAlbumBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentPhotoAlbumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_photo_album, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentPhotoAlbumBinding bind(View view) {
        int i = R.id.banner;
        ChangeBanner changeBanner = (ChangeBanner) view.findViewById(R.id.banner);
        if (changeBanner != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                return new FragmentPhotoAlbumBinding((FrameLayout) view, changeBanner, multiStateView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
