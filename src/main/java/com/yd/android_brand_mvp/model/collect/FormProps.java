package com.yd.android_brand_mvp.model.collect;

import androidx.room.RoomDatabase;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: FormProps.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b:\b\u0086\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u0012\u001a\b\u0002\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00190\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\u001dJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u000eHÆ\u0003J\t\u0010A\u001a\u00020\u000eHÆ\u0003J\u001b\u0010B\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00190\u0018HÆ\u0003J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\fHÆ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\fHÆ\u0003J\t\u0010M\u001a\u00020\u000eHÆ\u0003Jù\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\u001a\b\u0002\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00190\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0001J\u0013\u0010O\u001a\u00020\u00032\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020\u000eHÖ\u0001J\t\u0010R\u001a\u00020\fHÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR#\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010'\"\u0004\b6\u00107R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001f¨\u0006S"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/FormProps;", "", "imageOnly", "", "showLength", "expanding", "options", "", "enablePrint", "required", "isCondition", IjkMediaMeta.IJKM_KEY_FORMAT, "", "showRule", "", "autoLocate", "automaticPositioning", "showSummary", "rowLayout", "maxSize", "showBorder", "maxlength", "precision", "showExpression", "", "", "selectUIType", "placeholder", "ranges", "(ZZZLjava/util/List;ZZZLjava/lang/String;IZZZZIZIILjava/util/Map;ILjava/lang/String;Ljava/util/List;)V", "getAutoLocate", "()Z", "getAutomaticPositioning", "getEnablePrint", "getExpanding", "getFormat", "()Ljava/lang/String;", "getImageOnly", "getMaxSize", "()I", "getMaxlength", "getOptions", "()Ljava/util/List;", "getPlaceholder", "getPrecision", "getRanges", "getRequired", "getRowLayout", "getSelectUIType", "getShowBorder", "getShowExpression", "()Ljava/util/Map;", "getShowLength", "getShowRule", "setShowRule", "(I)V", "getShowSummary", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FormProps {
    private final boolean autoLocate;
    private final boolean automaticPositioning;
    private final boolean enablePrint;
    private final boolean expanding;
    private final String format;
    private final boolean imageOnly;
    private final boolean isCondition;
    private final int maxSize;
    private final int maxlength;
    private final List<Object> options;
    private final String placeholder;
    private final int precision;
    private final List<String> ranges;
    private final boolean required;
    private final boolean rowLayout;
    private final int selectUIType;
    private final boolean showBorder;
    private final Map<String, List<String>> showExpression;
    private final boolean showLength;
    private int showRule;
    private final boolean showSummary;

    public FormProps() {
        this(false, false, false, null, false, false, false, null, 0, false, false, false, false, 0, false, 0, 0, null, 0, null, null, 2097151, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getImageOnly() {
        return this.imageOnly;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getAutoLocate() {
        return this.autoLocate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getAutomaticPositioning() {
        return this.automaticPositioning;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getShowSummary() {
        return this.showSummary;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getRowLayout() {
        return this.rowLayout;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getMaxSize() {
        return this.maxSize;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getShowBorder() {
        return this.showBorder;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getMaxlength() {
        return this.maxlength;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getPrecision() {
        return this.precision;
    }

    public final Map<String, List<String>> component18() {
        return this.showExpression;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getSelectUIType() {
        return this.selectUIType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowLength() {
        return this.showLength;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final List<String> component21() {
        return this.ranges;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getExpanding() {
        return this.expanding;
    }

    public final List<Object> component4() {
        return this.options;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getEnablePrint() {
        return this.enablePrint;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsCondition() {
        return this.isCondition;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getShowRule() {
        return this.showRule;
    }

    public final FormProps copy(boolean imageOnly, boolean showLength, boolean expanding, List<Object> options, boolean enablePrint, boolean required, boolean isCondition, String format, int showRule, boolean autoLocate, boolean automaticPositioning, boolean showSummary, boolean rowLayout, int maxSize, boolean showBorder, int maxlength, int precision, Map<String, ? extends List<String>> showExpression, int selectUIType, String placeholder, List<String> ranges) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(showExpression, "showExpression");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        return new FormProps(imageOnly, showLength, expanding, options, enablePrint, required, isCondition, format, showRule, autoLocate, automaticPositioning, showSummary, rowLayout, maxSize, showBorder, maxlength, precision, showExpression, selectUIType, placeholder, ranges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormProps)) {
            return false;
        }
        FormProps formProps = (FormProps) other;
        return this.imageOnly == formProps.imageOnly && this.showLength == formProps.showLength && this.expanding == formProps.expanding && Intrinsics.areEqual(this.options, formProps.options) && this.enablePrint == formProps.enablePrint && this.required == formProps.required && this.isCondition == formProps.isCondition && Intrinsics.areEqual(this.format, formProps.format) && this.showRule == formProps.showRule && this.autoLocate == formProps.autoLocate && this.automaticPositioning == formProps.automaticPositioning && this.showSummary == formProps.showSummary && this.rowLayout == formProps.rowLayout && this.maxSize == formProps.maxSize && this.showBorder == formProps.showBorder && this.maxlength == formProps.maxlength && this.precision == formProps.precision && Intrinsics.areEqual(this.showExpression, formProps.showExpression) && this.selectUIType == formProps.selectUIType && Intrinsics.areEqual(this.placeholder, formProps.placeholder) && Intrinsics.areEqual(this.ranges, formProps.ranges);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean z = this.imageOnly;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.showLength;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z3 = this.expanding;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int iHashCode = (((i2 + r3) * 31) + this.options.hashCode()) * 31;
        boolean z4 = this.enablePrint;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (iHashCode + r4) * 31;
        boolean z5 = this.required;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (i3 + r5) * 31;
        boolean z6 = this.isCondition;
        ?? r6 = z6;
        if (z6) {
            r6 = 1;
        }
        int iHashCode2 = (((((i4 + r6) * 31) + this.format.hashCode()) * 31) + this.showRule) * 31;
        boolean z7 = this.autoLocate;
        ?? r7 = z7;
        if (z7) {
            r7 = 1;
        }
        int i5 = (iHashCode2 + r7) * 31;
        boolean z8 = this.automaticPositioning;
        ?? r8 = z8;
        if (z8) {
            r8 = 1;
        }
        int i6 = (i5 + r8) * 31;
        boolean z9 = this.showSummary;
        ?? r9 = z9;
        if (z9) {
            r9 = 1;
        }
        int i7 = (i6 + r9) * 31;
        boolean z10 = this.rowLayout;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        int i8 = (((i7 + r10) * 31) + this.maxSize) * 31;
        boolean z11 = this.showBorder;
        return ((((((((((((i8 + (z11 ? 1 : z11)) * 31) + this.maxlength) * 31) + this.precision) * 31) + this.showExpression.hashCode()) * 31) + this.selectUIType) * 31) + this.placeholder.hashCode()) * 31) + this.ranges.hashCode();
    }

    public String toString() {
        return "FormProps(imageOnly=" + this.imageOnly + ", showLength=" + this.showLength + ", expanding=" + this.expanding + ", options=" + this.options + ", enablePrint=" + this.enablePrint + ", required=" + this.required + ", isCondition=" + this.isCondition + ", format=" + this.format + ", showRule=" + this.showRule + ", autoLocate=" + this.autoLocate + ", automaticPositioning=" + this.automaticPositioning + ", showSummary=" + this.showSummary + ", rowLayout=" + this.rowLayout + ", maxSize=" + this.maxSize + ", showBorder=" + this.showBorder + ", maxlength=" + this.maxlength + ", precision=" + this.precision + ", showExpression=" + this.showExpression + ", selectUIType=" + this.selectUIType + ", placeholder=" + this.placeholder + ", ranges=" + this.ranges + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FormProps(boolean z, boolean z2, boolean z3, List<Object> options, boolean z4, boolean z5, boolean z6, String format, int i, boolean z7, boolean z8, boolean z9, boolean z10, int i2, boolean z11, int i3, int i4, Map<String, ? extends List<String>> showExpression, int i5, String placeholder, List<String> ranges) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(showExpression, "showExpression");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        this.imageOnly = z;
        this.showLength = z2;
        this.expanding = z3;
        this.options = options;
        this.enablePrint = z4;
        this.required = z5;
        this.isCondition = z6;
        this.format = format;
        this.showRule = i;
        this.autoLocate = z7;
        this.automaticPositioning = z8;
        this.showSummary = z9;
        this.rowLayout = z10;
        this.maxSize = i2;
        this.showBorder = z11;
        this.maxlength = i3;
        this.precision = i4;
        this.showExpression = showExpression;
        this.selectUIType = i5;
        this.placeholder = placeholder;
        this.ranges = ranges;
    }

    public final boolean getImageOnly() {
        return this.imageOnly;
    }

    public final boolean getShowLength() {
        return this.showLength;
    }

    public final boolean getExpanding() {
        return this.expanding;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FormProps(boolean z, boolean z2, boolean z3, List list, boolean z4, boolean z5, boolean z6, String str, int i, boolean z7, boolean z8, boolean z9, boolean z10, int i2, boolean z11, int i3, int i4, Map map, int i5, String str2, List list2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        String notSecondFormat;
        boolean z12 = (i6 & 1) != 0 ? false : z;
        boolean z13 = (i6 & 2) != 0 ? false : z2;
        boolean z14 = (i6 & 4) != 0 ? false : z3;
        ArrayList arrayList = (i6 & 8) != 0 ? new ArrayList() : list;
        boolean z15 = (i6 & 16) != 0 ? false : z4;
        boolean z16 = (i6 & 32) != 0 ? false : z5;
        boolean z17 = (i6 & 64) != 0 ? false : z6;
        if ((i6 & 128) != 0) {
            notSecondFormat = TimeUtil.notSecondFormat;
            Intrinsics.checkNotNullExpressionValue(notSecondFormat, "notSecondFormat");
        } else {
            notSecondFormat = str;
        }
        this(z12, z13, z14, arrayList, z15, z16, z17, notSecondFormat, (i6 & 256) != 0 ? 0 : i, (i6 & 512) != 0 ? true : z7, (i6 & 1024) != 0 ? false : z8, (i6 & 2048) != 0 ? false : z9, (i6 & 4096) != 0 ? false : z10, (i6 & 8192) != 0 ? 0 : i2, (i6 & 16384) != 0 ? false : z11, (i6 & 32768) != 0 ? RoomDatabase.MAX_BIND_PARAMETER_CNT : i3, (i6 & 65536) != 0 ? 0 : i4, (i6 & 131072) != 0 ? new LinkedHashMap() : map, (i6 & 262144) != 0 ? 0 : i5, (i6 & 524288) != 0 ? "" : str2, (i6 & 1048576) != 0 ? new ArrayList() : list2);
    }

    public final List<Object> getOptions() {
        return this.options;
    }

    public final boolean getEnablePrint() {
        return this.enablePrint;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final boolean isCondition() {
        return this.isCondition;
    }

    public final String getFormat() {
        return this.format;
    }

    public final int getShowRule() {
        return this.showRule;
    }

    public final void setShowRule(int i) {
        this.showRule = i;
    }

    public final boolean getAutoLocate() {
        return this.autoLocate;
    }

    public final boolean getAutomaticPositioning() {
        return this.automaticPositioning;
    }

    public final boolean getShowSummary() {
        return this.showSummary;
    }

    public final boolean getRowLayout() {
        return this.rowLayout;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public final boolean getShowBorder() {
        return this.showBorder;
    }

    public final int getMaxlength() {
        return this.maxlength;
    }

    public final int getPrecision() {
        return this.precision;
    }

    public final Map<String, List<String>> getShowExpression() {
        return this.showExpression;
    }

    public final int getSelectUIType() {
        return this.selectUIType;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final List<String> getRanges() {
        return this.ranges;
    }
}
