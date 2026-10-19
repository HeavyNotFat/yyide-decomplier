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
import com.yd.android_brand_mvp.model.KBRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.presenter.KBPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TeacherNameUtils;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import com.yd.android_brand_mvp.view.KBView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleFragment6_3P2 extends BaseMvpFragment<KBPresenter> implements KBView {
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
    private final String TAG = ClassScheduleFragment6_3P2.class.getSimpleName();
    String[] week7 = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    String[] week6 = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    String[] week5 = {"星期一", "星期二", "星期三", "星期四", "星期五"};
    int weekCount = 0;
    private final Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P2.2
        @Override // java.lang.Runnable
        public void run() {
            Log.i(ClassScheduleFragment6_3P2.this.TAG, "runnable: 刷新数据");
            Message message = new Message();
            message.what = 200;
            ClassScheduleFragment6_3P2.this.handler.sendMessage(message);
        }
    };
    int checkTab = -1;

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getCDKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getKBData(KBRsp kBRsp) {
    }

    private static class MyHandler extends Handler {
        private WeakReference<ClassScheduleFragment6_3P2> mWeakReference;

        public MyHandler(ClassScheduleFragment6_3P2 classScheduleFragment6_3P2) {
            this.mWeakReference = new WeakReference<>(classScheduleFragment6_3P2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 200) {
                this.mWeakReference.get().handler.postDelayed(this.mWeakReference.get().runnable, 30000L);
                Log.i(this.mWeakReference.get().TAG, "handleMessage: 刷新数据");
                if (this.mWeakReference.get().dutyAdapter != null) {
                    this.mWeakReference.get().dutyAdapter.notifyDataSetChanged();
                    this.mWeakReference.get().scrollToHighlightPosition();
                }
            }
        }
    }

    public ClassScheduleFragment6_3P2(String str) {
        this.tab = str;
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
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P2.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                if (TextUtils.isEmpty(SpData.getClassesId())) {
                    return;
                }
                ((KBPresenter) ClassScheduleFragment6_3P2.this.mvpPresenter).getKB(SpData.getClassesId(), -1);
            }
        });
        this.mu.setViewState(2);
        if (!TextUtils.isEmpty(SpData.getClassesId())) {
            ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId(), -1);
        }
        Hawk.init(this.mActivity).build();
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Table || i == MinaConstants.SEMESTER) {
            Hawk.delete(BaseHawk.NEWCLASSKB);
            if (TextUtils.isEmpty(SpData.getClassesId())) {
                return;
            }
            ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId(), -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public KBPresenter createPresenter() {
        return new KBPresenter(this);
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

    @Override // com.yd.android_brand_mvp.view.KBView
    public void KBDataFail(String str) {
        this.mu.setViewState(2);
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getClassKBData(KBRsp2 kBRsp2) {
        if (kBRsp2.code.intValue() == 0) {
            SPUtils.getInstance().put(SpData.Table, JSON.toJSONString(kBRsp2));
            this.checkTab = -1;
            this.gridRl.setVisibility(0);
            setData(kBRsp2);
            Hawk.delete(BaseHawk.NEWCLASSKB);
            Hawk.put(BaseHawk.NEWCLASSKB, kBRsp2);
            if (kBRsp2.data == null || kBRsp2.data.timetableList == null || kBRsp2.data.timetableList.isEmpty()) {
                Hawk.delete(BaseHawk.NEWCLASSKB);
                this.mu.setViewState(2);
                return;
            }
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
        if (kBRsp2.data != null) {
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
    /* JADX WARN: Code duplicated, block: B:51:0x011e  */
    private void setData(KBRsp2 kBRsp2) {
        Log.i(this.TAG, "setData(KBRsp2 rsp)");
        if (kBRsp2 == null || kBRsp2.data == null) {
            return;
        }
        this.mu.setViewState(0);
        getWeek(kBRsp2);
        this.tv_week.setVisibility(StringUtils.isEmpty(String.valueOf(kBRsp2.data.thisWeek)) ? 8 : 0);
        this.tv_week.setText("当前周次：第" + kBRsp2.data.thisWeek + "周");
        if (!TextUtils.isEmpty(kBRsp2.data.siteClassesName)) {
            this.title.setText(String.format("%s (%s)", getString(R.string.class_schedule), kBRsp2.data.siteClassesName));
        } else {
            this.title.setText(getString(R.string.class_schedule));
        }
        this.lists = new ArrayList();
        for (int i = 1; i <= 7; i++) {
            ArrayList arrayList = new ArrayList();
            if (kBRsp2.data.timetableList != null) {
                for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : listSorting(kBRsp2.data.timetableList)) {
                    if (timetableListDTO.week == i) {
                        arrayList.add(getTableRsp(timetableListDTO));
                    }
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
        if (list == null || list.isEmpty()) {
            this.mu.setViewState(2);
            return;
        }
        int i3 = this.checkTab;
        if (i3 != -1) {
            this.dutyAdapter.notifyData(this.lists.get(i3));
        } else {
            if (i2 > this.lists.size()) {
                this.dutyAdapter.notifyData(this.lists.get(0));
                this.mu.setViewState(this.lists.get(0).isEmpty() ? 2 : 0);
            } else {
                int i4 = i2 == 7 ? 0 : i2 + 1;
                int i5 = i2 - 1;
                this.dutyAdapter.notifyData(this.lists.get(i5), i4);
                this.mu.setViewState(this.lists.get(i5).isEmpty() ? 2 : 0);
            }
            this.gridRl.setNumColumns(this.lists.size());
            weekAdapter weekadapter = new weekAdapter();
            this.adapter = weekadapter;
            this.gridRl.setAdapter((ListAdapter) weekadapter);
            this.gridRl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P2.3
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j) {
                    ClassScheduleFragment6_3P2.this.adapter.setPostion(i6);
                    ClassScheduleFragment6_3P2.this.checkTab = i6;
                    if (ClassScheduleFragment6_3P2.this.lists != null && !ClassScheduleFragment6_3P2.this.lists.isEmpty()) {
                        ClassScheduleFragment6_3P2.this.dutyAdapter.notifyData((List) ClassScheduleFragment6_3P2.this.lists.get(i6), i6 == 6 ? 0 : i6 + 2);
                    }
                    if (ClassScheduleFragment6_3P2.this.lists == null || ClassScheduleFragment6_3P2.this.lists.isEmpty() || ClassScheduleFragment6_3P2.this.lists.size() < i6 || ((List) ClassScheduleFragment6_3P2.this.lists.get(i6)).isEmpty()) {
                        ClassScheduleFragment6_3P2.this.mu.setViewState(2);
                    } else {
                        ClassScheduleFragment6_3P2.this.mu.setViewState(0);
                    }
                    ClassScheduleFragment6_3P2.this.adapter.notifyDataSetChanged();
                }
            });
        }
        scrollToHighlightPosition();
        this.handler.removeCallbacks(this.runnable);
        this.handler.postDelayed(this.runnable, 30000L);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MyHandler myHandler = this.handler;
        if (myHandler != null) {
            myHandler.removeCallbacks(this.runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToHighlightPosition() {
        final int iFindHighlightPosition;
        MyTableAdapter1 myTableAdapter1 = this.dutyAdapter;
        if (myTableAdapter1 == null || myTableAdapter1.list == null || this.dutyAdapter.list.isEmpty() || this.listTable == null || (iFindHighlightPosition = findHighlightPosition()) < 0) {
            return;
        }
        Log.i(this.TAG, "滚动到高亮位置: " + iFindHighlightPosition);
        this.listTable.post(new Runnable() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$ClassScheduleFragment6_3P2$MXJImdd4XxDq8Ip37eCRiZqleMQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scrollToHighlightPosition$0$ClassScheduleFragment6_3P2(iFindHighlightPosition);
            }
        });
    }

    public /* synthetic */ void lambda$scrollToHighlightPosition$0$ClassScheduleFragment6_3P2(int i) {
        this.listTable.setSelection(i);
    }

    private int findHighlightPosition() {
        MyTableAdapter1 myTableAdapter1 = this.dutyAdapter;
        if (myTableAdapter1 == null || myTableAdapter1.list == null || this.dutyAdapter.list.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.dutyAdapter.list.size(); i++) {
            TableRsp tableRsp = this.dutyAdapter.list.get(i);
            if (!TextUtils.isEmpty(tableRsp.startTime) && !TextUtils.isEmpty(tableRsp.endTime)) {
                try {
                    if (TimeUtil.isBelong(tableRsp.startTime, tableRsp.endTime)) {
                        return i;
                    }
                } catch (Exception e) {
                    Log.e(this.TAG, "解析时间异常: " + e.getMessage());
                }
            }
        }
        return findNextClassPosition();
    }

    private int findNextClassPosition() {
        Exception e;
        long j;
        MyTableAdapter1 myTableAdapter1 = this.dutyAdapter;
        if (myTableAdapter1 != null && myTableAdapter1.list != null && !this.dutyAdapter.list.isEmpty()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = Long.MAX_VALUE;
            for (int i = 0; i < this.dutyAdapter.list.size(); i++) {
                TableRsp tableRsp = this.dutyAdapter.list.get(i);
                if (!TextUtils.isEmpty(tableRsp.startTime)) {
                    try {
                        j = TimeUtil.gettime(tableRsp.startTime, TimeUtil.hoursMinuteTimeFormat) - jCurrentTimeMillis;
                        if (j > 0 && j < j2) {
                            try {
                                Log.i(this.TAG, "findNextClassPosition = " + i);
                                return i;
                            } catch (Exception e2) {
                                e = e2;
                                Log.e(this.TAG, "解析时间异常: " + e.getMessage());
                                j2 = j;
                            }
                        }
                    } catch (Exception e3) {
                        long j3 = j2;
                        e = e3;
                        j = j3;
                    }
                }
            }
        }
        return -1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Runnable runnable;
        super.onResume();
        MyHandler myHandler = this.handler;
        if (myHandler == null || (runnable = this.runnable) == null) {
            return;
        }
        myHandler.postDelayed(runnable, 1000L);
    }

    public TableRsp getTableRsp(KBRsp2.DataDTO.TimetableListDTO timetableListDTO) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = timetableListDTO.subjectName;
        if (timetableListDTO.teacherList != null && !timetableListDTO.teacherList.isEmpty()) {
            tableRsp.teacherName = TeacherNameUtils.INSTANCE.getTeacherNameByList(timetableListDTO.teacherList);
        }
        tableRsp.courseType = timetableListDTO.courseType;
        tableRsp.sectionName = timetableListDTO.sectionName;
        tableRsp.startTime = timetableListDTO.startTime;
        tableRsp.endTime = timetableListDTO.endTime;
        tableRsp.week = timetableListDTO.week;
        tableRsp.seletion = timetableListDTO.section;
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
            ClassScheduleFragment6_3P2.this.gridRl.setNumColumns(ClassScheduleFragment6_3P2.this.weekCount);
            int i = ClassScheduleFragment6_3P2.this.weekCount;
            if (i == 5) {
                return ClassScheduleFragment6_3P2.this.week5;
            }
            if (i == 6) {
                return ClassScheduleFragment6_3P2.this.week6;
            }
            if (i == 7) {
                return ClassScheduleFragment6_3P2.this.week7;
            }
            return ClassScheduleFragment6_3P2.this.week7;
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
            if (ClassScheduleFragment6_3P2.this.checkTab >= 0) {
                if (ClassScheduleFragment6_3P2.this.checkTab == i) {
                    linearLayout.setBackgroundResource(R.drawable.bg_purple20);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.table_item_bg9l);
                }
            }
            if (ClassScheduleFragment6_3P2.this.checkTab != i) {
                imageView.setVisibility(TextUtils.equals(getItem(i), TimeUtil.getWeek(new Date())) ? 0 : 8);
                if (ClassScheduleFragment6_3P2.this.checkTab == -1) {
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

    public static List<KBRsp2.DataDTO.TimetableListDTO> listSorting(List<KBRsp2.DataDTO.TimetableListDTO> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new Comparator<KBRsp2.DataDTO.TimetableListDTO>() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P2.4
                @Override // java.util.Comparator
                public int compare(KBRsp2.DataDTO.TimetableListDTO timetableListDTO, KBRsp2.DataDTO.TimetableListDTO timetableListDTO2) {
                    return String.valueOf(timetableListDTO.sectionTypeNum).compareTo(String.valueOf(timetableListDTO2.sectionTypeNum));
                }
            });
        }
        return list;
    }
}
