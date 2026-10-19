package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ClassScheduleAdapter22;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.UserTableRsp;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.presenter.UserCenterPresenter;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.DisplayUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.view.UserTableView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleFragment22 extends BaseMvpFragment<UserCenterPresenter> implements UserTableView {
    ClassScheduleAdapter22 adapter1;
    ClassScheduleAdapter22 adapter2;
    ClassScheduleAdapter22 adapter3;
    ClassScheduleAdapter22 adapter4;

    @BindView(R.id.checkbox)
    TextView checkbox;
    long classID;

    @BindView(R.id.gv_list1)
    GridView gvList1;

    @BindView(R.id.gv_list2)
    GridView gvList2;

    @BindView(R.id.gv_list3)
    GridView gvList3;

    @BindView(R.id.gv_list4)
    GridView gvList4;
    int height1;
    int height2;
    int height3;
    int height4;

    @BindView(R.id.ll_afternoon)
    LinearLayout llAfternoon;

    @BindView(R.id.ll_content)
    LinearLayout llContent;

    @BindView(R.id.ll_forenoon)
    LinearLayout llForenoon;

    @BindView(R.id.ll_lab)
    LinearLayout llLab;

    @BindView(R.id.ll_morning_reading)
    LinearLayout llMorningReading;

    @BindView(R.id.ll_night)
    LinearLayout llNight;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rb_month)
    Button rbMonth;

    @BindView(R.id.rb_trimester)
    CheckedTextView rbTrimester;

    @BindView(R.id.rb_week)
    CheckedTextView rbWeek;

    @BindView(R.id.rg_check)
    LinearLayout rgCheck;

    @BindView(R.id.rl_check)
    RelativeLayout rl_check;

    @BindView(R.id.rl_rb)
    RelativeLayout rl_rb;
    UserTableRsp rsp;
    int statusCount;
    public List<UserTableRsp.DataDTO.SubListDTO> subList1;
    public List<UserTableRsp.DataDTO.SubListDTO> subList2;
    public List<UserTableRsp.DataDTO.SubListDTO> subList3;
    public List<UserTableRsp.DataDTO.SubListDTO> subList4;
    String thisweek;

    @BindView(R.id.title_Name)
    TextView title_Name;

    @BindView(R.id.tv_saturday)
    TextView tv_saturday;

    @BindView(R.id.tv_sunday)
    TextView tv_sunday;

    @BindView(R.id.v1)
    View v1;

    @BindView(R.id.v2)
    View v2;

    @BindView(R.id.v3)
    View v3;

    @BindView(R.id.week)
    TextView week;
    String weekday;
    int weekCount = -1;
    int height = 66;
    Boolean oneStart = true;
    private String TAG = ClassScheduleFragment22.class.getSimpleName();
    int dayIndex = 1;
    int weekIndex = 8;
    public int tableType = -1;
    int maxDay = 0;
    int cou = 0;
    int maxDay1 = 0;
    int lateWeek = 0;
    int type = 0;
    String checkId = "";

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void GetAskLeaveRecordBandRsp(GetAskLeaveRecordBandRsp getAskLeaveRecordBandRsp) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void GetAskLeaveRecordBandRspFail(String str) {
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
        return layoutInflater.inflate(R.layout.fragment_class_schedule22, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (DisplayUtil.getWindowsHeight(this.mActivity) == 720) {
            this.cou = 4;
        }
        initView();
        setAdapter();
        selectNewStudentByIcCardRsp selectnewstudentbyiccardrspUSERCENTINFO2 = SpData.USERCENTINFO2();
        if (selectnewstudentbyiccardrspUSERCENTINFO2 != null) {
            this.classID = Long.parseLong(selectnewstudentbyiccardrspUSERCENTINFO2.data.classesId);
        }
        ((UserCenterPresenter) this.mvpPresenter).UserTable2(this.classID);
        if (this.mActivity.isDestroyed()) {
            return;
        }
        this.bookLoadingDiallog.show();
    }

    private void initView() {
        this.gvList1.setVerticalSpacing(SizeUtils.dp2px(1.0f));
        this.gvList1.setHorizontalSpacing(SizeUtils.dp2px(1.0f));
        this.gvList2.setVerticalSpacing(SizeUtils.dp2px(1.0f));
        this.gvList2.setHorizontalSpacing(SizeUtils.dp2px(1.0f));
        this.gvList3.setVerticalSpacing(SizeUtils.dp2px(1.0f));
        this.gvList3.setHorizontalSpacing(SizeUtils.dp2px(1.0f));
        this.gvList4.setVerticalSpacing(SizeUtils.dp2px(1.0f));
        this.gvList4.setHorizontalSpacing(SizeUtils.dp2px(1.0f));
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.activity.ClassScheduleFragment22.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((UserCenterPresenter) ClassScheduleFragment22.this.mvpPresenter).UserTable2(ClassScheduleFragment22.this.classID);
                if (ClassScheduleFragment22.this.mActivity.isDestroyed()) {
                    return;
                }
                ClassScheduleFragment22.this.bookLoadingDiallog.show();
            }
        });
        this.checkbox.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.ClassScheduleFragment22.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClassScheduleFragment22.this.title_Name.getText().equals("单周课表")) {
                    ClassScheduleFragment22.this.adapter1.settimetableType(2);
                    ClassScheduleFragment22.this.adapter2.settimetableType(2);
                    ClassScheduleFragment22.this.adapter3.settimetableType(2);
                    ClassScheduleFragment22.this.adapter4.settimetableType(2);
                    ClassScheduleFragment22.this.title_Name.setText("双周课表");
                    ClassScheduleFragment22.this.checkbox.setText("切换单周");
                    return;
                }
                ClassScheduleFragment22.this.adapter1.settimetableType(1);
                ClassScheduleFragment22.this.adapter2.settimetableType(1);
                ClassScheduleFragment22.this.adapter3.settimetableType(1);
                ClassScheduleFragment22.this.adapter4.settimetableType(1);
                ClassScheduleFragment22.this.title_Name.setText("单周课表");
                ClassScheduleFragment22.this.checkbox.setText("切换双周");
            }
        });
    }

    @OnClick({R.id.rb_week, R.id.rb_month, R.id.rb_trimester})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rb_month) {
            ((UserCenterPresenter) this.mvpPresenter).UserTable2(this.classID);
            return;
        }
        if (id != R.id.rb_trimester) {
            if (id == R.id.rb_week && this.type == 1 && this.weekCount > 1) {
                UserCenterPresenter userCenterPresenter = (UserCenterPresenter) this.mvpPresenter;
                long j = this.classID;
                int i = this.weekCount - 1;
                this.weekCount = i;
                userCenterPresenter.UserTable2(j, i);
                return;
            }
            return;
        }
        if (this.type != 1 || this.weekCount >= this.statusCount) {
            return;
        }
        UserCenterPresenter userCenterPresenter2 = (UserCenterPresenter) this.mvpPresenter;
        long j2 = this.classID;
        int i2 = this.weekCount + 1;
        this.weekCount = i2;
        userCenterPresenter2.UserTable2(j2, i2);
    }

    public void addNullDay(List<UserTableRsp.DataDTO.SubListDTO> list) {
        if (this.statusCount == this.weekCount) {
            int i = this.lateWeek;
            if (i < 5) {
                i = 5;
            }
            this.maxDay1 = i;
            for (int i2 = i - this.lateWeek; i2 > 0; i2--) {
                list.add(new UserTableRsp.DataDTO.SubListDTO());
            }
            return;
        }
        for (int i3 = 0; i3 < 7 - this.weekIndex; i3++) {
            list.add(new UserTableRsp.DataDTO.SubListDTO());
        }
    }

    private void initData(List<UserTableRsp.DataDTO.SubListDTO> list) {
        int i;
        this.maxDay = 0;
        this.lateWeek = 0;
        getMaxDay(list);
        getWeek();
        setAdapter();
        this.llContent.setVisibility(0);
        int i2 = list.get(0).weekTime;
        this.dayIndex = i2;
        this.weekIndex = 8 - i2;
        this.subList1 = new ArrayList();
        this.subList2 = new ArrayList();
        this.subList3 = new ArrayList();
        this.subList4 = new ArrayList();
        this.checkId = null;
        if (this.statusCount == this.weekCount) {
            int i3 = 0;
            int i4 = -1;
            for (int i5 = 0; i5 < list.size(); i5++) {
                getClassId(list.get(i5));
                if (i3 == 0) {
                    int i6 = this.lateWeek;
                    if (i5 % i6 == 0) {
                        if ("0".equals(list.get(i5).timeFrame)) {
                            i3 = i6;
                            i4 = 0;
                        } else if ("1".equals(list.get(i5).timeFrame)) {
                            i3 = i6;
                            i4 = 1;
                        } else if ("2".equals(list.get(i5).timeFrame)) {
                            i3 = i6;
                            i4 = 2;
                        } else if ("3".equals(list.get(i5).timeFrame)) {
                            i3 = i6;
                            i4 = 3;
                        } else {
                            i3 = i6;
                        }
                    }
                }
                Log.i("count", "i = " + i5);
                Log.i("count", "type = " + i4);
                Log.i("count", "count = " + i3);
                Log.i("count", "timeFrame = " + list.get(i5).timeFrame);
                i3 += -1;
                if (i4 == 0 && this.maxDay >= list.get(i5).weekTime) {
                    this.subList1.add(list.get(i5));
                    if (i3 == 0) {
                        addNullDay(this.subList1);
                    }
                } else if (i4 == 1 && this.maxDay >= list.get(i5).weekTime) {
                    this.subList2.add(list.get(i5));
                    if (i3 == 0) {
                        addNullDay(this.subList2);
                    }
                } else if (i4 == 2 && this.maxDay >= list.get(i5).weekTime) {
                    this.subList3.add(list.get(i5));
                    if (i3 == 0) {
                        addNullDay(this.subList3);
                    }
                } else if (i4 == 3 && this.maxDay >= list.get(i5).weekTime) {
                    this.subList4.add(list.get(i5));
                    if (i3 == 0) {
                        addNullDay(this.subList4);
                    }
                }
            }
            Log.i("count", "subList1 = " + this.subList1.size());
            Log.i("count", "subList2 = " + this.subList2.size());
            Log.i("count", "subList3 = " + this.subList3.size());
            Log.i("count", "subList4 = " + this.subList4.size());
        } else {
            int i7 = 0;
            byte b = -1;
            for (int i8 = 0; i8 < list.size(); i8++) {
                getClassId(list.get(i8));
                if (i7 == 0) {
                    int i9 = this.weekIndex;
                    if (i8 % i9 == 0) {
                        if ("0".equals(list.get(i8).timeFrame)) {
                            addNullDay(this.subList1);
                            i7 = i9;
                            b = 0;
                        } else if ("1".equals(list.get(i8).timeFrame)) {
                            addNullDay(this.subList2);
                            i7 = i9;
                            b = 1;
                        } else if ("2".equals(list.get(i8).timeFrame)) {
                            addNullDay(this.subList3);
                            i7 = i9;
                            b = 2;
                        } else if ("3".equals(list.get(i8).timeFrame)) {
                            addNullDay(this.subList4);
                            i7 = i9;
                            b = 3;
                        } else {
                            i7 = i9;
                        }
                    }
                }
                i7--;
                if (b == 0 && this.maxDay >= list.get(i8).weekTime) {
                    this.subList1.add(list.get(i8));
                } else if (b == 1 && this.maxDay >= list.get(i8).weekTime) {
                    this.subList2.add(list.get(i8));
                } else if (b == 2 && this.maxDay >= list.get(i8).weekTime) {
                    this.subList3.add(list.get(i8));
                } else if (b == 3 && this.maxDay >= list.get(i8).weekTime) {
                    this.subList4.add(list.get(i8));
                }
            }
        }
        if (this.subList1.size() == 0) {
            i = 8;
            this.gvList1.setVisibility(8);
            this.v1.setVisibility(8);
            this.llMorningReading.setVisibility(8);
        } else {
            i = 8;
        }
        if (this.subList2.size() == 0) {
            this.gvList2.setVisibility(i);
            this.v2.setVisibility(i);
            this.llForenoon.setVisibility(i);
        }
        if (this.subList3.size() == 0) {
            this.gvList3.setVisibility(i);
            this.v3.setVisibility(i);
            this.llAfternoon.setVisibility(i);
        }
        if (this.subList4.size() == 0) {
            this.gvList4.setVisibility(i);
            this.llNight.setVisibility(i);
        }
        Log.i(this.TAG, "list1===" + this.subList1.size());
        Log.i(this.TAG, "list2===" + this.subList2.size());
        Log.i(this.TAG, "list3===" + this.subList3.size());
        Log.i(this.TAG, "list4===" + this.subList4.size());
        if ("单双周课表不同".equals(this.rsp.data.timetableType)) {
            if (!StringUtils.isEmpty(this.rsp.data.weekCount) && Integer.parseInt(this.rsp.data.weekCount) % 2 == 0) {
                setTableType(2);
            } else {
                setTableType(1);
            }
        }
        this.adapter1.notifyData(this.subList1, this.checkId);
        this.adapter2.notifyData(this.subList2, this.checkId);
        this.adapter3.notifyData(this.subList3, this.checkId);
        this.adapter4.notifyData(this.subList4, this.checkId);
        setParams();
    }

    void setTableType(int i) {
        if (i == 1) {
            this.tableType = 1;
            this.checkbox.setText("切换双周");
            this.adapter1.settimetableType(1);
            this.adapter2.settimetableType(1);
            this.adapter3.settimetableType(1);
            this.adapter4.settimetableType(1);
            this.title_Name.setText("单周课表");
        } else {
            this.tableType = 2;
            this.checkbox.setText("切换单周");
            this.adapter1.settimetableType(2);
            this.adapter2.settimetableType(2);
            this.adapter3.settimetableType(2);
            this.adapter4.settimetableType(2);
            this.title_Name.setText("双周课表");
        }
        Log.i("TAG", "setTableType: ");
        this.week.setText("当前周次：第" + this.rsp.data.weekCount + "周");
    }

    private void getMaxDay(List<UserTableRsp.DataDTO.SubListDTO> list) {
        if (this.statusCount == this.weekCount) {
            for (UserTableRsp.DataDTO.SubListDTO subListDTO : list) {
                if (subListDTO.weekTime > this.lateWeek) {
                    this.lateWeek = subListDTO.weekTime;
                    this.maxDay = subListDTO.weekTime;
                }
            }
            if (this.maxDay < 5) {
                this.maxDay = 5;
                return;
            }
            return;
        }
        for (UserTableRsp.DataDTO.SubListDTO subListDTO2 : list) {
            if (subListDTO2.weekTime > this.maxDay && !StringUtils.isEmpty(subListDTO2.subjectName)) {
                this.maxDay = subListDTO2.weekTime;
            }
        }
        if (this.maxDay < 5) {
            this.maxDay = 5;
        }
        this.tv_saturday.setVisibility(this.maxDay < 6 ? 8 : 0);
        this.tv_sunday.setVisibility(this.maxDay >= 7 ? 0 : 8);
    }

    private void setParams() {
        this.llLab.removeAllViews();
        setLab();
        int size = this.subList1.size() / this.maxDay < 1 ? 0 : this.subList1.size() / this.maxDay;
        int size2 = this.subList2.size() / this.maxDay < 1 ? 0 : this.subList2.size() / this.maxDay;
        int size3 = this.subList3.size() / this.maxDay < 1 ? 0 : this.subList3.size() / this.maxDay;
        int size4 = this.subList4.size() / this.maxDay < 1 ? 0 : this.subList4.size() / this.maxDay;
        this.llMorningReading.setLayoutParams(new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((this.height * size) + this.height1 + size)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((this.height * size2) + this.height2 + size2 + this.cou));
        layoutParams.setMargins(0, getViewHeight(2), 0, 0);
        this.llForenoon.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((this.height * size3) + this.height3 + size3 + this.cou));
        layoutParams2.setMargins(0, getViewHeight(3), 0, 0);
        this.llAfternoon.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px((this.height * size4) + this.height4 + size4 + this.cou));
        layoutParams3.setMargins(0, getViewHeight(4), 0, 0);
        this.llNight.setLayoutParams(layoutParams3);
    }

    public int getViewHeight(int i) {
        if (i > 3) {
            if (this.subList3.size() == 0) {
                if (this.subList2.size() == 0) {
                    if (this.subList1.size() == 0) {
                        return 0;
                    }
                    return SizeUtils.dp2px(10.0f);
                }
                return SizeUtils.dp2px(10.0f);
            }
            return SizeUtils.dp2px(10.0f);
        }
        if (i > 2) {
            if (this.subList2.size() == 0) {
                if (this.subList1.size() == 0) {
                    return 0;
                }
                return SizeUtils.dp2px(10.0f);
            }
            return SizeUtils.dp2px(10.0f);
        }
        if (i <= 1 || this.subList1.size() == 0) {
            return 0;
        }
        return SizeUtils.dp2px(10.0f);
    }

    private void setLab() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        this.height1 = 0;
        this.height2 = 0;
        this.height3 = 0;
        this.height4 = 0;
        int size = this.subList1.size() / this.maxDay;
        this.height1 = (this.subList1.size() / this.maxDay) - 1;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(((this.subList1.size() / this.maxDay) * this.height) + size));
        TextView textView = new TextView(this.mActivity);
        textView.setTextSize(SizeUtils.px2sp(20.0f));
        textView.setText("早读");
        textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black13));
        textView.setBackgroundResource(R.color.white);
        textView.setLayoutParams(layoutParams4);
        textView.setGravity(17);
        this.llLab.addView(textView);
        this.llLab.addView(addLine());
        for (int i = 0; i < this.subList2.size() / this.maxDay; i++) {
            if (i > 0) {
                this.height2++;
                layoutParams3 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams3 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            if (i == 0) {
                layoutParams3.setMargins(0, getViewHeight(2), 0, 0);
            } else {
                layoutParams3.setMargins(0, 0, 0, 0);
            }
            TextView textView2 = new TextView(this.mActivity);
            textView2.setTextSize(SizeUtils.px2sp(20.0f));
            List<UserTableRsp.DataDTO.SubListDTO> list = this.subList2;
            if (list != null && list.get(this.maxDay * i) != null) {
                String lab2 = setLab2(this.subList2, this.maxDay * i);
                if (StringUtils.isEmpty(lab2)) {
                    textView2.setText("无课");
                } else {
                    textView2.setText("第" + lab2 + "节");
                }
            } else {
                textView2.setText("*");
            }
            textView2.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black13));
            textView2.setBackgroundResource(R.color.white);
            textView2.setLayoutParams(layoutParams3);
            textView2.setGravity(17);
            this.llLab.addView(textView2);
            this.llLab.addView(addLine());
        }
        for (int i2 = 0; i2 < this.subList3.size() / this.maxDay; i2++) {
            if (i2 > 0) {
                this.height3++;
                layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            if (i2 == 0) {
                layoutParams2.setMargins(0, getViewHeight(3), 0, 0);
            } else {
                layoutParams2.setMargins(0, 0, 0, 0);
            }
            TextView textView3 = new TextView(this.mActivity);
            textView3.setTextSize(SizeUtils.px2sp(20.0f));
            List<UserTableRsp.DataDTO.SubListDTO> list2 = this.subList3;
            if (list2 != null && list2.get(this.maxDay * i2) != null) {
                String lab3 = setLab2(this.subList3, this.maxDay * i2);
                if (StringUtils.isEmpty(lab3)) {
                    textView3.setText("无课");
                } else {
                    textView3.setText("第" + lab3 + "节");
                }
            } else {
                textView3.setText("*");
            }
            textView3.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black13));
            textView3.setBackgroundResource(R.color.white);
            textView3.setLayoutParams(layoutParams2);
            textView3.setGravity(17);
            this.llLab.addView(textView3);
            this.llLab.addView(addLine());
        }
        for (int i3 = 0; i3 < this.subList4.size() / this.maxDay; i3++) {
            if (i3 > 0) {
                this.height4++;
                layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height + 1));
            } else {
                layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            }
            if (i3 == 0) {
                layoutParams.setMargins(0, getViewHeight(4), 0, 0);
            } else {
                layoutParams.setMargins(0, 0, 0, 0);
            }
            TextView textView4 = new TextView(this.mActivity);
            textView4.setTextSize(SizeUtils.px2sp(20.0f));
            List<UserTableRsp.DataDTO.SubListDTO> list3 = this.subList4;
            if (list3 != null && list3.get(this.maxDay * i3) != null) {
                String lab4 = setLab2(this.subList4, this.maxDay * i3);
                if (StringUtils.isEmpty(lab4)) {
                    textView4.setText("无课");
                } else {
                    textView4.setText("第" + lab4 + "节");
                }
            } else {
                textView4.setText("*");
            }
            textView4.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black13));
            textView4.setBackgroundResource(R.color.white);
            textView4.setLayoutParams(layoutParams);
            textView4.setGravity(17);
            this.llLab.addView(textView4);
            this.llLab.addView(addLine());
        }
    }

    View addLine() {
        return this.mActivity.getLayoutInflater().inflate(R.layout.layout_line, (ViewGroup) null);
    }

    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v1 int, still in use, count: 2, list:
  (r5v1 int) from 0x003d: IF  (r5v1 int) != (1598 int)  -> B:9:0x003f A[HIDDEN]
  (r5v1 int) from 0x0042: SWITCH (r5v1 int)
 case 1567: goto B:39:0x00b3
 case 1568: goto B:36:0x00a7
 case 1569: goto B:33:0x009b
 case 1570: goto B:30:0x008f
 case 1571: goto B:27:0x0083
 case 1572: goto B:24:0x0077
 case 1573: goto B:21:0x006b
 case 1574: goto B:18:0x005f
 case 1575: goto B:15:0x0053
 case 1576: goto B:12:0x0047
 default: goto B:72:0x0124 A[RegionRef:SW:10]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String setLab2(List<UserTableRsp.DataDTO.SubListDTO> list, int i) {
        Log.i(this.TAG, "list == " + list.size() + "postion=" + i);
        for (int i2 = i; i2 < this.maxDay + i; i2++) {
            String str = list.get(i2).section;
            if (!StringUtils.isEmpty(str)) {
                byte b = -1;
                if (iHashCode != 1598) {
                    switch (str) {
                        case "1":
                            b = 0;
                            break;
                        case "2":
                            b = 1;
                            break;
                        case "3":
                            b = 2;
                            break;
                        case "4":
                            b = 3;
                            break;
                        case "5":
                            b = 4;
                            break;
                        case "6":
                            b = 5;
                            break;
                        case "7":
                            b = 6;
                            break;
                        case "8":
                            b = 7;
                            break;
                        case "9":
                            b = 8;
                            break;
                        default:
                            switch (iHashCode) {
                                case 1567:
                                    if (str.equals(ConversionUtil.conditionWithSort)) {
                                        b = 9;
                                    }
                                    break;
                                case 1568:
                                    if (str.equals(ConversionUtil.conditionWithYear)) {
                                        b = 10;
                                    }
                                    break;
                                case 1569:
                                    if (str.equals("12")) {
                                        b = 11;
                                    }
                                    break;
                                case 1570:
                                    if (str.equals("13")) {
                                        b = 12;
                                    }
                                    break;
                                case 1571:
                                    if (str.equals("14")) {
                                        b = 13;
                                    }
                                    break;
                                case 1572:
                                    if (str.equals("15")) {
                                        b = 14;
                                    }
                                    break;
                                case 1573:
                                    if (str.equals("16")) {
                                        b = 15;
                                    }
                                    break;
                                case 1574:
                                    if (str.equals("17")) {
                                        b = 16;
                                    }
                                    break;
                                case 1575:
                                    if (str.equals("18")) {
                                        b = 17;
                                    }
                                    break;
                                case 1576:
                                    if (str.equals("19")) {
                                        b = 18;
                                    }
                                    break;
                            }
                    }
                } else if (str.equals("20")) {
                    b = 19;
                }
                switch (b) {
                    case 0:
                        return "一";
                    case 1:
                        return "二";
                    case 2:
                        return "三";
                    case 3:
                        return "四";
                    case 4:
                        return "五";
                    case 5:
                        return "六";
                    case 6:
                        return "七";
                    case 7:
                        return "八";
                    case 8:
                        return "九";
                    case 9:
                        return "十";
                    case 10:
                        return "十一";
                    case 11:
                        return "十二";
                    case 12:
                        return "十三";
                    case 13:
                        return "十四";
                    case 14:
                        return "十五";
                    case 15:
                        return "十六";
                    case 16:
                        return "十七";
                    case 17:
                        return "十八";
                    case 18:
                        return "十九";
                    case 19:
                        return "二十";
                    default:
                        return str;
                }
            }
        }
        return "";
    }

    private void setAdapter() {
        TimeUtil.getIntWeek(System.currentTimeMillis());
        this.adapter1 = new ClassScheduleAdapter22(this.mActivity, this.maxDay);
        this.adapter2 = new ClassScheduleAdapter22(this.mActivity, this.maxDay);
        this.adapter3 = new ClassScheduleAdapter22(this.mActivity, this.maxDay);
        this.adapter4 = new ClassScheduleAdapter22(this.mActivity, this.maxDay);
        this.gvList1.setNumColumns(this.maxDay);
        this.gvList2.setNumColumns(this.maxDay);
        this.gvList3.setNumColumns(this.maxDay);
        this.gvList4.setNumColumns(this.maxDay);
        this.gvList1.setAdapter((ListAdapter) this.adapter1);
        this.gvList2.setAdapter((ListAdapter) this.adapter2);
        this.gvList3.setAdapter((ListAdapter) this.adapter3);
        this.gvList4.setAdapter((ListAdapter) this.adapter4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public UserCenterPresenter createPresenter() {
        return new UserCenterPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableData(UserTableRsp userTableRsp) {
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.dismiss();
        }
        this.rsp = userTableRsp;
        if (userTableRsp == null || userTableRsp.data == null) {
            this.mu.setViewState(2);
            return;
        }
        if (this.oneStart.booleanValue()) {
            this.weekday = userTableRsp.data.weekCount;
            this.oneStart = false;
        }
        if ("每周课表不相同".equals(userTableRsp.data.timetableType)) {
            this.rl_check.setVisibility(0);
            this.rl_rb.setVisibility(8);
            this.type = 1;
            if (this.weekday.equals(userTableRsp.data.weekCount)) {
                this.title_Name.setText("第" + userTableRsp.data.weekCount + "周课表(本周)");
            } else {
                this.title_Name.setText("第" + userTableRsp.data.weekCount + "周课表");
            }
            this.weekCount = Integer.parseInt(userTableRsp.data.weekCount);
            Log.i("TAG", "UserTableData: 第" + userTableRsp.data.weekCount + "周课表");
        } else if ("单双周课表不同".equals(userTableRsp.data.timetableType)) {
            this.rl_check.setVisibility(8);
            this.rl_rb.setVisibility(0);
            this.title_Name.setText("单周课表");
            this.type = 2;
            this.rbWeek.setText("单周");
            this.rbTrimester.setText("双周");
            this.rbMonth.setVisibility(8);
            this.title_Name.setText("单周课表");
            this.week.setText("当前周次：第" + userTableRsp.data.weekCount + "周");
        } else {
            this.rl_check.setVisibility(0);
            this.rl_rb.setVisibility(8);
            this.type = 0;
            this.title_Name.setText("课表");
            this.rgCheck.setVisibility(8);
        }
        if (userTableRsp != null || (userTableRsp.data != null && userTableRsp.data.subList != null)) {
            initData(userTableRsp.data.subList);
            this.statusCount = userTableRsp.data.statusCount;
            Log.i("TAG", "UserTableData: statusCount" + this.statusCount);
            int i = this.weekCount;
            if (i == 1) {
                this.rbWeek.setChecked(true);
                this.rbTrimester.setChecked(false);
            } else {
                int i2 = this.statusCount;
                if (i < i2) {
                    this.rbWeek.setChecked(false);
                    this.rbTrimester.setChecked(false);
                } else if (i == i2) {
                    this.rbWeek.setChecked(false);
                    this.rbTrimester.setChecked(true);
                } else {
                    this.rbWeek.setChecked(true);
                    this.rbTrimester.setChecked(true);
                }
            }
            this.mu.setViewState(0);
            return;
        }
        this.mu.setViewState(2);
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableDataFail(String str) {
        if (this.mActivity.isDestroyed()) {
            return;
        }
        this.bookLoadingDiallog.dismiss();
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    public String getWeek() {
        switch (TimeUtils.getChineseWeek(new Date())) {
            case "周一":
                this.thisweek = "1";
                break;
            case "周二":
                this.thisweek = "2";
                break;
            case "周三":
                this.thisweek = "3";
                break;
            case "周四":
                this.thisweek = "4";
                break;
            case "周五":
                this.thisweek = ConversionUtil.conditionWithSeriesName;
                break;
            case "周六":
                this.thisweek = ConversionUtil.conditionWithCallNumber;
                break;
            case "周日":
                this.thisweek = ConversionUtil.conditionWithBookType;
                break;
        }
        return this.thisweek;
    }

    public void getClassId(UserTableRsp.DataDTO.SubListDTO subListDTO) {
        if (this.thisweek.equals(subListDTO.weekTime + "") && StringUtils.isEmpty(this.checkId) && TimeUtil.gettime99(subListDTO.toDateTime) > TimeUtil.gettime99(TimeUtil.stampToDate7(System.currentTimeMillis()))) {
            this.checkId = subListDTO.id;
        }
    }
}
