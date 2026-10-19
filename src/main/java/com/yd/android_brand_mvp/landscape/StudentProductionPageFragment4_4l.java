package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
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
import com.blankj.utilcode.util.StringUtils;
import com.to.aboomy.pager2banner.Banner;
import com.to.aboomy.pager2banner.IndicatorView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ImageAdapter;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.ArrayList;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionPageFragment4_4l extends BaseFragment {
    StudentWorkListBean.DataBean.RecordsBean dataBean;
    List<ImageView> imageList;

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

    public static StudentProductionPageFragment4_4l getInstance(StudentWorkListBean.DataBean.RecordsBean recordsBean) {
        return new StudentProductionPageFragment4_4l(recordsBean);
    }

    public StudentProductionPageFragment4_4l(StudentWorkListBean.DataBean.RecordsBean recordsBean) {
        this.dataBean = recordsBean;
    }

    public StudentProductionPageFragment4_4l() {
    }

    private void judgeLandscape() {
        if (ScreenUtils.isLandscape()) {
            this.layout = R.layout.student_production_page_44;
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
        initView();
        initData();
    }

    private void initView() {
        this.imageList = new ArrayList();
        initBanner();
    }

    private void initData() {
        this.vIsFine.setVisibility(this.dataBean.isFine ? 0 : 8);
        GlideUtil.loadCircleHeadImage(this.mActivity, this.dataBean.avatar, this.ivHeadPortrait);
        this.tvPersonalMotto.setText(StringUtils.isEmpty(this.dataBean.studentName) ? "" : this.dataBean.studentName);
        this.tv_name.setText(StringUtils.isEmpty(this.dataBean.workName) ? "" : this.dataBean.workName);
        setImageList();
    }

    private void setImageList() {
        if (this.dataBean.worksUrl == null || this.dataBean.worksUrl.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.dataBean.worksUrl.size(); i++) {
            ImageView imageView = new ImageView(this.mActivity);
            GlideUtil.loadNormalImg(imageView, this.dataBean.worksUrl.get(i));
            imageView.setTag(this.dataBean.worksUrl.get(i));
            this.imageList.add(imageView);
        }
    }

    private void initBanner() {
        IndicatorView indicatorSelectorColor = new IndicatorView(this.mActivity).setIndicatorColor(SkinCompatResources.getInstance().getColor(R.color.white)).setIndicatorSelectorColor(SkinCompatResources.getInstance().getColor(R.color.blue3));
        indicatorSelectorColor.setIndicatorRadius(2.0f).setIndicatorSelectedRatio(3.0f).setIndicatorSelectedRadius(2.0f).setIndicatorStyle(4);
        ImageAdapter imageAdapter = new ImageAdapter(requireContext(), null);
        this.mBanner.setIndicator(indicatorSelectorColor).setAutoTurningTime(5000L).setAdapter(imageAdapter);
        imageAdapter.setDatas(this.dataBean.worksUrl);
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
