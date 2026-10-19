package com.yd.android_brand_mvp.landscape;

import android.content.Intent;
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
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
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
public class StudentProductionFragment6_3P extends BaseMvpFragment<StudentProductionPresenter> implements StudentProductionView {
    int current;
    List<Fragment> fragmentList;
    List<StudentWorkListBean.DataBean.RecordsBean> list;

    @BindView(R.id.ll_indicator6_3)
    LinearLayout llIndicator;

    @BindView(R.id.mu6_3)
    MultiStateView mu;
    private ImageView[] tips;

    @BindView(R.id.title)
    TextView tvTitle;

    @BindView(R.id.vp_production6_3)
    ViewPager vpProduction;
    int index = 0;
    Handler handler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment6_3P.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (StudentProductionFragment6_3P.this.list == null || StudentProductionFragment6_3P.this.list.size() <= 0) {
                return;
            }
            if (StudentProductionFragment6_3P.this.list.size() > StudentProductionFragment6_3P.this.index + 1) {
                if (StudentProductionFragment6_3P.this.vpProduction != null) {
                    ViewPager viewPager = StudentProductionFragment6_3P.this.vpProduction;
                    StudentProductionFragment6_3P studentProductionFragment6_3P = StudentProductionFragment6_3P.this;
                    int i = studentProductionFragment6_3P.index + 1;
                    studentProductionFragment6_3P.index = i;
                    viewPager.setCurrentItem(i);
                }
            } else {
                StudentProductionFragment6_3P.this.index = 0;
                if (StudentProductionFragment6_3P.this.vpProduction != null) {
                    StudentProductionFragment6_3P.this.vpProduction.setCurrentItem(StudentProductionFragment6_3P.this.index);
                }
            }
            StudentProductionFragment6_3P.this.handler.postDelayed(StudentProductionFragment6_3P.this.thread, 30000L);
        }
    };
    Thread thread = new Thread() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment6_3P.2
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            StudentProductionFragment6_3P.this.handler.sendMessage(new Message());
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
        if (ScreenUtils.isLandscape()) {
            return null;
        }
        return layoutInflater.inflate(R.layout.fragment_student_production6_3p, viewGroup, false);
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
        this.tvTitle.setText(R.string.st_student_production);
        this.tvTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment6_3P.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SpData.getMsgType()) {
                    StudentProductionFragment6_3P.this.startActivityForResult(new Intent(StudentProductionFragment6_3P.this.mActivity, (Class<?>) StudentProductionActivity.class), 200);
                }
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment6_3P.4
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                if (TextUtils.isEmpty(SpData.getClassesId())) {
                    return;
                }
                ((StudentProductionPresenter) StudentProductionFragment6_3P.this.mvpPresenter).getStudentWorkList(SpData.getClassesId() + "", StudentProductionFragment6_3P.this.current);
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
        this.mu.setViewState(this.fragmentList.size() == 0 ? 2 : 0);
        this.vpProduction.setAdapter(new ViewPagerFragmentAdapter(getFragmentManager(), this.fragmentList));
        this.vpProduction.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment6_3P.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                StudentProductionFragment6_3P.this.setImageBackground(i2);
                StudentProductionFragment6_3P.this.index = i2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public StudentProductionPresenter createPresenter() {
        return new StudentProductionPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getStudentWorkSuccess(StudentWorkListBean studentWorkListBean) {
        if (studentWorkListBean == null || studentWorkListBean.data == null || studentWorkListBean.code != 0) {
            return;
        }
        SPUtils.getInstance().put(SpData.Studentproduction, JSON.toJSONString(studentWorkListBean));
        this.list.clear();
        this.list.addAll(studentWorkListBean.data.list);
        initData();
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void setWorkLikeSuccess(NewWorkCommentRsp newWorkCommentRsp) {
        this.mu.setViewState(1);
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getStudentWorkSuccessFail(String str) {
        if (SpData.getStudentproduction() != null) {
            this.list.clear();
            this.list.addAll(SpData.getStudentproduction().data.list);
            initData();
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
