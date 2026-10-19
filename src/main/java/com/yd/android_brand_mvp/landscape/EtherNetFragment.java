package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.C;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.model.NetWorkCheckBean;
import com.yd.android_brand_mvp.utils.PingUtils;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.ys.rkapi.MyManager;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class EtherNetFragment extends BaseFragment {

    @BindView(R.id.ckAuto)
    CheckBox checkBoxAuto;

    @BindView(R.id.ckNoAuto)
    CheckBox checkBoxNoAuto;

    @BindView(R.id.checkbox)
    CheckedTextView checkbox;

    @BindView(R.id.et_dns1)
    EditText etDns1;

    @BindView(R.id.et_dns2)
    EditText etDns2;

    @BindView(R.id.et_gateway)
    EditText etGateway;

    @BindView(R.id.et_ip)
    EditText etIp;

    @BindView(R.id.et_subnet)
    EditText etSubnet;

    @BindView(R.id.ether_back)
    LinearLayout ether_back;
    MyManager manager;

    @BindView(R.id.rl_title)
    RelativeLayout rl_title;

    @BindView(R.id.tvSetIp)
    TextView tvSetIp;

    @BindView(R.id.tv_ether_mode)
    TextView tv_ether_mode;

    @BindView(R.id.tv_mac)
    TextView tv_mac;
    private final String TAG = EtherNetFragment.class.getSimpleName();
    Handler handler = new Handler();
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$EtherNetFragment$r89Wq9JFyswrQ2s-Od7YptY7S6g
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$4$EtherNetFragment();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return ScreenUtils.isLandscape() ? layoutInflater.inflate(R.layout.activity_ether_nets_message_l, viewGroup, false) : layoutInflater.inflate(R.layout.activity_ether_nets_message, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.manager = MyManager.getInstance(this.mActivity);
        initView();
    }

    private void initView() {
        Log.e(this.TAG, "onViewCreated: ==>NetWork");
        this.checkbox.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$EtherNetFragment$ydCZEa77pfUlWSUE_MclFDESmiA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initView$0$EtherNetFragment(view);
            }
        });
        initData();
        this.checkBoxAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$EtherNetFragment$jqpXplZ_pTlX_jOiIW8iCsGMuSE
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.lambda$initView$1$EtherNetFragment(compoundButton, z);
            }
        });
        this.checkBoxNoAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$EtherNetFragment$FUkQDPpdp_3Xhs-1eUf6Qw80ZFQ
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f$0.lambda$initView$2$EtherNetFragment(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$EtherNetFragment(View view) {
        int currentNetType = this.manager.getCurrentNetType();
        Log.i(this.TAG, "netType = " + currentNetType);
        if (currentNetType == 0) {
            this.manager.ethEnabled(false);
            this.checkbox.setChecked(false);
            this.checkBoxNoAuto.setVisibility(4);
            this.checkBoxAuto.setVisibility(4);
            return;
        }
        this.manager.ethEnabled(true);
        this.checkBoxNoAuto.setVisibility(0);
        this.checkBoxAuto.setVisibility(0);
        if (!this.mActivity.isDestroyed()) {
            this.nomalLoadingDiallog.show();
        }
        this.handler.postDelayed(this.runnable, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    public /* synthetic */ void lambda$initView$1$EtherNetFragment(CompoundButton compoundButton, boolean z) {
        if (z) {
            Log.i(this.TAG, "动态模式");
            this.manager.setDhcpIpAddress(requireContext());
            this.checkBoxNoAuto.setChecked(false);
            this.etIp.setEnabled(false);
            this.etGateway.setEnabled(false);
            this.etSubnet.setEnabled(false);
            this.etDns1.setEnabled(false);
            this.etDns2.setEnabled(false);
            if (!this.mActivity.isDestroyed()) {
                this.nomalLoadingDiallog.show();
            }
            this.handler.postDelayed(this.runnable, 1000L);
        }
    }

    public /* synthetic */ void lambda$initView$2$EtherNetFragment(CompoundButton compoundButton, boolean z) {
        if (z) {
            Log.i(this.TAG, "静态模式");
            this.checkBoxAuto.setChecked(false);
            this.etIp.setEnabled(true);
            this.etGateway.setEnabled(true);
            this.etSubnet.setEnabled(true);
            this.etDns1.setEnabled(true);
            this.etDns2.setEnabled(true);
            EditText editText = this.etIp;
            editText.setSelection(editText.getText().toString().trim().length());
            this.etIp.requestFocus();
            this.manager.setStaticEthIPAddress(this.etIp.getText().toString().trim(), this.etGateway.getText().toString().trim(), this.etSubnet.getText().toString().trim(), this.etDns1.getText().toString().trim(), this.etDns2.getText().toString().trim());
            this.tvSetIp.setVisibility(0);
        }
    }

    private void setIp() {
        String strTrim = this.etIp.getText().toString().trim();
        String strTrim2 = this.etGateway.getText().toString().trim();
        String strTrim3 = this.etSubnet.getText().toString().trim();
        String strTrim4 = this.etDns1.getText().toString().trim();
        String strTrim5 = this.etDns2.getText().toString().trim();
        if (!PingUtils.INSTANCE.isMatch(strTrim)) {
            this.etIp.setError("请输入正确的IP");
            return;
        }
        if (!PingUtils.INSTANCE.isMatch(strTrim2)) {
            this.etGateway.setError("请输入正确的网关");
            return;
        }
        if (!PingUtils.INSTANCE.isMatch(strTrim3)) {
            this.etSubnet.setError("请输入正确的子掩码");
        } else if (!PingUtils.INSTANCE.isMatch(strTrim4)) {
            this.etDns1.setError("请输入正确的dns1");
        } else {
            this.manager.setStaticEthIPAddress(strTrim, strTrim2, strTrim3, strTrim4, strTrim5);
            ToastUtil.showBottomView(this.mActivity, "设置静态Ip成功");
        }
    }

    public /* synthetic */ void lambda$new$4$EtherNetFragment() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$EtherNetFragment$zJL-P6rmb_yZG7mSxF50O3YbwNc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$3$EtherNetFragment();
            }
        });
        initData();
    }

    public /* synthetic */ void lambda$new$3$EtherNetFragment() {
        if (this.mActivity.isDestroyed()) {
            return;
        }
        this.nomalLoadingDiallog.dismiss();
    }

    private void initData() {
        String staticEthIPAddress;
        int currentNetType = this.manager.getCurrentNetType();
        String ethMode = this.manager.getEthMode();
        boolean ethStatus = this.manager.getEthStatus();
        Log.i(this.TAG, "ethMode = " + ethMode);
        Log.i(this.TAG, "netType = " + currentNetType);
        Log.i(this.TAG, "ethStatus = " + ethStatus);
        if (currentNetType == -100 && !ethStatus) {
            this.checkbox.setChecked(false);
            this.checkBoxAuto.setChecked(false);
            this.checkBoxNoAuto.setChecked(false);
            this.tvSetIp.setVisibility(4);
            return;
        }
        String ethMacAddress = this.manager.getEthMacAddress();
        if (ethMode.equals("DHCP")) {
            staticEthIPAddress = this.manager.getDhcpIpAddress();
        } else {
            staticEthIPAddress = ethMode.equals("StaticIp") ? this.manager.getStaticEthIPAddress() : "";
        }
        String netMask = this.manager.getNetMask();
        String gateway = this.manager.getGateway();
        String ethDns1 = this.manager.getEthDns1();
        String ethDns2 = this.manager.getEthDns2();
        this.checkbox.setChecked(ethStatus);
        this.checkbox.setEnabled(true);
        if (!TextUtils.isEmpty(ethMacAddress)) {
            this.tv_mac.setText(ethMacAddress);
        }
        if (!TextUtils.isEmpty(staticEthIPAddress)) {
            this.etIp.setText(staticEthIPAddress);
        }
        if (!TextUtils.isEmpty(netMask)) {
            this.etSubnet.setText(netMask);
        }
        if (!TextUtils.isEmpty(gateway)) {
            this.etGateway.setText(gateway);
        }
        if (!TextUtils.isEmpty(ethDns1)) {
            this.etDns1.setText(ethDns1);
        }
        if (!TextUtils.isEmpty(ethDns2)) {
            this.etDns2.setText(ethDns2);
        }
        if (TextUtils.isEmpty(ethMode) || !ethStatus) {
            return;
        }
        if (ethMode.equals("StaticIp")) {
            this.tv_ether_mode.setText("静态代理");
            if (this.checkBoxNoAuto.isChecked()) {
                return;
            }
            this.checkBoxNoAuto.setChecked(true);
            this.tvSetIp.setVisibility(0);
            this.etIp.setEnabled(true);
            this.etGateway.setEnabled(true);
            this.etSubnet.setEnabled(true);
            this.etDns1.setEnabled(true);
            this.etDns2.setEnabled(true);
            return;
        }
        if (ethMode.equals("DHCP")) {
            this.tv_ether_mode.setText("动态代理");
            if (!this.checkBoxAuto.isChecked()) {
                this.checkBoxAuto.setChecked(true);
                this.etIp.setEnabled(false);
                this.etGateway.setEnabled(false);
                this.etSubnet.setEnabled(false);
                this.etDns1.setEnabled(false);
                this.etDns2.setEnabled(false);
            }
            this.tvSetIp.setVisibility(4);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.runnable);
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @OnClick({R.id.ether_back, R.id.tv_wifi, R.id.tvSetIp})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.ether_back) {
            getFragmentManager().popBackStack();
            return;
        }
        if (id != R.id.tvSetIp) {
            if (id == R.id.tv_wifi && this.checkbox.isEnabled()) {
                EventBus.getDefault().post(new NetWorkCheckBean(1));
                return;
            }
            return;
        }
        setIp();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
