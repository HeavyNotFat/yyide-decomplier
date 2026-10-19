package com.yd.android_brand_mvp.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.ttlock.bl.sdk.api.TTLockClient;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.BluetoothService;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.dialog.ConnectDiallog;
import com.yd.android_brand_mvp.mina.MinaEventType;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes4.dex */
public class doorControlActivity extends AppCompatActivity {
    protected static final int REQUEST_PERMISSION_REQ_CODE = 11;

    @BindView(R.id.Reconnection)
    FrameLayout Reconnection;
    BluetoothService bluetoothService;

    @BindView(R.id.delectconnect)
    FrameLayout delectconnect;

    @BindView(R.id.device)
    TextView device;

    @BindView(R.id.ll_back)
    LinearLayout llBack;

    @BindView(R.id.open)
    Button open;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tvRC)
    TextView tvRC;

    @BindView(R.id.tvUD)
    TextView tvUD;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_door_control);
        ButterKnife.bind(this);
        this.llBack.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$doorControlActivity$Wny287JxFLTcP9AMUwxx1VB56tk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$doorControlActivity(view);
            }
        });
        EventBus.getDefault().register(this);
        this.tvRC.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.icon_cxlj), (Drawable) null, (Drawable) null, (Drawable) null);
        this.tvUD.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.icon_cxlj), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public /* synthetic */ void lambda$onCreate$0$doorControlActivity(View view) {
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.delectconnect.setEnabled(false);
        BroCast.start(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MinaEventType minaEventType) {
        if (minaEventType.i == 666) {
            if (BaseApplication.getInstance().getChoosedLock() != null) {
                this.device.setText("已连接：" + BaseApplication.getInstance().getChoosedLock().getLockName());
                this.delectconnect.setEnabled(true);
                return;
            }
            this.device.setText("未连接");
            this.delectconnect.setEnabled(false);
        }
    }

    @OnClick({R.id.Reconnection, R.id.delectconnect})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.Reconnection) {
            initBtService();
        } else {
            if (id != R.id.delectconnect) {
                return;
            }
            new ConnectDiallog(this).show();
        }
    }

    private void initBtService() {
        TTLockClient.getDefault().prepareBTService(getApplicationContext());
        if (!TTLockClient.getDefault().isBLEEnabled(this)) {
            TTLockClient.getDefault().requestBleEnable(this);
        } else {
            startScan();
        }
    }

    private void startScan() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 11);
            Log.i("TAG", "requestPermissions: ");
        } else {
            startActivity(new Intent(this, (Class<?>) doorListActivity.class));
        }
    }
}
