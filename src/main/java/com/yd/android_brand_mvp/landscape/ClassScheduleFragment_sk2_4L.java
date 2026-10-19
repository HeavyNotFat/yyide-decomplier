package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
import com.yd.android_brand_mvp.adapter.ClassTableAdapter_sk;
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
import com.yd.android_brand_mvp.view.UserTableView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleFragment_sk2_4L extends BaseMvpFragment<UserCenterPresenter> implements UserTableView {
    ClassTableAdapter_sk adapter;
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
    private final String TAG = "ClassSchedule2_4L";
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$ClassScheduleFragment_sk2_4L$OFsHoiwTomvmTuFQ4GkH83ikJ1w
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$1$ClassScheduleFragment_sk2_4L();
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
        private WeakReference<ClassScheduleFragment_sk2_4L> mWeakReference;

        public MyHandler(ClassScheduleFragment_sk2_4L classScheduleFragment_sk2_4L) {
            this.mWeakReference = new WeakReference<>(classScheduleFragment_sk2_4L);
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
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule2_4l_sk, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.handler = new MyHandler(this);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.title.setText(R.string.one_schedule);
        ClassTableAdapter_sk classTableAdapter_sk = new ClassTableAdapter_sk();
        this.adapter = classTableAdapter_sk;
        this.listview.setAdapter((ListAdapter) classTableAdapter_sk);
        this.mu.setViewState(2);
        Hawk.init(this.mActivity).build();
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCDKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        }
        if (!TextUtils.isEmpty(SpData.getClassesId())) {
            ((UserCenterPresenter) this.mvpPresenter).getClassKB(SpData.getClassesId(), -1, "1");
        }
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$ClassScheduleFragment_sk2_4L$9p81hN2dj7GJmCoA-uyB9XFkn-g
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public final void reload() {
                this.f$0.lambda$onViewCreated$0$ClassScheduleFragment_sk2_4L();
            }
        });
    }

    public /* synthetic */ void lambda$onViewCreated$0$ClassScheduleFragment_sk2_4L() {
        if (TextUtils.isEmpty(SpData.getClassesId())) {
            return;
        }
        ((UserCenterPresenter) this.mvpPresenter).getClassKB(SpData.getClassesId(), -1, "1");
    }

    public /* synthetic */ void lambda$new$1$ClassScheduleFragment_sk2_4L() {
        Message message = new Message();
        message.what = 200;
        this.handler.sendMessage(message);
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
        Log.e("ClassSchedule2_4L", "UserTableData: " + JSON.toJSONString(userTableRsp));
    }

    @Override // com.yd.android_brand_mvp.view.UserTableView
    public void UserTableDataFail(String str) {
        KBRsp2 kBRsp2 = (KBRsp2) Hawk.get(BaseHawk.NEWCLASSKB);
        if (kBRsp2 != null) {
            setData(kBRsp2);
        } else {
            this.mu.setViewState(2);
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
                this.mu.setViewState(2);
                return;
            }
            return;
        }
        this.tv_week.setVisibility(8);
        this.mu.setViewState(2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x00f5  */
    void setData(KBRsp2 kBRsp2) {
        int i;
        if (kBRsp2 == null) {
            return;
        }
        this.tv_week.setVisibility(kBRsp2.data.thisWeek != null ? 0 : 8);
        this.tv_week.setText("当前周次：第" + kBRsp2.data.thisWeek + "周");
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
            this.lists.add(arrayList);
            i2++;
        }
        Log.e("TAG", "2_4Schedule" + this.lists.size());
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
        List<List<TableRsp>> list = this.lists;
        if (list == null || list.size() == 0) {
            this.mu.setViewState(2);
        } else {
            int i3 = i - 1;
            if (this.lists.get(i3) == null || this.lists.get(i3).size() == 0 || i > this.lists.size()) {
                this.mu.setViewState(2);
            } else {
                this.adapter.notifyData(this.lists.get(i3));
                this.mu.setViewState(0);
            }
        }
        if (this.adapter.getNextIndex() > 5 || this.adapter.getNextIndex() == -1) {
            this.listview.smoothScrollToPosition(this.adapter.list.size() - 1);
        }
        this.listview.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$ClassScheduleFragment_sk2_4L$bF_zN1kHywGORCTZdPEj0cebJbs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setData$2$ClassScheduleFragment_sk2_4L();
            }
        }, 1000L);
    }

    public /* synthetic */ void lambda$setData$2$ClassScheduleFragment_sk2_4L() {
        this.listview.smoothScrollToPosition(this.adapter.getNextIndex());
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
