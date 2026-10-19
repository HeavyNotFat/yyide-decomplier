package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class SettingFragment_ViewBinding implements Unbinder {
    private SettingFragment target;
    private View view7f0a04ff;
    private View view7f0a0500;
    private View view7f0a0501;
    private View view7f0a0502;
    private View view7f0a0503;
    private View view7f0a0504;
    private View view7f0a0505;
    private View view7f0a0506;
    private View view7f0a0507;
    private View view7f0a0508;
    private View view7f0a0509;
    private View view7f0a0513;
    private View view7f0a0514;
    private View view7f0a0516;
    private View view7f0a051a;
    private View view7f0a051b;
    private View view7f0a0521;
    private View view7f0a0525;
    private View view7f0a057a;

    public SettingFragment_ViewBinding(final SettingFragment settingFragment, View view) {
        this.target = settingFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_back, "field 'llBack' and method 'onViewClicked'");
        settingFragment.llBack = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.ll_back, "field 'llBack'", LinearLayout.class);
        this.view7f0a057a = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.layout1, "field 'layout1' and method 'onViewClicked'");
        settingFragment.layout1 = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.layout1, "field 'layout1'", LinearLayout.class);
        this.view7f0a04ff = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.layout3, "field 'layout3' and method 'onViewClicked'");
        settingFragment.layout3 = (LinearLayout) Utils.castView(viewFindRequiredView3, R.id.layout3, "field 'layout3'", LinearLayout.class);
        this.view7f0a0502 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.layout4, "field 'layout4' and method 'onViewClicked'");
        settingFragment.layout4 = (LinearLayout) Utils.castView(viewFindRequiredView4, R.id.layout4, "field 'layout4'", LinearLayout.class);
        this.view7f0a0503 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.layout9, "field 'layout9' and method 'onViewClicked'");
        settingFragment.layout9 = (LinearLayout) Utils.castView(viewFindRequiredView5, R.id.layout9, "field 'layout9'", LinearLayout.class);
        this.view7f0a0509 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.layout10, "field 'layout10' and method 'onViewClicked'");
        settingFragment.layout10 = (LinearLayout) Utils.castView(viewFindRequiredView6, R.id.layout10, "field 'layout10'", LinearLayout.class);
        this.view7f0a0500 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.layout_get_face, "field 'getFaceCode' and method 'onViewClicked'");
        settingFragment.getFaceCode = (LinearLayout) Utils.castView(viewFindRequiredView7, R.id.layout_get_face, "field 'getFaceCode'", LinearLayout.class);
        this.view7f0a0516 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.layout5, "field 'layout5' and method 'onViewClicked'");
        settingFragment.layout5 = (LinearLayout) Utils.castView(viewFindRequiredView8, R.id.layout5, "field 'layout5'", LinearLayout.class);
        this.view7f0a0504 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.layout6, "field 'layout6' and method 'onViewClicked'");
        settingFragment.layout6 = (LinearLayout) Utils.castView(viewFindRequiredView9, R.id.layout6, "field 'layout6'", LinearLayout.class);
        this.view7f0a0505 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView10 = Utils.findRequiredView(view, R.id.layout7, "field 'layout7' and method 'onViewClicked'");
        settingFragment.layout7 = (LinearLayout) Utils.castView(viewFindRequiredView10, R.id.layout7, "field 'layout7'", LinearLayout.class);
        this.view7f0a0506 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView11 = Utils.findRequiredView(view, R.id.layout8, "field 'layout8' and method 'onViewClicked'");
        settingFragment.layout8 = (LinearLayout) Utils.castView(viewFindRequiredView11, R.id.layout8, "field 'layout8'", LinearLayout.class);
        this.view7f0a0507 = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView12 = Utils.findRequiredView(view, R.id.layout88, "field 'layout88' and method 'onViewClicked'");
        settingFragment.layout88 = (LinearLayout) Utils.castView(viewFindRequiredView12, R.id.layout88, "field 'layout88'", LinearLayout.class);
        this.view7f0a0508 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView13 = Utils.findRequiredView(view, R.id.layout_skin, "field 'layout_skin' and method 'onViewClicked'");
        settingFragment.layout_skin = (LinearLayout) Utils.castView(viewFindRequiredView13, R.id.layout_skin, "field 'layout_skin'", LinearLayout.class);
        this.view7f0a0525 = viewFindRequiredView13;
        viewFindRequiredView13.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView14 = Utils.findRequiredView(view, R.id.layout_open, "field 'layout_open' and method 'onViewClicked'");
        settingFragment.layout_open = (LinearLayout) Utils.castView(viewFindRequiredView14, R.id.layout_open, "field 'layout_open'", LinearLayout.class);
        this.view7f0a051b = viewFindRequiredView14;
        viewFindRequiredView14.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.14
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView15 = Utils.findRequiredView(view, R.id.layout_close, "field 'layout_close' and method 'onViewClicked'");
        settingFragment.layout_close = (LinearLayout) Utils.castView(viewFindRequiredView15, R.id.layout_close, "field 'layout_close'", LinearLayout.class);
        this.view7f0a0513 = viewFindRequiredView15;
        viewFindRequiredView15.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.15
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView16 = Utils.findRequiredView(view, R.id.layout_screen, "field 'layout_screen' and method 'onViewClicked'");
        settingFragment.layout_screen = (LinearLayout) Utils.castView(viewFindRequiredView16, R.id.layout_screen, "field 'layout_screen'", LinearLayout.class);
        this.view7f0a0521 = viewFindRequiredView16;
        viewFindRequiredView16.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.16
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        settingFragment.tv_bg_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.tv_bg_img, "field 'tv_bg_img'", ImageView.class);
        settingFragment.tv_bg_img2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.tv_bg_img2, "field 'tv_bg_img2'", ImageView.class);
        settingFragment.msg2 = (TextView) Utils.findRequiredViewAsType(view, R.id.msg2, "field 'msg2'", TextView.class);
        settingFragment.down = (ImageView) Utils.findRequiredViewAsType(view, R.id.down, "field 'down'", ImageView.class);
        settingFragment.tvLab4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_lab4, "field 'tvLab4'", TextView.class);
        settingFragment.tvLab3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_lab3, "field 'tvLab3'", TextView.class);
        settingFragment.mTvActivation = (TextView) Utils.findRequiredViewAsType(view, R.id.activation_textview, "field 'mTvActivation'", TextView.class);
        settingFragment.up = (ImageView) Utils.findRequiredViewAsType(view, R.id.up, "field 'up'", ImageView.class);
        settingFragment.rl_bg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_bg, "field 'rl_bg'", RelativeLayout.class);
        settingFragment.bg = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", FrameLayout.class);
        settingFragment.toplongview = (TextView) Utils.findRequiredViewAsType(view, R.id.toplongview, "field 'toplongview'", TextView.class);
        settingFragment.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        settingFragment.tvSkin = (TextView) Utils.findRequiredViewAsType(view, R.id.tvSkin, "field 'tvSkin'", TextView.class);
        settingFragment.layout99 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout99, "field 'layout99'", LinearLayout.class);
        settingFragment.tvScreen = (TextView) Utils.findRequiredViewAsType(view, R.id.tvScreen, "field 'tvScreen'", TextView.class);
        View viewFindRequiredView17 = Utils.findRequiredView(view, R.id.layout_config, "method 'onViewClicked'");
        this.view7f0a0514 = viewFindRequiredView17;
        viewFindRequiredView17.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.17
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView18 = Utils.findRequiredView(view, R.id.layout11, "method 'onViewClicked'");
        this.view7f0a0501 = viewFindRequiredView18;
        viewFindRequiredView18.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.18
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
        View viewFindRequiredView19 = Utils.findRequiredView(view, R.id.layout_network_test, "method 'onViewClicked'");
        this.view7f0a051a = viewFindRequiredView19;
        viewFindRequiredView19.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment_ViewBinding.19
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settingFragment.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SettingFragment settingFragment = this.target;
        if (settingFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settingFragment.llBack = null;
        settingFragment.layout1 = null;
        settingFragment.layout3 = null;
        settingFragment.layout4 = null;
        settingFragment.layout9 = null;
        settingFragment.layout10 = null;
        settingFragment.getFaceCode = null;
        settingFragment.layout5 = null;
        settingFragment.layout6 = null;
        settingFragment.layout7 = null;
        settingFragment.layout8 = null;
        settingFragment.layout88 = null;
        settingFragment.layout_skin = null;
        settingFragment.layout_open = null;
        settingFragment.layout_close = null;
        settingFragment.layout_screen = null;
        settingFragment.tv_bg_img = null;
        settingFragment.tv_bg_img2 = null;
        settingFragment.msg2 = null;
        settingFragment.down = null;
        settingFragment.tvLab4 = null;
        settingFragment.tvLab3 = null;
        settingFragment.mTvActivation = null;
        settingFragment.up = null;
        settingFragment.rl_bg = null;
        settingFragment.bg = null;
        settingFragment.toplongview = null;
        settingFragment.title = null;
        settingFragment.tvSkin = null;
        settingFragment.layout99 = null;
        settingFragment.tvScreen = null;
        this.view7f0a057a.setOnClickListener(null);
        this.view7f0a057a = null;
        this.view7f0a04ff.setOnClickListener(null);
        this.view7f0a04ff = null;
        this.view7f0a0502.setOnClickListener(null);
        this.view7f0a0502 = null;
        this.view7f0a0503.setOnClickListener(null);
        this.view7f0a0503 = null;
        this.view7f0a0509.setOnClickListener(null);
        this.view7f0a0509 = null;
        this.view7f0a0500.setOnClickListener(null);
        this.view7f0a0500 = null;
        this.view7f0a0516.setOnClickListener(null);
        this.view7f0a0516 = null;
        this.view7f0a0504.setOnClickListener(null);
        this.view7f0a0504 = null;
        this.view7f0a0505.setOnClickListener(null);
        this.view7f0a0505 = null;
        this.view7f0a0506.setOnClickListener(null);
        this.view7f0a0506 = null;
        this.view7f0a0507.setOnClickListener(null);
        this.view7f0a0507 = null;
        this.view7f0a0508.setOnClickListener(null);
        this.view7f0a0508 = null;
        this.view7f0a0525.setOnClickListener(null);
        this.view7f0a0525 = null;
        this.view7f0a051b.setOnClickListener(null);
        this.view7f0a051b = null;
        this.view7f0a0513.setOnClickListener(null);
        this.view7f0a0513 = null;
        this.view7f0a0521.setOnClickListener(null);
        this.view7f0a0521 = null;
        this.view7f0a0514.setOnClickListener(null);
        this.view7f0a0514 = null;
        this.view7f0a0501.setOnClickListener(null);
        this.view7f0a0501 = null;
        this.view7f0a051a.setOnClickListener(null);
        this.view7f0a051a = null;
    }
}
