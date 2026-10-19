package com.yd.android_brand_mvp.adapter;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.StudenDutyBean;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class WeekStudentDutyAdapter extends BaseQuickAdapter<List<StudenDutyBean.DataBean>, BaseViewHolder> {
    int colorId;

    public WeekStudentDutyAdapter(int i, List list) {
        super(i, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder baseViewHolder, List<StudenDutyBean.DataBean> list) {
        DayStudentDutyAdapter dayStudentDutyAdapter;
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.rv_duty);
        Button button = (Button) baseViewHolder.getView(R.id.bt_duty_today);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_title);
        setWeek(baseViewHolder.getAdapterPosition(), button, (LinearLayout) baseViewHolder.getView(R.id.ll_zr), textView);
        textView.setText(setWeek(baseViewHolder.getAdapterPosition()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (ScreenUtils.isLandscape()) {
            dayStudentDutyAdapter = new DayStudentDutyAdapter(R.layout.all_student_duty_item, list, 1, this.colorId);
        } else {
            dayStudentDutyAdapter = new DayStudentDutyAdapter(R.layout.all_student_duty_item_p, list, 1, this.colorId);
        }
        recyclerView.setAdapter(dayStudentDutyAdapter);
    }

    private String setWeek(int i) {
        switch (i) {
            case 0:
                return getContext().getString(R.string.monday);
            case 1:
                return getContext().getString(R.string.tuesday);
            case 2:
                return getContext().getString(R.string.wednesday);
            case 3:
                return getContext().getString(R.string.thursday);
            case 4:
                return getContext().getString(R.string.friday);
            case 5:
                return getContext().getString(R.string.saturday);
            case 6:
                return getContext().getString(R.string.sunday);
            default:
                return "";
        }
    }

    private void setWeek(int i, Button button, LinearLayout linearLayout, TextView textView) {
        button.setVisibility(8);
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        if (intWeek == 1 && i == 6) {
            button.setVisibility(0);
            linearLayout.setBackgroundResource(R.drawable.icon_bg_z);
            textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.white));
            this.colorId = 1;
            return;
        }
        if (intWeek == i + 2) {
            button.setVisibility(0);
            textView.setTextColor(SkinCompatResources.getInstance().getColor(R.color.white));
            linearLayout.setBackgroundResource(R.drawable.icon_bg_z);
            this.colorId = 1;
            return;
        }
        linearLayout.setBackgroundResource(R.drawable.icon_bg_b);
        this.colorId = 0;
    }
}
