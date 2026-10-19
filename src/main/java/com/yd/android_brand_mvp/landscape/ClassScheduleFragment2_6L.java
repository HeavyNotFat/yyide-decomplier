package com.yd.android_brand_mvp.landscape;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.KBActivity;
import com.yd.android_brand_mvp.activity.SiteKBActivity;
import com.yd.android_brand_mvp.adapter.ClassTableAdapter2x2;
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
import com.yd.android_brand_mvp.view.UserTableView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleFragment2_6L extends BaseMvpFragment<UserCenterPresenter> implements UserTableView {
    ClassTableAdapter2x2 adapter;
    private MyHandler handler;
    private List<List<TableRsp>> lists;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private final String TAG = ClassScheduleFragment2_6L.class.getSimpleName();
    private int KBType = 1;
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$ClassScheduleFragment2_6L$L65wRyM54w5IqYM9r6SDBDrBPCs
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0$ClassScheduleFragment2_6L();
        }
    };

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
        private WeakReference<ClassScheduleFragment2_6L> mWeakReference;

        public MyHandler(ClassScheduleFragment2_6L classScheduleFragment2_6L) {
            this.mWeakReference = new WeakReference<>(classScheduleFragment2_6L);
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule2_6l, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.handler = new MyHandler(this);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.adapter = new ClassTableAdapter2x2();
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setEmptyView(R.layout.item_min_null_class_schedule_layout);
        Hawk.init(this.mActivity).build();
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        }
        ((UserCenterPresenter) this.mvpPresenter).getClassKB(SpData.getSiteId(), -1, "2");
    }

    public /* synthetic */ void lambda$new$0$ClassScheduleFragment2_6L() {
        Message message = new Message();
        message.what = 200;
        this.handler.sendMessage(message);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if ((i == MinaConstants.Table || i == MinaConstants.SEMESTER) && !TextUtils.isEmpty(SpData.getClassesId())) {
            ((UserCenterPresenter) this.mvpPresenter).getClassKB(SpData.getClassesId(), -1, "2");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public UserCenterPresenter createPresenter() {
        return new UserCenterPresenter(this);
    }

    @OnClick({R.id.content_layout})
    public void onViewClicked(View view) {
        if (view.getId() == R.id.content_layout) {
            if (this.KBType == 2) {
                goPermissionsActivity(KBActivity.class);
                return;
            }
            Intent intent = new Intent(getActivity(), (Class<?>) SiteKBActivity.class);
            intent.putExtra("drak", "music");
            goPermissionsActivity(intent);
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

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableDataFail(String str) {
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void getCDKBData(KBRsp2 kBRsp2) {
        if (kBRsp2.code.intValue() == 0) {
            SPUtils.getInstance().put(SpData.Table, JSON.toJSONString(kBRsp2));
            setData(kBRsp2);
            Hawk.delete(BaseHawk.NEWCLASSKB);
            Hawk.put(BaseHawk.NEWCLASSKB, kBRsp2);
            this.handler.postDelayed(this.runnable, 30000L);
            if (kBRsp2.data.timetableList.size() == 0) {
                Hawk.delete(BaseHawk.NEWCLASSKB);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:40:0x00ae  */
    void setData(KBRsp2 kBRsp2) {
        int i;
        if (kBRsp2 == null) {
            return;
        }
        this.adapter.setWeek(kBRsp2.data.thisWeek.intValue());
        this.lists = new ArrayList();
        int i2 = 1;
        while (true) {
            i = 7;
            if (i2 > 7) {
                break;
            }
            ArrayList arrayList = new ArrayList();
            for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : kBRsp2.data.timetableList) {
                if (timetableListDTO.week == i2 && timetableListDTO.subjectName != null) {
                    arrayList.add(getTableRsp(timetableListDTO));
                }
            }
            this.lists.add(getLastList(arrayList));
            i2++;
        }
        switch (TimeUtils.getChineseWeek(new Date())) {
            case "周一":
                i = 1;
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
                break;
            default:
                i = -1;
                break;
        }
        this.adapter.setList(this.lists.get(i - 1));
        final int nextIndex = this.adapter.getNextIndex();
        List<List<TableRsp>> list = this.lists;
        if (list == null || list.size() <= 0 || nextIndex < 0) {
            return;
        }
        this.recyclerView.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$ClassScheduleFragment2_6L$8MwjYtJAw18oZhtjZYh1TuF5sEQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setData$1$ClassScheduleFragment2_6L(nextIndex);
            }
        }, 1000L);
    }

    public /* synthetic */ void lambda$setData$1$ClassScheduleFragment2_6L(int i) {
        this.recyclerView.smoothScrollToPosition(i);
    }

    public List<TableRsp> getLastList(List<TableRsp> list) {
        Collections.sort(list, new Comparator<TableRsp>() { // from class: com.yd.android_brand_mvp.landscape.ClassScheduleFragment2_6L.1
            @Override // java.util.Comparator
            public int compare(TableRsp tableRsp, TableRsp tableRsp2) {
                return tableRsp.startTime.compareTo(tableRsp2.startTime);
            }
        });
        return list;
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
        tableRsp.timeFrame = timetableListDTO.sectionType;
        return tableRsp;
    }
}
