package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
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
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.StudentTaskBean;
import com.yd.android_brand_mvp.presenter.AssignmentPresenter;
import com.yd.android_brand_mvp.user.AsslgnmentWeekActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.view.AssignmentView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentFragment2_3L extends BaseMvpFragment<AssignmentPresenter> implements AssignmentView {
    List<Fragment> fragmentList;
    int layout;
    List<StudentTaskBean.DataBean.WorkBean> list;

    @BindView(R.id.ll_indicator)
    LinearLayout llIndicator;

    @BindView(R.id.mu)
    MultiStateView mu;
    private ImageView[] tips;

    @BindView(R.id.title)
    TextView tvTitle;
    Unbinder unbinder;

    @BindView(R.id.vp_assignment)
    ViewPager vpAssignment;
    private Runnable bannerRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.AssignmentFragment2_3L.4
        @Override // java.lang.Runnable
        public void run() {
            if (AssignmentFragment2_3L.this.vpAssignment == null) {
                return;
            }
            int currentItem = AssignmentFragment2_3L.this.vpAssignment.getCurrentItem() + 1;
            if (currentItem == AssignmentFragment2_3L.this.fragmentList.size()) {
                currentItem = 0;
            }
            AssignmentFragment2_3L.this.vpAssignment.setCurrentItem(currentItem);
            AssignmentFragment2_3L.this.mHandler.postDelayed(AssignmentFragment2_3L.this.bannerRunnable, 60000L);
        }
    };
    private Handler mHandler = new Handler();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public AssignmentPresenter createPresenter() {
        return new AssignmentPresenter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        judgeLandscape();
        View viewInflate = layoutInflater.inflate(this.layout, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    private void judgeLandscape() {
        this.layout = R.layout.fragment_assignment2_3l;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        ((AssignmentPresenter) this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", getDay());
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Zy) {
            ((AssignmentPresenter) this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", getDay());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    private void initView() {
        this.tvTitle.setText(R.string.st_day_assignment);
        this.tvTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.AssignmentFragment2_3L.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AssignmentFragment2_3L.this.goPermissionsActivity(AsslgnmentWeekActivity.class);
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.AssignmentFragment2_3L.2
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((AssignmentPresenter) AssignmentFragment2_3L.this.mvpPresenter).getTaskList(SpData.getClassesId() + "", SpData.getSchoolId() + "", AssignmentFragment2_3L.this.getDay());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDay() {
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        return (intWeek == 1 ? 7 : intWeek - 1) + "";
    }

    private void initData() {
        this.fragmentList = new ArrayList();
        for (int i = 0; i < this.list.size(); i++) {
            this.fragmentList.add(AssignmentPageFragment.getInstance(this.list.get(i)));
        }
        this.mu.setViewState(this.fragmentList.size() == 0 ? 2 : 0);
        if (this.fragmentList.size() > 1) {
            setIndicator();
        }
        this.vpAssignment.setAdapter(new ViewPagerFragmentAdapter(getFragmentManager(), this.fragmentList));
        this.vpAssignment.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.landscape.AssignmentFragment2_3L.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                AssignmentFragment2_3L.this.setImageBackground(i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AssignmentFragment2_3L.this.start();
            }
        });
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(this.bannerRunnable, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageBackground(int i) {
        if (this.tips == null) {
            return;
        }
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
        List<Fragment> list = this.fragmentList;
        if (list == null || list.size() != 1) {
            this.tips = new ImageView[this.fragmentList.size()];
            for (int i = 0; i < this.fragmentList.size(); i++) {
                ImageView imageView = new ImageView(this.mActivity);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(8, 8);
                layoutParams.setMargins(14, 0, 0, 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setLeft(30);
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

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override // com.yd.android_brand_mvp.view.AssignmentView
    public void getTaskListSuccess(StudentTaskBean studentTaskBean) {
        if (studentTaskBean.code == 0 && studentTaskBean.data.list != null) {
            this.mu.setViewState(0);
            ArrayList arrayList = new ArrayList();
            this.list = arrayList;
            arrayList.addAll(studentTaskBean.data.list);
            initData();
            return;
        }
        this.mu.setViewState(2);
    }

    @Override // com.yd.android_brand_mvp.view.AssignmentView
    public void getTaskListSuccessFail(String str) {
        this.mu.setViewState(2);
    }
}
