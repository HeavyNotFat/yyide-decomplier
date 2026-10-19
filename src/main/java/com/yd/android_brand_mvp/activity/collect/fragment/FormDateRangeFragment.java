package com.yd.android_brand_mvp.activity.collect.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.utils.LunarCalendar;
import com.bigkoo.pickerview.view.TimePickerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ViewCollectFormDateRangeBinding;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.FormDateRangeBean;
import com.yd.android_brand_mvp.model.collect.FormProps;
import com.yd.android_brand_mvp.model.userspace.LeaveTypeBean;
import com.yd.android_brand_mvp.user.viewmodel.StudentApplyLeaveViewModel;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.Calendar;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: FormDateRangeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0007J\u001a\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0016J\u001a\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormDateRangeFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormDateRangeBinding;", "()V", "currentClickType", "", "endDate", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "selectEndTime", "Ljava/util/Date;", "selectStartTime", "startDate", CommentsHomeFragment.TYPE_ID, "", "timeTypeBean", "Lcom/yd/android_brand_mvp/model/userspace/LeaveTypeBean;", "timeView", "Lcom/bigkoo/pickerview/view/TimePickerView;", "viewModel", "Lcom/yd/android_brand_mvp/user/viewmodel/StudentApplyLeaveViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/user/viewmodel/StudentApplyLeaveViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "handleTypeData", "", "typeData", "initTimeSelectView", "type", "", "timeFormat", "initView", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "setTimePickerDate", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormDateRangeFragment extends BaseCollectFragment<ViewCollectFormDateRangeBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int currentClickType;
    private final Calendar endDate;
    private FormBaseBean formItemData;
    private Date selectEndTime;
    private Date selectStartTime;
    private final Calendar startDate;
    private String studentId;
    private LeaveTypeBean timeTypeBean;
    private TimePickerView timeView;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormDateRangeFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormDateRangeFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewCollectFormDateRangeBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ViewCollectFormDateRangeBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ViewCollectFormDateRangeBinding;", 0);
        }

        public final ViewCollectFormDateRangeBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewCollectFormDateRangeBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewCollectFormDateRangeBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ViewCollectFormDateRangeBinding access$getBinding(FormDateRangeFragment formDateRangeFragment) {
        return (ViewCollectFormDateRangeBinding) formDateRangeFragment.getBinding();
    }

    /* JADX INFO: compiled from: FormDateRangeFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormDateRangeFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", CommentsHomeFragment.TYPE_ID, "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Fragment newInstance$default(Companion companion, FormBaseBean formBaseBean, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "";
            }
            return companion.newInstance(formBaseBean, str);
        }

        public final Fragment newInstance(FormBaseBean dataBean, String studentId) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            Intrinsics.checkNotNullParameter(studentId, "studentId");
            FormDateRangeFragment formDateRangeFragment = new FormDateRangeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            bundle.putString(CommentsHomeFragment.TYPE_ID, studentId);
            formDateRangeFragment.setArguments(bundle);
            return formDateRangeFragment;
        }
    }

    public FormDateRangeFragment() {
        super(AnonymousClass1.INSTANCE);
        final FormDateRangeFragment formDateRangeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormDateRangeFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return formDateRangeFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormDateRangeFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(formDateRangeFragment, Reflection.getOrCreateKotlinClass(StudentApplyLeaveViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormDateRangeFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormDateRangeFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormDateRangeFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = formDateRangeFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.studentId = "-1";
        this.startDate = Calendar.getInstance();
        this.endDate = Calendar.getInstance();
    }

    private final StudentApplyLeaveViewModel getViewModel() {
        return (StudentApplyLeaveViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Bundle arguments = getArguments();
        this.formItemData = (FormBaseBean) GsonUtils.fromJson(arguments != null ? arguments.getString("data") : null, FormBaseBean.class);
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString(CommentsHomeFragment.TYPE_ID) : null;
        if (string == null) {
            string = "-1";
        }
        this.studentId = string;
        this.timeTypeBean = new LeaveTypeBean(0, null, null, null, 2, null, 2, false, 175, null);
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean != null) {
            if (!formBaseBean.getProps().getRequired()) {
                TextView textView = ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDateRequired;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormDateRequired");
                SimpleUtilsKt.remove(textView);
                TextView textView2 = ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDateRequired2;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvViewCollectFormDateRequired2");
                SimpleUtilsKt.remove(textView2);
                TextView textView3 = ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDateRequired3;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvViewCollectFormDateRequired3");
                SimpleUtilsKt.remove(textView3);
            }
            if (!formBaseBean.getProps().getShowLength()) {
                TextView textView4 = ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDateName3;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvViewCollectFormDateName3");
                SimpleUtilsKt.remove(textView4);
                TextView textView5 = ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDateRequired3;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.tvViewCollectFormDateRequired3");
                SimpleUtilsKt.remove(textView5);
                TextView textView6 = ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDateLengthContent;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.tvViewCollectFormDateLengthContent");
                SimpleUtilsKt.remove(textView6);
            }
            initTimeSelectView(TransUtils.INSTANCE.getShowTimeTypeArray(formBaseBean.getProps().getFormat()), TransUtils.INSTANCE.getShowTimeToRightFormat(formBaseBean.getProps().getFormat()));
            String value = formBaseBean.getValue();
            if (!(value == null || value.length() == 0)) {
                AppExtKt.logd(this, "value = " + formBaseBean.getValue());
                FormDateRangeBean formDateRangeBean = (FormDateRangeBean) GsonUtils.fromJson(formBaseBean.getValue(), FormDateRangeBean.class);
                if (formDateRangeBean == null) {
                    return;
                }
                if (formDateRangeBean.getStartTime().length() > 0) {
                    ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDate.setText(formDateRangeBean.getStartTime());
                    ImageView imageView = ((ViewCollectFormDateRangeBinding) getBinding()).ivViewCollectFormDateDel;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormDateDel");
                    SimpleUtilsKt.show(imageView);
                    ((ViewCollectFormDateRangeBinding) getBinding()).ivViewCollectFormDate.setImageResource(R.mipmap.icon_date_select);
                }
                if (formDateRangeBean.getEndTime().length() > 0) {
                    ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDate2.setText(formDateRangeBean.getEndTime());
                    ImageView imageView2 = ((ViewCollectFormDateRangeBinding) getBinding()).ivViewCollectFormDateDel2;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivViewCollectFormDateDel2");
                    SimpleUtilsKt.show(imageView2);
                    ((ViewCollectFormDateRangeBinding) getBinding()).ivViewCollectFormDate2.setImageResource(R.mipmap.icon_date_select);
                }
            }
        }
        ((ViewCollectFormDateRangeBinding) getBinding()).clViewCollectFormDate.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateRangeFragment$rF8qO46lYNi31n0CQ870iN-uLig
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormDateRangeFragment.initView$lambda$1(this.f$0, view);
            }
        });
        ((ViewCollectFormDateRangeBinding) getBinding()).clViewCollectFormDate2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateRangeFragment$D20zOsjo-gCVN-RFp7rQJHob6Fs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormDateRangeFragment.initView$lambda$2(this.f$0, view);
            }
        });
        ((ViewCollectFormDateRangeBinding) getBinding()).ivViewCollectFormDateDel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateRangeFragment$5JLp201TP2zAO0R8Z0y49KZHH0o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormDateRangeFragment.initView$lambda$3(this.f$0, view);
            }
        });
        ((ViewCollectFormDateRangeBinding) getBinding()).ivViewCollectFormDateDel2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateRangeFragment$ewKzsmJdgU8BFASAIm8wrqo__Jk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormDateRangeFragment.initView$lambda$4(this.f$0, view);
            }
        });
        LiveData<Result<String>> leaveLength = getViewModel().getLeaveLength();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends String>, Unit> function1 = new Function1<Result<? extends String>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormDateRangeFragment.initView.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends String> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends String> it2) {
                TextView textView7 = FormDateRangeFragment.access$getBinding(FormDateRangeFragment.this).tvViewCollectFormDateLengthContent;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value2 = it2.getValue();
                if (Result.m597isFailureimpl(value2)) {
                    value2 = null;
                }
                String str = (String) value2;
                if (str == null) {
                    str = "";
                }
                textView7.setText(str);
                LeaveTypeBean leaveTypeBean = FormDateRangeFragment.this.timeTypeBean;
                String str2 = leaveTypeBean != null && leaveTypeBean.getDurationType() == 1 ? "天" : "小时";
                FormBaseBean formBaseBean2 = FormDateRangeFragment.this.formItemData;
                if (formBaseBean2 != null) {
                    FormDateRangeFragment formDateRangeFragment = FormDateRangeFragment.this;
                    String string2 = FormDateRangeFragment.access$getBinding(formDateRangeFragment).tvViewCollectFormDate.getText().toString();
                    String string3 = FormDateRangeFragment.access$getBinding(formDateRangeFragment).tvViewCollectFormDate2.getText().toString();
                    String string4 = FormDateRangeFragment.access$getBinding(formDateRangeFragment).tvViewCollectFormDateLengthContent.getText().toString();
                    if (formBaseBean2.getProps().getRequired()) {
                        if (string3.length() > 0) {
                            if (string2.length() > 0) {
                                FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
                                formVerifyBean.setStatus(true);
                                String json = GsonUtils.toJson(new FormDateRangeBean(string2, string3, string4, str2));
                                FormBaseBean formBaseBean3 = formDateRangeFragment.formItemData;
                                Intrinsics.checkNotNull(formBaseBean3);
                                formVerifyBean.setSort(formBaseBean3.getSort());
                                formVerifyBean.setDataValue(json);
                                formVerifyBean.setType(formBaseBean2.getName());
                                EventBus.getDefault().post(formVerifyBean);
                            }
                        }
                    }
                }
            }
        };
        leaveLength.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateRangeFragment$Vgd_9aWzlC6zBJzny8hHX3ZupYY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FormDateRangeFragment.initView$lambda$5(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FormDateRangeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentClickType = 0;
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(FormDateRangeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.currentClickType = 1;
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$3(FormDateRangeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = ((ViewCollectFormDateRangeBinding) this$0.getBinding()).ivViewCollectFormDateDel;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormDateDel");
        SimpleUtilsKt.remove(imageView);
        ((ViewCollectFormDateRangeBinding) this$0.getBinding()).ivViewCollectFormDate.setImageResource(R.mipmap.icon_date_not_select);
        ((ViewCollectFormDateRangeBinding) this$0.getBinding()).tvViewCollectFormDate.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$4(FormDateRangeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = ((ViewCollectFormDateRangeBinding) this$0.getBinding()).ivViewCollectFormDateDel2;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormDateDel2");
        SimpleUtilsKt.remove(imageView);
        ((ViewCollectFormDateRangeBinding) this$0.getBinding()).ivViewCollectFormDate2.setImageResource(R.mipmap.icon_date_not_select);
        ((ViewCollectFormDateRangeBinding) this$0.getBinding()).tvViewCollectFormDate2.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void setTimePickerDate() {
        this.startDate.set(LunarCalendar.MIN_YEAR, 0, 1);
        this.endDate.set(2119, 11, 31);
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean != null) {
            FormProps props = formBaseBean.getProps();
            if (props.getRanges().size() > 1) {
                String str = props.getRanges().get(0);
                String str2 = props.getRanges().get(1);
                if (TimeUtil.gettime66(str) <= 0 || TimeUtil.gettime66(str2) <= 0) {
                    return;
                }
                int dateYear = TimeUtil.getDateYear(str);
                int dateMonth = TimeUtil.getDateMonth(str);
                int dateDay = TimeUtil.getDateDay(str);
                int dateYear2 = TimeUtil.getDateYear(str2);
                int dateMonth2 = TimeUtil.getDateMonth(str2);
                int dateDay2 = TimeUtil.getDateDay(str2);
                Log.i("setTimePickerDate", "startTime=" + str + " - endTime=" + str2);
                Log.i("setTimePickerDate", "startYear=" + dateYear + " startMonth=" + dateMonth + " startDay=" + dateDay);
                Log.i("setTimePickerDate", "endYear=" + dateYear2 + " endMonth=" + dateMonth2 + " endDay=" + dateDay2);
                this.startDate.set(dateYear, dateMonth - 1, dateDay);
                this.endDate.set(dateYear2, dateMonth2 - 1, dateDay2);
            }
        }
    }

    static /* synthetic */ void initTimeSelectView$default(FormDateRangeFragment formDateRangeFragment, boolean[] zArr, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "yyyy-MM-dd HH:mm";
        }
        formDateRangeFragment.initTimeSelectView(zArr, str);
    }

    private final void initTimeSelectView(boolean[] type, final String timeFormat) {
        setTimePickerDate();
        this.timeView = new TimePickerBuilder(requireContext(), new OnTimeSelectListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateRangeFragment$wmmUx1FxuK6ITK-tQzq0C6JmomM
            @Override // com.bigkoo.pickerview.listener.OnTimeSelectListener
            public final void onTimeSelect(Date date, View view) {
                FormDateRangeFragment.initTimeSelectView$lambda$9(this.f$0, timeFormat, date, view);
            }
        }).setDate(Calendar.getInstance()).setType(type).setRangDate(this.startDate, this.endDate).setTextColorCenter(SimpleUtilsKt.asColor(R.color.purple2)).setDividerColor(SimpleUtilsKt.asColor(R.color.purple2)).setLabel("年", "月", "日", "时", "分", "秒").setLayoutRes(R.layout.time_select, new CustomListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateRangeFragment$QgNtA3ytm9D1CT5bH25QJbHrUOs
            @Override // com.bigkoo.pickerview.listener.CustomListener
            public final void customLayout(View view) {
                FormDateRangeFragment.initTimeSelectView$lambda$12(this.f$0, view);
            }
        }).isCenterLabel(false).isDialog(true).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initTimeSelectView$lambda$9(FormDateRangeFragment this$0, String timeFormat, Date date, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(timeFormat, "$timeFormat");
        Calendar.getInstance().setTime(date);
        int i = this$0.currentClickType;
        if (i == 0) {
            Date date2 = this$0.selectEndTime;
            if (date2 != null && !date.before(date2)) {
                ToastUtil.showBottomView(this$0.requireContext(), "时间不能超过结束时间");
                return;
            }
            this$0.selectStartTime = date;
            ((ViewCollectFormDateRangeBinding) this$0.getBinding()).tvViewCollectFormDate.setText(DateUtils.getDate(date, timeFormat));
            ImageView imageView = ((ViewCollectFormDateRangeBinding) this$0.getBinding()).ivViewCollectFormDateDel;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormDateDel");
            SimpleUtilsKt.show(imageView);
            ((ViewCollectFormDateRangeBinding) this$0.getBinding()).ivViewCollectFormDate.setImageResource(R.mipmap.icon_date_select);
        } else if (i == 1) {
            Date date3 = this$0.selectStartTime;
            if (date3 != null && !date.after(date3)) {
                ToastUtil.showBottomView(this$0.requireContext(), "时间不能低于开始时间");
                return;
            }
            this$0.selectEndTime = date;
            ((ViewCollectFormDateRangeBinding) this$0.getBinding()).tvViewCollectFormDate2.setText(DateUtils.getDate(date, timeFormat));
            ImageView imageView2 = ((ViewCollectFormDateRangeBinding) this$0.getBinding()).ivViewCollectFormDateDel2;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivViewCollectFormDateDel2");
            SimpleUtilsKt.show(imageView2);
            ((ViewCollectFormDateRangeBinding) this$0.getBinding()).ivViewCollectFormDate2.setImageResource(R.mipmap.icon_date_select);
        }
        if (this$0.formItemData != null) {
            String string = ((ViewCollectFormDateRangeBinding) this$0.getBinding()).tvViewCollectFormDate.getText().toString();
            String string2 = ((ViewCollectFormDateRangeBinding) this$0.getBinding()).tvViewCollectFormDate2.getText().toString();
            if (string2.length() > 0) {
                if ((string.length() > 0) && this$0.timeTypeBean != null) {
                    StudentApplyLeaveViewModel viewModel = this$0.getViewModel();
                    String str = this$0.studentId;
                    LeaveTypeBean leaveTypeBean = this$0.timeTypeBean;
                    String strValueOf = String.valueOf(leaveTypeBean != null ? Integer.valueOf(leaveTypeBean.getDurationType()) : null);
                    LeaveTypeBean leaveTypeBean2 = this$0.timeTypeBean;
                    viewModel.getLeaveLength(str, string, string2, strValueOf, String.valueOf(leaveTypeBean2 != null ? Integer.valueOf(leaveTypeBean2.getDurationWay()) : null));
                }
            }
        }
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$12(final FormDateRangeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Button button = (Button) view.findViewById(R.id.btnCancel);
        Button button2 = (Button) view.findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateRangeFragment$BkGsnSLyJ-6dGlkOu6s7ipvgU3c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FormDateRangeFragment.initTimeSelectView$lambda$12$lambda$10(this.f$0, view2);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateRangeFragment$CuatmPUDJHQ-V1eVcYGgzId2QIA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FormDateRangeFragment.initTimeSelectView$lambda$12$lambda$11(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$12$lambda$10(FormDateRangeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$12$lambda$11(FormDateRangeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.returnData();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment
    public FormVerifyBean readySubmit() {
        boolean z = false;
        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean == null) {
            formVerifyBean.setStatus(false);
            formVerifyBean.setErrorMessage("数据为空");
            return formVerifyBean;
        }
        Intrinsics.checkNotNull(formBaseBean);
        if (formBaseBean.getProps().getRequired()) {
            CharSequence text = ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDate.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.tvViewCollectFormDate.text");
            if (text.length() == 0) {
                formVerifyBean.setStatus(false);
                formVerifyBean.setErrorMessage("日期必填项未填写");
                return formVerifyBean;
            }
        }
        LeaveTypeBean leaveTypeBean = this.timeTypeBean;
        if (leaveTypeBean != null && leaveTypeBean.getDurationType() == 1) {
            z = true;
        }
        String json = GsonUtils.toJson(new FormDateRangeBean(((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDate.getText().toString(), ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDate2.getText().toString(), ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDateLengthContent.getText().toString(), z ? "天" : "小时"));
        FormBaseBean formBaseBean2 = this.formItemData;
        Intrinsics.checkNotNull(formBaseBean2);
        formVerifyBean.setSort(formBaseBean2.getSort());
        formVerifyBean.setDataValue(json);
        return formVerifyBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public final void handleTypeData(LeaveTypeBean typeData) {
        String str;
        Intrinsics.checkNotNullParameter(typeData, "typeData");
        if (typeData.isSelect()) {
            this.timeTypeBean = typeData;
            TextView textView = ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDateName3;
            if (typeData.getDurationType() == 1) {
            }
            textView.setText(str);
        } else {
            this.timeTypeBean = null;
        }
        ImageView imageView = ((ViewCollectFormDateRangeBinding) getBinding()).ivViewCollectFormDateDel;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormDateDel");
        SimpleUtilsKt.remove(imageView);
        ((ViewCollectFormDateRangeBinding) getBinding()).ivViewCollectFormDate.setImageResource(R.mipmap.icon_date_not_select);
        ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDate.setText("");
        ImageView imageView2 = ((ViewCollectFormDateRangeBinding) getBinding()).ivViewCollectFormDateDel2;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivViewCollectFormDateDel2");
        SimpleUtilsKt.remove(imageView2);
        ((ViewCollectFormDateRangeBinding) getBinding()).ivViewCollectFormDate2.setImageResource(R.mipmap.icon_date_not_select);
        ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDate2.setText("");
        ((ViewCollectFormDateRangeBinding) getBinding()).tvViewCollectFormDateLengthContent.setText("");
        this.selectStartTime = null;
        this.selectEndTime = null;
    }
}
