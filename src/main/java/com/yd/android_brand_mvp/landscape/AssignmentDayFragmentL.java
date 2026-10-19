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
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.AssignmentAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.StudentTaskBean;
import com.yd.android_brand_mvp.presenter.AssignmentPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.view.AssignmentView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentDayFragmentL extends BaseMvpFragment<AssignmentPresenter> implements AssignmentView {
    AssignmentAdapter adapter;
    String day;
    List<StudentTaskBean.DataBean.WorkBean> list;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rl_list)
    RecyclerView rvList;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseView
    public void hideLoading() {
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseView
    public void showError() {
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseView
    public void showLoading() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment_day_l, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.day = getDay();
        if (SpData.NewUser().data != null) {
            ((AssignmentPresenter) this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", this.day);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public AssignmentPresenter createPresenter() {
        return new AssignmentPresenter(this);
    }

    private void initView(StudentTaskBean studentTaskBean) {
        List<StudentTaskBean.DataBean.WorkBean> list = studentTaskBean.data.list;
        this.list = list;
        this.adapter = new AssignmentAdapter(R.layout.layout_announcement_item_l, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.rvList.setLayoutManager(linearLayoutManager);
        this.rvList.setAdapter(this.adapter);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.AssignmentDayFragmentL.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((AssignmentPresenter) AssignmentDayFragmentL.this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", AssignmentDayFragmentL.this.getDay());
            }
        });
        List<StudentTaskBean.DataBean.WorkBean> list2 = this.list;
        if (list2 != null) {
            this.mu.setViewState(list2.size() != 0 ? 0 : 2);
        } else {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override // com.yd.android_brand_mvp.view.AssignmentView
    public void getTaskListSuccess(StudentTaskBean studentTaskBean) {
        if (studentTaskBean.code == 0 && studentTaskBean.data.list != null) {
            this.mu.setViewState(0);
            initView(studentTaskBean);
        } else {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.AssignmentView
    public void getTaskListSuccessFail(String str) {
        this.mu.setViewState(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDay() {
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        return (intWeek == 1 ? 7 : intWeek - 1) + "";
    }
}
