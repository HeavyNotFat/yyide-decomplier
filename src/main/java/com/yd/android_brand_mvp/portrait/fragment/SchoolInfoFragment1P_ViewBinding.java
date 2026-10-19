package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDWebView;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolInfoFragment1P_ViewBinding implements Unbinder {
    private SchoolInfoFragment1P target;

    public SchoolInfoFragment1P_ViewBinding(SchoolInfoFragment1P schoolInfoFragment1P, View view) {
        this.target = schoolInfoFragment1P;
        schoolInfoFragment1P.img = (ImageView) Utils.findRequiredViewAsType(view, R.id.img, "field 'img'", ImageView.class);
        schoolInfoFragment1P.school_name = (TextView) Utils.findRequiredViewAsType(view, R.id.school_name, "field 'school_name'", TextView.class);
        schoolInfoFragment1P.grid = (GridView) Utils.findRequiredViewAsType(view, R.id.grid, "field 'grid'", GridView.class);
        schoolInfoFragment1P.webview = (YDWebView) Utils.findRequiredViewAsType(view, R.id.webview, "field 'webview'", YDWebView.class);
        schoolInfoFragment1P.tv_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tv_time'", TextView.class);
        schoolInfoFragment1P.tv_sname = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sname, "field 'tv_sname'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SchoolInfoFragment1P schoolInfoFragment1P = this.target;
        if (schoolInfoFragment1P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        schoolInfoFragment1P.img = null;
        schoolInfoFragment1P.school_name = null;
        schoolInfoFragment1P.grid = null;
        schoolInfoFragment1P.webview = null;
        schoolInfoFragment1P.tv_time = null;
        schoolInfoFragment1P.tv_sname = null;
    }
}
