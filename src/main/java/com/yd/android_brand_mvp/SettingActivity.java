package com.yd.android_brand_mvp;

import android.app.ProgressDialog;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.blankj.utilcode.util.LogUtils;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.landscape.SettingFragment;
import com.yd.android_brand_mvp.model.UpdateDialogIsTimeEventBean;
import com.yd.android_brand_mvp.utils.VideoUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes4.dex */
public class SettingActivity extends BaseActivity {
    private int NetType;
    public AudioManager audiomanage;
    private int currentVolume;

    @BindView(R.id.fm_setting)
    FrameLayout fm_setting;
    private int maxVolume;
    SeekBar seekBar;
    TextView tv_currentVolume;
    ProgressDialog progressDialog = null;
    private int volume = 0;

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_landscape);
        LogUtils.i("SettingActivity");
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        getWindow().getAttributes().gravity = 5;
        EventBus.getDefault().post("1");
        VideoUtils.setVideoState(this, "1");
        getWindow().setLayout(-2, -1);
        SettingFragment settingFragment = new SettingFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", getIntent().getStringExtra("type"));
        settingFragment.setArguments(bundle2);
        getSupportFragmentManager().beginTransaction().add(R.id.fm_setting, settingFragment).commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void isStartTime(UpdateDialogIsTimeEventBean updateDialogIsTimeEventBean) {
        if (updateDialogIsTimeEventBean.typt == 1) {
            this.isSecondLevel = false;
            removeCallHandler();
        } else if (updateDialogIsTimeEventBean.typt == 2 && this.isAutoClose) {
            this.isSecondLevel = true;
            BaseConstant.exitOutTime = 60;
            startThread();
        }
        EventBus.getDefault().cancelEventDelivery(updateDialogIsTimeEventBean);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        setAcountDown(60);
        BroCast.hidebar(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        VideoUtils.setVideoMute(this);
        EventBus.getDefault().unregister(this);
    }
}
