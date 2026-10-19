package com.yd.android_brand_mvp.photo;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public class ShowPhotoAlbumAllFragment_ViewBinding implements Unbinder {
    private ShowPhotoAlbumAllFragment target;

    public ShowPhotoAlbumAllFragment_ViewBinding(ShowPhotoAlbumAllFragment showPhotoAlbumAllFragment, View view) {
        this.target = showPhotoAlbumAllFragment;
        showPhotoAlbumAllFragment.banner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner, "field 'banner'", Banner.class);
        showPhotoAlbumAllFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ShowPhotoAlbumAllFragment showPhotoAlbumAllFragment = this.target;
        if (showPhotoAlbumAllFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        showPhotoAlbumAllFragment.banner = null;
        showPhotoAlbumAllFragment.mu = null;
    }
}
