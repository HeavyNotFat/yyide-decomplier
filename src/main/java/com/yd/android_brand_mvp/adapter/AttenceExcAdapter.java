package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.model.AttenceExcBean;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceExcAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<AttenceExcBean> list;

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }

    public AttenceExcAdapter(List<AttenceExcBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        List<AttenceExcBean> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return (this.list.get(i).nameList == null || this.list.get(i).nameList.size() == 0) ? 0 : 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.list.get(i).nameList.get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.att_parent_item, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.lab1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_count);
        textView.setText(this.list.get(i).lab);
        textView2.setText(this.list.get(i).count + "人");
        if (this.list.get(i).bgId == 4) {
            textView.setBackgroundResource(R.color.kq_color1);
        } else if (this.list.get(i).bgId == 5 || this.list.get(i).bgId == 1) {
            textView.setBackgroundResource(R.color.kq_color4);
        } else if (this.list.get(i).bgId == 3) {
            textView.setBackgroundResource(R.color.kq_color2);
        } else if (this.list.get(i).bgId == 2) {
            textView.setBackgroundResource(R.color.kq_color3);
        }
        return viewInflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.att_childrens_item, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.gv);
        BaseQuickAdapter<AttenceBean.DataBean.StudentsBean.PeopleBean, BaseViewHolder> baseQuickAdapter = new BaseQuickAdapter<AttenceBean.DataBean.StudentsBean.PeopleBean, BaseViewHolder>(R.layout.att_childrens_one_item) { // from class: com.yd.android_brand_mvp.adapter.AttenceExcAdapter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder baseViewHolder, AttenceBean.DataBean.StudentsBean.PeopleBean peopleBean) {
                ((TextView) baseViewHolder.getView(R.id.tv_name)).setText(peopleBean.name);
            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(this.context, 7));
        recyclerView.setAdapter(baseQuickAdapter);
        baseQuickAdapter.setList(this.list.get(i).nameList);
        return viewInflate;
    }
}
