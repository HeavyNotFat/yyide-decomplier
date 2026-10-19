package com.yd.android_brand_mvp.portrait.activity;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.dialog.TimeDialog;
import com.yd.android_brand_mvp.landscape.SettingFragment;
import com.yd.android_brand_mvp.model.UpdateDialogIsTimeEventBean;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.VideoUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes4.dex */
public class SettingPActivity extends BaseLayoutActivity {
    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "设置";
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        SettingFragment settingFragment = new SettingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", getIntent().getStringExtra("type"));
        settingFragment.setArguments(bundle);
        return settingFragment;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        getWindow().getAttributes().gravity = 5;
        Tool.getScreenConfiguration(this);
        EventBus.getDefault().post("1");
        this.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.portrait.activity.SettingPActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new TimeDialog(SettingPActivity.this.mActivity, "").show();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void isStartTime(UpdateDialogIsTimeEventBean updateDialogIsTimeEventBean) {
        if (updateDialogIsTimeEventBean.typt == 1) {
            this.isSecondLevel = false;
            removeCallHandler();
        } else if (updateDialogIsTimeEventBean.typt == 2 && this.isAutoClose) {
            this.isSecondLevel = true;
            BaseConstant.exitTime = 180;
            startThread();
        }
        EventBus.getDefault().cancelEventDelivery(updateDialogIsTimeEventBean);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
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
