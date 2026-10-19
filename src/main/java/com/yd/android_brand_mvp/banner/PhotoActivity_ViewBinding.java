package com.yd.android_brand_mvp.banner;

import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flyco.tablayout.SlidingTabLayout;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoActivity_ViewBinding implements Unbinder {
    private PhotoActivity target;
    private View view7f0a0476;

    public PhotoActivity_ViewBinding(PhotoActivity photoActivity) {
        this(photoActivity, photoActivity.getWindow().getDecorView());
    }

    public PhotoActivity_ViewBinding(final PhotoActivity photoActivity, View view) {
        this.target = photoActivity;
        photoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        photoActivity.mTablayout = (SlidingTabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'mTablayout'", SlidingTabLayout.class);
        photoActivity.mViewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'mViewpager'", ViewPager.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'click'");
        this.view7f0a0476 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.banner.PhotoActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                photoActivity.click();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PhotoActivity photoActivity = this.target;
        if (photoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        photoActivity.mTvTitle = null;
        photoActivity.mTablayout = null;
        photoActivity.mViewpager = null;
        this.view7f0a0476.setOnClickListener(null);
        this.view7f0a0476 = null;
    }
}
