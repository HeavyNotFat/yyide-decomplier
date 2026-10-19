package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ViewPagerFragmentAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.PhotoAlbumTabBean;
import com.yd.android_brand_mvp.presenter.PhotoAlbumPresenter;
import com.yd.android_brand_mvp.user.PhotoAlbumActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.PhotoAlbumView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumAllFragment extends BaseMvpFragment<PhotoAlbumPresenter> implements PhotoAlbumView, OnTabSelectListener {
    PhotoAlbumActivity activity;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.ctl_tab)
    CommonTabLayout tabLayout;

    @BindView(R.id.vpList)
    ViewPager viewPager;
    List<PhotoAlbumTabBean.DataBean> list = new ArrayList();
    ArrayList<CustomTabEntity> tabEntityList = new ArrayList<>();
    List<Fragment> fragmentList = new ArrayList();

    @Override // com.flyco.tablayout.listener.OnTabSelectListener
    public void onTabReselect(int i) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_all_photo_album, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.activity = (PhotoAlbumActivity) this.mActivity;
        ((PhotoAlbumPresenter) this.mvpPresenter).getPhotoAlbumTablist(SpData.getClassesId() + "", this.activity.kind);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public PhotoAlbumPresenter createPresenter() {
        return new PhotoAlbumPresenter(this);
    }

    void initView() {
        List<PhotoAlbumTabBean.DataBean> list = this.list;
        if (list == null || list.size() == 0) {
            this.mu.setViewState(2);
        } else {
            this.mu.setViewState(0);
        }
        for (final int i = 0; i < this.list.size(); i++) {
            this.tabEntityList.add(new CustomTabEntity() { // from class: com.yd.android_brand_mvp.landscape.PhotoAlbumAllFragment.1
                @Override // com.flyco.tablayout.listener.CustomTabEntity
                public int getTabSelectedIcon() {
                    return 0;
                }

                @Override // com.flyco.tablayout.listener.CustomTabEntity
                public int getTabUnselectedIcon() {
                    return 0;
                }

                @Override // com.flyco.tablayout.listener.CustomTabEntity
                public String getTabTitle() {
                    return PhotoAlbumAllFragment.this.list.get(i).name;
                }
            });
        }
        this.tabLayout.setTabData(this.tabEntityList);
        this.tabLayout.setOnTabSelectListener(this);
        for (int i2 = 0; i2 < this.list.size(); i2++) {
            this.fragmentList.add(PhotoAlbumFragment.newInstance(this.list.get(i2).id + ""));
        }
        this.viewPager.setAdapter(new ViewPagerFragmentAdapter(getChildFragmentManager(), this.fragmentList));
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.landscape.PhotoAlbumAllFragment.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
                PhotoAlbumAllFragment.this.tabLayout.setCurrentTab(i3);
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.PhotoAlbumAllFragment.3
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((PhotoAlbumPresenter) PhotoAlbumAllFragment.this.mvpPresenter).getPhotoAlbumTablist(SpData.getClassesId() + "", PhotoAlbumAllFragment.this.activity.kind);
            }
        });
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.view.PhotoAlbumView
    public void getDataSuccess(PhotoAlbumTabBean photoAlbumTabBean) {
        this.list = photoAlbumTabBean.data;
        initView();
    }

    @Override // com.yd.android_brand_mvp.view.PhotoAlbumView
    public void getFail(String str) {
        this.mu.setViewState(1);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.flyco.tablayout.listener.OnTabSelectListener
    public void onTabSelect(int i) {
        this.viewPager.setCurrentItem(i);
    }
}
