package com.yd.android_brand_mvp.landscape;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.banner.manager.ChangeBanner;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumFragment_ViewBinding implements Unbinder {
    private PhotoAlbumFragment target;

    public PhotoAlbumFragment_ViewBinding(PhotoAlbumFragment photoAlbumFragment, View view) {
        this.target = photoAlbumFragment;
        photoAlbumFragment.banner = (ChangeBanner) Utils.findRequiredViewAsType(view, R.id.banner, "field 'banner'", ChangeBanner.class);
        photoAlbumFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PhotoAlbumFragment photoAlbumFragment = this.target;
        if (photoAlbumFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        photoAlbumFragment.banner = null;
        photoAlbumFragment.mu = null;
    }
}
