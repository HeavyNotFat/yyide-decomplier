package com.yd.android_brand_mvp.repository;

import com.yd.android_brand_mvp.network.INetworkService;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: DownRepository.kt */
/* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\repository\DownRepository.smali */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/repository/DownRepository;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/INetworkService;", "()V", "downNormalFile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;", "url", "", "filePath", "fileType", "DownloadStatus", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DownRepository extends BaseNetworkApi<INetworkService> {
    public static final DownRepository INSTANCE = new DownRepository();

    private DownRepository() {
        super("https://api.yyide.com");
    }

    public static final /* synthetic */ INetworkService access$getNoInterceptorService(DownRepository downRepository) {
        return downRepository.getNoInterceptorService();
    }

    /* JADX INFO: compiled from: DownRepository.kt */
    /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\repository\DownRepository$DownloadStatus.smali */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;", "", "()V", "Complete", "Error", "None", "Progress", "Start", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus$Complete;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus$Error;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus$None;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus$Progress;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus$Start;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class DownloadStatus {
        public /* synthetic */ DownloadStatus(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: DownRepository.kt */
        /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\repository\DownRepository$DownloadStatus$None.smali */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus$None;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;", "()V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class None extends DownloadStatus {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        private DownloadStatus() {
        }

        /* JADX INFO: compiled from: DownRepository.kt */
        /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\repository\DownRepository$DownloadStatus$Start.smali */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus$Start;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;", "value", "", "(J)V", "getValue", "()J", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Start extends DownloadStatus {
            private final long value;

            public Start(long j) {
                super(null);
                this.value = j;
            }

            public final long getValue() {
                return this.value;
            }
        }

        /* JADX INFO: compiled from: DownRepository.kt */
        /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\repository\DownRepository$DownloadStatus$Progress.smali */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus$Progress;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;", "value", "", "size", "", "(IJ)V", "getSize", "()J", "getValue", "()I", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Progress extends DownloadStatus {
            private final long size;
            private final int value;

            public Progress(int i, long j) {
                super(null);
                this.value = i;
                this.size = j;
            }

            public final long getSize() {
                return this.size;
            }

            public final int getValue() {
                return this.value;
            }
        }

        /* JADX INFO: compiled from: DownRepository.kt */
        /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\repository\DownRepository$DownloadStatus$Error.smali */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus$Error;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Error extends DownloadStatus {
            private final Throwable throwable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(th, "throwable");
                this.throwable = th;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }
        }

        /* JADX INFO: compiled from: DownRepository.kt */
        /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\repository\DownRepository$DownloadStatus$Complete.smali */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus$Complete;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;", "file", "Ljava/io/File;", "remark", "", "(Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getRemark", "()Ljava/lang/String;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Complete extends DownloadStatus {
            private final File file;
            private final String remark;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Complete(File file, String str) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                Intrinsics.checkNotNullParameter(str, "remark");
                this.file = file;
                this.remark = str;
            }

            public /* synthetic */ Complete(File file, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(file, (i & 2) != 0 ? "" : str);
            }

            public final File getFile() {
                return this.file;
            }

            public final String getRemark() {
                return this.remark;
            }
        }
    }

    public static /* synthetic */ Flow downNormalFile$default(DownRepository downRepository, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "txt";
        }
        return downRepository.downNormalFile(str, str2, str3);
    }

    public final Flow<DownloadStatus> downNormalFile(String url, String filePath, String fileType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        File file = new File(filePath);
        if (file.exists()) {
            return FlowKt.flow(new AnonymousClass1(file, fileType, null));
        }
        return FlowKt.catch(FlowKt.flowOn(FlowKt.flow(new AnonymousClass2(url, file, fileType, null)), Dispatchers.getIO()), new AnonymousClass3(file, null));
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.repository.DownRepository$downNormalFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownRepository.kt */
    /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\repository\DownRepository$downNormalFile$1.smali */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.repository.DownRepository$downNormalFile$1", f = "DownRepository.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super DownloadStatus>, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $file;
        final /* synthetic */ String $fileType;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(File file, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$file = file;
            this.$fileType = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$file, this.$fileType, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(FlowCollector<? super DownloadStatus> flowCollector, Continuation<? super Unit> continuation) {
            return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (((FlowCollector) this.L$0).emit(new DownloadStatus.Complete(this.$file, this.$fileType), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.repository.DownRepository$downNormalFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: DownRepository.kt */
    /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\repository\DownRepository$downNormalFile$2.smali */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.repository.DownRepository$downNormalFile$2", f = "DownRepository.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3}, l = {56, 60, 69, 72}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "input", "total", "$this$flow", "input", "fos", "buf", "ch", "total", "process", "input", "fos"}, s = {"L$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0", "L$0", "L$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super DownloadStatus>, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $file;
        final /* synthetic */ String $fileType;
        final /* synthetic */ String $url;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, File file, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$file = file;
            this.$fileType = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$url, this.$file, this.$fileType, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        public final Object invoke(FlowCollector<? super DownloadStatus> flowCollector, Continuation<? super Unit> continuation) {
            return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00ce  */
        /* JADX WARN: Code duplicated, block: B:31:0x0117 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x0118  */
        /* JADX WARN: Code duplicated, block: B:37:0x00f5 A[SYNTHETIC] */
        public final Object invokeSuspend(Object obj) throws Exception {
            FlowCollector flowCollector;
            Object objDownloadFile;
            FlowCollector flowCollector2;
            InputStream inputStreamByteStream;
            long j;
            Ref.IntRef intRef;
            FlowCollector flowCollector3;
            int i;
            long j2;
            InputStream inputStream;
            FileOutputStream fileOutputStream;
            byte[] bArr;
            int i2;
            InputStream inputStream2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                this.L$0 = flowCollector;
                this.label = 1;
                objDownloadFile = DownRepository.access$getNoInterceptorService(DownRepository.INSTANCE).downloadFile(this.$url, (Continuation) this);
                if (objDownloadFile == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 == 1) {
                    flowCollector = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objDownloadFile = obj;
                } else {
                    if (i3 == 2) {
                        j = this.J$0;
                        inputStreamByteStream = (InputStream) this.L$1;
                        flowCollector2 = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        FileOutputStream fileOutputStream2 = new FileOutputStream(this.$file);
                        intRef = new Ref.IntRef();
                        flowCollector3 = flowCollector2;
                        i = 0;
                        j2 = j;
                        inputStream = inputStreamByteStream;
                        fileOutputStream = fileOutputStream2;
                        bArr = new byte[1024];
                        do {
                            i2 = inputStream.read(bArr);
                            intRef.element = i2;
                            if (i2 != -1) {
                                fileOutputStream.write(bArr, 0, intRef.element);
                                i += intRef.element;
                                this.L$0 = flowCollector3;
                                this.L$1 = inputStream;
                                this.L$2 = fileOutputStream;
                                this.L$3 = bArr;
                                this.L$4 = intRef;
                                this.J$0 = j2;
                                this.I$0 = i;
                                this.label = 3;
                            } else {
                                fileOutputStream.flush();
                                this.L$0 = inputStream;
                                this.L$1 = fileOutputStream;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 4;
                                if (flowCollector3.emit(new DownloadStatus.Complete(this.$file, this.$fileType), (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                inputStream2 = inputStream;
                            }
                        } while (flowCollector3.emit(new DownloadStatus.Progress(i, j2), (Continuation) this) != coroutine_suspended);
                        return coroutine_suspended;
                    }
                    if (i3 == 3) {
                        int i4 = this.I$0;
                        long j3 = this.J$0;
                        Ref.IntRef intRef2 = (Ref.IntRef) this.L$4;
                        bArr = (byte[]) this.L$3;
                        FileOutputStream fileOutputStream3 = (FileOutputStream) this.L$2;
                        InputStream inputStream3 = (InputStream) this.L$1;
                        flowCollector3 = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        i = i4;
                        fileOutputStream = fileOutputStream3;
                        intRef = intRef2;
                        j2 = j3;
                        inputStream = inputStream3;
                        do {
                            i2 = inputStream.read(bArr);
                            intRef.element = i2;
                            if (i2 != -1) {
                                fileOutputStream.write(bArr, 0, intRef.element);
                                i += intRef.element;
                                this.L$0 = flowCollector3;
                                this.L$1 = inputStream;
                                this.L$2 = fileOutputStream;
                                this.L$3 = bArr;
                                this.L$4 = intRef;
                                this.J$0 = j2;
                                this.I$0 = i;
                                this.label = 3;
                            } else {
                                fileOutputStream.flush();
                                this.L$0 = inputStream;
                                this.L$1 = fileOutputStream;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 4;
                                if (flowCollector3.emit(new DownloadStatus.Complete(this.$file, this.$fileType), (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                inputStream2 = inputStream;
                            }
                        } while (flowCollector3.emit(new DownloadStatus.Progress(i, j2), (Continuation) this) != coroutine_suspended);
                        return coroutine_suspended;
                    }
                    if (i3 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fileOutputStream = (FileOutputStream) this.L$1;
                    inputStream2 = (InputStream) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                inputStream2.close();
                fileOutputStream.close();
                return Unit.INSTANCE;
            }
            flowCollector2 = flowCollector;
            ResponseBody responseBody = (ResponseBody) objDownloadFile;
            inputStreamByteStream = responseBody.byteStream();
            if (inputStreamByteStream == null) {
                throw new Exception("下载失败");
            }
            long jContentLength = responseBody.contentLength();
            this.L$0 = flowCollector2;
            this.L$1 = inputStreamByteStream;
            this.J$0 = jContentLength;
            this.label = 2;
            if (flowCollector2.emit(new DownloadStatus.Start(jContentLength), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = jContentLength;
            FileOutputStream fileOutputStream4 = new FileOutputStream(this.$file);
            intRef = new Ref.IntRef();
            flowCollector3 = flowCollector2;
            i = 0;
            j2 = j;
            inputStream = inputStreamByteStream;
            fileOutputStream = fileOutputStream4;
            bArr = new byte[1024];
            do {
                i2 = inputStream.read(bArr);
                intRef.element = i2;
                if (i2 != -1) {
                    fileOutputStream.write(bArr, 0, intRef.element);
                    i += intRef.element;
                    this.L$0 = flowCollector3;
                    this.L$1 = inputStream;
                    this.L$2 = fileOutputStream;
                    this.L$3 = bArr;
                    this.L$4 = intRef;
                    this.J$0 = j2;
                    this.I$0 = i;
                    this.label = 3;
                } else {
                    fileOutputStream.flush();
                    this.L$0 = inputStream;
                    this.L$1 = fileOutputStream;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 4;
                    if (flowCollector3.emit(new DownloadStatus.Complete(this.$file, this.$fileType), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    inputStream2 = inputStream;
                    inputStream2.close();
                    fileOutputStream.close();
                    return Unit.INSTANCE;
                }
            } while (flowCollector3.emit(new DownloadStatus.Progress(i, j2), (Continuation) this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.repository.DownRepository$downNormalFile$3, reason: invalid class name */
    /* JADX INFO: compiled from: DownRepository.kt */
    /* JADX INFO: loaded from: D:\Desktop\AndroidProjects\HackedBrand3.0.15\build\app-smali-3.0.15\com\yd\android_brand_mvp\repository\DownRepository$downNormalFile$3.smali */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/yd/android_brand_mvp/repository/DownRepository$DownloadStatus;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.repository.DownRepository$downNormalFile$3", f = "DownRepository.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super DownloadStatus>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $file;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(File file, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.$file = file;
        }

        public final Object invoke(FlowCollector<? super DownloadStatus> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$file, continuation);
            anonymousClass3.L$0 = flowCollector;
            anonymousClass3.L$1 = th;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                if (this.$file.exists()) {
                    this.$file.delete();
                }
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(new DownloadStatus.Error(th), (Continuation) this) == coroutine_suspended) {
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
}
