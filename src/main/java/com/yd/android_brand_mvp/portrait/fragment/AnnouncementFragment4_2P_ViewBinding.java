package com.yd.android_brand_mvp.portrait.fragment;

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
public class AnnouncementFragment4_2P_ViewBinding implements Unbinder {
    private AnnouncementFragment4_2P target;
    private View view7f0a0863;
    private View view7f0a0b3a;
    private View view7f0a0b4c;

    public AnnouncementFragment4_2P_ViewBinding(final AnnouncementFragment4_2P announcementFragment4_2P, View view) {
        this.target = announcementFragment4_2P;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        announcementFragment4_2P.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementFragment4_2P_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                announcementFragment4_2P.onClick(view2);
            }
        });
        announcementFragment4_2P.tvAnnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ann_title, "field 'tvAnnTitle'", TextView.class);
        announcementFragment4_2P.tvIssueName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_issue_name, "field 'tvIssueName'", TextView.class);
        announcementFragment4_2P.tvIssueTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_issue_time, "field 'tvIssueTime'", TextView.class);
        announcementFragment4_2P.tvContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'tvContent'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_previous_record, "field 'tvPreviousRecord' and method 'onClick'");
        announcementFragment4_2P.tvPreviousRecord = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_previous_record, "field 'tvPreviousRecord'", TextView.class);
        this.view7f0a0b4c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementFragment4_2P_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                announcementFragment4_2P.onClick(view2);
            }
        });
        announcementFragment4_2P.tvCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tvCount'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_next_reference, "field 'tvNextReference' and method 'onClick'");
        announcementFragment4_2P.tvNextReference = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_next_reference, "field 'tvNextReference'", TextView.class);
        this.view7f0a0b3a = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementFragment4_2P_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                announcementFragment4_2P.onClick(view2);
            }
        });
        announcementFragment4_2P.llContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
        announcementFragment4_2P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        announcementFragment4_2P.img = (ImageView) Utils.findRequiredViewAsType(view, R.id.img, "field 'img'", ImageView.class);
        announcementFragment4_2P.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
        announcementFragment4_2P.msglayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.msglayout, "field 'msglayout'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AnnouncementFragment4_2P announcementFragment4_2P = this.target;
        if (announcementFragment4_2P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        announcementFragment4_2P.title = null;
        announcementFragment4_2P.tvAnnTitle = null;
        announcementFragment4_2P.tvIssueName = null;
        announcementFragment4_2P.tvIssueTime = null;
        announcementFragment4_2P.tvContent = null;
        announcementFragment4_2P.tvPreviousRecord = null;
        announcementFragment4_2P.tvCount = null;
        announcementFragment4_2P.tvNextReference = null;
        announcementFragment4_2P.llContent = null;
        announcementFragment4_2P.mu = null;
        announcementFragment4_2P.img = null;
        announcementFragment4_2P.content = null;
        announcementFragment4_2P.msglayout = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
        this.view7f0a0b4c.setOnClickListener(null);
        this.view7f0a0b4c = null;
        this.view7f0a0b3a.setOnClickListener(null);
        this.view7f0a0b3a = null;
    }
}
