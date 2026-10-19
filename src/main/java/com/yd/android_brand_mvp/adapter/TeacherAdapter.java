package com.yd.android_brand_mvp.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.TeachersRsp;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.VHUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TeacherAdapter extends BaseAdapter {
    int layoutId;
    List<TeachersRsp.DataDTO.RecordsDTO> list = new ArrayList();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public TeacherAdapter(int i) {
        this.layoutId = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public TeachersRsp.DataDTO.RecordsDTO getItem(int i) {
        return this.list.get(i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x00a6  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        byte b = 0;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(this.layoutId, (ViewGroup) null, false);
        }
        ImageView imageView = (ImageView) VHUtil.ViewHolder.get(view, R.id.img);
        TextView textView = (TextView) VHUtil.ViewHolder.get(view, R.id.name);
        TextView textView2 = (TextView) VHUtil.ViewHolder.get(view, R.id.type);
        GlideUtil.loadCircleImage(view.getContext(), getItem(i).avatar, imageView);
        textView.setText(getItem(i).name);
        textView2.setText(getItem(i).jobTitle);
        if (TextUtils.isEmpty(getItem(i).jobTitle)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            String str = getItem(i).jobTitle;
            switch (str.hashCode()) {
                case 48:
                    if (!str.equals("0")) {
                        b = -1;
                    }
                    break;
                case 49:
                    if (!str.equals("1")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 50:
                    if (!str.equals("2")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 51:
                    if (!str.equals("3")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 52:
                    if (!str.equals("4")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                textView2.setText("正高级教师");
            } else if (b == 1) {
                textView2.setText("高级教师");
            } else if (b == 2) {
                textView2.setText("一级教师");
            } else if (b == 3) {
                textView2.setText("二级教师");
            } else if (b == 4) {
                textView2.setText("三级教师");
            }
        }
        return view;
    }

    public void notifyData(List<TeachersRsp.DataDTO.RecordsDTO> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
