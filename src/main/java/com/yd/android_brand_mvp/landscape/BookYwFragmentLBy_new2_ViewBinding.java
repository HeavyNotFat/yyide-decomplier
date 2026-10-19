package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragmentLBy_new2_ViewBinding implements Unbinder {
    private BookYwFragmentLBy_new2 target;

    public BookYwFragmentLBy_new2_ViewBinding(BookYwFragmentLBy_new2 bookYwFragmentLBy_new2, View view) {
        this.target = bookYwFragmentLBy_new2;
        bookYwFragmentLBy_new2.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        bookYwFragmentLBy_new2.bg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragmentLBy_new2 bookYwFragmentLBy_new2 = this.target;
        if (bookYwFragmentLBy_new2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragmentLBy_new2.recyclerView = null;
        bookYwFragmentLBy_new2.bg = null;
    }
}
