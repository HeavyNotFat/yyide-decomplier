package com.yd.android_brand_mvp.adapter;

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
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.model.AttenceExcBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceEAdapter extends BaseQuickAdapter<AttenceExcBean, BaseViewHolder> {
    int index1;
    int index2;
    int index3;
    int index4;
    int textLength;
    int textSize;

    public AttenceEAdapter(int i) {
        super(i);
        this.textLength = 40;
        this.index1 = 0;
        this.index2 = 0;
        this.index3 = 0;
        this.index4 = 0;
        this.textSize = 20;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(final BaseViewHolder baseViewHolder, final AttenceExcBean attenceExcBean) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.lab1);
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.rv1);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_count);
        textView.setText(attenceExcBean.lab);
        textView2.setText(attenceExcBean.count + "人");
        if (attenceExcBean.bgId == 4) {
            textView.setBackgroundResource(R.drawable.bg_att1);
        } else if (attenceExcBean.bgId == 5 || attenceExcBean.bgId == 1) {
            textView.setBackgroundResource(R.drawable.bg_att2);
        } else if (attenceExcBean.bgId == 3) {
            textView.setBackgroundResource(R.drawable.bg_att3);
        } else if (attenceExcBean.bgId == 2) {
            textView.setBackgroundResource(R.drawable.bg_att4);
        }
        final BaseQuickAdapter<AttenceBean.DataBean.StudentsBean.PeopleBean, BaseViewHolder> baseQuickAdapter = new BaseQuickAdapter<AttenceBean.DataBean.StudentsBean.PeopleBean, BaseViewHolder>(R.layout.att_childrens_one_item) { // from class: com.yd.android_brand_mvp.adapter.AttenceEAdapter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder baseViewHolder2, AttenceBean.DataBean.StudentsBean.PeopleBean peopleBean) {
                TextView textView3 = (TextView) baseViewHolder2.getView(R.id.tv_name);
                textView3.setTextSize(SizeUtils.px2sp(AttenceEAdapter.this.textSize));
                textView3.setText(peopleBean.name);
            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));
        recyclerView.setAdapter(baseQuickAdapter);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.att_childrens_add_item, (ViewGroup) null);
        baseQuickAdapter.addFooterView(viewInflate);
        baseQuickAdapter.addData(addList(baseViewHolder.getAdapterPosition(), attenceExcBean.nameList, baseQuickAdapter));
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.AttenceEAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                baseQuickAdapter.addData((Collection) AttenceEAdapter.this.addList(baseViewHolder.getAdapterPosition(), attenceExcBean.nameList, baseQuickAdapter));
            }
        });
    }

    public List<AttenceBean.DataBean.StudentsBean.PeopleBean> addList(int i, List<AttenceBean.DataBean.StudentsBean.PeopleBean> list, BaseQuickAdapter baseQuickAdapter) {
        int i2;
        new ArrayList();
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
        List<AttenceBean.DataBean.StudentsBean.PeopleBean> listSubList = list.subList((i2 * i3) - i3, list.size());
        baseQuickAdapter.removeAllFooterView();
        return listSubList;
    }

    public void setTextSize(int i) {
        this.textSize = i;
    }
}
