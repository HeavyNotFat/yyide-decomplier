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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.SiteKBActivity;
import com.yd.android_brand_mvp.adapter.MyTableAdapter4;
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
public class KBFragment4_4L extends BaseMvpFragment<KBPresenter> implements KBView {
    weekAdapter adapter;
    MyTableAdapter4 dutyAdapter;

    @BindView(R.id.grid_rl)
    GridView gridRl;
    private MyHandler handler;

    @BindView(R.id.list_table)
    GridView listTable;
    private List<List<TableRsp>> lists;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.table_view)
    FrameLayout tableView;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tv_week)
    TextView tv_week;
    String[] week7 = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    int checkTab = -1;
    private boolean isRetryRequest = true;
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.KBFragment4_4L.1
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 200;
            KBFragment4_4L.this.handler.sendMessage(message);
        }
    };

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getClassKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getKBData(KBRsp kBRsp) {
    }

    private static class MyHandler extends Handler {
        private final WeakReference<KBFragment4_4L> mWeakReference;

        public MyHandler(KBFragment4_4L kBFragment4_4L) {
            this.mWeakReference = new WeakReference<>(kBFragment4_4L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 200 || this.mWeakReference.get() == null || this.mWeakReference.get().handler == null) {
                return;
            }
            this.mWeakReference.get().handler.postDelayed(this.mWeakReference.get().runnable, 60000L);
            KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
            if (kBRsp2 != null) {
                this.mWeakReference.get().setData(kBRsp2);
            }
            if (this.mWeakReference.get().isRetryRequest) {
                return;
            }
            ((KBPresenter) this.mWeakReference.get().mvpPresenter).getCDKB(SpData.getSiteId(), -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule4_4l, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.handler = new MyHandler(this);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (SpData.getSiteName() != null) {
            this.title.setText(SpData.getSiteName());
        } else {
            this.title.setText("场地课表");
        }
        MyTableAdapter4 myTableAdapter4 = new MyTableAdapter4(this.mActivity, TimeUtil.getIntWeek(System.currentTimeMillis()));
        this.dutyAdapter = myTableAdapter4;
        this.listTable.setAdapter((ListAdapter) myTableAdapter4);
        Hawk.init(this.mActivity).build();
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        }
        ((KBPresenter) this.mvpPresenter).getCDKB(SpData.getSiteId(), -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public KBPresenter createPresenter() {
        return new KBPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Table || i == MinaConstants.SEMESTER || i == MinaConstants.netWork) {
            ((KBPresenter) this.mvpPresenter).getCDKB(SpData.getSiteId(), -1);
        }
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
        ((KBPresenter) this.mvpPresenter).getCDKB(SpData.getSiteId(), -1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void KBDataFail(String str) {
        LogUtils.e("KBDataFail = " + str);
        this.isRetryRequest = false;
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        } else {
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getCDKBData(KBRsp2 kBRsp2) {
        LogUtils.i("getCDKBData44" + JSON.toJSONString(kBRsp2));
        if (kBRsp2 != null && kBRsp2.code.intValue() == 0 && kBRsp2.data != null) {
            this.isRetryRequest = true;
            Hawk.delete(BaseHawk.NEWCDKB);
            Hawk.put(BaseHawk.NEWCDKB, kBRsp2);
            setData(kBRsp2);
            this.checkTab = -1;
            this.gridRl.setVisibility(0);
            if (kBRsp2.data.timetableList.size() == 0) {
                Hawk.delete(BaseHawk.NEWCDKB);
                this.mu.setViewState(2);
                return;
            } else {
                this.mu.setViewState(0);
                return;
            }
        }
        this.mu.setViewState(2);
        List<List<TableRsp>> list = this.lists;
        if (list != null) {
            list.clear();
        }
        this.tv_week.setVisibility(8);
        this.gridRl.setVisibility(8);
        this.isRetryRequest = false;
    }

    public static List<KBRsp2.DataDTO.TimetableListDTO> listSorting(List<KBRsp2.DataDTO.TimetableListDTO> list) {
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Comparator() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$KBFragment4_4L$tpAX6-ne21RJRea2ouJyt_ivWas
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return String.valueOf(((KBRsp2.DataDTO.TimetableListDTO) obj).sectionTypeNum).compareTo(String.valueOf(((KBRsp2.DataDTO.TimetableListDTO) obj2).sectionTypeNum));
                }
            });
        }
        return list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:49:0x0122  */
    void setData(KBRsp2 kBRsp2) {
        if (SpData.getClassInfoRsp() != null) {
            this.title.setText(SpData.getClassInfoRsp().data.classesName);
        }
        this.handler.removeCallbacks(this.runnable);
        this.handler.postDelayed(this.runnable, 60000L);
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
            this.gridRl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.KBFragment4_4L.2
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j) {
                    KBFragment4_4L.this.adapter.setPostion(i6);
                    KBFragment4_4L.this.checkTab = i6;
                    if (KBFragment4_4L.this.lists != null && KBFragment4_4L.this.lists.size() > 0) {
                        KBFragment4_4L.this.dutyAdapter.notifyData((List) KBFragment4_4L.this.lists.get(i6), i6 == 6 ? 0 : i6 + 2);
                    }
                    if (KBFragment4_4L.this.lists == null || KBFragment4_4L.this.lists.size() == 0 || KBFragment4_4L.this.lists.size() < i6 || ((List) KBFragment4_4L.this.lists.get(i6)).size() == 0) {
                        KBFragment4_4L.this.mu.setViewState(2);
                    } else {
                        KBFragment4_4L.this.mu.setViewState(0);
                    }
                    KBFragment4_4L.this.adapter.notifyDataSetChanged();
                }
            });
        }
        this.listTable.setSelection(this.dutyAdapter.list.size() - 1);
        this.handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.KBFragment4_4L.3
            @Override // java.lang.Runnable
            public void run() {
                KBFragment4_4L.this.listTable.setSelection(KBFragment4_4L.this.dutyAdapter.getNextIndex());
            }
        }, 1000L);
    }

    public TableRsp getTableRsp(KBRsp2.DataDTO.TimetableListDTO timetableListDTO) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = timetableListDTO.subjectName;
        if (timetableListDTO.teacherList != null && timetableListDTO.teacherList.size() > 0) {
            tableRsp.teacherName = TeacherNameUtils.INSTANCE.getTeacherNameByList(timetableListDTO.teacherList);
        }
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
            KBFragment4_4L.this.gridRl.setNumColumns(7);
            return KBFragment4_4L.this.week7;
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
            if (KBFragment4_4L.this.checkTab >= 0) {
                if (KBFragment4_4L.this.checkTab == i) {
                    linearLayout.setBackgroundResource(R.drawable.bg_purple20);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.table_item_bg9l);
                }
            }
            if (KBFragment4_4L.this.checkTab != i) {
                imageView.setVisibility(TextUtils.equals(getItem(i), TimeUtil.getWeek(new Date())) ? 0 : 8);
                if (KBFragment4_4L.this.checkTab == -1) {
                    imageView.setVisibility(8);
                }
            } else {
                imageView.setVisibility(8);
            }
            int i2 = this.i;
            if (i2 != -1) {
                checkedTextView.setChecked(i2 == i);
            }
            return view;
        }

        public void setPostion(int i) {
            this.i = i;
            notifyDataSetChanged();
        }
    }
}
