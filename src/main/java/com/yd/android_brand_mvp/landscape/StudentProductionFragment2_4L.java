package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
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
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ViewPagerFragmentAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.NewWorkCommentRsp;
import com.yd.android_brand_mvp.model.StudentInfoBean;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.presenter.StudentProductionPresenter;
import com.yd.android_brand_mvp.user.StudentProductionActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.StudentProductionView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionFragment2_4L extends BaseMvpFragment<StudentProductionPresenter> implements StudentProductionView {
    List<Fragment> fragmentList;
    List<StudentWorkListBean.DataBean.RecordsBean> list;

    @BindView(R.id.ll_indicator2_4L)
    LinearLayout llIndicator;

    @BindView(R.id.mu2_4L)
    MultiStateView mu;
    private ImageView[] tips;

    @BindView(R.id.title)
    TextView tvTitle;
    Unbinder unbinder;

    @BindView(R.id.vp_production2_4L)
    ViewPager vpProduction;
    int current = 1;
    int index = 0;
    Handler handler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment2_4L.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (StudentProductionFragment2_4L.this.list == null || StudentProductionFragment2_4L.this.list.size() <= 0) {
                return;
            }
            if (StudentProductionFragment2_4L.this.list.size() > StudentProductionFragment2_4L.this.index + 1) {
                if (StudentProductionFragment2_4L.this.vpProduction != null) {
                    ViewPager viewPager = StudentProductionFragment2_4L.this.vpProduction;
                    StudentProductionFragment2_4L studentProductionFragment2_4L = StudentProductionFragment2_4L.this;
                    int i = studentProductionFragment2_4L.index + 1;
                    studentProductionFragment2_4L.index = i;
                    viewPager.setCurrentItem(i);
                }
            } else {
                StudentProductionFragment2_4L.this.index = 0;
                if (StudentProductionFragment2_4L.this.vpProduction != null) {
                    StudentProductionFragment2_4L.this.vpProduction.setCurrentItem(StudentProductionFragment2_4L.this.index);
                }
            }
            StudentProductionFragment2_4L.this.handler.postDelayed(StudentProductionFragment2_4L.this.thread, 30000L);
        }
    };
    Thread thread = new Thread() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment2_4L.2
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            StudentProductionFragment2_4L.this.handler.sendMessage(new Message());
        }
    };

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getProductionSuccessFail(String str) {
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate;
        if (ScreenUtils.isLandscape()) {
            viewInflate = layoutInflater.inflate(R.layout.fragment_student_production2_4l, viewGroup, false);
        } else {
            viewInflate = layoutInflater.inflate(R.layout.fragment_student_production4_2p, viewGroup, false);
        }
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        this.list = new ArrayList();
        if (!TextUtils.isEmpty(SpData.getClassesId())) {
            ((StudentProductionPresenter) this.mvpPresenter).getStudentWorkList(SpData.getClassesId() + "", this.current);
            return;
        }
        this.mu.setViewState(2);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i != MinaConstants.Work || TextUtils.isEmpty(SpData.getClassesId())) {
            return;
        }
        ((StudentProductionPresenter) this.mvpPresenter).getStudentWorkList(SpData.getClassesId() + "", this.current);
    }

    private void initView() {
        this.llIndicator.setVisibility(0);
        this.tvTitle.setText(R.string.st_student_production);
        this.tvTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment2_4L.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StudentProductionFragment2_4L.this.goPermissionsActivity(StudentProductionActivity.class);
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment2_4L.4
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                if (TextUtils.isEmpty(SpData.getClassesId())) {
                    return;
                }
                ((StudentProductionPresenter) StudentProductionFragment2_4L.this.mvpPresenter).getStudentWorkList(SpData.getClassesId() + "", StudentProductionFragment2_4L.this.current);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    private void initData() {
        this.fragmentList = new ArrayList();
        for (int i = 0; i < this.list.size(); i++) {
            this.fragmentList.add(StudentProductionPageFragment.getInstance(this.list.get(i)));
        }
        setIndicator();
        this.mu.setViewState(this.fragmentList.size() <= 0 ? 2 : 0);
        this.vpProduction.setAdapter(new ViewPagerFragmentAdapter(getFragmentManager(), this.fragmentList));
        this.vpProduction.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment2_4L.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                StudentProductionFragment2_4L.this.setImageBackground(i2);
                StudentProductionFragment2_4L.this.index = i2;
            }
        });
        this.handler.postDelayed(this.thread, 30000L);
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
        if (studentWorkListBean != null && studentWorkListBean.data != null && studentWorkListBean.code == 0) {
            SPUtils.getInstance().put(SpData.Studentproduction, JSON.toJSONString(studentWorkListBean));
            this.list.clear();
            this.list.addAll(studentWorkListBean.data.list);
            initData();
            return;
        }
        this.mu.setViewState(2);
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void setWorkLikeSuccess(NewWorkCommentRsp newWorkCommentRsp) {
        this.mu.setViewState(3);
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getStudentWorkSuccessFail(String str) {
        if (SpData.getStudentproduction() != null) {
            this.list.clear();
            this.list.addAll(SpData.getStudentproduction().data.list);
            initData();
        } else {
            this.mu.setViewState(1);
            this.llIndicator.setVisibility(8);
        }
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(SizeUtils.dp2px(8.0f), SizeUtils.dp2px(8.0f));
            layoutParams.setMargins(SizeUtils.dp2px(14.0f), 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setLeft(SizeUtils.dp2px(30.0f));
            ImageView[] imageViewArr = this.tips;
            imageViewArr[i] = imageView;
            if (i == 0) {
                imageViewArr[i].setBackgroundResource(R.drawable.bg_img_indicator2);
            } else {
                imageViewArr[i].setBackgroundResource(R.drawable.bg_img_indicator1);
            }
            this.llIndicator.addView(imageView);
        }
    }
}
