package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogFaceSyncBinding implements ViewBinding {
    public final CardView cardView;
    public final ImageView imageView2;
    private final CardView rootView;
    public final SeekBar seekBar;
    public final TextView tvProgress;
    public final TextView tvStatus;

    private DialogFaceSyncBinding(CardView cardView, CardView cardView2, ImageView imageView, SeekBar seekBar, TextView textView, TextView textView2) {
        this.rootView = cardView;
        this.cardView = cardView2;
        this.imageView2 = imageView;
        this.seekBar = seekBar;
        this.tvProgress = textView;
        this.tvStatus = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static DialogFaceSyncBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogFaceSyncBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_face_sync, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogFaceSyncBinding bind(View view) {
        CardView cardView = (CardView) view;
        int i = R.id.imageView2;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);
        if (imageView != null) {
            i = R.id.seekBar;
            SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);
            if (seekBar != null) {
                i = R.id.tvProgress;
                TextView textView = (TextView) view.findViewById(R.id.tvProgress);
                if (textView != null) {
                    i = R.id.tvStatus;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvStatus);
                    if (textView2 != null) {
                        return new DialogFaceSyncBinding(cardView, cardView, imageView, seekBar, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
