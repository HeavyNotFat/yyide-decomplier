package com.yd.android_brand_mvp.landscape.moraleducation.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
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
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.LogUtils;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentClassMeIndex2x41Binding;
import com.yd.android_brand_mvp.landscape.Wlkz2_2L;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CheckSecurityModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.IndexClassMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.IndexClassMEAdapter241;
import com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: compiled from: IndexClassMEFragment241.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00029:B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\u001a\u00100\u001a\u00020,2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0007J\b\u00108\u001a\u00020,H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006;"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment241;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentClassMeIndex2x41Binding;", "()V", "mActivityId", "", "getMActivityId", "()Ljava/lang/String;", "setMActivityId", "(Ljava/lang/String;)V", "mBroadcastReceiver", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment241$MyBroadcastReceiver;", "mClassName", "getMClassName", "setMClassName", "mCycle", "getMCycle", "setMCycle", "mStudentId", "getMStudentId", "setMStudentId", "mTeacherId", "getMTeacherId", "setMTeacherId", "mTitle", "getMTitle", "setMTitle", "mUserName", "getMUserName", "setMUserName", "mViewModel", "Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "getMViewModel", "()Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mWinPrizeList", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "getMWinPrizeList", "()Ljava/util/List;", "setMWinPrizeList", "(Ljava/util/List;)V", "initView", "", "onDestroy", "onResume", "onStop", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parseEventBean", "data", "Lcom/yd/android_brand_mvp/model/EventBean;", "showUIForRankingFirst", "Companion", "MyBroadcastReceiver", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IndexClassMEFragment241 extends KTBaseFragment<FragmentClassMeIndex2x41Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DATA = "data";
    private static final String TAG;
    private String mActivityId;
    private final MyBroadcastReceiver mBroadcastReceiver;
    private String mClassName;
    private String mCycle;
    private String mStudentId;
    private String mTeacherId;
    private String mTitle;
    private String mUserName;

    /* JADX INFO: renamed from: mViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mViewModel;
    private List<CurrentMEModel> mWinPrizeList;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241$1, reason: invalid class name */
    /* JADX INFO: compiled from: IndexClassMEFragment241.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentClassMeIndex2x41Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentClassMeIndex2x41Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentClassMeIndex2x41Binding;", 0);
        }

        public final FragmentClassMeIndex2x41Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentClassMeIndex2x41Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentClassMeIndex2x41Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentClassMeIndex2x41Binding access$getBinding(IndexClassMEFragment241 indexClassMEFragment241) {
        return indexClassMEFragment241.getBinding();
    }

    public IndexClassMEFragment241() {
        super(AnonymousClass1.INSTANCE);
        final IndexClassMEFragment241 indexClassMEFragment241 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return indexClassMEFragment241;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241$special$$inlined$viewModels$default$2
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
        this.mViewModel = FragmentViewModelLazyKt.createViewModelLazy(indexClassMEFragment241, Reflection.getOrCreateKotlinClass(ClassMEViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = indexClassMEFragment241.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mBroadcastReceiver = new MyBroadcastReceiver();
        this.mActivityId = "";
        this.mTeacherId = "";
        this.mStudentId = "";
        this.mTitle = "";
        this.mUserName = "";
        this.mCycle = "";
        this.mClassName = "";
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

    public final String getMTitle() {
        return this.mTitle;
    }

    public final void setMTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTitle = str;
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

    public final List<CurrentMEModel> getMWinPrizeList() {
        return this.mWinPrizeList;
    }

    public final void setMWinPrizeList(List<CurrentMEModel> list) {
        this.mWinPrizeList = list;
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        getMViewModel().getRanking();
        LogUtils.i("mac..." + BaseApplication.getInstance().getMac());
    }

    private final void initView() {
        getBinding().tvRankingDate.setText("");
        getBinding().tvWeekOfRanking.setText("");
        getBinding().tvRanking.setText("");
        MutableLiveData<Result<IndexClassMEModel>> mClassMEModelLiveData = getMViewModel().getMClassMEModelLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final C04951 c04951 = new C04951();
        mClassMEModelLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$IndexClassMEFragment241$uZCY48yjJtoWEW4ySJ8t6MVvumQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IndexClassMEFragment241.initView$lambda$0(c04951, obj);
            }
        });
        MutableLiveData<Result<CheckSecurityModel>> mCheckSecurityModelLiveData = getMViewModel().getMCheckSecurityModelLiveData();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends CheckSecurityModel>, Unit> function1 = new Function1<Result<? extends CheckSecurityModel>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241.initView.2
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
                IndexClassMEFragment241 indexClassMEFragment241 = IndexClassMEFragment241.this;
                if (checkSecurityModel.getMCanScore()) {
                    ClassMEAppraisalActivity.Companion companion = ClassMEAppraisalActivity.INSTANCE;
                    Context contextRequireContext = indexClassMEFragment241.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    companion.start(contextRequireContext, indexClassMEFragment241.getMTitle(), indexClassMEFragment241.getMUserName(), indexClassMEFragment241.getMClassName(), indexClassMEFragment241.getMCycle(), checkSecurityModel.getMSchoolId(), checkSecurityModel.getMActivityId(), checkSecurityModel.getMCycleId(), checkSecurityModel.getMFromGroupId(), checkSecurityModel.getMFromPersonId(), checkSecurityModel.getMToObjId(), checkSecurityModel.getMToObjName(), indexClassMEFragment241.getMTeacherId(), indexClassMEFragment241.getMStudentId());
                    return;
                }
                Context contextRequireContext2 = indexClassMEFragment241.requireContext();
                Intrinsics.checkNotNull(contextRequireContext2, "null cannot be cast to non-null type android.app.Activity");
                ToastUtil.showBottomView((Activity) contextRequireContext2, indexClassMEFragment241.getResources().getString(R.string.not_ranking_people));
            }
        };
        mCheckSecurityModelLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$IndexClassMEFragment241$NfesGOr6N_1ORhVpMHwT0U-WcRk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IndexClassMEFragment241.initView$lambda$1(function1, obj);
            }
        });
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241$initView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IndexClassMEFragment241.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/IndexClassMEModel;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C04951 extends Lambda implements Function1<Result<? extends IndexClassMEModel>, Unit> {
        C04951() {
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
                IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).tvClassMoralEducationComparison.setVisibility(8);
                IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).clRanking.setVisibility(8);
                IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).clRedFlag.setVisibility(8);
                IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).tvEnterForRankingPeople.setVisibility(8);
                IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).ivNoData.setVisibility(0);
                IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).tvNoMoralEducationAppraisal.setVisibility(0);
                return;
            }
            IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).tvClassMoralEducationComparison.setVisibility(0);
            IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).clRanking.setVisibility(0);
            IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).clRedFlag.setVisibility(0);
            IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).tvEnterForRankingPeople.setVisibility(0);
            IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).ivNoData.setVisibility(8);
            IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).tvNoMoralEducationAppraisal.setVisibility(8);
            String mActivityId = indexClassMEModel.getMActivityId();
            CurrentMEModel mCurrentObj = indexClassMEModel.getMCurrentObj();
            String mPromotionalImage = indexClassMEModel.getMPromotionalImage();
            String mCycle = indexClassMEModel.getMCycle();
            indexClassMEModel.getMCycleId();
            indexClassMEModel.getMLastCycleCurrentObj();
            indexClassMEModel.getMLastCycleId();
            indexClassMEModel.component8();
            indexClassMEModel.component9();
            indexClassMEModel.getMSchoolId();
            indexClassMEModel.getMLastTimeRange();
            String mTimeRange = indexClassMEModel.getMTimeRange();
            String mTitle = indexClassMEModel.getMTitle();
            List<CurrentMEModel> listComponent14 = indexClassMEModel.component14();
            IndexClassMEFragment241 indexClassMEFragment241 = IndexClassMEFragment241.this;
            if (mActivityId == null) {
                mActivityId = "";
            }
            indexClassMEFragment241.setMActivityId(mActivityId);
            IndexClassMEFragment241.this.setMCycle(mCycle == null ? "" : mCycle);
            IndexClassMEFragment241.this.setMTitle(mTitle == null ? "" : mTitle);
            IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).tvClassMoralEducationComparison.setText(mTitle);
            TextView textView = IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).tvWeekOfRanking;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = IndexClassMEFragment241.this.getResources().getString(R.string.the_week_of_ranking);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.the_week_of_ranking)");
            String str = String.format(string, Arrays.copyOf(new Object[]{mCycle}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            textView.setText(str);
            GlideUtil.loadImage(IndexClassMEFragment241.this.requireContext(), mPromotionalImage, IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).ivClassPhoto);
            if (mCurrentObj != null) {
                final IndexClassMEFragment241 indexClassMEFragment242 = IndexClassMEFragment241.this;
                if (Intrinsics.areEqual(mCurrentObj.getMRanking(), "1")) {
                    IndexClassMEFragment241.access$getBinding(indexClassMEFragment242).llRedFlag.setVisibility(0);
                    indexClassMEFragment242.showUIForRankingFirst();
                }
                TextView textView2 = IndexClassMEFragment241.access$getBinding(indexClassMEFragment242).tvRanking;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string2 = indexClassMEFragment242.getResources().getString(R.string.place);
                Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.place)");
                String str2 = String.format(string2, Arrays.copyOf(new Object[]{mCurrentObj.getMRanking()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                textView2.setText(str2);
                String mName = mCurrentObj.getMName();
                indexClassMEFragment242.setMClassName(mName != null ? mName : "");
                List listSplit$default = mTimeRange != null ? StringsKt.split$default((CharSequence) mTimeRange, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SERVER}, false, 0, 6, (Object) null) : null;
                if (listSplit$default != null && listSplit$default.size() == 2) {
                    String strDrop = StringsKt.drop((String) listSplit$default.get(0), 5);
                    String strDrop2 = StringsKt.drop((String) listSplit$default.get(1), 5);
                    IndexClassMEFragment241.access$getBinding(indexClassMEFragment242).tvRankingDate.setText(strDrop + '-' + strDrop2);
                }
                if (listComponent14 != null && (listComponent14.isEmpty() ^ true)) {
                    List<CurrentMEModel> listTake = CollectionsKt.take(listComponent14, 6);
                    indexClassMEFragment242.setMWinPrizeList(listTake);
                    Context contextRequireContext = indexClassMEFragment242.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listTake) {
                        if (((CurrentMEModel) obj).getMWinPrize()) {
                            arrayList.add(obj);
                        }
                    }
                    IndexClassMEAdapter241 indexClassMEAdapter241 = new IndexClassMEAdapter241(contextRequireContext, CollectionsKt.toMutableList((Collection) arrayList), new IndexClassMEAdapter241.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241$initView$1$1$indexClassMEAdapter$2
                        @Override // com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.IndexClassMEAdapter241.OnItemClickListener
                        public void onItemClicked(View view, CurrentMEModel currentMEModel) {
                            Intrinsics.checkNotNullParameter(view, "view");
                            Intrinsics.checkNotNullParameter(currentMEModel, "currentMEModel");
                            Intent intent = new Intent(indexClassMEFragment242.requireContext(), (Class<?>) TeacherCheackActivity2.class);
                            intent.putExtra("type", BaseConstant.enterRedFlagList);
                            indexClassMEFragment242.startActivity(intent);
                        }
                    });
                    IndexClassMEFragment241.access$getBinding(indexClassMEFragment242).rvFlowRedFlag.setLayoutManager(new LinearLayoutManager(indexClassMEFragment242.requireContext(), 0, true));
                    IndexClassMEFragment241.access$getBinding(indexClassMEFragment242).rvFlowRedFlag.setAdapter(indexClassMEAdapter241);
                    IndexClassMEFragment241.access$getBinding(indexClassMEFragment242).rvFlowRedFlag.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.IndexClassMEFragment241$initView$1$1$1
                        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                            Intrinsics.checkNotNullParameter(outRect, "outRect");
                            Intrinsics.checkNotNullParameter(view, "view");
                            Intrinsics.checkNotNullParameter(parent, "parent");
                            Intrinsics.checkNotNullParameter(state, "state");
                            super.getItemOffsets(outRect, view, parent, state);
                            outRect.right = 18;
                        }
                    });
                    indexClassMEAdapter241.notifyDataSetChanged();
                }
            }
            ConstraintLayout constraintLayout = IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).clRanking;
            final IndexClassMEFragment241 indexClassMEFragment243 = IndexClassMEFragment241.this;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$IndexClassMEFragment241$initView$1$W4b_3Yh8uYatYIVlc91zMbYOCkM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IndexClassMEFragment241.C04951.invoke$lambda$2(indexClassMEFragment243, view);
                }
            });
            TextView textView3 = IndexClassMEFragment241.access$getBinding(IndexClassMEFragment241.this).tvEnterForRankingPeople;
            final IndexClassMEFragment241 indexClassMEFragment244 = IndexClassMEFragment241.this;
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$IndexClassMEFragment241$initView$1$avWGEtTuJnSauZ1aPdp2alRQZTs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IndexClassMEFragment241.C04951.invoke$lambda$3(indexClassMEFragment244, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(IndexClassMEFragment241 this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ROEPInEveryClassActivity.Companion companion = ROEPInEveryClassActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.start(contextRequireContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3(IndexClassMEFragment241 this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
            intent.putExtra("type", BaseConstant.submitScore1);
            this$0.startActivity(intent);
        }
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
    public final void showUIForRankingFirst() {
        getBinding().getRoot().setBackgroundResource(R.drawable.bg_class_me_index);
        getBinding().ivVerticalBar.setBackgroundResource(R.drawable.bg_class_me_vertical_bar);
        getBinding().tvClassMoralEducation.setTextColor(getResources().getColor(R.color.white));
        getBinding().tvClassMoralEducationComparison.setTextColor(getResources().getColor(R.color.white));
        getBinding().clRanking.setBackgroundResource(R.drawable.bg_white_10);
        getBinding().llRedFlag.setVisibility(0);
        getBinding().clRedFlag.setBackgroundResource(R.drawable.bg_white_10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
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

    /* JADX INFO: compiled from: IndexClassMEFragment241.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment241$MyBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment241;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class MyBroadcastReceiver extends BroadcastReceiver {
        public MyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, Wlkz2_2L.SUO)) {
                Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra("type", 0)) : null;
                int i = BaseConstant.enterRedFlagList;
                if (numValueOf != null && numValueOf.intValue() == i) {
                    CFRFInThisClassActivity.Companion companion = CFRFInThisClassActivity.INSTANCE;
                    Context contextRequireContext = IndexClassMEFragment241.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    List<CurrentMEModel> mWinPrizeList = IndexClassMEFragment241.this.getMWinPrizeList();
                    Intrinsics.checkNotNull(mWinPrizeList);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : mWinPrizeList) {
                        if (((CurrentMEModel) obj).getMWinPrize()) {
                            arrayList.add(obj);
                        }
                    }
                    companion.start(contextRequireContext, CollectionsKt.toMutableList((Collection) arrayList));
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void parseEventBean(EventBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.type == BaseConstant.submitScore1) {
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

    /* JADX INFO: compiled from: IndexClassMEFragment241.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment241$Companion;", "", "()V", "DATA", "", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/IndexClassMEFragment241;", "bean", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return IndexClassMEFragment241.TAG;
        }

        public final IndexClassMEFragment241 newInstance(Object bean) {
            IndexClassMEFragment241 indexClassMEFragment241 = new IndexClassMEFragment241();
            indexClassMEFragment241.setArguments(new Bundle());
            return indexClassMEFragment241;
        }
    }

    static {
        String name = IndexClassMEFragment241.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IndexClassMEFragment241::class.java.name");
        TAG = name;
    }
}
