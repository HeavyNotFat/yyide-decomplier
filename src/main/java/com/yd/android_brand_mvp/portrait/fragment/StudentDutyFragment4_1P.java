package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.tencent.smtt.sdk.TbsListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.DayStudentDutyAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.StudenDutyBean;
import com.yd.android_brand_mvp.presenter.StudentDutyPresenter;
import com.yd.android_brand_mvp.user.StudentDutyActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.view.StudentDutyView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudentDutyFragment4_1P extends BaseMvpFragment<StudentDutyPresenter> implements StudentDutyView {
    DayStudentDutyAdapter adapter;

    @BindView(R.id.content)
    LinearLayout content;
    List<StudenDutyBean.DataBean> dataBean;
    int dutyLayout;
    int layout;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rv_duty)
    RecyclerView rvDuty;

    @BindView(R.id.title)
    TextView title;
    String type;
    Unbinder unbinder;

    public static StudentDutyFragment4_1P newInstance(String str) {
        return new StudentDutyFragment4_1P(str);
    }

    public StudentDutyFragment4_1P(String str) {
        this.type = str;
    }

    public StudentDutyFragment4_1P() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        judgeLandscape();
        View viewInflate = layoutInflater.inflate(this.layout, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setLayout();
        initView();
        ((StudentDutyPresenter) this.mvpPresenter).newStudentDutyList();
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.portrait.fragment.StudentDutyFragment4_1P.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((StudentDutyPresenter) StudentDutyFragment4_1P.this.mvpPresenter).newStudentDutyList();
            }
        });
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Duty) {
            ((StudentDutyPresenter) this.mvpPresenter).newStudentDutyList();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public StudentDutyPresenter createPresenter() {
        return new StudentDutyPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override // com.yd.android_brand_mvp.view.StudentDutyView
    public void getStudentDutySuccess(StudenDutyBean studenDutyBean) {
        if (studenDutyBean.getCode() == 0) {
            SPUtils.getInstance().put(SpData.ClassDuty, JSON.toJSONString(studenDutyBean));
            setData(studenDutyBean);
        }
    }

    @Override // com.yd.android_brand_mvp.view.StudentDutyView
    public void getSuccessFail(String str) {
        if (SpData.getStudenDutyBean() != null) {
            setData(SpData.getStudenDutyBean());
        } else {
            this.mu.setViewState(1);
        }
    }

    private void judgeLandscape() {
        if ("sbzr41".equals(this.type)) {
            this.layout = R.layout.fragment_student_duty_p4_1;
        } else {
            this.layout = R.layout.fragment_student_duty_p4_2;
        }
        if ("sbzr22".equals(this.type)) {
            this.dutyLayout = R.layout.student_duty_item2_2p;
        } else {
            this.dutyLayout = R.layout.student_duty_item4p;
        }
    }

    void setLayout() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.content.getLayoutParams();
        if ("sbzr42".equals(this.type)) {
            layoutParams.width = TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION;
            layoutParams.height = TypedValues.CycleType.TYPE_WAVE_OFFSET;
        } else if ("sbzr41".equals(this.type)) {
            layoutParams.width = TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION;
            layoutParams.height = 202;
        } else if ("sbzr22".equals(this.type)) {
            layoutParams.width = TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE;
            layoutParams.height = TypedValues.CycleType.TYPE_WAVE_OFFSET;
        }
    }

    private void initView() {
        this.title.setText(R.string.st_student_duty);
        ArrayList arrayList = new ArrayList();
        this.dataBean = arrayList;
        this.adapter = new DayStudentDutyAdapter(this.dutyLayout, arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        this.rvDuty.setLayoutManager(linearLayoutManager);
        this.rvDuty.setAdapter(this.adapter);
    }

    private void setData(StudenDutyBean studenDutyBean) {
        this.dataBean.clear();
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        int i = intWeek == 1 ? 6 : intWeek - 2;
        this.dataBean.addAll(studenDutyBean.getData().get(i));
        this.adapter.notifyDataSetChanged();
        if (studenDutyBean.getData() == null || studenDutyBean.getData().size() == 0 || studenDutyBean.getData().get(i) == null || studenDutyBean.getData().get(i).size() == 0) {
            this.mu.setViewState(2);
        } else {
            this.mu.setViewState(0);
        }
    }

    @OnClick({R.id.title})
    public void onClick(View view) {
        if (view.getId() != R.id.title) {
            return;
        }
        goPermissionsActivity(StudentDutyActivity.class);
    }
}
