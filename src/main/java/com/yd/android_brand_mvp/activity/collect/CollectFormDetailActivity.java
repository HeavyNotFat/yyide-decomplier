package com.yd.android_brand_mvp.activity.collect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment;
import com.yd.android_brand_mvp.activity.collect.viewmodel.CollectFormDetailViewModel;
import com.yd.android_brand_mvp.base.KTBaseActivity;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.databinding.ActivityCollectFormDetailBinding;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.model.collect.CollectListBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.FormDetailBean;
import com.yd.android_brand_mvp.model.collect.UpdateFormStatus;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.WeatherUtils;
import com.yd.android_brand_mvp.utils.form.FormComponentUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CollectFormDetailActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u001a\u001a\u00020\u00132\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001d0\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u001fH\u0014J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u001fH\u0014J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u001fH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/CollectFormDetailActivity;", "Lcom/yd/android_brand_mvp/base/KTBaseActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivityCollectFormDetailBinding;", "()V", "checkId", "", "getCheckId", "()Ljava/lang/String;", "setCheckId", "(Ljava/lang/String;)V", "formListItem", "Lcom/yd/android_brand_mvp/model/collect/CollectListBean;", "getFormListItem", "()Lcom/yd/android_brand_mvp/model/collect/CollectListBean;", "setFormListItem", "(Lcom/yd/android_brand_mvp/model/collect/CollectListBean;)V", "idPrefix", "", "isAvailableNetWork", "", "viewModel", "Lcom/yd/android_brand_mvp/activity/collect/viewmodel/CollectFormDetailViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/activity/collect/viewmodel/CollectFormDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewIsNeedGone", "showExpression", "", "", "getWork", "", "islive", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "parserModuleViewList", "requestFormDetail", "setBackground", "setInfo", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CollectFormDetailActivity extends KTBaseActivity<ActivityCollectFormDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String checkId;
    private CollectListBean formListItem;
    private final int idPrefix;
    private boolean isAvailableNetWork;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectFormDetailActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LayoutInflater, ActivityCollectFormDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ActivityCollectFormDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/yd/android_brand_mvp/databinding/ActivityCollectFormDetailBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ActivityCollectFormDetailBinding invoke(LayoutInflater p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityCollectFormDetailBinding.inflate(p0);
        }
    }

    public static final /* synthetic */ ActivityCollectFormDetailBinding access$getBinding(CollectFormDetailActivity collectFormDetailActivity) {
        return collectFormDetailActivity.getBinding();
    }

    public CollectFormDetailActivity() {
        super(AnonymousClass1.INSTANCE);
        final CollectFormDetailActivity collectFormDetailActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CollectFormDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = collectFormDetailActivity.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = collectFormDetailActivity.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity$special$$inlined$viewModels$default$3
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
                CreationExtras defaultViewModelCreationExtras = collectFormDetailActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
        this.idPrefix = 4500;
        this.isAvailableNetWork = true;
        this.checkId = "";
    }

    /* JADX INFO: compiled from: CollectFormDetailActivity.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/CollectFormDetailActivity$Companion;", "", "()V", "startGo", "", "context", "Landroid/content/Context;", "checkId", "", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/CollectListBean;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startGo(Context context, String checkId, CollectListBean formItemData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(checkId, "checkId");
            Intrinsics.checkNotNullParameter(formItemData, "formItemData");
            Intent intent = new Intent(context, (Class<?>) CollectFormDetailActivity.class);
            intent.putExtra("id", checkId);
            intent.putExtra("formItem", formItemData);
            context.startActivity(intent);
        }

        public final void startGo(Context context, String checkId, CollectListBean formItemData, ActivityResultLauncher<Intent> launcher) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(checkId, "checkId");
            Intrinsics.checkNotNullParameter(formItemData, "formItemData");
            Intrinsics.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent(context, (Class<?>) CollectFormDetailActivity.class);
            intent.putExtra("id", checkId);
            intent.putExtra("formItem", formItemData);
            launcher.launch(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CollectFormDetailViewModel getViewModel() {
        return (CollectFormDetailViewModel) this.viewModel.getValue();
    }

    public final CollectListBean getFormListItem() {
        return this.formListItem;
    }

    public final void setFormListItem(CollectListBean collectListBean) {
        this.formListItem = collectListBean;
    }

    public final String getCheckId() {
        return this.checkId;
    }

    public final void setCheckId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.checkId = str;
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setInfo();
        setBackground();
        requestFormDetail();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseActivity
    protected void initView() {
        String stringExtra = getIntent().getStringExtra("id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.checkId = stringExtra;
        this.formListItem = (CollectListBean) getIntent().getParcelableExtra("formItem");
        TextView textView = getBinding().viewActivityCollectFormHead.tvViewCollectFormHeadTitle;
        CollectListBean collectListBean = this.formListItem;
        Intrinsics.checkNotNull(collectListBean);
        textView.setText(collectListBean.getTitle());
        TextView textView2 = getBinding().viewActivityCollectFormHead.tvViewCollectFormHeadTip;
        CollectListBean collectListBean2 = this.formListItem;
        Intrinsics.checkNotNull(collectListBean2);
        textView2.setText(collectListBean2.getDescription());
        getBinding().tvActivityCollectFormTopTitle.setText("填写");
        getBinding().ivActivityCollectFormTopReturn.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.-$$Lambda$CollectFormDetailActivity$FJorzceIirBWPYxkBFFRmeasBzk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectFormDetailActivity.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().ivActivityCollectFormBottomReturn.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.-$$Lambda$CollectFormDetailActivity$X-A-hfw538Zt0HR6qLy8B0H766c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectFormDetailActivity.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().btnActivityCollectFormDetail.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.-$$Lambda$CollectFormDetailActivity$ogi8e7z88ovBihIE6_G0zuPJ9yk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectFormDetailActivity.initView$lambda$2(this.f$0, view);
            }
        });
        LiveData<Result<FormDetailBean>> formDetail = getViewModel().getFormDetail();
        CollectFormDetailActivity collectFormDetailActivity = this;
        final Function1<Result<? extends FormDetailBean>, Unit> function1 = new Function1<Result<? extends FormDetailBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends FormDetailBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends FormDetailBean> it2) {
                CollectFormDetailActivity.this.hideLoading();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                FormDetailBean formDetailBean = (FormDetailBean) value;
                if (formDetailBean != null) {
                    CollectFormDetailActivity.this.getViewModel().setComponentData(formDetailBean.getComponents());
                } else {
                    CollectFormDetailActivity.this.finish();
                }
            }
        };
        formDetail.observe(collectFormDetailActivity, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.-$$Lambda$CollectFormDetailActivity$xpRIVmqBfCUilgWrFJoWGzzQWQk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CollectFormDetailActivity.initView$lambda$3(function1, obj);
            }
        });
        LiveData<Result<Boolean>> submitResult = getViewModel().getSubmitResult();
        final Function1<Result<? extends Boolean>, Unit> function2 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Boolean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends Boolean> it2) {
                CollectFormDetailActivity.this.hideLoading();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                ToastUtil.showBottomView((Activity) CollectFormDetailActivity.this, "提交成功");
                MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_COLLECT);
                CollectFormDetailActivity collectFormDetailActivity2 = CollectFormDetailActivity.this;
                Intent intent = new Intent();
                intent.putExtra(ResultCodeStr.NORMAL_TYPE_CODE, ResultCodeStr.COLLECT_UPDATE);
                Unit unit = Unit.INSTANCE;
                collectFormDetailActivity2.setResult(-1, intent);
                CollectFormDetailActivity.this.finish();
            }
        };
        submitResult.observe(collectFormDetailActivity, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.-$$Lambda$CollectFormDetailActivity$cvRZC3ZA2FQY9Ksr83dK4CiVxbE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CollectFormDetailActivity.initView$lambda$4(function2, obj);
            }
        });
        LiveData<List<FormBaseBean>> componentList = getViewModel().getComponentList();
        final Function1<List<? extends FormBaseBean>, Unit> function3 = new Function1<List<? extends FormBaseBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity.initView.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends FormBaseBean> list) {
                invoke2((List<FormBaseBean>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<FormBaseBean> list) {
                CollectFormDetailActivity.this.parserModuleViewList();
            }
        };
        componentList.observe(collectFormDetailActivity, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.-$$Lambda$CollectFormDetailActivity$iup4h_RCzAM4o1mTGGIRAg6OPd4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CollectFormDetailActivity.initView$lambda$5(function3, obj);
            }
        });
        MutableLiveData<UpdateFormStatus> updateSort = getViewModel().getUpdateSort();
        final Function1<UpdateFormStatus, Unit> function4 = new Function1<UpdateFormStatus, Unit>() { // from class: com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity.initView.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UpdateFormStatus updateFormStatus) {
                invoke2(updateFormStatus);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateFormStatus updateFormStatus) {
                if (updateFormStatus.getSortInt() < CollectFormDetailActivity.this.getViewModel().getComponentFrameView().size()) {
                    FrameLayout frameLayout = CollectFormDetailActivity.this.getViewModel().getComponentFrameView().get(updateFormStatus.getSortInt());
                    if (updateFormStatus.isGone()) {
                        SimpleUtilsKt.remove(frameLayout);
                    } else {
                        SimpleUtilsKt.show(frameLayout);
                    }
                }
            }
        };
        updateSort.observe(collectFormDetailActivity, new Observer() { // from class: com.yd.android_brand_mvp.activity.collect.-$$Lambda$CollectFormDetailActivity$8cpv1Dl9eyFmELVym89woVrl8bs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CollectFormDetailActivity.initView$lambda$6(function4, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(CollectFormDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(CollectFormDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(CollectFormDetailActivity this$0, View view) {
        FormVerifyBean formVerifyBean;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.formListItem == null) {
            return;
        }
        this$0.loading();
        boolean z = true;
        for (Fragment fragment : this$0.getViewModel().getComponentFragmentList()) {
            BaseCollectFragment baseCollectFragment = fragment instanceof BaseCollectFragment ? (BaseCollectFragment) fragment : null;
            if (baseCollectFragment == null || (formVerifyBean = baseCollectFragment.readySubmit()) == null) {
                formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
            }
            if (!formVerifyBean.getStatus()) {
                z = false;
                ToastUtil.showBottomView((Activity) this$0, formVerifyBean.getErrorMessage());
                break;
            } else {
                FormBaseBean componentData = this$0.getViewModel().getComponentData(formVerifyBean.getSort());
                if (componentData != null) {
                    componentData.setValue(formVerifyBean.getDataValue());
                }
            }
        }
        if (z) {
            CollectFormDetailViewModel viewModel = this$0.getViewModel();
            CollectListBean collectListBean = this$0.formListItem;
            Intrinsics.checkNotNull(collectListBean);
            viewModel.submitFormContent(collectListBean.getId(), this$0.checkId);
            return;
        }
        this$0.hideLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, com.yd.android_brand_mvp.observer.NetWorkStaus
    public void getWork(boolean islive) {
        this.isAvailableNetWork = islive;
        if (islive) {
            if (Intrinsics.areEqual(Tool.getNetworkAvailableTypeName(this).getTypeName(), "Ethernet")) {
                getBinding().topActivityCollectForm.wifi.setImageResource(R.drawable.network_intneter);
                return;
            }
            int iObtainWifiInfo = Tool.obtainWifiInfo(this);
            if (iObtainWifiInfo == 0) {
                getBinding().topActivityCollectForm.wifi.setImageResource(R.drawable.wifi1);
                return;
            }
            if (iObtainWifiInfo == 1) {
                getBinding().topActivityCollectForm.wifi.setImageResource(R.drawable.wifi1);
                return;
            }
            if (iObtainWifiInfo == 2) {
                getBinding().topActivityCollectForm.wifi.setImageResource(R.drawable.wifi2);
                return;
            }
            if (iObtainWifiInfo == 3) {
                getBinding().topActivityCollectForm.wifi.setImageResource(R.drawable.wifi3);
                return;
            } else if (iObtainWifiInfo == 4) {
                getBinding().topActivityCollectForm.wifi.setImageResource(R.drawable.wifi4);
                return;
            } else {
                if (iObtainWifiInfo != 5) {
                    return;
                }
                getBinding().topActivityCollectForm.wifi.setImageResource(R.drawable.wifi4);
                return;
            }
        }
        getBinding().topActivityCollectForm.wifi.setImageResource(R.drawable.wifi_false);
    }

    private final void setInfo() {
        getBinding().topActivityCollectForm.tvText.setText("");
        if (SpData.getSchoolInfo2() != null) {
            getBinding().topActivityCollectForm.officename.setText(SpData.getSchoolInfo2().data.schoolName);
            getBinding().topActivityCollectForm.tvText.setText(SpData.getSchoolInfo2().data.englishName);
            getBinding().topActivityCollectForm.tvText.setVisibility(!TextUtils.isEmpty(SpData.getSchoolInfo2().data.englishName) ? 0 : 8);
            if (!ScreenUtils.isLandscape()) {
                TextView textView = getBinding().topActivityCollectForm.tvText;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.topActivityCollectForm.tvText");
                SimpleUtilsKt.remove(textView);
            }
            GlideUtil.loadCircleImage(this, SpData.getSchoolInfo2().data.schoolLogo, getBinding().topActivityCollectForm.logo);
        }
        NewWeatherBean newWeatherBean = (NewWeatherBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.WEATHER_NEW, NewWeatherBean.class);
        if (newWeatherBean != null) {
            getBinding().topActivityCollectForm.weathericon.setImageDrawable(SimpleUtilsKt.asDrawable(WeatherUtils.imgCode(newWeatherBean.getWeather())));
            getBinding().topActivityCollectForm.weathertext.setText(newWeatherBean.getWeather());
            getBinding().topActivityCollectForm.wd.setText(newWeatherBean.getReal());
        }
    }

    private final void setBackground() {
        String str;
        if (SPUtils.getInstance().getBoolean(SpData.SKIN)) {
            getBinding().clActivityCollectFormDetail.setBackgroundResource(R.drawable.bp_bg);
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
            Glide.with((FragmentActivity) this).load(str2).into(new CustomTarget<Drawable>() { // from class: com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity.setBackground.1
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
                }

                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    CollectFormDetailActivity.access$getBinding(CollectFormDetailActivity.this).clActivityCollectFormDetail.setBackground(resource);
                }
            });
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            getBinding().clActivityCollectFormDetail.setBackgroundColor(Color.parseColor(str));
        }
    }

    private final void requestFormDetail() {
        if (this.formListItem == null) {
            return;
        }
        loading();
        CollectFormDetailViewModel viewModel = getViewModel();
        CollectListBean collectListBean = this.formListItem;
        Intrinsics.checkNotNull(collectListBean);
        viewModel.getFormDetail(collectListBean.getId(), this.checkId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void parserModuleViewList() {
        getViewModel().getComponentFrameView().clear();
        getViewModel().getComponentFragmentList().clear();
        if (!getViewModel().getComponentData().isEmpty()) {
            ArrayList arrayList = new ArrayList();
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "supportFragmentManager.beginTransaction()");
            int i = 0;
            for (Object obj : getViewModel().getComponentData()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FormBaseBean formBaseBean = (FormBaseBean) obj;
                formBaseBean.setSort(i);
                formBaseBean.setSortNum(i2);
                Fragment componentFragment$default = FormComponentUtil.getComponentFragment$default(FormComponentUtil.INSTANCE, formBaseBean, null, 2, null);
                if (componentFragment$default != null) {
                    FrameLayout frameLayout = new FrameLayout(this);
                    frameLayout.setId(this.idPrefix + i);
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                    fragmentTransactionBeginTransaction.replace(frameLayout.getId(), componentFragment$default);
                    if (formBaseBean.getProps().getShowRule() != 0) {
                        if (getViewIsNeedGone(formBaseBean.getProps().getShowExpression())) {
                            frameLayout.setVisibility(8);
                        }
                        arrayList.add(formBaseBean);
                    }
                    getViewModel().getComponentFrameView().add(frameLayout);
                    getBinding().llActivityCollectFormDetailContainer.addView(frameLayout);
                    getViewModel().getComponentFragmentList().add(componentFragment$default);
                }
                i = i2;
            }
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
            getViewModel().setRuleComponentData(arrayList);
        }
    }

    private final boolean getViewIsNeedGone(Map<String, ? extends List<String>> showExpression) {
        boolean z;
        int i;
        int i2;
        if (!showExpression.isEmpty()) {
            Set<String> setKeySet = showExpression.keySet();
            Iterator<String> it2 = setKeySet.iterator();
            while (true) {
                if (!it2.hasNext() || (i2 = Integer.parseInt(it2.next()) - 1) >= getViewModel().getComponentData().size()) {
                    z = false;
                    break;
                }
                String value = getViewModel().getComponentData().get(i2).getValue();
                if (!(value == null || value.length() == 0)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                for (String str : setKeySet) {
                    int i3 = Integer.parseInt(str);
                    List list = (List) MapsKt.getValue(showExpression, str);
                    if (!list.isEmpty() && (i = i3 - 1) < getViewModel().getComponentData().size()) {
                        FormBaseBean formBaseBean = getViewModel().getComponentData().get(i);
                        String value2 = formBaseBean.getValue();
                        String str2 = value2;
                        if (str2 == null || str2.length() == 0) {
                            continue;
                        } else {
                            ArrayList arrayList = new ArrayList();
                            if (Intrinsics.areEqual(formBaseBean.getName(), FormComponentUtil.SingleSelect)) {
                                arrayList.add(value2);
                            } else if (Intrinsics.areEqual(formBaseBean.getName(), FormComponentUtil.MultipleSelect)) {
                                List valueList = (List) GsonUtils.fromJson(value2, new TypeToken<List<? extends String>>() { // from class: com.yd.android_brand_mvp.activity.collect.CollectFormDetailActivity$getViewIsNeedGone$valueList$1
                                }.getType());
                                Intrinsics.checkNotNullExpressionValue(valueList, "valueList");
                                arrayList.addAll(valueList);
                            }
                            if ((!arrayList.isEmpty()) && arrayList.containsAll(list)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
