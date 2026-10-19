package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ViewPagerFragmentAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.NewWorkCommentRsp;
import com.yd.android_brand_mvp.model.StudentInfoBean;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.portrait.fragment.StudentProductionAllPagePFragment;
import com.yd.android_brand_mvp.presenter.StudentProductionPresenter;
import com.yd.android_brand_mvp.utils.PageUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.StudentProductionView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.yd.android_brand_mvp.widget.YDViewPager;
import java.util.ArrayList;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionFragment extends BaseMvpFragment<StudentProductionPresenter> implements StudentProductionView {
    ViewPagerFragmentAdapter adapter;
    StudentWorkListBean bean;
    List<Fragment> fragmentList;

    @BindView(R.id.mu)
    MultiStateView mu;
    StudentWorkListBean.DataBean.RecordsBean recordsBean;

    @BindView(R.id.tv_last)
    TextView tvLast;

    @BindView(R.id.tv_next)
    TextView tvNext;
    Unbinder unbinder;

    @BindView(R.id.vp_stu_production)
    YDViewPager vpStuProduction;
    List<StudentWorkListBean.DataBean.RecordsBean> list = new ArrayList();
    int current = 1;
    int index = 0;

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
            viewInflate = layoutInflater.inflate(R.layout.fragment_student_production, viewGroup, false);
        } else {
            viewInflate = layoutInflater.inflate(R.layout.fragment_student_production_p, viewGroup, false);
        }
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((StudentProductionPresenter) StudentProductionFragment.this.mvpPresenter).getStudentWorkList(SpData.getClassesId() + "", StudentProductionFragment.this.current);
                if (StudentProductionFragment.this.mActivity.isDestroyed()) {
                    return;
                }
                StudentProductionFragment.this.bookLoadingDiallog.show();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((StudentProductionPresenter) this.mvpPresenter).getStudentWorkList(SpData.getClassesId() + "", this.current);
        if (this.mActivity.isDestroyed()) {
            return;
        }
        this.bookLoadingDiallog.show();
    }

    private void initData() {
        Fragment studentProductionAllPagePFragment;
        this.fragmentList = new ArrayList();
        for (int i = 0; i < this.list.size(); i++) {
            if (ScreenUtils.isLandscape()) {
                studentProductionAllPagePFragment = StudentProductionAllPageFragment.getInstance(this.list.get(i));
            } else {
                studentProductionAllPagePFragment = StudentProductionAllPagePFragment.getInstance(this.list.get(i));
            }
            this.fragmentList.add(studentProductionAllPagePFragment);
        }
        this.mu.setViewState(this.fragmentList.size() <= 0 ? 2 : 0);
        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getFragmentManager(), this.fragmentList);
        this.adapter = viewPagerFragmentAdapter;
        this.vpStuProduction.setAdapter(viewPagerFragmentAdapter);
        this.vpStuProduction.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
                StudentProductionFragment.this.index = i2;
                StudentProductionFragment studentProductionFragment = StudentProductionFragment.this;
                studentProductionFragment.recordsBean = studentProductionFragment.list.get(i2);
                StudentProductionFragment.this.setColor();
                if (PageUtils.INSTANCE.doCalculatePageNumber(10, Integer.valueOf(StudentProductionFragment.this.bean.data.total)) <= StudentProductionFragment.this.current || (StudentProductionFragment.this.current * 10) - 2 != StudentProductionFragment.this.index) {
                    return;
                }
                StudentProductionFragment.this.current++;
                ((StudentProductionPresenter) StudentProductionFragment.this.mvpPresenter).getStudentWorkList(SpData.getClassesId() + "", StudentProductionFragment.this.current);
            }
        });
        setColor();
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
        List<StudentWorkListBean.DataBean.RecordsBean> list;
        this.bean = studentWorkListBean;
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.dismiss();
        }
        if (studentWorkListBean != null && studentWorkListBean.data != null) {
            if (this.current == 1 && (list = this.list) != null) {
                list.clear();
            }
            List<StudentWorkListBean.DataBean.RecordsBean> list2 = this.list;
            if (list2 == null) {
                return;
            }
            list2.addAll(studentWorkListBean.data.list);
            initData();
            this.vpStuProduction.setCurrentItem(this.index);
            return;
        }
        this.mu.setViewState(2);
    }

    @OnClick({R.id.tv_last, R.id.tv_next})
    public void onClick(View view) {
        List<Fragment> list;
        int id = view.getId();
        if (id == R.id.tv_last) {
            int i = this.index;
            if (i > 0) {
                int i2 = i - 1;
                this.index = i2;
                this.vpStuProduction.setCurrentItem(i2);
            }
        } else if (id == R.id.tv_next && (list = this.fragmentList) != null && this.index < list.size()) {
            int i3 = this.index + 1;
            this.index = i3;
            this.vpStuProduction.setCurrentItem(i3);
            int iDoCalculatePageNumber = PageUtils.INSTANCE.doCalculatePageNumber(10, Integer.valueOf(this.bean.data.total));
            int i4 = this.current;
            if (iDoCalculatePageNumber > i4 && (i4 * 10) - 2 == this.index) {
                this.current = i4 + 1;
                ((StudentProductionPresenter) this.mvpPresenter).getStudentWorkList(SpData.getClassesId() + "", this.current);
            }
        }
        setColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColor() {
        List<Fragment> list = this.fragmentList;
        if (list == null || list.size() < 1) {
            this.tvLast.setBackgroundResource(R.drawable.bg_rb_ann_23_off_stroke);
            this.tvLast.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            this.tvNext.setBackgroundResource(R.drawable.bg_rb_ann_23_off_stroke);
            this.tvNext.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            return;
        }
        if (this.index > 0) {
            this.tvLast.setBackgroundResource(R.drawable.bg_rb_ann_23_on_stroke);
            TextView textView = this.tvLast;
            SkinCompatResources skinCompatResources = SkinCompatResources.getInstance();
            SpData.isNight();
            textView.setTextColor(skinCompatResources.getColor(R.color.purple2));
        } else {
            this.tvLast.setBackgroundResource(R.drawable.bg_rb_ann_23_off_stroke);
            this.tvLast.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
        }
        if (this.index < this.fragmentList.size() - 1) {
            this.tvNext.setBackgroundResource(R.drawable.bg_rb_ann_23_on_stroke);
            TextView textView2 = this.tvNext;
            SkinCompatResources skinCompatResources2 = SkinCompatResources.getInstance();
            SpData.isNight();
            textView2.setTextColor(skinCompatResources2.getColor(R.color.purple2));
            return;
        }
        this.tvNext.setBackgroundResource(R.drawable.bg_rb_ann_23_off_stroke);
        this.tvNext.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void setWorkLikeSuccess(NewWorkCommentRsp newWorkCommentRsp) {
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.dismiss();
        }
        this.mu.setViewState(3);
    }

    @Override // com.yd.android_brand_mvp.view.StudentProductionView
    public void getStudentWorkSuccessFail(String str) {
        if (this.mActivity.isDestroyed()) {
            return;
        }
        this.bookLoadingDiallog.dismiss();
    }
}
