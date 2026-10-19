package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class RequestLeaveFragment_ViewBinding implements Unbinder {
    private RequestLeaveFragment target;
    private View view7f0a046a;
    private View view7f0a0a0e;
    private View view7f0a0bad;
    private View view7f0a0bb5;

    public RequestLeaveFragment_ViewBinding(final RequestLeaveFragment requestLeaveFragment, View view) {
        this.target = requestLeaveFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_start_time, "field 'tvStartTime' and method 'onClick'");
        requestLeaveFragment.tvStartTime = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_start_time, "field 'tvStartTime'", TextView.class);
        this.view7f0a0bad = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.RequestLeaveFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                requestLeaveFragment.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_end_time, "field 'tvEndTime' and method 'onClick'");
        requestLeaveFragment.tvEndTime = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_end_time, "field 'tvEndTime'", TextView.class);
        this.view7f0a0a0e = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.RequestLeaveFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                requestLeaveFragment.onClick(view2);
            }
        });
        requestLeaveFragment.tvCopuPrompt = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_copy_prompt, "field 'tvCopuPrompt'", TextView.class);
        requestLeaveFragment.tvApproverPrompt = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_approver_prompt, "field 'tvApproverPrompt'", TextView.class);
        requestLeaveFragment.tvClassName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class, "field 'tvClassName'", TextView.class);
        requestLeaveFragment.etContent = (EditText) Utils.findRequiredViewAsType(view, R.id.et_content, "field 'etContent'", EditText.class);
        requestLeaveFragment.mApprovalRecycle = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.approvalList, "field 'mApprovalRecycle'", RecyclerView.class);
        requestLeaveFragment.mCcRecycle = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.ccList, "field 'mCcRecycle'", RecyclerView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_add_staff, "field 'iv_add_staff' and method 'onClick'");
        requestLeaveFragment.iv_add_staff = (ImageView) Utils.castView(viewFindRequiredView3, R.id.iv_add_staff, "field 'iv_add_staff'", ImageView.class);
        this.view7f0a046a = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.RequestLeaveFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                requestLeaveFragment.onClick(view2);
            }
        });
        requestLeaveFragment.ivApproval = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_add_approval, "field 'ivApproval'", ImageView.class);
        requestLeaveFragment.ccLine = Utils.findRequiredView(view, R.id.ccLine, "field 'ccLine'");
        requestLeaveFragment.appLine = Utils.findRequiredView(view, R.id.appLine, "field 'appLine'");
        requestLeaveFragment.viewTop = Utils.findRequiredView(view, R.id.viewTop, "field 'viewTop'");
        requestLeaveFragment.viewLine = Utils.findRequiredView(view, R.id.viewLine, "field 'viewLine'");
        requestLeaveFragment.tv_approver = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_approver, "field 'tv_approver'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_submit, "method 'onClick'");
        this.view7f0a0bb5 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.RequestLeaveFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                requestLeaveFragment.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RequestLeaveFragment requestLeaveFragment = this.target;
        if (requestLeaveFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        requestLeaveFragment.tvStartTime = null;
        requestLeaveFragment.tvEndTime = null;
        requestLeaveFragment.tvCopuPrompt = null;
        requestLeaveFragment.tvApproverPrompt = null;
        requestLeaveFragment.tvClassName = null;
        requestLeaveFragment.etContent = null;
        requestLeaveFragment.mApprovalRecycle = null;
        requestLeaveFragment.mCcRecycle = null;
        requestLeaveFragment.iv_add_staff = null;
        requestLeaveFragment.ivApproval = null;
        requestLeaveFragment.ccLine = null;
        requestLeaveFragment.appLine = null;
        requestLeaveFragment.viewTop = null;
        requestLeaveFragment.viewLine = null;
        requestLeaveFragment.tv_approver = null;
        this.view7f0a0bad.setOnClickListener(null);
        this.view7f0a0bad = null;
        this.view7f0a0a0e.setOnClickListener(null);
        this.view7f0a0a0e = null;
        this.view7f0a046a.setOnClickListener(null);
        this.view7f0a046a = null;
        this.view7f0a0bb5.setOnClickListener(null);
        this.view7f0a0bb5 = null;
    }
}
