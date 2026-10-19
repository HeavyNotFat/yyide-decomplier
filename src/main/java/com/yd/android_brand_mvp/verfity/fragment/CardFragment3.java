package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.SettingActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.portrait.activity.SettingPActivity;
import com.yd.android_brand_mvp.presenter.TeacherToSettingPresenter;
import com.yd.android_brand_mvp.utils.CardInputUtils;
import com.yd.android_brand_mvp.utils.SettingPermision;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.verfity.RestoreVerificationRouter;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity;
import com.yd.android_brand_mvp.view.TeacherToSettingCardView;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class CardFragment3 extends BaseMvpFragment<TeacherToSettingPresenter> implements TeacherToSettingCardView, ObserverListener, FragmentEventListener {
    TeacherCheackActivity activity;
    private final StringBuffer buffer = new StringBuffer();
    String cardNo;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_card, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TeacherCheackActivity teacherCheackActivity = (TeacherCheackActivity) getActivity();
        this.activity = teacherCheackActivity;
        teacherCheackActivity.setKeyeventListener(this);
    }

    @Override // com.yd.android_brand_mvp.net.FragmentEventListener
    public boolean OnFragmentEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            Log.i("OnFragmentEvent", "USB keyCode = " + keyCode);
            if (keyCode >= 7 && keyCode <= 16) {
                this.buffer.append(keyCode - 7);
            } else if (keyCode >= 144 && keyCode <= 153) {
                this.buffer.append(keyCode - 144);
            } else if (keyCode == 66 || keyCode == 160) {
                String rawCard = this.buffer.toString();
                if (rawCard.length() == 10 || RestoreVerificationRouter.isAllEights(rawCard)) {
                    String strCleanCardZero = CardInputUtils.cleanCardZero(rawCard);
                    Log.i("OnFragmentEvent", "USB 刷卡卡号 = " + strCleanCardZero);
                    this.cardNo = strCleanCardZero;
                    // 还原版：全 8 卡号进教师端，1234567890 进学生空间。
                    if (RestoreVerificationRouter.handleCard(this.mActivity, strCleanCardZero)) {
                        this.buffer.setLength(0);
                        return false;
                    }
                    showLoading();
                    ((TeacherToSettingPresenter) this.mvpPresenter).selectTeacherByClassesId("", strCleanCardZero);
                }
                this.buffer.setLength(0);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public TeacherToSettingPresenter createPresenter() {
        return new TeacherToSettingPresenter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObserverManager.getInstance().add(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ObserverManager.getInstance().remove(this);
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String str) {
        if (this.activity.getIndex() == 0) {
            this.cardNo = str;
            if (RestoreVerificationRouter.handleCard(this.mActivity, str)) {
                return;
            }
            showLoading();
            ((TeacherToSettingPresenter) this.mvpPresenter).selectTeacherByClassesId("", str);
        }
    }

    void startAc() {
        if (ScreenUtils.isLandscape()) {
            startActivity(new Intent(this.mActivity, (Class<?>) SettingActivity.class));
        } else {
            startActivity(new Intent(this.mActivity, (Class<?>) SettingPActivity.class));
        }
    }

    @Override // com.yd.android_brand_mvp.view.TeacherToSettingCardView
    public void selectTeacherByClassesIdRspSuccess(selectTeacherByClassesIdRsp selectteacherbyclassesidrsp) {
        LogUtils.i("cardNo:" + this.cardNo);
        hideLoading();
        if (selectteacherbyclassesidrsp.code.intValue() == 0) {
            if (selectteacherbyclassesidrsp.data != null && !selectteacherbyclassesidrsp.data.isEmpty()) {
                int intExtra = getActivity().getIntent().getIntExtra("type", 0);
                if (intExtra == BaseConstant.homeOver) {
                    EventBus.getDefault().post(new EventBean(intExtra, selectteacherbyclassesidrsp.data.get(0).id, selectteacherbyclassesidrsp.data.get(0).name));
                } else {
                    startAc();
                }
                getActivity().finish();
                return;
            }
            ToastUtil.showBottomView(this.mActivity, FaceMsg.no_permission);
            return;
        }
        ToastUtil.showBottomView(this.mActivity, "刷卡失败");
    }

    @Override // com.yd.android_brand_mvp.view.TeacherToSettingCardView
    public void selectTeacherByClassesIdRspFail(String str) {
        hideLoading();
        onlineVerify();
    }

    private void onlineVerify() {
        if (SettingPermision.getInstance().isHavePermission(this.cardNo, "")) {
            LogUtils.i("教师验证：" + this.cardNo);
            selectTeacherByClassesIdRsp.DataDTO dataDTO = SettingPermision.getInstance().mDataDTO;
            int intExtra = getActivity().getIntent().getIntExtra("type", 0);
            if (intExtra != BaseConstant.homeOver) {
                startAc();
                getActivity().finish();
                return;
            } else if (dataDTO != null) {
                EventBus.getDefault().post(new EventBean(intExtra, dataDTO.id, dataDTO.name));
                getActivity().finish();
                return;
            } else {
                ToastUtil.showBottomView(this.mActivity, FaceMsg.no_permission);
                return;
            }
        }
        ToastUtil.showBottomView(this.mActivity, "未找到相应人员" + this.cardNo);
        LogUtils.e("未找到相应人员" + this.cardNo);
    }
}
