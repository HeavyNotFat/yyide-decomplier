package com.yd.android_brand_mvp.landscape;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.necer.calendar.BaseCalendar;
import com.necer.calendar.MonthCalendar;
import com.necer.enumeration.DateChangeBehavior;
import com.necer.listener.OnCalendarChangedListener;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.NcalendarActivity;
import com.yd.android_brand_mvp.adapter.GeneralAdapter;
import com.yd.android_brand_mvp.adapter.NcMsgAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.getSchoolCalendarRsp;
import com.yd.android_brand_mvp.model.selectSchoolCalendarRsp;
import com.yd.android_brand_mvp.presenter.NcalendarPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.view.NcalendarView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import org.joda.time.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
public class NCalendarLFragment extends BaseMvpFragment<NcalendarPresenter> implements NcalendarView {

    @BindView(R.id.calendar)
    MonthCalendar Calendar;

    @BindView(R.id.all_mu)
    MultiStateView all_mu;

    @BindView(R.id.ivBack)
    TextView back;
    getSchoolCalendarRsp bean;

    @BindView(R.id.bg)
    RelativeLayout bg;
    boolean fy;
    GeneralAdapter generalAdapter;

    @BindView(R.id.left_month)
    TextView left_month;

    @BindView(R.id.listview)
    ListView listview;

    @BindView(R.id.mu)
    MultiStateView mu;
    NcMsgAdapter ncMsgAdapter;

    @BindView(R.id.right_month)
    TextView right_month;

