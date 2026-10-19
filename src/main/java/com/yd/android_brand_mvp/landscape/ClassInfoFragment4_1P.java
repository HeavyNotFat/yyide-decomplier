package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.model.selectClassesInfoRsp;
import com.yd.android_brand_mvp.presenter.ClassInfoPresenter;
import com.yd.android_brand_mvp.user.ClassInfoActivity;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.ClassInfoView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment4_1P extends BaseMvpFragment<ClassInfoPresenter> implements ClassInfoView {
    ClassesInfoBean classesInfoBean;

    @BindView(R.id.content)
    LinearLayout content;

    @BindView(R.id.img_head)
    ImageView imgHead;

    @BindView(R.id.tv_class_name)
    TextView tvClassName;

    @BindView(R.id.tv_student_num)
    TextView tvStudentNum;

    @BindView(R.id.tv_teacher_duty)
    TextView tvTeacherDuty;

    @BindView(R.id.tv_teacher_name)
    TextView tvTeacherName;

    @BindView(R.id.tv_teacher_nums)
    TextView tvTeacherNums;
    Unbinder unbinder;
    public String TAG = ClassInfoFragment4_1P.class.getSimpleName();
    List<selectClassesInfoRsp.DataBean.WatchwordsBean> list = new ArrayList();

    private void initWatchWord(NewWatchWordRsp newWatchWordRsp) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getWatchWordSuccess(NewWatchWordRsp newWatchWordRsp) {
    }

    public static Fragment newFragment(String str) {
        ClassInfoFragment4_1P classInfoFragment4_1P = new ClassInfoFragment4_1P();
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        classInfoFragment4_1P.setArguments(bundle);
        return classInfoFragment4_1P;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_p4x1, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null && "sbbjxxfdy41".equals(getArguments().getString("type"))) {
            this.tvTeacherDuty.setText("辅导员");
        } else {
            this.tvTeacherDuty.setText("班主任");
        }
        if (SpData.getNewClassInfoRsp() != null) {
            initClassInfo(SpData.getNewClassInfoRsp());
        }
        if (SpData.getNewWatchWordRsp() != null) {
            initWatchWord(SpData.getNewWatchWordRsp());
        }
        ((ClassInfoPresenter) this.mvpPresenter).selectNewClassesInfo();
        ((ClassInfoPresenter) this.mvpPresenter).getWatchWord(String.valueOf(SpData.getClassesId()));
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

    @OnClick({R.id.ll_tab})
    public void onClick(View view) {
        if (view.getId() == R.id.ll_tab) {
            SPUtils.getInstance().put(SpData.isCounselor, getArguments() != null && "sbbjxxfdy41".equals(getArguments().getString("type")));
            goPermissionsActivity(ClassInfoActivity.class);
        }
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getDataSuccess(NewClassInfoRsp newClassInfoRsp) {
        Log.i(this.TAG, "selectClassesInfoRsp: " + JSON.toJSONString(newClassInfoRsp));
        if (newClassInfoRsp.code != 0 || newClassInfoRsp.data == null) {
            return;
        }
        SPUtils.getInstance().put(SpData.NEWCLASSINFO, JSON.toJSONString(newClassInfoRsp));
        initClassInfo(newClassInfoRsp);
    }

    private void initClassInfo(NewClassInfoRsp newClassInfoRsp) {
        this.tvClassName.setText(TextUtils.isEmpty(newClassInfoRsp.data.classesName) ? "" : newClassInfoRsp.data.classesName);
        this.tvTeacherName.setText(StringUtils.isEmpty(newClassInfoRsp.data.f2016master) ? "无" : newClassInfoRsp.data.f2016master);
        this.tvStudentNum.setText(newClassInfoRsp.data.studentNums + "人");
        this.tvTeacherNums.setText(newClassInfoRsp.data.teacherNums + "人");
        GlideUtil.loadClassImage(this.mActivity, newClassInfoRsp.data.classesIcon, this.imgHead);
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getDataSuccess1(ClassesInfoBean classesInfoBean) {
        if (classesInfoBean == null || classesInfoBean.code.intValue() != BaseConstant.REQUEST_SUCCES2) {
            return;
        }
        SPUtils.getInstance().put(SpData.ClassInfoBean, JSON.toJSONString(classesInfoBean));
        this.classesInfoBean = classesInfoBean;
        this.tvTeacherNums.setText(this.classesInfoBean.data.teacherNums + "人");
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getFail(String str) {
        if (SpData.getNewClassInfoRsp() != null) {
            initClassInfo(SpData.getNewClassInfoRsp());
        }
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getFail1(String str) {
        if (SpData.getNewWatchWordRsp() != null) {
            initWatchWord(SpData.getNewWatchWordRsp());
        }
    }
}
