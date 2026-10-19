package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragmentLBy_loan2_2_ViewBinding implements Unbinder {
    private BookYwFragmentLBy_loan2_2 target;

    public BookYwFragmentLBy_loan2_2_ViewBinding(BookYwFragmentLBy_loan2_2 bookYwFragmentLBy_loan2_2, View view) {
        this.target = bookYwFragmentLBy_loan2_2;
        bookYwFragmentLBy_loan2_2.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        bookYwFragmentLBy_loan2_2.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        bookYwFragmentLBy_loan2_2.bg = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragmentLBy_loan2_2 bookYwFragmentLBy_loan2_2 = this.target;
        if (bookYwFragmentLBy_loan2_2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragmentLBy_loan2_2.recyclerView = null;
        bookYwFragmentLBy_loan2_2.title = null;
        bookYwFragmentLBy_loan2_2.bg = null;
    }
}
