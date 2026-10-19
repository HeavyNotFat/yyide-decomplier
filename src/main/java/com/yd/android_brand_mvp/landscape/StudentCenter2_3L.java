package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.ClassStudentMsg;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.StudenCenterAdapter2;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.StudentCenterRsp;
import com.yd.android_brand_mvp.model.StudentMsgBean;
import com.yd.android_brand_mvp.presenter.StudenCenterPresenter;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yd.android_brand_mvp.view.StudenCenterView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudentCenter2_3L extends BaseMvpFragment<StudenCenterPresenter> implements StudenCenterView {
    StudenCenterAdapter2 adapter;

    @BindView(R.id.grid)
    GridView grid;
    Handler handler = new Handler() { // from class: com.yd.android_brand_mvp.landscape.StudentCenter2_3L.3
        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            super.handleMessage(message);
            StudentCenter2_3L.this.mActivity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.StudentCenter2_3L.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (message.what == 1) {
                        StudentCenter2_3L.this.setStudentData();
                    }
                }
            });
        }
    };

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.title)
    TextView title;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.view.StudenCenterView
    public void getFail(String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_studentcenter_l2x3, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.title.setText(R.string.st_message);
        this.mu.setViewState(2);
        StudenCenterAdapter2 studenCenterAdapter2 = new StudenCenterAdapter2();
        this.adapter = studenCenterAdapter2;
        this.grid.setAdapter((ListAdapter) studenCenterAdapter2);
        this.mu.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentCenter2_3L.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        this.grid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentCenter2_3L.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                StudentCenter2_3L.this.goPermissionsActivity(StudentCheackActivity.class);
            }
        });
        this.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$StudentCenter2_3L$PGRQZvzbtL3BrW-CLxWPrDtNsWw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$0$StudentCenter2_3L(view2);
            }
        });
    }

    public /* synthetic */ void lambda$onViewCreated$0$StudentCenter2_3L(View view) {
        goPermissionsActivity(StudentCheackActivity.class);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.StudentMsg) {
            Log.e("TAG", "StudentMsg: ");
            Message message = new Message();
            message.what = 1;
            this.handler.sendMessage(message);
        }
    }

    void setStudentData() {
        List<StudentMsgBean.Data0> list = ClassStudentMsg.getInstance().list;
        if (list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (StudentMsgBean.Data0 data0 : list) {
                if (data0.msgNum != 0 && !isHaveId(data0.id, arrayList)) {
                    arrayList.add(data0);
                }
            }
            this.adapter.notifyData(arrayList);
            this.mu.setViewState(0);
            if (arrayList.size() == 0) {
                this.mu.setViewState(2);
                return;
            }
            return;
        }
        this.mu.setViewState(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public StudenCenterPresenter createPresenter() {
        return new StudenCenterPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.StudenCenterView
    public void getDataSuccess(StudentCenterRsp studentCenterRsp) {
        Log.e("TAG", "StudentCenterRsp: " + JSON.toJSONString(studentCenterRsp));
    }

    boolean isHaveId(long j, List<StudentMsgBean.Data0> list) {
        Iterator<StudentMsgBean.Data0> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().id == j) {
                return true;
            }
        }
        return false;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
