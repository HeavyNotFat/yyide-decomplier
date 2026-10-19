package com.yd.android_brand_mvp.video1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.utils.VideoUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ViewPagerVideoActivity extends BaseActivity implements ViewPagerMaxAdapter.OnVideoPlay {
    private int CLICK_DELAY_TIME = 500;
    Unbinder bind;

    @BindView(R.id.close)
    TextView close;
    List<VideoListBean.DataBean> dataList;
    int index;
    private long lastClickTime;

    @BindView(R.id.ll_indicator)
    LinearLayout llIndicator;
    private ImageView[] tips;

    @BindView(R.id.view_pager2)
    ViewPager2 viewPager2;
    ViewPagerMaxAdapter viewPagerAdapter;
    int volume;

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_view_pager);
        this.bind = ButterKnife.bind(this);
        initView();
        initData();
    }

    void initData() {
        Bundle bundleExtra = getIntent().getBundleExtra("key");
        this.dataList = (List) bundleExtra.getSerializable("urls");
        this.index = bundleExtra.getInt(FirebaseAnalytics.Param.INDEX);
        List<VideoListBean.DataBean> list = this.dataList;
        if (list == null || list.size() == 0) {
            return;
        }
        ViewPagerMaxAdapter viewPagerMaxAdapter = new ViewPagerMaxAdapter(this.mActivity, this.dataList, this, true);
        this.viewPagerAdapter = viewPagerMaxAdapter;
        viewPagerMaxAdapter.setType(1);
        this.viewPager2.setOrientation(0);
        this.viewPager2.setAdapter(this.viewPagerAdapter);
        this.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.yd.android_brand_mvp.video1.ViewPagerVideoActivity.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                ViewPagerVideoActivity.this.setImageBackground(i);
                if (ViewPagerVideoActivity.this.isNotSelected()) {
                    ViewPagerVideoActivity.this.viewPagerAdapter.playVideo(1000L, i);
                }
                ViewPagerVideoActivity.this.close.setVisibility(8);
            }
        });
        this.close.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.video1.ViewPagerVideoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewPagerVideoActivity.this.finish();
            }
        });
        setIndicator();
        onPlay(this.index);
    }

    public boolean isNotSelected() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - this.lastClickTime >= ((long) this.CLICK_DELAY_TIME);
        this.lastClickTime = jCurrentTimeMillis;
        return z;
    }

    void initView() {
        setAutoClose(false);
        VideoUtils.setVideoState(this);
        this.volume = VideoUtils.getVideoMute(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        initView();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
        GSYVideoManager.releaseAllVideos();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        VideoUtils.setVideoMute(this, this.volume);
        GSYVideoManager.releaseAllVideos();
    }

    @Override // com.yd.android_brand_mvp.video1.ViewPagerMaxAdapter.OnVideoPlay
    public void onPlay(int i) {
        this.viewPager2.setCurrentItem(i);
        if (this.viewPager2.getCurrentItem() == i) {
            this.viewPagerAdapter.notifyItemChanged(i);
            this.viewPagerAdapter.playVideo(1000L, i);
        }
    }

    @Override // com.yd.android_brand_mvp.video1.ViewPagerMaxAdapter.OnVideoPlay
    public void onBottomState(int i) {
        this.close.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageBackground(int i) {
        ImageView[] imageViewArr = this.tips;
        if (imageViewArr == null || imageViewArr.length == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            ImageView[] imageViewArr2 = this.tips;
            if (i2 >= imageViewArr2.length || imageViewArr2[i2] == null) {
                return;
            }
            if (i2 == i) {
                imageViewArr2[i2].setBackgroundResource(R.drawable.bg_img_indicator2);
            } else {
                imageViewArr2[i2].setBackgroundResource(R.drawable.bg_img_indicator1);
            }
            i2++;
        }
    }

    private void setIndicator() {
        this.llIndicator.removeAllViews();
        this.tips = new ImageView[this.dataList.size()];
        for (int i = 0; i < this.dataList.size(); i++) {
            ImageView imageView = new ImageView(this.mActivity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(6, 6);
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
