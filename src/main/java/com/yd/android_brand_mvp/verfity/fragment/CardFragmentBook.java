package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.WebActivity;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.presenter.StudentToUserPresenter;
import com.yd.android_brand_mvp.utils.CardInputUtils;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity2;
import com.yd.android_brand_mvp.view.StudentToUserCardView;

/* JADX INFO: loaded from: classes4.dex */
public class CardFragmentBook extends BaseMvpFragment<StudentToUserPresenter> implements StudentToUserCardView, ObserverListener, FragmentEventListener {
    StudentCheackActivity2 activity;
    public boolean iscan = true;
    private String cardNo = "";
    String url = "https://scyd.flyread.com.cn/";
    private final StringBuffer buffer = new StringBuffer();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_card, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        StudentCheackActivity2 studentCheackActivity2 = (StudentCheackActivity2) getActivity();
        this.activity = studentCheackActivity2;
        studentCheackActivity2.setKeyeventListener(this);
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
                    ((StudentToUserPresenter) this.mvpPresenter).StudentCardByCard(CardInputUtils.cleanCardZero(this.buffer.toString()));
                }
                this.buffer.setLength(0);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public StudentToUserPresenter createPresenter() {
        return new StudentToUserPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.StudentToUserCardView
    public void StudentCard(selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp) {
        Log.e("TAG", "StudentCard: " + JSON.toJSONString(selectnewstudentbyiccardrsp));
        this.iscan = true;
        if (selectnewstudentbyiccardrsp.code == 0) {
            LogUtils.i("StudentCard 验证成功 " + this.cardNo);
            String strValueOf = String.valueOf(selectnewstudentbyiccardrsp.data.id);
            Intent intent = new Intent();
            intent.putExtra(WebActivity.URLEXTRA, this.url);
            intent.putExtra(WebActivity.ID, strValueOf);
            intent.putExtra(WebActivity.TITLEEXTRA, "");
            intent.setClass(this.mActivity, WebActivity.class);
            startActivity(intent);
            getActivity().finish();
            return;
        }
        ToastUtil.showBottomView(this.mActivity, "未找到相关人员 " + this.cardNo);
        LogUtils.e("未找到相关人员 " + this.cardNo);
    }

    @Override // com.yd.android_brand_mvp.view.StudentToUserCardView
    public void StudentCardFail(String str) {
        this.iscan = true;
        ToastUtil.showBottomView(this.mActivity, "刷卡失败");
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
            if (this.iscan) {
                ((StudentToUserPresenter) this.mvpPresenter).StudentCardByCard(str);
            }
            this.iscan = false;
        }
    }
}
