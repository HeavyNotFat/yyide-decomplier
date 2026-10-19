package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleActivity extends BaseLayoutActivity {

    @BindView(R.id.checkbox)
    TextView checkbox;

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
    com.yd.android_brand_mvp.activity.fragment.ClassScheduleFragment scheduleFragment;
    TextView tv_week;

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public int addTitle() {
        return R.layout.schedule_title_layout;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        return "课表";
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        com.yd.android_brand_mvp.activity.fragment.ClassScheduleFragment classScheduleFragment = new com.yd.android_brand_mvp.activity.fragment.ClassScheduleFragment();
        this.scheduleFragment = classScheduleFragment;
        return classScheduleFragment;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setScheduleState(1);
    }

    public void setTitle(String str) {
        this.title.setText(str);
    }

    public void setRightTitle(String str) {
        TextView textView = (TextView) findViewById(R.id.week);
        this.tv_week = textView;
        textView.setText(str);
    }

    @OnClick({R.id.checkbox, R.id.rb_week, R.id.rb_trimester})
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.checkbox) {
            if (id == R.id.rb_trimester) {
                this.scheduleFragment.setNextWeek();
                return;
            } else {
                if (id != R.id.rb_week) {
                    return;
                }
                this.scheduleFragment.setLastWeek();
                return;
            }
        }
        if (this.title.getText().equals("单周课表")) {
            this.scheduleFragment.setCheckAdapter(2);
            this.title.setText("双周课表");
            this.checkbox.setText("切换单周");
        } else {
            this.scheduleFragment.setCheckAdapter(1);
            this.title.setText("单周课表");
            this.checkbox.setText("切换双周");
        }
    }

    public void setScheduleState(int i) {
        this.rl_check.setVisibility(i == 1 ? 0 : 8);
        this.rl_rb.setVisibility(i != 2 ? 8 : 0);
    }

    public void setCheckBox(int i) {
        this.checkbox.setText(i % 2 == 0 ? "切换单周" : "切换双周");
    }

    public void setColor(int i, int i2) {
        if (i < 1) {
            this.rbWeek.setBackgroundResource(R.drawable.bg_rb_ann_23_off_stroke);
            this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            this.rbTrimester.setBackgroundResource(R.drawable.bg_rb_ann_23_off_stroke);
            this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
            return;
        }
        if (i2 > 1) {
            this.rbWeek.setBackgroundResource(R.drawable.bg_rb_ann_23_on_stroke);
            this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        } else {
            this.rbWeek.setBackgroundResource(R.drawable.bg_rb_ann_23_off_stroke);
            this.rbWeek.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
        }
        if (i2 < i) {
            this.rbTrimester.setBackgroundResource(R.drawable.bg_rb_ann_23_on_stroke);
            this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        } else {
            this.rbTrimester.setBackgroundResource(R.drawable.bg_rb_ann_23_off_stroke);
            this.rbTrimester.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
        }
    }
}
