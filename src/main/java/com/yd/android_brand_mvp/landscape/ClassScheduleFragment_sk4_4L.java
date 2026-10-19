package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.ClassScheduleActivity;
import com.yd.android_brand_mvp.activity.KBActivity;
import com.yd.android_brand_mvp.adapter.MyTableAdapter1_sk;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.model.UserTableRsp;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.presenter.UserCenterPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TeacherNameUtils;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import com.yd.android_brand_mvp.view.UserTableView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleFragment_sk4_4L extends BaseMvpFragment<UserCenterPresenter> implements UserTableView {
    weekAdapter adapter;
    MyTableAdapter1_sk dutyAdapter;

    @BindView(R.id.grid_rl)
    GridView gridRl;
    private MyHandler handler;

    @BindView(R.id.list_table)
    GridView listTable;
    private List<List<TableRsp>> lists;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tv_week)
    TextView tv_week;
    private final String TAG = ClassScheduleFragment_sk4_4L.class.getSimpleName();
    String[] week7 = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    String[] week6 = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    String[] week5 = {"星期一", "星期二", "星期三", "星期四", "星期五"};
    int weekCount = 0;
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$ClassScheduleFragment_sk4_4L$kVAS9wowMUMpBIST5xhvc7WRd4I
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0$ClassScheduleFragment_sk4_4L();
        }
    };
    int checkTab = -1;

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void GetAskLeaveRecordBandRsp(GetAskLeaveRecordBandRsp getAskLeaveRecordBandRsp) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void GetAskLeaveRecordBandRspFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getUserSigByUserId(getUserSigByUserIdRsp getusersigbyuseridrsp) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getUserSigByUserIdFail(String str) {
    }

    private static class MyHandler extends Handler {
        private WeakReference<ClassScheduleFragment_sk4_4L> mWeakReference;

        public MyHandler(ClassScheduleFragment_sk4_4L classScheduleFragment_sk4_4L) {
            this.mWeakReference = new WeakReference<>(classScheduleFragment_sk4_4L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 200 || this.mWeakReference.get() == null || this.mWeakReference.get().handler == null) {
                return;
            }
            this.mWeakReference.get().handler.postDelayed(this.mWeakReference.get().runnable, 30000L);
            KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
            if (kBRsp2 != null) {
                this.mWeakReference.get().setData(kBRsp2);
            }
        }
    }

    public /* synthetic */ void lambda$new$0$ClassScheduleFragment_sk4_4L() {
        Message message = new Message();
        message.what = 200;
        this.handler.sendMessage(message);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule_sk4_4l, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.handler = new MyHandler(this);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.title.setText(R.string.class_schedule);
        MyTableAdapter1_sk myTableAdapter1_sk = new MyTableAdapter1_sk(this.mActivity, TimeUtil.getIntWeek(System.currentTimeMillis()));
        this.dutyAdapter = myTableAdapter1_sk;
        this.listTable.setAdapter((ListAdapter) myTableAdapter1_sk);
        if (!TextUtils.isEmpty(SpData.getClassesId())) {
            ((UserCenterPresenter) this.mvpPresenter).getClassKB(SpData.getClassesId(), -1, "1");
        }
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$ClassScheduleFragment_sk4_4L$Ug4dbrw1tKdmZYTEFDDv3spgL6Q
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public final void reload() {
                this.f$0.lambda$onViewCreated$1$ClassScheduleFragment_sk4_4L();
            }
        });
        Hawk.init(this.mActivity).build();
        getCache();
    }

    public /* synthetic */ void lambda$onViewCreated$1$ClassScheduleFragment_sk4_4L() {
        if (TextUtils.isEmpty(SpData.getClassesId())) {
            return;
        }
        ((UserCenterPresenter) this.mvpPresenter).getClassKB(SpData.getClassesId(), -1, "1");
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if ((i == MinaConstants.Table || i == MinaConstants.SEMESTER) && !TextUtils.isEmpty(SpData.getClassesId())) {
            ((UserCenterPresenter) this.mvpPresenter).getClassKB(SpData.getClassesId(), -1, "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public UserCenterPresenter createPresenter() {
        return new UserCenterPresenter(this);
    }

    @OnClick({R.id.title})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.title) {
            if (BaseConstant.KB) {
                goPermissionsActivity(ClassScheduleActivity.class);
            } else {
                goPermissionsActivity(KBActivity.class);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.handler.removeCallbacks(this.runnable);
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableData(UserTableRsp userTableRsp) {
        Log.e(this.TAG, "UserTableData: " + JSON.toJSONString(userTableRsp));
    }

    private void getCache() {
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        } else {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableDataFail(String str) {
        getCache();
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getCDKBData(KBRsp2 kBRsp2) {
        if (kBRsp2.code.intValue() == 0) {
            this.checkTab = -1;
            setData(kBRsp2);
            Hawk.delete(BaseHawk.NEWCLASSKB);
            Hawk.put(BaseHawk.NEWCLASSKB, kBRsp2);
            if (kBRsp2.data.timetableList.size() == 0) {
                Hawk.delete(BaseHawk.NEWCLASSKB);
                this.mu.setViewState(2);
            }
            this.gridRl.setVisibility(0);
            return;
        }
        this.mu.setViewState(2);
        this.handler.removeCallbacks(this.runnable);
        List<List<TableRsp>> list = this.lists;
        if (list != null) {
            list.clear();
        }
        this.tv_week.setVisibility(8);
        this.gridRl.setVisibility(8);
    }

    void getWeek(KBRsp2 kBRsp2) {
        this.weekCount = 0;
        if (kBRsp2 != null && kBRsp2.data != null && kBRsp2.data.timetableList != null) {
            for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : kBRsp2.data.timetableList) {
                if (timetableListDTO.week == 5 && !StringUtils.isEmpty(timetableListDTO.subjectName) && this.weekCount < timetableListDTO.week) {
                    this.weekCount = 5;
                }
                if (timetableListDTO.week == 6 && !StringUtils.isEmpty(timetableListDTO.subjectName) && this.weekCount < timetableListDTO.week) {
                    this.weekCount = 6;
                }
                if (timetableListDTO.week == 7 && !StringUtils.isEmpty(timetableListDTO.subjectName)) {
                    if (this.weekCount < timetableListDTO.week) {
                        this.weekCount = 7;
                        return;
                    }
                    return;
                }
            }
        }
        if (this.weekCount == 0) {
            this.weekCount = 5;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:48:0x00f4  */
    void setData(KBRsp2 kBRsp2) {
        if (kBRsp2 == null || kBRsp2.data == null) {
            return;
        }
        getWeek(kBRsp2);
        String strValueOf = String.valueOf(kBRsp2.data.thisWeek);
        this.handler.removeCallbacks(this.runnable);
        this.handler.postDelayed(this.runnable, 30000L);
        this.tv_week.setVisibility((TextUtils.isEmpty(strValueOf) || "null".equals(strValueOf)) ? 8 : 0);
        this.tv_week.setText("当前周次：第" + kBRsp2.data.thisWeek + "周");
        this.lists = new ArrayList();
        for (int i = 1; i <= 7; i++) {
            ArrayList arrayList = new ArrayList();
            for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : kBRsp2.data.timetableList) {
                if (timetableListDTO.week == i && timetableListDTO.subjectName != null) {
                    arrayList.add(getTableRsp(timetableListDTO));
                }
            }
            this.lists.add(arrayList);
        }
        int i2 = 6;
        switch (TimeUtils.getChineseWeek(new Date())) {
            case "周一":
                i2 = 1;
                break;
            case "周二":
                i2 = 2;
                break;
            case "周三":
                i2 = 3;
                break;
            case "周四":
                i2 = 4;
                break;
            case "周五":
                i2 = 5;
                break;
            case "周六":
                break;
            case "周日":
                i2 = 7;
                break;
            default:
                i2 = -1;
                break;
        }
        List<List<TableRsp>> list = this.lists;
        if (list == null || list.size() == 0) {
            this.mu.setViewState(2);
            return;
        }
        int i3 = this.checkTab;
        if (i3 != -1) {
            this.dutyAdapter.notifyData(this.lists.get(i3));
        } else {
            if (i2 > this.lists.size()) {
                this.dutyAdapter.notifyData(this.lists.get(0));
                this.mu.setViewState(this.lists.get(0).size() <= 0 ? 2 : 0);
            } else {
                int i4 = i2 == 7 ? 0 : i2 + 1;
                int i5 = i2 - 1;
                this.dutyAdapter.notifyData(this.lists.get(i5), i4);
                this.mu.setViewState(this.lists.get(i5).size() <= 0 ? 2 : 0);
            }
            this.gridRl.setNumColumns(this.lists.size());
            weekAdapter weekadapter = new weekAdapter();
            this.adapter = weekadapter;
            this.gridRl.setAdapter((ListAdapter) weekadapter);
            this.gridRl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassScheduleFragment_sk4_4L.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j) {
                    ClassScheduleFragment_sk4_4L.this.adapter.setPosition(i6);
                    ClassScheduleFragment_sk4_4L.this.checkTab = i6;
                    if (ClassScheduleFragment_sk4_4L.this.lists != null && ClassScheduleFragment_sk4_4L.this.lists.size() > 0) {
                        ClassScheduleFragment_sk4_4L.this.dutyAdapter.notifyData((List) ClassScheduleFragment_sk4_4L.this.lists.get(i6), i6 == 6 ? 0 : i6 + 2);
                    }
                    if (ClassScheduleFragment_sk4_4L.this.lists == null || ClassScheduleFragment_sk4_4L.this.lists.size() == 0 || ClassScheduleFragment_sk4_4L.this.lists.size() < i6 || ((List) ClassScheduleFragment_sk4_4L.this.lists.get(i6)).size() == 0) {
                        ClassScheduleFragment_sk4_4L.this.mu.setViewState(2);
                    } else {
                        ClassScheduleFragment_sk4_4L.this.mu.setViewState(0);
                    }
                    ClassScheduleFragment_sk4_4L.this.adapter.notifyDataSetChanged();
                }
            });
        }
        this.listTable.setSelection(this.dutyAdapter.list.size() - 1);
        Log.e(this.TAG, "setData: smoothScrollToPosition" + JSON.toJSONString(Integer.valueOf(this.dutyAdapter.list.size() - 1)));
        this.handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.ClassScheduleFragment_sk4_4L.2
            @Override // java.lang.Runnable
            public void run() {
                ClassScheduleFragment_sk4_4L.this.listTable.setSelection(ClassScheduleFragment_sk4_4L.this.dutyAdapter.getNextIndex());
            }
        }, 1000L);
    }

    public TableRsp getTableRsp(KBRsp2.DataDTO.TimetableListDTO timetableListDTO) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = timetableListDTO.subjectName;
        if (timetableListDTO.teacherList != null && timetableListDTO.teacherList.size() > 0) {
            tableRsp.teacherName = TeacherNameUtils.INSTANCE.getTeacherNameByList(timetableListDTO.teacherList);
        }
        tableRsp.seletion = timetableListDTO.section;
        tableRsp.startTime = timetableListDTO.startTime;
        tableRsp.endTime = timetableListDTO.endTime;
        tableRsp.week = timetableListDTO.week;
        tableRsp.sectionName = timetableListDTO.sectionName;
        tableRsp.timeFrame = timetableListDTO.sectionType;
        return tableRsp;
    }

    private class weekAdapter extends BaseAdapter {
        public int i;
        String[] week;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private weekAdapter() {
            this.week = getWeek();
            this.i = -1;
        }

        private String[] getWeek() {
            ClassScheduleFragment_sk4_4L.this.gridRl.setNumColumns(ClassScheduleFragment_sk4_4L.this.weekCount);
            int i = ClassScheduleFragment_sk4_4L.this.weekCount;
            if (i == 5) {
                return ClassScheduleFragment_sk4_4L.this.week5;
            }
            if (i == 6) {
                return ClassScheduleFragment_sk4_4L.this.week6;
            }
            if (i == 7) {
                return ClassScheduleFragment_sk4_4L.this.week7;
            }
            return ClassScheduleFragment_sk4_4L.this.week7;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.week.length;
        }

        @Override // android.widget.Adapter
        public String getItem(int i) {
            return this.week[i];
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_week_item_sk5_l, (ViewGroup) null);
            }
            CheckedTextView checkedTextView = (CheckedTextView) VHUtil.ViewHolder.get(view, R.id.weekItem);
            LinearLayout linearLayout = (LinearLayout) VHUtil.ViewHolder.get(view, R.id.ll);
            checkedTextView.setText(getItem(i));
            checkedTextView.setChecked(TextUtils.equals(getItem(i), TimeUtil.getWeek(new Date())));
            if (TextUtils.equals(getItem(i), TimeUtil.getWeek(new Date()))) {
                linearLayout.setBackgroundResource(R.drawable.bg_purple20_sk);
            } else {
                linearLayout.setBackgroundResource(R.drawable.table_item_bg9l_sk);
            }
            if (ClassScheduleFragment_sk4_4L.this.checkTab >= 0) {
                if (ClassScheduleFragment_sk4_4L.this.checkTab == i) {
                    linearLayout.setBackgroundResource(R.drawable.bg_purple20_sk);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.table_item_bg9l_sk);
                }
            }
            int i2 = this.i;
            if (i2 != -1) {
                checkedTextView.setChecked(i2 == i);
            }
            return view;
        }

        public void setPosition(int i) {
            this.i = i;
            notifyDataSetChanged();
        }
    }
}
