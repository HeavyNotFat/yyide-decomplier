package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.presenter.StudentToUserPresenter;
import com.yd.android_brand_mvp.user.UserCenterActivity;
import com.yd.android_brand_mvp.utils.CardInputUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.RestoreVerificationRouter;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yd.android_brand_mvp.view.StudentToUserCardView;

/* JADX INFO: loaded from: classes4.dex */
public class CardFragment extends BaseMvpFragment<StudentToUserPresenter> implements StudentToUserCardView, ObserverListener, FragmentEventListener {
    StudentCheackActivity activity;

    @BindView(R.id.frameLayout_card)
    FrameLayout frameLayout_card;
    public boolean iscan = true;
    private Boolean isNeedJump = true;
    private String TAG = CardFragment.class.getSimpleName();
    private String cardNo = "";
    private final StringBuffer buffer = new StringBuffer();

    public /* synthetic */ boolean lambda$onViewCreated$0$CardFragment(View view) {
        return false;
    }

    public static CardFragment newInstance(Boolean bool) {
        CardFragment cardFragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("needJump", bool.booleanValue());
        cardFragment.setArguments(bundle);
        return cardFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_card, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null) {
            this.isNeedJump = Boolean.valueOf(getArguments().getBoolean("needJump", true));
        }
        StudentCheackActivity studentCheackActivity = (StudentCheackActivity) getActivity();
        this.activity = studentCheackActivity;
        studentCheackActivity.setKeyeventListener(this);
        this.frameLayout_card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return false;
            }
        });
    }

    @Override // com.yd.android_brand_mvp.net.FragmentEventListener
    public boolean OnFragmentEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            Log.v(this.TAG, "keyCode = " + keyEvent.getCharacters());
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
                    ((StudentToUserPresenter) this.mvpPresenter).StudentCardByCard(card);
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
        Log.e(this.TAG, "StudentCard: " + JSON.toJSONString(selectnewstudentbyiccardrsp));
        this.iscan = true;
        if (selectnewstudentbyiccardrsp.code == 0) {
            LogUtils.i("StudentCard 验证成功 " + this.cardNo);
            SPUtils.getInstance().put(SpData.USERCENT2, JSON.toJSONString(selectnewstudentbyiccardrsp));
            if (this.isNeedJump.booleanValue()) {
                startActivity(new Intent(this.mActivity, (Class<?>) UserCenterActivity.class));
            } else {
                Intent intent = new Intent();
                intent.putExtra(ResultCodeStr.NORMAL_TYPE_CODE, ResultCodeStr.TASK_SIGN_VERIFY);
                TaskVerifyBean taskVerifyBean = new TaskVerifyBean();
                if (selectnewstudentbyiccardrsp.data != null) {
                    taskVerifyBean.setUserId(selectnewstudentbyiccardrsp.data.id);
                    taskVerifyBean.setSchoolId(selectnewstudentbyiccardrsp.data.schoolId);
                    taskVerifyBean.setClassesId(selectnewstudentbyiccardrsp.data.classesId);
                }
                intent.putExtra(ResultCodeStr.TASK_SIGN_VERIFY_SUCCESS, taskVerifyBean);
                requireActivity().setResult(-1, intent);
            }
            requireActivity().finish();
            return;
        }
        LogUtils.e("StudentCard 暂无该人员 " + this.cardNo);
        ToastUtil.showBottomView(this.mActivity, "暂无该人员 " + this.cardNo);
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

    @Override // com.yd.android_brand_mvp.view.StudentToUserCardView
    public void StudentCardFail(String str) {
        this.iscan = true;
        ToastUtil.showBottomView(this.mActivity, "刷卡验证异常,请重试");
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String str) {
        Log.e(this.TAG, "observerUpData: " + str);
        if (this.activity.getIndex() == 0 && this.iscan) {
            this.cardNo = str;
            if (RestoreVerificationRouter.handleCard(this.mActivity, str)) {
                return;
            }
            ((StudentToUserPresenter) this.mvpPresenter).StudentCardByCard(str);
        }
    }
}
