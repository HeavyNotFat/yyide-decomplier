package com.yd.android_brand_mvp.activity.collect.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseCollectFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\tJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R+\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "viewBinding", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "(Lkotlin/jvm/functions/Function3;)V", "getViewBinding", "()Lkotlin/jvm/functions/Function3;", "getSelectList", "", "", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BaseCollectFragment<VB extends ViewBinding> extends KTBaseFragment<VB> {
    private final Function3<LayoutInflater, ViewGroup, Boolean, VB> viewBinding;

    public final Function3<LayoutInflater, ViewGroup, Boolean, VB> getViewBinding() {
        return this.viewBinding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseCollectFragment(Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends VB> viewBinding) {
        super(viewBinding);
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        this.viewBinding = viewBinding;
    }

    public FormVerifyBean readySubmit() {
        return new FormVerifyBean(false, null, 0, null, null, null, 63, null);
    }

    public List<String> getSelectList() {
        return CollectionsKt.emptyList();
    }
}