    @BindView(R.id.schoolyear)
    TextView schoolyear;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.top_layout)
    LinearLayout top_layout;

    @BindView(R.id.month)
    TextView tv_month;
    String type;
    View view;
    String time = "";
    boolean delay = true;
    boolean first = true;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if ("hbxl25".equals(this.type) || "sbxl45".equals(this.type)) {
            this.view = layoutInflater.inflate(R.layout.fragment_ncalendar_2_5_l, viewGroup, false);
        } else if ("hbxl44".equals(this.type) || "sbxl42".equals(this.type) || "dxhbxl44".equals(this.type) || "sbxl63".equals(this.type) || "hbxl43".equals(this.type)) {
            this.view = layoutInflater.inflate(R.layout.fragment_ncalendar_4_4_l, viewGroup, false);
        }
        return this.view;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mu.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.NCalendarLFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ((NcalendarPresenter) NCalendarLFragment.this.mvpPresenter).getSchoolCalendar();
            }
        });
        setBg();
        if ("hbxl25".equals(this.type) || "sbxl45".equals(this.type)) {
            this.title.setText("校历");
        } else if ("hbxl44".equals(this.type) || "dxhbxl44".equals(this.type) || "sbxl42".equals(this.type) || "sbxl63".equals(this.type) || "hbxl43".equals(this.type)) {
            this.title.setText("");
        }
        this.left_month.setText("<");
        this.right_month.setText(">");
        NcMsgAdapter ncMsgAdapter = new NcMsgAdapter();
        this.ncMsgAdapter = ncMsgAdapter;
        this.listview.setAdapter((ListAdapter) ncMsgAdapter);
        GeneralAdapter generalAdapter = new GeneralAdapter();
        this.generalAdapter = generalAdapter;
        this.Calendar.setCalendarAdapter(generalAdapter);
        this.Calendar.setScrollEnable(false);
        ((NcalendarPresenter) this.mvpPresenter).getSchoolCalendar();
        this.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$NCalendarLFragment$hnWmu7sJnrc0RunPqWqljvQ0Y7s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$0$NCalendarLFragment(view2);
            }
        });
        this.schoolyear.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$NCalendarLFragment$F9b10goZ0vXwRqaeJZSkslB9O8A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$1$NCalendarLFragment(view2);
            }
        });
        this.generalAdapter.setLastOrNextOnClickListener(new GeneralAdapter.LastOrNextOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$NCalendarLFragment$iW3TUPT_7Kfdu7G0pyCcdINz-u4
            @Override // com.yd.android_brand_mvp.adapter.GeneralAdapter.LastOrNextOnClickListener
            public final void onLastOrNextOnClickListener(LocalDate localDate) {
                this.f$0.lambda$onViewCreated$2$NCalendarLFragment(localDate);
            }
        });
        this.Calendar.setOnCalendarChangedListener(new OnCalendarChangedListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$NCalendarLFragment$ziZf3I-LkSSG4SSYJMuXwQvEJKc
            @Override // com.necer.listener.OnCalendarChangedListener
            public final void onCalendarChange(BaseCalendar baseCalendar, int i, int i2, LocalDate localDate, DateChangeBehavior dateChangeBehavior) {
                this.f$0.lambda$onViewCreated$3$NCalendarLFragment(baseCalendar, i, i2, localDate, dateChangeBehavior);
            }
        });
        this.left_month.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$NCalendarLFragment$s2RLmd-cvXKtHsyTrq3oQZ_oY28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$5$NCalendarLFragment(view2);
            }
        });
        this.right_month.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$NCalendarLFragment$watGWgXG9_TfBnXnKD6LrRS0Ueo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$7$NCalendarLFragment(view2);
            }
        });
    }

    public /* synthetic */ void lambda$onViewCreated$0$NCalendarLFragment(View view) {
        goPermissionsActivity(new Intent(this.mActivity, (Class<?>) NcalendarActivity.class));
    }

    public /* synthetic */ void lambda$onViewCreated$1$NCalendarLFragment(View view) {
        goPermissionsActivity(new Intent(this.mActivity, (Class<?>) NcalendarActivity.class));
    }

    public /* synthetic */ void lambda$onViewCreated$2$NCalendarLFragment(LocalDate localDate) {
        this.Calendar.jumpDate(localDate.toString());
    }

    public /* synthetic */ void lambda$onViewCreated$3$NCalendarLFragment(BaseCalendar baseCalendar, int i, int i2, LocalDate localDate, DateChangeBehavior dateChangeBehavior) {
        Log.e("onCalendarChange", "onCalendarChange:" + localDate);
        if (localDate != null) {
            this.generalAdapter.setIndex(localDate.toString());
        }
        this.Calendar.notifyCalendar();
        if (TextUtils.isEmpty(this.time)) {
            this.fy = true;
        } else {
            String strValueOf = String.valueOf(i2);
            if (strValueOf.length() == 1) {
                strValueOf = "0" + i2;
            }
            if (this.time.contains(i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strValueOf)) {
                this.fy = true;
            } else {
                this.fy = false;
            }
        }
        if (localDate != null) {
            this.time = localDate.toString();
        }
        this.tv_month.setText(i + "年" + i2 + "月");
        getSchoolCalendarRsp getschoolcalendarrsp = this.bean;
        if (getschoolcalendarrsp == null || getschoolcalendarrsp.data == null || this.bean.data.semester == null || this.bean.data.semester.id == null) {
            return;
        }
        String strValueOf2 = String.valueOf(i2);
        if (strValueOf2.length() == 1) {
            strValueOf2 = "0" + i2;
        }
        ((NcalendarPresenter) this.mvpPresenter).selectSchoolCalendar(i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + strValueOf2, this.bean.data.semester.id);
        this.first = false;
    }

    public /* synthetic */ void lambda$onViewCreated$5$NCalendarLFragment(View view) {
        if (this.bean == null || TextUtils.isEmpty(this.time)) {
            return;
        }
        String str = this.bean.data.semester.startDate;
        String strStampToDate14 = TimeUtil.stampToDate14(TimeUtil.gettime10(str));
        String strStampToDate15 = TimeUtil.stampToDate14(TimeUtil.gettime10(this.time));
        Log.e("TAG", "startTime: " + str);
        Log.e("TAG", "time: " + this.time);
        Log.e("TAG", "sdata: " + strStampToDate14);
        Log.e("TAG", "sdata2: " + strStampToDate15);
        if (strStampToDate14.equals(strStampToDate15) || !this.delay) {
            return;
        }
        this.Calendar.toLastPager();
        this.delay = false;
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$NCalendarLFragment$kXeECxAQAPCSDo5mtVfJXm34TQc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onViewCreated$4$NCalendarLFragment();
            }
        }, 500L);
    }

    public /* synthetic */ void lambda$onViewCreated$4$NCalendarLFragment() {
        this.delay = true;
    }

    public /* synthetic */ void lambda$onViewCreated$7$NCalendarLFragment(View view) {
        if (this.bean == null || TextUtils.isEmpty(this.time) || TimeUtil.stampToDate14(TimeUtil.gettime10(this.bean.data.semester.endDate)).equals(TimeUtil.stampToDate14(TimeUtil.gettime10(this.time))) || !this.delay) {
            return;
        }
        this.Calendar.toNextPager();
        this.delay = false;
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$NCalendarLFragment$XaMAqtYr2ktjIpG8UhbcyjvbiwA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onViewCreated$6$NCalendarLFragment();
            }
        }, 500L);
    }

    public /* synthetic */ void lambda$onViewCreated$6$NCalendarLFragment() {
        this.delay = true;
    }

    void setBg() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if ("hbxl25".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(444.0f);
            layoutParams.height = SizeUtils.dp2px(760.0f);
        } else if ("hbxl44".equals(this.type) || "dxhbxl44".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(908.0f);
            layoutParams.height = SizeUtils.dp2px(604.0f);
        } else if ("sbxl42".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(660.0f);
            layoutParams.height = SizeUtils.dp2px(424.0f);
        } else if ("sbxl45".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(660.0f);
            layoutParams.height = SizeUtils.dp2px(1090.0f);
        } else if ("sbxl63".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(1000.0f);
            layoutParams.height = SizeUtils.dp2px(646.0f);
        } else if ("hbxl43".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(908.0f);
            layoutParams.height = SizeUtils.dp2px(454.0f);
            this.bg.setBackgroundResource(R.mipmap.icon_cartoon_calendar_bg);
            this.back.setBackgroundResource(R.mipmap.icon_cartoon_calendar);
            this.left_month.setText("<");
            this.right_month.setText(">");
        }
        this.bg.setLayoutParams(layoutParams);
    }

    public static NCalendarLFragment newInstance(String str) {
        return new NCalendarLFragment(str);
    }

    public NCalendarLFragment() {
    }

    public NCalendarLFragment(String str) {
        this.type = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public NcalendarPresenter createPresenter() {
        return new NcalendarPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.NcalendarView
    public void getSchoolCalendarSuccess(getSchoolCalendarRsp getschoolcalendarrsp) {
        if (getschoolcalendarrsp.code.intValue() == 0) {
            SPUtils.getInstance().put("nc", GsonUtils.toJson(getschoolcalendarrsp));
            if (getschoolcalendarrsp != null && getschoolcalendarrsp.data != null && getschoolcalendarrsp.data.semester != null && getschoolcalendarrsp.data.semester.id != null) {
                SPUtils.getInstance().put(SpData.NEWNCALENDARLGET, GsonUtils.toJson(getschoolcalendarrsp));
                setData(getschoolcalendarrsp);
            } else {
                this.top_layout.setVisibility(8);
                this.all_mu.setViewState(2);
            }
        }
    }

    private void setData(getSchoolCalendarRsp getschoolcalendarrsp) {
        if (getschoolcalendarrsp == null || getschoolcalendarrsp.data == null || getschoolcalendarrsp.data.semester == null || TextUtils.isEmpty(getschoolcalendarrsp.data.semester.endDate)) {
            return;
        }
        this.bean = getschoolcalendarrsp;
        this.all_mu.setViewState(0);
        this.generalAdapter.setTimeContent(getschoolcalendarrsp.data.semester.startDate, getschoolcalendarrsp.data.semester.endDate);
        this.generalAdapter.notydata(new ArrayList());
        this.Calendar.notifyCalendar();
        try {
            Thread.sleep(1500L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.top_layout.setVisibility(0);
        this.schoolyear.setText(getschoolcalendarrsp.data.semester.schoolYear + getschoolcalendarrsp.data.semester.name);
        if (TextUtils.isEmpty(getschoolcalendarrsp.data.semester.startDate)) {
            return;
        }
        if (TimeUtil.gettime10(getschoolcalendarrsp.data.semester.startDate) < System.currentTimeMillis() && System.currentTimeMillis() < TimeUtil.gettime10(getschoolcalendarrsp.data.semester.endDate)) {
            Log.e("TAG", "startDate: " + JSON.toJSONString(Long.valueOf(TimeUtil.gettime10(getschoolcalendarrsp.data.semester.startDate))));
            Log.e("TAG", "currentTimeMillis: " + JSON.toJSONString(Long.valueOf(System.currentTimeMillis())));
            this.Calendar.toToday();
            if (TextUtils.isEmpty(this.time)) {
                return;
            }
            this.Calendar.jumpDate(this.time);
            this.Calendar.toToday();
            return;
        }
        this.Calendar.jumpDate(getschoolcalendarrsp.data.semester.startDate);
    }

    private void setSelectData(selectSchoolCalendarRsp selectschoolcalendarrsp) {
        this.ncMsgAdapter.notfydata(selectschoolcalendarrsp.data);
        this.generalAdapter.notydata(selectschoolcalendarrsp.data);
        this.Calendar.notifyCalendar();
        if (this.fy) {
            for (int i = 0; i < selectschoolcalendarrsp.data.size(); i++) {
                if (this.time.equals(selectschoolcalendarrsp.data.get(i).startTime)) {
                    this.listview.setSelection(i);
                }
            }
        } else if (this.ncMsgAdapter.list.size() > 0) {
            this.listview.setSelection(0);
        }
        if (this.first && this.ncMsgAdapter.list.size() > 0) {
            this.listview.setSelection(0);
        }
        this.mu.setViewState(selectschoolcalendarrsp.data.size() == 0 ? 2 : 0);
    }

    @Override // com.yd.android_brand_mvp.view.NcalendarView
    public void getSchoolCalendarFail(String str) {
        if (SpData.getNewSchoolCalendarRsp() != null) {
            setData(SpData.getNewSchoolCalendarRsp());
        } else {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.NcalendarView
    public void getselectSchoolCalendarSuccess(selectSchoolCalendarRsp selectschoolcalendarrsp) {
        if (selectschoolcalendarrsp.code.intValue() == 0) {
            SPUtils.getInstance().put(SpData.NEWNCALENDARLSELECT, JSON.toJSONString(selectschoolcalendarrsp));
            setSelectData(selectschoolcalendarrsp);
        } else {
            this.mu.setViewState(2);
            this.ncMsgAdapter.notfydata(new ArrayList());
        }
    }

    @Override // com.yd.android_brand_mvp.view.NcalendarView
    public void getselectSchoolCalendarFail(String str) {
        Log.e("getSchoolCalendarFail1", JSON.toJSONString(SpData.getNewSelectSchoolCalendarRsp()));
        if (SpData.getNewSelectSchoolCalendarRsp() != null) {
            setSelectData(SpData.getNewSelectSchoolCalendarRsp());
        } else {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.NC) {
            ((NcalendarPresenter) this.mvpPresenter).getSchoolCalendar();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
