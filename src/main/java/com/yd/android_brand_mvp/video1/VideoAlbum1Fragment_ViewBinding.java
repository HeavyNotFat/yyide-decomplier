package com.yd.android_brand_mvp.video1;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class VideoAlbum1Fragment_ViewBinding implements Unbinder {
    private VideoAlbum1Fragment target;

    public VideoAlbum1Fragment_ViewBinding(VideoAlbum1Fragment videoAlbum1Fragment, View view) {
        this.target = videoAlbum1Fragment;
        videoAlbum1Fragment.viewPager2 = (ViewPager2) Utils.findRequiredViewAsType(view, R.id.view_pager2, "field 'viewPager2'", ViewPager2.class);
        videoAlbum1Fragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        videoAlbum1Fragment.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        VideoAlbum1Fragment videoAlbum1Fragment = this.target;
        if (videoAlbum1Fragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        videoAlbum1Fragment.viewPager2 = null;
        videoAlbum1Fragment.mu = null;
        videoAlbum1Fragment.llIndicator = null;
    }
}
