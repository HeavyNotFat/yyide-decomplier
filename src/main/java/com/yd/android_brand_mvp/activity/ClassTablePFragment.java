package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.BindView;
import com.blankj.utilcode.util.TimeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.MyTableAdapter2;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.model.UserTableRsp;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.presenter.UserCenterPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.view.UserTableView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassTablePFragment extends BaseMvpFragment<UserCenterPresenter> implements UserTableView {
    MyTableAdapter2 dutyAdapter;
    int index;

    @BindView(R.id.list_table)
    GridView listTable;
    private List<List<TableRsp>> lists;

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

    @BindView(R.id.table_view)
    FrameLayout table_view;
    int thisweek = -1;

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void GetAskLeaveRecordBandRsp(GetAskLeaveRecordBandRsp getAskLeaveRecordBandRsp) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void GetAskLeaveRecordBandRspFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableDataFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getCDKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getUserSigByUserId(getUserSigByUserIdRsp getusersigbyuseridrsp) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getUserSigByUserIdFail(String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.user_table_p_layout, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        init();
        ((UserCenterPresenter) this.mvpPresenter).UserTable(SpData.getClassesId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public UserCenterPresenter createPresenter() {
        return new UserCenterPresenter(this);
    }

    private void init() {
        MyTableAdapter2 myTableAdapter2 = new MyTableAdapter2(this.mActivity, TimeUtil.getIntWeek(System.currentTimeMillis()));
        this.dutyAdapter = myTableAdapter2;
        this.listTable.setAdapter((ListAdapter) myTableAdapter2);
        this.rg_check.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.activity.ClassTablePFragment.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_fri /* 2131363527 */:
                        ClassTablePFragment.this.index = 5;
                        break;
                    case R.id.rb_monday /* 2131363531 */:
                        ClassTablePFragment.this.index = 1;
                        break;
                    case R.id.rb_sat /* 2131363539 */:
                        ClassTablePFragment.this.index = 6;
                        break;
                    case R.id.rb_thursday /* 2131363543 */:
                        ClassTablePFragment.this.index = 4;
                        break;
                    case R.id.rb_tuesday /* 2131363547 */:
                        ClassTablePFragment.this.index = 2;
                        break;
                    case R.id.rb_wednesday /* 2131363548 */:
                        ClassTablePFragment.this.index = 3;
                        break;
                    case R.id.rb_week /* 2131363549 */:
                        ClassTablePFragment.this.index = 7;
                        break;
                }
                if (ClassTablePFragment.this.lists != null && ClassTablePFragment.this.lists.size() >= ClassTablePFragment.this.index) {
                    int i2 = ClassTablePFragment.this.thisweek;
                    ClassTablePFragment.this.dutyAdapter.notifyData((List) ClassTablePFragment.this.lists.get(ClassTablePFragment.this.thisweek - 1), i2 == 7 ? 0 : i2 + 1);
                } else {
                    ClassTablePFragment.this.dutyAdapter.notifyData(null);
                }
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.activity.ClassTablePFragment.2
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((UserCenterPresenter) ClassTablePFragment.this.mvpPresenter).UserTable(SpData.getClassesId());
            }
        });
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableData(UserTableRsp userTableRsp) {
        if (userTableRsp.code.intValue() == BaseConstant.REQUEST_SUCCES2) {
            setData(userTableRsp);
        }
    }

    void setData(UserTableRsp userTableRsp) {
        this.lists = new ArrayList();
        for (int i = 1; i <= 7; i++) {
            ArrayList arrayList = new ArrayList();
            for (UserTableRsp.DataDTO.SubListDTO subListDTO : userTableRsp.data.subList) {
                if (subListDTO.weekTime == i && subListDTO.subjectName != null) {
                    arrayList.add(getTableRsp(subListDTO));
                }
            }
            if (arrayList.size() > 0) {
                this.lists.add(arrayList);
            }
        }
        for (List<TableRsp> list : this.lists) {
        }
        Log.e("TAG", "" + this.lists.size());
        switch (TimeUtils.getChineseWeek(new Date())) {
            case "周一":
                this.thisweek = 1;
                this.rb_monday.setChecked(true);
                break;
            case "周二":
                this.thisweek = 2;
                this.rb_tuesday.setChecked(true);
                break;
            case "周三":
                this.thisweek = 3;
                this.rb_wednesday.setChecked(true);
                break;
            case "周四":
                this.thisweek = 4;
                this.rb_thursday.setChecked(true);
                break;
            case "周五":
                this.thisweek = 5;
                this.rb_fri.setChecked(true);
                break;
            case "周六":
                this.thisweek = 6;
                this.rb_sat.setChecked(true);
                break;
            case "周日":
                this.thisweek = 7;
                this.rb_week.setChecked(true);
                break;
        }
        if (this.thisweek > this.lists.size()) {
            this.dutyAdapter.notifyData(this.lists.get(0));
        } else {
            int i2 = this.thisweek;
            this.dutyAdapter.notifyData(this.lists.get(this.thisweek - 1), i2 == 7 ? 0 : i2 + 1);
        }
        if (this.lists.size() == 0) {
            this.mu.setViewState(2);
        } else if (this.thisweek > this.lists.size()) {
            this.dutyAdapter.notifyData(this.lists.get(0));
        } else {
            int i3 = this.thisweek;
            this.dutyAdapter.notifyData(this.lists.get(this.thisweek - 1), i3 == 7 ? 0 : i3 + 1);
        }
        if (this.dutyAdapter.getList().size() == 0) {
            this.mu.setViewState(2);
        } else {
            this.mu.setViewState(0);
        }
    }

    public TableRsp getTableRsp(UserTableRsp.DataDTO.SubListDTO subListDTO) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = subListDTO.subjectName;
        tableRsp.teacherName = subListDTO.classesTeacher;
        tableRsp.seletion = Integer.valueOf(subListDTO.section).intValue();
        tableRsp.startTime = subListDTO.fromDateTime;
        tableRsp.endTime = subListDTO.toDateTime;
        tableRsp.week = subListDTO.weekTime;
        return tableRsp;
    }
}
