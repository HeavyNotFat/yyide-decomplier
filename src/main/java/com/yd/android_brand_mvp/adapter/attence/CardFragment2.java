package com.yd.android_brand_mvp.adapter.attence;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.utils.AttendanceUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.weight.CameraView;

/* JADX INFO: loaded from: classes4.dex */
public class CardFragment2 extends BaseFragment implements ObserverListener, FragmentEventListener {
    private static final String TAG = CardFragment2.class.getSimpleName();
    BaseActivity activity;

    @BindView(R.id.camera)
    CameraView camera;
    String cardNo;

    @BindView(R.id.fl_cameraView)
    FrameLayout fl_cameraView;

    @BindView(R.id.fl_card)
    FrameLayout fl_card;

    @BindView(R.id.pm)
    TextView pm;
    private boolean isCard = true;
    private final StringBuffer buffer = new StringBuffer();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate;
        if (ScreenUtils.isLandscape()) {
            viewInflate = layoutInflater.inflate(R.layout.fragment_card2, viewGroup, false);
        } else {
            viewInflate = layoutInflater.inflate(R.layout.fragment_card2_p, viewGroup, false);
        }
        this.activity = (BaseActivity) getActivity();
        ObserverManager.getInstance().add(this);
        this.activity.setKeyeventListener(this);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.net.FragmentEventListener
    public boolean OnFragmentEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode >= 7 && keyCode <= 16) {
                this.buffer.append(keyCode - 7);
            } else if (keyCode >= 144 && keyCode <= 153) {
                this.buffer.append(keyCode - 144);
            } else if (keyCode == 66 || keyCode == 160) {
                if (this.buffer.length() == 10) {
                    if (SpData.getAttenceRule2() != null) {
                        AttendanceUtils.INSTANCE.attendance(this.mActivity, this.cardNo, 2);
                    } else {
                        ToastUtil.showView(this.mActivity, "未查询到考勤规则");
                        LogUtils.i("CardFragment2", "未查询到考勤规则" + this.cardNo);
                    }
                }
                this.buffer.setLength(0);
            }
        }
        return false;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (BaseConstant.MY) {
            this.camera.setRotation(90.0f);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.isCard = !z;
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String str) {
        this.cardNo = str;
        Log.d(TAG, "isCard: " + this.isCard);
        Log.d(TAG, "observerUpData: " + str);
        if (this.isCard) {
            AttendanceUtils.INSTANCE.attendance(this.mActivity, str, 2);
        }
    }

    public void releaseCamera() {
        CameraView cameraView = this.camera;
        if (cameraView != null) {
            cameraView.onPause();
            this.camera.onDestroy();
            this.camera.releaseCamera2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        releaseCamera();
        ObserverManager.getInstance().remove(this);
    }
}
