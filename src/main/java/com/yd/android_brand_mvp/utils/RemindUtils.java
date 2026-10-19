package com.yd.android_brand_mvp.utils;

import com.yd.android_brand_mvp.adapter.attence.RuleUtils;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.NewRemindRsp;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RemindUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/utils/RemindUtils;", "", "()V", "getRemindData", "Lcom/yd/android_brand_mvp/model/NewRemindRsp$DataDTO;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RemindUtils {
    public static final RemindUtils INSTANCE = new RemindUtils();

    private RemindUtils() {
    }

    public final NewRemindRsp.DataDTO getRemindData() {
        NewRemindRsp voiceData = SpData.getVoiceData();
        if ((voiceData != null ? voiceData.data : null) != null) {
            KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsRemindTable = RuleUtils.getInstance().isRemindTable();
            String week = Tool.getWeek3(System.currentTimeMillis());
            Iterator<NewRemindRsp.DataDTO> it2 = voiceData.data.iterator();
            while (it2.hasNext()) {
                NewRemindRsp.DataDTO next = it2.next();
                if (timetableListDTOIsRemindTable != null) {
                    if (Intrinsics.areEqual("1", next.type)) {
                        if (TimeUtil.isvoice(next.duration, timetableListDTOIsRemindTable.startTime, next.time)) {
                            return next;
                        }
                    } else if (Intrinsics.areEqual("2", next.type) && TimeUtil.isvoice(next.duration, timetableListDTOIsRemindTable.endTime, next.time)) {
                        return next;
                    }
                }
                if (Intrinsics.areEqual("3", next.type) || Intrinsics.areEqual("4", next.type) || Intrinsics.areEqual(ConversionUtil.conditionWithSeriesName, next.type) || Intrinsics.areEqual(ConversionUtil.conditionWithCallNumber, next.type)) {
                    String str = next.remindWeek;
                    Intrinsics.checkNotNullExpressionValue(str, "datum.remindWeek");
                    Intrinsics.checkNotNullExpressionValue(week, "week");
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) week, false, 2, (Object) null)) {
                        boolean zIsvoice2 = TimeUtil.isvoice2(next.duration, next.remindTime, next.time);
                        boolean zIsvoice = TimeUtil.isvoice(next.duration, next.remindTime, next.time);
                        if (zIsvoice2 || zIsvoice) {
                            return next;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }
}
