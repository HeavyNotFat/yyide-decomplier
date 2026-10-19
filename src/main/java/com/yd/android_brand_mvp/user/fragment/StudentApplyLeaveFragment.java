package com.yd.android_brand_mvp.user.fragment;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.reflect.TypeToken;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment;
import com.yd.android_brand_mvp.adapter.userspace.LeavePeopleAdapter;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentStudentApplyLeaveBinding;
import com.yd.android_brand_mvp.databinding.ItemUserLeaveNodeBinding;
import com.yd.android_brand_mvp.dialog.LeaveFinishDialog;
import com.yd.android_brand_mvp.dialog.reservation.userspace.SelectLeavePeopleDialog;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.userspace.FlowElementListItem;
import com.yd.android_brand_mvp.model.userspace.LeaveFormBean;
import com.yd.android_brand_mvp.model.userspace.LeaveProcessBean;
import com.yd.android_brand_mvp.model.userspace.UserInfoListItem;
import com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel;
import com.yd.android_brand_mvp.utils.MMKVUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.form.FormComponentUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: StudentApplyLeaveFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\r\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0016J\u001a\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0007J\b\u0010(\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J \u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/user/fragment/StudentApplyLeaveFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentStudentApplyLeaveBinding;", "()V", "componentDataList", "", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "formKey", "", "idPrefix", "", "kitDataList", "processAdapter", "com/yd/android_brand_mvp/user/fragment/StudentApplyLeaveFragment$processAdapter$1", "Lcom/yd/android_brand_mvp/user/fragment/StudentApplyLeaveFragment$processAdapter$1;", "processView", "Landroid/view/View;", CommentsHomeFragment.TYPE_ID, "studentName", "viewModel", "Lcom/yd/android_brand_mvp/user/viewmodel/StudentApplyLeaveViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/user/viewmodel/StudentApplyLeaveViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addComponentFragment", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/userspace/LeaveFormBean;", "(Ljava/lang/Object;)V", "initView", "onDestroyView", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "parseData", "data", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "parseSubmitJsonData", "request", "requestProcess", "key", "id", "jsonContent", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StudentApplyLeaveFragment extends KTBaseFragment<FragmentStudentApplyLeaveBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<FormBaseBean> componentDataList;
    private String formKey;
    private final int idPrefix;
    private final List<FormBaseBean> kitDataList;
    private final StudentApplyLeaveFragment$processAdapter$1 processAdapter;
    private View processView;
    private String studentId;
    private String studentName;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: StudentApplyLeaveFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentStudentApplyLeaveBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentStudentApplyLeaveBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentStudentApplyLeaveBinding;", 0);
        }

        public final FragmentStudentApplyLeaveBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentStudentApplyLeaveBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentStudentApplyLeaveBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$processAdapter$1] */
    public StudentApplyLeaveFragment() {
        super(AnonymousClass1.INSTANCE);
        final StudentApplyLeaveFragment studentApplyLeaveFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return studentApplyLeaveFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(studentApplyLeaveFragment, Reflection.getOrCreateKotlinClass(StudentApplyLeaveViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = studentApplyLeaveFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.idPrefix = PushConstants.DOWN_LOAD_LARGE_ICON_ERROR;
        this.studentId = "-1";
        this.studentName = "";
        this.formKey = "-1";
        this.componentDataList = new ArrayList();
        this.kitDataList = new ArrayList();
        this.processAdapter = new BaseBindingAdapter<ItemUserLeaveNodeBinding, FlowElementListItem>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$processAdapter$1
            {
                super(null, 1, null);
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, FlowElementListItem flowElementListItem) {
                convertPlus2((VBViewHolder<ItemUserLeaveNodeBinding>) vBViewHolder, flowElementListItem);
            }

            /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
            public void convertPlus2(VBViewHolder<ItemUserLeaveNodeBinding> holder, FlowElementListItem item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemUserLeaveNodeBinding itemUserLeaveNodeBinding = (ItemUserLeaveNodeBinding) holder.getBinding();
                if (itemUserLeaveNodeBinding != null) {
                    StudentApplyLeaveFragment studentApplyLeaveFragment2 = this.this$0;
                    if (getData().size() == 1) {
                        View view = itemUserLeaveNodeBinding.viewTopLine;
                        Intrinsics.checkNotNullExpressionValue(view, "it.viewTopLine");
                        SimpleUtilsKt.remove(view);
                        View view2 = itemUserLeaveNodeBinding.viewTopBottom;
                        Intrinsics.checkNotNullExpressionValue(view2, "it.viewTopBottom");
                        SimpleUtilsKt.remove(view2);
                    } else {
                        int layoutPosition = holder.getLayoutPosition();
                        if (layoutPosition == 0) {
                            View view3 = itemUserLeaveNodeBinding.viewTopLine;
                            Intrinsics.checkNotNullExpressionValue(view3, "it.viewTopLine");
                            SimpleUtilsKt.remove(view3);
                        } else if (layoutPosition == getData().size() - 1) {
                            View view4 = itemUserLeaveNodeBinding.viewTopBottom;
                            Intrinsics.checkNotNullExpressionValue(view4, "it.viewTopBottom");
                            SimpleUtilsKt.remove(view4);
                        } else {
                            View view5 = itemUserLeaveNodeBinding.viewTopLine;
                            Intrinsics.checkNotNullExpressionValue(view5, "it.viewTopLine");
                            SimpleUtilsKt.show(view5);
                            View view6 = itemUserLeaveNodeBinding.viewTopBottom;
                            Intrinsics.checkNotNullExpressionValue(view6, "it.viewTopBottom");
                            SimpleUtilsKt.show(view6);
                        }
                    }
                    itemUserLeaveNodeBinding.tvItemUserLeaveNodeName.setText(item.getName());
                    LeavePeopleAdapter leavePeopleAdapter = new LeavePeopleAdapter();
                    if (item.getUserSelectType() == 1) {
                        ImageView imageView = itemUserLeaveNodeBinding.ivItemUserLeaveNodeAdd;
                        Intrinsics.checkNotNullExpressionValue(imageView, "it.ivItemUserLeaveNodeAdd");
                        SimpleUtilsKt.remove(imageView);
                    } else {
                        ImageView imageView2 = itemUserLeaveNodeBinding.ivItemUserLeaveNodeAdd;
                        Intrinsics.checkNotNullExpressionValue(imageView2, "it.ivItemUserLeaveNodeAdd");
                        SimpleUtilsKt.show(imageView2);
                    }
                    if (!Intrinsics.areEqual(item.getFlowElementType(), "CC")) {
                        Iterator<T> it2 = item.getUserInfoList().iterator();
                        while (it2.hasNext()) {
                            ((UserInfoListItem) it2.next()).setMode(item.getMode());
                        }
                    }
                    List<UserInfoListItem> userInfoList = item.getUserInfoList();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : userInfoList) {
                        if (((UserInfoListItem) obj).getSelected()) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    itemUserLeaveNodeBinding.rvItemUserLeaveNodePeople.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                    itemUserLeaveNodeBinding.rvItemUserLeaveNodePeople.setAdapter(leavePeopleAdapter);
                    leavePeopleAdapter.setList(arrayList2);
                    if (item.isNotUser()) {
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SimpleUtilsKt.asColor(R.color.colorPrimaryDark));
                        String handler = item.getHandler();
                        int iHashCode = handler.hashCode();
                        if (iHashCode == -407216299) {
                            if (handler.equals("TO_PASS")) {
                                SpannableString spannableString = new SpannableString(studentApplyLeaveFragment2.getString(R.string.leave_auto_pass));
                                spannableString.setSpan(foregroundColorSpan, 0, 6, 17);
                                itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(spannableString);
                                return;
                            }
                            return;
                        }
                        if (iHashCode == -407050481) {
                            if (handler.equals("TO_USER")) {
                                StringBuilder sb = new StringBuilder();
                                int i = 0;
                                for (Object obj2 : arrayList2) {
                                    int i2 = i + 1;
                                    if (i < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    sb.append(((UserInfoListItem) obj2).getName());
                                    if (i != CollectionsKt.getLastIndex(arrayList2)) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    i = i2;
                                }
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String string = studentApplyLeaveFragment2.getString(R.string.leave_go_specify);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.leave_go_specify)");
                                String str = String.format(string, Arrays.copyOf(new Object[]{sb}, 1));
                                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                                SpannableString spannableString2 = new SpannableString(str);
                                spannableString2.setSpan(foregroundColorSpan, 0, 6, 17);
                                itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(spannableString2);
                                return;
                            }
                            return;
                        }
                        if (iHashCode == 247427179 && handler.equals("TO_ADMIN")) {
                            StringBuilder sb2 = new StringBuilder();
                            int i3 = 0;
                            for (Object obj3 : arrayList2) {
                                int i4 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                sb2.append(((UserInfoListItem) obj3).getName());
                                if (i3 != CollectionsKt.getLastIndex(arrayList2)) {
                                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                i3 = i4;
                            }
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            String string2 = studentApplyLeaveFragment2.getString(R.string.leave_to_manager);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.leave_to_manager)");
                            String str2 = String.format(string2, Arrays.copyOf(new Object[]{sb2}, 1));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                            SpannableString spannableString3 = new SpannableString(str2);
                            spannableString3.setSpan(foregroundColorSpan, 0, 6, 17);
                            itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(spannableString3);
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(item.getFlowElementType(), "CC")) {
                        itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(arrayList2.size() + "人抄送");
                        return;
                    }
                    String mode = item.getMode();
                    int iHashCode2 = mode.hashCode();
                    if (iHashCode2 == 2531) {
                        if (mode.equals("OR")) {
                            itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(arrayList2.size() + "人或签");
                            return;
                        }
                        return;
                    }
                    if (iHashCode2 == 64951) {
                        if (mode.equals("AND")) {
                            itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(arrayList2.size() + "人会签");
                            return;
                        }
                        return;
                    }
                    if (iHashCode2 == 2392819 && mode.equals("NEXT")) {
                        itemUserLeaveNodeBinding.tvItemUserLeaveNodeDesc.setText(arrayList2.size() + "人依次审批");
                    }
                }
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public ItemUserLeaveNodeBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                Intrinsics.checkNotNullParameter(parent, "parent");
                ItemUserLeaveNodeBinding itemUserLeaveNodeBindingInflate = ItemUserLeaveNodeBinding.inflate(inflater, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemUserLeaveNodeBindingInflate, "inflate(inflater, parent, false)");
                return itemUserLeaveNodeBindingInflate;
            }
        };
    }

    /* JADX INFO: compiled from: StudentApplyLeaveFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/user/fragment/StudentApplyLeaveFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/user/fragment/StudentApplyLeaveFragment;", "id", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StudentApplyLeaveFragment newInstance(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, name);
            StudentApplyLeaveFragment studentApplyLeaveFragment = new StudentApplyLeaveFragment();
            studentApplyLeaveFragment.setArguments(bundle);
            return studentApplyLeaveFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StudentApplyLeaveViewModel getViewModel() {
        return (StudentApplyLeaveViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
        request();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        View view = null;
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "-1";
        }
        this.studentId = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME) : null;
        if (string2 == null) {
            string2 = "";
        }
        this.studentName = string2;
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.view_leave_process, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(requireContext()).i…view_leave_process, null)");
        this.processView = viewInflate;
        if (viewInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processView");
        } else {
            view = viewInflate;
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_view_leave_process);
        addChildClickViewIds(R.id.iv_item_user_leave_node_add);
        setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentApplyLeaveFragment$EOSK5XGpNYUwtiqV6FqLkwHegtA
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                StudentApplyLeaveFragment.initView$lambda$1(this.f$0, baseQuickAdapter, view2, i);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.processAdapter);
        getBinding().llFragmentStudentApplyLeave.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentApplyLeaveFragment$_F1ggfX1sV9xJqUebojsb4tCR6w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StudentApplyLeaveFragment.initView$lambda$2(this.f$0, view2);
            }
        });
        getBinding().btnFragmentStudentApplyLeave.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentApplyLeaveFragment$Yu7ULd12HlIevC0SO3NiJYYvRCA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StudentApplyLeaveFragment.initView$lambda$3(this.f$0, view2);
            }
        });
        LiveData<Result<LeaveFormBean>> studentLeaveForm = getViewModel().getStudentLeaveForm();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends LeaveFormBean>, Unit> function1 = new Function1<Result<? extends LeaveFormBean>, Unit>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends LeaveFormBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends LeaveFormBean> it2) {
                StudentApplyLeaveFragment.this.dismissProgressDialog();
                StudentApplyLeaveFragment studentApplyLeaveFragment = StudentApplyLeaveFragment.this;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                studentApplyLeaveFragment.addComponentFragment(it2.getValue());
            }
        };
        studentLeaveForm.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentApplyLeaveFragment$R1bLjtBsu2cRc-BeRDeq4AE8br4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudentApplyLeaveFragment.initView$lambda$4(function1, obj);
            }
        });
        LiveData<Result<LeaveProcessBean>> studentLeaveProcess = getViewModel().getStudentLeaveProcess();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends LeaveProcessBean>, Unit> function2 = new Function1<Result<? extends LeaveProcessBean>, Unit>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends LeaveProcessBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends LeaveProcessBean> it2) {
                StudentApplyLeaveFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                LeaveProcessBean leaveProcessBean = (LeaveProcessBean) value;
                if (leaveProcessBean == null) {
                    return;
                }
                setList(leaveProcessBean.getFlowElementList());
            }
        };
        studentLeaveProcess.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentApplyLeaveFragment$HmgCTSZ8P8alb_b9y_vRgQyVBFI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudentApplyLeaveFragment.initView$lambda$5(function2, obj);
            }
        });
        LiveData<Result<String>> submitResult = getViewModel().getSubmitResult();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final AnonymousClass6 anonymousClass6 = new AnonymousClass6();
        submitResult.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentApplyLeaveFragment$c2RsJyLPVf69omyJtp70wmvj55M
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudentApplyLeaveFragment.initView$lambda$6(anonymousClass6, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(StudentApplyLeaveFragment this$0, final BaseQuickAdapter adapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        final FlowElementListItem flowElementListItem = this$0.processAdapter.getData().get(i);
        SelectLeavePeopleDialog selectLeavePeopleDialog = new SelectLeavePeopleDialog(flowElementListItem.getUserInfoList(), flowElementListItem.getUserSelectType());
        selectLeavePeopleDialog.setSelectLeavePeopleListener(new SelectLeavePeopleDialog.SelectLeavePeopleListener() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentApplyLeaveFragment$oJayjj68lE6z7WHZ_jufAiiPkaY
            @Override // com.yd.android_brand_mvp.dialog.reservation.userspace.SelectLeavePeopleDialog.SelectLeavePeopleListener
            public final void getUserInfoList(List list) {
                StudentApplyLeaveFragment.initView$lambda$1$lambda$0(flowElementListItem, adapter, i, list);
            }
        });
        selectLeavePeopleDialog.show(this$0.getChildFragmentManager(), "peopleDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(FlowElementListItem itemData, BaseQuickAdapter adapter, int i, List list) {
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(list, "list");
        itemData.getUserInfoList().clear();
        itemData.getUserInfoList().addAll(list);
        adapter.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(StudentApplyLeaveFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().llFragmentStudentApplyLeave.requestFocus();
        this$0.getBinding().llFragmentStudentApplyLeave.setFocusable(true);
        this$0.getBinding().llFragmentStudentApplyLeave.setFocusableInTouchMode(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(StudentApplyLeaveFragment this$0, View view) {
        boolean z;
        FormVerifyBean formVerifyBean;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showProgressDialog();
        Iterator<Fragment> it2 = this$0.getViewModel().getComponentFragmentList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = true;
                break;
            }
            Fragment next = it2.next();
            BaseCollectFragment baseCollectFragment = next instanceof BaseCollectFragment ? (BaseCollectFragment) next : null;
            if (baseCollectFragment == null || (formVerifyBean = baseCollectFragment.readySubmit()) == null) {
                formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
            }
            if (!formVerifyBean.getStatus()) {
                z = false;
                ToastUtil.showBottomView(this$0.requireContext(), formVerifyBean.getErrorMessage());
                break;
            } else if (!this$0.componentDataList.isEmpty() && formVerifyBean.getSort() >= 0 && formVerifyBean.getSort() < this$0.componentDataList.size()) {
                this$0.componentDataList.get(formVerifyBean.getSort()).setValue(formVerifyBean.getDataValue());
            }
        }
        if (z) {
            this$0.getViewModel().submitLeave(this$0.formKey, this$0.parseSubmitJsonData(), this$0.processAdapter.getData(), this$0.studentId, this$0.studentName);
        } else {
            this$0.dismissProgressDialog();
        }
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

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$initView$6, reason: invalid class name */
    /* JADX INFO: compiled from: StudentApplyLeaveFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass6 extends Lambda implements Function1<Result<? extends String>, Unit> {
        AnonymousClass6() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends String> result) {
            invoke2(result);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Result<? extends String> it2) {
            StudentApplyLeaveFragment.this.dismissProgressDialog();
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            Object value = it2.getValue();
            if (Result.m597isFailureimpl(value)) {
                value = null;
            }
            final String str = (String) value;
            if (str == null) {
                return;
            }
            Result<LeaveFormBean> resultM570getMLeaveFormBeanxLWZpok = StudentApplyLeaveFragment.this.getViewModel().m570getMLeaveFormBeanxLWZpok();
            if (resultM570getMLeaveFormBeanxLWZpok != null) {
                StudentApplyLeaveFragment.this.addComponentFragment(resultM570getMLeaveFormBeanxLWZpok.getValue());
            }
            setList(null);
            LeaveFinishDialog leaveFinishDialog = new LeaveFinishDialog(StudentApplyLeaveFragment.this.requireContext());
            leaveFinishDialog.show();
            leaveFinishDialog.setFinishListener(new LeaveFinishDialog.addListener() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentApplyLeaveFragment$initView$6$x63KQj8zW9PG0RS6yJr4J5jSVm8
                @Override // com.yd.android_brand_mvp.dialog.LeaveFinishDialog.addListener
                public final void addFinishListener() {
                    StudentApplyLeaveFragment.AnonymousClass6.invoke$lambda$1(str);
                }
            });
            ToastUtil.showBottomView(StudentApplyLeaveFragment.this.requireContext(), "请假成功");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(String leaveId) {
            Intrinsics.checkNotNullParameter(leaveId, "$leaveId");
            EventBus.getDefault().post(new EventBean(10002, leaveId, "leave"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addComponentFragment(Object it2) {
        List list;
        boolean z;
        getViewModel().getComponentFragmentList().clear();
        getBinding().llFragmentStudentApplyLeave.removeAllViews();
        getViewModel().setMLeaveFormBean(Result.m590boximpl(it2));
        View view = null;
        if (Result.m597isFailureimpl(it2)) {
            it2 = null;
        }
        LeaveFormBean leaveFormBean = (LeaveFormBean) it2;
        if (leaveFormBean == null || (list = (List) GsonUtils.fromJson(leaveFormBean.getFormItems(), new TypeToken<List<? extends FormBaseBean>>() { // from class: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$addComponentFragment$formItemList$1
        }.getType())) == null) {
            return;
        }
        this.formKey = leaveFormBean.getFromKey();
        this.componentDataList.clear();
        Iterator it3 = list.iterator();
        int i = 0;
        while (true) {
            z = true;
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FormBaseBean formBaseBean = (FormBaseBean) next;
            formBaseBean.setParentSort(i);
            if (formBaseBean.isKit()) {
                this.kitDataList.add(formBaseBean);
                for (FormBaseBean formBaseBean2 : formBaseBean.getChildren()) {
                    formBaseBean2.setKit(true);
                    formBaseBean2.setKitId(formBaseBean.getId());
                }
                this.componentDataList.addAll(formBaseBean.getChildren());
            } else {
                this.componentDataList.add(formBaseBean);
            }
            i = i2;
        }
        if (!this.componentDataList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
            int i3 = 0;
            for (Object obj : this.componentDataList) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FormBaseBean formBaseBean3 = (FormBaseBean) obj;
                if (formBaseBean3.getProps().getRequired()) {
                    z = false;
                }
                formBaseBean3.setSort(i3);
                formBaseBean3.setSortNum(i4);
                Fragment componentFragment = FormComponentUtil.INSTANCE.getComponentFragment(formBaseBean3, this.studentId);
                if (componentFragment != null) {
                    FrameLayout frameLayout = new FrameLayout(requireContext());
                    frameLayout.setId(this.idPrefix + i3);
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                    fragmentTransactionBeginTransaction.replace(frameLayout.getId(), componentFragment);
                    arrayList.add(formBaseBean3);
                    getBinding().llFragmentStudentApplyLeave.addView(frameLayout);
                    getViewModel().getComponentFragmentList().add(componentFragment);
                }
                i3 = i4;
            }
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        }
        LinearLayout linearLayout = getBinding().llFragmentStudentApplyLeave;
        View view2 = this.processView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processView");
        } else {
            view = view2;
        }
        linearLayout.addView(view);
        if (z) {
            requestProcess(leaveFormBean.getFromKey(), this.studentId, leaveFormBean.getFormItems());
        }
    }

    private final void request() {
        showProgressDialog();
        getViewModel().getLeaveFormDetail();
    }

    private final void requestProcess(String key, String id, String jsonContent) {
        showProgressDialog();
        getViewModel().getLeaveProcess(key, id, jsonContent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void parseData(FormVerifyBean data) {
        FormVerifyBean formVerifyBean;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getStatus()) {
            boolean z = true;
            for (Fragment fragment : getViewModel().getComponentFragmentList()) {
                BaseCollectFragment baseCollectFragment = fragment instanceof BaseCollectFragment ? (BaseCollectFragment) fragment : null;
                if (baseCollectFragment == null || (formVerifyBean = baseCollectFragment.readySubmit()) == null) {
                    formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
                }
                if (!formVerifyBean.getStatus()) {
                    z = false;
                    break;
                } else if (!this.componentDataList.isEmpty() && formVerifyBean.getSort() >= 0 && formVerifyBean.getSort() < this.componentDataList.size()) {
                    FormBaseBean formBaseBean = this.componentDataList.get(formVerifyBean.getSort());
                    formBaseBean.setValue(formVerifyBean.getDataValue());
                    formBaseBean.setValueData(formVerifyBean.getDataValueBean());
                }
            }
            if (!z) {
                AppExtKt.logd(this, "达不到请求流程的要求");
            } else {
                requestProcess(this.formKey, this.studentId, parseSubmitJsonData());
            }
        }
    }

    private final String parseSubmitJsonData() {
        ArrayList arrayList = new ArrayList();
        List<FormBaseBean> list = this.componentDataList;
        ArrayList<FormBaseBean> arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((FormBaseBean) obj).isKit()) {
                arrayList2.add(obj);
            }
        }
        for (FormBaseBean formBaseBean : arrayList2) {
            if (Intrinsics.areEqual(formBaseBean.getName(), FormComponentUtil.LeaveType)) {
                formBaseBean.getProps().getOptions().clear();
                formBaseBean.getProps().getOptions().addAll(MMKVUtil.INSTANCE.getLeaveTypeList());
            }
        }
        arrayList.addAll(this.kitDataList);
        for (FormBaseBean formBaseBean2 : this.componentDataList) {
            if (!formBaseBean2.isKit()) {
                arrayList.add(formBaseBean2);
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment$parseSubmitJsonData$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((FormBaseBean) t).getParentSort()), Integer.valueOf(((FormBaseBean) t2).getParentSort()));
                }
            });
        }
        String json = GsonUtils.toJson(arrayList);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(submitBean)");
        return json;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
