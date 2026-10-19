package com.yd.android_brand_mvp.activity.iotControl.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.VerifyTeacherLoginBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yyide.facepass.AppExtKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: DoorControlViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0014J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0011X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/iotControl/viewmodel/DoorControlViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "timeSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getTimeSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "timerFlow", "Lkotlinx/coroutines/Job;", "verifyTeacher", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/VerifyTeacherLoginBean;", "getVerifyTeacher", "()Landroidx/lifecycle/LiveData;", "verifyTeacherLiveData", "Landroidx/lifecycle/MutableLiveData;", "addOpenDoorRecodes", "", "personId", "type", "personType", "clearTimer", "onCleared", "setTimer", "second", "", "verifyTeacherLogin", "username", "password", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DoorControlViewModel extends ViewModel {
    private final MutableSharedFlow<String> timeSharedFlow;
    private Job timerFlow;
    private final LiveData<Result<VerifyTeacherLoginBean>> verifyTeacher;
    private final MutableLiveData<Result<VerifyTeacherLoginBean>> verifyTeacherLiveData;

    public DoorControlViewModel() {
        MutableLiveData<Result<VerifyTeacherLoginBean>> mutableLiveData = new MutableLiveData<>();
        this.verifyTeacherLiveData = mutableLiveData;
        this.verifyTeacher = mutableLiveData;
        this.timeSharedFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final LiveData<Result<VerifyTeacherLoginBean>> getVerifyTeacher() {
        return this.verifyTeacher;
    }

    public final MutableSharedFlow<String> getTimeSharedFlow() {
        return this.timeSharedFlow;
    }

    public final void setTimer(long second) {
        AppExtKt.logd(this, "setTimer");
        clearTimer();
        this.timerFlow = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03591(second, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$setTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DoorControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$setTimer$1", f = "DoorControlViewModel.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    static final class C03591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $second;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoorControlViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03591(long j, DoorControlViewModel doorControlViewModel, Continuation<? super C03591> continuation) {
            super(2, continuation);
            this.$second = j;
            this.this$0 = doorControlViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03591 c03591 = new C03591(this.$second, this.this$0, continuation);
            c03591.L$0 = obj;
            return c03591;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$setTimer$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DoorControlViewModel.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$setTimer$1$1", f = "DoorControlViewModel.kt", i = {0}, l = {36, 37}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
        static final class C01681 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $second;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01681(long j, Continuation<? super C01681> continuation) {
                super(2, continuation);
                this.$second = j;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01681 c01681 = new C01681(this.$second, continuation);
                c01681.L$0 = obj;
                return c01681;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
                return ((C01681) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                FlowCollector flowCollector;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    flowCollector = (FlowCollector) this.L$0;
                    this.L$0 = flowCollector;
                    this.label = 1;
                    if (DelayKt.delay(this.$second * ((long) 1000), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i == 1) {
                        flowCollector = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                this.L$0 = null;
                this.label = 2;
                if (flowCollector.emit("1", this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Flow flowM2121catch = FlowKt.m2121catch(FlowKt.flowOn(FlowKt.flow(new C01681(this.$second, null)), Dispatchers.getIO()), new AnonymousClass2(this.this$0, null));
                final DoorControlViewModel doorControlViewModel = this.this$0;
                this.label = 1;
                if (flowM2121catch.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel.setTimer.1.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        AppExtKt.logd(coroutineScope, "send Flow Data");
                        Object objEmit = doorControlViewModel.getTimeSharedFlow().emit(str, continuation);
                        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
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

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$setTimer$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DoorControlViewModel.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$setTimer$1$2", f = "DoorControlViewModel.kt", i = {0}, l = {39}, m = "invokeSuspend", n = {"$this$catch"}, s = {"L$0"})
        static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DoorControlViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DoorControlViewModel doorControlViewModel, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.this$0 = doorControlViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = flowCollector;
                return anonymousClass2.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                FlowCollector flowCollector;
                FlowCollector flowCollector2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    flowCollector = (FlowCollector) this.L$0;
                    Job job = this.this$0.timerFlow;
                    if (job != null) {
                        this.L$0 = flowCollector;
                        this.label = 1;
                        if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector2 = flowCollector;
                    }
                    AppExtKt.logd(flowCollector, "倒计时出错");
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector2;
                AppExtKt.logd(flowCollector, "倒计时出错");
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$clearTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DoorControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$clearTimer$1", f = "DoorControlViewModel.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    static final class C03581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03581(Continuation<? super C03581> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DoorControlViewModel.this.new C03581(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (DoorControlViewModel.this.timerFlow != null) {
                    Job job = DoorControlViewModel.this.timerFlow;
                    if (job != null) {
                        this.label = 1;
                        if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DoorControlViewModel.this.timerFlow = null;
            return Unit.INSTANCE;
        }
    }

    private final void clearTimer() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03581(null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        clearTimer();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$addOpenDoorRecodes$1, reason: invalid class name */
    /* JADX INFO: compiled from: DoorControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$addOpenDoorRecodes$1", f = "DoorControlViewModel.kt", i = {0}, l = {78}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $personId;
        final /* synthetic */ String $personType;
        final /* synthetic */ String $type;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$personId = str;
            this.$type = str2;
            this.$personType = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$personId, this.$type, this.$personType, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                HashMap map = new HashMap();
                HashMap map2 = map;
                String brandId = SpData.getBrandId();
                Intrinsics.checkNotNullExpressionValue(brandId, "getBrandId()");
                map2.put("brandId", brandId);
                String siteId = SpData.getSiteId();
                Intrinsics.checkNotNullExpressionValue(siteId, "getSiteId()");
                map2.put("siteId", siteId);
                String currentTime2 = TimeUtil.getCurrentTime2();
                Intrinsics.checkNotNullExpressionValue(currentTime2, "getCurrentTime2()");
                map2.put("openTime", currentTime2);
                map2.put("personId", this.$personId);
                map2.put("type", this.$type);
                map2.put("personType", this.$personType);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object objM471requestTrafficRecodesgIAlus = NetworkApi.INSTANCE.m471requestTrafficRecodesgIAlus(requestBodyCreate, this);
                if (objM471requestTrafficRecodesgIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
                value = objM471requestTrafficRecodesgIAlus;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            if (Result.m598isSuccessimpl(value)) {
                AppExtKt.logd(coroutineScope, "添加开门记录成功");
            } else {
                AppExtKt.logd(coroutineScope, "添加开门记录失败 " + GsonUtils.toJson(Result.m590boximpl(value)));
            }
            return Unit.INSTANCE;
        }
    }

    public final void addOpenDoorRecodes(String personId, String type, String personType) {
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(personType, "personType");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(personId, type, personType, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$verifyTeacherLogin$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DoorControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.iotControl.viewmodel.DoorControlViewModel$verifyTeacherLogin$1", f = "DoorControlViewModel.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    static final class C03601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $password;
        final /* synthetic */ String $username;
        Object L$0;
        int label;
        final /* synthetic */ DoorControlViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03601(String str, String str2, DoorControlViewModel doorControlViewModel, Continuation<? super C03601> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$password = str2;
            this.this$0 = doorControlViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03601(this.$username, this.$password, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM475verifyTeacherLogingIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HashMap map = new HashMap();
                HashMap map2 = map;
                map2.put("username", this.$username);
                map2.put("password", this.$password);
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = GsonUtils.toJson(map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(requestMap)");
                RequestBody requestBodyCreate = companion.create(json, BaseConstant.JSON);
                MutableLiveData mutableLiveData2 = this.this$0.verifyTeacherLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                objM475verifyTeacherLogingIAlus = NetworkApi.INSTANCE.m475verifyTeacherLogingIAlus(requestBodyCreate, this);
                if (objM475verifyTeacherLogingIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                objM475verifyTeacherLogingIAlus = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(objM475verifyTeacherLogingIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void verifyTeacherLogin(String username, String password) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03601(username, password, this, null), 3, null);
    }
}
