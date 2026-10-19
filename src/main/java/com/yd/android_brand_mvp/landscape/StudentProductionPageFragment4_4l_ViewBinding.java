package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.to.aboomy.pager2banner.Banner;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionPageFragment4_4l_ViewBinding implements Unbinder {
    private StudentProductionPageFragment4_4l target;

    public StudentProductionPageFragment4_4l_ViewBinding(StudentProductionPageFragment4_4l studentProductionPageFragment4_4l, View view) {
        this.target = studentProductionPageFragment4_4l;
        studentProductionPageFragment4_4l.ivHeadPortrait = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_head_portrait, "field 'ivHeadPortrait'", ImageView.class);
        studentProductionPageFragment4_4l.tv_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tv_name'", TextView.class);
        studentProductionPageFragment4_4l.tvPersonalMotto = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_personal_motto, "field 'tvPersonalMotto'", TextView.class);
        studentProductionPageFragment4_4l.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
        studentProductionPageFragment4_4l.mBanner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner, "field 'mBanner'", Banner.class);
        studentProductionPageFragment4_4l.vIsFine = Utils.findRequiredView(view, R.id.v_is_fine, "field 'vIsFine'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentProductionPageFragment4_4l studentProductionPageFragment4_4l = this.target;
        if (studentProductionPageFragment4_4l == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentProductionPageFragment4_4l.ivHeadPortrait = null;
        studentProductionPageFragment4_4l.tv_name = null;
        studentProductionPageFragment4_4l.tvPersonalMotto = null;
        studentProductionPageFragment4_4l.llIndicator = null;
        studentProductionPageFragment4_4l.mBanner = null;
        studentProductionPageFragment4_4l.vIsFine = null;
    }
}
