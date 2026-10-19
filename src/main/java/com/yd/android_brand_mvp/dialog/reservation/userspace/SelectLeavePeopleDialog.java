package com.yd.android_brand_mvp.dialog.reservation.userspace;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ItemSelectExamineBinding;
import com.yd.android_brand_mvp.databinding.SelectExamineDialogBinding;
import com.yd.android_brand_mvp.model.userspace.UserInfoListItem;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectLeavePeopleDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0011\u0018\u00002\u00020\u0001:\u0001\"B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\u001a\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\rR\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/reservation/userspace/SelectLeavePeopleDialog;", "Landroidx/fragment/app/DialogFragment;", "dataList", "", "Lcom/yd/android_brand_mvp/model/userspace/UserInfoListItem;", "modeType", "", "(Ljava/util/List;I)V", "binding", "Lcom/yd/android_brand_mvp/databinding/SelectExamineDialogBinding;", "getDataList", "()Ljava/util/List;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yd/android_brand_mvp/dialog/reservation/userspace/SelectLeavePeopleDialog$SelectLeavePeopleListener;", "getModeType", "()I", "peopleAdapter", "com/yd/android_brand_mvp/dialog/reservation/userspace/SelectLeavePeopleDialog$peopleAdapter$1", "Lcom/yd/android_brand_mvp/dialog/reservation/userspace/SelectLeavePeopleDialog$peopleAdapter$1;", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setSelectLeavePeopleListener", "callBack", "SelectLeavePeopleListener", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectLeavePeopleDialog extends DialogFragment {
    private SelectExamineDialogBinding binding;
    private final List<UserInfoListItem> dataList;
    private SelectLeavePeopleListener listener;
    private final int modeType;
    private final SelectLeavePeopleDialog$peopleAdapter$1 peopleAdapter;

    /* JADX INFO: compiled from: SelectLeavePeopleDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/reservation/userspace/SelectLeavePeopleDialog$SelectLeavePeopleListener;", "", "getUserInfoList", "", "data", "", "Lcom/yd/android_brand_mvp/model/userspace/UserInfoListItem;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SelectLeavePeopleListener {
        void getUserInfoList(List<UserInfoListItem> data);
    }

    public /* synthetic */ SelectLeavePeopleDialog(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? 2 : i);
    }

    public final List<UserInfoListItem> getDataList() {
        return this.dataList;
    }

    public final int getModeType() {
        return this.modeType;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.yd.android_brand_mvp.dialog.reservation.userspace.SelectLeavePeopleDialog$peopleAdapter$1] */
    public SelectLeavePeopleDialog(List<UserInfoListItem> dataList, int i) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList = dataList;
        this.modeType = i;
        this.peopleAdapter = new BaseBindingAdapter<ItemSelectExamineBinding, UserInfoListItem>() { // from class: com.yd.android_brand_mvp.dialog.reservation.userspace.SelectLeavePeopleDialog$peopleAdapter$1
            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, UserInfoListItem userInfoListItem) {
                convertPlus2((VBViewHolder<ItemSelectExamineBinding>) vBViewHolder, userInfoListItem);
            }

            /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
            public void convertPlus2(VBViewHolder<ItemSelectExamineBinding> holder, UserInfoListItem item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemSelectExamineBinding itemSelectExamineBinding = (ItemSelectExamineBinding) holder.getBinding();
                if (itemSelectExamineBinding != null) {
                    itemSelectExamineBinding.tvName.setText(item.getName());
                    GlideUtil.loadRadiusHeadImage(getContext(), item.getAvatar(), itemSelectExamineBinding.ivHead, 5);
                    itemSelectExamineBinding.tvDesc.setText(item.getSex());
                    itemSelectExamineBinding.cbCheck.setChecked(item.getSelected());
                }
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public ItemSelectExamineBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                Intrinsics.checkNotNullParameter(parent, "parent");
                ItemSelectExamineBinding itemSelectExamineBindingInflate = ItemSelectExamineBinding.inflate(inflater, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemSelectExamineBindingInflate, "inflate(inflater, parent, false)");
                return itemSelectExamineBindingInflate;
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        SelectExamineDialogBinding selectExamineDialogBindingInflate = SelectExamineDialogBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(selectExamineDialogBindingInflate, "inflate(inflater, container, false)");
        this.binding = selectExamineDialogBindingInflate;
        if (selectExamineDialogBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectExamineDialogBindingInflate = null;
        }
        ConstraintLayout root = selectExamineDialogBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        SelectExamineDialogBinding selectExamineDialogBinding = this.binding;
        SelectExamineDialogBinding selectExamineDialogBinding2 = null;
        if (selectExamineDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectExamineDialogBinding = null;
        }
        selectExamineDialogBinding.tvTitle.setText("请选择审批人");
        SelectExamineDialogBinding selectExamineDialogBinding3 = this.binding;
        if (selectExamineDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectExamineDialogBinding3 = null;
        }
        selectExamineDialogBinding3.tvCommit.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.reservation.userspace.-$$Lambda$SelectLeavePeopleDialog$6tBM2bONBDBv7s46q0e7vWFEkJk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectLeavePeopleDialog.initView$lambda$0(this.f$0, view);
            }
        });
        SelectExamineDialogBinding selectExamineDialogBinding4 = this.binding;
        if (selectExamineDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectExamineDialogBinding4 = null;
        }
        selectExamineDialogBinding4.tvDismiss.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.reservation.userspace.-$$Lambda$SelectLeavePeopleDialog$OyrznNuVnGziUbeRVv1yDu8S6ZI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectLeavePeopleDialog.initView$lambda$1(this.f$0, view);
            }
        });
        SelectExamineDialogBinding selectExamineDialogBinding5 = this.binding;
        if (selectExamineDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectExamineDialogBinding5 = null;
        }
        selectExamineDialogBinding5.dlRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        SelectExamineDialogBinding selectExamineDialogBinding6 = this.binding;
        if (selectExamineDialogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            selectExamineDialogBinding6 = null;
        }
        selectExamineDialogBinding6.dlRecycler.setAdapter(this.peopleAdapter);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.reservation.userspace.-$$Lambda$SelectLeavePeopleDialog$CXeh16akEIyXYJnxYMAx_5cav5I
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectLeavePeopleDialog.initView$lambda$4(this.f$0, baseQuickAdapter, view, i);
            }
        });
        setList(this.dataList);
        List<UserInfoListItem> list = this.dataList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((UserInfoListItem) obj).getSelected()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        SelectExamineDialogBinding selectExamineDialogBinding7 = this.binding;
        if (selectExamineDialogBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            selectExamineDialogBinding2 = selectExamineDialogBinding7;
        }
        selectExamineDialogBinding2.tvAmount.setText("已选择:" + arrayList2.size() + (char) 20154);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SelectLeavePeopleDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectLeavePeopleListener selectLeavePeopleListener = this$0.listener;
        if (selectLeavePeopleListener != null) {
            selectLeavePeopleListener.getUserInfoList(this$0.peopleAdapter.getData());
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(SelectLeavePeopleDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(SelectLeavePeopleDialog this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this$0.modeType == 2) {
            UserInfoListItem userInfoListItem = this$0.peopleAdapter.getData().get(i);
            userInfoListItem.setSelected(!userInfoListItem.getSelected());
            adapter.notifyItemChanged(i);
            List<UserInfoListItem> data = this$0.peopleAdapter.getData();
            ArrayList arrayList = new ArrayList();
            for (Object obj : data) {
                if (((UserInfoListItem) obj).getSelected()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            SelectExamineDialogBinding selectExamineDialogBinding = this$0.binding;
            if (selectExamineDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                selectExamineDialogBinding = null;
            }
            selectExamineDialogBinding.tvAmount.setText("已选择:" + arrayList2.size() + (char) 20154);
            return;
        }
        UserInfoListItem userInfoListItem2 = this$0.peopleAdapter.getData().get(i);
        userInfoListItem2.setSelected(!userInfoListItem2.getSelected());
        if (userInfoListItem2.getSelected()) {
            int i2 = 0;
            for (Object obj2 : this$0.peopleAdapter.getData()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                UserInfoListItem userInfoListItem3 = (UserInfoListItem) obj2;
                if (i2 != i) {
                    userInfoListItem3.setSelected(false);
                }
                i2 = i3;
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        Dialog dialog2 = getDialog();
        Window window = dialog2 != null ? dialog2.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "it.attributes");
            attributes.width = SizeUtils.dp2px(720.0f);
            attributes.height = SizeUtils.dp2px(560.0f);
            window.setAttributes(attributes);
        }
    }

    public final void setSelectLeavePeopleListener(SelectLeavePeopleListener callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        this.listener = callBack;
    }
}
