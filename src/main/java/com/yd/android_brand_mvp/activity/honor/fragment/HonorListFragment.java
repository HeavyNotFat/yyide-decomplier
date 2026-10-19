package com.yd.android_brand_mvp.activity.honor.fragment;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.honor.viewmodel.HonorWallViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentHonerWallBinding;
import com.yd.android_brand_mvp.databinding.GankItemHonerWallBinding;
import com.yd.android_brand_mvp.dialog.HonorDetailDialog;
import com.yd.android_brand_mvp.model.honor.HonorWallBean;
import com.yd.android_brand_mvp.model.honor.HonorWallItem;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: HonorListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0007\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/fragment/HonorListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHonerWallBinding;", "()V", "current", "", "honerAdapter", "com/yd/android_brand_mvp/activity/honor/fragment/HonorListFragment$honerAdapter$2$1", "getHonerAdapter", "()Lcom/yd/android_brand_mvp/activity/honor/fragment/HonorListFragment$honerAdapter$2$1;", "honerAdapter$delegate", "Lkotlin/Lazy;", InnerConstant.Db.size, "totalCount", "viewModel", "Lcom/yd/android_brand_mvp/activity/honor/viewmodel/HonorWallViewModel;", "onResume", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "request", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorListFragment extends KTBaseFragment<FragmentHonerWallBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int current;

    /* JADX INFO: renamed from: honerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy honerAdapter;
    private final int size;
    private int totalCount;
    private HonorWallViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.honor.fragment.HonorListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHonerWallBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHonerWallBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHonerWallBinding;", 0);
        }

        public final FragmentHonerWallBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHonerWallBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHonerWallBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public HonorListFragment() {
        super(AnonymousClass1.INSTANCE);
        this.size = 8;
        this.current = 1;
        this.totalCount = 8;
        this.honerAdapter = LazyKt.lazy(new Function0<HonorListFragment$honerAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.HonorListFragment$honerAdapter$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.honor.fragment.HonorListFragment$honerAdapter$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: HonorListFragment.kt */
            @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/yd/android_brand_mvp/activity/honor/fragment/HonorListFragment$honerAdapter$2$1", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/GankItemHonerWallBinding;", "Lcom/yd/android_brand_mvp/model/honor/HonorWallItem;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "convertPlus", "", "holder", "Lcom/yd/android_brand_mvp/base/VBViewHolder;", "item", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class AnonymousClass1 extends BaseBindingAdapter<GankItemHonerWallBinding, HonorWallItem> implements LoadMoreModule {
                final /* synthetic */ HonorListFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(HonorListFragment honorListFragment) {
                    super(null, 1, null);
                    this.this$0 = honorListFragment;
                }

                @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, HonorWallItem honorWallItem) {
                    convertPlus2((VBViewHolder<GankItemHonerWallBinding>) vBViewHolder, honorWallItem);
                }

                /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                public void convertPlus2(VBViewHolder<GankItemHonerWallBinding> holder, HonorWallItem item) {
                    int i;
                    Intrinsics.checkNotNullParameter(holder, "holder");
                    Intrinsics.checkNotNullParameter(item, "item");
                    GankItemHonerWallBinding gankItemHonerWallBinding = (GankItemHonerWallBinding) holder.getBinding();
                    if (gankItemHonerWallBinding != null) {
                        HonorListFragment honorListFragment = this.this$0;
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SimpleUtilsKt.asColor(R.color.black9));
                        if (item.getWinnerNames().length() == 0) {
                            TextView textView = gankItemHonerWallBinding.tvItemHonerWallGetClass;
                            Intrinsics.checkNotNullExpressionValue(textView, "it.tvItemHonerWallGetClass");
                            SimpleUtilsKt.hide(textView);
                        } else {
                            TextView textView2 = gankItemHonerWallBinding.tvItemHonerWallGetClass;
                            Intrinsics.checkNotNullExpressionValue(textView2, "it.tvItemHonerWallGetClass");
                            SimpleUtilsKt.show(textView2);
                            int honorType = item.getHonorType();
                            if (honorType != 2) {
                                i = honorType != 3 ? R.string.honer_wall_getClass : R.string.honer_wall_getTeacher;
                            } else {
                                i = R.string.honer_wall_getStudent;
                            }
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String string = honorListFragment.getString(i);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(strContentId)");
                            String str = String.format(string, Arrays.copyOf(new Object[]{item.getWinnerNames()}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                            SpannableString spannableString = new SpannableString(str);
                            spannableString.setSpan(foregroundColorSpan, 5, spannableString.length(), 17);
                            gankItemHonerWallBinding.tvItemHonerWallGetClass.setText(spannableString);
                        }
                        gankItemHonerWallBinding.tvItemHonerWallType.setText(TransUtils.INSTANCE.transHonorLevelToStr(item.getLevel()));
                        gankItemHonerWallBinding.tvItemHonerWallTime.setText(item.getCreateTime());
                        gankItemHonerWallBinding.tvItemHonerWallTitle.setText(item.getName());
                        Glide.with(getContext()).load(item.getImgPaths()).into(gankItemHonerWallBinding.ivItemHonerWallTemplate);
                    }
                }

                @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                public GankItemHonerWallBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                    Intrinsics.checkNotNullParameter(inflater, "inflater");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    GankItemHonerWallBinding gankItemHonerWallBindingInflate = GankItemHonerWallBinding.inflate(inflater, parent, false);
                    Intrinsics.checkNotNullExpressionValue(gankItemHonerWallBindingInflate, "inflate(inflater, parent, false)");
                    return gankItemHonerWallBindingInflate;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new AnonymousClass1(this.this$0);
            }
        });
    }

    /* JADX INFO: compiled from: HonorListFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/fragment/HonorListFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "isPortrait", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Fragment newInstance$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.newInstance(z);
        }

        public final Fragment newInstance(boolean isPortrait) {
            HonorListFragment honorListFragment = new HonorListFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isPortrait", isPortrait);
            honorListFragment.setArguments(bundle);
            return honorListFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HonorListFragment$honerAdapter$2.AnonymousClass1 getHonerAdapter() {
        return (HonorListFragment$honerAdapter$2.AnonymousClass1) this.honerAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.viewModel = (HonorWallViewModel) new ViewModelProvider(this).get(HonorWallViewModel.class);
        getBinding().rvFragmentHonerWall.setLayoutManager(new GridLayoutManager(requireContext(), ScreenUtils.isPortrait() ? 2 : 4));
        getBinding().rvFragmentHonerWall.setAdapter(getHonerAdapter());
        getHonerAdapter().setEmptyView(R.layout.item_null_layout_4);
        getHonerAdapter().getLoadMoreModule().setAutoLoadMore(false);
        getHonerAdapter().getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
        getBinding().tvFragmentHonerWallNext.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.-$$Lambda$HonorListFragment$RG142yO0s-d5ja3I8bAZUN4lClQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HonorListFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        getBinding().tvFragmentHonerWallPre.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.-$$Lambda$HonorListFragment$d-vPUU9xPu2ecT4FVwX9CdZG5PM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HonorListFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        getHonerAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.-$$Lambda$HonorListFragment$T23Dyky0yx1qC5jMpfatJYO2Cec
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                HonorListFragment.onViewCreated$lambda$2(this.f$0, baseQuickAdapter, view2, i);
            }
        });
        HonorWallViewModel honorWallViewModel = this.viewModel;
        if (honorWallViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorWallViewModel = null;
        }
        LiveData<Result<HonorWallBean>> honorList = honorWallViewModel.getHonorList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends HonorWallBean>, Unit> function1 = new Function1<Result<? extends HonorWallBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.HonorListFragment.onViewCreated.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends HonorWallBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends HonorWallBean> it2) {
                HonorListFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                HonorWallBean honorWallBean = (HonorWallBean) value;
                if (honorWallBean == null) {
                    return;
                }
                HonorListFragment.this.totalCount = honorWallBean.getTotal();
                HonorListFragment.this.getHonerAdapter().setList(honorWallBean.getList());
            }
        };
        honorList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.honor.fragment.-$$Lambda$HonorListFragment$O0LMsd6KeIKB4HJEHV5EU2ueUSw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorListFragment.onViewCreated$lambda$3(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(HonorListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.current;
        if (this$0.size * i >= this$0.totalCount) {
            this$0.toastShow("没有下一页了");
        } else {
            this$0.current = i + 1;
            this$0.request();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(HonorListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.current;
        if (i == 1) {
            this$0.toastShow("没有上一页了");
            return;
        }
        if (i > 1) {
            this$0.current = i - 1;
        }
        this$0.request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(HonorListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        new HonorDetailDialog(this$0.getHonerAdapter().getItem(i)).show(this$0.getChildFragmentManager(), "honorDetail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        request();
    }

    private final void request() {
        showProgressDialog();
        HonorWallViewModel honorWallViewModel = this.viewModel;
        if (honorWallViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorWallViewModel = null;
        }
        honorWallViewModel.getHonorList(this.current, this.size);
    }
}
