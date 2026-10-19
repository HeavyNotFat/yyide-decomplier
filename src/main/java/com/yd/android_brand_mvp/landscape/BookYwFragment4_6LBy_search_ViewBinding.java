package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragment4_6LBy_search_ViewBinding implements Unbinder {
    private BookYwFragment4_6LBy_search target;

    public BookYwFragment4_6LBy_search_ViewBinding(BookYwFragment4_6LBy_search bookYwFragment4_6LBy_search, View view) {
        this.target = bookYwFragment4_6LBy_search;
        bookYwFragment4_6LBy_search.booktitle = (TextView) Utils.findRequiredViewAsType(view, R.id.booktitle, "field 'booktitle'", TextView.class);
        bookYwFragment4_6LBy_search.tj = (TextView) Utils.findRequiredViewAsType(view, R.id.tj, "field 'tj'", TextView.class);
        bookYwFragment4_6LBy_search.edit = (EditText) Utils.findRequiredViewAsType(view, R.id.edit, "field 'edit'", EditText.class);
        bookYwFragment4_6LBy_search.seach = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.seach, "field 'seach'", FrameLayout.class);
        bookYwFragment4_6LBy_search.layout_info = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_info, "field 'layout_info'", LinearLayout.class);
        bookYwFragment4_6LBy_search.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        bookYwFragment4_6LBy_search.bg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", RelativeLayout.class);
        bookYwFragment4_6LBy_search.msg = (TextView) Utils.findRequiredViewAsType(view, R.id.msg, "field 'msg'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragment4_6LBy_search bookYwFragment4_6LBy_search = this.target;
        if (bookYwFragment4_6LBy_search == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragment4_6LBy_search.booktitle = null;
        bookYwFragment4_6LBy_search.tj = null;
        bookYwFragment4_6LBy_search.edit = null;
        bookYwFragment4_6LBy_search.seach = null;
        bookYwFragment4_6LBy_search.layout_info = null;
        bookYwFragment4_6LBy_search.recyclerView = null;
        bookYwFragment4_6LBy_search.bg = null;
        bookYwFragment4_6LBy_search.msg = null;
    }
}
