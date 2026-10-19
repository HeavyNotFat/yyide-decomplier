package com.yd.android_brand_mvp.network.library;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: LibraryNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.library.LibraryNetwork", f = "LibraryNetwork.kt", i = {}, l = {32}, m = "requestLibraryClassifyList-gIAlu-s", n = {}, s = {})
final class LibraryNetwork$requestLibraryClassifyList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LibraryNetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibraryNetwork$requestLibraryClassifyList$1(LibraryNetwork libraryNetwork, Continuation<? super LibraryNetwork$requestLibraryClassifyList$1> continuation) {
        super(continuation);
        this.this$0 = libraryNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM515requestLibraryClassifyListgIAlus = this.this$0.m515requestLibraryClassifyListgIAlus(null, this);
        return objM515requestLibraryClassifyListgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM515requestLibraryClassifyListgIAlus : Result.m590boximpl(objM515requestLibraryClassifyListgIAlus);
    }
}
