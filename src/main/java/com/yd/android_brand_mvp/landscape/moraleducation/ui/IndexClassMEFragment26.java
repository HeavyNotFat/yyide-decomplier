package com.yd.android_brand_mvp.landscape.moraleducation.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.LogUtils;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentClassMeIndex2x6Binding;
import com.yd.android_brand_mvp.landscape.Wlkz2_2L;
import com.yd.android_brand_mvp.landscape.moraleducation.custom.view.CustomLinearLayout;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CheckSecurityModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CycleCurrentMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.IndexClassMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.IndexClassMEAdapter26;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.TopThreeRankingIconAdapter;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.TopThreeRankingScoreAdapter;
import com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity2;
import com.zhpan.bannerview.BannerViewPager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: IndexClassMEFragment26.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002DEB\u0005¢\u0006\u0002\u0010\u0003J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0016J\b\u00104\u001a\u000202H\u0016J\u001a\u00105\u001a\u0002022\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020<H\u0007J\u0016\u0010=\u001a\u0002022\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0+H\u0002J\u0016\u0010@\u001a\u0002022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020?0+H\u0002J\u0016\u0010B\u001a\u0002022\f\u0010C\u001a\b\u0012\u0004\u0012\u00020?0+H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006F"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment26;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentClassMeIndex2x6Binding;", "()V", "mActivityId", "", "getMActivityId", "()Ljava/lang/String;", "setMActivityId", "(Ljava/lang/String;)V", "mBroadcastReceiver", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment26$MyBroadcastReceiver;", "mClassName", "getMClassName", "setMClassName", "mCycle", "getMCycle", "setMCycle", "mCycleId", "", "getMCycleId", "()J", "setMCycleId", "(J)V", "mStudentId", "getMStudentId", "setMStudentId", "mTeacherId", "getMTeacherId", "setMTeacherId", "mTitle", "getMTitle", "setMTitle", "mUserName", "getMUserName", "setMUserName", "mViewModel", "Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "getMViewModel", "()Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mWinPrizeList", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "getMWinPrizeList", "()Ljava/util/List;", "setMWinPrizeList", "(Ljava/util/List;)V", "initView", "", "onResume", "onStop", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parseEventBean", "data", "Lcom/yd/android_brand_mvp/model/EventBean;", "showTopOneUI", "topOneResults", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;", "showTopThreeUI", "topThreeResults", "showTopTwoUI", "topTwoResults", "Companion", "MyBroadcastReceiver", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IndexClassMEFragment26 extends KTBaseFragment<FragmentClassMeIndex2x6Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DATA = "data";
    private static final String TAG;
    private String mActivityId;
    private final MyBroadcastReceiver mBroadcastReceiver;
    private String mClassName;
    private String mCycle;
    private long mCycleId;
    private String mStudentId;
    private String mTeacherId;
    private String mTitle;
    private String mUserName;

    /* JADX INFO: renamed from: mViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mViewModel;
    private List<CurrentMEModel> mWinPrizeList;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment26$1, reason: invalid class name */
    /* JADX INFO: compiled from: IndexClassMEFragment26.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentClassMeIndex2x6Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentClassMeIndex2x6Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentClassMeIndex2x6Binding;", 0);
        }

        public final FragmentClassMeIndex2x6Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentClassMeIndex2x6Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentClassMeIndex2x6Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public IndexClassMEFragment26() {
        super(AnonymousClass1.INSTANCE);
        final IndexClassMEFragment26 indexClassMEFragment26 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment26$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return indexClassMEFragment26;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment26$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function1 = null;
        this.mViewModel = FragmentViewModelLazyKt.createViewModelLazy(indexClassMEFragment26, Reflection.getOrCreateKotlinClass(ClassMEViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment26$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment26$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function2 = function1;
                if (function2 != null && (creationExtras = (CreationExtras) function2.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment26$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) {
                    defaultViewModelProviderFactory = indexClassMEFragment26.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mBroadcastReceiver = new MyBroadcastReceiver();
        this.mActivityId = "";
        this.mTeacherId = "";
        this.mStudentId = "";
        this.mUserName = "";
        this.mCycle = "";
        this.mClassName = "";
        this.mTitle = "";
    }

    public static final /* synthetic */ FragmentClassMeIndex2x6Binding access$getBinding(IndexClassMEFragment26 indexClassMEFragment26) {
        return indexClassMEFragment26.getBinding();
    }

    private final ClassMEViewModel getMViewModel() {
        return (ClassMEViewModel) this.mViewModel.getValue();
    }

    public final String getMActivityId() {
        return this.mActivityId;
    }

    public final void setMActivityId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mActivityId = str;
    }

    public final String getMTeacherId() {
        return this.mTeacherId;
    }

    public final void setMTeacherId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTeacherId = str;
    }

    public final String getMStudentId() {
        return this.mStudentId;
    }

    public final void setMStudentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mStudentId = str;
    }

    public final String getMUserName() {
        return this.mUserName;
    }

    public final void setMUserName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mUserName = str;
    }

    public final String getMCycle() {
        return this.mCycle;
    }

    public final void setMCycle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCycle = str;
    }

    public final String getMClassName() {
        return this.mClassName;
    }

    public final void setMClassName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mClassName = str;
    }

    public final String getMTitle() {
        return this.mTitle;
    }

    public final void setMTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTitle = str;
    }

    public final List<CurrentMEModel> getMWinPrizeList() {
        return this.mWinPrizeList;
    }

    public final void setMWinPrizeList(List<CurrentMEModel> list) {
        this.mWinPrizeList = list;
    }

    public final long getMCycleId() {
        return this.mCycleId;
    }

    public final void setMCycleId(long j) {
        this.mCycleId = j;
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        getMViewModel().getRanking();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment26$initView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IndexClassMEFragment26.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/IndexClassMEModel;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C04971 extends Lambda implements Function1<Result<? extends IndexClassMEModel>, Unit> {
        C04971() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends IndexClassMEModel> result) {
            invoke2(result);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Result<? extends IndexClassMEModel> it2) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            Object value = it2.getValue();
            if (Result.m597isFailureimpl(value)) {
                value = null;
            }
            IndexClassMEModel indexClassMEModel = (IndexClassMEModel) value;
            if (indexClassMEModel == null) {
                IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvRankingFirst.setVisibility(0);
                IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvRankingSecond.setVisibility(0);
                IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvRankingThird.setVisibility(0);
                IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).ivNoData.setVisibility(0);
                IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvNoMoralEducationAppraisal.setVisibility(0);
                IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).clThisClassRanking.setVisibility(8);
                IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvEnterForRankingPeople.setVisibility(8);
                return;
            }
            IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvRankingFirst.setVisibility(8);
            IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvRankingSecond.setVisibility(8);
            IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvRankingThird.setVisibility(8);
            IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).ivNoData.setVisibility(8);
            IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvNoMoralEducationAppraisal.setVisibility(8);
            IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).clThisClassRanking.setVisibility(0);
            IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvEnterForRankingPeople.setVisibility(0);
            String mActivityId = indexClassMEModel.getMActivityId();
            CurrentMEModel mCurrentObj = indexClassMEModel.getMCurrentObj();
            indexClassMEModel.getMPromotionalImage();
            String mCycle = indexClassMEModel.getMCycle();
            Long mCycleId = indexClassMEModel.getMCycleId();
            indexClassMEModel.getMLastCycleCurrentObj();
            indexClassMEModel.getMLastCycleId();
            indexClassMEModel.component8();
            List<CycleCurrentMEModel> listComponent9 = indexClassMEModel.component9();
            indexClassMEModel.getMSchoolId();
            indexClassMEModel.getMLastTimeRange();
            String mTimeRange = indexClassMEModel.getMTimeRange();
            String mTitle = indexClassMEModel.getMTitle();
            List<CurrentMEModel> listComponent14 = indexClassMEModel.component14();
            IndexClassMEFragment26 indexClassMEFragment26 = IndexClassMEFragment26.this;
            if (mActivityId == null) {
                mActivityId = "";
            }
            indexClassMEFragment26.setMActivityId(mActivityId);
            IndexClassMEFragment26 indexClassMEFragment27 = IndexClassMEFragment26.this;
            if (mCycle == null) {
                mCycle = "";
            }
            indexClassMEFragment27.setMCycle(mCycle);
            IndexClassMEFragment26.this.setMCycleId(mCycleId != null ? mCycleId.longValue() : 0L);
            IndexClassMEFragment26.this.setMWinPrizeList(listComponent14);
            IndexClassMEFragment26 indexClassMEFragment28 = IndexClassMEFragment26.this;
            if (mTitle == null) {
                mTitle = "";
            }
            indexClassMEFragment28.setMTitle(mTitle);
            List listSplit$default = mTimeRange != null ? StringsKt.split$default((CharSequence) mTimeRange, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SERVER}, false, 0, 6, (Object) null) : null;
            if (listSplit$default != null && listSplit$default.size() == 2) {
                String strTake = StringsKt.take(mTimeRange, 4);
                String strDrop = StringsKt.drop((String) listSplit$default.get(0), 5);
                String strDrop2 = StringsKt.drop((String) listSplit$default.get(1), 5);
                IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvRankingDate.setText(strTake + " | " + strDrop + '-' + strDrop2);
            }
            if (listComponent9 != null) {
                IndexClassMEFragment26 indexClassMEFragment29 = IndexClassMEFragment26.this;
                if (!listComponent9.isEmpty()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj : listComponent9) {
                        Integer numValueOf = Integer.valueOf(((CycleCurrentMEModel) obj).getMRanking());
                        Object obj2 = linkedHashMap.get(numValueOf);
                        if (obj2 == null) {
                            obj2 = (List) new ArrayList();
                            linkedHashMap.put(numValueOf, obj2);
                        }
                        ((List) obj2).add(obj);
                    }
                    SortedMap sortedMap = MapsKt.toSortedMap(linkedHashMap);
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Map.Entry entry : sortedMap.entrySet()) {
                        Object key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "cycleCurrentMeModel.key");
                        if (((Number) key).intValue() < 4) {
                            linkedHashMap2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    LogUtils.i("result2.size" + linkedHashMap2.size());
                    int size = linkedHashMap2.size();
                    if (size == 1) {
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).tvRankingFirst.setVisibility(8);
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).tvRankingSecond.setVisibility(0);
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).tvRankingThird.setVisibility(0);
                        List list = (List) linkedHashMap2.get(1);
                        if (list != null) {
                            indexClassMEFragment29.showTopOneUI(list);
                        }
                    } else if (size == 2) {
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).tvRankingFirst.setVisibility(8);
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).tvRankingSecond.setVisibility(8);
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).tvRankingThird.setVisibility(0);
                        List list2 = (List) linkedHashMap2.get(1);
                        List list3 = (List) linkedHashMap2.get(2);
                        if (list2 != null) {
                            indexClassMEFragment29.showTopOneUI(list2);
                        }
                        if (list3 != null) {
                            indexClassMEFragment29.showTopTwoUI(list3);
                        }
                    } else if (size == 3) {
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).tvRankingFirst.setVisibility(8);
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).tvRankingSecond.setVisibility(8);
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).tvRankingThird.setVisibility(8);
                        List list4 = (List) linkedHashMap2.get(1);
                        List list5 = (List) linkedHashMap2.get(2);
                        List list6 = (List) linkedHashMap2.get(3);
                        if (list4 != null) {
                            indexClassMEFragment29.showTopOneUI(list4);
                        }
                        if (list5 != null) {
                            indexClassMEFragment29.showTopTwoUI(list5);
                        }
                        if (list6 != null) {
                            indexClassMEFragment29.showTopThreeUI(list6);
                        }
                    }
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Map.Entry entry2 : sortedMap.entrySet()) {
                        Integer key2 = (Integer) entry2.getKey();
                        Intrinsics.checkNotNullExpressionValue(key2, "key");
                        int iIntValue = key2.intValue();
                        if (4 <= iIntValue && iIntValue < 11) {
                            linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    LinkedHashMap linkedHashMap4 = linkedHashMap3;
                    if (!linkedHashMap4.isEmpty()) {
                        Context contextRequireContext = indexClassMEFragment29.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                        IndexClassMEAdapter26 indexClassMEAdapter26 = new IndexClassMEAdapter26(contextRequireContext, CollectionsKt.toMutableList((Collection) CollectionsKt.flatten(linkedHashMap4.values())));
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).rvClassesRanking.setLayoutManager(new LinearLayoutManager(indexClassMEFragment29.requireContext()));
                        IndexClassMEFragment26.access$getBinding(indexClassMEFragment29).rvClassesRanking.setAdapter(indexClassMEAdapter26);
                        indexClassMEAdapter26.notifyDataSetChanged();
                    }
                }
            }
            if (mCurrentObj != null) {
                IndexClassMEFragment26 indexClassMEFragment210 = IndexClassMEFragment26.this;
                String mName = mCurrentObj.getMName();
                indexClassMEFragment210.setMClassName(mName != null ? mName : "");
                IndexClassMEFragment26.access$getBinding(indexClassMEFragment210).tvThisClassRanking.setText(mCurrentObj.getMRanking());
                GlideUtil.loadCircleHeadImage(indexClassMEFragment210.requireContext(), mCurrentObj.getMAvatar(), IndexClassMEFragment26.access$getBinding(indexClassMEFragment210).ivThisClassIcon);
                IndexClassMEFragment26.access$getBinding(indexClassMEFragment210).tvThisClassName.setText(mCurrentObj.getMName());
                TextView textView = IndexClassMEFragment26.access$getBinding(indexClassMEFragment210).tvThisClassScore;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = indexClassMEFragment210.getResources().getString(R.string.score3);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.score3)");
                String str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(mCurrentObj.getMScore())}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                textView.setText(str);
            }
            ConstraintLayout constraintLayout = IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).clThisClassRanking;
            final IndexClassMEFragment26 indexClassMEFragment211 = IndexClassMEFragment26.this;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$IndexClassMEFragment26$initView$1$OrE3ofnc5Whd-1Un7loMv1BKfGo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IndexClassMEFragment26.C04971.invoke$lambda$11(indexClassMEFragment211, view);
                }
            });
            CustomLinearLayout customLinearLayout = IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).llRanking;
            final IndexClassMEFragment26 indexClassMEFragment212 = IndexClassMEFragment26.this;
            customLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$IndexClassMEFragment26$initView$1$VlW_3PFb2NOSod6TmGtFU8TJzJA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IndexClassMEFragment26.C04971.invoke$lambda$12(indexClassMEFragment212, view);
                }
            });
            CustomLinearLayout customLinearLayout2 = IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).llClassesRanking;
            final IndexClassMEFragment26 indexClassMEFragment213 = IndexClassMEFragment26.this;
            customLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$IndexClassMEFragment26$initView$1$r0D7Enl7jKhGIoStxWAE4kBtJC0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IndexClassMEFragment26.C04971.invoke$lambda$13(indexClassMEFragment213, view);
                }
            });
            TextView textView2 = IndexClassMEFragment26.access$getBinding(IndexClassMEFragment26.this).tvEnterForRankingPeople;
            final IndexClassMEFragment26 indexClassMEFragment214 = IndexClassMEFragment26.this;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$IndexClassMEFragment26$initView$1$3pjcltivz5du1MMHC_ncR5nRAYo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IndexClassMEFragment26.C04971.invoke$lambda$14(indexClassMEFragment214, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$11(IndexClassMEFragment26 this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intent intent = new Intent(this$0.requireContext(), (Class<?>) TeacherCheackActivity2.class);
            intent.putExtra("type", BaseConstant.enterROEPInThisClass2);
            this$0.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$12(IndexClassMEFragment26 this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ROEPInEveryClassActivity.Companion companion = ROEPInEveryClassActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.start(contextRequireContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$13(IndexClassMEFragment26 this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ROEPInEveryClassActivity.Companion companion = ROEPInEveryClassActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.start(contextRequireContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$14(IndexClassMEFragment26 this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
            intent.putExtra("type", BaseConstant.submitScore3);
            this$0.startActivity(intent);
        }
    }

    private final void initView() {
        MutableLiveData<Result<IndexClassMEModel>> mClassMEModelLiveData = getMViewModel().getMClassMEModelLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final C04971 c04971 = new C04971();
        mClassMEModelLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$IndexClassMEFragment26$RMkL3qkyZQJQmhRNRaksXbStS7Y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IndexClassMEFragment26.initView$lambda$0(c04971, obj);
            }
        });
        MutableLiveData<Result<CheckSecurityModel>> mCheckSecurityModelLiveData = getMViewModel().getMCheckSecurityModelLiveData();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends CheckSecurityModel>, Unit> function1 = new Function1<Result<? extends CheckSecurityModel>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment26.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends CheckSecurityModel> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends CheckSecurityModel> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                CheckSecurityModel checkSecurityModel = (CheckSecurityModel) value;
                if (checkSecurityModel == null) {
                    return;
                }
                IndexClassMEFragment26 indexClassMEFragment26 = IndexClassMEFragment26.this;
                if (checkSecurityModel.getMCanScore()) {
                    ClassMEAppraisalActivity.Companion companion = ClassMEAppraisalActivity.INSTANCE;
                    Context contextRequireContext = indexClassMEFragment26.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    companion.start(contextRequireContext, indexClassMEFragment26.getMTitle(), indexClassMEFragment26.getMUserName(), indexClassMEFragment26.getMClassName(), indexClassMEFragment26.getMCycle(), checkSecurityModel.getMSchoolId(), checkSecurityModel.getMActivityId(), checkSecurityModel.getMCycleId(), checkSecurityModel.getMFromGroupId(), checkSecurityModel.getMFromPersonId(), checkSecurityModel.getMToObjId(), checkSecurityModel.getMToObjName(), indexClassMEFragment26.getMTeacherId(), indexClassMEFragment26.getMStudentId());
                    return;
                }
                Context contextRequireContext2 = indexClassMEFragment26.requireContext();
                Intrinsics.checkNotNull(contextRequireContext2, "null cannot be cast to non-null type android.app.Activity");
                ToastUtil.showBottomView((Activity) contextRequireContext2, indexClassMEFragment26.getResources().getString(R.string.not_ranking_people));
            }
        };
        mCheckSecurityModelLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$IndexClassMEFragment26$jT2o0YI9T5zJV0y9BQkYtFkT7BY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IndexClassMEFragment26.initView$lambda$1(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTopOneUI(List<CycleCurrentMEModel> topOneResults) {
        LogUtils.i("topOneResults.size" + topOneResults.size());
        View viewFindViewById = requireActivity().findViewById(R.id.bvp_class_icon11);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "requireActivity().findVi…Id(R.id.bvp_class_icon11)");
        BannerViewPager bannerViewPager = (BannerViewPager) viewFindViewById;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        bannerViewPager.setAdapter(new TopThreeRankingIconAdapter(contextRequireContext));
        bannerViewPager.setOrientation(1);
        bannerViewPager.setLifecycleRegistry(getLifecycle());
        bannerViewPager.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager.setIndicatorHeight(0);
        bannerViewPager.setIndicatorSliderWidth(0);
        bannerViewPager.setScrollDuration(500);
        bannerViewPager.setInterval(2000);
        bannerViewPager.setUserInputEnabled(false);
        bannerViewPager.create(topOneResults);
        View viewFindViewById2 = requireActivity().findViewById(R.id.bvp_class_score11);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "requireActivity().findVi…d(R.id.bvp_class_score11)");
        BannerViewPager bannerViewPager2 = (BannerViewPager) viewFindViewById2;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        bannerViewPager2.setAdapter(new TopThreeRankingScoreAdapter(contextRequireContext2, 1));
        bannerViewPager2.setOrientation(1);
        bannerViewPager2.setLifecycleRegistry(getLifecycle());
        bannerViewPager2.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager2.setIndicatorHeight(0);
        bannerViewPager2.setIndicatorSliderWidth(0);
        bannerViewPager2.setScrollDuration(500);
        bannerViewPager2.setInterval(2000);
        bannerViewPager2.setUserInputEnabled(false);
        bannerViewPager2.create(topOneResults);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTopTwoUI(List<CycleCurrentMEModel> topTwoResults) {
        View viewFindViewById = requireActivity().findViewById(R.id.bvp_class_icon22);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "requireActivity().findVi…Id(R.id.bvp_class_icon22)");
        BannerViewPager bannerViewPager = (BannerViewPager) viewFindViewById;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        bannerViewPager.setAdapter(new TopThreeRankingIconAdapter(contextRequireContext));
        bannerViewPager.setOrientation(1);
        bannerViewPager.setLifecycleRegistry(getLifecycle());
        bannerViewPager.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager.setIndicatorHeight(0);
        bannerViewPager.setIndicatorSliderWidth(0);
        bannerViewPager.setScrollDuration(500);
        bannerViewPager.setInterval(2000);
        bannerViewPager.setUserInputEnabled(false);
        bannerViewPager.create(topTwoResults);
        View viewFindViewById2 = requireActivity().findViewById(R.id.bvp_class_score22);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "requireActivity().findVi…d(R.id.bvp_class_score22)");
        BannerViewPager bannerViewPager2 = (BannerViewPager) viewFindViewById2;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        bannerViewPager2.setAdapter(new TopThreeRankingScoreAdapter(contextRequireContext2, 2));
        bannerViewPager2.setOrientation(1);
        bannerViewPager2.setLifecycleRegistry(getLifecycle());
        bannerViewPager2.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager2.setIndicatorHeight(0);
        bannerViewPager2.setIndicatorSliderWidth(0);
        bannerViewPager2.setScrollDuration(500);
        bannerViewPager2.setInterval(2000);
        bannerViewPager2.setUserInputEnabled(false);
        bannerViewPager2.create(topTwoResults);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTopThreeUI(List<CycleCurrentMEModel> topThreeResults) {
        View viewFindViewById = requireActivity().findViewById(R.id.bvp_class_icon33);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "requireActivity().findVi…Id(R.id.bvp_class_icon33)");
        BannerViewPager bannerViewPager = (BannerViewPager) viewFindViewById;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        bannerViewPager.setAdapter(new TopThreeRankingIconAdapter(contextRequireContext));
        bannerViewPager.setOrientation(1);
        bannerViewPager.setLifecycleRegistry(getLifecycle());
        bannerViewPager.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager.setIndicatorHeight(0);
        bannerViewPager.setIndicatorSliderWidth(0);
        bannerViewPager.setScrollDuration(500);
        bannerViewPager.setInterval(2000);
        bannerViewPager.setUserInputEnabled(false);
        bannerViewPager.create(topThreeResults);
        View viewFindViewById2 = requireActivity().findViewById(R.id.bvp_class_score33);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "requireActivity().findVi…d(R.id.bvp_class_score33)");
        BannerViewPager bannerViewPager2 = (BannerViewPager) viewFindViewById2;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        bannerViewPager2.setAdapter(new TopThreeRankingScoreAdapter(contextRequireContext2, 3));
        bannerViewPager2.setOrientation(1);
        bannerViewPager2.setLifecycleRegistry(getLifecycle());
        bannerViewPager2.stopLoopWhenDetachedFromWindow(true);
        bannerViewPager2.setIndicatorHeight(0);
        bannerViewPager2.setIndicatorSliderWidth(0);
        bannerViewPager2.setScrollDuration(500);
        bannerViewPager2.setInterval(2000);
        bannerViewPager2.setUserInputEnabled(false);
        bannerViewPager2.create(topThreeResults);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        requireActivity().unregisterReceiver(this.mBroadcastReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Wlkz2_2L.SUO);
        requireActivity().registerReceiver(this.mBroadcastReceiver, intentFilter);
    }

    /* JADX INFO: compiled from: IndexClassMEFragment26.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment26$MyBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment26;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class MyBroadcastReceiver extends BroadcastReceiver {
        public MyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, Wlkz2_2L.SUO)) {
                Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra("type", 0)) : null;
                int i = BaseConstant.enterROEPInThisClass2;
                if (numValueOf != null && numValueOf.intValue() == i) {
                    ROEPInThisClassActivity.Companion companion = ROEPInThisClassActivity.INSTANCE;
                    Context contextRequireContext = IndexClassMEFragment26.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    companion.start(contextRequireContext, IndexClassMEFragment26.this.getMActivityId(), Long.valueOf(IndexClassMEFragment26.this.getMCycleId()), IndexClassMEFragment26.this.getMTitle(), IndexClassMEFragment26.this.getMWinPrizeList());
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void parseEventBean(EventBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.type == BaseConstant.submitScore3) {
            if (data.isStudent) {
                String str = data.id;
                Intrinsics.checkNotNullExpressionValue(str, "data.id");
                this.mStudentId = str;
                this.mTeacherId = "";
            } else {
                String str2 = data.id;
                Intrinsics.checkNotNullExpressionValue(str2, "data.id");
                this.mTeacherId = str2;
                this.mStudentId = "";
            }
            String str3 = data.name;
            Intrinsics.checkNotNullExpressionValue(str3, "data.name");
            this.mUserName = str3;
            getMViewModel().securityCheck(this.mActivityId, this.mTeacherId, this.mStudentId);
            return;
        }
        if (data.Event == 10005) {
            getMViewModel().getRanking();
        }
    }

    /* JADX INFO: compiled from: IndexClassMEFragment26.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment26$Companion;", "", "()V", "DATA", "", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment26;", "bean", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return IndexClassMEFragment26.TAG;
        }

        public final IndexClassMEFragment26 newInstance(Object bean) {
            IndexClassMEFragment26 indexClassMEFragment26 = new IndexClassMEFragment26();
            indexClassMEFragment26.setArguments(new Bundle());
            return indexClassMEFragment26;
        }
    }

    static {
        String name = IndexClassMEFragment26.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IndexClassMEFragment26::class.java.name");
        TAG = name;
    }
}
