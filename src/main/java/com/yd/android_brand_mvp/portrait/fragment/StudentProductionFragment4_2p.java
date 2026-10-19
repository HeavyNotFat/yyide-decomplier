package com.yd.android_brand_mvp.portrait.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ViewPagerFragmentAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.landscape.StudentProductionPageFragment;
import com.yd.android_brand_mvp.model.NewWorkCommentRsp;
import com.yd.android_brand_mvp.model.StudentInfoBean;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.presenter.StudentProductionPresenter;
import com.yd.android_brand_mvp.user.StudentProductionActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.StudentProductionView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionFragment4_2p extends BaseMvpFragment<StudentProductionPresenter> implements StudentProductionView {
    int current;
    List<Fragment> fragmentList;
    List<StudentWorkListBean.DataBean.RecordsBean> list;

    @BindView(R.id.ll_indicator)
    LinearLayout llIndicator;
    private ImageView[] tips;

    @BindView(R.id.title)
    TextView tvTitle;
    Unbinder unbinder;

    @BindView(R.id.vp_production)
    ViewPager vpProduction;

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getProductionSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getStudentWorkSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getWorkCommentSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getWorkLikeSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void selectStudentInfoSuccess(StudentInfoBean studentInfoBean) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void selectUserInfoByIcCardSuccess(UserIcCardBean userIcCardBean) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void selectUserInfoByIcCardSuccessFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void setWorkCommentSuccess(NewWorkCommentRsp newWorkCommentRsp) {
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void setWorkLikeSuccess(NewWorkCommentRsp newWorkCommentRsp) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_student_production6_3p, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        this.list = new ArrayList();
    }

    private void initView() {
        this.tvTitle.setText(R.string.st_student_production);
        this.tvTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.StudentProductionFragment4_2p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SpData.getMsgType()) {
                    StudentProductionFragment4_2p.this.startActivityForResult(new Intent(StudentProductionFragment4_2p.this.mActivity, (Class<?>) StudentProductionActivity.class), 200);
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((StudentProductionPresenter) this.mvpPresenter).getStudentWorkList(SpData.getClassesId() + "", this.current);
    }

    private void initData() {
        this.fragmentList = new ArrayList();
        for (int i = 0; i < this.list.size(); i++) {
            this.fragmentList.add(StudentProductionPageFragment.getInstance(this.list.get(i)));
        }
        setIndicator();
        this.vpProduction.setAdapter(new ViewPagerFragmentAdapter(getFragmentManager(), this.fragmentList));
        this.vpProduction.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.StudentProductionFragment4_2p.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                StudentProductionFragment4_2p.this.setImageBackground(i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public StudentProductionPresenter createPresenter() {
        return new StudentProductionPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getStudentWorkSuccess(StudentWorkListBean studentWorkListBean) {
        if (studentWorkListBean == null || studentWorkListBean.data == null) {
            return;
        }
        this.list.clear();
        this.list.addAll(studentWorkListBean.data.list);
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageBackground(int i) {
        int i2 = 0;
        while (true) {
            ImageView[] imageViewArr = this.tips;
            if (i2 >= imageViewArr.length) {
                return;
            }
            if (i2 == i) {
                imageViewArr[i2].setBackgroundResource(R.drawable.bg_img_indicator2);
            } else {
                imageViewArr[i2].setBackgroundResource(R.drawable.bg_img_indicator1);
            }
            i2++;
        }
    }

    private void setIndicator() {
        this.llIndicator.removeAllViews();
        this.tips = new ImageView[this.fragmentList.size()];
        for (int i = 0; i < this.fragmentList.size(); i++) {
            ImageView imageView = new ImageView(this.mActivity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(10, 10);
            layoutParams.setMargins(8, 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setLeft(20);
            ImageView[] imageViewArr = this.tips;
            imageViewArr[i] = imageView;
            if (i == 0) {
                imageViewArr[i].setBackgroundResource(R.drawable.bg_img_indicator1);
            } else {
                imageViewArr[i].setBackgroundResource(R.drawable.bg_img_indicator2);
            }
            this.llIndicator.addView(imageView);
        }
    }
}
