package com.yd.android_brand_mvp.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yyide.facepass.database.FacePeople;

/* JADX INFO: loaded from: classes4.dex */
public class ListmsgAdapter4_2l extends BaseQuickAdapter<FacePeople, BaseViewHolder> {
    public boolean iscl;

    public ListmsgAdapter4_2l(int i) {
        super(i);
        this.iscl = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, FacePeople facePeople) {
        ((TextView) baseViewHolder.getView(R.id.name)).setText(facePeople.getName());
    }

    public void setcolor(boolean z) {
        this.iscl = z;
    }
}
