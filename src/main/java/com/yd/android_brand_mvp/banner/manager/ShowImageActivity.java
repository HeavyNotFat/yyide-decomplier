package com.yd.android_brand_mvp.banner.manager;

import android.os.Bundle;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.WorkRequest;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.to.aboomy.pager2banner.Banner;
import com.to.aboomy.pager2banner.IndicatorView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ImageAdapter;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.listener.AdapterListener;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class ShowImageActivity extends BaseActivity {
    List<String> list;
    Banner mBanner;
    int postion;
    TextView tv_index;

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.list = getIntent().getStringArrayListExtra(TUIKitConstants.Selection.LIST);
        this.postion = getIntent().getIntExtra("postion", this.postion);
        setContentView(R.layout.activity_show_image);
        this.mBanner = (Banner) findViewById(R.id.banner);
        this.tv_index = (TextView) findViewById(R.id.tv_index);
        ImageAdapter imageAdapter = new ImageAdapter(this, null);
        imageAdapter.setAdapterListener(new AdapterListener() { // from class: com.yd.android_brand_mvp.banner.manager.ShowImageActivity.1
            @Override // com.yd.android_brand_mvp.listener.AdapterListener
            public void setOnclick(int i, String str) {
                ShowImageActivity.this.finish();
            }
        });
        new IndicatorView(this);
        this.mBanner.setIndicator(null).setAutoPlay(true).setAutoTurningTime(WorkRequest.MIN_BACKOFF_MILLIS).setAdapter(imageAdapter);
        imageAdapter.setDatas(this.list);
        this.mBanner.setCurrentItem(this.postion + 1);
        if (this.list != null) {
            this.tv_index.setText((this.postion + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.list.size());
        }
        this.mBanner.setOuterPageChangeListener(new ViewPager2.OnPageChangeCallback() { // from class: com.yd.android_brand_mvp.banner.manager.ShowImageActivity.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i, float f, int i2) {
                super.onPageScrolled(i, f, i2);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                if (ShowImageActivity.this.list != null) {
                    ShowImageActivity.this.tv_index.setText((i + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + ShowImageActivity.this.list.size());
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                super.onPageScrollStateChanged(i);
            }
        });
    }
}
