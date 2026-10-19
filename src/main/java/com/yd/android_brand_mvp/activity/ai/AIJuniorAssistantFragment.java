package com.yd.android_brand_mvp.activity.ai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.heytap.mcssdk.a.a;
import com.tencent.qcloud.tim.uikit.utils.SoftKeyBoardUtil;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentAiJuniorAssistantListBinding;
import com.yd.android_brand_mvp.dialog.NewSelectPopUp;
import com.yd.android_brand_mvp.landscape.ai.AIFragmentViewModel;
import com.yd.android_brand_mvp.model.SelectPopBean;
import com.yd.android_brand_mvp.model.ai.AIChatMessageBean;
import com.yd.android_brand_mvp.model.ai.AICreateSessionBean;
import com.yd.android_brand_mvp.model.ai.AIIntellectHomeBean;
import com.yd.android_brand_mvp.model.ai.AIModelBean;
import com.yd.android_brand_mvp.model.ai.AIProblemBean;
import com.yd.android_brand_mvp.model.ai.Properties;
import com.yd.android_brand_mvp.network.base.SSEClient;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import defpackage.AIEventBean;
import io.noties.markwon.Markwon;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AIJuniorAssistantFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00019B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\u0012\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\"H\u0016J\u001a\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\"H\u0002J\u0014\u0010.\u001a\u00020\"2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\nH\u0002J \u00103\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020\"2\u0006\u00107\u001a\u000208H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006:"}, d2 = {"Lcom/yd/android_brand_mvp/activity/ai/AIJuniorAssistantFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentAiJuniorAssistantListBinding;", "Landroid/view/View$OnClickListener;", "()V", "alItem", "Lcom/yd/android_brand_mvp/model/ai/AIChatMessageBean;", "chatAdapter", "Lcom/yd/android_brand_mvp/activity/ai/AIChatMessageAdapter;", "checkType", "", "dataSelect", "", "Lcom/yd/android_brand_mvp/model/SelectPopBean;", "id", "isBottom", "", "isWriting", "markwon", "Lio/noties/markwon/Markwon;", "problemAdapter", "Lcom/yd/android_brand_mvp/activity/ai/AIProblemAdapter;", "selectBean", "sessionData", "Lcom/yd/android_brand_mvp/model/ai/AICreateSessionBean;", "studentPopUp", "Lcom/yd/android_brand_mvp/dialog/NewSelectPopUp;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/ai/AIFragmentViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/ai/AIFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initModel", "", "initRecyclerView", "initView", "onClick", "v", "Landroid/view/View;", "onDestroyView", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "scrollToBottom", "sendChat", "text", "", "setCheckView", "type", "setItemData", "messageContent", a.j, "setModelTypeView", "data", "Lcom/yd/android_brand_mvp/model/ai/AIModelBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AIJuniorAssistantFragment extends KTBaseFragment<FragmentAiJuniorAssistantListBinding> implements View.OnClickListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AIChatMessageBean alItem;
    private final AIChatMessageAdapter chatAdapter;
    private int checkType;
    private final List<SelectPopBean> dataSelect;
    private int id;
    private boolean isBottom;
    private boolean isWriting;
    private final Markwon markwon;
    private final AIProblemAdapter problemAdapter;
    private SelectPopBean selectBean;
    private AICreateSessionBean sessionData;
    private NewSelectPopUp studentPopUp;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: AIJuniorAssistantFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentAiJuniorAssistantListBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentAiJuniorAssistantListBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentAiJuniorAssistantListBinding;", 0);
        }

        public final FragmentAiJuniorAssistantListBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentAiJuniorAssistantListBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentAiJuniorAssistantListBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public AIJuniorAssistantFragment() {
        super(AnonymousClass1.INSTANCE);
        final AIJuniorAssistantFragment aIJuniorAssistantFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return aIJuniorAssistantFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(aIJuniorAssistantFragment, Reflection.getOrCreateKotlinClass(AIFragmentViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = aIJuniorAssistantFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.dataSelect = new ArrayList();
        Markwon markwonBuild = Markwon.builder(Utils.getApp()).build();
        Intrinsics.checkNotNullExpressionValue(markwonBuild, "builder(Utils.getApp()).build()");
        this.markwon = markwonBuild;
        this.chatAdapter = new AIChatMessageAdapter(this.markwon);
        this.problemAdapter = new AIProblemAdapter();
        this.id = 1;
        this.checkType = 1;
    }

    public static final /* synthetic */ FragmentAiJuniorAssistantListBinding access$getBinding(AIJuniorAssistantFragment aIJuniorAssistantFragment) {
        return aIJuniorAssistantFragment.getBinding();
    }

    /* JADX INFO: compiled from: AIJuniorAssistantFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/activity/ai/AIJuniorAssistantFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/ai/AIJuniorAssistantFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AIJuniorAssistantFragment newInstance() {
            return new AIJuniorAssistantFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIFragmentViewModel getViewModel() {
        return (AIFragmentViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initModel();
    }

    private final void initView() {
        AIJuniorAssistantFragment aIJuniorAssistantFragment = this;
        getBinding().ctSendSearch.setOnClickListener(aIJuniorAssistantFragment);
        getBinding().ctDeepThinking.setOnClickListener(aIJuniorAssistantFragment);
        getBinding().ctInternetSearch.setOnClickListener(aIJuniorAssistantFragment);
        getBinding().tvSelectMode.setOnClickListener(aIJuniorAssistantFragment);
        CheckedTextView checkedTextView = getBinding().ctDeepThinking;
        Intrinsics.checkNotNullExpressionValue(checkedTextView, "binding.ctDeepThinking");
        SimpleUtilsKt.remove(checkedTextView);
        getBinding().etInput.addTextChangedListener(new TextWatcher() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment.initView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string = StringsKt.trim((CharSequence) AIJuniorAssistantFragment.access$getBinding(AIJuniorAssistantFragment.this).etInput.getText().toString()).toString();
                if (AIJuniorAssistantFragment.this.isWriting) {
                    return;
                }
                String str = string;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                AIJuniorAssistantFragment.access$getBinding(AIJuniorAssistantFragment.this).ctSendSearch.setClickable(!TextUtils.isEmpty(str));
                AIJuniorAssistantFragment.this.setCheckView(2);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        NewSelectPopUp newSelectPopUp = new NewSelectPopUp(contextRequireContext);
        this.studentPopUp = newSelectPopUp;
        Intrinsics.checkNotNull(newSelectPopUp);
        newSelectPopUp.setSubmitCallBack(new NewSelectPopUp.SubmitCallBack() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment.initView.2
            @Override // com.yd.android_brand_mvp.dialog.NewSelectPopUp.SubmitCallBack
            public void getSubmitData(SelectPopBean data) {
                Intrinsics.checkNotNullParameter(data, "data");
                AIJuniorAssistantFragment.access$getBinding(AIJuniorAssistantFragment.this).tvSelectMode.setText(data.getName());
                AIJuniorAssistantFragment.this.selectBean = data;
            }
        });
        TextView textView = getBinding().tvSelectMode;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvSelectMode");
        SimpleUtilsKt.remove(textView);
        initRecyclerView();
        setCheckView(1);
    }

    private final void initRecyclerView() {
        getBinding().rvChatMessages.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView.ItemAnimator itemAnimator = getBinding().rvChatMessages.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        getBinding().rvChatMessages.setAdapter(this.chatAdapter);
        getBinding().rvProblem.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvProblem.setAdapter(this.problemAdapter);
        getBinding().rvChatMessages.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment.initRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, dx, dy);
                if (!AIJuniorAssistantFragment.access$getBinding(AIJuniorAssistantFragment.this).rvChatMessages.canScrollVertically(1)) {
                    AIJuniorAssistantFragment.this.isBottom = true;
                } else {
                    AIJuniorAssistantFragment.this.isBottom = false;
                }
                AIJuniorAssistantFragment.access$getBinding(AIJuniorAssistantFragment.this).rvChatMessages.canScrollVertically(-1);
            }
        });
        this.problemAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIJuniorAssistantFragment$FznRT2i6K8eQKYl5lGCVwsu3cRI
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AIJuniorAssistantFragment.initRecyclerView$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
        this.chatAdapter.setOnItemScrollListener(new AIChatMessageAdapter.OnItemScrollListener() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment.initRecyclerView.3
            @Override // com.yd.android_brand_mvp.activity.ai.AIChatMessageAdapter.OnItemScrollListener
            public void onItemScroll() {
                AIJuniorAssistantFragment.this.scrollToBottom();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$0(AIJuniorAssistantFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.sendChat(this$0.problemAdapter.getItem(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollToBottom() {
        getBinding().rvChatMessages.post(new Runnable() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIJuniorAssistantFragment$3HHEqDKnwWM6c4_aa8h-fwnqIoE
            @Override // java.lang.Runnable
            public final void run() {
                AIJuniorAssistantFragment.scrollToBottom$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollToBottom$lambda$1(AIJuniorAssistantFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int itemCount = this$0.chatAdapter.getItemCount();
        if (itemCount <= 0 || !this$0.isBottom) {
            return;
        }
        this$0.getBinding().rvChatMessages.smoothScrollToPosition(itemCount);
    }

    private final void initModel() {
        String iconUrl;
        String id;
        String id2;
        Intent intent;
        Intent intent2;
        LiveData<Result<List<AIModelBean>>> aiModelLis = getViewModel().getAiModelLis();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<AIModelBean>>, Unit> function1 = new Function1<Result<? extends List<AIModelBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment.initModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<AIModelBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<AIModelBean>> it2) {
                StringBuilder sb = new StringBuilder();
                sb.append("AI 首页模型列表：");
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                sb.append(GsonUtils.toJson(value));
                Log.i("TAG", sb.toString());
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value2 = it2.getValue();
                    List<AIModelBean> list = (List) (Result.m597isFailureimpl(value2) ? null : value2);
                    if (list != null) {
                        AIJuniorAssistantFragment aIJuniorAssistantFragment = AIJuniorAssistantFragment.this;
                        AIModelBean aIModelBean = (AIModelBean) CollectionsKt.first(list);
                        TextView textView = AIJuniorAssistantFragment.access$getBinding(aIJuniorAssistantFragment).tvSelectMode;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvSelectMode");
                        SimpleUtilsKt.show(textView);
                        aIJuniorAssistantFragment.setModelTypeView(aIModelBean);
                        aIJuniorAssistantFragment.selectBean = new SelectPopBean(aIModelBean.getId(), aIModelBean.getName());
                        for (AIModelBean aIModelBean2 : list) {
                            aIJuniorAssistantFragment.dataSelect.add(new SelectPopBean(aIModelBean2.getId(), aIModelBean2.getName()));
                        }
                        return;
                    }
                    return;
                }
                Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                ToastUtils.showShort(thM594exceptionOrNullimpl != null ? thM594exceptionOrNullimpl.getMessage() : null, new Object[0]);
            }
        };
        aiModelLis.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIJuniorAssistantFragment$a9YLkiAWnGA9Aw7zWFR_AJvrpDk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIJuniorAssistantFragment.initModel$lambda$2(function1, obj);
            }
        });
        LiveData<Result<AICreateSessionBean>> aiCreateSession = getViewModel().getAiCreateSession();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends AICreateSessionBean>, Unit> function2 = new Function1<Result<? extends AICreateSessionBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment.initModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends AICreateSessionBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends AICreateSessionBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    AIJuniorAssistantFragment aIJuniorAssistantFragment = AIJuniorAssistantFragment.this;
                    Object value = it2.getValue();
                    aIJuniorAssistantFragment.sessionData = (AICreateSessionBean) (Result.m597isFailureimpl(value) ? null : value);
                } else {
                    Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                    ToastUtils.showShort(thM594exceptionOrNullimpl != null ? thM594exceptionOrNullimpl.getMessage() : null, new Object[0]);
                }
            }
        };
        aiCreateSession.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIJuniorAssistantFragment$4S8JUJUyDo91yEC5ozTtu1_2WyA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIJuniorAssistantFragment.initModel$lambda$3(function2, obj);
            }
        });
        LiveData<Result<AIProblemBean>> aiProblem = getViewModel().getAiProblem();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Result<? extends AIProblemBean>, Unit> function3 = new Function1<Result<? extends AIProblemBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment.initModel.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends AIProblemBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends AIProblemBean> it2) {
                String welcomeMessage;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    AIProblemBean aIProblemBean = (AIProblemBean) value;
                    if (aIProblemBean != null) {
                        AIJuniorAssistantFragment aIJuniorAssistantFragment = AIJuniorAssistantFragment.this;
                        TextView textView = AIJuniorAssistantFragment.access$getBinding(aIJuniorAssistantFragment).tvDescription;
                        Properties properties = aIProblemBean.getProperties();
                        if (properties == null || (welcomeMessage = properties.getWelcomeMessage()) == null) {
                            welcomeMessage = "";
                        }
                        textView.setText(welcomeMessage);
                        AIJuniorAssistantFragment.access$getBinding(aIJuniorAssistantFragment).textview.setText(aIProblemBean.getName());
                        AIJuniorAssistantFragment.access$getBinding(aIJuniorAssistantFragment).etInput.setHint("问问" + aIProblemBean.getName());
                        AIProblemAdapter aIProblemAdapter = aIJuniorAssistantFragment.problemAdapter;
                        AIFragmentViewModel viewModel = aIJuniorAssistantFragment.getViewModel();
                        Properties properties2 = aIProblemBean.getProperties();
                        aIProblemAdapter.setList(viewModel.getRandomPrompts(properties2 != null ? properties2.getSamplePrompts() : null));
                        return;
                    }
                    return;
                }
                Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                ToastUtils.showShort(thM594exceptionOrNullimpl != null ? thM594exceptionOrNullimpl.getMessage() : null, new Object[0]);
            }
        };
        aiProblem.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIJuniorAssistantFragment$eDvup2J3hLo8bjo4kRGvhoN5kvI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AIJuniorAssistantFragment.initModel$lambda$4(function3, obj);
            }
        });
        FragmentActivity activity = getActivity();
        if (Intrinsics.areEqual((Object) ((activity == null || (intent2 = activity.getIntent()) == null) ? null : Boolean.valueOf(intent2.getBooleanExtra("isNotDefault", false))), (Object) true)) {
            CheckedTextView checkedTextView = getBinding().ctInternetSearch;
            Intrinsics.checkNotNullExpressionValue(checkedTextView, "binding.ctInternetSearch");
            SimpleUtilsKt.remove(checkedTextView);
            CheckedTextView checkedTextView2 = getBinding().ctDeepThinking;
            Intrinsics.checkNotNullExpressionValue(checkedTextView2, "binding.ctDeepThinking");
            SimpleUtilsKt.remove(checkedTextView2);
            TextView textView = getBinding().tvSelectMode;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvSelectMode");
            SimpleUtilsKt.remove(textView);
            FragmentActivity activity2 = getActivity();
            AIIntellectHomeBean aIIntellectHomeBean = (activity2 == null || (intent = activity2.getIntent()) == null) ? null : (AIIntellectHomeBean) intent.getParcelableExtra("data");
            EditText editText = getBinding().etInput;
            StringBuilder sb = new StringBuilder();
            sb.append("问问");
            sb.append(aIIntellectHomeBean != null ? aIIntellectHomeBean.getName() : null);
            editText.setHint(sb.toString());
            Context contextRequireContext = requireContext();
            if (aIIntellectHomeBean == null || (iconUrl = aIIntellectHomeBean.getIconUrl()) == null) {
                iconUrl = "";
            }
            GlideUtil.loadCircleImage(contextRequireContext, iconUrl, getBinding().ivIcon);
            AIFragmentViewModel viewModel = getViewModel();
            if (aIIntellectHomeBean == null || (id = aIIntellectHomeBean.getId()) == null) {
                id = "";
            }
            viewModel.getAIInfo(id);
            AIFragmentViewModel viewModel2 = getViewModel();
            if (aIIntellectHomeBean == null || (id2 = aIIntellectHomeBean.getId()) == null) {
                id2 = "";
            }
            viewModel2.createSession(id2, "");
            return;
        }
        getViewModel().getAIInfo("default");
        getViewModel().getAIModelList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initModel$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initModel$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setModelTypeView(AIModelBean data) {
        getBinding().tvSelectMode.setText(data.getName());
        Iterator<T> it2 = data.getCapabilities().iterator();
        while (it2.hasNext()) {
            if (Intrinsics.areEqual((String) it2.next(), "reasoning")) {
                CheckedTextView checkedTextView = getBinding().ctDeepThinking;
                Intrinsics.checkNotNullExpressionValue(checkedTextView, "binding.ctDeepThinking");
                SimpleUtilsKt.show(checkedTextView);
            }
        }
        getViewModel().createSession("default", data.getId());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int id = getBinding().ctSendSearch.getId();
        if (numValueOf != null && numValueOf.intValue() == id) {
            if (this.checkType == 3) {
                setCheckView(2);
                this.isWriting = false;
                SSEClient.INSTANCE.disconnect();
                AIChatMessageBean aIChatMessageBean = this.alItem;
                Intrinsics.checkNotNull(aIChatMessageBean);
                AIChatMessageBean aIChatMessageBean2 = this.alItem;
                Intrinsics.checkNotNull(aIChatMessageBean2);
                setItemData(aIChatMessageBean, aIChatMessageBean2.getContent(), -1);
                return;
            }
            sendChat$default(this, null, 1, null);
            return;
        }
        int id2 = getBinding().ctDeepThinking.getId();
        if (numValueOf != null && numValueOf.intValue() == id2) {
            getBinding().ctDeepThinking.setChecked(!getBinding().ctDeepThinking.isChecked());
            return;
        }
        int id3 = getBinding().ctInternetSearch.getId();
        if (numValueOf != null && numValueOf.intValue() == id3) {
            getBinding().ctInternetSearch.setChecked(!getBinding().ctInternetSearch.isChecked());
            return;
        }
        int id4 = getBinding().tvSelectMode.getId();
        if (numValueOf != null && numValueOf.intValue() == id4) {
            NewSelectPopUp newSelectPopUp = this.studentPopUp;
            if (newSelectPopUp != null) {
                newSelectPopUp.setData(this.dataSelect, this.selectBean);
            }
            NewSelectPopUp newSelectPopUp2 = this.studentPopUp;
            Intrinsics.checkNotNull(newSelectPopUp2);
            if (newSelectPopUp2.isShowing()) {
                NewSelectPopUp newSelectPopUp3 = this.studentPopUp;
                Intrinsics.checkNotNull(newSelectPopUp3);
                newSelectPopUp3.dismiss();
            } else {
                NewSelectPopUp newSelectPopUp4 = this.studentPopUp;
                Intrinsics.checkNotNull(newSelectPopUp4);
                newSelectPopUp4.showPopupWindow(getBinding().tvSelectMode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCheckView(final int type) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIJuniorAssistantFragment$v4Ls6unkDPD1_e00NfyHrF9ohWY
                @Override // java.lang.Runnable
                public final void run() {
                    AIJuniorAssistantFragment.setCheckView$lambda$6(this.f$0, type);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCheckView$lambda$6(AIJuniorAssistantFragment this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkType = i;
        if (i == 1) {
            this$0.getBinding().ctSendSearch.setBackgroundResource(R.drawable.icon_ai_search_default);
            this$0.getBinding().ctSendSearch.setClickable(false);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            this$0.getBinding().ctSendSearch.setBackgroundResource(R.drawable.icon_ai_search_stop);
            this$0.getBinding().ctSendSearch.setClickable(true);
            return;
        }
        if (!TextUtils.isEmpty(StringsKt.trim((CharSequence) this$0.getBinding().etInput.getText().toString()).toString())) {
            this$0.getBinding().ctSendSearch.setBackgroundResource(R.drawable.icon_ai_search_top_select);
            this$0.getBinding().ctSendSearch.setClickable(true);
        } else {
            this$0.getBinding().ctSendSearch.setBackgroundResource(R.drawable.icon_ai_search_default);
            this$0.getBinding().ctSendSearch.setClickable(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SSEClient.INSTANCE.disconnect();
        NewSelectPopUp newSelectPopUp = this.studentPopUp;
        if (newSelectPopUp != null) {
            newSelectPopUp.dismiss();
        }
        getBinding().rvChatMessages.setAdapter(null);
    }

    static /* synthetic */ void sendChat$default(AIJuniorAssistantFragment aIJuniorAssistantFragment, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        aIJuniorAssistantFragment.sendChat(str);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0102  */
    /* JADX WARN: Code duplicated, block: B:45:0x0147  */
    /* JADX WARN: Code duplicated, block: B:47:? A[RETURN, SYNTHETIC] */
    private final void sendChat(String text) {
        String str;
        String name;
        String str2;
        final Ref.ObjectRef objectRef;
        AICreateSessionBean aICreateSessionBean;
        String iconUrl;
        Intent intent;
        Intent intent2;
        SoftKeyBoardUtil.hideKeyBoard(getBinding().etInput);
        setCheckView(3);
        ConstraintLayout constraintLayout = getBinding().clInit;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clInit");
        SimpleUtilsKt.remove(constraintLayout);
        String string = text == null ? "" : text;
        if (TextUtils.isEmpty(text)) {
            string = StringsKt.trim((CharSequence) getBinding().etInput.getText().toString()).toString();
        }
        if (TextUtils.isEmpty(string)) {
            ToastUtils.showLong("请输入内容", new Object[0]);
            return;
        }
        FragmentActivity activity = getActivity();
        AIIntellectHomeBean aIIntellectHomeBean = null;
        Boolean boolValueOf = (activity == null || (intent2 = activity.getIntent()) == null) ? null : Boolean.valueOf(intent2.getBooleanExtra("isNotDefault", false));
        if (this.sessionData == null) {
            ToastUtils.showLong("会话创建失败，请重试", new Object[0]);
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            aIIntellectHomeBean = (AIIntellectHomeBean) intent.getParcelableExtra("data");
        }
        AIIntellectHomeBean aIIntellectHomeBean2 = aIIntellectHomeBean;
        AIChatMessageAdapter aIChatMessageAdapter = this.chatAdapter;
        int i = this.id;
        this.id = i + 1;
        String str3 = string;
        aIChatMessageAdapter.addData(new AIChatMessageBean(i, 0, "", "", string, true, false, 0, 0, 448, null));
        if (!Intrinsics.areEqual((Object) boolValueOf, (Object) false)) {
            if (aIIntellectHomeBean2 == null || (name = aIIntellectHomeBean2.getName()) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (isNotDefault == fals…ce) else data?.name ?: \"\"");
            int i2 = this.id;
            this.id = i2 + 1;
            if (aIIntellectHomeBean2 != null || (iconUrl = aIIntellectHomeBean2.getIconUrl()) == null) {
                str2 = "";
            } else {
                str2 = iconUrl;
            }
            AIChatMessageBean aIChatMessageBean = new AIChatMessageBean(i2, 0, str2, str, "", false, false, 0, 0, 448, null);
            this.alItem = aIChatMessageBean;
            AIChatMessageAdapter aIChatMessageAdapter2 = this.chatAdapter;
            Intrinsics.checkNotNull(aIChatMessageBean);
            aIChatMessageAdapter2.addData(aIChatMessageBean);
            getBinding().rvChatMessages.scrollToPosition(this.chatAdapter.getItemCount() - 1);
            objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            getBinding().etInput.setText("");
            this.isWriting = true;
            aICreateSessionBean = this.sessionData;
            if (aICreateSessionBean != null) {
                SSEClient.INSTANCE.connect(SSEClient.INSTANCE.getSEE_SESSION_URL(), aICreateSessionBean.getId(), str3, new SSEClient.SSEListener() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment$sendChat$1$1
                    /* JADX WARN: Type inference failed for: r2v13, types: [T, java.lang.String] */
                    @Override // com.yd.android_brand_mvp.network.base.SSEClient.SSEListener
                    public void onMessage(String message) {
                        if (message != null) {
                            Ref.ObjectRef<String> objectRef2 = objectRef;
                            AIJuniorAssistantFragment aIJuniorAssistantFragment = this;
                            AIEventBean aIEventBean = (AIEventBean) GsonUtils.fromJson(message, AIEventBean.class);
                            if (!TextUtils.isEmpty(aIEventBean.getText())) {
                                objectRef2.element += aIEventBean.getText();
                            }
                            if (!TextUtils.isEmpty(objectRef2.element)) {
                                AIChatMessageBean aIChatMessageBean2 = aIJuniorAssistantFragment.alItem;
                                Intrinsics.checkNotNull(aIChatMessageBean2);
                                aIJuniorAssistantFragment.setItemData(aIChatMessageBean2, objectRef2.element, 0);
                            }
                            if (Intrinsics.areEqual(aIEventBean.getEvent(), "all_done")) {
                                SSEClient.INSTANCE.disconnect();
                                aIJuniorAssistantFragment.isWriting = false;
                                aIJuniorAssistantFragment.setCheckView(2);
                                AIChatMessageBean aIChatMessageBean3 = aIJuniorAssistantFragment.alItem;
                                Intrinsics.checkNotNull(aIChatMessageBean3);
                                aIJuniorAssistantFragment.setItemData(aIChatMessageBean3, objectRef2.element, 1);
                                return;
                            }
                            if (Intrinsics.areEqual(aIEventBean.getEvent(), "error")) {
                                aIJuniorAssistantFragment.isWriting = false;
                                AIChatMessageBean aIChatMessageBean4 = aIJuniorAssistantFragment.alItem;
                                Intrinsics.checkNotNull(aIChatMessageBean4);
                                aIJuniorAssistantFragment.setItemData(aIChatMessageBean4, "服务连接超时，请重试", -1);
                                aIJuniorAssistantFragment.setCheckView(2);
                            }
                        }
                    }

                    @Override // com.yd.android_brand_mvp.network.base.SSEClient.SSEListener
                    public void onError(IOException e) {
                        Object[] objArr = new Object[1];
                        StringBuilder sb = new StringBuilder();
                        sb.append("SSEClient onError：");
                        sb.append(e != null ? e.getMessage() : null);
                        objArr[0] = sb.toString();
                        LogUtils.i(objArr);
                        this.isWriting = false;
                        this.setCheckView(2);
                        if (e instanceof SocketTimeoutException) {
                            AIJuniorAssistantFragment aIJuniorAssistantFragment = this;
                            AIChatMessageBean aIChatMessageBean2 = aIJuniorAssistantFragment.alItem;
                            Intrinsics.checkNotNull(aIChatMessageBean2);
                            aIJuniorAssistantFragment.setItemData(aIChatMessageBean2, "服务连接超时，请重试", -1);
                            return;
                        }
                        if (e instanceof ConnectException) {
                            AIJuniorAssistantFragment aIJuniorAssistantFragment2 = this;
                            AIChatMessageBean aIChatMessageBean3 = aIJuniorAssistantFragment2.alItem;
                            Intrinsics.checkNotNull(aIChatMessageBean3);
                            aIJuniorAssistantFragment2.setItemData(aIChatMessageBean3, "无法连接服务器，请检查网络", -1);
                            return;
                        }
                        AIJuniorAssistantFragment aIJuniorAssistantFragment3 = this;
                        AIChatMessageBean aIChatMessageBean4 = aIJuniorAssistantFragment3.alItem;
                        Intrinsics.checkNotNull(aIChatMessageBean4);
                        aIJuniorAssistantFragment3.setItemData(aIChatMessageBean4, "服务异常，请检查网络", -1);
                    }
                });
            }
        }
        name = getString(R.string.one_intelligence);
        str = name;
        Intrinsics.checkNotNullExpressionValue(str, "if (isNotDefault == fals…ce) else data?.name ?: \"\"");
        int i3 = this.id;
        this.id = i3 + 1;
        if (aIIntellectHomeBean2 != null) {
            str2 = "";
        } else {
            str2 = "";
        }
        AIChatMessageBean aIChatMessageBean2 = new AIChatMessageBean(i3, 0, str2, str, "", false, false, 0, 0, 448, null);
        this.alItem = aIChatMessageBean2;
        AIChatMessageAdapter aIChatMessageAdapter3 = this.chatAdapter;
        Intrinsics.checkNotNull(aIChatMessageBean2);
        aIChatMessageAdapter3.addData(aIChatMessageBean2);
        getBinding().rvChatMessages.scrollToPosition(this.chatAdapter.getItemCount() - 1);
        objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        getBinding().etInput.setText("");
        this.isWriting = true;
        aICreateSessionBean = this.sessionData;
        if (aICreateSessionBean != null) {
            SSEClient.INSTANCE.connect(SSEClient.INSTANCE.getSEE_SESSION_URL(), aICreateSessionBean.getId(), str3, new SSEClient.SSEListener() { // from class: com.yd.android_brand_mvp.activity.ai.AIJuniorAssistantFragment$sendChat$1$1
                /* JADX WARN: Type inference failed for: r2v13, types: [T, java.lang.String] */
                @Override // com.yd.android_brand_mvp.network.base.SSEClient.SSEListener
                public void onMessage(String message) {
                    if (message != null) {
                        Ref.ObjectRef<String> objectRef2 = objectRef;
                        AIJuniorAssistantFragment aIJuniorAssistantFragment = this;
                        AIEventBean aIEventBean = (AIEventBean) GsonUtils.fromJson(message, AIEventBean.class);
                        if (!TextUtils.isEmpty(aIEventBean.getText())) {
                            objectRef2.element += aIEventBean.getText();
                        }
                        if (!TextUtils.isEmpty(objectRef2.element)) {
                            AIChatMessageBean aIChatMessageBean3 = aIJuniorAssistantFragment.alItem;
                            Intrinsics.checkNotNull(aIChatMessageBean3);
                            aIJuniorAssistantFragment.setItemData(aIChatMessageBean3, objectRef2.element, 0);
                        }
                        if (Intrinsics.areEqual(aIEventBean.getEvent(), "all_done")) {
                            SSEClient.INSTANCE.disconnect();
                            aIJuniorAssistantFragment.isWriting = false;
                            aIJuniorAssistantFragment.setCheckView(2);
                            AIChatMessageBean aIChatMessageBean4 = aIJuniorAssistantFragment.alItem;
                            Intrinsics.checkNotNull(aIChatMessageBean4);
                            aIJuniorAssistantFragment.setItemData(aIChatMessageBean4, objectRef2.element, 1);
                            return;
                        }
                        if (Intrinsics.areEqual(aIEventBean.getEvent(), "error")) {
                            aIJuniorAssistantFragment.isWriting = false;
                            AIChatMessageBean aIChatMessageBean5 = aIJuniorAssistantFragment.alItem;
                            Intrinsics.checkNotNull(aIChatMessageBean5);
                            aIJuniorAssistantFragment.setItemData(aIChatMessageBean5, "服务连接超时，请重试", -1);
                            aIJuniorAssistantFragment.setCheckView(2);
                        }
                    }
                }

                @Override // com.yd.android_brand_mvp.network.base.SSEClient.SSEListener
                public void onError(IOException e) {
                    Object[] objArr = new Object[1];
                    StringBuilder sb = new StringBuilder();
                    sb.append("SSEClient onError：");
                    sb.append(e != null ? e.getMessage() : null);
                    objArr[0] = sb.toString();
                    LogUtils.i(objArr);
                    this.isWriting = false;
                    this.setCheckView(2);
                    if (e instanceof SocketTimeoutException) {
                        AIJuniorAssistantFragment aIJuniorAssistantFragment = this;
                        AIChatMessageBean aIChatMessageBean3 = aIJuniorAssistantFragment.alItem;
                        Intrinsics.checkNotNull(aIChatMessageBean3);
                        aIJuniorAssistantFragment.setItemData(aIChatMessageBean3, "服务连接超时，请重试", -1);
                        return;
                    }
                    if (e instanceof ConnectException) {
                        AIJuniorAssistantFragment aIJuniorAssistantFragment2 = this;
                        AIChatMessageBean aIChatMessageBean4 = aIJuniorAssistantFragment2.alItem;
                        Intrinsics.checkNotNull(aIChatMessageBean4);
                        aIJuniorAssistantFragment2.setItemData(aIChatMessageBean4, "无法连接服务器，请检查网络", -1);
                        return;
                    }
                    AIJuniorAssistantFragment aIJuniorAssistantFragment3 = this;
                    AIChatMessageBean aIChatMessageBean5 = aIJuniorAssistantFragment3.alItem;
                    Intrinsics.checkNotNull(aIChatMessageBean5);
                    aIJuniorAssistantFragment3.setItemData(aIChatMessageBean5, "服务异常，请检查网络", -1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setItemData(final AIChatMessageBean alItem, final String messageContent, final int code) {
        requireActivity().runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIJuniorAssistantFragment$6Jjrld9IRKWX1EHhksJOvaJ1gls
            @Override // java.lang.Runnable
            public final void run() {
                AIJuniorAssistantFragment.setItemData$lambda$8(this.f$0, alItem, messageContent, code);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setItemData$lambda$8(AIJuniorAssistantFragment this$0, AIChatMessageBean alItem, String messageContent, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(alItem, "$alItem");
        Intrinsics.checkNotNullParameter(messageContent, "$messageContent");
        int itemPosition = this$0.chatAdapter.getItemPosition(alItem);
        ((AIChatMessageBean) this$0.chatAdapter.getItem(itemPosition)).setContent(messageContent);
        alItem.setCode(i);
        this$0.chatAdapter.notifyItemChanged(itemPosition);
    }
}
