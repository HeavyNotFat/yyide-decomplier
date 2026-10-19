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
public class AnnouncementFragment6_3P_ViewBinding implements Unbinder {
    private AnnouncementFragment6_3P target;
    private View view7f0a0863;
    private View view7f0a0b3a;
    private View view7f0a0b4c;

    public AnnouncementFragment6_3P_ViewBinding(final AnnouncementFragment6_3P announcementFragment6_3P, View view) {
        this.target = announcementFragment6_3P;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        announcementFragment6_3P.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementFragment6_3P_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                announcementFragment6_3P.onClick(view2);
            }
        });
        announcementFragment6_3P.tvAnnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ann_title, "field 'tvAnnTitle'", TextView.class);
        announcementFragment6_3P.tvIssueName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_issue_name, "field 'tvIssueName'", TextView.class);
        announcementFragment6_3P.tvIssueTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_issue_time, "field 'tvIssueTime'", TextView.class);
        announcementFragment6_3P.tvContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'tvContent'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_previous_record, "field 'tvPreviousRecord' and method 'onClick'");
        announcementFragment6_3P.tvPreviousRecord = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_previous_record, "field 'tvPreviousRecord'", TextView.class);
        this.view7f0a0b4c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementFragment6_3P_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                announcementFragment6_3P.onClick(view2);
            }
        });
        announcementFragment6_3P.tvCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_count, "field 'tvCount'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_next_reference, "field 'tvNextReference' and method 'onClick'");
        announcementFragment6_3P.tvNextReference = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_next_reference, "field 'tvNextReference'", TextView.class);
        this.view7f0a0b3a = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementFragment6_3P_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                announcementFragment6_3P.onClick(view2);
            }
        });
        announcementFragment6_3P.llContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
        announcementFragment6_3P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        announcementFragment6_3P.img = (ImageView) Utils.findRequiredViewAsType(view, R.id.img, "field 'img'", ImageView.class);
        announcementFragment6_3P.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
        announcementFragment6_3P.msglayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.msglayout, "field 'msglayout'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AnnouncementFragment6_3P announcementFragment6_3P = this.target;
        if (announcementFragment6_3P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        announcementFragment6_3P.title = null;
        announcementFragment6_3P.tvAnnTitle = null;
        announcementFragment6_3P.tvIssueName = null;
        announcementFragment6_3P.tvIssueTime = null;
        announcementFragment6_3P.tvContent = null;
        announcementFragment6_3P.tvPreviousRecord = null;
        announcementFragment6_3P.tvCount = null;
        announcementFragment6_3P.tvNextReference = null;
        announcementFragment6_3P.llContent = null;
        announcementFragment6_3P.mu = null;
        announcementFragment6_3P.img = null;
        announcementFragment6_3P.content = null;
        announcementFragment6_3P.msglayout = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
        this.view7f0a0b4c.setOnClickListener(null);
        this.view7f0a0b4c = null;
        this.view7f0a0b3a.setOnClickListener(null);
        this.view7f0a0b3a = null;
    }
}
