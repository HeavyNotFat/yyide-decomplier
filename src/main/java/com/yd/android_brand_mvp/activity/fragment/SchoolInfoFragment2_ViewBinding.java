package com.yd.android_brand_mvp.activity.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolInfoFragment2_ViewBinding implements Unbinder {
    private SchoolInfoFragment2 target;

    public SchoolInfoFragment2_ViewBinding(SchoolInfoFragment2 schoolInfoFragment2, View view) {
        this.target = schoolInfoFragment2;
        schoolInfoFragment2.grid = (GridView) Utils.findRequiredViewAsType(view, R.id.grid, "field 'grid'", GridView.class);
        schoolInfoFragment2.up = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.up, "field 'up'", CheckedTextView.class);
        schoolInfoFragment2.down = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.down, "field 'down'", CheckedTextView.class);
        schoolInfoFragment2.index = (TextView) Utils.findRequiredViewAsType(view, R.id.index, "field 'index'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SchoolInfoFragment2 schoolInfoFragment2 = this.target;
        if (schoolInfoFragment2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        schoolInfoFragment2.grid = null;
        schoolInfoFragment2.up = null;
        schoolInfoFragment2.down = null;
        schoolInfoFragment2.index = null;
    }
}
