package com.yd.android_brand_mvp.activity.reserve;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel;
import com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseDominateActivity;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ActivityReservationFullBinding;
import com.yd.android_brand_mvp.databinding.ItemReservationSignBinding;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.model.reservation.ReservationSignListItemBean;
import com.yd.android_brand_mvp.observer.MinaListener;
import com.yd.android_brand_mvp.observer.NetWorkManager;
import com.yd.android_brand_mvp.observer.NetWorkStaus;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.WeatherUtils;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: ReservationFullActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000f\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001*B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\u001bH\u0014J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u001bH\u0014J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0007J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/yd/android_brand_mvp/activity/reserve/ReservationFullActivity;", "Lcom/yd/android_brand_mvp/base/BaseDominateActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivityReservationFullBinding;", "Lcom/yd/android_brand_mvp/observer/NetWorkStaus;", "Lcom/yd/android_brand_mvp/observer/MinaListener;", "()V", "homeViewModel", "Lcom/yd/android_brand_mvp/activity/home/viewmodel/HomeViewModel;", "getHomeViewModel", "()Lcom/yd/android_brand_mvp/activity/home/viewmodel/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "isAvailableNetWork", "", "peopleAdapter", "com/yd/android_brand_mvp/activity/reserve/ReservationFullActivity$peopleAdapter$2$1", "getPeopleAdapter", "()Lcom/yd/android_brand_mvp/activity/reserve/ReservationFullActivity$peopleAdapter$2$1;", "peopleAdapter$delegate", "showData", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "viewModel", "Lcom/yd/android_brand_mvp/activity/reserve/viewmodel/ReservationViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/reserve/viewmodel/ReservationViewModel;", "viewModel$delegate", "UpdataEvent", "", "id", "", "getWork", "islive", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "setBackground", "setInfo", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReservationFullActivity extends BaseDominateActivity<ActivityReservationFullBinding> implements NetWorkStaus, MinaListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: homeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy homeViewModel;
    private boolean isAvailableNetWork;

    /* JADX INFO: renamed from: peopleAdapter$delegate, reason: from kotlin metadata */
    private final Lazy peopleAdapter;
    private ReservationRecordBean showData;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReservationFullActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LayoutInflater, ActivityReservationFullBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ActivityReservationFullBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/yd/android_brand_mvp/databinding/ActivityReservationFullBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ActivityReservationFullBinding invoke(LayoutInflater p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityReservationFullBinding.inflate(p0);
        }
    }

    public static final /* synthetic */ ActivityReservationFullBinding access$getBinding(ReservationFullActivity reservationFullActivity) {
        return reservationFullActivity.getBinding();
    }

    public ReservationFullActivity() {
        super(AnonymousClass1.INSTANCE);
        this.isAvailableNetWork = true;
        final ReservationFullActivity reservationFullActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ReservationViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = reservationFullActivity.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = reservationFullActivity.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity$special$$inlined$viewModels$default$3
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
                CreationExtras defaultViewModelCreationExtras = reservationFullActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
        this.homeViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity$special$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = reservationFullActivity.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity$special$$inlined$viewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = reservationFullActivity.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity$special$$inlined$viewModels$default$6
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
                CreationExtras defaultViewModelCreationExtras = reservationFullActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
        this.peopleAdapter = LazyKt.lazy(new Function0<ReservationFullActivity$peopleAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity$peopleAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity$peopleAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemReservationSignBinding, ReservationSignListItemBean>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity$peopleAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ReservationSignListItemBean reservationSignListItemBean) {
                        convertPlus2((VBViewHolder<ItemReservationSignBinding>) vBViewHolder, reservationSignListItemBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemReservationSignBinding> holder, ReservationSignListItemBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemReservationSignBinding itemReservationSignBinding = (ItemReservationSignBinding) holder.getBinding();
                        if (itemReservationSignBinding != null) {
                            GlideUtil.loadCircleImage(getContext(), item.getAvatar(), itemReservationSignBinding.ivItemReservationSignAvatar);
                            itemReservationSignBinding.tvItemReservationSignName.setText(item.getUserName());
                            if (item.getToSignInTime().length() == 0) {
                                TextView textView = itemReservationSignBinding.tvItemReservationSignTip;
                                Intrinsics.checkNotNullExpressionValue(textView, "it.tvItemReservationSignTip");
                                SimpleUtilsKt.hide(textView);
                                TextView textView2 = itemReservationSignBinding.tvItemReservationSignTime;
                                Intrinsics.checkNotNullExpressionValue(textView2, "it.tvItemReservationSignTime");
                                SimpleUtilsKt.remove(textView2);
                                return;
                            }
                            TextView textView3 = itemReservationSignBinding.tvItemReservationSignTip;
                            Intrinsics.checkNotNullExpressionValue(textView3, "it.tvItemReservationSignTip");
                            SimpleUtilsKt.show(textView3);
                            TextView textView4 = itemReservationSignBinding.tvItemReservationSignTime;
                            Intrinsics.checkNotNullExpressionValue(textView4, "it.tvItemReservationSignTime");
                            SimpleUtilsKt.show(textView4);
                            itemReservationSignBinding.tvItemReservationSignTime.setText(item.getToSignInTime());
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemReservationSignBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemReservationSignBinding itemReservationSignBindingInflate = ItemReservationSignBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemReservationSignBindingInflate, "inflate(inflater, parent, false)");
                        return itemReservationSignBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: ReservationFullActivity.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/activity/reserve/ReservationFullActivity$Companion;", "", "()V", "startGo", "", "context", "Landroid/content/Context;", "data", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "nextData", "isShow", "", "(Landroid/content/Context;Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;Ljava/lang/Boolean;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void startGo$default(Companion companion, Context context, ReservationRecordBean reservationRecordBean, ReservationRecordBean reservationRecordBean2, Boolean bool, int i, Object obj) {
            if ((i & 8) != 0) {
                bool = false;
            }
            companion.startGo(context, reservationRecordBean, reservationRecordBean2, bool);
        }

        public final void startGo(Context context, ReservationRecordBean data, ReservationRecordBean nextData, Boolean isShow) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Intent intent = new Intent(context, (Class<?>) ReservationFullActivity.class);
            intent.putExtra("data", data);
            intent.putExtra("isShow", isShow);
            if (nextData != null) {
                intent.putExtra("nextData", nextData);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReservationViewModel getViewModel() {
        return (ReservationViewModel) this.viewModel.getValue();
    }

    private final HomeViewModel getHomeViewModel() {
        return (HomeViewModel) this.homeViewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.BaseDominateActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        NetWorkManager.getInstance().add(this);
        setInfo();
        setBackground();
    }

    @Override // com.yd.android_brand_mvp.observer.NetWorkStaus
    public void getWork(boolean islive) {
        this.isAvailableNetWork = islive;
        if (islive) {
            if (Intrinsics.areEqual(Tool.getNetworkAvailableTypeName(this).getTypeName(), "Ethernet")) {
                getBinding().topActivityReservationFull.wifi.setImageResource(R.drawable.network_intneter);
                return;
            }
            int iObtainWifiInfo = Tool.obtainWifiInfo(this);
            if (iObtainWifiInfo == 0) {
                getBinding().topActivityReservationFull.wifi.setImageResource(R.drawable.wifi1);
                return;
            }
            if (iObtainWifiInfo == 1) {
                getBinding().topActivityReservationFull.wifi.setImageResource(R.drawable.wifi1);
                return;
            }
            if (iObtainWifiInfo == 2) {
                getBinding().topActivityReservationFull.wifi.setImageResource(R.drawable.wifi2);
                return;
            }
            if (iObtainWifiInfo == 3) {
                getBinding().topActivityReservationFull.wifi.setImageResource(R.drawable.wifi3);
                return;
            } else if (iObtainWifiInfo == 4) {
                getBinding().topActivityReservationFull.wifi.setImageResource(R.drawable.wifi4);
                return;
            } else {
                if (iObtainWifiInfo != 5) {
                    return;
                }
                getBinding().topActivityReservationFull.wifi.setImageResource(R.drawable.wifi4);
                return;
            }
        }
        getBinding().topActivityReservationFull.wifi.setImageResource(R.drawable.wifi_false);
    }

    private final void setInfo() {
        getBinding().topActivityReservationFull.tvText.setText("");
        if (SpData.getSchoolInfo2() != null) {
            getBinding().topActivityReservationFull.officename.setText(SpData.getSchoolInfo2().data.schoolName);
            getBinding().topActivityReservationFull.tvText.setText(SpData.getSchoolInfo2().data.englishName);
            getBinding().topActivityReservationFull.tvText.setVisibility(!TextUtils.isEmpty(SpData.getSchoolInfo2().data.englishName) ? 0 : 8);
            if (!ScreenUtils.isLandscape()) {
                TextView textView = getBinding().topActivityReservationFull.tvText;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.topActivityReservationFull.tvText");
                SimpleUtilsKt.remove(textView);
            }
            GlideUtil.loadCircleImage(this, SpData.getSchoolInfo2().data.schoolLogo, getBinding().topActivityReservationFull.logo);
        }
        NewWeatherBean newWeatherBean = (NewWeatherBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.WEATHER_NEW, NewWeatherBean.class);
        if (newWeatherBean != null) {
            getBinding().topActivityReservationFull.weathericon.setImageDrawable(SimpleUtilsKt.asDrawable(WeatherUtils.imgCode(newWeatherBean.getWeather())));
            getBinding().topActivityReservationFull.weathertext.setText(newWeatherBean.getWeather());
            getBinding().topActivityReservationFull.wd.setText(newWeatherBean.getReal());
        }
    }

    private final void setBackground() {
        String str;
        if (SPUtils.getInstance().getBoolean(SpData.SKIN)) {
            getBinding().clActivityReservationFull.setBackgroundResource(R.drawable.bp_bg);
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
            Glide.with((FragmentActivity) this).load(str2).into(new CustomTarget<Drawable>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity.setBackground.1
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
                }

                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    ReservationFullActivity.access$getBinding(ReservationFullActivity.this).clActivityReservationFull.setBackground(resource);
                }
            });
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            getBinding().clActivityReservationFull.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReservationFullActivity$peopleAdapter$2.AnonymousClass1 getPeopleAdapter() {
        return (ReservationFullActivity$peopleAdapter$2.AnonymousClass1) this.peopleAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.BaseDominateActivity
    protected void initView() {
        super.initView();
        this.showData = (ReservationRecordBean) getIntent().getParcelableExtra("data");
        ReservationRecordBean reservationRecordBean = (ReservationRecordBean) getIntent().getParcelableExtra("nextData");
        if (getIntent().getBooleanExtra("isShow", false)) {
            ImageView imageView = getBinding().ivFragmentReservationFullReturn;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivFragmentReservationFullReturn");
            SimpleUtilsKt.hide(imageView);
        } else {
            ImageView imageView2 = getBinding().ivFragmentReservationFullReturn;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivFragmentReservationFullReturn");
            SimpleUtilsKt.show(imageView2);
        }
        if (reservationRecordBean == null) {
            getBinding().tvActivityReservationFullNextTheme.setText("暂无");
            getBinding().tvActivityReservationFullNextTime.setText("");
        } else {
            getBinding().tvActivityReservationFullNextTheme.setText(reservationRecordBean.getName());
            getBinding().tvActivityReservationFullNextTime.setText(new Regex("\\s+").split(reservationRecordBean.getBookingTime(), 0).get(1));
        }
        getBinding().ivFragmentReservationFullReturn.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.reserve.-$$Lambda$ReservationFullActivity$c84faHNznDRdP7W1fI8tL21l0f4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReservationFullActivity.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().ivActivityReservationFullScreenReturnBottom.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.reserve.-$$Lambda$ReservationFullActivity$I9ghYTIaW12THEo68_qqLqPouzo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReservationFullActivity.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().btnActivityReservationFullSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.reserve.-$$Lambda$ReservationFullActivity$BvVNofxYAdTJoyuYQ_jZrhVKHf0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReservationFullActivity.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().rvActivityReservationFullPeople.setLayoutManager(new GridLayoutManager(this, ScreenUtils.isPortrait() ? 5 : 7));
        getBinding().rvActivityReservationFullPeople.setAdapter(getPeopleAdapter());
        getBinding().rvActivityReservationFullPeople.setItemAnimator(null);
        ReservationRecordBean reservationRecordBean2 = this.showData;
        if (reservationRecordBean2 != null) {
            getViewModel().getReservationDetail(reservationRecordBean2.getId());
        }
        LiveData<ReservationDetailBean> reservationDetail = getViewModel().getReservationDetail();
        ReservationFullActivity reservationFullActivity = this;
        final Function1<ReservationDetailBean, Unit> function1 = new Function1<ReservationDetailBean, Unit>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity.initView.5
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
                if (reservationDetailBean == null) {
                    SimpleUtilsKt.showLongToast(ReservationFullActivity.this, "请求会议详情异常");
                    return;
                }
                ReservationFullActivity.access$getBinding(ReservationFullActivity.this).tvActivityReservationFullTheme.setText(reservationDetailBean.getName());
                ReservationFullActivity.access$getBinding(ReservationFullActivity.this).tvActivityReservationFullTime.setText(new Regex("\\s+").split(reservationDetailBean.getBookingTime(), 0).get(1));
                ReservationFullActivity.access$getBinding(ReservationFullActivity.this).tvActivityReservationFullExplain.setText(reservationDetailBean.getDescribe());
                if (reservationDetailBean.getSignIn()) {
                    TextView textView = ReservationFullActivity.access$getBinding(ReservationFullActivity.this).btnActivityReservationFullSign;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.btnActivityReservationFullSign");
                    SimpleUtilsKt.show(textView);
                } else {
                    TextView textView2 = ReservationFullActivity.access$getBinding(ReservationFullActivity.this).btnActivityReservationFullSign;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.btnActivityReservationFullSign");
                    SimpleUtilsKt.remove(textView2);
                }
                ReservationFullActivity.access$getBinding(ReservationFullActivity.this).tvActivityReservationFullPeopleCount.setText("(应到人数" + reservationDetailBean.getSignList().size() + "人)");
                ReservationFullActivity.this.getPeopleAdapter().setList(reservationDetailBean.getSignList());
            }
        };
        reservationDetail.observe(reservationFullActivity, new Observer() { // from class: com.yd.android_brand_mvp.activity.reserve.-$$Lambda$ReservationFullActivity$uYK6Bx_fRFk036DtVaw9jjyQFZE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservationFullActivity.initView$lambda$5(function1, obj);
            }
        });
        LiveData<Result<Boolean>> signInResult = getViewModel().getSignInResult();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity.initView.6
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
                ToastUtil.showBottomView((Activity) ReservationFullActivity.this, "签到成功");
                ReservationRecordBean reservationRecordBean3 = ReservationFullActivity.this.showData;
                if (reservationRecordBean3 != null) {
                    ReservationFullActivity.this.getViewModel().getReservationDetail(reservationRecordBean3.getId());
                }
            }
        };
        signInResult.observe(reservationFullActivity, new Observer() { // from class: com.yd.android_brand_mvp.activity.reserve.-$$Lambda$ReservationFullActivity$y3YWoq8QFAFAjV3dHSCYX-N6y08
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservationFullActivity.initView$lambda$6(function2, obj);
            }
        });
        LiveData<List<ReservationRecordBean>> reservationList = getViewModel().getReservationList();
        final Function1<List<? extends ReservationRecordBean>, Unit> function3 = new Function1<List<? extends ReservationRecordBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationFullActivity.initView.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ReservationRecordBean> list) {
                invoke2((List<ReservationRecordBean>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ReservationRecordBean> list) {
                Iterator<ReservationRecordBean> it2 = list.iterator();
                int i = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i = -1;
                        break;
                    }
                    int i2 = i + 1;
                    ReservationRecordBean next = it2.next();
                    if (!(next.getStartTimeStr().length() == 0)) {
                        if (!(next.getEndTimeStr().length() == 0) && DateUtils.isTiming(next.getStartTimeStr(), next.getEndTimeStr(), TimeUtil.notSecondFormat)) {
                            break;
                        }
                    }
                    i = i2;
                }
                String id = list.get(i).getId();
                ReservationRecordBean reservationRecordBean3 = ReservationFullActivity.this.showData;
                if (Intrinsics.areEqual(id, reservationRecordBean3 != null ? reservationRecordBean3.getId() : null)) {
                    return;
                }
                BaseConstant.DOMINATE_CLOSE = true;
                ReservationFullActivity.this.finish();
            }
        };
        reservationList.observe(reservationFullActivity, new Observer() { // from class: com.yd.android_brand_mvp.activity.reserve.-$$Lambda$ReservationFullActivity$Dsvb7yaJZAF1zo3icK0KtCusP4o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservationFullActivity.initView$lambda$7(function3, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ReservationFullActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseConstant.DOMINATE_CLOSE = true;
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ReservationFullActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseConstant.DOMINATE_CLOSE = true;
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ReservationFullActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0, (Class<?>) CheackNomalActivity.class);
        intent.putExtra("type", BaseConstant.dominateReservation44);
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        ReservationRecordBean reservationRecordBean;
        Object next;
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.type == BaseConstant.dominateReservation44 && (reservationRecordBean = this.showData) != null) {
            if (!this.isAvailableNetWork) {
                ToastUtil.showBottomView((Activity) this, getString(R.string.network_is_unavailable));
                List<ReservationSignListItemBean> data = getPeopleAdapter().getData();
                if (data.isEmpty()) {
                    return;
                }
                Iterator<T> it2 = data.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!Intrinsics.areEqual(((ReservationSignListItemBean) next).getUserId(), eventBean.id));
                if (((ReservationSignListItemBean) next) == null) {
                    return;
                }
                String timeStr = DateUtils.getTodayStr(TimeUtil.allTimeFormat);
                ReservationViewModel viewModel = getViewModel();
                String id = reservationRecordBean.getId();
                String str = eventBean.id;
                Intrinsics.checkNotNullExpressionValue(str, "eventBean.id");
                Intrinsics.checkNotNullExpressionValue(timeStr, "timeStr");
                viewModel.insertReservationSignDataToDao(id, str, timeStr);
                return;
            }
            ReservationViewModel viewModel2 = getViewModel();
            String str2 = eventBean.id;
            Intrinsics.checkNotNullExpressionValue(str2, "eventBean.id");
            viewModel2.signInRecord(str2, reservationRecordBean.getId());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        NetWorkManager.getInstance().remove(this);
    }
}
