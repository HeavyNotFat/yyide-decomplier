package com.yd.android_brand_mvp.landscape.setting;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.model.getRegistrationCodeRsp;
import com.yd.android_brand_mvp.network.setting.SettingActivationNetWork;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.LinkedHashMap;
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
import okhttp3.RequestBody;

/* JADX INFO: compiled from: SettingViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/setting/SettingViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "codeData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/getRegistrationCodeRsp$RegistrationCode;", "codeResult", "getCodeResult", "()Landroidx/lifecycle/MutableLiveData;", "getActivationCode", "", "no", "", "deviceType", "schoolId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SettingViewModel extends ViewModel {
    private final MutableLiveData<Result<getRegistrationCodeRsp.RegistrationCode>> codeData;
    private final MutableLiveData<Result<getRegistrationCodeRsp.RegistrationCode>> codeResult;

    public SettingViewModel() {
        MutableLiveData<Result<getRegistrationCodeRsp.RegistrationCode>> mutableLiveData = new MutableLiveData<>();
        this.codeData = mutableLiveData;
        this.codeResult = mutableLiveData;
    }

    public final MutableLiveData<Result<getRegistrationCodeRsp.RegistrationCode>> getCodeResult() {
        return this.codeResult;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.setting.SettingViewModel$getActivationCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: SettingViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.setting.SettingViewModel$getActivationCode$1", f = "SettingViewModel.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceType;
        final /* synthetic */ String $no;
        final /* synthetic */ String $schoolId;
        int label;
        final /* synthetic */ SettingViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, SettingViewModel settingViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$no = str;
            this.$deviceType = str2;
            this.$schoolId = str3;
            this.this$0 = settingViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$no, this.$deviceType, this.$schoolId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM532getActivationCodegIAlus;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("no", this.$no);
                linkedHashMap.put("deviceType", this.$deviceType);
                linkedHashMap.put("schoolId", this.$schoolId);
                linkedHashMap.put("type", "3");
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String gson = GsonUtils.toGson(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(gson, "toGson(map)");
                RequestBody requestBodyCreate = companion.create(gson, BaseConstant.JSON);
                this.label = 1;
                objM532getActivationCodegIAlus = SettingActivationNetWork.INSTANCE.m532getActivationCodegIAlus(requestBodyCreate, this);
                if (objM532getActivationCodegIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objM532getActivationCodegIAlus = ((Result) obj).getValue();
            }
            this.this$0.codeData.setValue(Result.m590boximpl(objM532getActivationCodegIAlus));
            return Unit.INSTANCE;
        }
    }

    public final void getActivationCode(String no2, String deviceType, String schoolId) {
        Intrinsics.checkNotNullParameter(no2, "no");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(no2, deviceType, schoolId, this, null), 3, null);
    }
}
