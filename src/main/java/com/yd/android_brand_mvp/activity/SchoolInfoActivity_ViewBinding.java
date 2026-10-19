package com.yd.android_brand_mvp.activity;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolInfoActivity_ViewBinding implements Unbinder {
    private SchoolInfoActivity target;

    public SchoolInfoActivity_ViewBinding(SchoolInfoActivity schoolInfoActivity) {
        this(schoolInfoActivity, schoolInfoActivity.getWindow().getDecorView());
    }

    public SchoolInfoActivity_ViewBinding(SchoolInfoActivity schoolInfoActivity, View view) {
        this.target = schoolInfoActivity;
        schoolInfoActivity.logo = (ImageView) Utils.findRequiredViewAsType(view, R.id.logo, "field 'logo'", ImageView.class);
        schoolInfoActivity.officename = (TextView) Utils.findRequiredViewAsType(view, R.id.officename, "field 'officename'", TextView.class);
        schoolInfoActivity.back_layout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.back_layout, "field 'back_layout'", FrameLayout.class);
        schoolInfoActivity.weathertext = (TextView) Utils.findRequiredViewAsType(view, R.id.weathertext, "field 'weathertext'", TextView.class);
        schoolInfoActivity.weathericon = (ImageView) Utils.findRequiredViewAsType(view, R.id.weathericon, "field 'weathericon'", ImageView.class);
        schoolInfoActivity.tab1 = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.tab1, "field 'tab1'", CheckedTextView.class);
        schoolInfoActivity.tab2 = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.tab2, "field 'tab2'", CheckedTextView.class);
        schoolInfoActivity.weatherlayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.weatherlayout, "field 'weatherlayout'", LinearLayout.class);
        schoolInfoActivity.bg = (ImageView) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", ImageView.class);
        schoolInfoActivity.tv_text = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tv_text'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SchoolInfoActivity schoolInfoActivity = this.target;
        if (schoolInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        schoolInfoActivity.logo = null;
        schoolInfoActivity.officename = null;
        schoolInfoActivity.back_layout = null;
        schoolInfoActivity.weathertext = null;
        schoolInfoActivity.weathericon = null;
        schoolInfoActivity.tab1 = null;
        schoolInfoActivity.tab2 = null;
        schoolInfoActivity.weatherlayout = null;
        schoolInfoActivity.bg = null;
        schoolInfoActivity.tv_text = null;
    }
}
