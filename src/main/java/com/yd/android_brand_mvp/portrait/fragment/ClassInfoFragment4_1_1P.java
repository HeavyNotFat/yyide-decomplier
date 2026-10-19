package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.model.selectClassesInfoRsp;
import com.yd.android_brand_mvp.presenter.ClassInfoPresenter;
import com.yd.android_brand_mvp.user.ClassInfoActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.ClassInfoView;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment4_1_1P extends BaseMvpFragment<ClassInfoPresenter> implements ClassInfoView {

    @BindView(R.id.tv_class_name)
    TextView tvClassName;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getDataSuccess1(ClassesInfoBean classesInfoBean) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getFail1(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getWatchWordSuccess(NewWatchWordRsp newWatchWordRsp) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_p4x1_1, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        NewClassInfoRsp newClassInfoRsp = SpData.getNewClassInfoRsp();
        if (newClassInfoRsp != null && newClassInfoRsp.data != null) {
            this.tvClassName.setText(TextUtils.isEmpty(newClassInfoRsp.data.classesName) ? "" : newClassInfoRsp.data.classesName);
        }
        ((ClassInfoPresenter) this.mvpPresenter).selectNewClassesInfo();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.ClassInfo) {
            ((ClassInfoPresenter) this.mvpPresenter).getWatchWord(String.valueOf(SpData.getClassesId()));
        } else if (i == MinaConstants.ClassInfoChange) {
            ((ClassInfoPresenter) this.mvpPresenter).selectNewClassesInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public ClassInfoPresenter createPresenter() {
        return new ClassInfoPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.rl_tab})
    public void onClick(View view) {
        if (view.getId() != R.id.rl_tab) {
            return;
        }
        goPermissionsActivity(ClassInfoActivity.class);
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getDataSuccess(NewClassInfoRsp newClassInfoRsp) {
        if (newClassInfoRsp.code != 0 || newClassInfoRsp.data == null) {
            return;
        }
        this.tvClassName.setText(TextUtils.isEmpty(newClassInfoRsp.data.classesName) ? "" : newClassInfoRsp.data.classesName);
    }

    void setClassInfoData(selectClassesInfoRsp selectclassesinforsp) {
        if (selectclassesinforsp.data != null) {
            if (TextUtils.isEmpty(selectclassesinforsp.data.classAlias)) {
                if (TextUtils.isEmpty(selectclassesinforsp.data.classesName)) {
                    this.tvClassName.setText("");
                    return;
                } else {
                    this.tvClassName.setText(selectclassesinforsp.data.classesName);
                    return;
                }
            }
            if (TextUtils.isEmpty(selectclassesinforsp.data.classAlias)) {
                this.tvClassName.setText("");
            } else {
                this.tvClassName.setText(selectclassesinforsp.data.classAlias);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getFail(String str) {
        if (SpData.getClassInfoRsp() != null) {
            setClassInfoData(SpData.getClassInfoRsp());
        }
    }
}
