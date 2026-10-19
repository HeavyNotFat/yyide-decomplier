package com.yd.android_brand_mvp.banner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.widget.ChildViewPager;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator;

/* JADX INFO: loaded from: classes4.dex */
public class ImageItemFragment extends Fragment {
    private static String TYPE_URL = "imgUrl";
    private int currentBannerIndex;
    private MagicIndicator indicatorBanner;
    private List<String> list = new ArrayList();
    private View mView;
    private ChildViewPager mViewpager;

    /* JADX INFO: Access modifiers changed from: private */
    public void startBannerIntervel() {
    }

    public static ImageItemFragment newInstance(String str) {
        ImageItemFragment imageItemFragment = new ImageItemFragment();
        imageItemFragment.setArguments(new Bundle());
        return imageItemFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.image_fragment, viewGroup, false);
        this.mView = viewInflate;
        this.mViewpager = (ChildViewPager) viewInflate.findViewById(R.id.viewpager);
        this.indicatorBanner = (MagicIndicator) this.mView.findViewById(R.id.indicatorBanner);
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.list.add("https://www.goodglasses.com/assets/images/glideonhat.jpg");
        this.list.add("https://www.goodglasses.com/assets/images/glideonhat.jpg");
        this.list.add("https://www.goodglasses.com/assets/images/glideonhat.jpg");
        this.list.add("https://www.goodglasses.com/assets/images/glideonhat.jpg");
        this.list.add("https://www.goodglasses.com/assets/images/glideonhat.jpg");
        CircleNavigator circleNavigator = new CircleNavigator(getContext());
        circleNavigator.setFollowTouch(true);
        circleNavigator.setCircleColor(ContextCompat.getColor(getContext(), R.color.purple2));
        circleNavigator.setCircleCount(this.list.size());
        this.indicatorBanner.setNavigator(circleNavigator);
        this.mViewpager.setAdapter(new PagerAdapter() { // from class: com.yd.android_brand_mvp.banner.ImageItemFragment.1
            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return 5;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public Object instantiateItem(ViewGroup viewGroup, int i) {
                ImageView imageView = new ImageView(viewGroup.getContext());
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(layoutParams);
                GlideUtil.loadNormalImg(imageView, (String) ImageItemFragment.this.list.get(i));
                viewGroup.addView(imageView);
                return imageView;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
                viewGroup.removeView((View) obj);
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public boolean isViewFromObject(View view, Object obj) {
                return view == ((View) obj);
            }
        });
        this.mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.banner.ImageItemFragment.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ImageItemFragment.this.indicatorBanner.onPageScrolled(i % ImageItemFragment.this.list.size(), f, i2);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                ImageItemFragment.this.currentBannerIndex = i;
                ImageItemFragment.this.indicatorBanner.onPageSelected(i % ImageItemFragment.this.list.size());
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                ImageItemFragment.this.indicatorBanner.onPageScrollStateChanged(i);
                if (i != 0) {
                    return;
                }
                ImageItemFragment.this.startBannerIntervel();
            }
        });
        startBannerIntervel();
    }
}
