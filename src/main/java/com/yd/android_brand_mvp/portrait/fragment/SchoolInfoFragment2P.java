package com.yd.android_brand_mvp.portrait.fragment;

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
import com.yd.android_brand_mvp.activity.SchoolInfoActivity;
import com.yd.android_brand_mvp.adapter.TeacherAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.TeachersRsp;
import com.yd.android_brand_mvp.presenter.TeachersPresenter;
import com.yd.android_brand_mvp.view.TeachersView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolInfoFragment2P extends BaseMvpFragment<TeachersPresenter> implements TeachersView {
    SchoolInfoActivity activity;
    TeacherAdapter adapter;

    @BindView(R.id.down)
    CheckedTextView down;

    @BindView(R.id.grid)
    GridView grid;

    @BindView(R.id.index)
    TextView index;

    @BindView(R.id.mu)
    MultiStateView mu;
    int pate = 1;

    @BindView(R.id.rb_tab1)
    TextView rb_tab1;
    int sum;

    @BindView(R.id.up)
    CheckedTextView up;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_school_info2_p, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TeacherAdapter teacherAdapter = new TeacherAdapter(R.layout.layout_teacher_item_p);
        this.adapter = teacherAdapter;
        this.grid.setAdapter((ListAdapter) teacherAdapter);
        this.activity = (SchoolInfoActivity) this.mActivity;
        this.up.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.SchoolInfoFragment2P.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SchoolInfoFragment2P.this.pate != 1) {
                    SchoolInfoFragment2P.this.pate--;
                    ((TeachersPresenter) SchoolInfoFragment2P.this.mvpPresenter).Teachers(SchoolInfoFragment2P.this.pate);
                    if (!SchoolInfoFragment2P.this.mActivity.isDestroyed()) {
                        SchoolInfoFragment2P.this.bookLoadingDiallog.show();
                    }
                    SchoolInfoFragment2P.this.index.setText(SchoolInfoFragment2P.this.pate + MqttTopic.TOPIC_LEVEL_SEPARATOR + SchoolInfoFragment2P.this.sum);
                }
            }
        });
        this.down.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.SchoolInfoFragment2P.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SchoolInfoFragment2P.this.down.isChecked()) {
                    SchoolInfoFragment2P.this.pate++;
                    ((TeachersPresenter) SchoolInfoFragment2P.this.mvpPresenter).Teachers(SchoolInfoFragment2P.this.pate);
                    if (!SchoolInfoFragment2P.this.mActivity.isDestroyed()) {
                        SchoolInfoFragment2P.this.bookLoadingDiallog.show();
                    }
                    SchoolInfoFragment2P.this.index.setText(SchoolInfoFragment2P.this.pate + MqttTopic.TOPIC_LEVEL_SEPARATOR + SchoolInfoFragment2P.this.sum);
                }
            }
        });
        this.rb_tab1.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.SchoolInfoFragment2P.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SchoolInfoFragment2P.this.activity.setCheck(0);
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.portrait.fragment.SchoolInfoFragment2P.4
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((TeachersPresenter) SchoolInfoFragment2P.this.mvpPresenter).Teachers(SchoolInfoFragment2P.this.pate);
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
            this.down.setChecked(this.pate != iCeil);
            this.index.setText(this.pate + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.sum);
            if (teachersRsp.data.list == null) {
                this.mu.setViewState(2);
                return;
            } else {
                this.mu.setViewState(teachersRsp.data.list.size() > 0 ? 0 : 2);
                return;
            }
        }
        this.mu.setViewState(2);
        this.up.setChecked(false);
        this.down.setChecked(false);
        this.index.setText("0/0");
    }

    @Override // com.yd.android_brand_mvp.view.TeachersView
    public void teachersFail(String str) {
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.dismiss();
        }
        this.adapter.notifyData(new ArrayList());
        this.up.setChecked(false);
        this.down.setChecked(false);
        this.index.setText("0/0");
        this.mu.setViewState(1);
    }
}
