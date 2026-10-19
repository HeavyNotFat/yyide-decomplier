package com.yd.android_brand_mvp.activity.fragment;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDWebView;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolInfoFragment1_ViewBinding implements Unbinder {
    private SchoolInfoFragment1 target;

    public SchoolInfoFragment1_ViewBinding(SchoolInfoFragment1 schoolInfoFragment1, View view) {
        this.target = schoolInfoFragment1;
        schoolInfoFragment1.img = (ImageView) Utils.findRequiredViewAsType(view, R.id.img, "field 'img'", ImageView.class);
        schoolInfoFragment1.school_name = (TextView) Utils.findRequiredViewAsType(view, R.id.school_name, "field 'school_name'", TextView.class);
        schoolInfoFragment1.grid = (GridView) Utils.findRequiredViewAsType(view, R.id.grid, "field 'grid'", GridView.class);
        schoolInfoFragment1.webview = (YDWebView) Utils.findRequiredViewAsType(view, R.id.webview, "field 'webview'", YDWebView.class);
        schoolInfoFragment1.tv_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tv_time'", TextView.class);
        schoolInfoFragment1.tv_sname = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sname, "field 'tv_sname'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SchoolInfoFragment1 schoolInfoFragment1 = this.target;
        if (schoolInfoFragment1 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        schoolInfoFragment1.img = null;
        schoolInfoFragment1.school_name = null;
        schoolInfoFragment1.grid = null;
        schoolInfoFragment1.webview = null;
        schoolInfoFragment1.tv_time = null;
        schoolInfoFragment1.tv_sname = null;
    }
}
