package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.graphics.Typeface;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontsUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0001H\u0002J\u0006\u0010\u000e\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/utils/FontsUtils;", "", "()V", "fontPath", "", "createTypeface", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "replaceSystemDefaultFont", "", "replaceTypefaceField", "fieldName", "value", "typeFaceDefault", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontsUtils {
    public static final FontsUtils INSTANCE = new FontsUtils();
    public static final String fontPath = "fonts/JingNanMaiYuanTi.ttf";

    private FontsUtils() {
    }

    public final void replaceSystemDefaultFont(Context context, String fontPath2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fontPath2, "fontPath");
        replaceTypefaceField("MONOSPACE", createTypeface(context, fontPath2));
    }

    private final Typeface createTypeface(Context context, String fontPath2) {
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), fontPath2);
        Intrinsics.checkNotNullExpressionValue(typefaceCreateFromAsset, "createFromAsset(context.assets, fontPath)");
        return typefaceCreateFromAsset;
    }

    public final void typeFaceDefault() {
        Typeface typeface = Typeface.create(Typeface.DEFAULT, 0);
        Intrinsics.checkNotNullExpressionValue(typeface, "typeface");
        replaceTypefaceField("MONOSPACE", typeface);
    }

    private final void replaceTypefaceField(String fieldName, Object value) {
        try {
            Field declaredField = Typeface.class.getDeclaredField(fieldName);
            Intrinsics.checkNotNullExpressionValue(declaredField, "Typeface::class.java.getDeclaredField(fieldName)");
            declaredField.setAccessible(true);
            declaredField.set(null, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
}
