package com.yd.android_brand_mvp.utils;

import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.model.userspace.LeaveTypeBean;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MMKVUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0014\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/utils/MMKVUtil;", "", "()V", "DOMINATE_CUSTOM_DATA", "", "DOMINATE_EXAM_DATA", "DOMINATE_RESERVATION_DATA", "DOMINATE_SCREEN_DATA", "KEY_DOMINATE_LEVEL", "LEAVE_TYPE_LIST", "mmkvInstance", "Lcom/tencent/mmkv/MMKV;", "kotlin.jvm.PlatformType", "getMmkvInstance", "()Lcom/tencent/mmkv/MMKV;", "mmkvInstance$delegate", "Lkotlin/Lazy;", "getDominateLevel", "getDominateScreenData", "id", "getLeaveTypeList", "", "Lcom/yd/android_brand_mvp/model/userspace/LeaveTypeBean;", "saveDominateLevel", "", "dominateLevel", "saveDominateScreenData", "dataJson", "saveLeaveTypeList", "leaveTypeList", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MMKVUtil {
    public static final String DOMINATE_CUSTOM_DATA = "dominate_custom_data_new";
    public static final String DOMINATE_EXAM_DATA = "dominate_exam_data";
    public static final String DOMINATE_RESERVATION_DATA = "dominate_reservation_data";
    private static final String DOMINATE_SCREEN_DATA = "dominate_screen_data";
    public static final String KEY_DOMINATE_LEVEL = "key_dominate_level_new";
    public static final String LEAVE_TYPE_LIST = "leave_type_list";
    public static final MMKVUtil INSTANCE = new MMKVUtil();

    /* JADX INFO: renamed from: mmkvInstance$delegate, reason: from kotlin metadata */
    private static final Lazy mmkvInstance = LazyKt.lazy(new Function0<MMKV>() { // from class: com.yd.android_brand_mvp.utils.MMKVUtil$mmkvInstance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.defaultMMKV();
        }
    });

    private MMKVUtil() {
    }

    private final MMKV getMmkvInstance() {
        return (MMKV) mmkvInstance.getValue();
    }

    public final void saveDominateScreenData(String dataJson, String id) {
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        Intrinsics.checkNotNullParameter(id, "id");
        getMmkvInstance().encode("dominate_screen_data/" + id, dataJson);
    }

    public final String getDominateScreenData(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        String strDecodeString = getMmkvInstance().decodeString("dominate_screen_data/" + id);
        String str = strDecodeString;
        if (str == null || str.length() == 0) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(strDecodeString, "{\n            dataJson\n        }");
        return strDecodeString;
    }

    public final void saveDominateLevel(String dominateLevel) {
        Intrinsics.checkNotNullParameter(dominateLevel, "dominateLevel");
        getMmkvInstance().encode("key_dominate_level_new/" + SpData.getBrandId(), dominateLevel);
    }

    public final String getDominateLevel() {
        String strDecodeString = getMmkvInstance().decodeString("key_dominate_level_new/" + SpData.getBrandId());
        return strDecodeString == null ? "" : strDecodeString;
    }

    public final void saveLeaveTypeList(List<LeaveTypeBean> leaveTypeList) {
        Intrinsics.checkNotNullParameter(leaveTypeList, "leaveTypeList");
        getMmkvInstance().encode(LEAVE_TYPE_LIST, GsonUtils.toJson(leaveTypeList));
    }

    public final List<LeaveTypeBean> getLeaveTypeList() {
        String str = getMmkvInstance().decodeString(LEAVE_TYPE_LIST, "");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(str, "str");
        if (str.length() > 0) {
            List formatList = (List) GsonUtils.fromJson(str, new TypeToken<List<? extends LeaveTypeBean>>() { // from class: com.yd.android_brand_mvp.utils.MMKVUtil$getLeaveTypeList$formatList$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(formatList, "formatList");
            arrayList.addAll(formatList);
        }
        return arrayList;
    }
}
