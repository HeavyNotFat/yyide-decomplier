package com.yd.android_brand_mvp.utils;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AnncouncementUtils {
    public static void setHtmlToTextView(TextView textView, String str) {
        Spanned spannedFromHtml;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            spannedFromHtml = Html.fromHtml(str, 0);
        } else {
            spannedFromHtml = Html.fromHtml(str);
        }
        textView.setText(spannedFromHtml);
    }

    public static ArrayList<String> getImageUrl(List<getNoticeRsp.DataDTO.RecordsDTO.detailsBean> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        Iterator<getNoticeRsp.DataDTO.RecordsDTO.detailsBean> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().coverImg);
        }
        return arrayList;
    }
}
