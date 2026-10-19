package com.yd.android_brand_mvp.adapter.customtj;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.utils.SortList;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CustomSiteTableAdapter extends BaseAdapter {
    Activity activity;
    int week;
    public List<TableRsp> list = new ArrayList();
    boolean isNight = false;
    int nextIndex = 0;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public CustomSiteTableAdapter(Activity activity, int i) {
        this.activity = activity;
        this.week = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public TableRsp getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String strStampToDate7;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_site_table, (ViewGroup) null, false);
        }
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.tv_table_name);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.tv_teacher_name);
        ConstraintLayout constraintLayout = (ConstraintLayout) VHUtil.ViewHolder.get(view, R.id.layout_table_item);
        ((TextView) VHUtil.ViewHolder.get(view, R.id.tv_table_time)).setText(getItem(i).startTime + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getItem(i).endTime);
        String str = getItem(i).otherClassesTeacher;
        if (TextUtils.isEmpty(str)) {
            str = getItem(i).teacherName;
        }
        textView2.setText(str);
        textView.setText(getItem(i).subjectsName);
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        if (i == 0) {
            strStampToDate7 = TimeUtil.stampToDate7(TimeUtil.gettime55(getItem(i).startTime) + 5000);
        } else {
            strStampToDate7 = getItem(i).startTime;
        }
        if (TimeUtil.isBelong(strStampToDate7, getItem(i).endTime) && intWeek == this.week && !this.isNight) {
            this.isNight = true;
            constraintLayout.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.bg_drak_kb_8dp_select));
            this.nextIndex = i;
        } else {
            constraintLayout.setBackground(viewGroup.getContext().getResources().getDrawable(R.drawable.bg_white_transparency_65));
        }
        return view;
    }

    public void notifyData(List<TableRsp> list) {
        this.list = list;
        this.isNight = false;
        this.list = SortList.listSorting2(list);
        notifyDataSetChanged();
    }

    public void notifyData(List<TableRsp> list, int i) {
        this.list = list;
        this.week = i;
        this.isNight = false;
        this.list = SortList.listSorting2(list);
        notifyDataSetInvalidated();
    }

    public int getNextIndex() {
        return this.nextIndex;
    }
}
