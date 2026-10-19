package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolInfoFragment2P_ViewBinding implements Unbinder {
    private SchoolInfoFragment2P target;

    public SchoolInfoFragment2P_ViewBinding(SchoolInfoFragment2P schoolInfoFragment2P, View view) {
        this.target = schoolInfoFragment2P;
        schoolInfoFragment2P.grid = (GridView) Utils.findRequiredViewAsType(view, R.id.grid, "field 'grid'", GridView.class);
        schoolInfoFragment2P.up = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.up, "field 'up'", CheckedTextView.class);
        schoolInfoFragment2P.down = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.down, "field 'down'", CheckedTextView.class);
        schoolInfoFragment2P.index = (TextView) Utils.findRequiredViewAsType(view, R.id.index, "field 'index'", TextView.class);
        schoolInfoFragment2P.rb_tab1 = (TextView) Utils.findRequiredViewAsType(view, R.id.rb_tab1, "field 'rb_tab1'", TextView.class);
        schoolInfoFragment2P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SchoolInfoFragment2P schoolInfoFragment2P = this.target;
        if (schoolInfoFragment2P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        schoolInfoFragment2P.grid = null;
        schoolInfoFragment2P.up = null;
        schoolInfoFragment2P.down = null;
        schoolInfoFragment2P.index = null;
        schoolInfoFragment2P.rb_tab1 = null;
        schoolInfoFragment2P.mu = null;
    }
}
