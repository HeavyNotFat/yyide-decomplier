package com.yd.android_brand_mvp.photo;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumAllFragment_ViewBinding implements Unbinder {
    private PhotoAlbumAllFragment target;

    public PhotoAlbumAllFragment_ViewBinding(PhotoAlbumAllFragment photoAlbumAllFragment, View view) {
        this.target = photoAlbumAllFragment;
        photoAlbumAllFragment.banner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner, "field 'banner'", Banner.class);
        photoAlbumAllFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PhotoAlbumAllFragment photoAlbumAllFragment = this.target;
        if (photoAlbumAllFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        photoAlbumAllFragment.banner = null;
        photoAlbumAllFragment.mu = null;
    }
}
