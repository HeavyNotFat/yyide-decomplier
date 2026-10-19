package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookFragment2_1L_ViewBinding implements Unbinder {
    private BookFragment2_1L target;

    public BookFragment2_1L_ViewBinding(BookFragment2_1L bookFragment2_1L, View view) {
        this.target = bookFragment2_1L;
        bookFragment2_1L.book_layout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.book_layout, "field 'book_layout'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookFragment2_1L bookFragment2_1L = this.target;
        if (bookFragment2_1L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookFragment2_1L.book_layout = null;
    }
}
