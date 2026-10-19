package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.snackbar.Snackbar;
import com.yd.android_brand_mvp.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SimpleUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001\u001a\n\u0010\n\u001a\u00020\u0005*\u00020\u0006\u001ax\u0010\u000b\u001a\u00020\u0005*\u00020\f2f\b\u0004\u0010\r\u001a`\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u000eH\u0086\bø\u0001\u0000\u001a \u0010\u0017\u001a\u00020\u0005*\u00020\u00062\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H\u0086\bø\u0001\u0000\u001a\n\u0010\u0019\u001a\u00020\u0005*\u00020\u0006\u001a\u0012\u0010\u001a\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b\u001a\u0012\u0010\u001c\u001a\u00020\u0005*\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\b\u001a\u0012\u0010\u001e\u001a\u00020\u0005*\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\b\u001a\u0012\u0010\u001f\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b\u001a\u0012\u0010 \u001a\u00020\u0005*\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\b\u001a(\u0010!\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"asColor", "", "asDrawable", "Landroid/graphics/drawable/Drawable;", "hide", "", "Landroid/view/View;", "maxLength", "", SessionDescription.ATTR_LENGTH, "remove", "setSafeItemListener", "Landroid/widget/GridView;", "action", "Lkotlin/Function4;", "Landroid/widget/AdapterView;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "parent", "view", "position", "", "id", "setSafeListener", "Lkotlin/Function0;", "show", "showLongSnackBar", "message", "showLongToast", "Landroid/content/Context;", "showLongToastInCenter", "showShotSnackBar", "showShotToast", "snackBarWithAction", "actionLabel", "block", "app_commonRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SimpleUtilsKt {
    public static final void show(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
    }

    public static final void hide(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(4);
    }

    public static final void remove(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(8);
    }

    public static final String maxLength(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append("...");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "cutSb.toString()");
        return string;
    }

    public static final void showShotToast(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Toast.makeText(context, message, 0).show();
    }

    public static final void showLongToast(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Toast.makeText(context, message, 1).show();
    }

    public static final void showLongToastInCenter(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Toast toastMakeText = Toast.makeText(context, message, 1);
        toastMakeText.setGravity(17, 0, 0);
        toastMakeText.show();
    }

    public static final void showShotSnackBar(View view, String message) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Snackbar.make(view, message, -1).show();
    }

    public static final void showLongSnackBar(View view, String message) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Snackbar.make(view, message, 0).show();
    }

    public static final void snackBarWithAction(View view, String message, String actionLabel, final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(actionLabel, "actionLabel");
        Intrinsics.checkNotNullParameter(block, "block");
        Snackbar.make(view, message, 0).setAction(actionLabel, new View.OnClickListener() { // from class: com.yd.android_brand_mvp.utils.-$$Lambda$SimpleUtilsKt$q8nCS8YCkARblP_zaDsuxfIhDCY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SimpleUtilsKt.snackBarWithAction$lambda$0(block, view2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void snackBarWithAction$lambda$0(Function0 block, View view) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    public static final void setSafeListener(View view, final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final Ref.LongRef longRef = new Ref.LongRef();
        view.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.utils.SimpleUtilsKt.setSafeListener.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long jCurrentTimeMillis = System.currentTimeMillis() - longRef.element;
                longRef.element = System.currentTimeMillis();
                if (jCurrentTimeMillis < 500) {
                    return;
                }
                action.invoke();
            }
        });
    }

    public static final void setSafeItemListener(GridView gridView, final Function4<? super AdapterView<?>, ? super View, ? super Integer, ? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(gridView, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final Ref.LongRef longRef = new Ref.LongRef();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.utils.SimpleUtilsKt.setSafeItemListener.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> parent, View view, int i, long j) {
                long jCurrentTimeMillis = System.currentTimeMillis() - longRef.element;
                longRef.element = System.currentTimeMillis();
                if (jCurrentTimeMillis < 1000) {
                    return;
                }
                Function4<AdapterView<?>, View, Integer, Long, Unit> function4 = action;
                Intrinsics.checkNotNullExpressionValue(parent, "parent");
                Intrinsics.checkNotNullExpressionValue(view, "view");
                function4.invoke(parent, view, Integer.valueOf(i), Long.valueOf(j));
            }
        });
    }

    public static final int asColor(int i) {
        return ContextCompat.getColor(BaseApplication.getInstance(), i);
    }

    public static final Drawable asDrawable(int i) {
        return ContextCompat.getDrawable(BaseApplication.getInstance(), i);
    }
}
