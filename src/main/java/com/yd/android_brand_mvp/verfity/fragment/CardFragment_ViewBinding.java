package com.yd.android_brand_mvp.verfity.fragment;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class CardFragment_ViewBinding implements Unbinder {
    private CardFragment target;

    public CardFragment_ViewBinding(CardFragment cardFragment, View view) {
        this.target = cardFragment;
        cardFragment.frameLayout_card = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.frameLayout_card, "field 'frameLayout_card'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CardFragment cardFragment = this.target;
        if (cardFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        cardFragment.frameLayout_card = null;
    }
}
