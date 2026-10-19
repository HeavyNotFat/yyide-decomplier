package com.yd.android_brand_mvp.banner;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import com.flyco.tablayout.SlidingTabLayout;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseActivity;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoActivity extends BaseActivity {

    @BindView(R.id.tablayout)
    SlidingTabLayout mTablayout;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_photo);
        initViewPager();
    }

    private void initViewPager() {
        this.mViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), 1) { // from class: com.yd.android_brand_mvp.banner.PhotoActivity.1
            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return 10;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int i) {
                return "我的相册xx";
            }

            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i) {
                return ImageItemFragment.newInstance("my_release");
            }
        });
        this.mTablayout.setViewPager(this.mViewpager);
    }

    @OnClick({R.id.iv_back})
    public void click() {
        finish();
    }
}
