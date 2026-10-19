package com.yd.android_brand_mvp.landscape.video;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class VideoFragment_ViewBinding implements Unbinder {
    private VideoFragment target;
    private View view7f0a0642;
    private View view7f0a0863;

    public VideoFragment_ViewBinding(final VideoFragment videoFragment, View view) {
        this.target = videoFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.mu, "field 'mu' and method 'onClick'");
        videoFragment.mu = (MultiStateView) Utils.castView(viewFindRequiredView, R.id.mu, "field 'mu'", MultiStateView.class);
        this.view7f0a0642 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.video.VideoFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                videoFragment.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        videoFragment.title = (TextView) Utils.castView(viewFindRequiredView2, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.video.VideoFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                videoFragment.onClick(view2);
            }
        });
        videoFragment.viewPager2 = (ViewPager2) Utils.findRequiredViewAsType(view, R.id.view_pager2, "field 'viewPager2'", ViewPager2.class);
        videoFragment.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
        videoFragment.rlContent = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'rlContent'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        VideoFragment videoFragment = this.target;
        if (videoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        videoFragment.mu = null;
        videoFragment.title = null;
        videoFragment.viewPager2 = null;
        videoFragment.llIndicator = null;
        videoFragment.rlContent = null;
        this.view7f0a0642.setOnClickListener(null);
        this.view7f0a0642 = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
