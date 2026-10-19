package com.yd.android_brand_mvp.network.setting;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: SettingActivationNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.setting.SettingActivationNetWork", f = "SettingActivationNetWork.kt", i = {}, l = {17}, m = "getActivationCode-gIAlu-s", n = {}, s = {})
final class SettingActivationNetWork$getActivationCode$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingActivationNetWork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SettingActivationNetWork$getActivationCode$1(SettingActivationNetWork settingActivationNetWork, Continuation<? super SettingActivationNetWork$getActivationCode$1> continuation) {
        super(continuation);
        this.this$0 = settingActivationNetWork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM532getActivationCodegIAlus = this.this$0.m532getActivationCodegIAlus(null, this);
        return objM532getActivationCodegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM532getActivationCodegIAlus : Result.m590boximpl(objM532getActivationCodegIAlus);
    }
}
