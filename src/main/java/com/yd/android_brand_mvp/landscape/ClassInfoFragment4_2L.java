package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.presenter.ClassInfoPresenter;
import com.yd.android_brand_mvp.user.ClassInfoActivity;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.ClassInfoView;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment4_2L extends BaseMvpFragment<ClassInfoPresenter> implements ClassInfoView {
    public String TAG = ClassInfoFragment4_2L.class.getSimpleName();

    @BindView(R.id.content)
    FrameLayout content;

    @BindView(R.id.img_head)
    ImageView imgHead;

    @BindView(R.id.ll_class)
    LinearLayout ll_class;

    @BindView(R.id.ll_no)
    LinearLayout ll_no;

    @BindView(R.id.tv_class_name)
    TextView tvClassName;

    @BindView(R.id.tv_student_num)
    TextView tvStudentNum;

    @BindView(R.id.tv_teacher_duty)
    TextView tvTeacherDuty;

    @BindView(R.id.tv_teacher_name)
    TextView tvTeacherName;

    @BindView(R.id.tv_class)
    TextView tv_class;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getDataSuccess1(ClassesInfoBean classesInfoBean) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getFail1(String str) {
    }

    public static Fragment newFragment(String str) {
        ClassInfoFragment4_2L classInfoFragment4_2L = new ClassInfoFragment4_2L();
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        classInfoFragment4_2L.setArguments(bundle);
        return classInfoFragment4_2L;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_l4x2, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
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

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (SpData.getNewClassInfoRsp() != null) {
            initClassInfo(SpData.getNewClassInfoRsp());
        }
        if (getArguments() != null && "hbbjxxfdy42".equals(getArguments().getString("type"))) {
            this.tvTeacherDuty.setText("辅导员");
        } else {
            this.tvTeacherDuty.setText("班主任");
        }
        ((ClassInfoPresenter) this.mvpPresenter).selectNewClassesInfo();
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

    @OnClick({R.id.content})
    public void onClick(View view) {
        if (view.getId() == R.id.content) {
            SPUtils.getInstance().put(SpData.isCounselor, getArguments() != null && "hbbjxxfdy42".equals(getArguments().getString("type")));
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
        if (newClassInfoRsp != null && newClassInfoRsp.data != null) {
            this.tv_class.setVisibility(8);
            this.tvClassName.setText(TextUtils.isEmpty(newClassInfoRsp.data.classesName) ? "" : newClassInfoRsp.data.classesName);
            this.tvTeacherName.setText(TextUtils.isEmpty(newClassInfoRsp.data.f2016master) ? "" : newClassInfoRsp.data.f2016master);
            this.tvStudentNum.setText(newClassInfoRsp.data.studentNums + "人");
            this.imgHead.setVisibility(0);
            GlideUtil.loadClassImage(this.mActivity, newClassInfoRsp.data.classesIcon, this.imgHead);
            if (TextUtils.isEmpty(newClassInfoRsp.data.classesId)) {
                this.tv_class.setVisibility(0);
                this.tv_class.setText(TextUtils.isEmpty(newClassInfoRsp.data.classesName) ? "" : newClassInfoRsp.data.classesName);
                return;
            }
            return;
        }
        this.imgHead.setVisibility(4);
        this.tv_class.setText("");
        this.tvClassName.setText("");
        this.tvTeacherName.setText("");
        this.tvStudentNum.setText("");
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getWatchWordSuccess(NewWatchWordRsp newWatchWordRsp) {
        int i = newWatchWordRsp.code;
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getFail(String str) {
        if (SpData.getNewClassInfoRsp() != null) {
            initClassInfo(SpData.getNewClassInfoRsp());
        }
    }
}
