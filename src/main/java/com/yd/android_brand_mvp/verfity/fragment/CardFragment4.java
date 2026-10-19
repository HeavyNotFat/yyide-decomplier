package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.SettingActivity;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.ValidationConstant;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.landscape.Wlkz2_2L;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.IdentityBean;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.portrait.activity.SettingPActivity;
import com.yd.android_brand_mvp.presenter.TeacherToSettingPresenter;
import com.yd.android_brand_mvp.utils.CardInputUtils;
import com.yd.android_brand_mvp.utils.SettingPermision;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.StudentPermision;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.RestoreVerificationRouter;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity2;
import com.yd.android_brand_mvp.view.TeacherToSettingCardView;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class CardFragment4 extends BaseMvpFragment<TeacherToSettingPresenter> implements TeacherToSettingCardView, ObserverListener, FragmentEventListener {
    TeacherCheackActivity2 activity;
    private final StringBuffer buffer = new StringBuffer();
    String cardNo;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_card, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TeacherCheackActivity2 teacherCheackActivity2 = (TeacherCheackActivity2) getActivity();
        this.activity = teacherCheackActivity2;
        teacherCheackActivity2.setKeyeventListener(this);
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
                String rawCard = this.buffer.toString();
                if (rawCard.length() == 10 || RestoreVerificationRouter.isAllEights(rawCard)) {
                    String card = CardInputUtils.cleanCardZero(rawCard);
                    if (RestoreVerificationRouter.handleCard(this.mActivity, card)) {
                        this.buffer.setLength(0);
                        return false;
                    }
                    ((TeacherToSettingPresenter) this.mvpPresenter).selectTeacherByClassesId("", card);
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

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String str) {
        if (this.activity.getIndex() == 0) {
            this.cardNo = str;
            if (RestoreVerificationRouter.handleCard(this.mActivity, str)) {
                return;
            }
            if (SettingPermision.getInstance().isHavePermission(str, "") || StudentPermision.getInstance().isHavePermission(str, "")) {
                String string = SPUtils.getInstance().getString(SpData.VERTIFY_TYPE);
                IdentityBean permissionIdentityInfo = SettingPermision.getInstance().getPermissionIdentityInfo(str);
                LogUtils.i("TeacherCard 验证成功 " + str);
                if (ValidationConstant.STUDENT_COMMENT.equals(string)) {
                    if (permissionIdentityInfo != null) {
                        EventBus.getDefault().post(permissionIdentityInfo);
                    }
                } else if (!ValidationConstant.HTML_OPEN_API.equals(string)) {
                    Intent intent = this.mActivity.getIntent();
                    int intExtra = intent != null ? intent.getIntExtra("type", 0) : 0;
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", intExtra);
                    Intent intent2 = new Intent(Wlkz2_2L.SUO);
                    intent2.putExtras(bundle);
                    this.mActivity.sendBroadcast(intent2);
                } else if (permissionIdentityInfo != null) {
                    EventBus.getDefault().post(new EventBean(10000, permissionIdentityInfo.getIdentityId(), str));
                }
                ToastUtil.showBottomView(this.mActivity, "刷卡成功");
                BroCast.open(this.mActivity);
                getActivity().finish();
                return;
            }
            LogUtils.e("TeacherCard 未找到相应人员 " + str);
            ToastUtil.showBottomView(this.mActivity, "未找到相应人员" + str);
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
        if (selectteacherbyclassesidrsp.code.intValue() == 0) {
            if (selectteacherbyclassesidrsp.data.size() > 0) {
                startAc();
                getActivity().finish();
                return;
            }
            ToastUtil.showBottomView(this.mActivity, "未找到相应人员" + this.cardNo);
            LogUtils.i("物联开门", "未找到相应人员 " + this.cardNo);
            return;
        }
        ToastUtil.showBottomView(this.mActivity, "刷卡失败");
        LogUtils.i("物联开门", "请求服务异常");
    }

    @Override // com.yd.android_brand_mvp.view.TeacherToSettingCardView
    public void selectTeacherByClassesIdRspFail(String str) {
        if (SettingPermision.getInstance().isHavePermission(this.cardNo, "")) {
            startAc();
            getActivity().finish();
            return;
        }
        ToastUtil.showBottomView(this.mActivity, "未找到相应人员" + this.cardNo);
        LogUtils.i("物联开门", "未找到相应人员 " + this.cardNo);
    }
}
