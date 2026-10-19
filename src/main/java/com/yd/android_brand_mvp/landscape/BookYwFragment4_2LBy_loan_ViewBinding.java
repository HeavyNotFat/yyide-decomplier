package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragment4_2LBy_loan_ViewBinding implements Unbinder {
    private BookYwFragment4_2LBy_loan target;

    public BookYwFragment4_2LBy_loan_ViewBinding(BookYwFragment4_2LBy_loan bookYwFragment4_2LBy_loan, View view) {
        this.target = bookYwFragment4_2LBy_loan;
        bookYwFragment4_2LBy_loan.bg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", RelativeLayout.class);
        bookYwFragment4_2LBy_loan.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        bookYwFragment4_2LBy_loan.booktitle = (TextView) Utils.findRequiredViewAsType(view, R.id.booktitle, "field 'booktitle'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragment4_2LBy_loan bookYwFragment4_2LBy_loan = this.target;
        if (bookYwFragment4_2LBy_loan == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragment4_2LBy_loan.bg = null;
        bookYwFragment4_2LBy_loan.recyclerView = null;
        bookYwFragment4_2LBy_loan.booktitle = null;
    }
}
