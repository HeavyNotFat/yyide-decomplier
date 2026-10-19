package com.yd.android_brand_mvp.landscape;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
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
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import com.yd.android_brand_mvp.view.KBView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragment4_2P extends BaseMvpFragment<KBPresenter> implements KBView {
    private static final long HIGHLIGHT_UPDATE_INTERVAL = 30000;
    weekAdapter adapter;
    MyTableAdapter1 dutyAdapter;

    @BindView(R.id.grid_rl)
    GridView gridRl;
    private Runnable highlightRunnable;

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
    private final String TAG = "ClassSchedule4_4L";
    String[] week7 = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    int checkTab = -1;
    int weekCount = 0;
    private Handler handler = new Handler();
    private boolean hasScrolledToHighlight = false;

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getCDKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getKBData(KBRsp kBRsp) {
    }

    public KBFragment4_2P() {
    }

    public KBFragment4_2P(String str) {
        this.tab = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule4_2p, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.gridRl.setVisibility(8);
        MyTableAdapter1 myTableAdapter1 = new MyTableAdapter1(this.mActivity, TimeUtil.getIntWeek(System.currentTimeMillis()), this.tab);
        this.dutyAdapter = myTableAdapter1;
        this.listTable.setAdapter((ListAdapter) myTableAdapter1);
        this.title.setText("班级课表");
        ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$KBFragment4_2P$3TK-H4qeNMey8t8UMDm5xZDfL5E
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public final void reload() {
                this.f$0.lambda$onViewCreated$0$KBFragment4_2P();
            }
        });
        setData((KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB));
        initHighlightRefresh();
    }

    public /* synthetic */ void lambda$onViewCreated$0$KBFragment4_2P() {
        ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
    }

    private void initHighlightRefresh() {
        this.highlightRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.KBFragment4_2P.1
            @Override // java.lang.Runnable
            public void run() {
                Log.i("ClassSchedule4_4L", "highlightRunnable run: ");
                if (KBFragment4_2P.this.dutyAdapter != null) {
                    KBFragment4_2P.this.dutyAdapter.notifyDataSetChanged();
                    KBFragment4_2P.this.scrollToHighlightPosition();
                }
                KBFragment4_2P.this.handler.postDelayed(this, 30000L);
            }
        };
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Table || i == MinaConstants.SEMESTER) {
            ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
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

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Runnable runnable;
        super.onDestroyView();
        Handler handler = this.handler;
        if (handler == null || (runnable = this.highlightRunnable) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToHighlightPosition() {
        final int iFindHighlightPosition;
        MyTableAdapter1 myTableAdapter1 = this.dutyAdapter;
        if (myTableAdapter1 == null || myTableAdapter1.list == null || this.dutyAdapter.list.size() <= 0 || this.listTable == null || (iFindHighlightPosition = findHighlightPosition()) < 0) {
            return;
        }
        Log.i("ClassSchedule4_4L", "滚动到高亮位置: " + iFindHighlightPosition);
        this.listTable.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$KBFragment4_2P$2fvHZQvOxBLMEKVq_XdFlpojMow
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scrollToHighlightPosition$1$KBFragment4_2P(iFindHighlightPosition);
            }
        });
    }

    public /* synthetic */ void lambda$scrollToHighlightPosition$1$KBFragment4_2P(int i) {
        this.listTable.smoothScrollToPosition(i);
        this.hasScrolledToHighlight = true;
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
                    Log.e("ClassSchedule4_4L", "解析时间异常: " + e.getMessage());
                }
            }
        }
        return findNextClassPosition();
    }

    private int findNextClassPosition() {
        MyTableAdapter1 myTableAdapter1 = this.dutyAdapter;
        int i = -1;
        if (myTableAdapter1 != null && myTableAdapter1.list != null && !this.dutyAdapter.list.isEmpty()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = Long.MAX_VALUE;
            for (int i2 = 0; i2 < this.dutyAdapter.list.size(); i2++) {
                TableRsp tableRsp = this.dutyAdapter.list.get(i2);
                if (!TextUtils.isEmpty(tableRsp.startTime)) {
                    try {
                        long j2 = TimeUtil.gettime(tableRsp.startTime, TimeUtil.hoursMinuteTimeFormat) - jCurrentTimeMillis;
                        if (j2 > 0 && j2 < j) {
                            i = i2;
                            j = j2;
                        }
                    } catch (Exception e) {
                        Log.e("ClassSchedule4_4L", "解析时间异常: " + e.getMessage());
                    }
                }
            }
        }
        return i;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Runnable runnable;
        super.onResume();
        Handler handler = this.handler;
        if (handler == null || (runnable = this.highlightRunnable) == null) {
            return;
        }
        this.hasScrolledToHighlight = false;
        handler.postDelayed(runnable, 1000L);
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void KBDataFail(String str) {
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        } else {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getClassKBData(KBRsp2 kBRsp2) {
        if (kBRsp2.code.intValue() == 0) {
            SPUtils.getInstance().put(SpData.Table, JSON.toJSONString(kBRsp2));
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
    /* JADX WARN: Code duplicated, block: B:50:0x0128  */
    void setData(KBRsp2 kBRsp2) {
        if (kBRsp2 == null || kBRsp2.data == null) {
            return;
        }
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
            for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : kBRsp2.data.timetableList) {
                if (timetableListDTO.week == i && timetableListDTO.subjectName != null) {
                    arrayList.add(getTableRsp(timetableListDTO));
                }
            }
            this.lists.add(arrayList);
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
            this.lists.size();
            this.gridRl.setAdapter((ListAdapter) this.adapter);
            this.gridRl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.KBFragment4_2P.2
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j) {
                    KBFragment4_2P.this.adapter.setPostion(i6);
                    KBFragment4_2P.this.checkTab = i6;
                    if (KBFragment4_2P.this.lists != null && KBFragment4_2P.this.lists.size() > 0) {
                        KBFragment4_2P.this.dutyAdapter.notifyData((List) KBFragment4_2P.this.lists.get(i6), i6 == 6 ? 0 : i6 + 2);
                    }
                    if (KBFragment4_2P.this.lists == null || KBFragment4_2P.this.lists.size() == 0 || KBFragment4_2P.this.lists.size() < i6 || ((List) KBFragment4_2P.this.lists.get(i6)).size() == 0) {
                        KBFragment4_2P.this.mu.setViewState(2);
                    } else {
                        KBFragment4_2P.this.mu.setViewState(0);
                    }
                    KBFragment4_2P.this.adapter.notifyDataSetChanged();
                }
            });
        }
        scrollToHighlightPosition();
    }

    public TableRsp getTableRsp(KBRsp2.DataDTO.TimetableListDTO timetableListDTO) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = timetableListDTO.subjectName;
        if (timetableListDTO.teacherList != null && !timetableListDTO.teacherList.isEmpty()) {
            tableRsp.teacherName = timetableListDTO.teacherList.get(0).name;
        }
        tableRsp.courseType = timetableListDTO.courseType;
        tableRsp.seletion = timetableListDTO.section;
        tableRsp.startTime = timetableListDTO.startTime;
        tableRsp.endTime = timetableListDTO.endTime;
        tableRsp.sectionName = timetableListDTO.sectionName;
        tableRsp.week = timetableListDTO.week;
        tableRsp.timeFrame = timetableListDTO.sectionType;
        return tableRsp;
    }

    private class weekAdapter extends BaseAdapter {
        Resources res;
        String[] week = getWeek();
        public int i = -1;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private weekAdapter() {
            this.res = KBFragment4_2P.this.getResources();
        }

        private String[] getWeek() {
            KBFragment4_2P.this.gridRl.setNumColumns(7);
            return KBFragment4_2P.this.week7;
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
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_week_item6_p, (ViewGroup) null);
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
            if (KBFragment4_2P.this.checkTab >= 0) {
                if (KBFragment4_2P.this.checkTab == i) {
                    linearLayout.setBackgroundResource(R.drawable.bg_purple20);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.table_item_bg9l);
                }
            }
            if (KBFragment4_2P.this.checkTab != i) {
                imageView.setVisibility(TextUtils.equals(getItem(i), TimeUtil.getWeek(new Date())) ? 0 : 8);
                if (KBFragment4_2P.this.checkTab == -1) {
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
