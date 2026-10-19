package com.yd.android_brand_mvp.activity.home.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yyide.facepass.bean.FaceExtractBean;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FaceSyncStatusViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/home/viewmodel/FaceSyncStatusViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "isProcessing", "", "requestQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/yyide/facepass/bean/FaceExtractBean;", "addRequest", "", "faceExtractBean", "processQueue", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FaceSyncStatusViewModel extends ViewModel {
    private boolean isProcessing;
    private final ConcurrentLinkedQueue<FaceExtractBean> requestQueue = new ConcurrentLinkedQueue<>();

    public final void addRequest(FaceExtractBean faceExtractBean) {
        Intrinsics.checkNotNullParameter(faceExtractBean, "faceExtractBean");
        this.requestQueue.add(faceExtractBean);
        processQueue();
    }

    private final void processQueue() {
        if (this.isProcessing) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.home.viewmodel.FaceSyncStatusViewModel$processQueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: FaceSyncStatusViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.FaceSyncStatusViewModel$processQueue$1", f = "FaceSyncStatusViewModel.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FaceSyncStatusViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0037  */
        /* JADX WARN: Code duplicated, block: B:16:0x0045  */
        /* JADX WARN: Code duplicated, block: B:17:0x0050  */
        /* JADX WARN: Code duplicated, block: B:19:0x0072  */
        /* JADX WARN: Code duplicated, block: B:22:0x007e  */
        /* JADX WARN: Code duplicated, block: B:25:0x0091  */
        /* JADX WARN: Code duplicated, block: B:29:0x009e  */
        /* JADX WARN: Code duplicated, block: B:33:0x00c2 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00c0 -> B:41:0x00c3). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yd.android_brand_mvp.activity.home.viewmodel.FaceSyncStatusViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
