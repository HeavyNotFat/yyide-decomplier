package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragment_search_ViewBinding implements Unbinder {
    private BookYwFragment_search target;

    public BookYwFragment_search_ViewBinding(BookYwFragment_search bookYwFragment_search, View view) {
        this.target = bookYwFragment_search;
        bookYwFragment_search.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        bookYwFragment_search.seach = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.seach, "field 'seach'", FrameLayout.class);
        bookYwFragment_search.edit = (EditText) Utils.findRequiredViewAsType(view, R.id.edit, "field 'edit'", EditText.class);
        bookYwFragment_search.tj = (TextView) Utils.findRequiredViewAsType(view, R.id.tj, "field 'tj'", TextView.class);
        bookYwFragment_search.layout_info = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_info, "field 'layout_info'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragment_search bookYwFragment_search = this.target;
        if (bookYwFragment_search == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragment_search.recyclerView = null;
        bookYwFragment_search.seach = null;
        bookYwFragment_search.edit = null;
        bookYwFragment_search.tj = null;
        bookYwFragment_search.layout_info = null;
    }
}
