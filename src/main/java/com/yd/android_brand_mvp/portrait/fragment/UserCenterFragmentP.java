package com.yd.android_brand_mvp.portrait.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blankj.utilcode.util.SPUtils;
import com.heytap.mcssdk.a.a;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.fragment.KBFragment2;
import com.yd.android_brand_mvp.activity.repair.UserRepairFragment;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentUserCenterFragmentBinding;
import com.yd.android_brand_mvp.db.ChatEventBean;
import com.yd.android_brand_mvp.db.ChatFragment3;
import com.yd.android_brand_mvp.landscape.UserCenterMessageFragment;
import com.yd.android_brand_mvp.landscape.active.MyRegistrationFragment;
import com.yd.android_brand_mvp.landscape.evaluation.EvaluationMedalFragment;
import com.yd.android_brand_mvp.landscape.evaluation.EvaluationPointCardFragment;
import com.yd.android_brand_mvp.landscape.evaluation.EvaluationPointFragment;
import com.yd.android_brand_mvp.landscape.exam.UserExamFragment;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.landscape.task.HonorSingleFragment;
import com.yd.android_brand_mvp.landscape.task.MyTaskFragment;
import com.yd.android_brand_mvp.model.collect.UserVerifyBean;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.portrait.adapter.UserComponentAdapter;
import com.yd.android_brand_mvp.user.fragment.StudentLeaveFragment;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import com.yyide.im.chat.login.UserInfo;
import com.yyide.im.chat.utils.DemoLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: UserCenterFragmentP.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\bH\u0002J(\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001f0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\u0006\u0010!\u001a\u00020\"R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/fragment/UserCenterFragmentP;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentUserCenterFragmentBinding;", "()V", HiAnalyticsConstant.Direction.RESPONSE, "Lcom/yd/android_brand_mvp/model/selectNewStudentByIcCardRsp;", "tabs", "", "", "[Ljava/lang/String;", "viewModel", "Lcom/yd/android_brand_mvp/portrait/fragment/UserCenterFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/portrait/fragment/UserCenterFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initIm", "", "userid", "userSig", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onChatEventMessage", "bean", "Lcom/yd/android_brand_mvp/db/ChatEventBean;", "onDestroyView", "setFragment", RemoteMessageConst.Notification.TAG, "splitList", "", TUIKitConstants.Selection.LIST, "groupSize", "", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserCenterFragmentP extends KTBaseFragment<FragmentUserCenterFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private selectNewStudentByIcCardRsp rsp;
    private final String[] tabs;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentP$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserCenterFragmentP.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentUserCenterFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentUserCenterFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentUserCenterFragmentBinding;", 0);
        }

        public final FragmentUserCenterFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentUserCenterFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentUserCenterFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UserCenterFragmentP() {
        super(AnonymousClass1.INSTANCE);
        this.tabs = new String[]{"课表", "请假", "我的报名", "考试", "消息", "个人荣誉", "留言", "打卡任务", "我的勋章", "我的积分卡", "我的积分", "报修"};
        final UserCenterFragmentP userCenterFragmentP = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentP$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return userCenterFragmentP;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentP$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(userCenterFragmentP, Reflection.getOrCreateKotlinClass(UserCenterFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentP$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentP$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentP$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = userCenterFragmentP.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentUserCenterFragmentBinding access$getBinding(UserCenterFragmentP userCenterFragmentP) {
        return userCenterFragmentP.getBinding();
    }

    /* JADX INFO: compiled from: UserCenterFragmentP.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/fragment/UserCenterFragmentP$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/portrait/fragment/UserCenterFragmentP;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UserCenterFragmentP newInstance() {
            return new UserCenterFragmentP();
        }
    }

    private final UserCenterFragmentViewModel getViewModel() {
        return (UserCenterFragmentViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        EventBus.getDefault().register(this);
    }

    private final void initView() {
        Banner startPosition;
        Banner adapter;
        Banner bannerIsAutoLoop;
        Banner loopTime;
        Banner indicator;
        Banner indicatorGravity;
        Banner indicatorSpace;
        Banner indicatorNormalColor;
        Banner indicatorSelectedColor;
        Banner indicatorWidth;
        String str;
        selectNewStudentByIcCardRsp selectnewstudentbyiccardrspUSERCENTINFO2 = SpData.USERCENTINFO2();
        this.rsp = selectnewstudentbyiccardrspUSERCENTINFO2;
        if (selectnewstudentbyiccardrspUSERCENTINFO2 != null) {
            getBinding().tvClassName.setText(selectnewstudentbyiccardrspUSERCENTINFO2.data.className);
            getBinding().name.setText(selectnewstudentbyiccardrspUSERCENTINFO2.data.name);
            if (TextUtils.isEmpty(selectnewstudentbyiccardrspUSERCENTINFO2.data.teacherName)) {
                getBinding().teacherName.setText("无");
            } else {
                TextView textView = getBinding().teacherName;
                if (BaseConstant.APP_VERSION_TYPE == BaseConstant.COMMON_VERSION) {
                    str = "班主任:\t";
                } else {
                    str = "辅导员:\t" + selectnewstudentbyiccardrspUSERCENTINFO2.data.teacherName;
                }
                textView.setText(str);
            }
            GlideUtil.loadCircleImage(getActivity(), selectnewstudentbyiccardrspUSERCENTINFO2.data.avatar, getBinding().img);
            getViewModel().getUserSig();
        }
        List<List<String>> listSplitList = splitList(ArraysKt.toMutableList(this.tabs), 5);
        UserComponentAdapter userComponentAdapter = new UserComponentAdapter();
        userComponentAdapter.setItemClick(new UserComponentAdapter.ItemClick() { // from class: com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentP.initView.2
            @Override // com.yd.android_brand_mvp.portrait.adapter.UserComponentAdapter.ItemClick
            public void onItemClick(int position, String item) {
                Intrinsics.checkNotNullParameter(item, "item");
                UserCenterFragmentP.access$getBinding(UserCenterFragmentP.this).banner.getAdapter().notifyDataSetChanged();
                UserCenterFragmentP.this.setFragment(item);
            }
        });
        MutableLiveData<Result<getUserSigByUserIdRsp.DataBean>> userSigLiveData = getViewModel().getUserSigLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends getUserSigByUserIdRsp.DataBean>, Unit> function1 = new Function1<Result<? extends getUserSigByUserIdRsp.DataBean>, Unit>() { // from class: com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentP.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends getUserSigByUserIdRsp.DataBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends getUserSigByUserIdRsp.DataBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    getUserSigByUserIdRsp.DataBean dataBean = (getUserSigByUserIdRsp.DataBean) value;
                    if (dataBean != null) {
                        UserCenterFragmentP.this.initIm(dataBean.identifier, dataBean.userSig);
                    }
                }
            }
        };
        userSigLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$UserCenterFragmentP$05tozZ2qv-gX8Xl6_mrya2_eKwA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserCenterFragmentP.initView$lambda$1(function1, obj);
            }
        });
        Banner bannerAddBannerLifecycleObserver = getBinding().banner.addBannerLifecycleObserver(this);
        if (bannerAddBannerLifecycleObserver != null && (startPosition = bannerAddBannerLifecycleObserver.setStartPosition(1)) != null && (adapter = startPosition.setAdapter(userComponentAdapter)) != null && (bannerIsAutoLoop = adapter.isAutoLoop(false)) != null && (loopTime = bannerIsAutoLoop.setLoopTime(5000L)) != null && (indicator = loopTime.setIndicator(new CircleIndicator(requireContext()))) != null && (indicatorGravity = indicator.setIndicatorGravity(1)) != null && (indicatorSpace = indicatorGravity.setIndicatorSpace(BannerUtils.dp2px(10.0f))) != null && (indicatorNormalColor = indicatorSpace.setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray))) != null && (indicatorSelectedColor = indicatorNormalColor.setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue12))) != null && (indicatorWidth = indicatorSelectedColor.setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f))) != null) {
            indicatorWidth.setIndicatorHeight(BannerUtils.dp2px(10.0f));
        }
        getBinding().banner.setDatas(listSplitList);
        setFragment(this.tabs[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFragment(String tag) {
        selectNewStudentByIcCardRsp.DataBean dataBean;
        selectNewStudentByIcCardRsp.DataBean dataBean2;
        selectNewStudentByIcCardRsp.DataBean dataBean3;
        selectNewStudentByIcCardRsp.DataBean dataBean4;
        selectNewStudentByIcCardRsp.DataBean dataBean5;
        selectNewStudentByIcCardRsp.DataBean dataBean6;
        selectNewStudentByIcCardRsp.DataBean dataBean7;
        selectNewStudentByIcCardRsp.DataBean dataBean8;
        selectNewStudentByIcCardRsp.DataBean dataBean9;
        selectNewStudentByIcCardRsp.DataBean dataBean10;
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        Intent intent = new Intent();
        intent.setAction("setIndex");
        if (Intrinsics.areEqual(tag, this.tabs[0])) {
            fragmentTransactionBeginTransaction.replace(getBinding().content.getId(), new KBFragment2());
            requireActivity().sendBroadcast(intent);
        } else {
            String str = null;
            if (Intrinsics.areEqual(tag, this.tabs[1])) {
                int id = getBinding().content.getId();
                StudentLeaveFragment.Companion companion = StudentLeaveFragment.INSTANCE;
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp = this.rsp;
                String str2 = (selectnewstudentbyiccardrsp == null || (dataBean10 = selectnewstudentbyiccardrsp.data) == null) ? null : dataBean10.id;
                if (str2 == null) {
                    str2 = "";
                }
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp2 = this.rsp;
                if (selectnewstudentbyiccardrsp2 != null && (dataBean9 = selectnewstudentbyiccardrsp2.data) != null) {
                    str = dataBean9.name;
                }
                fragmentTransactionBeginTransaction.replace(id, companion.newInstance(str2, str != null ? str : ""));
                requireActivity().sendBroadcast(intent);
            } else if (Intrinsics.areEqual(tag, this.tabs[2])) {
                int id2 = getBinding().content.getId();
                MyRegistrationFragment.Companion companion2 = MyRegistrationFragment.INSTANCE;
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp3 = this.rsp;
                if (selectnewstudentbyiccardrsp3 != null && (dataBean8 = selectnewstudentbyiccardrsp3.data) != null) {
                    str = dataBean8.id;
                }
                fragmentTransactionBeginTransaction.replace(id2, companion2.newInstance(str != null ? str : ""));
            } else if (Intrinsics.areEqual(tag, this.tabs[3])) {
                int id3 = getBinding().content.getId();
                UserExamFragment.Companion companion3 = UserExamFragment.INSTANCE;
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp4 = this.rsp;
                if (selectnewstudentbyiccardrsp4 != null && (dataBean7 = selectnewstudentbyiccardrsp4.data) != null) {
                    str = dataBean7.id;
                }
                fragmentTransactionBeginTransaction.replace(id3, companion3.newInstance(str != null ? str : ""));
            } else if (Intrinsics.areEqual(tag, this.tabs[4])) {
                fragmentTransactionBeginTransaction.replace(getBinding().content.getId(), new UserCenterMessageFragment());
                SPUtils.getInstance().put(SpData.Refresh, true);
            } else if (Intrinsics.areEqual(tag, this.tabs[5])) {
                fragmentTransactionBeginTransaction.replace(getBinding().content.getId(), HonorSingleFragment.INSTANCE.newInstance());
            } else if (Intrinsics.areEqual(tag, this.tabs[6])) {
                int id4 = getBinding().content.getId();
                CommentsHomeFragment.Companion companion4 = CommentsHomeFragment.INSTANCE;
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp5 = this.rsp;
                String str3 = (selectnewstudentbyiccardrsp5 == null || (dataBean6 = selectnewstudentbyiccardrsp5.data) == null) ? null : dataBean6.id;
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp6 = this.rsp;
                if (selectnewstudentbyiccardrsp6 != null && (dataBean5 = selectnewstudentbyiccardrsp6.data) != null) {
                    str = dataBean5.classesId;
                }
                fragmentTransactionBeginTransaction.replace(id4, companion4.newInstance(str3, str));
            } else if (Intrinsics.areEqual(tag, this.tabs[7])) {
                int id5 = getBinding().content.getId();
                MyTaskFragment.Companion companion5 = MyTaskFragment.INSTANCE;
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp7 = this.rsp;
                if (selectnewstudentbyiccardrsp7 != null && (dataBean4 = selectnewstudentbyiccardrsp7.data) != null) {
                    str = dataBean4.id;
                }
                fragmentTransactionBeginTransaction.replace(id5, companion5.newInstance(str != null ? str : ""));
            } else if (Intrinsics.areEqual(tag, this.tabs[8])) {
                int id6 = getBinding().content.getId();
                EvaluationMedalFragment.Companion companion6 = EvaluationMedalFragment.INSTANCE;
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp8 = this.rsp;
                if (selectnewstudentbyiccardrsp8 != null && (dataBean3 = selectnewstudentbyiccardrsp8.data) != null) {
                    str = dataBean3.id;
                }
                fragmentTransactionBeginTransaction.replace(id6, companion6.newInstance(str != null ? str : ""));
            } else if (Intrinsics.areEqual(tag, this.tabs[9])) {
                int id7 = getBinding().content.getId();
                EvaluationPointCardFragment.Companion companion7 = EvaluationPointCardFragment.INSTANCE;
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp9 = this.rsp;
                if (selectnewstudentbyiccardrsp9 != null && (dataBean2 = selectnewstudentbyiccardrsp9.data) != null) {
                    str = dataBean2.id;
                }
                fragmentTransactionBeginTransaction.replace(id7, companion7.newInstance(str != null ? str : ""));
            } else if (Intrinsics.areEqual(tag, this.tabs[10])) {
                int id8 = getBinding().content.getId();
                EvaluationPointFragment.Companion companion8 = EvaluationPointFragment.INSTANCE;
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp10 = this.rsp;
                if (selectnewstudentbyiccardrsp10 != null && (dataBean = selectnewstudentbyiccardrsp10.data) != null) {
                    str = dataBean.id;
                }
                fragmentTransactionBeginTransaction.replace(id8, companion8.newInstance(str != null ? str : ""));
            } else if (Intrinsics.areEqual(tag, this.tabs[11])) {
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp11 = this.rsp;
                Intrinsics.checkNotNull(selectnewstudentbyiccardrsp11);
                String str4 = selectnewstudentbyiccardrsp11.data.name;
                Intrinsics.checkNotNullExpressionValue(str4, "rsp!!.data.name");
                selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp12 = this.rsp;
                Intrinsics.checkNotNull(selectnewstudentbyiccardrsp12);
                String str5 = selectnewstudentbyiccardrsp12.data.id;
                Intrinsics.checkNotNullExpressionValue(str5, "rsp!!.data.id");
                fragmentTransactionBeginTransaction.replace(getBinding().content.getId(), UserRepairFragment.INSTANCE.newInstance(new UserVerifyBean(true, str4, str5, "")));
            }
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public final List<List<String>> splitList(List<String> list, int groupSize) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        int i = ((size + groupSize) - 1) / groupSize;
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 * groupSize;
            i2++;
            arrayList.add(list.subList(i3, RangesKt.coerceAtMost(i2 * groupSize, size)));
        }
        return arrayList;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onChatEventMessage(ChatEventBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        fragmentTransactionBeginTransaction.setTransition(4097);
        if (bean.getType() == 5) {
            ChatInfo chatInfo = new ChatInfo();
            chatInfo.setId(bean.getId());
            chatInfo.setType(bean.getChatType());
            chatInfo.setChatName(bean.getChatName());
            ChatFragment3 chatFragment3 = new ChatFragment3();
            fragmentTransactionBeginTransaction.add(R.id.content, chatFragment3);
            fragmentTransactionBeginTransaction.addToBackStack(null);
            Bundle bundle = new Bundle();
            bundle.putSerializable("chatInfo", chatInfo);
            chatFragment3.setArguments(bundle);
            fragmentTransactionBeginTransaction.commit();
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.portrait.fragment.UserCenterFragmentP$initIm$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UserCenterFragmentP.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/yd/android_brand_mvp/portrait/fragment/UserCenterFragmentP$initIm$1", "Lcom/tencent/qcloud/tim/uikit/base/IUIKitCallBack;", "onError", "", "module", "", a.j, "", "desc", "onSuccess", "data", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C05531 implements IUIKitCallBack {
        final /* synthetic */ String $userSig;
        final /* synthetic */ String $userid;

        C05531(String str, String str2) {
            this.$userSig = str;
            this.$userid = str2;
        }

        @Override // com.tencent.qcloud.tim.uikit.base.IUIKitCallBack
        public void onError(String module, final int code, final String desc) {
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(desc, "desc");
            if (UserCenterFragmentP.this.mActivity != null) {
                UserCenterFragmentP.this.mActivity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$UserCenterFragmentP$initIm$1$xMsFP6vvqG5WC4SXxLClOTC9ldg
                    @Override // java.lang.Runnable
                    public final void run() {
                        UserCenterFragmentP.C05531.onError$lambda$0(code, desc);
                    }
                });
            }
            DemoLog.i("TAG", "imLogin errorCode = " + code + ", errorInfo = " + desc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onError$lambda$0(int i, String desc) {
            Intrinsics.checkNotNullParameter(desc, "$desc");
            Log.e("initIm:", "登录失败, errCode = " + i + ", errInfo = " + desc);
        }

        @Override // com.tencent.qcloud.tim.uikit.base.IUIKitCallBack
        public void onSuccess(Object data) {
            Log.i("initIm:", "IM登录成功");
            if (UserCenterFragmentP.this.mActivity != null) {
                UserInfo.getInstance().setAutoLogin(true);
                UserInfo.getInstance().setUserSig(this.$userSig);
                UserInfo.getInstance().setUserId(this.$userid);
                ToastUtil.showBottomView(UserCenterFragmentP.this.mActivity, "聊天激活成功");
            }
        }
    }

    public final void initIm(String userid, String userSig) {
        TUIKit.login(userid, userSig, new C05531(userSig, userid));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
