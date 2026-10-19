package com.yd.android_brand_mvp.landscape.vote;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentHomeVote46Binding;
import com.yd.android_brand_mvp.databinding.ItemVoteDetailBinding;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.utils.view.GridSpacingItemDecoration;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: HomeVote46Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u001a\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/vote/HomeVote46Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeVote46Binding;", "()V", "normalAdapter", "com/yd/android_brand_mvp/landscape/vote/HomeVote46Fragment$normalAdapter$2$1", "getNormalAdapter", "()Lcom/yd/android_brand_mvp/landscape/vote/HomeVote46Fragment$normalAdapter$2$1;", "normalAdapter$delegate", "Lkotlin/Lazy;", "type", "", "initView", "", "onDestroyView", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeVote46Fragment extends KTBaseFragment<FragmentHomeVote46Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: normalAdapter$delegate, reason: from kotlin metadata */
    private final Lazy normalAdapter;
    private String type;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.vote.HomeVote46Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeVote46Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeVote46Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeVote46Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeVote46Binding;", 0);
        }

        public final FragmentHomeVote46Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeVote46Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeVote46Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public HomeVote46Fragment() {
        super(AnonymousClass1.INSTANCE);
        this.normalAdapter = LazyKt.lazy(new Function0<HomeVote46Fragment$normalAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.landscape.vote.HomeVote46Fragment$normalAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.landscape.vote.HomeVote46Fragment$normalAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemVoteDetailBinding, String>() { // from class: com.yd.android_brand_mvp.landscape.vote.HomeVote46Fragment$normalAdapter$2.1
                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemVoteDetailBinding> holder, String item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, String str) {
                        convertPlus2((VBViewHolder<ItemVoteDetailBinding>) vBViewHolder, str);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemVoteDetailBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemVoteDetailBinding itemVoteDetailBindingInflate = ItemVoteDetailBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemVoteDetailBindingInflate, "inflate(inflater, parent, false)");
                        return itemVoteDetailBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: HomeVote46Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/vote/HomeVote46Fragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            HomeVote46Fragment homeVote46Fragment = new HomeVote46Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            homeVote46Fragment.setArguments(bundle);
            return homeVote46Fragment;
        }
    }

    private final HomeVote46Fragment$normalAdapter$2.AnonymousClass1 getNormalAdapter() {
        return (HomeVote46Fragment$normalAdapter$2.AnonymousClass1) this.normalAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbsjb22";
        }
        this.type = string;
        if (string == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
        } else {
            str = string;
        }
        if (Intrinsics.areEqual(str, "hbtphd46")) {
            getBinding().clFragmentHomeVote46.getLayoutParams().width = SizeUtils.dp2px(908.0f);
            getBinding().clFragmentHomeVote46.getLayoutParams().height = SizeUtils.dp2px(916.0f);
        } else if (Intrinsics.areEqual(str, "sbtphd45")) {
            getBinding().clFragmentHomeVote46.getLayoutParams().width = SizeUtils.dp2px(660.0f);
            getBinding().clFragmentHomeVote46.getLayoutParams().height = SizeUtils.dp2px(1090.0f);
        }
        initView();
    }

    private final void initView() {
        getBinding().topFragmentHomeVote46.title.setText("投票");
        getBinding().rvFragmentVote46.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        getBinding().rvFragmentVote46.setAdapter(getNormalAdapter());
        getBinding().rvFragmentVote46.addItemDecoration(new GridSpacingItemDecoration(2, SizeUtils.dp2px(20.0f), false));
        getNormalAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.vote.-$$Lambda$HomeVote46Fragment$cehN_Hk34vG9z-R0Wk35yorqtDI
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HomeVote46Fragment.initView$lambda$0(baseQuickAdapter, view, i);
            }
        });
        getBinding().btnFragmentHomeVote46.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.vote.-$$Lambda$HomeVote46Fragment$EU-9C6SbcIHp0XQCvG8pFsxqdSM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeVote46Fragment.initView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HomeVote46Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
        intent.putExtra("type", BaseConstant.homeVote46);
        this$0.startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.type != BaseConstant.homeVote46) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
