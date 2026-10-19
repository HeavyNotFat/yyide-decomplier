package com.yd.android_brand_mvp.landscape.book;

import android.view.View;
import android.widget.GridView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookFragmentPage_ViewBinding implements Unbinder {
    private BookFragmentPage target;

    public BookFragmentPage_ViewBinding(BookFragmentPage bookFragmentPage, View view) {
        this.target = bookFragmentPage;
        bookFragmentPage.grid = (GridView) Utils.findRequiredViewAsType(view, R.id.grid, "field 'grid'", GridView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookFragmentPage bookFragmentPage = this.target;
        if (bookFragmentPage == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookFragmentPage.grid = null;
    }
}
