package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.contrarywind.view.WheelView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUniversityMusicTableBinding implements ViewBinding {
    public final ImageView imageView3;
    public final ImageView ivLeft;
    public final ImageView ivRight;
    private final ConstraintLayout rootView;
    public final TextView tvEndTime;
    public final TextView tvStartTime;
    public final TextView tvTableName;
    public final TextView tvTime;
    public final WheelView wheelView;

    private FragmentUniversityMusicTableBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, WheelView wheelView) {
        this.rootView = constraintLayout;
        this.imageView3 = imageView;
        this.ivLeft = imageView2;
        this.ivRight = imageView3;
        this.tvEndTime = textView;
        this.tvStartTime = textView2;
        this.tvTableName = textView3;
        this.tvTime = textView4;
        this.wheelView = wheelView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUniversityMusicTableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUniversityMusicTableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_university_music_table, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUniversityMusicTableBinding bind(View view) {
        int i = R.id.imageView3;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView3);
        if (imageView != null) {
            i = R.id.ivLeft;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.ivLeft);
            if (imageView2 != null) {
                i = R.id.ivRight;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.ivRight);
                if (imageView3 != null) {
                    i = R.id.tvEndTime;
                    TextView textView = (TextView) view.findViewById(R.id.tvEndTime);
                    if (textView != null) {
                        i = R.id.tvStartTime;
                        TextView textView2 = (TextView) view.findViewById(R.id.tvStartTime);
                        if (textView2 != null) {
                            i = R.id.tvTableName;
                            TextView textView3 = (TextView) view.findViewById(R.id.tvTableName);
                            if (textView3 != null) {
                                i = R.id.tvTime;
                                TextView textView4 = (TextView) view.findViewById(R.id.tvTime);
                                if (textView4 != null) {
                                    i = R.id.wheelView;
                                    WheelView wheelView = (WheelView) view.findViewById(R.id.wheelView);
                                    if (wheelView != null) {
                                        return new FragmentUniversityMusicTableBinding((ConstraintLayout) view, imageView, imageView2, imageView3, textView, textView2, textView3, textView4, wheelView);
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
