package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.model.StudentTaskBean;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentPageFragment extends BaseFragment {
    StudentTaskBean.DataBean.WorkBean bean;
    int layout;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.tv_subject)
    TextView tvSubject;

    @BindView(R.id.tv_time)
    TextView tvTime;

    @BindView(R.id.tv_create_people)
    TextView tv_create_people;
    Unbinder unbinder;

    public static AssignmentPageFragment getInstance(StudentTaskBean.DataBean.WorkBean workBean) {
        return new AssignmentPageFragment(workBean);
    }

    public AssignmentPageFragment() {
    }

    public AssignmentPageFragment(StudentTaskBean.DataBean.WorkBean workBean) {
        this.bean = workBean;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        judgeLandscape();
        View viewInflate = layoutInflater.inflate(this.layout, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    private void judgeLandscape() {
        if (ScreenUtils.isLandscape()) {
            this.layout = R.layout.fragment_assignment_page;
        } else {
            this.layout = R.layout.fragment_assignment_page_p;
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
    }

    private void initData() {
        if (this.bean == null) {
            return;
        }
        new StringBuffer();
        this.tvSubject.setText(StringUtils.isEmpty(this.bean.subjectName) ? "" : this.bean.subjectName);
        this.tvTime.setText(StringUtils.isEmpty(this.bean.releaseTime) ? "" : this.bean.releaseTime);
        this.tv_create_people.setText(StringUtils.isEmpty(this.bean.publisherName) ? "" : this.bean.publisherName);
        this.tvContent.setText(StringUtils.isEmpty(this.bean.content) ? "" : this.bean.content);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
