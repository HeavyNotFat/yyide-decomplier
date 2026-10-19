package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.NcMsgALLAdapter;
import com.yd.android_brand_mvp.adapter.NcWeekAdapter;
import com.yd.android_brand_mvp.adapter.TopWeekAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.MonthBean;
import com.yd.android_brand_mvp.model.NcMsgALLBean;
import com.yd.android_brand_mvp.model.YearBean;
import com.yd.android_brand_mvp.model.getSchoolCalendarRsp;
import com.yd.android_brand_mvp.model.selectSchoolCalendarRsp;
import com.yd.android_brand_mvp.presenter.NcalendarPresenter;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.view.NcalendarView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NcalendarAcFragment extends BaseMvpFragment<NcalendarPresenter> implements NcalendarView {

    @BindView(R.id.all_mu)
    MultiStateView all_mu;
    getSchoolCalendarRsp bean;
    int cnum;

    @BindView(R.id.layout_month)
    LinearLayout layout_month;

    @BindView(R.id.layout_week)
    LinearLayout layout_week;

    @BindView(R.id.listview)
    ListView listview;

    @BindView(R.id.lyaout_year)
    LinearLayout lyaout_year;

    @BindView(R.id.mu)
    MultiStateView mu;
    NcMsgALLAdapter ncMsgALLAdapter;
    NcWeekAdapter ncWekkAdapter;
    TopWeekAdapter topWeekAdapter;

    @BindView(R.id.top_grid)
    GridView top_grid;
    Unbinder unbinder;
    View view;

    @BindView(R.id.week_grid)
    GridView week_grid;
    String startTime = "2021-09-10";
    String endTime = "2022-06-10";
    int height = 59;
    List<MonthBean> listbean = new ArrayList();
    String[] weekstrs = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "二十一", "二十二", "二十三", "二十四", "二十五", "二十六", "二十七", "二十八", "二十九", "三十", "三十一", "三十二", "三十三", "三十四", "三十五", "三十六", "三十七", "三十八", "三十九", "四十", "四十一", "四十二", "四十三", "四十四", "四十五", "四十六", "四十七", "四十八", "四十九", "五十", "五十一", "五十二", "五十三", "五十四", "五十五", "五十六", "五十七", "五十八", "五十九", "六十", "六十一", "六十二", "六十三", "六十四", "六十五", "六十六", "六十七", "六十八", "六十九", "七十", "七十一", "七十二", "七十三", "七十四", "七十五", "七十六", "七十七", "七十八", "七十九", "八十", "八十一", "八十二", "八十三", "八十四", "八十五", "八十六", "八十七", "八十八", "八十九", "九十", "九十一", "九十二", "九十三", "九十四", "九十五", "九十六", "九十七", "九十八", "九十九", "一百", "一百零一", "一百零二", "一百零三", "一百零四", "一百零五", "一百零六", "一百零七", "一百零八", "一百零九"};

    @Override // com.yd.android_brand_mvp.view.NcalendarView
    public void getSchoolCalendarFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.NcalendarView
    public void getselectSchoolCalendarFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.NcalendarView
    public void getselectSchoolCalendarSuccess(selectSchoolCalendarRsp selectschoolcalendarrsp) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (ScreenUtils.isLandscape()) {
            this.view = layoutInflater.inflate(R.layout.fragment_ncalendar_activity2, viewGroup, false);
        } else {
            this.view = layoutInflater.inflate(R.layout.fragment_ncalendar_activity3, viewGroup, false);
        }
        this.unbinder = ButterKnife.bind(this, this.view);
        this.ncWekkAdapter = new NcWeekAdapter();
        this.topWeekAdapter = new TopWeekAdapter();
        this.ncMsgALLAdapter = new NcMsgALLAdapter();
        this.top_grid.setAdapter((ListAdapter) this.topWeekAdapter);
        this.week_grid.setAdapter((ListAdapter) this.ncWekkAdapter);
        this.listview.setAdapter((ListAdapter) this.ncMsgALLAdapter);
        return this.view;
    }

    void setData() {
        List<String> days = Tool.getDays(this.startTime, this.endTime);
        List<String> arrayList = new ArrayList<>();
        this.cnum = 0;
        if (days.size() > 0) {
            int i = Integer.parseInt(TimeUtil.getWeek2(TimeUtil.gettime10(days.get(0))));
            for (int i2 = 1; i2 < i; i2++) {
                arrayList.add("");
                this.cnum++;
            }
        }
        arrayList.addAll(days);
        this.ncWekkAdapter.notyfaData(arrayList);
        addWeekView(arrayList);
        addYearView(this.startTime, this.endTime);
        addMonthView(this.startTime, this.endTime);
    }

    void addMonthView(String str, String str2) {
        int size;
        LinearLayout.LayoutParams layoutParams;
        String strStampToDate14 = TimeUtil.stampToDate14(TimeUtil.gettime10(str));
        String strStampToDate15 = TimeUtil.stampToDate14(TimeUtil.gettime10(str2));
        List<String> days = Tool.getDays(str, str2);
        for (String str3 : Tool.getMonthBetween(strStampToDate14, strStampToDate15)) {
            MonthBean monthBean = new MonthBean();
            monthBean.Month = str3;
            this.listbean.add(monthBean);
        }
        for (MonthBean monthBean2 : this.listbean) {
            Iterator<String> it2 = days.iterator();
            while (it2.hasNext()) {
                if (it2.next().contains(monthBean2.Month)) {
                    monthBean2.num++;
                }
            }
        }
        Log.e("TAG", "addMonthView: " + JSON.toJSONString(this.listbean));
        this.ncWekkAdapter.setNc(this.listbean);
        int size2 = this.ncWekkAdapter.list.size();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (IsHaveFirst()) {
            arrayList2.add(TimeUtil.stampToDate14(TimeUtil.gettime10(str)));
        }
        for (int i = 1; i <= size2 / 7; i++) {
            int i2 = i * 7;
            if (i2 <= this.ncWekkAdapter.list.size() - 1) {
                arrayList2.add(TimeUtil.stampToDate14(TimeUtil.gettime10(this.ncWekkAdapter.list.get(i2))));
            }
        }
        Log.e("TAG", "indexlist: " + JSON.toJSONString(arrayList2));
        int i3 = 0;
        while (i3 < arrayList2.size()) {
            int i4 = i3 + 1;
            if (i4 < arrayList2.size() && !((String) arrayList2.get(i3)).equals(arrayList2.get(i4))) {
                arrayList.add(Integer.valueOf(i4));
            }
            i3 = i4;
        }
        Log.e("TAG", "ncWekkAdapter: " + JSON.toJSONString(arrayList));
        int i5 = 0;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            if (i6 == 0) {
                int iIntValue = IsHaveFirst() ? 1 : ((Integer) arrayList.get(i6)).intValue() + 1;
                i5 += iIntValue;
                layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height * iIntValue));
            } else {
                int iIntValue2 = ((Integer) arrayList.get(i6)).intValue() - ((Integer) arrayList.get(i6 - 1)).intValue();
                i5 += iIntValue2;
                layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height * iIntValue2));
            }
            TextView textView = new TextView(getActivity());
            textView.setGravity(17);
            textView.setTextSize(SizeUtils.px2sp(20.0f));
            textView.setText(Integer.parseInt(TimeUtil.stampToDate17(TimeUtil.gettime11(this.listbean.get(i6).Month))) + "月");
            textView.setBackgroundResource(R.drawable.bg_ac_nc_item);
            textView.setLayoutParams(layoutParams);
            this.layout_month.addView(textView);
        }
        if (size2 % 7 == 0) {
            size = this.ncWekkAdapter.list.size() / 7;
        } else {
            size = (this.ncWekkAdapter.list.size() / 7) + 1;
        }
        int i7 = size - i5;
        StringBuilder sb = new StringBuilder();
        sb.append("addMonthView: ");
        sb.append(JSON.toJSONString("sum==>" + size2 + "cd==>" + i5));
        Log.e("TAG", sb.toString());
        if (i7 > 0) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height * i7));
            TextView textView2 = new TextView(getActivity());
            textView2.setGravity(17);
            textView2.setTextSize(SizeUtils.px2sp(20.0f));
            List<MonthBean> list = this.listbean;
            textView2.setText(TimeUtil.stampToDate17(TimeUtil.gettime11(list.get(list.size() - 1).Month)) + "月");
            textView2.setBackgroundResource(R.drawable.bg_ac_nc_item);
            textView2.setLayoutParams(layoutParams2);
            this.layout_month.addView(textView2);
        }
    }

    boolean IsHaveFirst() {
        String strStampToDate14;
        String str = "";
        boolean z = false;
        for (int i = 0; i < 7; i++) {
            if (!TextUtils.isEmpty(this.ncWekkAdapter.list.get(i))) {
                strStampToDate14 = TimeUtil.stampToDate14(TimeUtil.gettime10(this.ncWekkAdapter.list.get(i)));
            } else {
                strStampToDate14 = TimeUtil.stampToDate14(TimeUtil.gettime10(this.startTime));
            }
            if (TextUtils.isEmpty(str)) {
                str = strStampToDate14;
            } else if (!str.equals(strStampToDate14)) {
                z = true;
            }
        }
        return z;
    }

    void addWeekView(List<String> list) {
        int size;
        if (list.size() % 7 == 0) {
            size = list.size() / 7;
        } else {
            size = (list.size() / 7) + 1;
        }
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height));
            TextView textView = new TextView(getActivity());
            textView.setGravity(17);
            textView.setTextSize(SizeUtils.px2sp(20.0f));
            String[] strArr = this.weekstrs;
            if (i < strArr.length) {
                textView.setText(strArr[i]);
            } else {
                textView.setText("第" + (i + 1) + "周");
            }
            textView.setBackgroundResource(R.drawable.bg_ac_nc_item);
            textView.setLayoutParams(layoutParams);
            this.layout_week.addView(textView);
        }
    }

    void addYearView(String str, String str2) {
        int i;
        int i2;
        String strStampToDate15;
        String strStampToDate16;
        Tool.getMonthBetween(TimeUtil.stampToDate14(TimeUtil.gettime10(str)), TimeUtil.stampToDate14(TimeUtil.gettime10(str2)));
        TimeUtil.stampToDate15(TimeUtil.gettime10(str));
        String strStampToDate17 = TimeUtil.stampToDate15(TimeUtil.gettime10(str));
        String strStampToDate18 = TimeUtil.stampToDate15(TimeUtil.gettime10(str2));
        int i3 = Integer.parseInt(strStampToDate18);
        Integer.parseInt(strStampToDate17);
        String strValueOf = String.valueOf(i3 - 1);
        ArrayList arrayList = new ArrayList();
        for (String str3 : this.ncWekkAdapter.list) {
            YearBean yearBean = new YearBean();
            if (!TextUtils.isEmpty(str3)) {
                strStampToDate16 = TimeUtil.stampToDate15(TimeUtil.gettime10(str3));
            } else {
                strStampToDate16 = TimeUtil.stampToDate15(TimeUtil.gettime10(str));
            }
            yearBean.Year = strStampToDate16;
            if (!isHava(arrayList, strStampToDate16)) {
                arrayList.add(yearBean);
            }
        }
        for (YearBean yearBean2 : arrayList) {
            for (String str4 : this.ncWekkAdapter.list) {
                if (!TextUtils.isEmpty(str4)) {
                    strStampToDate15 = TimeUtil.stampToDate15(TimeUtil.gettime10(str4));
                } else {
                    strStampToDate15 = TimeUtil.stampToDate15(TimeUtil.gettime10(str));
                }
                if (strStampToDate15.equals(yearBean2.Year)) {
                    yearBean2.num++;
                }
            }
        }
        Log.e("TAG", "yearBean==>: " + JSON.toJSONString(arrayList));
        int i4 = 0;
        if (arrayList.size() == 0) {
            i = 0;
            i2 = 0;
        } else if (arrayList.size() == 1) {
            int i5 = arrayList.get(0).num / 7;
            if (i5 != 0) {
                i5++;
            }
            i4 = i5;
            i = 0;
            i2 = 0;
        } else if (arrayList.size() == 2) {
            int i6 = arrayList.get(1).num;
            int i7 = arrayList.get(0).num;
            int size = this.ncWekkAdapter.list.size();
            int i8 = i7 / 7;
            if (i8 != 0) {
                i8++;
            }
            int i9 = size / 7;
            i4 = i8;
            i = i9 == 0 ? i9 - i8 : (i9 - i8) + 1;
            i2 = 0;
        } else {
            int i10 = arrayList.get(arrayList.size() - 1).num;
            int i11 = arrayList.get(0).num / 7;
            i4 = i11 == 0 ? 1 : i11 + 1;
            int size2 = this.ncWekkAdapter.list.size();
            if ((this.ncWekkAdapter.list.size() - i10) / 7 == 0) {
                i = i10 / 7;
            } else {
                i = (i10 / 7) + 1;
            }
            int i12 = size2 / 7;
            if (i12 != 0) {
                i12++;
            }
            i2 = (i12 - i4) - i;
        }
        Log.e("TAG", "sY: " + i4);
        Log.e("TAG", "zY: " + i2);
        Log.e("TAG", "eY: " + i);
        if (i4 > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height * i4));
            TextView textView = new TextView(getActivity());
            textView.setGravity(17);
            textView.setTextSize(SizeUtils.px2sp(20.0f));
            textView.setText(strStampToDate17);
            textView.setBackgroundResource(R.drawable.bg_ac_nc_item);
            textView.setLayoutParams(layoutParams);
            this.lyaout_year.addView(textView);
        }
        if (i2 > 0) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height * i2));
            TextView textView2 = new TextView(getActivity());
            textView2.setGravity(17);
            textView2.setTextSize(SizeUtils.px2sp(20.0f));
            textView2.setText(strValueOf);
            textView2.setBackgroundResource(R.drawable.bg_ac_nc_item);
            textView2.setLayoutParams(layoutParams2);
            this.lyaout_year.addView(textView2);
        }
        if (i > 0) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, SizeUtils.dp2px(this.height * i));
            TextView textView3 = new TextView(getActivity());
            textView3.setGravity(17);
            textView3.setTextSize(SizeUtils.px2sp(20.0f));
            textView3.setText(strStampToDate18);
            textView3.setBackgroundResource(R.drawable.bg_ac_nc_item);
            textView3.setLayoutParams(layoutParams3);
            this.lyaout_year.addView(textView3);
        }
    }

    boolean isHava(List<YearBean> list, String str) {
        Iterator<YearBean> it2 = list.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (it2.next().Year.equals(str)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public NcalendarPresenter createPresenter() {
        return new NcalendarPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.NcalendarView
    public void getSchoolCalendarSuccess(getSchoolCalendarRsp getschoolcalendarrsp) {
        if (getschoolcalendarrsp.code.intValue() == 0) {
            if (getschoolcalendarrsp != null && getschoolcalendarrsp.data != null && getschoolcalendarrsp.data.semester != null && getschoolcalendarrsp.data.semester.id != null) {
                this.all_mu.setViewState(0);
                this.startTime = getschoolcalendarrsp.data.semester.startDate;
                this.endTime = getschoolcalendarrsp.data.semester.endDate;
                setData();
                this.bean = getschoolcalendarrsp;
                ArrayList arrayList = new ArrayList();
                for (getSchoolCalendarRsp.DataDTO.SchoolCalendarEventListDTO.MonthListDTO monthListDTO : getschoolcalendarrsp.data.schoolCalendarEventList.monthList) {
                    NcMsgALLBean ncMsgALLBean = new NcMsgALLBean();
                    ncMsgALLBean.remark = monthListDTO.remark;
                    ncMsgALLBean.startTime = monthListDTO.startTime;
                    arrayList.add(ncMsgALLBean);
                }
                Log.e("TAG", "NcMsgALLBean: " + JSON.toJSONString(arrayList));
                if (ScreenUtils.isLandscape()) {
                    this.mu.setViewState(arrayList.size() != 0 ? 0 : 2);
                } else {
                    this.mu.setViewState(0);
                }
                this.ncMsgALLAdapter.notydata(arrayList);
                this.ncWekkAdapter.setindex(arrayList);
                return;
            }
            this.all_mu.setViewState(2);
            ToastUtil.showBottomView(this.mActivity, "获取校历为空");
            return;
        }
        if (ScreenUtils.isLandscape()) {
            this.mu.setViewState(2);
        } else {
            this.mu.setViewState(0);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((NcalendarPresenter) this.mvpPresenter).getSchoolCalendar();
    }
}
