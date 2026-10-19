package com.yd.android_brand_mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.gson.reflect.TypeToken;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel;
import com.yd.android_brand_mvp.adapter.BannerCustomAdapter2;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseDominateActivity;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.ActivityDominateShowImageBinding;
import com.yd.android_brand_mvp.landscape.video.RecyclerItemNormalHolder;
import com.yd.android_brand_mvp.landscape.video.ViewPagerAdapter;
import com.yd.android_brand_mvp.model.home.CustomImageBean;
import com.yd.android_brand_mvp.model.home.CustomItemBean;
import com.yd.android_brand_mvp.model.home.DominateCustomBean;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.observer.MinaListener;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.MMKVUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: compiled from: CustomDominateActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001$B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0016H\u0014J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\rH\u0002J\b\u0010#\u001a\u00020\u0016H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/activity/CustomDominateActivity;", "Lcom/yd/android_brand_mvp/base/BaseDominateActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivityDominateShowImageBinding;", "Lcom/yd/android_brand_mvp/observer/MinaListener;", "()V", "dataList", "", "Lcom/yd/android_brand_mvp/model/home/DominateCustomBean;", "handler", "Landroid/os/Handler;", "loopTime", "", "pagePosition", "", "runnable", "Ljava/lang/Runnable;", "showList", "viewModel", "Lcom/yd/android_brand_mvp/activity/home/viewmodel/HomeViewModel;", "viewPagerAdapter", "Lcom/yd/android_brand_mvp/adapter/BannerCustomAdapter2;", "UpdataEvent", "", "id", "dominateCustomBeans", "getCustomItemBeans", "Lcom/yd/android_brand_mvp/model/home/CustomItemBean;", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "play", "position", "setData", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomDominateActivity extends BaseDominateActivity<ActivityDominateShowImageBinding> implements MinaListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<DominateCustomBean> dataList;
    private final Handler handler;
    private long loopTime;
    private int pagePosition;
    private final Runnable runnable;
    private final List<DominateCustomBean> showList;
    private HomeViewModel viewModel;
    private BannerCustomAdapter2 viewPagerAdapter;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.CustomDominateActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomDominateActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LayoutInflater, ActivityDominateShowImageBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ActivityDominateShowImageBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/yd/android_brand_mvp/databinding/ActivityDominateShowImageBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ActivityDominateShowImageBinding invoke(LayoutInflater p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityDominateShowImageBinding.inflate(p0);
        }
    }

    public CustomDominateActivity() {
        super(AnonymousClass1.INSTANCE);
        this.showList = new ArrayList();
        this.loopTime = 20000L;
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.checkNotNull(looperMyLooper);
        this.handler = new Handler(looperMyLooper);
        this.runnable = new Runnable() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$CustomDominateActivity$uqzQvo6RAHr64MWHj3hAJMc6Zu8
            @Override // java.lang.Runnable
            public final void run() {
                CustomDominateActivity.runnable$lambda$6(this.f$0);
            }
        };
        this.dataList = new ArrayList();
    }

    public static final /* synthetic */ ActivityDominateShowImageBinding access$getBinding(CustomDominateActivity customDominateActivity) {
        return customDominateActivity.getBinding();
    }

    /* JADX INFO: compiled from: CustomDominateActivity.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/activity/CustomDominateActivity$Companion;", "", "()V", "startGo", "", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/model/home/DominateCustomBean;", "Lkotlin/collections/ArrayList;", "isShowClose", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startGo(Context context, ArrayList<DominateCustomBean> dataList, boolean isShowClose) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) CustomDominateActivity.class);
            intent.putParcelableArrayListExtra("data", dataList);
            intent.putExtra("isShow", isShowClose);
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseDominateActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MinaEventManager.getInstance().add(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseDominateActivity
    protected void initView() {
        super.initView();
        this.viewModel = (HomeViewModel) new ViewModelProvider(this).get(HomeViewModel.class);
        this.showList.clear();
        List list = (List) GsonUtils.fromJson(MMKVUtil.INSTANCE.getDominateScreenData(MMKVUtil.DOMINATE_CUSTOM_DATA), new TypeToken<List<? extends DominateCustomBean>>() { // from class: com.yd.android_brand_mvp.activity.CustomDominateActivity$initView$tempList$1
        }.getType());
        if (list != null && (!list.isEmpty())) {
            Log.d("CustomDominateActivity", "dataList=" + list.size());
            this.showList.addAll(CollectionsKt.sortedWith(list, new Comparator() { // from class: com.yd.android_brand_mvp.activity.CustomDominateActivity$initView$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((DominateCustomBean) t).getStartDate(), ((DominateCustomBean) t2).getStartDate());
                }
            }));
        }
        if (getIntent().getBooleanExtra("isShow", false)) {
            ImageView imageView = getBinding().ivClose;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivClose");
            SimpleUtilsKt.hide(imageView);
        } else {
            ImageView imageView2 = getBinding().ivClose;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivClose");
            SimpleUtilsKt.show(imageView2);
        }
        getBinding().ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$CustomDominateActivity$Pki2YShCmCDxFKWDngOYHkWUVDE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomDominateActivity.initView$lambda$1(this.f$0, view);
            }
        });
        BannerCustomAdapter2 bannerCustomAdapter2 = new BannerCustomAdapter2(this);
        this.viewPagerAdapter = bannerCustomAdapter2;
        if (bannerCustomAdapter2 != null) {
            bannerCustomAdapter2.setOnNext(new ViewPagerAdapter.OnNext() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$CustomDominateActivity$z8hK7873y7L2g7jBpg6brLrkSLI
                @Override // com.yd.android_brand_mvp.landscape.video.ViewPagerAdapter.OnNext
                public final void next(int i) {
                    CustomDominateActivity.initView$lambda$3(this.f$0, i);
                }
            });
        }
        getBinding().viewPager2.setOffscreenPageLimit(1);
        getBinding().viewPager2.setOrientation(0);
        getBinding().viewPager2.setAdapter(this.viewPagerAdapter);
        getBinding().viewPager2.registerOnPageChangeCallback(new AnonymousClass4());
        setData();
        CustomDominateActivity customDominateActivity = this;
        HomeViewModel homeViewModel = null;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(customDominateActivity), null, null, new AnonymousClass5(null), 3, null);
        HomeViewModel homeViewModel2 = this.viewModel;
        if (homeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            homeViewModel = homeViewModel2;
        }
        LiveData<List<DominateCustomBean>> dominateCustomData = homeViewModel.getDominateCustomData();
        final Function1<List<? extends DominateCustomBean>, Unit> function1 = new Function1<List<? extends DominateCustomBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.CustomDominateActivity.initView.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DominateCustomBean> list2) {
                invoke2((List<DominateCustomBean>) list2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<DominateCustomBean> it2) {
                if (it2.isEmpty()) {
                    BaseConstant.DOMINATE_CLOSE = true;
                    CustomDominateActivity.this.finish();
                }
                CustomDominateActivity.this.showList.clear();
                List list2 = CustomDominateActivity.this.showList;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                list2.addAll(it2);
                if (CustomDominateActivity.this.showList.isEmpty()) {
                    BaseConstant.DOMINATE_CLOSE = true;
                    CustomDominateActivity.this.finish();
                }
                CustomDominateActivity.this.setData();
            }
        };
        dominateCustomData.observe(customDominateActivity, new Observer() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$CustomDominateActivity$EGyiaIm0X87ceQ9qepZH5gxth2g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CustomDominateActivity.initView$lambda$4(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(CustomDominateActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().ivClose.setClickable(false);
        BaseConstant.DOMINATE_CLOSE = true;
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(final CustomDominateActivity this$0, int i) {
        List<CustomItemBean> dataList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.d("CustomDominateActivity", "viewpager下标 = " + i);
        BannerCustomAdapter2 bannerCustomAdapter2 = this$0.viewPagerAdapter;
        if (((bannerCustomAdapter2 == null || (dataList = bannerCustomAdapter2.getDataList()) == null || dataList.size() != 1) ? false : true) && i == 0) {
            this$0.getBinding().viewPager2.post(new Runnable() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$CustomDominateActivity$p7GbV-kZbTrU-czm5fiTRrQPybc
                @Override // java.lang.Runnable
                public final void run() {
                    CustomDominateActivity.initView$lambda$3$lambda$2(this.f$0);
                }
            });
        } else {
            this$0.getBinding().viewPager2.setCurrentItem(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(CustomDominateActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GSYVideoManager.releaseAllVideos();
        this$0.play(0);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.CustomDominateActivity$initView$4, reason: invalid class name */
    /* JADX INFO: compiled from: CustomDominateActivity.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/yd/android_brand_mvp/activity/CustomDominateActivity$initView$4", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass4 extends ViewPager2.OnPageChangeCallback {
        AnonymousClass4() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int position) {
            List<CustomItemBean> dataList;
            List<CustomItemBean> dataList2;
            super.onPageSelected(position);
            CustomDominateActivity.this.handler.removeCallbacks(CustomDominateActivity.this.runnable);
            GSYVideoManager.onPause();
            BannerCustomAdapter2 bannerCustomAdapter2 = CustomDominateActivity.this.viewPagerAdapter;
            Integer numValueOf = null;
            CustomItemBean customItemBean = (bannerCustomAdapter2 == null || (dataList2 = bannerCustomAdapter2.getDataList()) == null) ? null : dataList2.get(position);
            CustomDominateActivity.this.pagePosition = position;
            boolean z = false;
            if (customItemBean != null && customItemBean.getType() == 4) {
                z = true;
            }
            if (!z) {
                BannerCustomAdapter2 bannerCustomAdapter3 = CustomDominateActivity.this.viewPagerAdapter;
                if (bannerCustomAdapter3 != null && (dataList = bannerCustomAdapter3.getDataList()) != null) {
                    numValueOf = Integer.valueOf(dataList.size());
                }
                Intrinsics.checkNotNull(numValueOf);
                if (numValueOf.intValue() > 1) {
                    int duration = customItemBean != null ? customItemBean.getDuration() * 1000 : 10000;
                    Log.d("CustomDominateActivity", "轮播时间=" + duration);
                    CustomDominateActivity.this.handler.postDelayed(CustomDominateActivity.this.runnable, (long) duration);
                    return;
                }
                return;
            }
            ViewPager2 viewPager2 = CustomDominateActivity.access$getBinding(CustomDominateActivity.this).viewPager2;
            final CustomDominateActivity customDominateActivity = CustomDominateActivity.this;
            viewPager2.post(new Runnable() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$CustomDominateActivity$initView$4$-YeOiw-lXayLU22pxRIx7Sz5Hoo
                @Override // java.lang.Runnable
                public final void run() {
                    CustomDominateActivity.AnonymousClass4.onPageSelected$lambda$0(customDominateActivity, position);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageSelected$lambda$0(CustomDominateActivity this$0, int i) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            GSYVideoManager.releaseAllVideos();
            this$0.play(i);
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.CustomDominateActivity$initView$5, reason: invalid class name */
    /* JADX INFO: compiled from: CustomDominateActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.CustomDominateActivity$initView$5", f = "CustomDominateActivity.kt", i = {}, l = {121, 122}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomDominateActivity.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            HomeViewModel homeViewModel = null;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
            ResultKt.throwOnFailure(obj);
            HomeViewModel homeViewModel2 = CustomDominateActivity.this.viewModel;
            if (homeViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                homeViewModel2 = null;
            }
            this.label = 1;
            if (homeViewModel2.startTimer(CustomDominateActivity.this.loopTime, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            HomeViewModel homeViewModel3 = CustomDominateActivity.this.viewModel;
            if (homeViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                homeViewModel = homeViewModel3;
            }
            MutableSharedFlow<String> timeSharedFlow = homeViewModel.getTimeSharedFlow();
            final CustomDominateActivity customDominateActivity = CustomDominateActivity.this;
            this.label = 2;
            if (timeSharedFlow.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.activity.CustomDominateActivity.initView.5.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((String) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(String str, Continuation<? super Unit> continuation) {
                    List listDominateCustomBeans = customDominateActivity.dominateCustomBeans();
                    Log.d("CustomDominateActivity", GsonUtils.toJson(listDominateCustomBeans));
                    if (!Intrinsics.areEqual(GsonUtils.toJson(listDominateCustomBeans), GsonUtils.toJson(customDominateActivity.dataList))) {
                        customDominateActivity.setData();
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DominateCustomBean> dominateCustomBeans() {
        ArrayList arrayList = new ArrayList();
        for (DominateCustomBean dominateCustomBean : this.showList) {
            if (DateUtils.isTiming(dominateCustomBean.getStartDate(), dominateCustomBean.getEndDate(), TimeUtil.allTimeFormat)) {
                arrayList.add(dominateCustomBean);
            }
        }
        if (arrayList.isEmpty()) {
            BaseConstant.DOMINATE_CLOSE = true;
            finish();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runnable$lambda$6(final CustomDominateActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Ref.IntRef intRef = new Ref.IntRef();
        this$0.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$CustomDominateActivity$VFASmgE8zsa4uXsbvCjt7D3P4ro
            @Override // java.lang.Runnable
            public final void run() {
                CustomDominateActivity.runnable$lambda$6$lambda$5(this.f$0, intRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runnable$lambda$6$lambda$5(CustomDominateActivity this$0, Ref.IntRef index) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(index, "$index");
        RecyclerView.Adapter adapter = this$0.getBinding().viewPager2.getAdapter();
        Integer numValueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            index.element = 0;
        }
        index.element = (numValueOf == null || numValueOf.intValue() != this$0.pagePosition + 1) ? this$0.pagePosition + 1 : 0;
        this$0.getBinding().viewPager2.setCurrentItem(index.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData() {
        List<CustomItemBean> customItemBeans = getCustomItemBeans();
        this.dataList = dominateCustomBeans();
        if (!customItemBeans.isEmpty()) {
            BannerCustomAdapter2 bannerCustomAdapter2 = this.viewPagerAdapter;
            if (bannerCustomAdapter2 != null) {
                bannerCustomAdapter2.setListData(customItemBeans);
            }
            if (customItemBeans.get(0).getType() == 4) {
                getBinding().viewPager2.post(new Runnable() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$CustomDominateActivity$HyQSRePcrMYmeOEC5Q1oCwpu3A0
                    @Override // java.lang.Runnable
                    public final void run() {
                        CustomDominateActivity.setData$lambda$7(this.f$0);
                    }
                });
                return;
            }
            return;
        }
        BaseConstant.DOMINATE_CLOSE = true;
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$7(CustomDominateActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.play(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void play(int position) {
        View childAt = getBinding().viewPager2.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ((RecyclerView) childAt).findViewHolderForAdapterPosition(position);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            ((RecyclerItemNormalHolder) viewHolderFindViewHolderForAdapterPosition).getPlayer().startPlayLogic();
        }
    }

    private final List<CustomItemBean> getCustomItemBeans() {
        ArrayList arrayList = new ArrayList();
        CollectionsKt.sortedWith(this.showList, new Comparator() { // from class: com.yd.android_brand_mvp.activity.CustomDominateActivity$getCustomItemBeans$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((DominateCustomBean) t).getStartDate(), ((DominateCustomBean) t2).getStartDate());
            }
        });
        for (DominateCustomBean dominateCustomBean : this.showList) {
            if (DateUtils.isTiming(dominateCustomBean.getStartDate(), dominateCustomBean.getEndDate(), TimeUtil.allTimeFormat) && (Intrinsics.areEqual(dominateCustomBean.getModeType(), "4") || Intrinsics.areEqual(dominateCustomBean.getModeType(), "3"))) {
                if (dominateCustomBean.getType() == 3 || dominateCustomBean.getType() == 2 || dominateCustomBean.getType() == 4) {
                    List<CustomItemBean> groups = dominateCustomBean.getGroups();
                    if (groups != null) {
                        for (CustomItemBean customItemBean : groups) {
                            List<CustomImageBean> images = (List) GsonUtils.fromJson(customItemBean.getContent(), new TypeToken<List<CustomImageBean>>() { // from class: com.yd.android_brand_mvp.activity.CustomDominateActivity$getCustomItemBeans$2$1$images$1
                            }.getType());
                            if (images != null) {
                                Intrinsics.checkNotNullExpressionValue(images, "images");
                                for (CustomImageBean customImageBean : images) {
                                    CustomItemBean customItemBean2 = new CustomItemBean(null, null, 0, null, null, null, 0, 0, null, 511, null);
                                    customItemBean2.setType(dominateCustomBean.getType());
                                    customItemBean2.setDuration(dominateCustomBean.getDuration());
                                    customItemBean2.setContent(customImageBean.getUrl());
                                    customItemBean2.setSettingInfo(customItemBean.getSettingInfo());
                                    arrayList.add(customItemBean2);
                                }
                            }
                        }
                    }
                } else {
                    List<CustomItemBean> groups2 = dominateCustomBean.getGroups();
                    if (groups2 != null) {
                        for (CustomItemBean customItemBean3 : groups2) {
                            customItemBean3.setType(dominateCustomBean.getType());
                            customItemBean3.setDuration(dominateCustomBean.getDuration());
                            arrayList.add(customItemBean3);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        if (id == MinaConstants.CODE_DOMINATE_CUSTOM || id == MinaConstants.CODE_DOMINATE_LEVEL1) {
            HomeViewModel homeViewModel = this.viewModel;
            if (homeViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                homeViewModel = null;
            }
            homeViewModel.getCustomDominateData();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MinaEventManager.getInstance().remove(this);
        GSYVideoManager.releaseAllVideos();
    }
}
