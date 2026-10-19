package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.WeekStudentDutyAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.StudenDutyBean;
import com.yd.android_brand_mvp.presenter.StudentDutyPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.StudentDutyView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class WeekStudentDutyFragment extends BaseMvpFragment<StudentDutyPresenter> implements StudentDutyView {
    WeekStudentDutyAdapter adapter;
    int count;
    List<StudenDutyBean.DataBean> dataBean;
    int dutyLayout;
    int layout;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rv_all_duty)
    RecyclerView rvAllDuty;
    Unbinder unbinder;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        judgeLandscape();
        View viewInflate = layoutInflater.inflate(this.layout, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    private void judgeLandscape() {
        if (ScreenUtils.isLandscape()) {
            this.layout = R.layout.fragment_week_student_duty;
            this.dutyLayout = R.layout.day_student_duty_item;
            this.count = 3;
        } else {
            this.count = 2;
            this.layout = R.layout.fragment_week_student_duty;
            this.dutyLayout = R.layout.day_student_duty_item_p;
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((StudentDutyPresenter) this.mvpPresenter).newStudentDutyList();
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.show();
        }
        initView();
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
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.dismiss();
        }
        if (studenDutyBean.getCode() == 0) {
            SPUtils.getInstance().put(SpData.ClassDuty, JSON.toJSONString(studenDutyBean));
            setData(studenDutyBean);
        }
    }

    @Override // com.yd.android_brand_mvp.view.StudentDutyView
    public void getSuccessFail(String str) {
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.dismiss();
        }
        if (SpData.getStudenDutyBean() != null) {
            setData(SpData.getStudenDutyBean());
        } else {
            this.mu.setViewState(1);
        }
    }

    private void initView() {
        ArrayList arrayList = new ArrayList();
        this.dataBean = arrayList;
        this.adapter = new WeekStudentDutyAdapter(this.dutyLayout, arrayList);
        this.rvAllDuty.setLayoutManager(new LinearLayoutManager(this.mActivity, 0, false));
        this.rvAllDuty.setAdapter(this.adapter);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.WeekStudentDutyFragment.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((StudentDutyPresenter) WeekStudentDutyFragment.this.mvpPresenter).newStudentDutyList();
                if (WeekStudentDutyFragment.this.mActivity.isDestroyed()) {
                    return;
                }
                WeekStudentDutyFragment.this.bookLoadingDiallog.show();
            }
        });
    }

    private void setData(StudenDutyBean studenDutyBean) {
        this.adapter.addData((Collection) studenDutyBean.getData());
        if (studenDutyBean.getData() == null || studenDutyBean.getData().size() == 0) {
            this.mu.setViewState(2);
        } else {
            this.mu.setViewState(0);
        }
    }
}
