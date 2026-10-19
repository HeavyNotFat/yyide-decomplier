package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.utils.SpData;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class SiteKBActivity extends BaseLayoutActivity {

    @BindView(R.id.checkbox)
    TextView checkbox;
    com.yd.android_brand_mvp.portrait.fragment.KBFragment kbFragment;

    @BindView(R.id.layoutTop)
    FrameLayout layoutTop;

    @BindView(R.id.left)
    TextView leftBack;

    @BindView(R.id.rb_trimester)
    Button rbTrimester;

    @BindView(R.id.rb_week)
    Button rbWeek;

    @BindView(R.id.rg_check)
    LinearLayout rgCheck;

    @BindView(R.id.rl_check)
    RelativeLayout rl_check;

    @BindView(R.id.rl_rb)
    RelativeLayout rl_rb;

    @BindView(R.id.title_Name)
    TextView title_Name;
    TextView tv_week;

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public int addTitle() {
        return R.layout.schedule_title_layout;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        com.yd.android_brand_mvp.portrait.fragment.KBFragment kBFragment = new com.yd.android_brand_mvp.portrait.fragment.KBFragment();
        this.kbFragment = kBFragment;
        return kBFragment;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tv_week = (TextView) findViewById(R.id.week);
        String stringExtra = getIntent().getStringExtra("drak");
        if ("music".equals(stringExtra) || "chemistry".equals(stringExtra)) {
            this.layoutTop.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_title_drak_music));
            this.leftBack.setBackground(ContextCompat.getDrawable(this, R.drawable.icon_left_black));
            this.title_Name.setTextColor(SkinCompatResources.getInstance().getColor(R.color.text_333333));
            this.tv_week.setTextColor(SkinCompatResources.getInstance().getColor(R.color.text_333333));
            this.checkbox.setTextColor(SkinCompatResources.getInstance().getColor(R.color.text_333333));
            return;
        }
        if ("machinery".equals(stringExtra)) {
            this.layoutTop.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_title_drak));
            this.leftBack.setBackground(getResources().getDrawable(R.drawable.icon_left_wihte));
            this.title_Name.setTextColor(-1);
            this.tv_week.setTextColor(-1);
            this.checkbox.setTextColor(-1);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        return SpData.getSiteName() != null ? SpData.getSiteName() : "场地课表";
    }

    public void setTitle(String str) {
        this.title.setText(str);
    }

    public void setRightTitle(String str) {
        this.tv_week.setText(str);
    }
}
