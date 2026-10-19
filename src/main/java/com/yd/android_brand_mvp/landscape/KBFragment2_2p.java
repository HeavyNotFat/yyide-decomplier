package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.ClassScheduleActivity;
import com.yd.android_brand_mvp.activity.KBActivity;
import com.yd.android_brand_mvp.adapter.ClassTableAdapter;
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
import com.yd.android_brand_mvp.view.KBView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragment2_2p extends BaseMvpFragment<KBPresenter> implements KBView {
    private static final int UPDATE_HIGHLIGHT = 100;
    private static final long UPDATE_INTERVAL = 30000;
    ClassTableAdapter adapter;
    private MyHandler handler;
    private List<List<TableRsp>> lists;

    @BindView(R.id.listview)
    ListView listview;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tv_week)
    TextView tv_week;
    private final String sqlTab = "KBRsp";
    String[] week7 = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    private boolean hasScrolledToHighlight = false;

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getCDKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getKBData(KBRsp kBRsp) {
    }

    private static class MyHandler extends Handler {
        private final WeakReference<KBFragment2_2p> fragmentRef;

        public MyHandler(KBFragment2_2p kBFragment2_2p) {
            super(Looper.myLooper());
            this.fragmentRef = new WeakReference<>(kBFragment2_2p);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            KBFragment2_2p kBFragment2_2p = this.fragmentRef.get();
            if (kBFragment2_2p == null || message.what != 100) {
                return;
            }
            kBFragment2_2p.updateHighlightAndScroll();
            sendEmptyMessageDelayed(100, 30000L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_kb_22_p, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.handler = new MyHandler(this);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ClassTableAdapter classTableAdapter = new ClassTableAdapter();
        this.adapter = classTableAdapter;
        this.listview.setAdapter((ListAdapter) classTableAdapter);
        this.title.setText(R.string.one_schedule);
        ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.KBFragment2_2p.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((KBPresenter) KBFragment2_2p.this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
            }
        });
        Hawk.init(this.mActivity).build();
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.hasScrolledToHighlight = false;
        MyHandler myHandler = this.handler;
        if (myHandler != null) {
            myHandler.removeMessages(100);
            this.handler.sendEmptyMessageDelayed(100, 1000L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MyHandler myHandler = this.handler;
        if (myHandler != null) {
            myHandler.removeMessages(100);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MyHandler myHandler = this.handler;
        if (myHandler != null) {
            myHandler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:40:0x00ce  */
    void setData(KBRsp2 kBRsp2) {
        if (kBRsp2 == null) {
            return;
        }
        String.valueOf(kBRsp2.data.thisWeek);
        this.adapter.setWeek(kBRsp2.data.thisWeek.intValue());
        this.lists = new ArrayList();
        int i = 1;
        for (int i2 = 1; i2 <= 7; i2++) {
            ArrayList arrayList = new ArrayList();
            for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : kBRsp2.data.timetableList) {
                if (timetableListDTO.week == i2 && timetableListDTO.subjectName != null) {
                    arrayList.add(getTableRsp(timetableListDTO));
                }
            }
            this.lists.add(arrayList);
        }
        Log.e("TAG", "2_4Schedule" + this.lists.size());
        switch (TimeUtils.getChineseWeek(new Date())) {
            case "周一":
                break;
            case "周二":
                i = 2;
                break;
            case "周三":
                i = 3;
                break;
            case "周四":
                i = 4;
                break;
            case "周五":
                i = 5;
                break;
            case "周六":
                i = 6;
                break;
            case "周日":
                i = 7;
                break;
            default:
                i = -1;
                break;
        }
        List<List<TableRsp>> list = this.lists;
        if (list != null && list.size() != 0) {
            int i3 = i - 1;
            if (this.lists.get(i3) != null && this.lists.get(i3).size() != 0) {
                if (i > this.lists.size()) {
                    this.mu.setViewState(2);
                    return;
                }
                this.adapter.notifyData(this.lists.get(i3));
                this.mu.setViewState(0);
                this.listview.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.KBFragment2_2p.2
                    @Override // java.lang.Runnable
                    public void run() {
                        KBFragment2_2p.this.updateHighlightAndScroll();
                    }
                }, 500L);
                return;
            }
        }
        this.mu.setViewState(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHighlightAndScroll() {
        ClassTableAdapter classTableAdapter = this.adapter;
        if (classTableAdapter == null || classTableAdapter.list == null || this.adapter.list.isEmpty()) {
            return;
        }
        clearAllHighlights();
        int iFindHighlightPosition = findHighlightPosition();
        if (iFindHighlightPosition >= 0) {
            this.adapter.list.get(iFindHighlightPosition).isHighlighted = true;
            if (!this.hasScrolledToHighlight || this.listview.getFirstVisiblePosition() > iFindHighlightPosition || this.listview.getLastVisiblePosition() < iFindHighlightPosition) {
                scrollToHighlightPosition(iFindHighlightPosition);
                this.hasScrolledToHighlight = true;
            }
        } else {
            int iFindNextClassPosition = findNextClassPosition();
            if (iFindNextClassPosition >= 0 && (!this.hasScrolledToHighlight || this.listview.getFirstVisiblePosition() > iFindNextClassPosition || this.listview.getLastVisiblePosition() < iFindNextClassPosition)) {
                scrollToHighlightPosition(iFindNextClassPosition);
                this.hasScrolledToHighlight = true;
            }
        }
        this.adapter.notifyDataSetChanged();
    }

    private void clearAllHighlights() {
        ClassTableAdapter classTableAdapter = this.adapter;
        if (classTableAdapter == null || classTableAdapter.list == null) {
            return;
        }
        Iterator<TableRsp> it2 = this.adapter.list.iterator();
        while (it2.hasNext()) {
            it2.next().isHighlighted = false;
        }
    }

    private int findHighlightPosition() {
        ClassTableAdapter classTableAdapter = this.adapter;
        if (classTableAdapter != null && classTableAdapter.list != null && !this.adapter.list.isEmpty()) {
            for (int i = 0; i < this.adapter.list.size(); i++) {
                TableRsp tableRsp = this.adapter.list.get(i);
                if (TimeUtil.isBelong(tableRsp.startTime, tableRsp.endTime)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int findNextClassPosition() {
        ClassTableAdapter classTableAdapter = this.adapter;
        if (classTableAdapter != null && classTableAdapter.list != null && !this.adapter.list.isEmpty()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < this.adapter.list.size(); i++) {
                if (jCurrentTimeMillis > TimeUtil.gettime(this.adapter.list.get(i).startTime, TimeUtil.hoursMinuteTimeFormat)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void scrollToHighlightPosition(final int i) {
        ListView listView = this.listview;
        if (listView == null || i < 0) {
            return;
        }
        listView.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.KBFragment2_2p.3
            @Override // java.lang.Runnable
            public void run() {
                KBFragment2_2p.this.listview.smoothScrollToPosition(i);
                KBFragment2_2p.this.listview.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.KBFragment2_2p.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KBFragment2_2p.this.listview != null) {
                            int firstVisiblePosition = KBFragment2_2p.this.listview.getFirstVisiblePosition();
                            int lastVisiblePosition = KBFragment2_2p.this.listview.getLastVisiblePosition();
                            if (i < firstVisiblePosition || i > lastVisiblePosition) {
                                KBFragment2_2p.this.listview.setSelection(i);
                            }
                        }
                    }
                }, 500L);
            }
        });
    }

    public TableRsp getTableRsp(KBRsp2.DataDTO.TimetableListDTO timetableListDTO) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = timetableListDTO.subjectName;
        if (timetableListDTO.teacherList != null && timetableListDTO.teacherList.size() > 0) {
            tableRsp.teacherName = TeacherNameUtils.INSTANCE.getTeacherNameByList(timetableListDTO.teacherList);
        }
        tableRsp.courseType = timetableListDTO.courseType;
        tableRsp.seletion = Integer.valueOf(timetableListDTO.section).intValue();
        tableRsp.startTime = timetableListDTO.startTime;
        tableRsp.endTime = timetableListDTO.endTime;
        tableRsp.week = timetableListDTO.week;
        tableRsp.timeFrame = timetableListDTO.sectionType;
        tableRsp.isHighlighted = false;
        return tableRsp;
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void KBDataFail(String str) {
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
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
            setData(kBRsp2);
            Hawk.delete(BaseHawk.NEWCLASSKB);
            Hawk.put(BaseHawk.NEWCLASSKB, kBRsp2);
            if (kBRsp2.data.timetableList.size() == 0) {
                Hawk.delete(BaseHawk.NEWCLASSKB);
                this.mu.setViewState(2);
                return;
            }
            return;
        }
        this.tv_week.setVisibility(8);
        this.mu.setViewState(2);
    }
}
