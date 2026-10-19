package com.yd.android_brand_mvp.activity.collect.viewmodel;

import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.koushikdutta.async.http.body.MultipartFormDataBody;
import com.tencent.qcloud.tim.uikit.utils.FileUtil;
import com.yd.android_brand_mvp.model.AreaBean;
import com.yd.android_brand_mvp.model.UploadFileBean;
import com.yd.android_brand_mvp.model.collect.BaseArrayBean;
import com.yd.android_brand_mvp.model.collect.DeptListBean;
import com.yd.android_brand_mvp.network.NetworkApi;
import com.yd.android_brand_mvp.network.collect.CollectNetWork;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
import master.flame.danmaku.danmaku.parser.IDataSource;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: FormItemViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!J\u000e\u0010\u001a\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$J\u0014\u0010\u001a\u001a\u00020\u001e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u0006R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR#\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR#\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00060\u00050\u000bX\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/viewmodel/FormItemViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "areaInfo", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/model/AreaBean;", "getAreaInfo", "()Landroidx/lifecycle/LiveData;", "areaInfoLiveData", "Landroidx/lifecycle/MutableLiveData;", "deptList", "Lcom/yd/android_brand_mvp/model/collect/DeptListBean;", "getDeptList", "deptListLiveData", "selectDeptData", "Lcom/yd/android_brand_mvp/model/collect/BaseArrayBean;", "getSelectDeptData", "()Lcom/yd/android_brand_mvp/model/collect/BaseArrayBean;", "setSelectDeptData", "(Lcom/yd/android_brand_mvp/model/collect/BaseArrayBean;)V", "uploadBitmapFile", "Lcom/yd/android_brand_mvp/model/UploadFileBean;", "getUploadBitmapFile", "uploadBitmapFileLiveData", "uploadFile", "getUploadFile", "uploadFileLiveData", "getLocationInfo", "", "getTeacherDeptList", "schoolId", "", "userId", "bitmap", "Landroid/graphics/Bitmap;", "filePathList", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormItemViewModel extends ViewModel {
    private final LiveData<Result<List<AreaBean>>> areaInfo;
    private final MutableLiveData<Result<List<AreaBean>>> areaInfoLiveData;
    private final LiveData<Result<List<DeptListBean>>> deptList;
    private final MutableLiveData<Result<List<DeptListBean>>> deptListLiveData;
    private BaseArrayBean selectDeptData;
    private final LiveData<Result<List<UploadFileBean>>> uploadBitmapFile;
    private final MutableLiveData<Result<List<UploadFileBean>>> uploadBitmapFileLiveData;
    private final LiveData<Result<List<UploadFileBean>>> uploadFile;
    private final MutableLiveData<Result<List<UploadFileBean>>> uploadFileLiveData;

    public FormItemViewModel() {
        MutableLiveData<Result<List<UploadFileBean>>> mutableLiveData = new MutableLiveData<>();
        this.uploadBitmapFileLiveData = mutableLiveData;
        this.uploadBitmapFile = mutableLiveData;
        MutableLiveData<Result<List<UploadFileBean>>> mutableLiveData2 = new MutableLiveData<>();
        this.uploadFileLiveData = mutableLiveData2;
        this.uploadFile = mutableLiveData2;
        MutableLiveData<Result<List<AreaBean>>> mutableLiveData3 = new MutableLiveData<>();
        this.areaInfoLiveData = mutableLiveData3;
        this.areaInfo = mutableLiveData3;
        MutableLiveData<Result<List<DeptListBean>>> mutableLiveData4 = new MutableLiveData<>();
        this.deptListLiveData = mutableLiveData4;
        this.deptList = mutableLiveData4;
        this.selectDeptData = new BaseArrayBean(null, null, false, 7, null);
    }

    public final LiveData<Result<List<UploadFileBean>>> getUploadBitmapFile() {
        return this.uploadBitmapFile;
    }

    public final LiveData<Result<List<UploadFileBean>>> getUploadFile() {
        return this.uploadFile;
    }

    public final LiveData<Result<List<AreaBean>>> getAreaInfo() {
        return this.areaInfo;
    }

    public final LiveData<Result<List<DeptListBean>>> getDeptList() {
        return this.deptList;
    }

    public final BaseArrayBean getSelectDeptData() {
        return this.selectDeptData;
    }

    public final void setSelectDeptData(BaseArrayBean baseArrayBean) {
        Intrinsics.checkNotNullParameter(baseArrayBean, "<set-?>");
        this.selectDeptData = baseArrayBean;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel$getLocationInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormItemViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel$getLocationInfo$1", f = "FormItemViewModel.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FormItemViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = FormItemViewModel.this.areaInfoLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM432getLocationInfoIoAF18A = NetworkApi.INSTANCE.m432getLocationInfoIoAF18A(this);
                if (objM432getLocationInfoIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM432getLocationInfoIoAF18A;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(value));
            return Unit.INSTANCE;
        }
    }

    public final void getLocationInfo() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel$uploadFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FormItemViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel$uploadFile$1", f = "FormItemViewModel.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    static final class C03161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        Object L$0;
        int label;
        final /* synthetic */ FormItemViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03161(Bitmap bitmap, FormItemViewModel formItemViewModel, Continuation<? super C03161> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.this$0 = formItemViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03161(this.$bitmap, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String filePath = FileUtil.saveBitmap("", this.$bitmap);
                Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
                if (filePath.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    File file = new File(filePath);
                    arrayList.add(MultipartBody.Part.INSTANCE.createFormData(IDataSource.SCHEME_FILE_TAG, file.getName(), RequestBody.INSTANCE.create(file, MediaType.INSTANCE.parse(MultipartFormDataBody.CONTENT_TYPE))));
                    MutableLiveData mutableLiveData2 = this.this$0.uploadBitmapFileLiveData;
                    this.L$0 = mutableLiveData2;
                    this.label = 1;
                    Object objM473upPhotogIAlus = NetworkApi.INSTANCE.m473upPhotogIAlus(arrayList, this);
                    if (objM473upPhotogIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableLiveData = mutableLiveData2;
                    value = objM473upPhotogIAlus;
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
            value = ((Result) obj).getValue();
            mutableLiveData.setValue(Result.m590boximpl(value));
            return Unit.INSTANCE;
        }
    }

    public final void uploadFile(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03161(bitmap, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel$uploadFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: FormItemViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel$uploadFile$2", f = "FormItemViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $filePathList;
        Object L$0;
        int label;
        final /* synthetic */ FormItemViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<String> list, FormItemViewModel formItemViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$filePathList = list;
            this.this$0 = formItemViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$filePathList, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM473upPhotogIAlus;
            MutableLiveData mutableLiveData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.$filePathList.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it2 = this.$filePathList.iterator();
                    while (it2.hasNext()) {
                        File file = new File((String) it2.next());
                        arrayList.add(MultipartBody.Part.INSTANCE.createFormData(IDataSource.SCHEME_FILE_TAG, file.getName(), RequestBody.INSTANCE.create(file, MediaType.INSTANCE.parse(MultipartFormDataBody.CONTENT_TYPE))));
                    }
                    MutableLiveData mutableLiveData2 = this.this$0.uploadFileLiveData;
                    this.L$0 = mutableLiveData2;
                    this.label = 1;
                    objM473upPhotogIAlus = NetworkApi.INSTANCE.m473upPhotogIAlus(arrayList, this);
                    if (objM473upPhotogIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableLiveData = mutableLiveData2;
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
            objM473upPhotogIAlus = ((Result) obj).getValue();
            mutableLiveData.setValue(Result.m590boximpl(objM473upPhotogIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void uploadFile(List<String> filePathList) {
        Intrinsics.checkNotNullParameter(filePathList, "filePathList");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(filePathList, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel$getTeacherDeptList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FormItemViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.collect.viewmodel.FormItemViewModel$getTeacherDeptList$1", f = "FormItemViewModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    static final class C03151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $schoolId;
        final /* synthetic */ String $userId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03151(String str, String str2, Continuation<? super C03151> continuation) {
            super(2, continuation);
            this.$schoolId = str;
            this.$userId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FormItemViewModel.this.new C03151(this.$schoolId, this.$userId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableLiveData mutableLiveData;
            Object value;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableLiveData mutableLiveData2 = FormItemViewModel.this.deptListLiveData;
                this.L$0 = mutableLiveData2;
                this.label = 1;
                Object objM491getTeacherDeptList0E7RQCE = CollectNetWork.INSTANCE.m491getTeacherDeptList0E7RQCE(this.$schoolId, this.$userId, this);
                if (objM491getTeacherDeptList0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLiveData = mutableLiveData2;
                value = objM491getTeacherDeptList0E7RQCE;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableLiveData = (MutableLiveData) this.L$0;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            mutableLiveData.setValue(Result.m590boximpl(value));
            return Unit.INSTANCE;
        }
    }

    public final void getTeacherDeptList(String schoolId, String userId) {
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03151(schoolId, userId, null), 3, null);
    }
}
