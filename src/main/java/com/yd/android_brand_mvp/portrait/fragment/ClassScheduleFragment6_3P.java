package com.yd.android_brand_mvp.portrait.fragment;

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
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.ClassScheduleActivity;
import com.yd.android_brand_mvp.activity.KBActivity;
import com.yd.android_brand_mvp.adapter.MyTableAdapter1;
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
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import com.yd.android_brand_mvp.view.UserTableView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleFragment6_3P extends BaseMvpFragment<UserCenterPresenter> implements UserTableView {
    weekAdapter adapter;
    MyTableAdapter1 dutyAdapter;

    @BindView(R.id.grid_rl)
    GridView gridRl;
    private MyHandler handler;

    @BindView(R.id.list_table)
    GridView listTable;
    private List<List<TableRsp>> lists;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.nodata)
    TextView nodata;
    String tab;

    @BindView(R.id.table_view)
    FrameLayout tableView;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tv_week)
    TextView tv_week;
    private final String TAG = "ClassSchedule6_3L";
    private final String sqlTab = "tableRspDao";
    String studentId = "abd5ed5e7001458c88de5d52f9825e54";
    int officeId = 16955;
    String[] week7 = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    String[] week6 = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    String[] week5 = {"星期一", "星期二", "星期三", "星期四", "星期五"};
    int weekCount = 0;
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P.2
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 200;
            ClassScheduleFragment6_3P.this.handler.sendMessage(message);
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
    public void getCDKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getUserSigByUserId(getUserSigByUserIdRsp getusersigbyuseridrsp) {
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getUserSigByUserIdFail(String str) {
    }

    private static class MyHandler extends Handler {
        private WeakReference<ClassScheduleFragment6_3P> mWeakReference;

        public MyHandler(ClassScheduleFragment6_3P classScheduleFragment6_3P) {
            this.mWeakReference = new WeakReference<>(classScheduleFragment6_3P);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 200 || this.mWeakReference.get() == null || this.mWeakReference.get().handler == null) {
                return;
            }
            this.mWeakReference.get().handler.postDelayed(this.mWeakReference.get().runnable, 60000L);
            UserTableRsp userTableRsp = (UserTableRsp) Hawk.get("tableRspDao");
            if (userTableRsp != null) {
                this.mWeakReference.get().setData(userTableRsp);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule6_3p, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.handler = new MyHandler(this);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.title.setText(R.string.class_schedule);
        MyTableAdapter1 myTableAdapter1 = new MyTableAdapter1(this.mActivity, TimeUtil.getIntWeek(System.currentTimeMillis()), this.tab);
        this.dutyAdapter = myTableAdapter1;
        this.listTable.setAdapter((ListAdapter) myTableAdapter1);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((UserCenterPresenter) ClassScheduleFragment6_3P.this.mvpPresenter).UserTable(SpData.getClassesId(), -1);
            }
        });
        Hawk.init(this.mActivity).build();
        setData((UserTableRsp) Hawk.get("tableRspDao"));
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Table || i == MinaConstants.SEMESTER) {
            ((UserCenterPresenter) this.mvpPresenter).UserTable(SpData.getClassesId(), -1);
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
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((UserCenterPresenter) this.mvpPresenter).UserTable(SpData.getClassesId(), -1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.runnable);
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableData(UserTableRsp userTableRsp) {
        Log.e("ClassSchedule6_3L", "UserTableData: " + JSON.toJSONString(userTableRsp));
        if (userTableRsp.code.intValue() == BaseConstant.REQUEST_SUCCES2) {
            SPUtils.getInstance().put(SpData.Table, JSON.toJSONString(userTableRsp));
            this.checkTab = -1;
            setData(userTableRsp);
            Hawk.delete("tableRspDao");
            Hawk.put("tableRspDao", userTableRsp);
            this.handler.postDelayed(this.runnable, 30000L);
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

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableDataFail(String str) {
        UserTableRsp userTableRsp = (UserTableRsp) Hawk.get(BaseHawk.TABLE1);
        if (userTableRsp != null) {
            setData(userTableRsp);
        } else {
            this.mu.setViewState(2);
        }
    }

    void setKb(UserTableRsp userTableRsp) {
        this.checkTab = -1;
        setData(userTableRsp);
        Hawk.delete("tableRspDao");
        Hawk.put("tableRspDao", userTableRsp);
        this.handler.postDelayed(this.runnable, 30000L);
        this.gridRl.setVisibility(0);
    }

    public void addNullDay(int i) {
        for (int i2 = 1; i2 < i; i2++) {
            this.lists.add(new ArrayList());
        }
    }

    void getWeek(UserTableRsp userTableRsp) {
        this.weekCount = 0;
        if (userTableRsp.data != null) {
            for (UserTableRsp.DataDTO.SubListDTO subListDTO : userTableRsp.data.subList) {
                if (subListDTO.weekTime == 5 && !StringUtils.isEmpty(subListDTO.subjectName) && this.weekCount < subListDTO.weekTime) {
                    this.weekCount = 5;
                }
                if (subListDTO.weekTime == 6 && !StringUtils.isEmpty(subListDTO.subjectName) && this.weekCount < subListDTO.weekTime) {
                    this.weekCount = 6;
                }
                if (subListDTO.weekTime == 7 && !StringUtils.isEmpty(subListDTO.subjectName)) {
                    if (this.weekCount < subListDTO.weekTime) {
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
    /* JADX WARN: Code duplicated, block: B:50:0x011d  */
    void setData(UserTableRsp userTableRsp) {
        if (userTableRsp == null || userTableRsp.data == null) {
            return;
        }
        getWeek(userTableRsp);
        this.tv_week.setVisibility(StringUtils.isEmpty(userTableRsp.data.weekCount) ? 8 : 0);
        this.tv_week.setText("当前周次：第" + userTableRsp.data.weekCount + "周");
        this.dutyAdapter.setWeekCount(userTableRsp.data.weekCount, userTableRsp.data.timetableType);
        this.lists = new ArrayList();
        for (int i = 1; i <= 7; i++) {
            ArrayList arrayList = new ArrayList();
            for (UserTableRsp.DataDTO.SubListDTO subListDTO : userTableRsp.data.subList) {
                if (subListDTO.weekTime == i && subListDTO.subjectName != null) {
                    arrayList.add(getTableRsp(subListDTO));
                }
            }
            this.lists.add(arrayList);
        }
        Iterator<List<TableRsp>> it2 = this.lists.iterator();
        while (it2.hasNext()) {
            Log.e("wick", JSON.toJSONString(it2.next()));
        }
        Log.e("TAG", "" + this.lists.size());
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
            this.adapter = new weekAdapter();
            this.lists.size();
            this.gridRl.setAdapter((ListAdapter) this.adapter);
            this.gridRl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P.3
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j) {
                    ClassScheduleFragment6_3P.this.adapter.setPostion(i6);
                    ClassScheduleFragment6_3P.this.checkTab = i6;
                    if (ClassScheduleFragment6_3P.this.lists != null && ClassScheduleFragment6_3P.this.lists.size() > 0) {
                        ClassScheduleFragment6_3P.this.dutyAdapter.notifyData((List) ClassScheduleFragment6_3P.this.lists.get(i6), i6 == 6 ? 0 : i6 + 2);
                    }
                    if (ClassScheduleFragment6_3P.this.lists == null || ClassScheduleFragment6_3P.this.lists.size() == 0 || ClassScheduleFragment6_3P.this.lists.size() < i6 || ((List) ClassScheduleFragment6_3P.this.lists.get(i6)).size() == 0) {
                        ClassScheduleFragment6_3P.this.mu.setViewState(2);
                    } else {
                        ClassScheduleFragment6_3P.this.mu.setViewState(0);
                    }
                    ClassScheduleFragment6_3P.this.adapter.notifyDataSetChanged();
                }
            });
        }
        this.listTable.setSelection(this.dutyAdapter.list.size() - 1);
        Log.e("ClassSchedule6_3L", "setData: smoothScrollToPosition" + JSON.toJSONString(Integer.valueOf(this.dutyAdapter.list.size() - 1)));
        this.handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P.4
            @Override // java.lang.Runnable
            public void run() {
                ClassScheduleFragment6_3P.this.listTable.setSelection(ClassScheduleFragment6_3P.this.dutyAdapter.getNextIndex());
            }
        }, 1000L);
    }

    public TableRsp getTableRsp(UserTableRsp.DataDTO.SubListDTO subListDTO) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = subListDTO.subjectName;
        tableRsp.teacherName = subListDTO.classesTeacher;
        tableRsp.seletion = Integer.valueOf(subListDTO.section).intValue();
        tableRsp.startTime = subListDTO.fromDateTime;
        tableRsp.sectionName = subListDTO.sectionName;
        tableRsp.endTime = subListDTO.toDateTime;
        tableRsp.week = subListDTO.weekTime;
        tableRsp.otherSubjectName = subListDTO.otherSubjectName;
        tableRsp.otherClassesTeacher = subListDTO.otherClassesTeacher;
        tableRsp.week = subListDTO.weekTime;
        tableRsp.timeFrame = subListDTO.timeFrame;
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
            ClassScheduleFragment6_3P.this.gridRl.setNumColumns(ClassScheduleFragment6_3P.this.weekCount);
            int i = ClassScheduleFragment6_3P.this.weekCount;
            if (i == 5) {
                return ClassScheduleFragment6_3P.this.week5;
            }
            if (i == 6) {
                return ClassScheduleFragment6_3P.this.week6;
            }
            if (i == 7) {
                return ClassScheduleFragment6_3P.this.week7;
            }
            return ClassScheduleFragment6_3P.this.week7;
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
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_week_item5_l, (ViewGroup) null);
            }
            CheckedTextView checkedTextView = (CheckedTextView) VHUtil.ViewHolder.get(view, R.id.weekItem);
            LinearLayout linearLayout = (LinearLayout) VHUtil.ViewHolder.get(view, R.id.ll);
            ImageView imageView = (ImageView) VHUtil.ViewHolder.get(view, R.id.iv_day);
            checkedTextView.setText(getItem(i));
            checkedTextView.setChecked(TextUtils.equals(getItem(i), TimeUtil.getWeek(new Date())));
            if (TextUtils.equals(getItem(i), TimeUtil.getWeek(new Date()))) {
                linearLayout.setBackgroundResource(R.drawable.bg_purple20);
            } else {
                linearLayout.setBackgroundResource(R.drawable.table_item_bg9l);
            }
            if (ClassScheduleFragment6_3P.this.checkTab >= 0) {
                if (ClassScheduleFragment6_3P.this.checkTab == i) {
                    linearLayout.setBackgroundResource(R.drawable.bg_purple20);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.table_item_bg9l);
                }
            }
            if (ClassScheduleFragment6_3P.this.checkTab != i) {
                imageView.setVisibility(TextUtils.equals(getItem(i), TimeUtil.getWeek(new Date())) ? 0 : 8);
                if (ClassScheduleFragment6_3P.this.checkTab == -1) {
                    imageView.setVisibility(8);
                }
            } else {
                imageView.setVisibility(8);
            }
            int i2 = this.i;
            if (i2 != -1) {
                if (i2 == i) {
                    checkedTextView.setChecked(true);
                } else {
                    checkedTextView.setChecked(false);
                }
            }
            return view;
        }

        public void setPostion(int i) {
            this.i = i;
            notifyDataSetChanged();
        }
    }
}
