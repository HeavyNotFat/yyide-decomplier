package com.yd.android_brand_mvp.user.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class UserLeaveFragment_ViewBinding implements Unbinder {
    private UserLeaveFragment target;

    public UserLeaveFragment_ViewBinding(UserLeaveFragment userLeaveFragment, View view) {
        this.target = userLeaveFragment;
        userLeaveFragment.tab1 = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.tab1, "field 'tab1'", CheckedTextView.class);
        userLeaveFragment.tab2 = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.tab2, "field 'tab2'", CheckedTextView.class);
        userLeaveFragment.tab3 = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.tab3, "field 'tab3'", CheckedTextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        UserLeaveFragment userLeaveFragment = this.target;
        if (userLeaveFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        userLeaveFragment.tab1 = null;
        userLeaveFragment.tab2 = null;
        userLeaveFragment.tab3 = null;
    }
}
