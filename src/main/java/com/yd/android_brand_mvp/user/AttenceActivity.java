package com.yd.android_brand_mvp.user;

import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentL;
import com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentP;
import com.yd.android_brand_mvp.model.EventTimerBean;
import com.yd.android_brand_mvp.utils.SpData;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceActivity extends BaseLayoutActivity {
    int index;

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "考勤";
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        if (ScreenUtils.isLandscape()) {
            return new AttendanceFragmentL();
        }
        return new AttendanceFragmentP();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.listener != null && this.index == 0) {
            this.listener.OnFragmentEvent(keyEvent);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        setBtn(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void thread(EventTimerBean eventTimerBean) {
        setAcountDown(60);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        SPUtils.getInstance().put(SpData.AttenceEnable, "1");
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public int getIndex() {
        return this.index;
    }
}
