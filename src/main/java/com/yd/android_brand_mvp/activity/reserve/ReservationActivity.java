package com.yd.android_brand_mvp.activity.reserve;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.yd.android_brand_mvp.activity.reserve.fragment.ReservationFragment;
import com.yd.android_brand_mvp.activity.reserve.fragment.ReservationNoSignFragment;
import com.yd.android_brand_mvp.activity.reserve.viewmodel.ReservationViewModel;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.dialog.reservation.ReservationDetailDialog;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ReservationActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/activity/reserve/ReservationActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "bookingId", "", "isNeedSign", "", "isPortrait", "viewModel", "Lcom/yd/android_brand_mvp/activity/reserve/viewmodel/ReservationViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/reserve/viewmodel/ReservationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReservationActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String bookingId = "-1";
    private boolean isNeedSign = true;
    private boolean isPortrait;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "与会人员";
    }

    public ReservationActivity() {
        final ReservationActivity reservationActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ReservationViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = reservationActivity.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = reservationActivity.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationActivity$special$$inlined$viewModels$default$3
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
                CreationExtras defaultViewModelCreationExtras = reservationActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    /* JADX INFO: compiled from: ReservationActivity.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/reserve/ReservationActivity$Companion;", "", "()V", "startGo", "", "context", "Landroid/content/Context;", "bookingId", "", "isPortrait", "", "sign", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startGo(Context context, String bookingId, boolean isPortrait, boolean sign) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bookingId, "bookingId");
            Intent intent = new Intent(context, (Class<?>) ReservationActivity.class);
            intent.putExtra("isPortrait", isPortrait);
            intent.putExtra("bookingId", bookingId);
            intent.putExtra("needSign", sign);
            context.startActivity(intent);
        }
    }

    private final ReservationViewModel getViewModel() {
        return (ReservationViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        this.isPortrait = getIntent().getBooleanExtra("isPortrait", false);
        String stringExtra = getIntent().getStringExtra("bookingId");
        if (stringExtra == null) {
            stringExtra = "-1";
        }
        this.bookingId = stringExtra;
        this.isNeedSign = getIntent().getBooleanExtra("needSign", true);
        super.onCreate(savedInstanceState);
        setRightTextView("详情");
        getRightTextView().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.reserve.-$$Lambda$ReservationActivity$5EZf78V7nec3znNUNSIVey6fF70
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReservationActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        initView();
        loading();
        getViewModel().getReservationDetail(this.bookingId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ReservationActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReservationDetailBean value = this$0.getViewModel().getReservationDetail().getValue();
        if (value == null) {
            return;
        }
        new ReservationDetailDialog(value, this$0.isPortrait).show(this$0.getSupportFragmentManager(), "reservationDetailDialog");
    }

    private final void initView() {
        final AnonymousClass1 anonymousClass1 = new Function1<ReservationDetailBean, Unit>() { // from class: com.yd.android_brand_mvp.activity.reserve.ReservationActivity.initView.1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ReservationDetailBean reservationDetailBean) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReservationDetailBean reservationDetailBean) {
                invoke2(reservationDetailBean);
                return Unit.INSTANCE;
            }
        };
        getViewModel().getReservationDetail().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.activity.reserve.-$$Lambda$ReservationActivity$mmFcdf7pUM-NA1akYYszcHoIb-U
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReservationActivity.initView$lambda$1(anonymousClass1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        if (this.isNeedSign) {
            return ReservationFragment.INSTANCE.newInstance(this.bookingId, this.isPortrait);
        }
        return ReservationNoSignFragment.INSTANCE.newInstance(this.bookingId, this.isPortrait);
    }
}
