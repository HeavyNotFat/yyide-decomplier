package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import moe.codeest.enviews.ENDownloadView;

/* JADX INFO: loaded from: classes4.dex */
public final class VideoLayoutCoverBinding implements ViewBinding {
    public final ImageView back;
    public final ImageView backTiny;
    public final ProgressBar bottomProgressbar;
    public final TextView current;
    public final ImageView fullscreen;
    public final LinearLayout layoutBottom;
    public final LinearLayout layoutTop;
    public final ENDownloadView loading;
    public final ImageView lockScreen;
    public final SeekBar progress;
    private final RelativeLayout rootView;
    public final ImageView smallClose;
    public final ImageView start;
    public final FrameLayout surfaceContainer;
    public final RelativeLayout thumb;
    public final ImageView thumbImage;
    public final TextView title;
    public final TextView total;

    private VideoLayoutCoverBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ProgressBar progressBar, TextView textView, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, ENDownloadView eNDownloadView, ImageView imageView4, SeekBar seekBar, ImageView imageView5, ImageView imageView6, FrameLayout frameLayout, RelativeLayout relativeLayout2, ImageView imageView7, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.back = imageView;
        this.backTiny = imageView2;
        this.bottomProgressbar = progressBar;
        this.current = textView;
        this.fullscreen = imageView3;
        this.layoutBottom = linearLayout;
        this.layoutTop = linearLayout2;
        this.loading = eNDownloadView;
        this.lockScreen = imageView4;
        this.progress = seekBar;
        this.smallClose = imageView5;
        this.start = imageView6;
        this.surfaceContainer = frameLayout;
        this.thumb = relativeLayout2;
        this.thumbImage = imageView7;
        this.title = textView2;
        this.total = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VideoLayoutCoverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VideoLayoutCoverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.video_layout_cover, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static VideoLayoutCoverBinding bind(View view) {
        int i = R.id.back;
        ImageView imageView = (ImageView) view.findViewById(R.id.back);
        if (imageView != null) {
            i = R.id.back_tiny;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.back_tiny);
            if (imageView2 != null) {
                i = R.id.bottom_progressbar;
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
                if (progressBar != null) {
                    i = R.id.current;
                    TextView textView = (TextView) view.findViewById(R.id.current);
                    if (textView != null) {
                        i = R.id.fullscreen;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.fullscreen);
                        if (imageView3 != null) {
                            i = R.id.layout_bottom;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_bottom);
                            if (linearLayout != null) {
                                i = R.id.layout_top;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout_top);
                                if (linearLayout2 != null) {
                                    i = R.id.loading;
                                    ENDownloadView eNDownloadView = (ENDownloadView) view.findViewById(R.id.loading);
                                    if (eNDownloadView != null) {
                                        i = R.id.lock_screen;
                                        ImageView imageView4 = (ImageView) view.findViewById(R.id.lock_screen);
                                        if (imageView4 != null) {
                                            i = R.id.progress;
                                            SeekBar seekBar = (SeekBar) view.findViewById(R.id.progress);
                                            if (seekBar != null) {
                                                i = R.id.small_close;
                                                ImageView imageView5 = (ImageView) view.findViewById(R.id.small_close);
                                                if (imageView5 != null) {
                                                    i = R.id.start;
                                                    ImageView imageView6 = (ImageView) view.findViewById(R.id.start);
                                                    if (imageView6 != null) {
                                                        i = R.id.surface_container;
                                                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.surface_container);
                                                        if (frameLayout != null) {
                                                            i = R.id.thumb;
                                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.thumb);
                                                            if (relativeLayout != null) {
                                                                i = R.id.thumbImage;
                                                                ImageView imageView7 = (ImageView) view.findViewById(R.id.thumbImage);
                                                                if (imageView7 != null) {
                                                                    i = R.id.title;
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.title);
                                                                    if (textView2 != null) {
                                                                        i = R.id.total;
                                                                        TextView textView3 = (TextView) view.findViewById(R.id.total);
                                                                        if (textView3 != null) {
                                                                            return new VideoLayoutCoverBinding((RelativeLayout) view, imageView, imageView2, progressBar, textView, imageView3, linearLayout, linearLayout2, eNDownloadView, imageView4, seekBar, imageView5, imageView6, frameLayout, relativeLayout, imageView7, textView2, textView3);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
