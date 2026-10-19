package com.yd.android_brand_mvp.utils;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;

/* JADX INFO: loaded from: classes4.dex */
public class TextViewLinesUtil {
    public static int getTextViewLines(TextView textView, int i) {
        StaticLayout staticLayout;
        int compoundPaddingLeft = (i - textView.getCompoundPaddingLeft()) - textView.getCompoundPaddingRight();
        if (Build.VERSION.SDK_INT >= 23) {
            staticLayout = getStaticLayout23(textView, compoundPaddingLeft);
        } else {
            staticLayout = getStaticLayout(textView, compoundPaddingLeft);
        }
        int lineCount = staticLayout.getLineCount();
        int maxLines = textView.getMaxLines();
        return maxLines > lineCount ? lineCount : maxLines;
    }

    private static StaticLayout getStaticLayout23(TextView textView, int i) {
        StaticLayout.Builder maxLines = StaticLayout.Builder.obtain(textView.getText(), 0, textView.getText().length(), textView.getPaint(), i).setAlignment(Layout.Alignment.ALIGN_NORMAL).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency()).setMaxLines(textView.getMaxLines() == -1 ? Integer.MAX_VALUE : textView.getMaxLines());
        if (Build.VERSION.SDK_INT >= 26) {
            maxLines.setJustificationMode(textView.getJustificationMode());
        }
        if (textView.getEllipsize() != null && textView.getKeyListener() == null) {
            maxLines.setEllipsize(textView.getEllipsize()).setEllipsizedWidth(i);
        }
        return maxLines.build();
    }

    private static StaticLayout getStaticLayout(TextView textView, int i) {
        return new StaticLayout(textView.getText(), 0, textView.getText().length(), textView.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding(), textView.getEllipsize(), i);
    }
}
