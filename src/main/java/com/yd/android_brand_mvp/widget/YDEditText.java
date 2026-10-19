package com.yd.android_brand_mvp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes4.dex */
public class YDEditText extends AppCompatEditText {
    public YDEditText(Context context) {
        super(context);
        init();
    }

    public YDEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public YDEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: com.yd.android_brand_mvp.widget.YDEditText.1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
    }
}
