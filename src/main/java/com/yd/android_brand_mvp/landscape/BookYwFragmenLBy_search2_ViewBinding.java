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
public class BookYwFragmenLBy_search2_ViewBinding implements Unbinder {
    private BookYwFragmenLBy_search2 target;

    public BookYwFragmenLBy_search2_ViewBinding(BookYwFragmenLBy_search2 bookYwFragmenLBy_search2, View view) {
        this.target = bookYwFragmenLBy_search2;
        bookYwFragmenLBy_search2.tj = (TextView) Utils.findRequiredViewAsType(view, R.id.tj, "field 'tj'", TextView.class);
        bookYwFragmenLBy_search2.edit = (EditText) Utils.findRequiredViewAsType(view, R.id.edit, "field 'edit'", EditText.class);
        bookYwFragmenLBy_search2.seach = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.seach, "field 'seach'", FrameLayout.class);
        bookYwFragmenLBy_search2.layout_info = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_info, "field 'layout_info'", LinearLayout.class);
        bookYwFragmenLBy_search2.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        bookYwFragmenLBy_search2.bg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", RelativeLayout.class);
        bookYwFragmenLBy_search2.msg = (TextView) Utils.findRequiredViewAsType(view, R.id.msg, "field 'msg'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragmenLBy_search2 bookYwFragmenLBy_search2 = this.target;
        if (bookYwFragmenLBy_search2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragmenLBy_search2.tj = null;
        bookYwFragmenLBy_search2.edit = null;
        bookYwFragmenLBy_search2.seach = null;
        bookYwFragmenLBy_search2.layout_info = null;
        bookYwFragmenLBy_search2.recyclerView = null;
        bookYwFragmenLBy_search2.bg = null;
        bookYwFragmenLBy_search2.msg = null;
    }
}
