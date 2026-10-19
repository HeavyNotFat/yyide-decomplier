package com.yd.android_brand_mvp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.fragment.SchoolInfoFragment1;
import com.yd.android_brand_mvp.activity.fragment.SchoolInfoFragment2;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.portrait.fragment.SchoolInfoFragment1P;
import com.yd.android_brand_mvp.portrait.fragment.SchoolInfoFragment2P;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.WeatherUtils;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolInfoActivity extends BaseActivity {

    @BindView(R.id.back_layout)
    FrameLayout back_layout;

    @BindView(R.id.bg)
    ImageView bg;

    @BindView(R.id.logo)
    ImageView logo;

    @BindView(R.id.officename)
    TextView officename;

    @BindView(R.id.tab1)
    CheckedTextView tab1;

    @BindView(R.id.tab2)
    CheckedTextView tab2;

    @BindView(R.id.tv_text)
    TextView tv_text;

    @BindView(R.id.weathericon)
    ImageView weathericon;

    @BindView(R.id.weatherlayout)
    LinearLayout weatherlayout;

    @BindView(R.id.weathertext)
    TextView weathertext;

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ScreenUtils.isLandscape()) {
            setContentView(R.layout.activity_school_info_layout);
        } else {
            setContentView(R.layout.activity_school_info_layout_p);
        }
        ButterKnife.bind(this);
        setInfo();
        this.back_layout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.SchoolInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SchoolInfoActivity.this.finish();
            }
        });
        this.tab1.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.SchoolInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SchoolInfoActivity.this.setTab(0);
            }
        });
        this.tab2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.SchoolInfoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SchoolInfoActivity.this.setTab(1);
            }
        });
        if (!ScreenUtils.isLandscape()) {
            this.back_layout.setVisibility(8);
            findViewById(R.id.rl_close).setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.SchoolInfoActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SchoolInfoActivity.this.finish();
                }
            });
        }
        setTab(0);
        setBg();
        LogUtils.e("SchoolInfoActivity", "学校信息页面");
    }

    public void setCheck(int i) {
        setTab(i);
    }

    void setBg() {
        String str;
        if (SPUtils.getInstance().getBoolean(SpData.SKIN)) {
            this.bg.setImageResource(R.drawable.bp_bg);
            this.bg.setBackgroundResource(R.drawable.bp_bg);
            return;
        }
        if (SpData.HomeIndexData() == null || SpData.HomeIndexData().data.size() <= 0) {
            return;
        }
        String str2 = null;
        if (SpData.HomeIndexData().data.get(0).layoutClassSignDetailsEntityList.size() > 0) {
            str2 = SpData.HomeIndexData().data.get(0).layoutClassSignDetailsEntityList.get(0).backgropPhoto;
            str = SpData.HomeIndexData().data.get(0).layoutClassSignDetailsEntityList.get(0).backgropColour;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            GlideUtil.loadNomalImage(this, str2, this.bg);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.bg.setBackgroundColor(Color.parseColor(str));
        }
    }

    void setInfo() {
        if (SpData.getSchoolInfo2() != null && SpData.getSchoolInfo2().data != null) {
            this.officename.setText(SpData.getSchoolInfo2().data.schoolName);
            GlideUtil.loadCircleImage(this, SpData.getSchoolInfo2().data.schoolLogo, this.logo);
            this.tv_text.setText(SpData.getSchoolInfo2().data.englishName);
            this.tv_text.setVisibility(!TextUtils.isEmpty(SpData.getSchoolInfo2().data.englishName) ? 0 : 8);
            if (!ScreenUtils.isLandscape()) {
                this.tv_text.setVisibility(8);
            }
        }
        NewWeatherBean newWeatherBean = (NewWeatherBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.WEATHER_NEW, NewWeatherBean.class);
        if (newWeatherBean != null) {
            this.weathericon.setImageDrawable(WeatherUtils.imgCode_y(this, newWeatherBean.getWeather()));
            this.weathertext.setText(newWeatherBean.getWeather());
        }
    }

    void setTab(int i) {
        Fragment schoolInfoFragment1P;
        Fragment schoolInfoFragment2P;
        this.tab1.setChecked(false);
        this.tab2.setChecked(false);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(String.valueOf(this.tab1.getId()));
        Fragment fragmentFindFragmentByTag2 = supportFragmentManager.findFragmentByTag(String.valueOf(this.tab2.getId()));
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag);
        }
        if (fragmentFindFragmentByTag2 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
        }
        if (i == 0) {
            if (fragmentFindFragmentByTag == null) {
                if (ScreenUtils.isLandscape()) {
                    schoolInfoFragment1P = new SchoolInfoFragment1();
                } else {
                    schoolInfoFragment1P = new SchoolInfoFragment1P();
                }
                fragmentTransactionBeginTransaction.add(R.id.content, schoolInfoFragment1P, String.valueOf(this.tab1.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag);
            }
            this.tab1.setChecked(true);
            this.tab1.setTextSize(SizeUtils.px2sp(20.0f));
            this.tab2.setTextSize(SizeUtils.px2sp(20.0f));
        } else if (i == 1) {
            if (fragmentFindFragmentByTag2 == null) {
                if (ScreenUtils.isLandscape()) {
                    schoolInfoFragment2P = new SchoolInfoFragment2();
                } else {
                    schoolInfoFragment2P = new SchoolInfoFragment2P();
                }
                fragmentTransactionBeginTransaction.add(R.id.content, schoolInfoFragment2P, String.valueOf(this.tab2.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
            }
            this.tab2.setChecked(true);
            this.tab2.setTextSize(SizeUtils.px2sp(20.0f));
            this.tab1.setTextSize(SizeUtils.px2sp(20.0f));
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
