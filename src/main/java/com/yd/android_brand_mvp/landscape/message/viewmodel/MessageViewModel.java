package com.yd.android_brand_mvp.landscape.message.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.repository.DownRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: MessageViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "downloadState", "Landroidx/lifecycle/LiveData;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;", "getDownloadState", "()Landroidx/lifecycle/LiveData;", "downloadStateLiveData", "Landroidx/lifecycle/MutableLiveData;", "downloadWordFile", "", "filePath", "", "downUrl", "fileType", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageViewModel extends ViewModel {
    private final LiveData<DownRepository.DownloadStatus> downloadState;
    private final MutableLiveData<DownRepository.DownloadStatus> downloadStateLiveData;

    public MessageViewModel() {
        MutableLiveData<DownRepository.DownloadStatus> mutableLiveData = new MutableLiveData<>();
        this.downloadStateLiveData = mutableLiveData;
        this.downloadState = mutableLiveData;
    }

    public final LiveData<DownRepository.DownloadStatus> getDownloadState() {
        return this.downloadState;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.message.viewmodel.MessageViewModel$downloadWordFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.message.viewmodel.MessageViewModel$downloadWordFile$1", f = "MessageViewModel.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $downUrl;
        final /* synthetic */ String $filePath;
        final /* synthetic */ String $fileType;
        int label;
        final /* synthetic */ MessageViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, MessageViewModel messageViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$downUrl = str;
            this.$filePath = str2;
            this.$fileType = str3;
            this.this$0 = messageViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$downUrl, this.$filePath, this.$fileType, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<DownRepository.DownloadStatus> flowDownNormalFile = DownRepository.INSTANCE.downNormalFile(this.$downUrl, this.$filePath, this.$fileType);
                final MessageViewModel messageViewModel = this.this$0;
                this.label = 1;
                if (flowDownNormalFile.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.landscape.message.viewmodel.MessageViewModel.downloadWordFile.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((DownRepository.DownloadStatus) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(DownRepository.DownloadStatus downloadStatus, Continuation<? super Unit> continuation) {
                        messageViewModel.downloadStateLiveData.setValue(downloadStatus);
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
    }

    public final void downloadWordFile(String filePath, String downUrl, String fileType) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(downUrl, "downUrl");
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(downUrl, filePath, fileType, this, null), 3, null);
    }
}
