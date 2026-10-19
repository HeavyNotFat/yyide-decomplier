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
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.SpacesItemDecoration;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.model.selectClassesInfoRsp;
import com.yd.android_brand_mvp.presenter.ClassInfoPresenter;
import com.yd.android_brand_mvp.user.ClassInfoActivity;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.StatusBarUtils;
import com.yd.android_brand_mvp.view.ClassInfoView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoFragment6_2P extends BaseMvpFragment<ClassInfoPresenter> implements ClassInfoView {
    BaseQuickAdapter adapter;

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

    @BindView(R.id.tv_class)
    TextView tv_class;
    Unbinder unbinder;
    public String TAG = ClassInfoFragment6_2P.class.getSimpleName();
    List<selectClassesInfoRsp.DataBean.WatchwordsBean> list = new ArrayList();

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getDataSuccess1(ClassesInfoBean classesInfoBean) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getFail1(String str) {
    }

    public static Fragment newFragment(String str) {
        ClassInfoFragment6_2P classInfoFragment6_2P = new ClassInfoFragment6_2P();
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        classInfoFragment6_2P.setArguments(bundle);
        return classInfoFragment6_2P;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_l6_2, viewGroup, false);
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
        if (getArguments() != null && "sbbjxxfdy62".equals(getArguments().getString("type"))) {
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

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
        linearLayoutManager.setOrientation(1);
        this.recyclerview.setLayoutManager(linearLayoutManager);
        BaseQuickAdapter<NewWatchWordRsp.DataDTO, BaseViewHolder> baseQuickAdapter = new BaseQuickAdapter<NewWatchWordRsp.DataDTO, BaseViewHolder>(R.layout.class_item_info) { // from class: com.yd.android_brand_mvp.landscape.ClassInfoFragment6_2P.1
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
        if (view.getId() == R.id.ll_tab) {
            SPUtils.getInstance().put(SpData.isCounselor, getArguments() != null && "sbbjxxfdy62".equals(getArguments().getString("type")));
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
            this.tvTeacherName.setText(StringUtils.isEmpty(newClassInfoRsp.data.f2016master) ? "" : newClassInfoRsp.data.f2016master);
            this.tvStudentNum.setText(newClassInfoRsp.data.studentNums + "人");
            this.imgHead.setVisibility(0);
            GlideUtil.loadClassImage(this.mActivity, newClassInfoRsp.data.classesIcon, this.imgHead);
            if (StringUtils.isEmpty(newClassInfoRsp.data.classesId)) {
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

    private void initWatchWord(NewWatchWordRsp newWatchWordRsp) {
        this.adapter.setList(newWatchWordRsp.data);
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getWatchWordSuccess(NewWatchWordRsp newWatchWordRsp) {
        if (newWatchWordRsp.code == 0) {
            SPUtils.getInstance().put(SpData.NEWWATCHWORD, JSON.toJSONString(newWatchWordRsp));
            initWatchWord(newWatchWordRsp);
        }
    }
}
