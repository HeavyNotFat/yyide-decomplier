package com.yd.android_brand_mvp.verfity.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class AccountFragment_ViewBinding implements Unbinder {
    private AccountFragment target;

    public AccountFragment_ViewBinding(AccountFragment accountFragment, View view) {
        this.target = accountFragment;
        accountFragment.edit = (EditText) Utils.findRequiredViewAsType(view, R.id.edit, "field 'edit'", EditText.class);
        accountFragment.qd = (TextView) Utils.findRequiredViewAsType(view, R.id.qd, "field 'qd'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AccountFragment accountFragment = this.target;
        if (accountFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        accountFragment.edit = null;
        accountFragment.qd = null;
    }
}
