package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumAllPFragment_ViewBinding implements Unbinder {
    private PhotoAlbumAllPFragment target;

    public PhotoAlbumAllPFragment_ViewBinding(PhotoAlbumAllPFragment photoAlbumAllPFragment, View view) {
        this.target = photoAlbumAllPFragment;
        photoAlbumAllPFragment.rlList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_list, "field 'rlList'", RecyclerView.class);
        photoAlbumAllPFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PhotoAlbumAllPFragment photoAlbumAllPFragment = this.target;
        if (photoAlbumAllPFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        photoAlbumAllPFragment.rlList = null;
        photoAlbumAllPFragment.mu = null;
    }
}
