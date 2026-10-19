package com.yd.android_brand_mvp.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.TeacherAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.TeachersRsp;
import com.yd.android_brand_mvp.presenter.TeachersPresenter;
import com.yd.android_brand_mvp.view.TeachersView;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolInfoFragment2 extends BaseMvpFragment<TeachersPresenter> implements TeachersView {
    TeacherAdapter adapter;

    @BindView(R.id.down)
    CheckedTextView down;

    @BindView(R.id.grid)
    GridView grid;

    @BindView(R.id.index)
    TextView index;
    int pate = 1;
    int sum;

    @BindView(R.id.up)
    CheckedTextView up;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_school_info2, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TeacherAdapter teacherAdapter = new TeacherAdapter(R.layout.layout_teacher_item);
        this.adapter = teacherAdapter;
        this.grid.setAdapter((ListAdapter) teacherAdapter);
        this.up.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.SchoolInfoFragment2.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SchoolInfoFragment2.this.pate != 1) {
                    SchoolInfoFragment2.this.pate--;
                    ((TeachersPresenter) SchoolInfoFragment2.this.mvpPresenter).Teachers(SchoolInfoFragment2.this.pate);
                    if (!SchoolInfoFragment2.this.mActivity.isDestroyed()) {
                        SchoolInfoFragment2.this.bookLoadingDiallog.show();
                    }
                    SchoolInfoFragment2.this.index.setText(SchoolInfoFragment2.this.pate + MqttTopic.TOPIC_LEVEL_SEPARATOR + SchoolInfoFragment2.this.sum);
                }
            }
        });
        this.down.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.SchoolInfoFragment2.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SchoolInfoFragment2.this.down.isChecked() || SchoolInfoFragment2.this.sum < SchoolInfoFragment2.this.pate) {
                    return;
                }
                SchoolInfoFragment2.this.pate++;
                ((TeachersPresenter) SchoolInfoFragment2.this.mvpPresenter).Teachers(SchoolInfoFragment2.this.pate);
                if (!SchoolInfoFragment2.this.mActivity.isDestroyed()) {
                    SchoolInfoFragment2.this.bookLoadingDiallog.show();
                }
                SchoolInfoFragment2.this.index.setText(SchoolInfoFragment2.this.pate + MqttTopic.TOPIC_LEVEL_SEPARATOR + SchoolInfoFragment2.this.sum);
            }
        });
        ((TeachersPresenter) this.mvpPresenter).Teachers(this.pate);
        if (this.mActivity.isDestroyed()) {
            return;
        }
        this.bookLoadingDiallog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public TeachersPresenter createPresenter() {
        return new TeachersPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.TeachersView
    public void teachersSuccess(TeachersRsp teachersRsp) {
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.dismiss();
        }
        if (teachersRsp.code.intValue() == 0) {
            this.adapter.notifyData(teachersRsp.data.list);
            this.up.setChecked(this.pate == 1);
            int iCeil = (int) Math.ceil((((double) teachersRsp.data.total.intValue()) * 1.0d) / ((double) teachersRsp.data.pageSize.intValue()));
            this.sum = iCeil;
            this.down.setChecked(this.pate >= iCeil);
            this.index.setText(this.pate + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.sum);
        }
    }

    @Override // com.yd.android_brand_mvp.view.TeachersView
    public void teachersFail(String str) {
        if (this.mActivity.isDestroyed()) {
            return;
        }
        this.bookLoadingDiallog.dismiss();
    }
}
