package com.yd.android_brand_mvp.landscape.message;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AnnouncementFragment2_5L_ViewBinding implements Unbinder {
    private AnnouncementFragment2_5L target;
    private View view7f0a0863;
    private View view7f0a0b3a;
    private View view7f0a0b4c;

    public AnnouncementFragment2_5L_ViewBinding(final AnnouncementFragment2_5L announcementFragment2_5L, View view) {
        this.target = announcementFragment2_5L;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        announcementFragment2_5L.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementFragment2_5L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                announcementFragment2_5L.onClick(view2);
            }
        });
        announcementFragment2_5L.tvAnnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ann_title, "field 'tvAnnTitle'", TextView.class);
        announcementFragment2_5L.tvIssueName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_issue_name, "field 'tvIssueName'", TextView.class);
        announcementFragment2_5L.tvIssueTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_issue_time, "field 'tvIssueTime'", TextView.class);
        announcementFragment2_5L.tvContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'tvContent'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_previous_record, "field 'tvPreviousRecord' and method 'onClick'");
        announcementFragment2_5L.tvPreviousRecord = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_previous_record, "field 'tvPreviousRecord'", TextView.class);
        this.view7f0a0b4c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementFragment2_5L_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                announcementFragment2_5L.onClick(view2);
            }
        });
        announcementFragment2_5L.tvCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tvCount'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_next_reference, "field 'tvNextReference' and method 'onClick'");
        announcementFragment2_5L.tvNextReference = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_next_reference, "field 'tvNextReference'", TextView.class);
        this.view7f0a0b3a = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementFragment2_5L_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                announcementFragment2_5L.onClick(view2);
            }
        });
        announcementFragment2_5L.llContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
        announcementFragment2_5L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        announcementFragment2_5L.img = (ImageView) Utils.findRequiredViewAsType(view, R.id.img, "field 'img'", ImageView.class);
        announcementFragment2_5L.msglayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.msglayout, "field 'msglayout'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AnnouncementFragment2_5L announcementFragment2_5L = this.target;
        if (announcementFragment2_5L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        announcementFragment2_5L.title = null;
        announcementFragment2_5L.tvAnnTitle = null;
        announcementFragment2_5L.tvIssueName = null;
        announcementFragment2_5L.tvIssueTime = null;
        announcementFragment2_5L.tvContent = null;
        announcementFragment2_5L.tvPreviousRecord = null;
        announcementFragment2_5L.tvCount = null;
        announcementFragment2_5L.tvNextReference = null;
        announcementFragment2_5L.llContent = null;
        announcementFragment2_5L.mu = null;
        announcementFragment2_5L.img = null;
        announcementFragment2_5L.msglayout = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
        this.view7f0a0b4c.setOnClickListener(null);
        this.view7f0a0b4c = null;
        this.view7f0a0b3a.setOnClickListener(null);
        this.view7f0a0b3a = null;
    }
}
