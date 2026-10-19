package com.yd.android_brand_mvp.network.library;

import com.yd.android_brand_mvp.model.library.LibraryBean;
import com.yd.android_brand_mvp.model.library.LibraryCollectBookSituationBean;
import com.yd.android_brand_mvp.model.library.LibraryItemBean;
import com.yd.android_brand_mvp.model.library.LibraryTypeBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: LibraryNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\r0\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ0\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ0\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ0\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u000bJ6\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\r0\u00052\u0006\u0010\b\u001a\u00020\tH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ0\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00060\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/network/library/LibraryNetwork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/library/ILibraryService;", "()V", "requestHotList", "Lkotlin/Result;", "", "Lcom/yd/android_brand_mvp/model/library/LibraryItemBean;", "requestBody", "Lokhttp3/RequestBody;", "requestHotList-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestLibraryBookSituation", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "Lcom/yd/android_brand_mvp/model/library/LibraryCollectBookSituationBean;", "requestLibraryBookSituation-gIAlu-s", "requestLibraryClassifyList", "Lcom/yd/android_brand_mvp/model/library/LibraryTypeBean;", "requestLibraryClassifyList-gIAlu-s", "requestLibraryList", "Lcom/yd/android_brand_mvp/model/library/LibraryBean;", "requestLibraryList-gIAlu-s", "requestLibraryNewRecommendedList", "requestLibraryNewRecommendedList-gIAlu-s", "requestLibrarySearch", "requestLibrarySearch-gIAlu-s", "requestLibraryTypeList", "libraryId", "", "requestLibraryTypeList-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibraryNetwork extends BaseNetworkApi<ILibraryService> {
    public static final LibraryNetwork INSTANCE = new LibraryNetwork();

    private LibraryNetwork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestHotList-gIAlu-s, reason: not valid java name */
    public final Object m513requestHotListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<LibraryItemBean>>> continuation) {
        LibraryNetwork$requestHotList$1 libraryNetwork$requestHotList$1;
        if (continuation instanceof LibraryNetwork$requestHotList$1) {
            libraryNetwork$requestHotList$1 = (LibraryNetwork$requestHotList$1) continuation;
            if ((libraryNetwork$requestHotList$1.label & Integer.MIN_VALUE) != 0) {
                libraryNetwork$requestHotList$1.label -= Integer.MIN_VALUE;
            } else {
                libraryNetwork$requestHotList$1 = new LibraryNetwork$requestHotList$1(this, continuation);
            }
        } else {
            libraryNetwork$requestHotList$1 = new LibraryNetwork$requestHotList$1(this, continuation);
        }
        Object obj = libraryNetwork$requestHotList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = libraryNetwork$requestHotList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        LibraryNetwork$requestHotList$2 libraryNetwork$requestHotList$2 = new LibraryNetwork$requestHotList$2(requestBody, null);
        libraryNetwork$requestHotList$1.label = 1;
        Object obj2 = m485getResultgIAlus(libraryNetwork$requestHotList$2, libraryNetwork$requestHotList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestLibraryList-gIAlu-s, reason: not valid java name */
    public final Object m516requestLibraryListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<LibraryBean>>> continuation) {
        LibraryNetwork$requestLibraryList$1 libraryNetwork$requestLibraryList$1;
        if (continuation instanceof LibraryNetwork$requestLibraryList$1) {
            libraryNetwork$requestLibraryList$1 = (LibraryNetwork$requestLibraryList$1) continuation;
            if ((libraryNetwork$requestLibraryList$1.label & Integer.MIN_VALUE) != 0) {
                libraryNetwork$requestLibraryList$1.label -= Integer.MIN_VALUE;
            } else {
                libraryNetwork$requestLibraryList$1 = new LibraryNetwork$requestLibraryList$1(this, continuation);
            }
        } else {
            libraryNetwork$requestLibraryList$1 = new LibraryNetwork$requestLibraryList$1(this, continuation);
        }
        Object obj = libraryNetwork$requestLibraryList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = libraryNetwork$requestLibraryList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        LibraryNetwork$requestLibraryList$2 libraryNetwork$requestLibraryList$2 = new LibraryNetwork$requestLibraryList$2(requestBody, null);
        libraryNetwork$requestLibraryList$1.label = 1;
        Object obj2 = m485getResultgIAlus(libraryNetwork$requestLibraryList$2, libraryNetwork$requestLibraryList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestLibraryClassifyList-gIAlu-s, reason: not valid java name */
    public final Object m515requestLibraryClassifyListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<LibraryTypeBean>>> continuation) {
        LibraryNetwork$requestLibraryClassifyList$1 libraryNetwork$requestLibraryClassifyList$1;
        if (continuation instanceof LibraryNetwork$requestLibraryClassifyList$1) {
            libraryNetwork$requestLibraryClassifyList$1 = (LibraryNetwork$requestLibraryClassifyList$1) continuation;
            if ((libraryNetwork$requestLibraryClassifyList$1.label & Integer.MIN_VALUE) != 0) {
                libraryNetwork$requestLibraryClassifyList$1.label -= Integer.MIN_VALUE;
            } else {
                libraryNetwork$requestLibraryClassifyList$1 = new LibraryNetwork$requestLibraryClassifyList$1(this, continuation);
            }
        } else {
            libraryNetwork$requestLibraryClassifyList$1 = new LibraryNetwork$requestLibraryClassifyList$1(this, continuation);
        }
        Object obj = libraryNetwork$requestLibraryClassifyList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = libraryNetwork$requestLibraryClassifyList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        LibraryNetwork$requestLibraryClassifyList$2 libraryNetwork$requestLibraryClassifyList$2 = new LibraryNetwork$requestLibraryClassifyList$2(requestBody, null);
        libraryNetwork$requestLibraryClassifyList$1.label = 1;
        Object obj2 = m485getResultgIAlus(libraryNetwork$requestLibraryClassifyList$2, libraryNetwork$requestLibraryClassifyList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestLibraryTypeList-gIAlu-s, reason: not valid java name */
    public final Object m519requestLibraryTypeListgIAlus(String str, Continuation<? super Result<? extends List<LibraryTypeBean>>> continuation) {
        LibraryNetwork$requestLibraryTypeList$1 libraryNetwork$requestLibraryTypeList$1;
        if (continuation instanceof LibraryNetwork$requestLibraryTypeList$1) {
            libraryNetwork$requestLibraryTypeList$1 = (LibraryNetwork$requestLibraryTypeList$1) continuation;
            if ((libraryNetwork$requestLibraryTypeList$1.label & Integer.MIN_VALUE) != 0) {
                libraryNetwork$requestLibraryTypeList$1.label -= Integer.MIN_VALUE;
            } else {
                libraryNetwork$requestLibraryTypeList$1 = new LibraryNetwork$requestLibraryTypeList$1(this, continuation);
            }
        } else {
            libraryNetwork$requestLibraryTypeList$1 = new LibraryNetwork$requestLibraryTypeList$1(this, continuation);
        }
        Object obj = libraryNetwork$requestLibraryTypeList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = libraryNetwork$requestLibraryTypeList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        LibraryNetwork$requestLibraryTypeList$2 libraryNetwork$requestLibraryTypeList$2 = new LibraryNetwork$requestLibraryTypeList$2(str, null);
        libraryNetwork$requestLibraryTypeList$1.label = 1;
        Object obj2 = m485getResultgIAlus(libraryNetwork$requestLibraryTypeList$2, libraryNetwork$requestLibraryTypeList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestLibraryNewRecommendedList-gIAlu-s, reason: not valid java name */
    public final Object m517requestLibraryNewRecommendedListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<LibraryItemBean>>> continuation) {
        LibraryNetwork$requestLibraryNewRecommendedList$1 libraryNetwork$requestLibraryNewRecommendedList$1;
        if (continuation instanceof LibraryNetwork$requestLibraryNewRecommendedList$1) {
            libraryNetwork$requestLibraryNewRecommendedList$1 = (LibraryNetwork$requestLibraryNewRecommendedList$1) continuation;
            if ((libraryNetwork$requestLibraryNewRecommendedList$1.label & Integer.MIN_VALUE) != 0) {
                libraryNetwork$requestLibraryNewRecommendedList$1.label -= Integer.MIN_VALUE;
            } else {
                libraryNetwork$requestLibraryNewRecommendedList$1 = new LibraryNetwork$requestLibraryNewRecommendedList$1(this, continuation);
            }
        } else {
            libraryNetwork$requestLibraryNewRecommendedList$1 = new LibraryNetwork$requestLibraryNewRecommendedList$1(this, continuation);
        }
        Object obj = libraryNetwork$requestLibraryNewRecommendedList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = libraryNetwork$requestLibraryNewRecommendedList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        LibraryNetwork$requestLibraryNewRecommendedList$2 libraryNetwork$requestLibraryNewRecommendedList$2 = new LibraryNetwork$requestLibraryNewRecommendedList$2(requestBody, null);
        libraryNetwork$requestLibraryNewRecommendedList$1.label = 1;
        Object obj2 = m485getResultgIAlus(libraryNetwork$requestLibraryNewRecommendedList$2, libraryNetwork$requestLibraryNewRecommendedList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestLibrarySearch-gIAlu-s, reason: not valid java name */
    public final Object m518requestLibrarySearchgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<LibraryItemBean>>>> continuation) {
        LibraryNetwork$requestLibrarySearch$1 libraryNetwork$requestLibrarySearch$1;
        if (continuation instanceof LibraryNetwork$requestLibrarySearch$1) {
            libraryNetwork$requestLibrarySearch$1 = (LibraryNetwork$requestLibrarySearch$1) continuation;
            if ((libraryNetwork$requestLibrarySearch$1.label & Integer.MIN_VALUE) != 0) {
                libraryNetwork$requestLibrarySearch$1.label -= Integer.MIN_VALUE;
            } else {
                libraryNetwork$requestLibrarySearch$1 = new LibraryNetwork$requestLibrarySearch$1(this, continuation);
            }
        } else {
            libraryNetwork$requestLibrarySearch$1 = new LibraryNetwork$requestLibrarySearch$1(this, continuation);
        }
        Object obj = libraryNetwork$requestLibrarySearch$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = libraryNetwork$requestLibrarySearch$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        LibraryNetwork$requestLibrarySearch$2 libraryNetwork$requestLibrarySearch$2 = new LibraryNetwork$requestLibrarySearch$2(requestBody, null);
        libraryNetwork$requestLibrarySearch$1.label = 1;
        Object obj2 = m485getResultgIAlus(libraryNetwork$requestLibrarySearch$2, libraryNetwork$requestLibrarySearch$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestLibraryBookSituation-gIAlu-s, reason: not valid java name */
    public final Object m514requestLibraryBookSituationgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<LibraryCollectBookSituationBean>>>> continuation) {
        LibraryNetwork$requestLibraryBookSituation$1 libraryNetwork$requestLibraryBookSituation$1;
        if (continuation instanceof LibraryNetwork$requestLibraryBookSituation$1) {
            libraryNetwork$requestLibraryBookSituation$1 = (LibraryNetwork$requestLibraryBookSituation$1) continuation;
            if ((libraryNetwork$requestLibraryBookSituation$1.label & Integer.MIN_VALUE) != 0) {
                libraryNetwork$requestLibraryBookSituation$1.label -= Integer.MIN_VALUE;
            } else {
                libraryNetwork$requestLibraryBookSituation$1 = new LibraryNetwork$requestLibraryBookSituation$1(this, continuation);
            }
        } else {
            libraryNetwork$requestLibraryBookSituation$1 = new LibraryNetwork$requestLibraryBookSituation$1(this, continuation);
        }
        Object obj = libraryNetwork$requestLibraryBookSituation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = libraryNetwork$requestLibraryBookSituation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        LibraryNetwork$requestLibraryBookSituation$2 libraryNetwork$requestLibraryBookSituation$2 = new LibraryNetwork$requestLibraryBookSituation$2(requestBody, null);
        libraryNetwork$requestLibraryBookSituation$1.label = 1;
        Object obj2 = m485getResultgIAlus(libraryNetwork$requestLibraryBookSituation$2, libraryNetwork$requestLibraryBookSituation$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
