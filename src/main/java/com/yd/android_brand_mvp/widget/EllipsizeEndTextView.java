package com.yd.android_brand_mvp.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: compiled from: EllipsizeEndTextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\nJ\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/widget/EllipsizeEndTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mFullText", "", "mLineAddVertPad", "", "mLineSpacingMult", "mNeedEllipsize", "", "createWorkingLayout", "Landroid/text/Layout;", "workingText", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "resetText", "setFullText", "text", "setLineSpacing", "add", "mult", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EllipsizeEndTextView extends AppCompatTextView {
    private static final String ELLIPSIS = "…";
    private String mFullText;
    private float mLineAddVertPad;
    private float mLineSpacingMult;
    private boolean mNeedEllipsize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EllipsizeEndTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EllipsizeEndTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ EllipsizeEndTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.textViewStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EllipsizeEndTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFullText = "";
        this.mLineSpacingMult = 1.0f;
    }

    public final void setFullText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.mFullText = text;
        this.mNeedEllipsize = true;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float add, float mult) {
        this.mLineAddVertPad = add;
        this.mLineSpacingMult = mult;
        super.setLineSpacing(add, mult);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mNeedEllipsize) {
            super.setEllipsize(null);
            resetText();
        }
        super.onDraw(canvas);
    }

    private final void resetText() {
        int length;
        int maxLines = getMaxLines();
        String str = this.mFullText;
        if (maxLines != -1) {
            Layout layoutCreateWorkingLayout = createWorkingLayout(str);
            if (layoutCreateWorkingLayout.getLineCount() > maxLines) {
                String strSubstring = this.mFullText.substring(0, layoutCreateWorkingLayout.getLineEnd(maxLines - 1));
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                while (true) {
                    if (createWorkingLayout(strSubstring + Typography.ellipsis).getLineCount() <= maxLines || (length = strSubstring.length() - 1) <= 0) {
                        break;
                    }
                    strSubstring = strSubstring.substring(0, length);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                str = strSubstring + Typography.ellipsis;
            }
        }
        setText(str);
        this.mNeedEllipsize = false;
    }

    private final Layout createWorkingLayout(CharSequence workingText) {
        return new StaticLayout(workingText, getPaint(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.mLineSpacingMult, this.mLineAddVertPad, false);
    }
}
