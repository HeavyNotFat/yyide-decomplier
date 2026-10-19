package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragmentL_ViewBinding implements Unbinder {
    private BookYwFragmentL target;

    public BookYwFragmentL_ViewBinding(BookYwFragmentL bookYwFragmentL, View view) {
        this.target = bookYwFragmentL;
        bookYwFragmentL.gridView = (GridView) Utils.findRequiredViewAsType(view, R.id.grid, "field 'gridView'", GridView.class);
        bookYwFragmentL.content = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", FrameLayout.class);
        bookYwFragmentL.ll_content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'll_content'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragmentL bookYwFragmentL = this.target;
        if (bookYwFragmentL == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragmentL.gridView = null;
        bookYwFragmentL.content = null;
        bookYwFragmentL.ll_content = null;
    }
}
