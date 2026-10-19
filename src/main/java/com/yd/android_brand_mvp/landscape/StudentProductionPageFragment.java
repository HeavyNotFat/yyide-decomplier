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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ImageAdapter;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionPageFragment extends BaseFragment {

    @BindView(R.id.iv_head_portrait)
    ImageView ivHeadPortrait;
    int layout;

    @BindView(R.id.ll_indicator)
    LinearLayout llIndicator;

    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.tv_personal_motto)
    TextView tvPersonalMotto;

    @BindView(R.id.tv_name)
    TextView tv_name;
    Unbinder unbinder;

    @BindView(R.id.v_is_fine)
    View vIsFine;

    public static StudentProductionPageFragment getInstance(StudentWorkListBean.DataBean.RecordsBean recordsBean) {
        StudentProductionPageFragment studentProductionPageFragment = new StudentProductionPageFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("dataBean", recordsBean);
        studentProductionPageFragment.setArguments(bundle);
        return studentProductionPageFragment;
    }

    private void judgeLandscape() {
        if (ScreenUtils.isLandscape()) {
            this.layout = R.layout.student_production_page;
        } else {
            this.layout = R.layout.student_production_page_p;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        judgeLandscape();
        View viewInflate = layoutInflater.inflate(this.layout, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
    }

    private void initData() {
        StudentWorkListBean.DataBean.RecordsBean recordsBean;
        if (getArguments() != null) {
            recordsBean = (StudentWorkListBean.DataBean.RecordsBean) getArguments().getSerializable("dataBean");
            Log.d("StudentProductionPage", "学生评价= " + GsonUtils.toJson(recordsBean));
        } else {
            recordsBean = null;
        }
        this.mBanner.addBannerLifecycleObserver(this).setStartPosition(1).setAdapter(new ImageAdapter(requireContext(), null)).isAutoLoop(true).setLoopTime(5000L).setIndicator(new CircleIndicator(requireContext())).setIndicatorGravity(1).setIndicatorSpace(BannerUtils.dp2px(10.0f)).setIndicatorNormalColor(getResources().getColor(R.color.gray)).setIndicatorSelectedColor(getResources().getColor(R.color.blue12)).setIndicatorWidth(BannerUtils.dp2px(8.0f), BannerUtils.dp2px(8.0f)).setIndicatorHeight(BannerUtils.dp2px(8.0f));
        if (recordsBean != null) {
            this.vIsFine.setVisibility(recordsBean.isFine ? 0 : 8);
            GlideUtil.loadCircleHeadImage(this.mActivity, recordsBean.avatar, this.ivHeadPortrait);
            this.tvPersonalMotto.setText(TextUtils.isEmpty(recordsBean.studentName) ? "" : recordsBean.studentName);
            this.tv_name.setText(TextUtils.isEmpty(recordsBean.workName) ? "" : recordsBean.workName);
            this.mBanner.setDatas(recordsBean.worksUrl);
        }
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
