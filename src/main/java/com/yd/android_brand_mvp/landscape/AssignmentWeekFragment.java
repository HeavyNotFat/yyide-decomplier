package com.yd.android_brand_mvp.landscape;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.view.AssignmentView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentWeekFragment extends BaseMvpFragment<AssignmentPresenter> implements AssignmentView, PagingScrollHelper.onPageChangeListener {
    AssignmentAdapter adapter;
    String checkDay;
    LinearLayout llIndicator;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rb_fri)
    RadioButton rb_fri;

    @BindView(R.id.rb_monday)
    RadioButton rb_monday;

    @BindView(R.id.rb_sat)
    RadioButton rb_sat;

    @BindView(R.id.rb_thursday)
    RadioButton rb_thursday;

    @BindView(R.id.rb_tuesday)
    RadioButton rb_tuesday;

    @BindView(R.id.rb_wednesday)
    RadioButton rb_wednesday;

    @BindView(R.id.rb_week)
    RadioButton rb_week;

    @BindView(R.id.rg_check)
    RadioGroup rg_check;

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private ImageView[] tips;
    Unbinder unbinder;
    List<StudentTaskBean.DataBean.WorkBean> list = new ArrayList();
    String day = "1";

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
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment_week, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.day = getDay();
        this.checkDay = getDay();
        initView();
        setCheck(this.checkDay);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public AssignmentPresenter createPresenter() {
        return new AssignmentPresenter(this);
    }

    private void initView() {
        ((AssignmentPresenter) this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", this.day);
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.show();
        }
        this.rg_check.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.landscape.AssignmentWeekFragment.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_fri /* 2131363527 */:
                        AssignmentWeekFragment.this.day = ConversionUtil.conditionWithSeriesName;
                        break;
                    case R.id.rb_monday /* 2131363531 */:
                        AssignmentWeekFragment.this.day = "1";
                        break;
                    case R.id.rb_sat /* 2131363539 */:
                        AssignmentWeekFragment.this.day = ConversionUtil.conditionWithCallNumber;
                        break;
                    case R.id.rb_thursday /* 2131363543 */:
                        AssignmentWeekFragment.this.day = "4";
                        break;
                    case R.id.rb_tuesday /* 2131363547 */:
                        AssignmentWeekFragment.this.day = "2";
                        break;
                    case R.id.rb_wednesday /* 2131363548 */:
                        AssignmentWeekFragment.this.day = "3";
                        break;
                    case R.id.rb_week /* 2131363549 */:
                        AssignmentWeekFragment.this.day = ConversionUtil.conditionWithBookType;
                        break;
                }
                if (AssignmentWeekFragment.this.day.equals(AssignmentWeekFragment.this.checkDay)) {
                    ((RadioButton) radioGroup.findViewById(i)).setButtonDrawable((Drawable) null);
                } else {
                    AssignmentWeekFragment assignmentWeekFragment = AssignmentWeekFragment.this;
                    assignmentWeekFragment.setLfetImg(assignmentWeekFragment.checkDay);
                }
                ((AssignmentPresenter) AssignmentWeekFragment.this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", AssignmentWeekFragment.this.day);
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.AssignmentWeekFragment.2
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((AssignmentPresenter) AssignmentWeekFragment.this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", AssignmentWeekFragment.this.day);
                if (AssignmentWeekFragment.this.mActivity.isDestroyed()) {
                    return;
                }
                AssignmentWeekFragment.this.bookLoadingDiallog.show();
            }
        });
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.rvList.setLayoutManager(linearLayoutManager);
        this.adapter = new AssignmentAdapter(R.layout.assignment_item_1, this.list);
        this.rvList.removeAllViews();
        this.rvList.setAdapter(this.adapter);
    }

    private void setData(StudentTaskBean studentTaskBean) {
        this.list.clear();
        this.list.addAll(studentTaskBean.data.list);
        List<StudentTaskBean.DataBean.WorkBean> list = this.list;
        if (list != null) {
            this.mu.setViewState(list.size() != 0 ? 0 : 2);
        } else {
            this.mu.setViewState(2);
        }
        List<StudentTaskBean.DataBean.WorkBean> list2 = this.list;
        if (list2 == null || list2.size() == 0) {
            AssignmentAdapter assignmentAdapter = this.adapter;
            if (assignmentAdapter != null) {
                assignmentAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        setAdapter();
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    private void setCheck(String str) {
        switch (str) {
            case "1":
                this.rb_monday.setChecked(true);
                this.rb_monday.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                break;
            case "2":
                this.rb_tuesday.setChecked(true);
                this.rb_tuesday.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                break;
            case "3":
                this.rb_wednesday.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                this.rb_wednesday.setChecked(true);
                break;
            case "4":
                this.rb_thursday.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                this.rb_thursday.setChecked(true);
                break;
            case "5":
                this.rb_fri.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                this.rb_fri.setChecked(true);
                break;
            case "6":
                this.rb_sat.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                this.rb_sat.setChecked(true);
                break;
            case "7":
                this.rb_week.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                this.rb_week.setChecked(true);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    public void setLfetImg(String str) {
        switch (str) {
            case "1":
                this.rb_monday.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                break;
            case "2":
                this.rb_tuesday.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                break;
            case "3":
                this.rb_wednesday.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                break;
            case "4":
                this.rb_thursday.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                break;
            case "5":
                this.rb_fri.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                break;
            case "6":
                this.rb_sat.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                break;
            case "7":
                this.rb_week.setButtonDrawable(getResources().getDrawable(R.drawable.icon_day_st));
                break;
        }
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
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.dismiss();
        }
        if (studentTaskBean.code == 0 && studentTaskBean.data.list != null) {
            this.mu.setViewState(0);
            setData(studentTaskBean);
        } else {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.AssignmentView
    public void getTaskListSuccessFail(String str) {
        if (this.mActivity.isDestroyed()) {
            return;
        }
        this.bookLoadingDiallog.dismiss();
    }

    private String getDay() {
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        return (intWeek == 1 ? 7 : intWeek - 1) + "";
    }
}
