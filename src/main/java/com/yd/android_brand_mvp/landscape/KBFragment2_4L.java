package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.ClassScheduleActivity;
import com.yd.android_brand_mvp.activity.KBActivity;
import com.yd.android_brand_mvp.adapter.ClassTableAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.KBRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.presenter.KBPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.KBView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragment2_4L extends BaseMvpFragment<KBPresenter> implements KBView {
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
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.KBFragment2_4L.1
        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 200;
            KBFragment2_4L.this.handler.sendMessage(message);
        }
    };

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getCDKBData(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getClassKBData(KBRsp2 kBRsp2) {
    }

    private static class MyHandler extends Handler {
        private WeakReference<KBFragment2_4L> mWeakReference;

        public MyHandler(KBFragment2_4L kBFragment2_4L) {
            this.mWeakReference = new WeakReference<>(kBFragment2_4L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 200 || this.mWeakReference.get() == null || this.mWeakReference.get().handler == null) {
                return;
            }
            this.mWeakReference.get().handler.postDelayed(this.mWeakReference.get().runnable, 30000L);
            KBRsp kBRsp = (KBRsp) Hawk.get("KBRsp");
            if (kBRsp != null) {
                this.mWeakReference.get().setData(kBRsp);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule2_4l, viewGroup, false);
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
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$KBFragment2_4L$VS7nHJmpxUvAWsAWVCc_l0niOiA
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public final void reload() {
                this.f$0.lambda$onViewCreated$0$KBFragment2_4L();
            }
        });
        Hawk.init(this.mActivity).build();
    }

    public /* synthetic */ void lambda$onViewCreated$0$KBFragment2_4L() {
        ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
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
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Runnable runnable;
        super.onResume();
        MyHandler myHandler = this.handler;
        if (myHandler != null && (runnable = this.runnable) != null) {
            myHandler.postDelayed(runnable, 1000L);
        }
        ((KBPresenter) this.mvpPresenter).getKB(SpData.getClassesId() + "", -1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.runnable);
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void getKBData(KBRsp kBRsp) {
        if (kBRsp.code == BaseConstant.REQUEST_SUCCES2) {
            SPUtils.getInstance().put(SpData.Table, JSON.toJSONString(kBRsp));
            setData(kBRsp);
            Hawk.delete("KBRsp");
            Hawk.put("KBRsp", kBRsp);
            this.handler.postDelayed(this.runnable, 30000L);
            return;
        }
        this.tv_week.setVisibility(8);
        this.mu.setViewState(2);
        this.handler.removeCallbacks(this.runnable);
    }

    @Override // com.yd.android_brand_mvp.view.KBView
    public void KBDataFail(String str) {
        if (SpData.getTable() != null) {
            return;
        }
        this.mu.setViewState(1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:42:0x00e8  */
    void setData(KBRsp kBRsp) {
        int i;
        if (kBRsp == null) {
            return;
        }
        this.title.setText(kBRsp.data.cdmc);
        TextView textView = this.tv_week;
        StringBuilder sb = new StringBuilder();
        sb.append(kBRsp.data.bzzc);
        sb.append("");
        textView.setVisibility(StringUtils.isEmpty(sb.toString()) ? 8 : 0);
        this.tv_week.setText("当前周次：第" + kBRsp.data.bzzc + "周");
        this.lists = new ArrayList();
        int i2 = 1;
        while (true) {
            i = 7;
            if (i2 > 7) {
                break;
            }
            ArrayList arrayList = new ArrayList();
            for (KBRsp.DataDTO.ListDTO listDTO : kBRsp.data.list) {
                if (listDTO.skxq == i2 + 1) {
                    arrayList.add(getTableRsp(listDTO));
                }
            }
            this.lists.add(arrayList);
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
        this.listview.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.KBFragment2_4L.2
            @Override // java.lang.Runnable
            public void run() {
                KBFragment2_4L.this.listview.smoothScrollToPosition(KBFragment2_4L.this.adapter.getNextIndex());
            }
        }, 1000L);
    }

    public TableRsp getTableRsp(KBRsp.DataDTO.ListDTO listDTO) {
        TableRsp tableRsp = new TableRsp();
        tableRsp.subjectsName = listDTO.kcmc;
        tableRsp.teacherName = listDTO.jzgmc;
        tableRsp.startTime = listDTO.kssj;
        tableRsp.endTime = listDTO.jssj;
        tableRsp.week = listDTO.skxq;
        tableRsp.timeFrame = listDTO.jcsd;
        return tableRsp;
    }
}
