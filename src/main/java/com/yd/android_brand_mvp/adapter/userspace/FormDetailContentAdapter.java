package com.yd.android_brand_mvp.adapter.userspace;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.FormDateRangeBean;
import com.yd.android_brand_mvp.model.userspace.LeaveTypeBean;
import com.yd.android_brand_mvp.utils.form.FormComponentUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormDetailContentAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/userspace/FormDetailContentAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormDetailContentAdapter extends BaseMultiItemQuickAdapter<FormBaseBean, BaseViewHolder> {
    public FormDetailContentAdapter() {
        super(null, 1, null);
        addItemType(0, R.layout.view_leave_content);
        addItemType(1, R.layout.item_leave_time_range_content);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, FormBaseBean item) {
        String name;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemViewType = holder.getItemViewType();
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                return;
            }
            TextView textView = (TextView) holder.getView(R.id.tv_item_leave_time_range_startTime_content);
            TextView textView2 = (TextView) holder.getView(R.id.tv_item_leave_time_range_endTime_content);
            TextView textView3 = (TextView) holder.getView(R.id.tv_item_leave_time_range_timeLength_content);
            TextView textView4 = (TextView) holder.getView(R.id.tv_item_leave_time_range_timeLength);
            FormDateRangeBean formDateRangeBean = (FormDateRangeBean) GsonUtils.fromJson(item.getValue(), FormDateRangeBean.class);
            if (formDateRangeBean != null) {
                textView.setText(formDateRangeBean.getStartTime());
                textView2.setText(formDateRangeBean.getEndTime());
                textView3.setText(formDateRangeBean.getTimeLength());
                textView4.setText("时长(" + formDateRangeBean.getUnit() + ')');
                return;
            }
            return;
        }
        TextView textView5 = (TextView) holder.getView(R.id.tv_view_leave_content_title);
        TextView textView6 = (TextView) holder.getView(R.id.tv_view_leave_content_content);
        textView5.setText(item.getTitle());
        if (Intrinsics.areEqual(item.getName(), FormComponentUtil.LeaveType)) {
            List<Object> options = item.getProps().getOptions();
            Object obj = null;
            if (!(options instanceof List)) {
                options = null;
            }
            if (options != null) {
                for (Object obj2 : options) {
                    if (Intrinsics.areEqual(((LeaveTypeBean) obj2).getId(), item.getValue())) {
                        obj = obj2;
                        break;
                    }
                }
                LeaveTypeBean leaveTypeBean = (LeaveTypeBean) obj;
                textView6.setText((leaveTypeBean == null || (name = leaveTypeBean.getName()) == null) ? "未知" : name);
                return;
            }
            textView6.setText("未知");
            return;
        }
        FormComponentUtil formComponentUtil = FormComponentUtil.INSTANCE;
        String name2 = item.getName();
        String value = item.getValue();
        if (value == null) {
            value = "";
        }
        textView6.setText(formComponentUtil.parseDataValueToShowValue(name2, value));
    }
}
