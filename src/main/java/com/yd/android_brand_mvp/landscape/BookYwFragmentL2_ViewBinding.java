package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragmentL2_ViewBinding implements Unbinder {
    private BookYwFragmentL2 target;

    public BookYwFragmentL2_ViewBinding(BookYwFragmentL2 bookYwFragmentL2, View view) {
        this.target = bookYwFragmentL2;
        bookYwFragmentL2.gridView = (GridView) Utils.findRequiredViewAsType(view, R.id.grid, "field 'gridView'", GridView.class);
        bookYwFragmentL2.content = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", FrameLayout.class);
        bookYwFragmentL2.layout_bg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.layout_bg, "field 'layout_bg'", RelativeLayout.class);
        bookYwFragmentL2.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragmentL2 bookYwFragmentL2 = this.target;
        if (bookYwFragmentL2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragmentL2.gridView = null;
        bookYwFragmentL2.content = null;
        bookYwFragmentL2.layout_bg = null;
        bookYwFragmentL2.title = null;
    }
}
