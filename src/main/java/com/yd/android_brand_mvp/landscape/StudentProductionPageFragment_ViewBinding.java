package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionPageFragment_ViewBinding implements Unbinder {
    private StudentProductionPageFragment target;

    public StudentProductionPageFragment_ViewBinding(StudentProductionPageFragment studentProductionPageFragment, View view) {
        this.target = studentProductionPageFragment;
        studentProductionPageFragment.ivHeadPortrait = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_head_portrait, "field 'ivHeadPortrait'", ImageView.class);
        studentProductionPageFragment.tv_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tv_name'", TextView.class);
        studentProductionPageFragment.tvPersonalMotto = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_personal_motto, "field 'tvPersonalMotto'", TextView.class);
        studentProductionPageFragment.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
        studentProductionPageFragment.mBanner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner, "field 'mBanner'", Banner.class);
        studentProductionPageFragment.vIsFine = Utils.findRequiredView(view, R.id.v_is_fine, "field 'vIsFine'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentProductionPageFragment studentProductionPageFragment = this.target;
        if (studentProductionPageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentProductionPageFragment.ivHeadPortrait = null;
        studentProductionPageFragment.tv_name = null;
        studentProductionPageFragment.tvPersonalMotto = null;
        studentProductionPageFragment.llIndicator = null;
        studentProductionPageFragment.mBanner = null;
        studentProductionPageFragment.vIsFine = null;
    }
}
