package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragment_new_ViewBinding implements Unbinder {
    private BookYwFragment_new target;

    public BookYwFragment_new_ViewBinding(BookYwFragment_new bookYwFragment_new, View view) {
        this.target = bookYwFragment_new;
        bookYwFragment_new.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerView, "field 'recyclerView'", RecyclerView.class);
        bookYwFragment_new.flag = (TextView) Utils.findRequiredViewAsType(view, R.id.flag, "field 'flag'", TextView.class);
        bookYwFragment_new.time = (TextView) Utils.findRequiredViewAsType(view, R.id.time, "field 'time'", TextView.class);
        bookYwFragment_new.s1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.s1, "field 's1'", LinearLayout.class);
        bookYwFragment_new.language = (TextView) Utils.findRequiredViewAsType(view, R.id.language, "field 'language'", TextView.class);
        bookYwFragment_new.typelayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.typelayout, "field 'typelayout'", FrameLayout.class);
        bookYwFragment_new.type = (TextView) Utils.findRequiredViewAsType(view, R.id.type, "field 'type'", TextView.class);
        bookYwFragment_new.flaglayout2 = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flaglayout2, "field 'flaglayout2'", FrameLayout.class);
        bookYwFragment_new.flag2 = (TextView) Utils.findRequiredViewAsType(view, R.id.flag2, "field 'flag2'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BookYwFragment_new bookYwFragment_new = this.target;
        if (bookYwFragment_new == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        bookYwFragment_new.recyclerView = null;
        bookYwFragment_new.flag = null;
        bookYwFragment_new.time = null;
        bookYwFragment_new.s1 = null;
        bookYwFragment_new.language = null;
        bookYwFragment_new.typelayout = null;
        bookYwFragment_new.type = null;
        bookYwFragment_new.flaglayout2 = null;
        bookYwFragment_new.flag2 = null;
    }
}
