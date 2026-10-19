package com.yd.android_brand_mvp.landscape.reserve;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.reserve.ReservationActivity;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentSiteReservation22Binding;
import com.yd.android_brand_mvp.databinding.ItemReservationMeetingBinding;
import com.yd.android_brand_mvp.landscape.reserve.viemodel.HomeReservationViewModel;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: HomeReservation44Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0005\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'H\u0007J\u001a\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010*\u001a\u00020\u0015H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/yd/android_brand_mvp/landscape/reserve/HomeReservation44Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentSiteReservation22Binding;", "()V", "meetingAdapter", "com/yd/android_brand_mvp/landscape/reserve/HomeReservation44Fragment$meetingAdapter$2$1", "getMeetingAdapter", "()Lcom/yd/android_brand_mvp/landscape/reserve/HomeReservation44Fragment$meetingAdapter$2$1;", "meetingAdapter$delegate", "Lkotlin/Lazy;", "showItem", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "showReservationList", "", "signList", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "type", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/reserve/viemodel/HomeReservationViewModel;", "UpdataEvent", "", "id", "", "getHighLightIndex", TUIKitConstants.Selection.LIST, "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onViewCreated", "view", "request", "setShowItemUI", "setShowReservation", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeReservation44Fragment extends KTBaseFragment<FragmentSiteReservation22Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: meetingAdapter$delegate, reason: from kotlin metadata */
    private final Lazy meetingAdapter;
    private ReservationRecordBean showItem;
    private final List<ReservationRecordBean> showReservationList;
    private final List<ReservationSignListItemBean> signList;
    private String type;
    private HomeReservationViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeReservation44Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentSiteReservation22Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentSiteReservation22Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentSiteReservation22Binding;", 0);
        }

        public final FragmentSiteReservation22Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentSiteReservation22Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentSiteReservation22Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentSiteReservation22Binding access$getBinding(HomeReservation44Fragment homeReservation44Fragment) {
        return homeReservation44Fragment.getBinding();
    }

    public HomeReservation44Fragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
        this.showReservationList = new ArrayList();
        this.signList = new ArrayList();
        this.meetingAdapter = LazyKt.lazy(new Function0<HomeReservation44Fragment$meetingAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$meetingAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$meetingAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemReservationMeetingBinding, ReservationRecordBean>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$meetingAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ReservationRecordBean reservationRecordBean) {
                        convertPlus2((VBViewHolder<ItemReservationMeetingBinding>) vBViewHolder, reservationRecordBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemReservationMeetingBinding> holder, ReservationRecordBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemReservationMeetingBinding itemReservationMeetingBinding = (ItemReservationMeetingBinding) holder.getBinding();
                        if (itemReservationMeetingBinding != null) {
                            itemReservationMeetingBinding.tvItemReservationMeetingTheme.setText(item.getName());
                            itemReservationMeetingBinding.tvItemReservationMeetingTime.setText(new Regex("\\s+").split(item.getBookingTime(), 0).get(1));
                            itemReservationMeetingBinding.clItemReservationMeeting.setBackground(SimpleUtilsKt.asDrawable(TransUtils.INSTANCE.transSiteBookingTypeCodeToBackground(item.getSiteBookingTypeCode())));
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemReservationMeetingBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemReservationMeetingBinding itemReservationMeetingBindingInflate = ItemReservationMeetingBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemReservationMeetingBindingInflate, "inflate(inflater, parent, false)");
                        return itemReservationMeetingBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: HomeReservation44Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/reserve/HomeReservation44Fragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            HomeReservation44Fragment homeReservation44Fragment = new HomeReservation44Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            homeReservation44Fragment.setArguments(bundle);
            return homeReservation44Fragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeReservation44Fragment$meetingAdapter$2.AnonymousClass1 getMeetingAdapter() {
        return (HomeReservation44Fragment$meetingAdapter$2.AnonymousClass1) this.meetingAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.viewModel = (HomeReservationViewModel) new ViewModelProvider(this).get(HomeReservationViewModel.class);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbcdyy22";
        }
        this.type = string;
        if (Intrinsics.areEqual(string, "hbcdyy44")) {
            ConstraintLayout constraintLayout = getBinding().clFragmentSiteReservation44Meeting;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clFragmentSiteReservation44Meeting");
            SimpleUtilsKt.show(constraintLayout);
            getBinding().topFragmentSiteReservation22Content.setImageResource(R.mipmap.bg_top_purple2);
            getBinding().topFragmentSiteReservation22.title.setText("今日预约");
            getBinding().clFragmentSiteReservation22.getLayoutParams().width = SizeUtils.dp2px(908.0f);
            getBinding().clFragmentSiteReservation22.getLayoutParams().height = SizeUtils.dp2px(604.0f);
        } else if (Intrinsics.areEqual(string, "sbcdyy63")) {
            ConstraintLayout constraintLayout2 = getBinding().clFragmentSiteReservation44Meeting;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.clFragmentSiteReservation44Meeting");
            SimpleUtilsKt.show(constraintLayout2);
            getBinding().topFragmentSiteReservation22Content.setImageResource(R.mipmap.bg_top_purple2);
            getBinding().topFragmentSiteReservation22.title.setText("今日预约");
            getBinding().clFragmentSiteReservation22.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
            getBinding().clFragmentSiteReservation22.getLayoutParams().height = SizeUtils.dp2px(646.0f);
        }
        initView();
    }

    private final void initView() {
        getBinding().topFragmentSiteReservation22.llTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.reserve.-$$Lambda$HomeReservation44Fragment$v_-IhjjUTFFcBAGTTtKp7cghGGA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeReservation44Fragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().btnFragmentSiteReservation22Sign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.reserve.-$$Lambda$HomeReservation44Fragment$XVBkzdMAv6vvn32xpq9Rmz-83S8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeReservation44Fragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().rvFragmentSiteReservation44Meeting.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        getBinding().rvFragmentSiteReservation44Meeting.setAdapter(getMeetingAdapter());
        HomeReservationViewModel homeReservationViewModel = this.viewModel;
        HomeReservationViewModel homeReservationViewModel2 = null;
        if (homeReservationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            homeReservationViewModel = null;
        }
        LiveData<Result<BasePageResponse<List<ReservationRecordBean>>>> reservationList = homeReservationViewModel.getReservationList();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<? extends ReservationRecordBean>>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) value;
                if (basePageResponse == null) {
                    return;
                }
                Collection collection = (Collection) basePageResponse.getList();
                if (collection == null || collection.isEmpty()) {
                    return;
                }
                List listSortedWith = CollectionsKt.sortedWith((Iterable) basePageResponse.getList(), new Comparator() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$initView$3$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((ReservationRecordBean) t).getStartTimeStr(), ((ReservationRecordBean) t2).getStartTimeStr());
                    }
                });
                int highLightIndex = HomeReservation44Fragment.this.getHighLightIndex(listSortedWith);
                if (highLightIndex == -1) {
                    return;
                }
                HomeReservation44Fragment.this.showItem = (ReservationRecordBean) listSortedWith.get(highLightIndex);
                HomeReservation44Fragment.this.setShowItemUI();
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(HomeReservation44Fragment.this), null, null, new AnonymousClass1(HomeReservation44Fragment.this, null), 3, null);
                if (highLightIndex == CollectionsKt.getLastIndex(listSortedWith)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int size = listSortedWith.size();
                for (int i = highLightIndex + 1; i < size; i++) {
                    arrayList.add(listSortedWith.get(i));
                }
                ArrayList arrayList2 = arrayList;
                HomeReservation44Fragment.this.getMeetingAdapter().setList(arrayList2);
                HomeReservation44Fragment.this.showReservationList.clear();
                HomeReservation44Fragment.this.showReservationList.addAll(arrayList2);
            }

            /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$initView$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: HomeReservation44Fragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$initView$3$1", f = "HomeReservation44Fragment.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ HomeReservation44Fragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(HomeReservation44Fragment homeReservation44Fragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = homeReservation44Fragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        ReservationRecordBean reservationRecordBean = this.this$0.showItem;
                        HomeReservationViewModel homeReservationViewModel = null;
                        long timestamp = (DateUtils.getTimestamp(reservationRecordBean != null ? reservationRecordBean.getStartTimeStr() : null, TimeUtil.notSecondFormat) - System.currentTimeMillis()) + ((long) 10000);
                        AppExtKt.logd(coroutineScope, "nextTimeInterval = " + timestamp);
                        HomeReservationViewModel homeReservationViewModel2 = this.this$0.viewModel;
                        if (homeReservationViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            homeReservationViewModel = homeReservationViewModel2;
                        }
                        this.label = 1;
                        if (homeReservationViewModel.startTimer(timestamp, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        reservationList.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.reserve.-$$Lambda$HomeReservation44Fragment$OTOsWI6qgH_jS0HLrMchWMIpUd4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeReservation44Fragment.initView$lambda$3(function1, obj);
            }
        });
        HomeReservationViewModel homeReservationViewModel3 = this.viewModel;
        if (homeReservationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            homeReservationViewModel3 = null;
        }
        LiveData<ReservationDetailBean> reservationDetail = homeReservationViewModel3.getReservationDetail();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<ReservationDetailBean, Unit> function2 = new Function1<ReservationDetailBean, Unit>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReservationDetailBean reservationDetailBean) {
                invoke2(reservationDetailBean);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ReservationDetailBean reservationDetailBean) {
                HomeReservation44Fragment.this.signList.addAll(reservationDetailBean.getSignList());
            }
        };
        reservationDetail.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.reserve.-$$Lambda$HomeReservation44Fragment$-VPwve_lrtJh5AnBBQroG294eN4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeReservation44Fragment.initView$lambda$4(function2, obj);
            }
        });
        HomeReservationViewModel homeReservationViewModel4 = this.viewModel;
        if (homeReservationViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            homeReservationViewModel2 = homeReservationViewModel4;
        }
        LiveData<Result<Boolean>> signInResult = homeReservationViewModel2.getSignInResult();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function3 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Boolean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends Boolean> result) {
                ToastUtil.showBottomView((Activity) HomeReservation44Fragment.this.requireActivity(), "签到成功");
            }
        };
        signInResult.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.landscape.reserve.-$$Lambda$HomeReservation44Fragment$hQ9ayX8ENm-nAWlhHQNDrBFhuHY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeReservation44Fragment.initView$lambda$5(function3, obj);
            }
        });
        setShowReservation();
        request();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HomeReservation44Fragment this$0, View view) {
        String id;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.showItem == null) {
            ToastUtil.showBottomView(this$0.requireContext(), "暂无预约");
            return;
        }
        if (this$0.secondaryPagePermissions()) {
            ReservationActivity.Companion companion = ReservationActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            ReservationRecordBean reservationRecordBean = this$0.showItem;
            if (reservationRecordBean == null || (id = reservationRecordBean.getId()) == null) {
                id = "-1";
            }
            boolean zStartsWith$default = StringsKt.startsWith$default(this$0.type, "sb", false, 2, (Object) null);
            ReservationRecordBean reservationRecordBean2 = this$0.showItem;
            companion.startGo(contextRequireContext, id, zStartsWith$default, reservationRecordBean2 != null ? reservationRecordBean2.getSignIn() : true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(HomeReservation44Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReservationRecordBean reservationRecordBean = this$0.showItem;
        if (reservationRecordBean != null) {
            if (reservationRecordBean.getSignIn()) {
                Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
                intent.putExtra("type", BaseConstant.homeReservation44);
                this$0.startActivity(intent);
            } else {
                Context contextRequireContext = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                SimpleUtilsKt.showShotToast(contextRequireContext, "无需签到");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$setShowReservation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeReservation44Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$setShowReservation$1", f = "HomeReservation44Fragment.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
    static final class C05051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C05051(Continuation<? super C05051> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C05051 c05051 = HomeReservation44Fragment.this.new C05051(continuation);
            c05051.L$0 = obj;
            return c05051;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$setShowReservation$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: HomeReservation44Fragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "", "emit", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C01821<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$launch;
            final /* synthetic */ HomeReservation44Fragment this$0;

            C01821(CoroutineScope coroutineScope, HomeReservation44Fragment homeReservation44Fragment) {
                this.$$this$launch = coroutineScope;
                this.this$0 = homeReservation44Fragment;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((String) obj, (Continuation<? super Unit>) continuation);
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            public final Object emit(String str, Continuation<? super Unit> continuation) {
                HomeReservation44Fragment$setShowReservation$1$1$emit$1 homeReservation44Fragment$setShowReservation$1$1$emit$1;
                C01821<T> c01821;
                int i;
                if (continuation instanceof HomeReservation44Fragment$setShowReservation$1$1$emit$1) {
                    homeReservation44Fragment$setShowReservation$1$1$emit$1 = (HomeReservation44Fragment$setShowReservation$1$1$emit$1) continuation;
                    if ((homeReservation44Fragment$setShowReservation$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        homeReservation44Fragment$setShowReservation$1$1$emit$1.label -= Integer.MIN_VALUE;
                    } else {
                        homeReservation44Fragment$setShowReservation$1$1$emit$1 = new HomeReservation44Fragment$setShowReservation$1$1$emit$1(this, continuation);
                    }
                } else {
                    homeReservation44Fragment$setShowReservation$1$1$emit$1 = new HomeReservation44Fragment$setShowReservation$1$1$emit$1(this, continuation);
                }
                Object obj = homeReservation44Fragment$setShowReservation$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = homeReservation44Fragment$setShowReservation$1$1$emit$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AppExtKt.logd(this.$$this$launch, "44 更新下一个预约");
                    HomeReservation44Fragment homeReservation44Fragment = this.this$0;
                    int highLightIndex = homeReservation44Fragment.getHighLightIndex(homeReservation44Fragment.showReservationList);
                    if (highLightIndex == -1) {
                        HomeReservation44Fragment.access$getBinding(this.this$0).tvFragmentSiteReservation22Title.setText("暂无");
                        HomeReservation44Fragment.access$getBinding(this.this$0).tvFragmentSiteReservation22Time.setText("暂无");
                        this.this$0.getMeetingAdapter().setList(null);
                        return Unit.INSTANCE;
                    }
                    HomeReservation44Fragment homeReservation44Fragment2 = this.this$0;
                    homeReservation44Fragment2.showItem = (ReservationRecordBean) homeReservation44Fragment2.showReservationList.get(highLightIndex);
                    this.this$0.setShowItemUI();
                    ReservationRecordBean reservationRecordBean = this.this$0.showItem;
                    long timestamp = (DateUtils.getTimestamp(reservationRecordBean != null ? reservationRecordBean.getStartTimeStr() : null, TimeUtil.notSecondFormat) - System.currentTimeMillis()) + ((long) 10000);
                    AppExtKt.logd(this.$$this$launch, "nextTimeInterval = " + timestamp);
                    HomeReservationViewModel homeReservationViewModel = this.this$0.viewModel;
                    if (homeReservationViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        homeReservationViewModel = null;
                    }
                    homeReservation44Fragment$setShowReservation$1$1$emit$1.L$0 = this;
                    homeReservation44Fragment$setShowReservation$1$1$emit$1.I$0 = highLightIndex;
                    homeReservation44Fragment$setShowReservation$1$1$emit$1.label = 1;
                    if (homeReservationViewModel.startTimer(timestamp, homeReservation44Fragment$setShowReservation$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c01821 = this;
                    i = highLightIndex;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = homeReservation44Fragment$setShowReservation$1$1$emit$1.I$0;
                    c01821 = (C01821) homeReservation44Fragment$setShowReservation$1$1$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (i == CollectionsKt.getLastIndex(c01821.this$0.showReservationList)) {
                    c01821.this$0.getMeetingAdapter().setList(null);
                } else {
                    ArrayList arrayList = new ArrayList();
                    int size = c01821.this$0.showReservationList.size();
                    for (int i3 = i + 1; i3 < size; i3++) {
                        arrayList.add(c01821.this$0.showReservationList.get(i3));
                    }
                    c01821.this$0.getMeetingAdapter().setList(arrayList);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                HomeReservationViewModel homeReservationViewModel = HomeReservation44Fragment.this.viewModel;
                if (homeReservationViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    homeReservationViewModel = null;
                }
                this.label = 1;
                if (homeReservationViewModel.getTimeSharedFlow().collect(new C01821(coroutineScope, HomeReservation44Fragment.this), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    private final void setShowReservation() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C05051(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowItemUI() {
        ReservationRecordBean reservationRecordBean = this.showItem;
        if (reservationRecordBean != null) {
            if (reservationRecordBean.getSignIn()) {
                Button button = getBinding().btnFragmentSiteReservation22Sign;
                Intrinsics.checkNotNullExpressionValue(button, "binding.btnFragmentSiteReservation22Sign");
                SimpleUtilsKt.show(button);
            } else {
                Button button2 = getBinding().btnFragmentSiteReservation22Sign;
                Intrinsics.checkNotNullExpressionValue(button2, "binding.btnFragmentSiteReservation22Sign");
                SimpleUtilsKt.remove(button2);
            }
            getBinding().tvFragmentSiteReservation22Title.setText(reservationRecordBean.getName());
            getBinding().tvFragmentSiteReservation22Time.setText(new Regex("\\s+").split(reservationRecordBean.getBookingTime(), 0).get(1));
            this.signList.clear();
            HomeReservationViewModel homeReservationViewModel = this.viewModel;
            if (homeReservationViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                homeReservationViewModel = null;
            }
            homeReservationViewModel.getReservationDetail(reservationRecordBean.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getHighLightIndex(List<ReservationRecordBean> list) {
        int i = 0;
        for (ReservationRecordBean reservationRecordBean : list) {
            int i2 = i + 1;
            if ((reservationRecordBean.getStartTimeStr().length() > 0) && DateUtils.isNextTime(reservationRecordBean.getStartTimeStr(), TimeUtil.notSecondFormat)) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    private final void request() {
        String siteId = SpData.getSiteId();
        if (siteId == null) {
            siteId = "-1";
        }
        if (Intrinsics.areEqual(siteId, "-1")) {
            return;
        }
        HomeReservationViewModel homeReservationViewModel = this.viewModel;
        if (homeReservationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            homeReservationViewModel = null;
        }
        homeReservationViewModel.getTodayReservationList(siteId);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (MinaConstants.CODE_RESERVE == id) {
            request();
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        EventBus.getDefault().register(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        ReservationRecordBean reservationRecordBean;
        Object next;
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.type == BaseConstant.homeReservation44 && (reservationRecordBean = this.showItem) != null) {
            HomeReservationViewModel homeReservationViewModel = null;
            if (!Tool.isNetworkAvailable(requireContext())) {
                ToastUtil.showBottomView(requireContext(), getString(R.string.network_is_unavailable));
                if (this.signList.isEmpty()) {
                    return;
                }
                Iterator<T> it2 = this.signList.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!Intrinsics.areEqual(((ReservationSignListItemBean) next).getUserId(), eventBean.id));
                if (((ReservationSignListItemBean) next) == null) {
                    ToastUtil.showBottomView(requireContext(), "不在名单内");
                    return;
                }
                String timeStr = DateUtils.getTodayStr(TimeUtil.allTimeFormat);
                HomeReservationViewModel homeReservationViewModel2 = this.viewModel;
                if (homeReservationViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    homeReservationViewModel = homeReservationViewModel2;
                }
                String id = reservationRecordBean.getId();
                String str = eventBean.id;
                Intrinsics.checkNotNullExpressionValue(str, "eventBean.id");
                Intrinsics.checkNotNullExpressionValue(timeStr, "timeStr");
                homeReservationViewModel.insertReservationSignDataToDao(id, str, timeStr);
                return;
            }
            HomeReservationViewModel homeReservationViewModel3 = this.viewModel;
            if (homeReservationViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                homeReservationViewModel = homeReservationViewModel3;
            }
            String str2 = eventBean.id;
            Intrinsics.checkNotNullExpressionValue(str2, "eventBean.id");
            homeReservationViewModel.signInRecord(str2, reservationRecordBean.getId());
        }
    }
}
