package com.yd.android_brand_mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager2.widget.ViewPager2;
import androidx.work.WorkRequest;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.ActivityDominateScreenBinding;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.model.WebSocketDominateParamBean;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.observer.MinaListener;
import com.yd.android_brand_mvp.utils.MMKVUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DominateScreenActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000e\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002+,B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u001eH\u0014J\u0012\u0010&\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/yd/android_brand_mvp/activity/DominateScreenActivity;", "Lcom/yd/android_brand_mvp/base/BaseActivity;", "Lcom/yd/android_brand_mvp/observer/MinaListener;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lkotlin/collections/ArrayList;", "dataListAll", "handler", "Lcom/yd/android_brand_mvp/activity/DominateScreenActivity$LooperHandler;", FirebaseAnalytics.Param.INDEX, "", "mAdapter", "com/yd/android_brand_mvp/activity/DominateScreenActivity$mAdapter$1", "Lcom/yd/android_brand_mvp/activity/DominateScreenActivity$mAdapter$1;", "newsIndex", "running", "Ljava/lang/Runnable;", "time", "", "viewBinding", "Lcom/yd/android_brand_mvp/databinding/ActivityDominateScreenBinding;", "viewModel", "Lcom/yd/android_brand_mvp/activity/home/viewmodel/HomeViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/home/viewmodel/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "removeData", "setAdapter", "Companion", "LooperHandler", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DominateScreenActivity extends BaseActivity implements MinaListener {
    private LooperHandler handler;
    private int index;
    private int newsIndex;
    private ActivityDominateScreenBinding viewBinding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS_ALL = "listDataAll";
    private static final String PARAMS = "listData";
    private ArrayList<MessageItemBean> dataListAll = new ArrayList<>();
    private ArrayList<MessageItemBean> dataList = new ArrayList<>();
    private long time = WorkRequest.MIN_BACKOFF_MILLIS;
    private final Runnable running = new Runnable() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$DominateScreenActivity$DxrCkfYXJZnQvPF6qLBgQlF4ksY
        @Override // java.lang.Runnable
        public final void run() {
            DominateScreenActivity.running$lambda$7(this.f$0);
        }
    };
    private final DominateScreenActivity$mAdapter$1 mAdapter = new DominateScreenActivity$mAdapter$1();

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    public DominateScreenActivity() {
        final DominateScreenActivity dominateScreenActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.DominateScreenActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = dominateScreenActivity.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.DominateScreenActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = dominateScreenActivity.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.DominateScreenActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                if (function1 != null && (creationExtras = (CreationExtras) function1.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = dominateScreenActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    private final HomeViewModel getViewModel() {
        return (HomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: compiled from: DominateScreenActivity.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JW\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/activity/DominateScreenActivity$Companion;", "", "()V", "PARAMS", "", "PARAMS_ALL", TtmlNode.START, "", "context", "Landroid/content/Context;", "listAll", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lkotlin/collections/ArrayList;", TUIKitConstants.Selection.LIST, "isShow", "", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Boolean;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, ArrayList arrayList, ArrayList arrayList2, Boolean bool, int i, Object obj) {
            if ((i & 8) != 0) {
                bool = false;
            }
            companion.start(context, arrayList, arrayList2, bool);
        }

        public final void start(Context context, ArrayList<MessageItemBean> listAll, ArrayList<MessageItemBean> list, Boolean isShow) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) DominateScreenActivity.class);
            intent.putParcelableArrayListExtra(DominateScreenActivity.PARAMS_ALL, listAll);
            intent.putParcelableArrayListExtra(DominateScreenActivity.PARAMS, list);
            intent.putExtra("isShow", isShow);
            ActivityUtils.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.isAutoClose = false;
        ActivityDominateScreenBinding activityDominateScreenBindingInflate = ActivityDominateScreenBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityDominateScreenBindingInflate, "inflate(layoutInflater)");
        this.viewBinding = activityDominateScreenBindingInflate;
        ActivityDominateScreenBinding activityDominateScreenBinding = null;
        if (activityDominateScreenBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityDominateScreenBindingInflate = null;
        }
        setContentView(activityDominateScreenBindingInflate.getRoot());
        MinaEventManager.getInstance().add(this);
        if (getIntent().getBooleanExtra("isShow", false)) {
            ActivityDominateScreenBinding activityDominateScreenBinding2 = this.viewBinding;
            if (activityDominateScreenBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                activityDominateScreenBinding2 = null;
            }
            ImageView imageView = activityDominateScreenBinding2.ivClose;
            Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.ivClose");
            SimpleUtilsKt.hide(imageView);
        } else {
            ActivityDominateScreenBinding activityDominateScreenBinding3 = this.viewBinding;
            if (activityDominateScreenBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                activityDominateScreenBinding3 = null;
            }
            ImageView imageView2 = activityDominateScreenBinding3.ivClose;
            Intrinsics.checkNotNullExpressionValue(imageView2, "viewBinding.ivClose");
            SimpleUtilsKt.show(imageView2);
        }
        ActivityDominateScreenBinding activityDominateScreenBinding4 = this.viewBinding;
        if (activityDominateScreenBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityDominateScreenBinding4 = null;
        }
        activityDominateScreenBinding4.ivLeft.setVisibility(8);
        ActivityDominateScreenBinding activityDominateScreenBinding5 = this.viewBinding;
        if (activityDominateScreenBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityDominateScreenBinding5 = null;
        }
        activityDominateScreenBinding5.ivRight.setVisibility(8);
        ActivityDominateScreenBinding activityDominateScreenBinding6 = this.viewBinding;
        if (activityDominateScreenBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            activityDominateScreenBinding = activityDominateScreenBinding6;
        }
        activityDominateScreenBinding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$DominateScreenActivity$GY8ba_OFU30P_RvMkeS5WLFQQjA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DominateScreenActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        ArrayList<MessageItemBean> arrayList = this.dataListAll;
        Collection<? extends MessageItemBean> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(PARAMS_ALL);
        if (parcelableArrayListExtra == null) {
            parcelableArrayListExtra = CollectionsKt.emptyList();
        }
        arrayList.addAll(parcelableArrayListExtra);
        ArrayList<MessageItemBean> arrayList2 = this.dataList;
        Collection<? extends MessageItemBean> parcelableArrayListExtra2 = getIntent().getParcelableArrayListExtra(PARAMS);
        if (parcelableArrayListExtra2 == null) {
            parcelableArrayListExtra2 = CollectionsKt.emptyList();
        }
        arrayList2.addAll(parcelableArrayListExtra2);
        String dominateLevel = MMKVUtil.INSTANCE.getDominateLevel();
        if (dominateLevel.length() > 0) {
            this.time = WorkRequest.MIN_BACKOFF_MILLIS;
            AppExtKt.logd(this, "duration = " + this.time);
        }
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(DominateScreenActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseConstant.DOMINATE_CLOSE = true;
        this$0.finish();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.dataListAll.clear();
            this.dataList.clear();
            ArrayList<MessageItemBean> arrayList = this.dataListAll;
            Collection<? extends MessageItemBean> parcelableArrayListExtra = intent.getParcelableArrayListExtra(PARAMS_ALL);
            if (parcelableArrayListExtra == null) {
                parcelableArrayListExtra = CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNullExpressionValue(parcelableArrayListExtra, "it.getParcelableArrayLis…ARAMS_ALL) ?: emptyList()");
            }
            arrayList.addAll(parcelableArrayListExtra);
            ArrayList<MessageItemBean> arrayList2 = this.dataList;
            Collection<? extends MessageItemBean> parcelableArrayListExtra2 = intent.getParcelableArrayListExtra(PARAMS);
            if (parcelableArrayListExtra2 == null) {
                parcelableArrayListExtra2 = CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNullExpressionValue(parcelableArrayListExtra2, "it.getParcelableArrayLis…ra(PARAMS) ?: emptyList()");
            }
            arrayList2.addAll(parcelableArrayListExtra2);
            setAdapter();
            if (this.dataList.containsAll(this.mAdapter.getData()) || this.mAdapter.getData().containsAll(this.dataList)) {
                return;
            }
            ActivityDominateScreenBinding activityDominateScreenBinding = this.viewBinding;
            ActivityDominateScreenBinding activityDominateScreenBinding2 = null;
            if (activityDominateScreenBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                activityDominateScreenBinding = null;
            }
            activityDominateScreenBinding.ivLeft.setVisibility(8);
            ActivityDominateScreenBinding activityDominateScreenBinding3 = this.viewBinding;
            if (activityDominateScreenBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                activityDominateScreenBinding3 = null;
            }
            activityDominateScreenBinding3.ivRight.setVisibility(8);
            this.mAdapter.setList(CollectionsKt.sortedWith(this.dataList, new Comparator() { // from class: com.yd.android_brand_mvp.activity.DominateScreenActivity$onNewIntent$lambda$2$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((MessageItemBean) t).getDominateStartTime(), ((MessageItemBean) t2).getDominateStartTime());
                }
            }));
            ActivityDominateScreenBinding activityDominateScreenBinding4 = this.viewBinding;
            if (activityDominateScreenBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                activityDominateScreenBinding2 = activityDominateScreenBinding4;
            }
            activityDominateScreenBinding2.viewPager2.setCurrentItem(0);
        }
    }

    private final void initView() {
        ActivityDominateScreenBinding activityDominateScreenBinding = this.viewBinding;
        LooperHandler looperHandler = null;
        if (activityDominateScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityDominateScreenBinding = null;
        }
        activityDominateScreenBinding.viewPager2.setOrientation(0);
        ActivityDominateScreenBinding activityDominateScreenBinding2 = this.viewBinding;
        if (activityDominateScreenBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityDominateScreenBinding2 = null;
        }
        activityDominateScreenBinding2.viewPager2.setAdapter(this.mAdapter);
        ActivityDominateScreenBinding activityDominateScreenBinding3 = this.viewBinding;
        if (activityDominateScreenBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityDominateScreenBinding3 = null;
        }
        activityDominateScreenBinding3.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.yd.android_brand_mvp.activity.DominateScreenActivity.initView.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (DominateScreenActivity.this.index != position) {
                    AppExtKt.loge(this, "position" + position);
                    ActivityDominateScreenBinding activityDominateScreenBinding4 = null;
                    if (position > 0) {
                        ActivityDominateScreenBinding activityDominateScreenBinding5 = DominateScreenActivity.this.viewBinding;
                        if (activityDominateScreenBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            activityDominateScreenBinding5 = null;
                        }
                        activityDominateScreenBinding5.ivLeft.setVisibility(0);
                    } else {
                        ActivityDominateScreenBinding activityDominateScreenBinding6 = DominateScreenActivity.this.viewBinding;
                        if (activityDominateScreenBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            activityDominateScreenBinding6 = null;
                        }
                        activityDominateScreenBinding6.ivLeft.setVisibility(8);
                    }
                    if (DominateScreenActivity.this.mAdapter.getData().size() <= 0 || DominateScreenActivity.this.mAdapter.getData().size() - 1 == position) {
                        ActivityDominateScreenBinding activityDominateScreenBinding7 = DominateScreenActivity.this.viewBinding;
                        if (activityDominateScreenBinding7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        } else {
                            activityDominateScreenBinding4 = activityDominateScreenBinding7;
                        }
                        activityDominateScreenBinding4.ivRight.setVisibility(8);
                    } else {
                        ActivityDominateScreenBinding activityDominateScreenBinding8 = DominateScreenActivity.this.viewBinding;
                        if (activityDominateScreenBinding8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        } else {
                            activityDominateScreenBinding4 = activityDominateScreenBinding8;
                        }
                        activityDominateScreenBinding4.ivRight.setVisibility(0);
                    }
                }
                DominateScreenActivity.this.index = position;
            }
        });
        this.mAdapter.setList(CollectionsKt.sortedWith(this.dataList, new Comparator() { // from class: com.yd.android_brand_mvp.activity.DominateScreenActivity$initView$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MessageItemBean) t).getDominateStartTime(), ((MessageItemBean) t2).getDominateStartTime());
            }
        }));
        if (this.dataList.size() > 1) {
            ActivityDominateScreenBinding activityDominateScreenBinding4 = this.viewBinding;
            if (activityDominateScreenBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                activityDominateScreenBinding4 = null;
            }
            ImageView imageView = activityDominateScreenBinding4.ivRight;
            Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.ivRight");
            SimpleUtilsKt.show(imageView);
        }
        ActivityDominateScreenBinding activityDominateScreenBinding5 = this.viewBinding;
        if (activityDominateScreenBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityDominateScreenBinding5 = null;
        }
        activityDominateScreenBinding5.ivLeft.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$DominateScreenActivity$nJq6yOTVW3G-jHBCa1vJvrZHLz8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DominateScreenActivity.initView$lambda$4(this.f$0, view);
            }
        });
        ActivityDominateScreenBinding activityDominateScreenBinding6 = this.viewBinding;
        if (activityDominateScreenBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityDominateScreenBinding6 = null;
        }
        activityDominateScreenBinding6.ivRight.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$DominateScreenActivity$ni8NOhz1snu0n563KvNx7H74Dxg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DominateScreenActivity.initView$lambda$5(this.f$0, view);
            }
        });
        LooperHandler looperHandler2 = new LooperHandler(this);
        this.handler = looperHandler2;
        if (looperHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handler");
        } else {
            looperHandler = looperHandler2;
        }
        looperHandler.postDelayed(this.running, this.time);
        final Function1<Result<? extends List<? extends MessageItemBean>>, Unit> function1 = new Function1<Result<? extends List<? extends MessageItemBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.DominateScreenActivity.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends MessageItemBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends MessageItemBean>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                ActivityDominateScreenBinding activityDominateScreenBinding7 = null;
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                if (list == null) {
                    return;
                }
                DominateScreenActivity.this.dataListAll.clear();
                DominateScreenActivity.this.dataList.clear();
                DominateScreenActivity.this.dataListAll.addAll(list);
                DominateScreenActivity.this.setAdapter();
                if (DominateScreenActivity.this.dataList.containsAll(DominateScreenActivity.this.mAdapter.getData()) || DominateScreenActivity.this.mAdapter.getData().containsAll(DominateScreenActivity.this.dataList)) {
                    return;
                }
                ActivityDominateScreenBinding activityDominateScreenBinding8 = DominateScreenActivity.this.viewBinding;
                if (activityDominateScreenBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    activityDominateScreenBinding8 = null;
                }
                activityDominateScreenBinding8.ivLeft.setVisibility(8);
                ActivityDominateScreenBinding activityDominateScreenBinding9 = DominateScreenActivity.this.viewBinding;
                if (activityDominateScreenBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    activityDominateScreenBinding9 = null;
                }
                activityDominateScreenBinding9.ivRight.setVisibility(8);
                DominateScreenActivity.this.mAdapter.setList(CollectionsKt.sortedWith(DominateScreenActivity.this.dataList, new Comparator() { // from class: com.yd.android_brand_mvp.activity.DominateScreenActivity$initView$5$invoke$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MessageItemBean) t).getDominateStartTime(), ((MessageItemBean) t2).getDominateStartTime());
                    }
                }));
                ActivityDominateScreenBinding activityDominateScreenBinding10 = DominateScreenActivity.this.viewBinding;
                if (activityDominateScreenBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                } else {
                    activityDominateScreenBinding7 = activityDominateScreenBinding10;
                }
                activityDominateScreenBinding7.viewPager2.setCurrentItem(0);
            }
        };
        getViewModel().getDominateMessageList().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$DominateScreenActivity$vPhSdevtKTBUcyqHlHfYFxXP9mY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DominateScreenActivity.initView$lambda$6(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(DominateScreenActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.newsIndex - 1;
        this$0.newsIndex = i;
        if (i <= 0) {
            this$0.newsIndex = 0;
        }
        ActivityDominateScreenBinding activityDominateScreenBinding = this$0.viewBinding;
        if (activityDominateScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityDominateScreenBinding = null;
        }
        activityDominateScreenBinding.viewPager2.setCurrentItem(this$0.newsIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(DominateScreenActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.newsIndex + 1;
        this$0.newsIndex = i;
        if (i > this$0.mAdapter.getData().size()) {
            this$0.newsIndex = this$0.mAdapter.getData().size();
        }
        ActivityDominateScreenBinding activityDominateScreenBinding = this$0.viewBinding;
        if (activityDominateScreenBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityDominateScreenBinding = null;
        }
        activityDominateScreenBinding.viewPager2.setCurrentItem(this$0.newsIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: compiled from: DominateScreenActivity.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/DominateScreenActivity$LooperHandler;", "Landroid/os/Handler;", PushConstants.INTENT_ACTIVITY_NAME, "Lcom/yd/android_brand_mvp/activity/DominateScreenActivity;", "(Lcom/yd/android_brand_mvp/activity/DominateScreenActivity;)V", "mWeakReference", "Ljava/lang/ref/WeakReference;", "getMWeakReference", "()Ljava/lang/ref/WeakReference;", "setMWeakReference", "(Ljava/lang/ref/WeakReference;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class LooperHandler extends Handler {
        private WeakReference<DominateScreenActivity> mWeakReference;

        public LooperHandler(DominateScreenActivity dominateScreenActivity) {
            this.mWeakReference = new WeakReference<>(dominateScreenActivity);
        }

        public final WeakReference<DominateScreenActivity> getMWeakReference() {
            return this.mWeakReference;
        }

        public final void setMWeakReference(WeakReference<DominateScreenActivity> weakReference) {
            Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
            this.mWeakReference = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Runnable runnable;
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            DominateScreenActivity dominateScreenActivity = this.mWeakReference.get();
            if (dominateScreenActivity == null || (runnable = dominateScreenActivity.running) == null) {
                return;
            }
            DominateScreenActivity dominateScreenActivity2 = this.mWeakReference.get();
            Intrinsics.checkNotNull(dominateScreenActivity2);
            postDelayed(runnable, dominateScreenActivity2.time + ((long) 2000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void running$lambda$7(DominateScreenActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LooperHandler looperHandler = this$0.handler;
        if (looperHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handler");
            looperHandler = null;
        }
        looperHandler.sendEmptyMessage(1);
        this$0.removeData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAdapter() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (MessageItemBean messageItemBean : this.dataListAll) {
            if (TimeUtil.gettime22(messageItemBean.getDominateStartTime()) < jCurrentTimeMillis && TimeUtil.gettime22(messageItemBean.getDominateEndTime()) > jCurrentTimeMillis) {
                arrayList.add(messageItemBean);
            }
        }
        this.dataList.clear();
        this.dataList.addAll(arrayList);
        if (this.dataList.isEmpty()) {
            finish();
        }
    }

    private final void removeData() {
        if (this.mAdapter.getData().size() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i = 0;
            for (Object obj : this.mAdapter.getData()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (TimeUtil.gettime22(((MessageItemBean) obj).getDominateEndTime()) <= jCurrentTimeMillis && i < this.dataList.size()) {
                    this.dataList.remove(i);
                }
                i = i2;
            }
            if (this.mAdapter.getData().size() == this.dataList.size()) {
                setAdapter();
            }
            if (this.mAdapter.getData().size() != this.dataList.size()) {
                setAdapter();
                this.mAdapter.setList(CollectionsKt.sortedWith(this.dataList, new Comparator() { // from class: com.yd.android_brand_mvp.activity.DominateScreenActivity$removeData$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((MessageItemBean) t).getDominateStartTime(), ((MessageItemBean) t2).getDominateStartTime());
                    }
                }));
            }
            if (this.mAdapter.getData().size() == 0) {
                finish();
                return;
            }
            if (this.mAdapter.getData().size() > 1) {
                int size = this.mAdapter.getData().size() - 1;
                int i3 = this.index;
                ActivityDominateScreenBinding activityDominateScreenBinding = null;
                if (size > i3) {
                    this.index = i3 + 1;
                    if (this.mAdapter.getData().size() == this.index) {
                        this.index = this.mAdapter.getData().size() - 1;
                    }
                    ActivityDominateScreenBinding activityDominateScreenBinding2 = this.viewBinding;
                    if (activityDominateScreenBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    } else {
                        activityDominateScreenBinding = activityDominateScreenBinding2;
                    }
                    activityDominateScreenBinding.viewPager2.setCurrentItem(this.index);
                    return;
                }
                this.index = 0;
                ActivityDominateScreenBinding activityDominateScreenBinding3 = this.viewBinding;
                if (activityDominateScreenBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                } else {
                    activityDominateScreenBinding = activityDominateScreenBinding3;
                }
                activityDominateScreenBinding.viewPager2.setCurrentItem(this.index);
                return;
            }
            return;
        }
        finish();
    }

    @Override // com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        if (id == MinaConstants.Dominate || id == MinaConstants.Notice) {
            getViewModel().getMessagePublishData();
        } else if (id == MinaConstants.CODE_DOMINATE_LEVEL1) {
            String dominateLevel = MMKVUtil.INSTANCE.getDominateLevel();
            if (dominateLevel.length() > 0) {
                this.time = ((WebSocketDominateParamBean) GsonUtils.fromJson(dominateLevel, WebSocketDominateParamBean.class)).getDuration() * 1000;
            }
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LooperHandler looperHandler = this.handler;
        if (looperHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handler");
            looperHandler = null;
        }
        looperHandler.removeCallbacksAndMessages(null);
        MinaEventManager.getInstance().remove(this);
    }
}
