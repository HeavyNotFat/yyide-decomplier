package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookFragment2_1P_ViewBinding implements Unbinder {
    private BookFragment2_1P target;

    public BookFragment2_1P_ViewBinding(BookFragment2_1P bookFragment2_1P, View view) {
        this.target = bookFragment2_1P;
        bookFragment2_1P.book_layout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.book_layout, "field 'book_layout'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookFragment2_1P bookFragment2_1P = this.target;
        if (bookFragment2_1P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookFragment2_1P.book_layout = null;
    }
}
