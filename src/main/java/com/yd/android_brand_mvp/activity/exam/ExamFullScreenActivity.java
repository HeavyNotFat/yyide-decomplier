package com.yd.android_brand_mvp.activity.exam;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.exam.fragment.NormalFullScreenFragment;
import com.yd.android_brand_mvp.activity.exam.fragment.SimpleFullScreenFragment;
import com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseDominateActivity;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.databinding.ActivityExamFullScreenBinding;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.observer.MinaListener;
import com.yd.android_brand_mvp.observer.NetWorkManager;
import com.yd.android_brand_mvp.observer.NetWorkStaus;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.WeatherUtils;
import com.yyide.facepass.AppExtKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ExamFullScreenActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001!B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0012H\u0014J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/ExamFullScreenActivity;", "Lcom/yd/android_brand_mvp/base/BaseDominateActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivityExamFullScreenBinding;", "Lcom/yd/android_brand_mvp/observer/NetWorkStaus;", "Lcom/yd/android_brand_mvp/observer/MinaListener;", "()V", "dataBean", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "isFullMode", "", "isPort", "viewModel", "Lcom/yd/android_brand_mvp/activity/home/viewmodel/HomeViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/home/viewmodel/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "", "changeContent", "fragment", "Landroidx/fragment/app/Fragment;", "getWork", "islive", "initListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setBackground", "setInfo", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamFullScreenActivity extends BaseDominateActivity<ActivityExamFullScreenBinding> implements NetWorkStaus, MinaListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ExamPlanItem dataBean;
    private boolean isFullMode;
    private boolean isPort;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.ExamFullScreenActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExamFullScreenActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LayoutInflater, ActivityExamFullScreenBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ActivityExamFullScreenBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/yd/android_brand_mvp/databinding/ActivityExamFullScreenBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ActivityExamFullScreenBinding invoke(LayoutInflater p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityExamFullScreenBinding.inflate(p0);
        }
    }

    public ExamFullScreenActivity() {
        super(AnonymousClass1.INSTANCE);
        this.isFullMode = true;
        final ExamFullScreenActivity examFullScreenActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.exam.ExamFullScreenActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = examFullScreenActivity.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.exam.ExamFullScreenActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = examFullScreenActivity.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.exam.ExamFullScreenActivity$special$$inlined$viewModels$default$3
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
                CreationExtras defaultViewModelCreationExtras = examFullScreenActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final /* synthetic */ ActivityExamFullScreenBinding access$getBinding(ExamFullScreenActivity examFullScreenActivity) {
        return examFullScreenActivity.getBinding();
    }

    /* JADX INFO: compiled from: ExamFullScreenActivity.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/ExamFullScreenActivity$Companion;", "", "()V", "startGo", "", "context", "Landroid/content/Context;", "isPortrait", "", "data", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "isShow", "(Landroid/content/Context;ZLcom/yd/android_brand_mvp/model/exam/ExamPlanItem;Ljava/lang/Boolean;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void startGo$default(Companion companion, Context context, boolean z, ExamPlanItem examPlanItem, Boolean bool, int i, Object obj) {
            if ((i & 8) != 0) {
                bool = false;
            }
            companion.startGo(context, z, examPlanItem, bool);
        }

        public final void startGo(Context context, boolean isPortrait, ExamPlanItem data, Boolean isShow) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Intent intent = new Intent(context, (Class<?>) ExamFullScreenActivity.class);
            intent.putExtra("isPortrait", isPortrait);
            intent.putExtra("data", data);
            intent.putExtra("isShow", isShow);
            context.startActivity(intent);
        }
    }

    private final HomeViewModel getViewModel() {
        return (HomeViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.BaseDominateActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.isPort = getIntent().getBooleanExtra("isPortrait", false);
        ExamPlanItem examPlanItem = (ExamPlanItem) getIntent().getParcelableExtra("data");
        if (examPlanItem == null) {
            examPlanItem = new ExamPlanItem(null, null, 0, null, 0, null, 0, null, 0, null, false, false, null, 0, null, 0, null, null, null, null, 0, 0, 0, false, 16777215, null);
        }
        this.dataBean = examPlanItem;
        ImageView imageView = getBinding().ivActivityExamFullScreenReturnBottom;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivActivityExamFullScreenReturnBottom");
        SimpleUtilsKt.hide(imageView);
        if (getIntent().getBooleanExtra("isShow", false)) {
            ImageView imageView2 = getBinding().ivActivityExamFullScreenReturnBottom;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivActivityExamFullScreenReturnBottom");
            SimpleUtilsKt.hide(imageView2);
            ImageView imageView3 = getBinding().ivFragmentExamFullReturn;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivFragmentExamFullReturn");
            SimpleUtilsKt.hide(imageView3);
        } else {
            ImageView imageView4 = getBinding().ivFragmentExamFullReturn;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivFragmentExamFullReturn");
            SimpleUtilsKt.show(imageView4);
            if (this.isPort) {
                ImageView imageView5 = getBinding().ivActivityExamFullScreenReturnBottom;
                Intrinsics.checkNotNullExpressionValue(imageView5, "binding.ivActivityExamFullScreenReturnBottom");
                SimpleUtilsKt.show(imageView5);
            }
        }
        NetWorkManager.getInstance().add(this);
        setInfo();
        setBackground();
        initListener();
        NormalFullScreenFragment.Companion companion = NormalFullScreenFragment.INSTANCE;
        ExamPlanItem examPlanItem2 = this.dataBean;
        if (examPlanItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem2 = null;
        }
        changeContent(companion.newInstance(examPlanItem2));
    }

    private final void setInfo() {
        TextView textView = getBinding().tvFragmentExamFullScreen;
        ExamPlanItem examPlanItem = this.dataBean;
        if (examPlanItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem = null;
        }
        textView.setText(examPlanItem.getExaminationRoomName());
        if (SpData.getSchoolInfo2() != null) {
            getBinding().topActivityExamFull.officename.setText(SpData.getSchoolInfo2().data.schoolName);
            getBinding().topActivityExamFull.tvText.setText(SpData.getSchoolInfo2().data.englishName);
            getBinding().topActivityExamFull.tvText.setVisibility(!TextUtils.isEmpty(SpData.getSchoolInfo2().data.englishName) ? 0 : 8);
            if (!ScreenUtils.isLandscape()) {
                TextView textView2 = getBinding().topActivityExamFull.tvText;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.topActivityExamFull.tvText");
                SimpleUtilsKt.remove(textView2);
            }
            GlideUtil.loadCircleImage(this, SpData.getSchoolInfo2().data.schoolLogo, getBinding().topActivityExamFull.logo);
        }
        NewWeatherBean newWeatherBean = (NewWeatherBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.WEATHER_NEW, NewWeatherBean.class);
        if (newWeatherBean != null) {
            getBinding().topActivityExamFull.weathericon.setImageDrawable(SimpleUtilsKt.asDrawable(WeatherUtils.imgCode(newWeatherBean.getWeather())));
            getBinding().topActivityExamFull.weathertext.setText(newWeatherBean.getWeather());
            getBinding().topActivityExamFull.wd.setText(newWeatherBean.getReal());
        }
    }

    private final void setBackground() {
        String str;
        if (SPUtils.getInstance().getBoolean(SpData.SKIN)) {
            getBinding().clActivityExamFull.setBackgroundResource(R.drawable.bp_bg);
            return;
        }
        if (SpData.HomeIndexData() == null || SpData.HomeIndexData().data.size() <= 0) {
            return;
        }
        String str2 = "";
        if (SpData.HomeIndexData().data.get(0).layoutClassSignDetailsEntityList.size() > 0) {
            str2 = SpData.HomeIndexData().data.get(0).layoutClassSignDetailsEntityList.get(0).backgropPhoto;
            str = SpData.HomeIndexData().data.get(0).layoutClassSignDetailsEntityList.get(0).backgropColour;
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            Glide.with((FragmentActivity) this).load(str2).into(new CustomTarget<Drawable>() { // from class: com.yd.android_brand_mvp.activity.exam.ExamFullScreenActivity.setBackground.1
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
                }

                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    ExamFullScreenActivity.access$getBinding(ExamFullScreenActivity.this).clActivityExamFull.setBackground(resource);
                }
            });
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            getBinding().clActivityExamFull.setBackgroundColor(Color.parseColor(str));
        }
    }

    private final void initListener() {
        getBinding().ivFragmentExamFullSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.exam.-$$Lambda$ExamFullScreenActivity$Hs71xSbPUzoJ9X634MjI4Nt_0Cw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamFullScreenActivity.initListener$lambda$1(this.f$0, view);
            }
        });
        getBinding().tvFragmentExamFullSwitch.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.exam.-$$Lambda$ExamFullScreenActivity$PKkv5JpWDLgLZMIf9tNGqom-uPU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamFullScreenActivity.initListener$lambda$2(this.f$0, view);
            }
        });
        getBinding().ivFragmentExamFullReturn.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.exam.-$$Lambda$ExamFullScreenActivity$cYwSJ5omePrm5HdGguTcViMUAGI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamFullScreenActivity.initListener$lambda$3(this.f$0, view);
            }
        });
        getBinding().ivActivityExamFullScreenReturnBottom.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.exam.-$$Lambda$ExamFullScreenActivity$ZEwOjnEZs2YbWleAxiG3nBc6oL0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamFullScreenActivity.initListener$lambda$4(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(ExamFullScreenActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExamPlanItem examPlanItem = null;
        if (this$0.isFullMode) {
            SimpleFullScreenFragment.Companion companion = SimpleFullScreenFragment.INSTANCE;
            ExamPlanItem examPlanItem2 = this$0.dataBean;
            if (examPlanItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            } else {
                examPlanItem = examPlanItem2;
            }
            this$0.changeContent(companion.newInstance(examPlanItem));
            this$0.getBinding().tvFragmentExamFullSwitch.setText(this$0.getString(R.string.exam_switch_normal));
            this$0.isFullMode = false;
            return;
        }
        NormalFullScreenFragment.Companion companion2 = NormalFullScreenFragment.INSTANCE;
        ExamPlanItem examPlanItem3 = this$0.dataBean;
        if (examPlanItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
        } else {
            examPlanItem = examPlanItem3;
        }
        this$0.changeContent(companion2.newInstance(examPlanItem));
        this$0.getBinding().tvFragmentExamFullSwitch.setText(this$0.getString(R.string.exam_switch_simple));
        this$0.isFullMode = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$2(ExamFullScreenActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExamPlanItem examPlanItem = null;
        if (this$0.isFullMode) {
            SimpleFullScreenFragment.Companion companion = SimpleFullScreenFragment.INSTANCE;
            ExamPlanItem examPlanItem2 = this$0.dataBean;
            if (examPlanItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            } else {
                examPlanItem = examPlanItem2;
            }
            this$0.changeContent(companion.newInstance(examPlanItem));
            this$0.getBinding().tvFragmentExamFullSwitch.setText(this$0.getString(R.string.exam_switch_normal));
            this$0.isFullMode = false;
            return;
        }
        NormalFullScreenFragment.Companion companion2 = NormalFullScreenFragment.INSTANCE;
        ExamPlanItem examPlanItem3 = this$0.dataBean;
        if (examPlanItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
        } else {
            examPlanItem = examPlanItem3;
        }
        this$0.changeContent(companion2.newInstance(examPlanItem));
        this$0.getBinding().tvFragmentExamFullSwitch.setText(this$0.getString(R.string.exam_switch_simple));
        this$0.isFullMode = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$3(ExamFullScreenActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseConstant.DOMINATE_CLOSE = true;
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$4(ExamFullScreenActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseConstant.DOMINATE_CLOSE = true;
        this$0.finish();
    }

    private final void changeContent(Fragment fragment) {
        StringBuilder sb = new StringBuilder();
        sb.append("dataBean = ");
        ExamPlanItem examPlanItem = this.dataBean;
        if (examPlanItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBean");
            examPlanItem = null;
        }
        sb.append(examPlanItem);
        AppExtKt.logd(this, sb.toString());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        fragmentTransactionBeginTransaction.replace(R.id.fragment_exam_full_content, fragment);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.yd.android_brand_mvp.observer.NetWorkStaus
    public void getWork(boolean islive) {
        if (islive) {
            if (Intrinsics.areEqual(Tool.getNetworkAvailableTypeName(this).getTypeName(), "Ethernet")) {
                getBinding().topActivityExamFull.wifi.setImageResource(R.drawable.network_intneter);
                return;
            }
            int iObtainWifiInfo = Tool.obtainWifiInfo(this);
            if (iObtainWifiInfo == 0) {
                getBinding().topActivityExamFull.wifi.setImageResource(R.drawable.wifi1);
                return;
            }
            if (iObtainWifiInfo == 1) {
                getBinding().topActivityExamFull.wifi.setImageResource(R.drawable.wifi1);
                return;
            }
            if (iObtainWifiInfo == 2) {
                getBinding().topActivityExamFull.wifi.setImageResource(R.drawable.wifi2);
                return;
            }
            if (iObtainWifiInfo == 3) {
                getBinding().topActivityExamFull.wifi.setImageResource(R.drawable.wifi3);
                return;
            } else if (iObtainWifiInfo == 4) {
                getBinding().topActivityExamFull.wifi.setImageResource(R.drawable.wifi4);
                return;
            } else {
                if (iObtainWifiInfo != 5) {
                    return;
                }
                getBinding().topActivityExamFull.wifi.setImageResource(R.drawable.wifi4);
                return;
            }
        }
        getBinding().topActivityExamFull.wifi.setImageResource(R.drawable.wifi_false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        NetWorkManager.getInstance().remove(this);
    }
}
