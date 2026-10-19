package com.yd.android_brand_mvp.landscape;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentWeekFragmentP extends BaseMvpFragment<AssignmentPresenter> implements AssignmentView {
    AssignmentAdapter adapter;
    String day;
    List<StudentTaskBean.DataBean.WorkBean> list;
    RadioButton rbCheck;

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

    @BindView(R.id.rl_list)
    RecyclerView rvList;

    @BindView(R.id.tv_null)
    TextView tvNull;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.view.AssignmentView
    public void getTaskListSuccessFail(String str) {
    }

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
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment_week_p, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.day = getDay();
        setCheck();
        this.list = new ArrayList();
        ((AssignmentPresenter) this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", this.day);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public AssignmentPresenter createPresenter() {
        return new AssignmentPresenter(this);
    }

    private void initView() {
        this.adapter = new AssignmentAdapter(R.layout.layout_announcement_item_l, this.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.rvList.setLayoutManager(linearLayoutManager);
        this.rvList.setAdapter(this.adapter);
        this.rg_check.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.landscape.AssignmentWeekFragmentP.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_fri /* 2131363527 */:
                        AssignmentWeekFragmentP.this.day = ConversionUtil.conditionWithSeriesName;
                        break;
                    case R.id.rb_monday /* 2131363531 */:
                        AssignmentWeekFragmentP.this.day = "1";
                        break;
                    case R.id.rb_sat /* 2131363539 */:
                        AssignmentWeekFragmentP.this.day = ConversionUtil.conditionWithCallNumber;
                        break;
                    case R.id.rb_thursday /* 2131363543 */:
                        AssignmentWeekFragmentP.this.day = "4";
                        break;
                    case R.id.rb_tuesday /* 2131363547 */:
                        AssignmentWeekFragmentP.this.day = "2";
                        break;
                    case R.id.rb_wednesday /* 2131363548 */:
                        AssignmentWeekFragmentP.this.day = "3";
                        break;
                    case R.id.rb_week /* 2131363549 */:
                        AssignmentWeekFragmentP.this.day = ConversionUtil.conditionWithBookType;
                        break;
                }
                AssignmentWeekFragmentP.this.getChildCheck(i);
                ((AssignmentPresenter) AssignmentWeekFragmentP.this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", AssignmentWeekFragmentP.this.day);
            }
        });
    }

    void getChildCheck(int i) {
        if (this.rbCheck.getId() != i) {
            this.rbCheck.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.icon_day_st), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.rbCheck.setCompoundDrawables(null, null, null, null);
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    private void setCheck() {
        switch (this.day) {
            case "1":
                this.rb_monday.setChecked(true);
                this.rbCheck = this.rb_monday;
                break;
            case "2":
                this.rb_tuesday.setChecked(true);
                this.rbCheck = this.rb_tuesday;
                break;
            case "3":
                this.rb_wednesday.setChecked(true);
                this.rbCheck = this.rb_wednesday;
                break;
            case "4":
                RadioButton radioButton = this.rb_thursday;
                this.rbCheck = radioButton;
                radioButton.setChecked(true);
                break;
            case "5":
                RadioButton radioButton2 = this.rb_fri;
                this.rbCheck = radioButton2;
                radioButton2.setChecked(true);
                break;
            case "6":
                RadioButton radioButton3 = this.rb_sat;
                this.rbCheck = radioButton3;
                radioButton3.setChecked(true);
                break;
            case "7":
                RadioButton radioButton4 = this.rb_week;
                this.rbCheck = radioButton4;
                radioButton4.setChecked(true);
                break;
        }
    }

    @Override // com.yd.android_brand_mvp.view.AssignmentView
    public void getTaskListSuccess(StudentTaskBean studentTaskBean) {
        this.list.clear();
        this.list.addAll(studentTaskBean.data.list);
        List<StudentTaskBean.DataBean.WorkBean> list = this.list;
        if (list == null || list.size() == 0) {
            this.tvNull.setVisibility(0);
            this.rvList.setVisibility(8);
        } else {
            this.rvList.setVisibility(0);
            this.tvNull.setVisibility(8);
        }
        initView();
    }

    private String getDay() {
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        return (intWeek == 1 ? 7 : intWeek - 1) + "";
    }
}
