package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.GridView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragment4_4L_ViewBinding implements Unbinder {
    private BookYwFragment4_4L target;

    public BookYwFragment4_4L_ViewBinding(BookYwFragment4_4L bookYwFragment4_4L, View view) {
        this.target = bookYwFragment4_4L;
        bookYwFragment4_4L.gridView = (GridView) Utils.findRequiredViewAsType(view, R.id.grid, "field 'gridView'", GridView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragment4_4L bookYwFragment4_4L = this.target;
        if (bookYwFragment4_4L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragment4_4L.gridView = null;
    }
}
