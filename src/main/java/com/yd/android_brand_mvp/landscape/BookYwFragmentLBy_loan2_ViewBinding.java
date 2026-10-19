package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragmentLBy_loan2_ViewBinding implements Unbinder {
    private BookYwFragmentLBy_loan2 target;

    public BookYwFragmentLBy_loan2_ViewBinding(BookYwFragmentLBy_loan2 bookYwFragmentLBy_loan2, View view) {
        this.target = bookYwFragmentLBy_loan2;
        bookYwFragmentLBy_loan2.bg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", RelativeLayout.class);
        bookYwFragmentLBy_loan2.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragmentLBy_loan2 bookYwFragmentLBy_loan2 = this.target;
        if (bookYwFragmentLBy_loan2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragmentLBy_loan2.bg = null;
        bookYwFragmentLBy_loan2.recyclerView = null;
    }
}
