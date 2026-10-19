package com.yd.android_brand_mvp.dialog.patrol;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.patrol.PatrolListActivity;
import com.yd.android_brand_mvp.adapter.VerifyUserPager;
import com.yd.android_brand_mvp.databinding.DialogVerifyUserBinding;
import com.yd.android_brand_mvp.model.VerifyEventBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.view.ListenerConstraint;
import com.yd.android_brand_mvp.view.OnInterceptTouchEventListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: PatrolVerifyDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u001a\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/patrol/PatrolVerifyDialog;", "Landroidx/fragment/app/DialogFragment;", "type", "", "(I)V", "binding", "Lcom/yd/android_brand_mvp/databinding/DialogVerifyUserBinding;", "mLastUpTime", "", "timerFlow", "Lkotlinx/coroutines/Job;", "getType", "()I", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onDestroyView", "onStart", "onViewCreated", "view", "parseVerifyData", "data", "Lcom/yd/android_brand_mvp/model/VerifyEventBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PatrolVerifyDialog extends DialogFragment {
    private DialogVerifyUserBinding binding;
    private long mLastUpTime;
    private Job timerFlow;
    private final int type;

    public PatrolVerifyDialog() {
        this(0, 1, null);
    }

    public PatrolVerifyDialog(int i) {
        this.type = i;
    }

    public /* synthetic */ PatrolVerifyDialog(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i);
    }

    public final int getType() {
        return this.type;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DialogVerifyUserBinding dialogVerifyUserBindingInflate = DialogVerifyUserBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(dialogVerifyUserBindingInflate, "inflate(inflater, container, false)");
        this.binding = dialogVerifyUserBindingInflate;
        if (dialogVerifyUserBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogVerifyUserBindingInflate = null;
        }
        ListenerConstraint root = dialogVerifyUserBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        ((ListenerConstraint) view).setMOnInterceptTouchEventListener(new OnInterceptTouchEventListener() { // from class: com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog.onViewCreated.1
            @Override // com.yd.android_brand_mvp.view.OnInterceptTouchEventListener
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                Integer numValueOf = ev != null ? Integer.valueOf(ev.getAction()) : null;
                if (numValueOf == null || numValueOf.intValue() != 1) {
                    return false;
                }
                PatrolVerifyDialog.this.mLastUpTime = System.currentTimeMillis();
                return false;
            }
        });
        initView();
        this.mLastUpTime = System.currentTimeMillis();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        this.timerFlow = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass2(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: PatrolVerifyDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog$onViewCreated$2", f = "PatrolVerifyDialog.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PatrolVerifyDialog.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog$onViewCreated$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: PatrolVerifyDialog.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog$onViewCreated$2$1", f = "PatrolVerifyDialog.kt", i = {0, 1}, l = {83, 84}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:14:0x003b  */
            /* JADX WARN: Code duplicated, block: B:16:0x004a A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:19:0x005a A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0058 -> B:12:0x0031). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:16:0x004a
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L29
                    if (r1 == r3) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r7.L$0
                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                    kotlin.ResultKt.throwOnFailure(r8)
                    r8 = r1
                    goto L30
                L17:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1f:
                    java.lang.Object r1 = r7.L$0
                    kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                    kotlin.ResultKt.throwOnFailure(r8)
                    r8 = r1
                    r1 = r7
                    goto L4b
                L29:
                    kotlin.ResultKt.throwOnFailure(r8)
                    java.lang.Object r8 = r7.L$0
                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                L30:
                    r1 = r7
                L31:
                    kotlin.coroutines.CoroutineContext r4 = r1.get$context()
                    boolean r4 = kotlinx.coroutines.JobKt.isActive(r4)
                    if (r4 == 0) goto L5b
                    r4 = r1
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r1.L$0 = r8
                    r1.label = r3
                    java.lang.String r5 = "1"
                    java.lang.Object r4 = r8.emit(r5, r4)
                    if (r4 != r0) goto L4b
                    return r0
                L4b:
                    r4 = 1000(0x3e8, double:4.94E-321)
                    r6 = r1
                    kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                    r1.L$0 = r8
                    r1.label = r2
                    java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r6)
                    if (r4 != r0) goto L31
                    return r0
                L5b:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowM2121catch = FlowKt.m2121catch(FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(null)), Dispatchers.getIO()), new C01702(PatrolVerifyDialog.this, null));
                final PatrolVerifyDialog patrolVerifyDialog = PatrolVerifyDialog.this;
                this.label = 1;
                if (flowM2121catch.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog.onViewCreated.2.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        if (System.currentTimeMillis() - patrolVerifyDialog.mLastUpTime > 120000) {
                            patrolVerifyDialog.dismiss();
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog$onViewCreated$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: PatrolVerifyDialog.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog$onViewCreated$2$2", f = "PatrolVerifyDialog.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
        static final class C01702 extends SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PatrolVerifyDialog this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01702(PatrolVerifyDialog patrolVerifyDialog, Continuation<? super C01702> continuation) {
                super(3, continuation);
                this.this$0 = patrolVerifyDialog;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return new C01702(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job job = this.this$0.timerFlow;
                    if (job != null) {
                        this.label = 1;
                        if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        Dialog dialog2 = getDialog();
        Window window = dialog2 != null ? dialog2.getWindow() : null;
        if (window != null) {
            window.setBackgroundDrawable(SimpleUtilsKt.asDrawable(R.drawable.bg_white20));
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "it.attributes");
            attributes.width = SizeUtils.dp2px(680.0f);
            attributes.height = SizeUtils.dp2px(640.0f);
            window.setAttributes(attributes);
        }
    }

    private final void initView() {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("card", "刷卡");
        linkedHashMap.put("face", "人脸");
        linkedHashMap.put("qrCode", "二维码");
        final VerifyUserPager verifyUserPager = new VerifyUserPager(this, CollectionsKt.toList(linkedHashMap.keySet()), "patrol");
        DialogVerifyUserBinding dialogVerifyUserBinding = this.binding;
        DialogVerifyUserBinding dialogVerifyUserBinding2 = null;
        if (dialogVerifyUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogVerifyUserBinding = null;
        }
        dialogVerifyUserBinding.vpDialogVerifyUser.setAdapter(verifyUserPager);
        DialogVerifyUserBinding dialogVerifyUserBinding3 = this.binding;
        if (dialogVerifyUserBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogVerifyUserBinding3 = null;
        }
        TabLayout tabLayout = dialogVerifyUserBinding3.tlDialogVerifyUser;
        DialogVerifyUserBinding dialogVerifyUserBinding4 = this.binding;
        if (dialogVerifyUserBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogVerifyUserBinding4 = null;
        }
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, dialogVerifyUserBinding4.vpDialogVerifyUser, true, false, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.yd.android_brand_mvp.dialog.patrol.-$$Lambda$PatrolVerifyDialog$h848yaoxz0PZHv5PtWirlfk3mpM
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                PatrolVerifyDialog.initView$lambda$1(linkedHashMap, verifyUserPager, tab, i);
            }
        });
        DialogVerifyUserBinding dialogVerifyUserBinding5 = this.binding;
        if (dialogVerifyUserBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogVerifyUserBinding2 = dialogVerifyUserBinding5;
        }
        dialogVerifyUserBinding2.vpDialogVerifyUser.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog.initView.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                Window window;
                Window window2;
                super.onPageSelected(position);
                if (Intrinsics.areEqual(verifyUserPager.getDataList().get(position), "face")) {
                    Dialog dialog = this.getDialog();
                    if (dialog == null || (window2 = dialog.getWindow()) == null) {
                        return;
                    }
                    window2.setDimAmount(0.0f);
                    return;
                }
                Dialog dialog2 = this.getDialog();
                if (dialog2 == null || (window = dialog2.getWindow()) == null) {
                    return;
                }
                window.setDimAmount(0.5f);
            }
        });
        tabLayoutMediator.attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Map dataList, VerifyUserPager pagerAdapter, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        Intrinsics.checkNotNullParameter(pagerAdapter, "$pagerAdapter");
        Intrinsics.checkNotNullParameter(tab, "tab");
        String str = (String) dataList.get(pagerAdapter.getDataList().get(i));
        if (str == null) {
            str = "未知";
        }
        tab.setText(str);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void parseVerifyData(VerifyEventBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data.getId().length() > 0) || data.isStudent()) {
            return;
        }
        dismiss();
        PatrolListActivity.Companion companion = PatrolListActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, data.getId(), data.getUserName(), this.type);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C03831(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog$onDestroyView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PatrolVerifyDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog$onDestroyView$1", f = "PatrolVerifyDialog.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
    static final class C03831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03831(Continuation<? super C03831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PatrolVerifyDialog.this.new C03831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = PatrolVerifyDialog.this.timerFlow;
                if (job != null) {
                    this.label = 1;
                    if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PatrolVerifyDialog.this.timerFlow = null;
            return Unit.INSTANCE;
        }
    }
}
