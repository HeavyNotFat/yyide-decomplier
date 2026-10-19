package com.yd.android_brand_mvp.landscape.attence;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttencesEAdapter1 extends BaseQuickAdapter<AttencesExcBean, BaseViewHolder> {
    int index1;
    int index2;
    int index3;
    int index4;
    int textLength;
    int textSize;

    public AttencesEAdapter1(int i) {
        super(i);
        this.textSize = 20;
        this.textLength = 40;
        this.index1 = 0;
        this.index2 = 0;
        this.index3 = 0;
        this.index4 = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(final BaseViewHolder baseViewHolder, final AttencesExcBean attencesExcBean) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.lab1);
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.rv1);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_count);
        textView.setText(attencesExcBean.lab);
        textView2.setText(attencesExcBean.count + "人");
        if (attencesExcBean.bgId == 4) {
            textView.setBackgroundResource(R.drawable.bg_att1);
        } else if (attencesExcBean.bgId == 5 || attencesExcBean.bgId == 1) {
            textView.setBackgroundResource(R.drawable.bg_att2);
        } else if (attencesExcBean.bgId == 3) {
            textView.setBackgroundResource(R.drawable.bg_att3);
        } else if (attencesExcBean.bgId == 2) {
            textView.setBackgroundResource(R.drawable.bg_att4);
        }
        final BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.att_childrens_one_item) { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesEAdapter1.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder baseViewHolder2, String str) {
                TextView textView3 = (TextView) baseViewHolder2.getView(R.id.tv_name);
                textView3.setTextSize(SizeUtils.px2sp(AttencesEAdapter1.this.textSize));
                textView3.setText(str);
            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));
        recyclerView.setAdapter(baseQuickAdapter);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.att_childrens_add_item, (ViewGroup) null);
        baseQuickAdapter.addFooterView(viewInflate);
        baseQuickAdapter.addData(addNewList(baseViewHolder.getAdapterPosition(), attencesExcBean.listName, baseQuickAdapter));
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesEAdapter1.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                baseQuickAdapter.addData((Collection) AttencesEAdapter1.this.addNewList(baseViewHolder.getAdapterPosition(), attencesExcBean.listName, baseQuickAdapter));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> addNewList(int i, List<String> list, BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapter) {
        int i2;
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            i2 = this.index1 + 1;
            this.index1 = i2;
        } else {
            i2 = 0;
        }
        if (i == 1) {
            i2 = this.index2 + 1;
            this.index2 = i2;
        }
        if (i == 2) {
            i2 = this.index3 + 1;
            this.index3 = i2;
        }
        if (i == 3) {
            i2 = this.index4 + 1;
            this.index4 = i2;
        }
        if (list == null) {
            baseQuickAdapter.removeAllFooterView();
            return list;
        }
        if (list.size() < this.textLength) {
            baseQuickAdapter.removeAllFooterView();
            return list;
        }
        int size = list.size();
        int i3 = this.textLength;
        if (size > i2 * i3) {
            return list.subList((i2 * i3) - i3, i2 * i3);
        }
        int size2 = list.size();
        int i4 = this.textLength;
        if (size2 <= (i2 * i4) - i4) {
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("start：");
        int i5 = this.textLength;
        sb.append((i2 * i5) - i5);
        sb.append("list.size():=");
        sb.append(list.size());
        Log.e("AttencesEAdapter1", sb.toString());
        int i6 = this.textLength;
        List<String> listSubList = list.subList((i2 * i6) - i6, list.size());
        baseQuickAdapter.removeAllFooterView();
        return listSubList;
    }

    public void setTextSize(int i) {
        this.textSize = i;
    }

    private void resetRecyclerHeight(int i, int i2, RecyclerView recyclerView) {
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.width = -1;
        if (i % 7 == 0) {
            layoutParams.height = (i / 7) * i2;
        } else {
            layoutParams.height = ((i / 7) + 1) * i2;
        }
        recyclerView.setLayoutParams(layoutParams);
        recyclerView.setFocusable(false);
        recyclerView.setFocusableInTouchMode(false);
    }
}
