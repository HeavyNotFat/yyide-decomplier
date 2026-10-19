package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.CheckedTextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class UserCenterMessageFragment_ViewBinding implements Unbinder {
    private UserCenterMessageFragment target;

    public UserCenterMessageFragment_ViewBinding(UserCenterMessageFragment userCenterMessageFragment, View view) {
        this.target = userCenterMessageFragment;
        userCenterMessageFragment.btn1 = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.btn1, "field 'btn1'", CheckedTextView.class);
        userCenterMessageFragment.btn2 = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.btn2, "field 'btn2'", CheckedTextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        UserCenterMessageFragment userCenterMessageFragment = this.target;
        if (userCenterMessageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        userCenterMessageFragment.btn1 = null;
        userCenterMessageFragment.btn2 = null;
    }
}
