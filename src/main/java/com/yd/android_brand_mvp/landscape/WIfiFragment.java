package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.hacknife.wifimanager.IWifi;
import com.hacknife.wifimanager.IWifiManager;
import com.hacknife.wifimanager.OnWifiChangeListener;
import com.hacknife.wifimanager.OnWifiConnectListener;
import com.hacknife.wifimanager.OnWifiStateChangeListener;
import com.hacknife.wifimanager.State;
import com.hacknife.wifimanager.WifiManager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.WifiAdapter;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.dialog.WifiPassWordDiallog;
import com.yd.android_brand_mvp.dialog.WifiSaveDiallog;
import com.yd.android_brand_mvp.model.NetWorkCheckBean;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class WIfiFragment extends BaseFragment implements OnWifiChangeListener, OnWifiConnectListener, OnWifiStateChangeListener {

    @BindView(R.id.checkbox)
    CheckedTextView checkbox;
    private FragmentManager fm;
    EditText inputServer;
    private LinearLayoutManager linearLayoutManager;
    ArrayList<IWifi> list;
    IWifiManager manager;
    private WifiAdapter myAdapter;

    @BindView(R.id.rc_view)
    RecyclerView rc_view;

    @BindView(R.id.wifi_back)
    LinearLayout wifi_back;
    boolean isclose = false;
    Handler handler = new Handler() { // from class: com.yd.android_brand_mvp.landscape.WIfiFragment.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1 || WIfiFragment.this.mActivity.isDestroyed()) {
                return;
            }
            WIfiFragment.this.nomalLoadingDiallog.dismiss();
        }
    };
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.WIfiFragment.4
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            WIfiFragment.this.handler.sendMessage(message);
            WIfiFragment.this.setWifiStuas();
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_wifi, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
        setWifiStuas();
        Log.e("TAG", "onViewCreated: ==>wifi");
        this.checkbox.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.WIfiFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (WIfiFragment.this.manager.isOpened()) {
                    WIfiFragment.this.isclose = true;
                    WIfiFragment.this.manager.disConnectWifi();
                } else {
                    WIfiFragment.this.isclose = false;
                    WIfiFragment.this.manager.openWifi();
                }
                if (WIfiFragment.this.mActivity.isDestroyed()) {
                    WIfiFragment.this.nomalLoadingDiallog.show();
                }
                WIfiFragment.this.checkbox.setEnabled(false);
                WIfiFragment.this.handler.postDelayed(WIfiFragment.this.runnable, 1500L);
            }
        });
    }

    private void initData() {
        ArrayList<IWifi> arrayList = new ArrayList<>();
        this.list = arrayList;
        this.myAdapter = new WifiAdapter(arrayList, this.rc_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
        this.linearLayoutManager = linearLayoutManager;
        this.rc_view.setLayoutManager(linearLayoutManager);
        this.rc_view.setAdapter(this.myAdapter);
        IWifiManager iWifiManagerCreate = WifiManager.create(this.mActivity);
        this.manager = iWifiManagerCreate;
        iWifiManagerCreate.setOnWifiChangeListener(this);
        this.manager.setOnWifiConnectListener(this);
        this.manager.setOnWifiStateChangeListener(this);
        if (this.manager.isOpened()) {
            this.manager.scanWifi();
        }
        Log.e("TAG", "initData: ");
        this.myAdapter.setOnItemClickListener(new WifiAdapter.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.WIfiFragment.2
            @Override // com.yd.android_brand_mvp.adapter.WifiAdapter.OnItemClickListener
            public void onItemClick(View view, final int i) {
                Log.e("TAG", "onItemClick: " + JSON.toJSONString(WIfiFragment.this.myAdapter.mData.get(i)));
                if (!WIfiFragment.this.myAdapter.mData.get(i).isConnected()) {
                    if (WIfiFragment.this.myAdapter.mData.get(i).isSaved()) {
                        WIfiFragment.this.manager.connectSavedWifi(WIfiFragment.this.myAdapter.mData.get(i));
                        return;
                    }
                    final WifiPassWordDiallog wifiPassWordDiallog = new WifiPassWordDiallog(WIfiFragment.this.mActivity, "请输入密码");
                    wifiPassWordDiallog.setOnClickLister(new WifiPassWordDiallog.WifiOnClickLister() { // from class: com.yd.android_brand_mvp.landscape.WIfiFragment.2.2
                        @Override // com.yd.android_brand_mvp.dialog.WifiPassWordDiallog.WifiOnClickLister
                        public void rightOnClick() {
                            WIfiFragment.this.manager.connectEncryptWifi(WIfiFragment.this.myAdapter.mData.get(i), wifiPassWordDiallog.getEditString());
                        }
                    });
                    wifiPassWordDiallog.show();
                    return;
                }
                WifiSaveDiallog wifiSaveDiallog = new WifiSaveDiallog(WIfiFragment.this.mActivity, "是否要取消保存");
                wifiSaveDiallog.setOnClickLister(new WifiSaveDiallog.WifiOnClickLister() { // from class: com.yd.android_brand_mvp.landscape.WIfiFragment.2.1
                    @Override // com.yd.android_brand_mvp.dialog.WifiSaveDiallog.WifiOnClickLister
                    public void rightOnClick() {
                        WIfiFragment.this.manager.removeWifi(WIfiFragment.this.myAdapter.mData.get(i));
                    }
                });
                wifiSaveDiallog.show();
            }
        });
    }

    void setWifiStuas() {
        IWifiManager iWifiManager;
        CheckedTextView checkedTextView = this.checkbox;
        if (checkedTextView == null || (iWifiManager = this.manager) == null) {
            return;
        }
        checkedTextView.setChecked(iWifiManager.isOpened());
        this.checkbox.setEnabled(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fm = getFragmentManager();
    }

    @OnClick({R.id.wifi_back, R.id.tv_yt})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != R.id.tv_yt) {
            if (id != R.id.wifi_back) {
                return;
            }
            this.fm.popBackStack();
        } else if (this.checkbox.isEnabled()) {
            EventBus.getDefault().post(new NetWorkCheckBean(2));
        }
    }

    @Override // com.hacknife.wifimanager.OnWifiChangeListener
    public void onWifiChanged(List<IWifi> list) {
        Log.e("wick1", "111111111111  " + list.size());
        ArrayList<IWifi> arrayList = (ArrayList) list;
        this.list = arrayList;
        if (this.isclose) {
            return;
        }
        this.myAdapter.updateData(arrayList);
        setWifiStuas();
    }

    @Override // com.hacknife.wifimanager.OnWifiConnectListener
    public void onConnectChanged(boolean z) {
        Log.e("TAG", "onConnectChanged: " + z);
        if (this.isclose) {
            Log.e("TAG", "closeWifi: ");
            this.manager.closeWifi();
            ArrayList<IWifi> arrayList = new ArrayList<>();
            this.list = arrayList;
            this.myAdapter.updateData(arrayList);
        }
    }

    @Override // com.hacknife.wifimanager.OnWifiStateChangeListener
    public void onStateChanged(State state) {
        Log.e("TAG", "onStateChanged: " + state);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.manager.destroy();
        this.handler.removeCallbacks(this.runnable);
        this.handler.removeCallbacksAndMessages(null);
    }
}
