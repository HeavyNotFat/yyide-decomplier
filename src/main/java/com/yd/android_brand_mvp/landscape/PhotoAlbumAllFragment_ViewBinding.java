package com.yd.android_brand_mvp.landscape;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.flyco.tablayout.CommonTabLayout;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumAllFragment_ViewBinding implements Unbinder {
    private PhotoAlbumAllFragment target;

    public PhotoAlbumAllFragment_ViewBinding(PhotoAlbumAllFragment photoAlbumAllFragment, View view) {
        this.target = photoAlbumAllFragment;
        photoAlbumAllFragment.tabLayout = (CommonTabLayout) Utils.findRequiredViewAsType(view, R.id.ctl_tab, "field 'tabLayout'", CommonTabLayout.class);
        photoAlbumAllFragment.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vpList, "field 'viewPager'", ViewPager.class);
        photoAlbumAllFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PhotoAlbumAllFragment photoAlbumAllFragment = this.target;
        if (photoAlbumAllFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        photoAlbumAllFragment.tabLayout = null;
        photoAlbumAllFragment.viewPager = null;
        photoAlbumAllFragment.mu = null;
    }
}
