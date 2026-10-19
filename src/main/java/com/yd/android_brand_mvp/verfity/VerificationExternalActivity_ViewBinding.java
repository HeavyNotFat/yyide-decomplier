package com.yd.android_brand_mvp.verfity;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class VerificationExternalActivity_ViewBinding implements Unbinder {
    private VerificationExternalActivity target;
    private View view7f0a00ed;
    private View view7f0a00ee;
    private View view7f0a00ef;
    private View view7f0a00f0;

    public VerificationExternalActivity_ViewBinding(VerificationExternalActivity verificationExternalActivity) {
        this(verificationExternalActivity, verificationExternalActivity.getWindow().getDecorView());
    }

    public VerificationExternalActivity_ViewBinding(final VerificationExternalActivity verificationExternalActivity, View view) {
        this.target = verificationExternalActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn1, "field 'btn1' and method 'onViewClicked'");
        verificationExternalActivity.btn1 = (CheckedTextView) Utils.castView(viewFindRequiredView, R.id.btn1, "field 'btn1'", CheckedTextView.class);
        this.view7f0a00ed = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.VerificationExternalActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                verificationExternalActivity.onViewClicked(view2);
            }
        });
        verificationExternalActivity.line1 = (TextView) Utils.findRequiredViewAsType(view, R.id.line1, "field 'line1'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn2, "field 'btn2' and method 'onViewClicked'");
        verificationExternalActivity.btn2 = (CheckedTextView) Utils.castView(viewFindRequiredView2, R.id.btn2, "field 'btn2'", CheckedTextView.class);
        this.view7f0a00ee = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.VerificationExternalActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                verificationExternalActivity.onViewClicked(view2);
            }
        });
        verificationExternalActivity.line2 = (TextView) Utils.findRequiredViewAsType(view, R.id.line2, "field 'line2'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn3, "field 'btn3' and method 'onViewClicked'");
        verificationExternalActivity.btn3 = (CheckedTextView) Utils.castView(viewFindRequiredView3, R.id.btn3, "field 'btn3'", CheckedTextView.class);
        this.view7f0a00ef = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.VerificationExternalActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                verificationExternalActivity.onViewClicked(view2);
            }
        });
        verificationExternalActivity.line3 = (TextView) Utils.findRequiredViewAsType(view, R.id.line3, "field 'line3'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn4, "field 'btn4' and method 'onViewClicked'");
        verificationExternalActivity.btn4 = (CheckedTextView) Utils.castView(viewFindRequiredView4, R.id.btn4, "field 'btn4'", CheckedTextView.class);
        this.view7f0a00f0 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.verfity.VerificationExternalActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                verificationExternalActivity.onViewClicked(view2);
            }
        });
        verificationExternalActivity.line4 = (TextView) Utils.findRequiredViewAsType(view, R.id.line4, "field 'line4'", TextView.class);
        verificationExternalActivity.content = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", FrameLayout.class);
        verificationExternalActivity.layout4 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout4, "field 'layout4'", LinearLayout.class);
        verificationExternalActivity.tab1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab1, "field 'tab1'", LinearLayout.class);
        verificationExternalActivity.tab2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab2, "field 'tab2'", LinearLayout.class);
        verificationExternalActivity.tab3 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tab3, "field 'tab3'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        VerificationExternalActivity verificationExternalActivity = this.target;
        if (verificationExternalActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        verificationExternalActivity.btn1 = null;
        verificationExternalActivity.line1 = null;
        verificationExternalActivity.btn2 = null;
        verificationExternalActivity.line2 = null;
        verificationExternalActivity.btn3 = null;
        verificationExternalActivity.line3 = null;
        verificationExternalActivity.btn4 = null;
        verificationExternalActivity.line4 = null;
        verificationExternalActivity.content = null;
        verificationExternalActivity.layout4 = null;
        verificationExternalActivity.tab1 = null;
        verificationExternalActivity.tab2 = null;
        verificationExternalActivity.tab3 = null;
        this.view7f0a00ed.setOnClickListener(null);
        this.view7f0a00ed = null;
        this.view7f0a00ee.setOnClickListener(null);
        this.view7f0a00ee = null;
        this.view7f0a00ef.setOnClickListener(null);
        this.view7f0a00ef = null;
        this.view7f0a00f0.setOnClickListener(null);
        this.view7f0a00f0 = null;
    }
}
