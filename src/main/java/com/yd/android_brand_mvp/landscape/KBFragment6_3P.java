package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
import androidx.work.WorkRequest;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.SiteKBActivity;
import com.yd.android_brand_mvp.adapter.MyTableAdapter1;
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
public class KBFragment6_3P extends BaseMvpFragment<KBPresenter> implements KBView {
    private static final long UPDATE_INTERVAL = 30000;
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
    private final String TAG = "ClassSchedule4_4L";
    String[] week7 = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    int checkTab = -1;
    private int lastHighlightIndex = -1;
    private final Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.KBFragment6_3P.1
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 200;
            KBFragment6_3P.this.handler.sendMessage(message);
        }
    };

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getClassKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getKBData(KBRsp kBRsp) {
    }

    public KBFragment6_3P() {
    }

    public KBFragment6_3P(String str) {
        this.tab = str;
    }

    private static class MyHandler extends Handler {
        private WeakReference<KBFragment6_3P> mWeakReference;

        public MyHandler(KBFragment6_3P kBFragment6_3P) {
            this.mWeakReference = new WeakReference<>(kBFragment6_3P);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 200) {
                this.mWeakReference.get().handler.postDelayed(this.mWeakReference.get().runnable, 30000L);
                KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
                if (kBRsp2 != null) {
                    if (this.mWeakReference.get().dutyAdapter == null) {
                        this.mWeakReference.get().setData(kBRsp2);
                    } else {
                        this.mWeakReference.get().dutyAdapter.notifyDataSetChanged();
                        this.mWeakReference.get().checkAndScrollToHighlightPosition();
                    }
                }
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
        if (SpData.NewUser() == null) {
            this.title.setText("场地课表");
        } else {
            this.title.setText(SpData.getSiteName());
        }
        MyTableAdapter1 myTableAdapter1 = new MyTableAdapter1(this.mActivity, TimeUtil.getIntWeek(System.currentTimeMillis()), this.tab);
        this.dutyAdapter = myTableAdapter1;
        this.listTable.setAdapter((ListAdapter) myTableAdapter1);
        ((KBPresenter) this.mvpPresenter).getCDKB(SpData.getSiteId(), -1);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.KBFragment6_3P.2
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((KBPresenter) KBFragment6_3P.this.mvpPresenter).getCDKB(SpData.getSiteId(), -1);
            }
        });
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        }
        this.handler.postDelayed(this.runnable, 30000L);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Table || i == MinaConstants.SEMESTER) {
            ((KBPresenter) this.mvpPresenter).getCDKB(SpData.getSiteId(), -1);
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
            goPermissionsActivity(SiteKBActivity.class);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
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
    public void getCDKBData(KBRsp2 kBRsp2) {
        if (kBRsp2.data != null && kBRsp2.code.intValue() == 0) {
            Hawk.delete(BaseHawk.NEWCDKB);
            Hawk.put(BaseHawk.NEWCDKB, kBRsp2);
            setData(kBRsp2);
            this.checkTab = -1;
            this.handler.postDelayed(this.runnable, WorkRequest.MIN_BACKOFF_MILLIS);
            this.gridRl.setVisibility(0);
            if (kBRsp2.data.timetableList.size() == 0) {
                Hawk.delete(BaseHawk.NEWCDKB);
                this.mu.setViewState(2);
                return;
            }
            return;
        }
        this.mu.setViewState(2);
    }

    public static List<KBRsp2.DataDTO.TimetableListDTO> listSorting(List<KBRsp2.DataDTO.TimetableListDTO> list) {
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Comparator<KBRsp2.DataDTO.TimetableListDTO>() { // from class: com.yd.android_brand_mvp.landscape.KBFragment6_3P.3
                @Override // java.util.Comparator
                public int compare(KBRsp2.DataDTO.TimetableListDTO timetableListDTO, KBRsp2.DataDTO.TimetableListDTO timetableListDTO2) {
                    return String.valueOf(timetableListDTO.sectionTypeNum).compareTo(String.valueOf(timetableListDTO2.sectionTypeNum));
                }
            });
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:48:0x0106  */
    public void setData(KBRsp2 kBRsp2) {
        if (kBRsp2 == null) {
            return;
        }
        this.mu.setViewState(0);
        TextView textView = this.tv_week;
        StringBuilder sb = new StringBuilder();
        sb.append(kBRsp2.data.thisWeek);
        sb.append("");
        textView.setVisibility(StringUtils.isEmpty(sb.toString()) ? 8 : 0);
        int iIntValue = kBRsp2.data.thisWeek.intValue();
        this.tv_week.setText("当前周次：第" + iIntValue + "周");
        this.title.setText(TextUtils.isEmpty(SpData.getSiteName()) ? "场地课表" : SpData.getSiteName());
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
            this.gridRl.setOnItemClickListener(new AnonymousClass4());
        }
        this.handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$KBFragment6_3P$peArW6ETe3HJ23ZYTglDBa1BigI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.checkAndScrollToHighlightPosition();
            }
        }, 1000L);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.KBFragment6_3P$4, reason: invalid class name */
    class AnonymousClass4 implements AdapterView.OnItemClickListener {
        AnonymousClass4() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            KBFragment6_3P.this.adapter.setPostion(i);
            KBFragment6_3P.this.checkTab = i;
            if (KBFragment6_3P.this.lists != null && !KBFragment6_3P.this.lists.isEmpty()) {
                KBFragment6_3P.this.dutyAdapter.notifyData((List) KBFragment6_3P.this.lists.get(i), i == 6 ? 0 : i + 2);
                KBFragment6_3P.this.lastHighlightIndex = -1;
                KBFragment6_3P.this.handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$KBFragment6_3P$4$J_5aUiMXQgFhBc6flroNfi-zDTY
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onItemClick$0$KBFragment6_3P$4();
                    }
                }, 300L);
            }
            if (KBFragment6_3P.this.lists == null || KBFragment6_3P.this.lists.isEmpty() || KBFragment6_3P.this.lists.size() < i || ((List) KBFragment6_3P.this.lists.get(i)).isEmpty()) {
                KBFragment6_3P.this.mu.setViewState(2);
            } else {
                KBFragment6_3P.this.mu.setViewState(0);
            }
            KBFragment6_3P.this.adapter.notifyDataSetChanged();
        }

        public /* synthetic */ void lambda$onItemClick$0$KBFragment6_3P$4() {
            KBFragment6_3P.this.scrollToHighlightPosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToHighlightPosition() {
        int nextIndex;
        MyTableAdapter1 myTableAdapter1 = this.dutyAdapter;
        if (myTableAdapter1 == null || myTableAdapter1.list == null || this.dutyAdapter.list.isEmpty() || (nextIndex = this.dutyAdapter.getNextIndex()) < 0 || nextIndex >= this.dutyAdapter.list.size()) {
            return;
        }
        this.listTable.smoothScrollToPosition(nextIndex);
        this.listTable.setSelection(nextIndex);
        this.lastHighlightIndex = nextIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndScrollToHighlightPosition() {
        int nextIndex;
        MyTableAdapter1 myTableAdapter1 = this.dutyAdapter;
        if (myTableAdapter1 == null || myTableAdapter1.list == null || this.dutyAdapter.list.isEmpty() || (nextIndex = this.dutyAdapter.getNextIndex()) == this.lastHighlightIndex || nextIndex < 0 || nextIndex >= this.dutyAdapter.list.size()) {
            return;
        }
        scrollToHighlightPosition();
    }

    public TableRsp getTableRsp(KBRsp2.DataDTO.TimetableListDTO timetableListDTO) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = timetableListDTO.subjectName;
        if (timetableListDTO.teacherList != null && !timetableListDTO.teacherList.isEmpty()) {
            tableRsp.teacherName = TeacherNameUtils.INSTANCE.getTeacherNameByList(timetableListDTO.teacherList);
        }
        tableRsp.courseType = timetableListDTO.courseType;
        tableRsp.startTime = timetableListDTO.startTime;
        tableRsp.endTime = timetableListDTO.endTime;
        tableRsp.week = timetableListDTO.week;
        tableRsp.seletion = timetableListDTO.section;
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
            KBFragment6_3P.this.gridRl.setNumColumns(7);
            return KBFragment6_3P.this.week7;
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
            if (KBFragment6_3P.this.checkTab >= 0) {
                if (KBFragment6_3P.this.checkTab == i) {
                    linearLayout.setBackgroundResource(R.drawable.bg_purple20);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.table_item_bg9l);
                }
            }
            if (KBFragment6_3P.this.checkTab != i) {
                imageView.setVisibility(TextUtils.equals(getItem(i), TimeUtil.getWeek(new Date())) ? 0 : 8);
                if (KBFragment6_3P.this.checkTab == -1) {
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
