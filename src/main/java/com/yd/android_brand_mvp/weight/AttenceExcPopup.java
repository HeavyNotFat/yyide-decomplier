package com.yd.android_brand_mvp.weight;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.AttenceEAdapter;
import com.yd.android_brand_mvp.adapter.AttenceEAdapter1;
import com.yd.android_brand_mvp.base.BaseCenterPopup;
import com.yd.android_brand_mvp.model.AttenceExcBean;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceExcPopup extends BaseCenterPopup {
    List<AttenceExcBean> bean;
    OnStartLister onStartLister;
    String title;

    public interface OnStartLister {
        void onstart();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.attence_exc_popup;
    }

    public AttenceExcPopup(Context context, List<AttenceExcBean> list, String str) {
        super(context);
        this.bean = list;
        this.title = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseCenterPopup, com.lxj.xpopup.core.BasePopupView
    protected void onCreate() {
        super.onCreate();
        ((TextView) findViewById(R.id.tv_title)).setText(this.title);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (ScreenUtils.isLandscape()) {
            AttenceEAdapter attenceEAdapter = new AttenceEAdapter(R.layout.att_parent_item1);
            recyclerView.setAdapter(attenceEAdapter);
            attenceEAdapter.setList(this.bean);
        } else {
            AttenceEAdapter1 attenceEAdapter1 = new AttenceEAdapter1(R.layout.att_parent_item1);
            recyclerView.setAdapter(attenceEAdapter1);
            attenceEAdapter1.setList(this.bean);
        }
        findViewById(R.id.rl).setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.weight.AttenceExcPopup.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AttenceExcPopup.this.dismiss();
            }
        });
        OnStartLister onStartLister = this.onStartLister;
        if (onStartLister != null) {
            onStartLister.onstart();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxHeight() {
        return super.getMaxHeight();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return super.getMaxWidth();
    }

    public void setOnStartLister(OnStartLister onStartLister) {
        this.onStartLister = onStartLister;
    }
}
