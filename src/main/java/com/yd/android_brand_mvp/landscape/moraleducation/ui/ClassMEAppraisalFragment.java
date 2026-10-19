package com.yd.android_brand_mvp.landscape.moraleducation.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vivo.push.PushClientConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentClassMeAppraisalBinding;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.landscape.moraleducation.model.AppraisalScoreParamModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.FirstIndicatorModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.SubAppraisalScoreParamModel;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.ClassMEAppraisalAdapter;
import com.yd.android_brand_mvp.landscape.moraleducation.viewmodel.ClassMEViewModel;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.utils.ToastUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
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

/* JADX INFO: compiled from: ClassMEAppraisalFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ClassMEAppraisalFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentClassMeAppraisalBinding;", "()V", "mClassMEAppraisalAdapterMap", "", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ClassMEAppraisalAdapter;", "mViewModel", "Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "getMViewModel", "()Lcom/yd/android_brand_mvp/landscape/moraleducation/viewmodel/ClassMEViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "onDestroy", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassMEAppraisalFragment extends KTBaseFragment<FragmentClassMeAppraisalBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<Integer, ClassMEAppraisalAdapter> mClassMEAppraisalAdapterMap;

    /* JADX INFO: renamed from: mViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mViewModel;

    @JvmStatic
    public static final ClassMEAppraisalFragment newInstance(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.ClassMEAppraisalFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClassMEAppraisalFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentClassMeAppraisalBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentClassMeAppraisalBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentClassMeAppraisalBinding;", 0);
        }

        public final FragmentClassMeAppraisalBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentClassMeAppraisalBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentClassMeAppraisalBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentClassMeAppraisalBinding access$getBinding(ClassMEAppraisalFragment classMEAppraisalFragment) {
        return classMEAppraisalFragment.getBinding();
    }

    public ClassMEAppraisalFragment() {
        super(AnonymousClass1.INSTANCE);
        final ClassMEAppraisalFragment classMEAppraisalFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ClassMEAppraisalFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return classMEAppraisalFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ClassMEAppraisalFragment$special$$inlined$viewModels$default$2
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
        this.mViewModel = FragmentViewModelLazyKt.createViewModelLazy(classMEAppraisalFragment, Reflection.getOrCreateKotlinClass(ClassMEViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ClassMEAppraisalFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ClassMEAppraisalFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ClassMEAppraisalFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = classMEAppraisalFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.mClassMEAppraisalAdapterMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassMEViewModel getMViewModel() {
        return (ClassMEViewModel) this.mViewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String string = requireArguments().getString("userName");
        String string2 = requireArguments().getString(PushClientConstants.TAG_CLASS_NAME);
        String string3 = requireArguments().getString("cycle");
        getMViewModel().getScoringRubric(requireArguments().getString("activityId"), requireArguments().getString("teacherId"), requireArguments().getString(CommentsHomeFragment.TYPE_ID));
        MutableLiveData<Result<List<FirstIndicatorModel>>> mIndicatorModelLiveData = getMViewModel().getMIndicatorModelLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final C04931 c04931 = new C04931();
        mIndicatorModelLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$ClassMEAppraisalFragment$dL7K1VeoHlGzfKp7klVzOjzqioE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassMEAppraisalFragment.onViewCreated$lambda$0(c04931, obj);
            }
        });
        MutableLiveData<Result<Float>> mSubmitScoreModelLiveData = getMViewModel().getMSubmitScoreModelLiveData();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends Float>, Unit> function1 = new Function1<Result<? extends Float>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ClassMEAppraisalFragment.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Float> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends Float> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                if (((Float) value) != null) {
                    ToastUtil.showBottomView((Activity) ClassMEAppraisalFragment.this.requireActivity(), ClassMEAppraisalFragment.this.getResources().getString(R.string.ranking_success));
                    EventBus.getDefault().post(new EventBean(10005, "", "更新模块数据"));
                    ClassMEAppraisalFragment.this.requireActivity().finish();
                    return;
                }
                ToastUtil.showBottomView((Activity) ClassMEAppraisalFragment.this.requireActivity(), ClassMEAppraisalFragment.this.getResources().getString(R.string.ranking_failure));
            }
        };
        mSubmitScoreModelLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$ClassMEAppraisalFragment$JCTIDp-H_SA4t5xH0ujmMTDNiOM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassMEAppraisalFragment.onViewCreated$lambda$1(function1, obj);
            }
        });
        TextView textView = getBinding().tvHello;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string4 = getResources().getString(R.string.user_name_for_submitting_score);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…ame_for_submitting_score)");
        String str = String.format(string4, Arrays.copyOf(new Object[]{string}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        getBinding().tvToBeAppraisedClass.setText(string2);
        getBinding().tvCurrentWeek.setText(string3);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.ClassMEAppraisalFragment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClassMEAppraisalFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0006*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/FirstIndicatorModel;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C04931 extends Lambda implements Function1<Result<? extends List<? extends FirstIndicatorModel>>, Unit> {
        C04931() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends FirstIndicatorModel>> result) {
            invoke2(result);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Result<? extends List<? extends FirstIndicatorModel>> it2) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            Object value = it2.getValue();
            if (Result.m597isFailureimpl(value)) {
                value = null;
            }
            List list = (List) value;
            if (list == null) {
                return;
            }
            ClassMEAppraisalFragment.access$getBinding(ClassMEAppraisalFragment.this).rgMeAppraisal.setWeightSum(list.size());
            ClassMEAppraisalFragment classMEAppraisalFragment = ClassMEAppraisalFragment.this;
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                RadioButton radioButton = new RadioButton(classMEAppraisalFragment.requireContext());
                radioButton.setId(i);
                radioButton.setBackgroundResource(R.drawable.radio_button_bg_selector);
                radioButton.setTextColor(AppCompatResources.getColorStateList(classMEAppraisalFragment.requireContext(), R.color.radio_button_text_selector));
                radioButton.setTextSize(24.0f);
                radioButton.setText(((FirstIndicatorModel) obj).getMFirstIndicatorName());
                radioButton.setButtonDrawable((Drawable) null);
                radioButton.setGravity(17);
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, 52);
                layoutParams.weight = 1.0f;
                ClassMEAppraisalFragment.access$getBinding(classMEAppraisalFragment).rgMeAppraisal.addView(radioButton, layoutParams);
                Map map = classMEAppraisalFragment.mClassMEAppraisalAdapterMap;
                Integer numValueOf = Integer.valueOf(i);
                Context contextRequireContext = classMEAppraisalFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                map.put(numValueOf, new ClassMEAppraisalAdapter(contextRequireContext, String.valueOf(i), ((FirstIndicatorModel) list.get(i)).getMIndicatorDetailList()));
                i = i2;
            }
            RadioGroup radioGroup = ClassMEAppraisalFragment.access$getBinding(ClassMEAppraisalFragment.this).rgMeAppraisal;
            final ClassMEAppraisalFragment classMEAppraisalFragment2 = ClassMEAppraisalFragment.this;
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$ClassMEAppraisalFragment$onViewCreated$1$NzCI7k4kbQPoiycuzEztKpaTuaU
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                    ClassMEAppraisalFragment.C04931.invoke$lambda$2(classMEAppraisalFragment2, radioGroup2, i3);
                }
            });
            ClassMEAppraisalFragment.access$getBinding(ClassMEAppraisalFragment.this).rgMeAppraisal.check(0);
            TextView textView = ClassMEAppraisalFragment.access$getBinding(ClassMEAppraisalFragment.this).tvSubmit;
            final ClassMEAppraisalFragment classMEAppraisalFragment3 = ClassMEAppraisalFragment.this;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$ClassMEAppraisalFragment$onViewCreated$1$qwm5wcOB_8o_269AF-YMcxwjTr4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClassMEAppraisalFragment.C04931.invoke$lambda$4(classMEAppraisalFragment3, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(ClassMEAppraisalFragment this$0, RadioGroup radioGroup, int i) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ClassMEAppraisalAdapter classMEAppraisalAdapter = (ClassMEAppraisalAdapter) this$0.mClassMEAppraisalAdapterMap.get(Integer.valueOf(i));
            ClassMEAppraisalFragment.access$getBinding(this$0).rvClassMeAppraisal.setLayoutManager(new GridLayoutManager(this$0.requireContext(), 2));
            ClassMEAppraisalFragment.access$getBinding(this$0).rvClassMeAppraisal.setAdapter(classMEAppraisalAdapter);
            ClassMEAppraisalFragment.access$getBinding(this$0).rvClassMeAppraisal.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ClassMEAppraisalFragment$onViewCreated$1$2$1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view, parent, state);
                    outRect.bottom = 30;
                    outRect.right = 16;
                }
            });
            if (classMEAppraisalAdapter != null) {
                classMEAppraisalAdapter.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$4(ClassMEAppraisalFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ClassMEAppraisalFragment.access$getBinding(this$0).tvSubmit.requestFocus();
            Bundle bundleRequireArguments = this$0.requireArguments();
            String string = bundleRequireArguments.getString("schoolId");
            String string2 = bundleRequireArguments.getString("activityId");
            String string3 = bundleRequireArguments.getString("cycleId");
            String string4 = bundleRequireArguments.getString("fromGroupId");
            String string5 = bundleRequireArguments.getString("fromPersonId");
            String string6 = bundleRequireArguments.getString("toObjId");
            String string7 = bundleRequireArguments.getString("toObjName");
            ArrayList arrayList = new ArrayList();
            Iterator<Map<Integer, SubAppraisalScoreParamModel>> it2 = ClassMEAppraisalAdapter.INSTANCE.getMRecordScoreMap().values().iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList, CollectionsKt.toMutableList((Collection) it2.next().values()));
            }
            this$0.getMViewModel().submitScore(new AppraisalScoreParamModel(string, string2, string3, string4, string5, string6, string7, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ClassMEAppraisalAdapter.INSTANCE.getMRecordScoreMap().clear();
    }

    /* JADX INFO: compiled from: ClassMEAppraisalFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0080\u0001\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ClassMEAppraisalFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ClassMEAppraisalFragment;", "userName", "", PushClientConstants.TAG_CLASS_NAME, "cycle", "schoolId", "activityId", "cycleId", "fromGroupId", "fromPersonId", "toObjId", "toObjName", "teacherId", CommentsHomeFragment.TYPE_ID, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ClassMEAppraisalFragment newInstance(String userName, String className, String cycle, String schoolId, String activityId, String cycleId, String fromGroupId, String fromPersonId, String toObjId, String toObjName, String teacherId, String studentId) {
            ClassMEAppraisalFragment classMEAppraisalFragment = new ClassMEAppraisalFragment();
            Bundle bundle = new Bundle();
            bundle.putString("userName", userName);
            bundle.putString(PushClientConstants.TAG_CLASS_NAME, className);
            bundle.putString("cycle", cycle);
            bundle.putString("schoolId", schoolId);
            bundle.putString("activityId", activityId);
            bundle.putString("cycleId", cycleId);
            bundle.putString("fromGroupId", fromGroupId);
            bundle.putString("fromPersonId", fromPersonId);
            bundle.putString("toObjId", toObjId);
            bundle.putString("toObjName", toObjName);
            bundle.putString("teacherId", teacherId);
            bundle.putString(CommentsHomeFragment.TYPE_ID, studentId);
            classMEAppraisalFragment.setArguments(bundle);
            return classMEAppraisalFragment;
        }
    }
}
