package com.yd.android_brand_mvp.landscape.blackboard;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blankj.utilcode.util.FileUtils;
import com.google.gson.reflect.TypeToken;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.joda.time.DateTimeConstants;

/* JADX INFO: compiled from: BlackBoardViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u0007\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u0014\u001a\u00020\u001aJ\u0006\u0010\u0016\u001a\u00020\u001aJ\u0006\u0010\u0018\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001dJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060$H\u0002J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060$H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b¨\u0006&"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "allSubjectList", "Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardModel;", "getAllSubjectList", "()Lcom/yd/android_brand_mvp/network/base/SingleLiveEvent;", "bytes", "", "getBytes", "()[B", "setBytes", "([B)V", "historyList", "getHistoryList", "singleSubjectList", "getSingleSubjectList", "todayAllSubjectList", "getTodayAllSubjectList", "todayList", "getTodayList", "todaySubjectList", "getTodaySubjectList", "clearTimeoutCache", "", "getSubjectHistoryStatisticsList", "subjectName", "", "getTodaytTableList", "time", "soft", "newList", "splitDateGroup", TUIKitConstants.Selection.LIST, "", "splitGroup", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlackBoardViewModel extends ViewModel {
    private final SingleLiveEvent<List<BlackBoardModel>> historyList = new SingleLiveEvent<>();
    private final SingleLiveEvent<List<BlackBoardModel>> todayList = new SingleLiveEvent<>();
    private final SingleLiveEvent<List<BlackBoardModel>> singleSubjectList = new SingleLiveEvent<>();
    private final SingleLiveEvent<List<BlackBoardModel>> allSubjectList = new SingleLiveEvent<>();
    private final SingleLiveEvent<List<BlackBoardModel>> todayAllSubjectList = new SingleLiveEvent<>();
    private final SingleLiveEvent<List<BlackBoardModel>> todaySubjectList = new SingleLiveEvent<>();
    private byte[] bytes = new byte[0];

    public final SingleLiveEvent<List<BlackBoardModel>> getHistoryList() {
        return this.historyList;
    }

    public final SingleLiveEvent<List<BlackBoardModel>> getTodayList() {
        return this.todayList;
    }

    public final SingleLiveEvent<List<BlackBoardModel>> getSingleSubjectList() {
        return this.singleSubjectList;
    }

    public final SingleLiveEvent<List<BlackBoardModel>> getAllSubjectList() {
        return this.allSubjectList;
    }

    public final SingleLiveEvent<List<BlackBoardModel>> getTodayAllSubjectList() {
        return this.todayAllSubjectList;
    }

    public final SingleLiveEvent<List<BlackBoardModel>> getTodaySubjectList() {
        return this.todaySubjectList;
    }

    public final byte[] getBytes() {
        return this.bytes;
    }

    public final void setBytes(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.bytes = bArr;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodaySubjectList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlackBoardViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodaySubjectList$1", f = "BlackBoardViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04061(Continuation<? super C04061> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlackBoardViewModel.this.new C04061(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<BlackBoardModel> list = (List) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BLACK_BROAD), new TypeToken<List<? extends BlackBoardModel>>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodaySubjectList$1$list$1
            }.getType());
            String currentTime = TimeUtil.getCurrentTime();
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (BlackBoardModel blackBoardModel : list) {
                    if (Intrinsics.areEqual(currentTime, TimeUtil.formatTime(blackBoardModel.getTime(), "yyyyMMddHHmmss", "yyyyMMdd"))) {
                        arrayList.add(blackBoardModel);
                    }
                }
            }
            BlackBoardViewModel.this.getTodaySubjectList().setValue(BlackBoardViewModel.this.splitGroup(arrayList));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getTodaySubjectList, reason: collision with other method in class */
    public final void m299getTodaySubjectList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04061(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getAllSubjectList$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlackBoardViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getAllSubjectList$1", f = "BlackBoardViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlackBoardViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List list = (List) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BLACK_BROAD), new TypeToken<List<? extends BlackBoardModel>>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getAllSubjectList$1$list$1
            }.getType());
            BlackBoardViewModel blackBoardViewModel = BlackBoardViewModel.this;
            Intrinsics.checkNotNullExpressionValue(list, "list");
            BlackBoardViewModel.this.getAllSubjectList().setValue(blackBoardViewModel.splitGroup(list));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getAllSubjectList, reason: collision with other method in class */
    public final void m296getAllSubjectList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodayAllSubjectList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlackBoardViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodayAllSubjectList$1", f = "BlackBoardViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04041(Continuation<? super C04041> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlackBoardViewModel.this.new C04041(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<BlackBoardModel> list = (List) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BLACK_BROAD), new TypeToken<List<? extends BlackBoardModel>>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodayAllSubjectList$1$list$1
            }.getType());
            String currentTime = TimeUtil.getCurrentTime();
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (BlackBoardModel blackBoardModel : list) {
                    if (Intrinsics.areEqual(currentTime, TimeUtil.formatTime(blackBoardModel.getTime(), "yyyyMMddHHmmss", "yyyyMMdd"))) {
                        arrayList.add(blackBoardModel);
                    }
                }
            }
            BlackBoardViewModel.this.getTodayAllSubjectList().setValue(BlackBoardViewModel.this.splitGroup(arrayList));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getTodayAllSubjectList, reason: collision with other method in class */
    public final void m297getTodayAllSubjectList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04041(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<BlackBoardModel> soft(List<BlackBoardModel> newList) {
        Collections.sort(newList, new Comparator() { // from class: com.yd.android_brand_mvp.landscape.blackboard.-$$Lambda$BlackBoardViewModel$QzMYXD9Mhio1fx8iiIyuIvQsRUY
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BlackBoardViewModel.soft$lambda$0((BlackBoardModel) obj, (BlackBoardModel) obj2);
            }
        });
        return newList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int soft$lambda$0(BlackBoardModel blackBoardModel, BlackBoardModel blackBoardModel2) {
        return TimeUtil.gettime(blackBoardModel != null ? blackBoardModel.getTime() : null, "yyyyMMddHHmmss") < TimeUtil.gettime(blackBoardModel2 != null ? blackBoardModel2.getTime() : null, "yyyyMMddHHmmss") ? 1 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<BlackBoardModel> splitGroup(List<BlackBoardModel> list) {
        BlackBoardModel blackBoardModel;
        HashMap map = new HashMap();
        for (BlackBoardModel blackBoardModel2 : list) {
            String subjectName = blackBoardModel2.getSubjectName();
            if (subjectName == null) {
                subjectName = "";
            }
            if (map.containsKey(subjectName)) {
                Object obj = map.get(subjectName);
                Intrinsics.checkNotNull(obj);
                ((List) obj).add(blackBoardModel2);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(blackBoardModel2);
                map.put(subjectName, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : map.keySet()) {
            BlackBoardModel blackBoardModel3 = new BlackBoardModel(null, null, null, null, 15, null);
            blackBoardModel3.setSubjectName(str);
            List list2 = (List) map.get(str);
            blackBoardModel3.setTime((list2 == null || (blackBoardModel = (BlackBoardModel) list2.get(0)) == null) ? null : blackBoardModel.getTime());
            blackBoardModel3.setList((List) map.get(str));
            arrayList2.add(blackBoardModel3);
        }
        ArrayList arrayList3 = arrayList2;
        CollectionsKt.reverse(arrayList3);
        return arrayList3;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getSubjectHistoryStatisticsList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlackBoardViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getSubjectHistoryStatisticsList$1", f = "BlackBoardViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $subjectName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04031(String str, Continuation<? super C04031> continuation) {
            super(2, continuation);
            this.$subjectName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlackBoardViewModel.this.new C04031(this.$subjectName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<BlackBoardModel> list = (List) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BLACK_BROAD), new TypeToken<List<? extends BlackBoardModel>>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getSubjectHistoryStatisticsList$1$list$1
            }.getType());
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                String str = this.$subjectName;
                for (BlackBoardModel blackBoardModel : list) {
                    if (Intrinsics.areEqual(str, blackBoardModel.getSubjectName())) {
                        arrayList.add(blackBoardModel);
                    }
                }
            }
            SingleLiveEvent<List<BlackBoardModel>> historyList = BlackBoardViewModel.this.getHistoryList();
            BlackBoardViewModel blackBoardViewModel = BlackBoardViewModel.this;
            historyList.setValue(blackBoardViewModel.soft(blackBoardViewModel.splitDateGroup(arrayList)));
            return Unit.INSTANCE;
        }
    }

    public final void getSubjectHistoryStatisticsList(String subjectName) {
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04031(subjectName, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<BlackBoardModel> splitDateGroup(List<BlackBoardModel> list) {
        BlackBoardModel blackBoardModel;
        HashMap map = new HashMap();
        for (BlackBoardModel blackBoardModel2 : list) {
            String time = blackBoardModel2.getTime();
            if (time == null) {
                time = "";
            }
            if (map.containsKey(time)) {
                Object obj = map.get(time);
                Intrinsics.checkNotNull(obj);
                ((List) obj).add(blackBoardModel2);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(blackBoardModel2);
                map.put(time, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : map.keySet()) {
            BlackBoardModel blackBoardModel3 = new BlackBoardModel(null, null, null, null, 15, null);
            List list2 = (List) map.get(str);
            blackBoardModel3.setSubjectName((list2 == null || (blackBoardModel = (BlackBoardModel) list2.get(0)) == null) ? null : blackBoardModel.getSubjectName());
            blackBoardModel3.setTime(str);
            blackBoardModel3.setList((List) map.get(str));
            arrayList2.add(blackBoardModel3);
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodayList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlackBoardViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodayList$1", f = "BlackBoardViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C04051(Continuation<? super C04051> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlackBoardViewModel.this.new C04051(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<BlackBoardModel> list = (List) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BLACK_BROAD), new TypeToken<List<? extends BlackBoardModel>>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodayList$1$list$1
            }.getType());
            String currentTime = TimeUtil.getCurrentTime();
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (BlackBoardModel blackBoardModel : list) {
                    if (Intrinsics.areEqual(currentTime, TimeUtil.formatTime(blackBoardModel.getTime(), "yyyyMMddHHmmss", "yyyyMMdd"))) {
                        arrayList.add(blackBoardModel);
                    }
                }
            }
            if (arrayList.size() >= 10) {
                BlackBoardViewModel.this.getTodayList().setValue(arrayList.subList(0, 10));
            } else {
                BlackBoardViewModel.this.getTodayList().setValue(arrayList);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: getTodayList, reason: collision with other method in class */
    public final void m298getTodayList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04051(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodaytTableList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BlackBoardViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodaytTableList$1", f = "BlackBoardViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $time;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04071(String str, Continuation<? super C04071> continuation) {
            super(2, continuation);
            this.$time = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlackBoardViewModel.this.new C04071(this.$time, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<BlackBoardModel> list = (List) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BLACK_BROAD), new TypeToken<List<? extends BlackBoardModel>>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$getTodaytTableList$1$list$1
            }.getType());
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                String str = this.$time;
                for (BlackBoardModel blackBoardModel : list) {
                    if (Intrinsics.areEqual(str, blackBoardModel.getTime())) {
                        arrayList.add(blackBoardModel);
                    }
                }
            }
            BlackBoardViewModel.this.getSingleSubjectList().setValue(BlackBoardViewModel.this.soft(arrayList));
            return Unit.INSTANCE;
        }
    }

    public final void getTodaytTableList(String time) {
        Intrinsics.checkNotNullParameter(time, "time");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04071(time, null), 3, null);
    }

    public final void clearTimeoutCache() {
        List<BlackBoardModel> list = (List) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BLACK_BROAD), new TypeToken<List<? extends BlackBoardModel>>() { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel$clearTimeoutCache$list$1
        }.getType());
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (list != null) {
            for (BlackBoardModel blackBoardModel : list) {
                if (jCurrentTimeMillis - TimeUtil.gettime(blackBoardModel.getTime(), "yyyyMMddHHmmss") < DateTimeConstants.MILLIS_PER_WEEK) {
                    arrayList.add(blackBoardModel);
                } else {
                    String filePath = blackBoardModel.getFilePath();
                    if (filePath != null) {
                        FileUtils.delete(filePath);
                    }
                }
            }
        }
        MMKVUtils.INSTANCE.put(MMKVConstant.BLACK_BROAD, GsonUtils.toJson(arrayList));
    }
}
