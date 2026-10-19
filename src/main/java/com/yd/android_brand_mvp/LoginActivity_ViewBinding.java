package com.yd.android_brand_mvp;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class LoginActivity_ViewBinding implements Unbinder {
    private LoginActivity target;
    private View view7f0a005b;
    private View view7f0a0233;
    private View view7f0a0345;
    private View view7f0a039e;
    private View view7f0a045c;
    private View view7f0a04f8;
    private View view7f0a06eb;
    private View view7f0a08a5;

    public LoginActivity_ViewBinding(LoginActivity loginActivity) {
        this(loginActivity, loginActivity.getWindow().getDecorView());
    }

    public LoginActivity_ViewBinding(final LoginActivity loginActivity, View view) {
        this.target = loginActivity;
        loginActivity.user = (EditText) Utils.findRequiredViewAsType(view, R.id.user, "field 'user'", EditText.class);
        loginActivity.psd = (EditText) Utils.findRequiredViewAsType(view, R.id.psd, "field 'psd'", EditText.class);
        loginActivity.tips = (TextView) Utils.findRequiredViewAsType(view, R.id.tips, "field 'tips'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.config, "field 'config' and method 'onViewClicked'");
        loginActivity.config = (TextView) Utils.castView(viewFindRequiredView, R.id.config, "field 'config'", TextView.class);
        this.view7f0a0233 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.LoginActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                loginActivity.onViewClicked(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.registerBtn, "field 'registerBtn' and method 'onViewClicked'");
        loginActivity.registerBtn = (TextView) Utils.castView(viewFindRequiredView2, R.id.registerBtn, "field 'registerBtn'", TextView.class);
        this.view7f0a06eb = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.LoginActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                loginActivity.onViewClicked(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.activateBtn, "field 'activateBtn' and method 'onViewClicked'");
        loginActivity.activateBtn = (TextView) Utils.castView(viewFindRequiredView3, R.id.activateBtn, "field 'activateBtn'", TextView.class);
        this.view7f0a005b = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.LoginActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                loginActivity.onViewClicked(view2);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.go2qrcode, "field 'go2qrcode' and method 'onViewClicked'");
        loginActivity.go2qrcode = (TextView) Utils.castView(viewFindRequiredView4, R.id.go2qrcode, "field 'go2qrcode'", TextView.class);
        this.view7f0a039e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.LoginActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                loginActivity.onViewClicked(view2);
            }
        });
        loginActivity.llAccount = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_account, "field 'llAccount'", LinearLayout.class);
        loginActivity.qrcode = (ImageView) Utils.findRequiredViewAsType(view, R.id.qrcode, "field 'qrcode'", ImageView.class);
        loginActivity.llQrcode = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_qrcode, "field 'llQrcode'", LinearLayout.class);
        loginActivity.progress = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progress, "field 'progress'", ProgressBar.class);
        loginActivity.welcome = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.welcome, "field 'welcome'", LinearLayout.class);
        loginActivity.register_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.register_layout, "field 'register_layout'", LinearLayout.class);
        loginActivity.name_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.name_layout, "field 'name_layout'", LinearLayout.class);
        loginActivity.password_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.password_layout, "field 'password_layout'", LinearLayout.class);
        loginActivity.register = (EditText) Utils.findRequiredViewAsType(view, R.id.register, "field 'register'", EditText.class);
        loginActivity.getCode = (TextView) Utils.findRequiredViewAsType(view, R.id.getCode, "field 'getCode'", TextView.class);
        loginActivity.activateLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.activate_layout, "field 'activateLayout'", LinearLayout.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.jump_to_main, "field 'jumpToMain' and method 'onViewClicked'");
        loginActivity.jumpToMain = (TextView) Utils.castView(viewFindRequiredView5, R.id.jump_to_main, "field 'jumpToMain'", TextView.class);
        this.view7f0a04f8 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.LoginActivity_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                loginActivity.onViewClicked(view2);
            }
        });
        loginActivity.school_layout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.school_layout, "field 'school_layout'", FrameLayout.class);
        loginActivity.AuthCode = (TextView) Utils.findRequiredViewAsType(view, R.id.AuthCode, "field 'AuthCode'", TextView.class);
        loginActivity.getFaceCode = (TextView) Utils.findRequiredViewAsType(view, R.id.getFaceCode, "field 'getFaceCode'", TextView.class);
        loginActivity.facelayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.face_layout, "field 'facelayout'", LinearLayout.class);
        loginActivity.showcode = (TextView) Utils.findRequiredViewAsType(view, R.id.showcode, "field 'showcode'", TextView.class);
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.flQRRefresh, "field 'flQRRefresh' and method 'onViewClicked'");
        loginActivity.flQRRefresh = (FrameLayout) Utils.castView(viewFindRequiredView6, R.id.flQRRefresh, "field 'flQRRefresh'", FrameLayout.class);
        this.view7f0a0345 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.LoginActivity_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                loginActivity.onViewClicked(view2);
            }
        });
        loginActivity.llQRConfirm = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llQRConfirm, "field 'llQRConfirm'", LinearLayout.class);
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tvAccount, "method 'onViewClicked'");
        this.view7f0a08a5 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.LoginActivity_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                loginActivity.onViewClicked(view2);
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.ivSet, "method 'onViewClicked'");
        this.view7f0a045c = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.LoginActivity_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                loginActivity.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LoginActivity loginActivity = this.target;
        if (loginActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        loginActivity.user = null;
        loginActivity.psd = null;
        loginActivity.tips = null;
        loginActivity.config = null;
        loginActivity.registerBtn = null;
        loginActivity.activateBtn = null;
        loginActivity.go2qrcode = null;
        loginActivity.llAccount = null;
        loginActivity.qrcode = null;
        loginActivity.llQrcode = null;
        loginActivity.progress = null;
        loginActivity.welcome = null;
        loginActivity.register_layout = null;
        loginActivity.name_layout = null;
        loginActivity.password_layout = null;
        loginActivity.register = null;
        loginActivity.getCode = null;
        loginActivity.activateLayout = null;
        loginActivity.jumpToMain = null;
        loginActivity.school_layout = null;
        loginActivity.AuthCode = null;
        loginActivity.getFaceCode = null;
        loginActivity.facelayout = null;
        loginActivity.showcode = null;
        loginActivity.flQRRefresh = null;
        loginActivity.llQRConfirm = null;
        this.view7f0a0233.setOnClickListener(null);
        this.view7f0a0233 = null;
        this.view7f0a06eb.setOnClickListener(null);
        this.view7f0a06eb = null;
        this.view7f0a005b.setOnClickListener(null);
        this.view7f0a005b = null;
        this.view7f0a039e.setOnClickListener(null);
        this.view7f0a039e = null;
        this.view7f0a04f8.setOnClickListener(null);
        this.view7f0a04f8 = null;
        this.view7f0a0345.setOnClickListener(null);
        this.view7f0a0345 = null;
        this.view7f0a08a5.setOnClickListener(null);
        this.view7f0a08a5 = null;
        this.view7f0a045c.setOnClickListener(null);
        this.view7f0a045c = null;
    }
}
