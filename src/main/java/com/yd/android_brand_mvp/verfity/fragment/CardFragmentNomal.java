package com.yd.android_brand_mvp.verfity.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.LogUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.selectTeacherByIcCardRsp;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.presenter.CheackMsgPresenter;
import com.yd.android_brand_mvp.utils.CardInputUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import com.yd.android_brand_mvp.view.CheackMsgView;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class CardFragmentNomal extends BaseMvpFragment<CheackMsgPresenter> implements CheackMsgView, ObserverListener, FragmentEventListener {
    CheackNomalActivity activity;
    private String cardNo = "";
    private final StringBuffer buffer = new StringBuffer();

    @Override // com.yd.android_brand_mvp.view.CheackMsgView
    public void selectUserInfoByIcFace(selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp) {
    }

    @Override // com.yd.android_brand_mvp.view.CheackMsgView
    public void selectUserInfoByIcFace(selectTeacherByIcCardRsp selectteacherbyiccardrsp) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_card, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        CheackNomalActivity cheackNomalActivity = (CheackNomalActivity) this.mActivity;
        this.activity = cheackNomalActivity;
        cheackNomalActivity.setKeyeventListener(this);
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
                    ((CheackMsgPresenter) this.mvpPresenter).selectUserInfoByIcCard(CardInputUtils.cleanCardZero(this.buffer.toString()));
                }
                this.buffer.setLength(0);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public CheackMsgPresenter createPresenter() {
        return new CheackMsgPresenter(this);
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
        this.cardNo = str;
        if (this.activity.getIndex() == 0) {
            ((CheackMsgPresenter) this.mvpPresenter).selectUserInfoByIcCard(str);
        }
    }

    @Override // com.yd.android_brand_mvp.view.CheackMsgView
    public void selectUserInfoByIcCard(UserIcCardBean userIcCardBean) {
        if (userIcCardBean.code == 0 && userIcCardBean.data != null) {
            if (userIcCardBean.data.schoolId.equals(SpData.getSchoolId())) {
                LogUtils.i("验证成功 " + this.cardNo);
                EventBus.getDefault().post(new EventBean(BaseConstant.CheackMsg, userIcCardBean.data.id, userIcCardBean.data.name, this.activity.type, this.activity.productionId, userIcCardBean.data.isStudent, userIcCardBean.data.identityId));
                getActivity().finish();
                return;
            }
            ToastUtil.showBottomView(this.mActivity, "非本校人员 " + this.cardNo);
            LogUtils.e("非本校人员 " + this.cardNo);
            return;
        }
        ToastUtil.showBottomView(this.mActivity, userIcCardBean.message);
    }

    @Override // com.yd.android_brand_mvp.view.CheackMsgView
    public void selectUserInfoByIcCardFail(String str) {
        ToastUtil.showBottomView(this.mActivity, "请求异常" + str);
    }
}
