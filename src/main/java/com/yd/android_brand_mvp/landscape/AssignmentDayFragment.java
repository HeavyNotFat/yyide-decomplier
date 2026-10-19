package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentDayFragment extends BaseMvpFragment<AssignmentPresenter> implements AssignmentView, PagingScrollHelper.onPageChangeListener {
    AssignmentAdapter adapter;
    String day = "1";
    List<StudentTaskBean.DataBean.WorkBean> list;

    @BindView(R.id.ll_indicator)
    LinearLayout llIndicator;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private ImageView[] tips;
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
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment_day, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.day = getDay();
        ((AssignmentPresenter) this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId(), this.day);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public AssignmentPresenter createPresenter() {
        return new AssignmentPresenter(this);
    }

    private void initView(StudentTaskBean studentTaskBean) {
        this.list = studentTaskBean.data.list;
        new PagingScrollHelper();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        this.rvList.setLayoutManager(linearLayoutManager);
        AssignmentAdapter assignmentAdapter = new AssignmentAdapter(R.layout.assignment_item_1, this.list);
        this.adapter = assignmentAdapter;
        this.rvList.setAdapter(assignmentAdapter);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.AssignmentDayFragment.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((AssignmentPresenter) AssignmentDayFragment.this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", AssignmentDayFragment.this.getDay());
            }
        });
        List<StudentTaskBean.DataBean.WorkBean> list = this.list;
        if (list != null) {
            this.mu.setViewState(list.size() != 0 ? 0 : 2);
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

    @Override // com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper.onPageChangeListener
    public void onPageChange(int i) {
        setImageBackground(i);
    }

    private void setImageBackground(int i) {
        ImageView[] imageViewArr = this.tips;
        if (imageViewArr == null || imageViewArr.length == 1) {
            return;
        }
        int i2 = 0;
        while (true) {
            ImageView[] imageViewArr2 = this.tips;
            if (i2 >= imageViewArr2.length) {
                return;
            }
            if (i2 == i) {
                imageViewArr2[i2].setBackgroundResource(R.drawable.bg_img_indicator2);
            } else {
                imageViewArr2[i2].setBackgroundResource(R.drawable.bg_img_indicator1);
            }
            i2++;
        }
    }

    private void setIndicator() {
        int size;
        this.llIndicator.removeAllViews();
        if (this.list.size() == 0) {
            return;
        }
        if (this.list.size() % 3 == 0) {
            size = this.list.size() / 3;
        } else {
            size = (this.list.size() / 3) + 1;
        }
        if (size == 1) {
            size = 0;
        }
        this.tips = new ImageView[size];
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(this.mActivity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(10, 10);
            layoutParams.setMargins(8, 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setLeft(20);
            ImageView[] imageViewArr = this.tips;
            imageViewArr[i] = imageView;
            if (i != 0) {
                imageViewArr[i].setBackgroundResource(R.drawable.bg_img_indicator1);
            } else {
                imageViewArr[i].setBackgroundResource(R.drawable.bg_img_indicator2);
            }
            this.llIndicator.addView(imageView);
        }
    }

    @Override // com.yd.android_brand_mvp.view.AssignmentView
    public void getTaskListSuccess(StudentTaskBean studentTaskBean) {
        if (studentTaskBean.code == 0 && studentTaskBean.data != null) {
            this.mu.setViewState(0);
            initView(studentTaskBean);
            setIndicator();
            return;
        }
        this.mu.setViewState(2);
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
