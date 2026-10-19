package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class EtherNetFragment_ViewBinding implements Unbinder {
    private EtherNetFragment target;
    private View view7f0a02ef;
    private View view7f0a08f7;
    private View view7f0a0c27;

    public EtherNetFragment_ViewBinding(final EtherNetFragment etherNetFragment, View view) {
        this.target = etherNetFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tvSetIp, "field 'tvSetIp' and method 'onViewClicked'");
        etherNetFragment.tvSetIp = (TextView) Utils.castView(viewFindRequiredView, R.id.tvSetIp, "field 'tvSetIp'", TextView.class);
        this.view7f0a08f7 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.EtherNetFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                etherNetFragment.onViewClicked(view2);
            }
        });
        etherNetFragment.tv_mac = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mac, "field 'tv_mac'", TextView.class);
        etherNetFragment.tv_ether_mode = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ether_mode, "field 'tv_ether_mode'", TextView.class);
        etherNetFragment.etGateway = (EditText) Utils.findRequiredViewAsType(view, R.id.et_gateway, "field 'etGateway'", EditText.class);
        etherNetFragment.etSubnet = (EditText) Utils.findRequiredViewAsType(view, R.id.et_subnet, "field 'etSubnet'", EditText.class);
        etherNetFragment.etDns1 = (EditText) Utils.findRequiredViewAsType(view, R.id.et_dns1, "field 'etDns1'", EditText.class);
        etherNetFragment.etDns2 = (EditText) Utils.findRequiredViewAsType(view, R.id.et_dns2, "field 'etDns2'", EditText.class);
        etherNetFragment.etIp = (EditText) Utils.findRequiredViewAsType(view, R.id.et_ip, "field 'etIp'", EditText.class);
        etherNetFragment.rl_title = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'rl_title'", RelativeLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ether_back, "field 'ether_back' and method 'onViewClicked'");
        etherNetFragment.ether_back = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.ether_back, "field 'ether_back'", LinearLayout.class);
        this.view7f0a02ef = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.EtherNetFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                etherNetFragment.onViewClicked(view2);
            }
        });
        etherNetFragment.checkbox = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.checkbox, "field 'checkbox'", CheckedTextView.class);
        etherNetFragment.checkBoxAuto = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ckAuto, "field 'checkBoxAuto'", CheckBox.class);
        etherNetFragment.checkBoxNoAuto = (CheckBox) Utils.findRequiredViewAsType(view, R.id.ckNoAuto, "field 'checkBoxNoAuto'", CheckBox.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_wifi, "method 'onViewClicked'");
        this.view7f0a0c27 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.EtherNetFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                etherNetFragment.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        EtherNetFragment etherNetFragment = this.target;
        if (etherNetFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        etherNetFragment.tvSetIp = null;
        etherNetFragment.tv_mac = null;
        etherNetFragment.tv_ether_mode = null;
        etherNetFragment.etGateway = null;
        etherNetFragment.etSubnet = null;
        etherNetFragment.etDns1 = null;
        etherNetFragment.etDns2 = null;
        etherNetFragment.etIp = null;
        etherNetFragment.rl_title = null;
        etherNetFragment.ether_back = null;
        etherNetFragment.checkbox = null;
        etherNetFragment.checkBoxAuto = null;
        etherNetFragment.checkBoxNoAuto = null;
        this.view7f0a08f7.setOnClickListener(null);
        this.view7f0a08f7 = null;
        this.view7f0a02ef.setOnClickListener(null);
        this.view7f0a02ef = null;
        this.view7f0a0c27.setOnClickListener(null);
        this.view7f0a0c27 = null;
    }
}
