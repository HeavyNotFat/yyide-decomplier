package com.yd.android_brand_mvp.banner;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.to.aboomy.pager2banner.Banner;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class BannerImageFragment_ViewBinding implements Unbinder {
    private BannerImageFragment target;
    private View view7f0a0250;
    private View view7f0a0863;

    public BannerImageFragment_ViewBinding(final BannerImageFragment bannerImageFragment, View view) {
        this.target = bannerImageFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        bannerImageFragment.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.banner.BannerImageFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                bannerImageFragment.onClick(view2);
            }
        });
        bannerImageFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        bannerImageFragment.banner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner, "field 'banner'", Banner.class);
        bannerImageFragment.tv_index = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_index, "field 'tv_index'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.content, "field 'llContent' and method 'onClick'");
        bannerImageFragment.llContent = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.content, "field 'llContent'", LinearLayout.class);
        this.view7f0a0250 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.banner.BannerImageFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                bannerImageFragment.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BannerImageFragment bannerImageFragment = this.target;
        if (bannerImageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bannerImageFragment.title = null;
        bannerImageFragment.mu = null;
        bannerImageFragment.banner = null;
        bannerImageFragment.tv_index = null;
        bannerImageFragment.llContent = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
        this.view7f0a0250.setOnClickListener(null);
        this.view7f0a0250 = null;
    }
}
