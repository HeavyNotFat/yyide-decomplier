package com.yd.android_brand_mvp.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.LayoutTableItem22lBinding;
import com.yd.android_brand_mvp.model.TableRsp;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassTableAdapter2x2.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u001e\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/ClassTableAdapter2x2;", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/LayoutTableItem22lBinding;", "Lcom/yd/android_brand_mvp/model/TableRsp;", "selectBackground", "", "normalBackground", "selectTextColor", "normalTextColor", "(IIII)V", "nextIndex", "weekCount", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "getItemChecked", "getNextIndex", "setWeek", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassTableAdapter2x2 extends BaseBindingAdapter<LayoutTableItem22lBinding, TableRsp> {
    private int nextIndex;
    private final int normalBackground;
    private final int normalTextColor;
    private final int selectBackground;
    private final int selectTextColor;
    private int weekCount;

    public ClassTableAdapter2x2() {
        this(0, 0, 0, 0, 15, null);
    }

    public /* synthetic */ ClassTableAdapter2x2(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? R.drawable.bg_drak_kb_10dp_select : i, (i5 & 2) != 0 ? R.drawable.bg_drak_kb_10dp : i2, (i5 & 4) != 0 ? R.color.white : i3, (i5 & 8) != 0 ? R.color.white : i4);
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, TableRsp tableRsp) {
        convertPlus2((VBViewHolder<LayoutTableItem22lBinding>) vBViewHolder, tableRsp);
    }

    public ClassTableAdapter2x2(int i, int i2, int i3, int i4) {
        super(null, 1, null);
        this.selectBackground = i;
        this.normalBackground = i2;
        this.selectTextColor = i3;
        this.normalTextColor = i4;
        this.nextIndex = -1;
    }

    public final void setWeek(int weekCount) {
        this.weekCount = weekCount;
    }

    public final int getNextIndex() {
        return this.nextIndex;
    }

    private final int getItemChecked() {
        int i = 0;
        int i2 = -1;
        for (Object obj : getData()) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TableRsp tableRsp = (TableRsp) obj;
            if (TimeUtil.isBelong(TimeUtil.stampToDate7(TimeUtil.gettime55(tableRsp.startTime) + ((long) 5000)), tableRsp.endTime) && i2 == -1) {
                i2 = i;
            }
            i = i3;
        }
        return i2;
    }

    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
    public void convertPlus2(VBViewHolder<LayoutTableItem22lBinding> holder, TableRsp item) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        LayoutTableItem22lBinding layoutTableItem22lBinding = (LayoutTableItem22lBinding) holder.getBinding();
        if (layoutTableItem22lBinding != null) {
            if (!StringUtils.isEmpty(item.otherSubjectName)) {
                if (this.weekCount % 2 == 0) {
                    str = item.otherClassesTeacher;
                    Intrinsics.checkNotNullExpressionValue(str, "item.otherClassesTeacher");
                    layoutTableItem22lBinding.tvTableName.setText(item.otherSubjectName);
                } else {
                    if (TextUtils.isEmpty(item.teacherName)) {
                        str = "";
                    } else {
                        str = item.teacherName;
                        Intrinsics.checkNotNullExpressionValue(str, "item.teacherName");
                    }
                    layoutTableItem22lBinding.tvTableName.setText(item.subjectsName);
                }
            } else {
                if (TextUtils.isEmpty(item.teacherName)) {
                    str = "";
                } else {
                    str = item.teacherName;
                    Intrinsics.checkNotNullExpressionValue(str, "item.teacherName");
                }
                layoutTableItem22lBinding.tvTableName.setText(item.subjectsName);
            }
            String str2 = StringUtils.isEmpty(str) ? "" : str;
            layoutTableItem22lBinding.tvTime.setText(item.startTime + '-' + item.endTime);
            layoutTableItem22lBinding.tvTeacherName.setText(str2);
            try {
                if (getItemChecked() == holder.getAdapterPosition()) {
                    this.nextIndex = holder.getAdapterPosition();
                    layoutTableItem22lBinding.clContent.setBackground(SimpleUtilsKt.asDrawable(this.selectBackground));
                    layoutTableItem22lBinding.tvTableName.setTextColor(SimpleUtilsKt.asColor(this.selectTextColor));
                    layoutTableItem22lBinding.tvTime.setTextColor(SimpleUtilsKt.asColor(this.selectTextColor));
                    layoutTableItem22lBinding.tvTeacherName.setTextColor(SimpleUtilsKt.asColor(this.selectTextColor));
                } else {
                    layoutTableItem22lBinding.clContent.setBackground(SimpleUtilsKt.asDrawable(this.normalBackground));
                    layoutTableItem22lBinding.tvTableName.setTextColor(SimpleUtilsKt.asColor(this.normalTextColor));
                    layoutTableItem22lBinding.tvTime.setTextColor(SimpleUtilsKt.asColor(this.normalTextColor));
                    layoutTableItem22lBinding.tvTeacherName.setTextColor(SimpleUtilsKt.asColor(this.normalTextColor));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
    public LayoutTableItem22lBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutTableItem22lBinding layoutTableItem22lBindingInflate = LayoutTableItem22lBinding.inflate(inflater, parent, false);
        Intrinsics.checkNotNullExpressionValue(layoutTableItem22lBindingInflate, "inflate(inflater, parent, false)");
        return layoutTableItem22lBindingInflate;
    }
}
