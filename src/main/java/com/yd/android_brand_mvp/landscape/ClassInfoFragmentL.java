package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.SpacesItemDecoration;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.model.selectClassesInfoRsp;
import com.yd.android_brand_mvp.presenter.ClassInfoPresenter;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.StatusBarUtils;
import com.yd.android_brand_mvp.utils.TeacherNameUtils;
import com.yd.android_brand_mvp.view.ClassInfoView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragmentL extends BaseMvpFragment<ClassInfoPresenter> implements ClassInfoView {
    BaseQuickAdapter adapter;
    ClassesInfoBean classesInfoBean;

    @BindView(R.id.img_head)
    ImageView imgHead;

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
    Unbinder unbinder;
    public String TAG = ClassInfoFragmentL.class.getSimpleName();
    List<selectClassesInfoRsp.DataBean.WatchwordsBean> list = new ArrayList();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate;
        if (ScreenUtils.isLandscape()) {
            viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_l1, viewGroup, false);
        } else {
            viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_p1, viewGroup, false);
        }
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (SPUtils.getInstance().getBoolean(SpData.isCounselor, false)) {
            this.tvTeacherDuty.setText("辅导员");
        } else {
            this.tvTeacherDuty.setText("班主任");
        }
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

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.ClassInfo) {
            ((ClassInfoPresenter) this.mvpPresenter).getWatchWord(String.valueOf(SpData.getClassesId()));
        } else if (i == MinaConstants.ClassInfoChange) {
            ((ClassInfoPresenter) this.mvpPresenter).selectNewClassesInfo();
        }
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        this.recyclerview.setLayoutManager(linearLayoutManager);
        BaseQuickAdapter<NewWatchWordRsp.DataDTO, BaseViewHolder> baseQuickAdapter = new BaseQuickAdapter<NewWatchWordRsp.DataDTO, BaseViewHolder>(R.layout.class_item_info_l) { // from class: com.yd.android_brand_mvp.landscape.ClassInfoFragmentL.1
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
        SPUtils.getInstance().put(SpData.isCounselor, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getDataSuccess(NewClassInfoRsp newClassInfoRsp) {
        Log.e(this.TAG, "selectClassesInfoRspLLL: " + JSON.toJSONString(newClassInfoRsp));
        if (newClassInfoRsp.code != 0 || newClassInfoRsp.data == null) {
            return;
        }
        SPUtils.getInstance().put(SpData.NEWCLASSINFO, JSON.toJSONString(newClassInfoRsp));
        initClassInfo(newClassInfoRsp);
    }

    private void initClassInfo(NewClassInfoRsp newClassInfoRsp) {
        if (newClassInfoRsp.data == null) {
            return;
        }
        this.tvClassName.setText(TextUtils.isEmpty(newClassInfoRsp.data.classesName) ? "" : newClassInfoRsp.data.classesName);
        this.tvStudentNum.setText(newClassInfoRsp.data.studentNums + "人");
        this.tvTeacherNums.setText(newClassInfoRsp.data.teacherNums + "人");
        GlideUtil.loadClassImage(this.mActivity, newClassInfoRsp.data.classesIcon, this.imgHead);
        String teacherNameList = TeacherNameUtils.INSTANCE.getTeacherNameList(newClassInfoRsp.data.f2016master);
        TextView textView = this.tvTeacherName;
        if (StringUtils.isEmpty(teacherNameList)) {
            teacherNameList = "无";
        }
        textView.setText(teacherNameList);
    }

    private void initWatchWord(NewWatchWordRsp newWatchWordRsp) {
        if (newWatchWordRsp.data.size() > 0) {
            this.adapter.setList(newWatchWordRsp.data);
        }
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getWatchWordSuccess(NewWatchWordRsp newWatchWordRsp) {
        if (newWatchWordRsp.code == 0) {
            SPUtils.getInstance().put(SpData.NEWWATCHWORD, JSON.toJSONString(newWatchWordRsp));
            initWatchWord(newWatchWordRsp);
        }
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

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getDataSuccess1(ClassesInfoBean classesInfoBean) {
        if (classesInfoBean == null || classesInfoBean.code.intValue() != BaseConstant.REQUEST_SUCCES2) {
            return;
        }
        this.classesInfoBean = classesInfoBean;
        this.tvTeacherNums.setText(this.classesInfoBean.data.teacherNums + "人");
    }
}
