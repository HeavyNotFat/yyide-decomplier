package com.yd.android_brand_mvp.adapter;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.StudenDutyBean;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewWeekStudentDutyLAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J(\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/NewWeekStudentDutyLAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/yd/android_brand_mvp/model/StudenDutyBean$DataBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "colorId", "", "getColorId", "()I", "setColorId", "(I)V", "convert", "", "holder", "item", "setWeek", "", FirebaseAnalytics.Param.INDEX, "button", "Landroid/widget/Button;", "ll", "Landroid/widget/LinearLayout;", "tvTitle", "Landroid/widget/TextView;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewWeekStudentDutyLAdapter extends BaseQuickAdapter<List<StudenDutyBean.DataBean>, BaseViewHolder> {
    private int colorId;

    public NewWeekStudentDutyLAdapter() {
        super(R.layout.day_student_duty_item, null, 2, null);
    }

    public final int getColorId() {
        return this.colorId;
    }

    public final void setColorId(int i) {
        this.colorId = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, List<StudenDutyBean.DataBean> item) {
        DayStudentDutyAdapter dayStudentDutyAdapter;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        RecyclerView recyclerView = (RecyclerView) holder.getView(R.id.rv_duty);
        Button button = (Button) holder.getView(R.id.bt_duty_today);
        TextView textView = (TextView) holder.getView(R.id.tv_title);
        MultiStateView multiStateView = (MultiStateView) holder.getView(R.id.mu);
        setWeek(holder.getAdapterPosition(), button, (LinearLayout) holder.getView(R.id.ll_zr), textView);
        textView.setText(setWeek(holder.getAdapterPosition()));
        if (item.isEmpty()) {
            multiStateView.setViewState(2);
        } else {
            multiStateView.setVisibility(8);
        }
        if (ScreenUtils.isLandscape()) {
            dayStudentDutyAdapter = new DayStudentDutyAdapter(R.layout.all_student_duty_item, item, 1, this.colorId);
        } else {
            dayStudentDutyAdapter = new DayStudentDutyAdapter(R.layout.all_student_duty_item_p, item, 1, this.colorId);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(dayStudentDutyAdapter);
    }

    private final String setWeek(int index) {
        switch (index) {
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

    private final void setWeek(int index, Button button, LinearLayout ll, TextView tvTitle) {
        button.setVisibility(8);
        int intWeek = TimeUtil.getIntWeek(System.currentTimeMillis());
        if (intWeek == 1 && index == 6) {
            button.setVisibility(0);
            ll.setBackgroundResource(R.drawable.icon_zr_z);
            tvTitle.setTextColor(getContext().getResources().getColor(R.color.white));
            this.colorId = 1;
            return;
        }
        if (intWeek == index + 2) {
            button.setVisibility(0);
            tvTitle.setTextColor(getContext().getResources().getColor(R.color.white));
            ll.setBackgroundResource(R.drawable.icon_zr_z);
            this.colorId = 1;
            return;
        }
        ll.setBackgroundResource(R.drawable.icon_zr_b);
        this.colorId = 0;
    }
}
