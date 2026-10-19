package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.SpacesItemDecoration;
import com.yd.android_brand_mvp.landscape.ClassInfoFragment2_4L;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.presenter.ClassInfoPresenter;
import com.yd.android_brand_mvp.user.ClassInfoActivity;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.StatusBarUtils;
import com.yd.android_brand_mvp.view.ClassInfoView;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment2_2P extends BaseMvpFragment<ClassInfoPresenter> implements ClassInfoView {
    public String TAG = ClassInfoFragment2_4L.class.getSimpleName();
    BaseQuickAdapter adapter;
    ClassesInfoBean classesInfoBean;

    @BindView(R.id.content)
    LinearLayout content;

    @BindView(R.id.img_head)
    ImageView imgHead;

    @BindView(R.id.ll_no)
    LinearLayout ll_no;

    @BindView(R.id.recyleview)
    RecyclerView recyclerview;

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

    @BindView(R.id.tv_class)
    TextView tv_class;
    Unbinder unbinder;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.p_fragment_class_info2_2, viewGroup, false);
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
        initAdapter();
        if (SpData.getNewClassInfoRsp() != null) {
            initClassInfo(SpData.getNewClassInfoRsp());
        }
        if (SpData.getNewWatchWordRsp() != null) {
            initWatchWord(SpData.getNewWatchWordRsp());
        }
        ((ClassInfoPresenter) this.mvpPresenter).selectNewClassesInfo();
        ((ClassInfoPresenter) this.mvpPresenter).getWatchWord(String.valueOf(SpData.getClassesId()));
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        this.recyclerview.setLayoutManager(linearLayoutManager);
        BaseQuickAdapter<NewWatchWordRsp.DataDTO, BaseViewHolder> baseQuickAdapter = new BaseQuickAdapter<NewWatchWordRsp.DataDTO, BaseViewHolder>(R.layout.class_item_info_p) { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassInfoFragment2_2P.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder baseViewHolder, NewWatchWordRsp.DataDTO dataDTO) {
                baseViewHolder.setText(R.id.item, dataDTO.project + Constants.COLON_SEPARATOR);
                baseViewHolder.setText(R.id.item2, dataDTO.projectValue);
            }
        };
        this.adapter = baseQuickAdapter;
        this.recyclerview.setAdapter(baseQuickAdapter);
        this.recyclerview.addItemDecoration(new SpacesItemDecoration(StatusBarUtils.dip2px(this.mActivity, 1.0f)));
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
        if (view.getId() != R.id.ll_tab) {
            return;
        }
        goPermissionsActivity(ClassInfoActivity.class);
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
        if (newClassInfoRsp.data != null) {
            this.tv_class.setVisibility(8);
            this.tvClassName.setText(TextUtils.isEmpty(newClassInfoRsp.data.classesName) ? "" : newClassInfoRsp.data.classesName);
            this.tvTeacherNums.setText(newClassInfoRsp.data.teacherNums + "人");
            this.tvTeacherName.setText(StringUtils.isEmpty(newClassInfoRsp.data.f2016master) ? "无" : newClassInfoRsp.data.f2016master);
            this.tvStudentNum.setText(newClassInfoRsp.data.studentNums + "");
            GlideUtil.loadClassImage(this.mActivity, newClassInfoRsp.data.classesIcon, this.imgHead);
            if (StringUtils.isEmpty(newClassInfoRsp.data.classesId)) {
                this.tv_class.setVisibility(0);
                this.tv_class.setText(TextUtils.isEmpty(newClassInfoRsp.data.classesName) ? "" : newClassInfoRsp.data.classesName);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getWatchWordSuccess(NewWatchWordRsp newWatchWordRsp) {
        if (newWatchWordRsp.code == 0) {
            SPUtils.getInstance().put(SpData.NEWWATCHWORD, JSON.toJSONString(newWatchWordRsp));
            initWatchWord(newWatchWordRsp);
        }
    }

    private void initWatchWord(NewWatchWordRsp newWatchWordRsp) {
        if (newWatchWordRsp.data.size() > 0) {
            this.adapter.setList(newWatchWordRsp.data);
        }
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
