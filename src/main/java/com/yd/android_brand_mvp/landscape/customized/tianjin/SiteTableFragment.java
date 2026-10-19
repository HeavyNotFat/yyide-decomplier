package com.yd.android_brand_mvp.landscape.customized.tianjin;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
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
import com.yd.android_brand_mvp.adapter.customtj.CustomSiteTableAdapter;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SiteTableFragment extends BaseMvpFragment<KBPresenter> implements KBView {
    CustomSiteTableAdapter dutyAdapter;
    private MyHandler handler;

    @BindView(R.id.list_table)
    GridView listTable;
    private List<List<TableRsp>> lists;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tv_week)
    TextView tv_week;
    int checkTab = -1;
    private boolean isRetryRequest = true;
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteTableFragment.1
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 200;
            SiteTableFragment.this.handler.sendMessage(message);
        }
    };

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getClassKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getKBData(KBRsp kBRsp) {
    }

    private static class MyHandler extends Handler {
        private final WeakReference<SiteTableFragment> mWeakReference;

        public MyHandler(SiteTableFragment siteTableFragment) {
            this.mWeakReference = new WeakReference<>(siteTableFragment);
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
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule4_3l, viewGroup, false);
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
        CustomSiteTableAdapter customSiteTableAdapter = new CustomSiteTableAdapter(this.mActivity, TimeUtil.getIntWeek(System.currentTimeMillis()));
        this.dutyAdapter = customSiteTableAdapter;
        this.listTable.setAdapter((ListAdapter) customSiteTableAdapter);
        Hawk.init(this.mActivity).build();
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        }
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
            if (kBRsp2.data.timetableList.size() == 0) {
                Hawk.delete(BaseHawk.NEWCDKB);
                return;
            }
            return;
        }
        List<List<TableRsp>> list = this.lists;
        if (list != null) {
            list.clear();
        }
        this.tv_week.setVisibility(8);
        this.isRetryRequest = false;
    }

    public static List<KBRsp2.DataDTO.TimetableListDTO> listSorting(List<KBRsp2.DataDTO.TimetableListDTO> list) {
        if (list != null && list.size() > 0) {
            Collections.sort(list, new Comparator() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.-$$Lambda$SiteTableFragment$5v4GkfmOJYAhih3JwwK8ISfZgfI
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return String.valueOf(((KBRsp2.DataDTO.TimetableListDTO) obj).sectionTypeNum).compareTo(String.valueOf(((KBRsp2.DataDTO.TimetableListDTO) obj2).sectionTypeNum));
                }
            });
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:60:0x0125  */
    public void setData(KBRsp2 kBRsp2) {
        this.onFragmentDataListener.onFragmentData(kBRsp2 == null || kBRsp2.data == null || kBRsp2.data.timetableList == null || kBRsp2.data.timetableList.isEmpty());
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
        kBRsp2.data.thisWeek.intValue();
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
            return;
        }
        int i3 = this.checkTab;
        if (i3 != -1) {
            this.dutyAdapter.notifyData(this.lists.get(i3));
        } else if (i2 > this.lists.size()) {
            this.dutyAdapter.notifyData(this.lists.get(0));
        } else {
            this.dutyAdapter.notifyData(this.lists.get(i2 - 1), i2 != 7 ? i2 + 1 : 0);
        }
        this.listTable.setSelection(this.dutyAdapter.list.size() - 1);
        this.handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteTableFragment.2
            @Override // java.lang.Runnable
            public void run() {
                SiteTableFragment.this.listTable.setSelection(SiteTableFragment.this.dutyAdapter.getNextIndex());
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
}
