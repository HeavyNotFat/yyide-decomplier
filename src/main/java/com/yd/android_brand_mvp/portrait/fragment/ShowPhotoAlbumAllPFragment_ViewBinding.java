package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class ShowPhotoAlbumAllPFragment_ViewBinding implements Unbinder {
    private ShowPhotoAlbumAllPFragment target;

    public ShowPhotoAlbumAllPFragment_ViewBinding(ShowPhotoAlbumAllPFragment showPhotoAlbumAllPFragment, View view) {
        this.target = showPhotoAlbumAllPFragment;
        showPhotoAlbumAllPFragment.rlList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_list, "field 'rlList'", RecyclerView.class);
        showPhotoAlbumAllPFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ShowPhotoAlbumAllPFragment showPhotoAlbumAllPFragment = this.target;
        if (showPhotoAlbumAllPFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        showPhotoAlbumAllPFragment.rlList = null;
        showPhotoAlbumAllPFragment.mu = null;
    }
}
