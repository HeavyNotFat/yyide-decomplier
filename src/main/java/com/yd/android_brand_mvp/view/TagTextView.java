package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.yd.android_brand_mvp.R;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TagTextView extends AppCompatTextView {
    private StringBuffer content_buffer;
    private Context mContext;
    private TextView tv_tag;
    private View view;

    public TagTextView(Context context) {
        super(context);
        this.mContext = context;
    }

    public TagTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public TagTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public void setContentAndTag(String str, List<String> list) {
        this.content_buffer = new StringBuffer();
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            this.content_buffer.append(it2.next());
        }
        this.content_buffer.append(str);
        SpannableString spannableString = new SpannableString(this.content_buffer);
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i);
            View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.view_text_tab, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_view_tag);
            this.tv_tag = textView;
            textView.setText(str2);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(convertViewToBitmap(viewInflate));
            bitmapDrawable.setBounds(0, 0, this.tv_tag.getWidth(), this.tv_tag.getHeight());
            ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 0);
            int lastLength = getLastLength(list, i);
            spannableString.setSpan(imageSpan, lastLength, str2.length() + lastLength, 33);
        }
        setText(spannableString);
        setGravity(16);
    }

    private static Bitmap convertViewToBitmap(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    private int getLastLength(List<String> list, int i) {
        int length = 0;
        for (int i2 = 0; i2 < i; i2++) {
            length += list.get(i2).length();
        }
        return length;
    }
}
