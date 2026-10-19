package com.yd.android_brand_mvp.base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.android.exoplayer2.C;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.dialog.CheackLongDiallog;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.utils.ClickUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.LongClickUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.WeatherUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseLayoutActivity extends BaseActivity {
    public FrameLayout back_layout;

    @BindView(R.id.bg)
    ImageView bg;
    FrameLayout flTitle;

    @BindView(R.id.logo)
    ImageView logo;

    @BindView(R.id.officename)
    TextView officename;
    public RelativeLayout rlBack;
    public TextView title;

    @BindView(R.id.tv_text)
    TextView tv_text;

    @BindView(R.id.wd)
    TextView wd;

    @BindView(R.id.weathericon)
    ImageView weathericon;

    @BindView(R.id.weathertext)
    TextView weathertext;

    @BindView(R.id.wifi)
    ImageView wifi;
    boolean isbtnWifi = true;
    private String rightTextTip = "";

    public int addTitle() {
        return 0;
    }

    protected void clickFinish() {
    }

    public abstract Fragment getFragment();

    public abstract String getName();

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ScreenUtils.isLandscape()) {
            setContentView(R.layout.activity_base_layout);
        } else {
            setContentView(R.layout.activity_base_layout_p);
        }
        adddefaultTitle();
        ButterKnife.bind(this);
        initView();
        setInfo();
        setBg();
        setFragment();
        this.back_layout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.base.BaseLayoutActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseLayoutActivity.this.clickFinish();
                BaseLayoutActivity.this.finish();
            }
        });
        if (ScreenUtils.isLandscape()) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_close);
        this.rlBack = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.base.-$$Lambda$BaseLayoutActivity$va9QnsBXNN_MnjeOeL5P-iMWlE4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$BaseLayoutActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$BaseLayoutActivity(View view) {
        clickFinish();
        finish();
    }

    public void goActivity(Intent intent) {
        if (ClickUtils.isFastClick()) {
            if (SpData.getMsgType()) {
                startActivity(intent);
            } else {
                ToastUtil.showBottomView(this.mActivity, "二级页面已禁用");
            }
        }
    }

    void setBtnEnable(boolean z) {
        this.wifi.setEnabled(z);
    }

    public void setBtn(boolean z) {
        this.isbtnWifi = z;
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        setBtnEnable(true);
    }

    void setBg() {
        String str;
        boolean z = SPUtils.getInstance().getBoolean(SpData.SKIN);
        String stringExtra = getIntent().getStringExtra("drak");
        if ("chemistry".equals(stringExtra)) {
            this.bg.setImageResource(R.drawable.bg_module_chemistry);
            return;
        }
        if ("music".equals(stringExtra)) {
            this.bg.setImageResource(R.drawable.icon_drak_music_bg);
            return;
        }
        if ("machinery".equals(stringExtra)) {
            this.bg.setImageResource(R.drawable.icon_drak_bp_bg);
            return;
        }
        if (z) {
            this.bg.setImageResource(R.drawable.bp_bg);
            this.bg.setBackgroundResource(R.drawable.bp_bg);
            return;
        }
        if (SpData.HomeIndexData() == null || SpData.HomeIndexData().data == null || SpData.HomeIndexData().data.size() <= 0) {
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

    void initView() {
        this.back_layout = (FrameLayout) this.flTitle.findViewById(R.id.back_layout);
        this.title = (TextView) this.flTitle.findViewById(R.id.title_Name);
    }

    void setInfo() {
        this.title.setText(getName());
        if (!TextUtils.isEmpty(getName()) && getName().equals("校历") && SpData.getNcData() != null && SpData.getNcData().data != null && SpData.getNcData().data.semester != null && SpData.getNcData().data.semester.id != null) {
            this.title.setText(SpData.getNcData().data.semester.schoolYear + SpData.getNcData().data.semester.name + "校历");
        }
        if (SpData.getSchoolInfo2() != null && SpData.getSchoolInfo2().data != null) {
            this.officename.setText(SpData.getSchoolInfo2().data.schoolName);
            this.tv_text.setText(SpData.getSchoolInfo2().data.englishName);
            this.tv_text.setVisibility(!TextUtils.isEmpty(SpData.getSchoolInfo2().data.englishName) ? 0 : 8);
            if (!ScreenUtils.isLandscape()) {
                this.tv_text.setVisibility(8);
            }
            GlideUtil.loadCircleImage(this, SpData.getSchoolInfo2().data.schoolLogo, this.logo);
        }
        NewWeatherBean newWeatherBean = (NewWeatherBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.WEATHER_NEW, NewWeatherBean.class);
        if (newWeatherBean != null) {
            this.weathericon.setImageDrawable(getResources().getDrawable(WeatherUtils.imgCode(newWeatherBean.getWeather())));
            this.weathertext.setText(newWeatherBean.getArea() + " " + newWeatherBean.getWeather());
            this.wd.setText(newWeatherBean.getReal());
        }
    }

    void setFragment() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.add(R.id.content, getFragment());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    void adddefaultTitle() {
        View viewInflate;
        int iAddTitle = addTitle();
        if (iAddTitle != 0) {
            viewInflate = LayoutInflater.from(this).inflate(iAddTitle, (ViewGroup) null);
        } else {
            viewInflate = LayoutInflater.from(this).inflate(R.layout.activity_titile_layout, (ViewGroup) null);
            if ("设置".equals(getName())) {
                TextView textView = (TextView) viewInflate.findViewById(R.id.left_view);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.right_view);
                LongClickUtils.setLongClick(new Handler(), textView, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.base.BaseLayoutActivity.2
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        new CheackLongDiallog(BaseLayoutActivity.this.mActivity).show();
                        return true;
                    }
                });
                LongClickUtils.setLongClick(new Handler(), textView2, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.base.BaseLayoutActivity.3
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        new CheackLongDiallog(BaseLayoutActivity.this.mActivity).show();
                        return true;
                    }
                });
            }
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_title);
        this.flTitle = frameLayout;
        frameLayout.addView(viewInflate);
    }

    public void setRightTextView(String str) {
        TextView textView = (TextView) this.flTitle.findViewById(R.id.right_view);
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        }
        textView.setText(str);
    }

    public TextView getRightTextView() {
        return (TextView) this.flTitle.findViewById(R.id.right_view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, com.yd.android_brand_mvp.observer.NetWorkStaus
    public void getWork(boolean z) {
        super.getWork(z);
        if (z) {
            if (Tool.getNetworkAvailableTypeName(this).getTypeName().equals("Ethernet")) {
                this.wifi.setBackgroundResource(R.drawable.network_intneter);
                return;
            }
            int iObtainWifiInfo = Tool.obtainWifiInfo(this);
            if (iObtainWifiInfo == 0) {
                this.wifi.setImageResource(R.drawable.wifi1);
                return;
            }
            if (iObtainWifiInfo == 1) {
                this.wifi.setImageResource(R.drawable.wifi1);
                return;
            }
            if (iObtainWifiInfo == 2) {
                this.wifi.setImageResource(R.drawable.wifi2);
                return;
            }
            if (iObtainWifiInfo == 3) {
                this.wifi.setImageResource(R.drawable.wifi3);
                return;
            } else if (iObtainWifiInfo == 4) {
                this.wifi.setImageResource(R.drawable.wifi4);
                return;
            } else {
                if (iObtainWifiInfo != 5) {
                    return;
                }
                this.wifi.setImageResource(R.drawable.wifi4);
                return;
            }
        }
        this.wifi.setImageResource(R.drawable.wifi_false);
    }
}
