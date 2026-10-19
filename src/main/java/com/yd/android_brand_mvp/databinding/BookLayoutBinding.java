package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class BookLayoutBinding implements ViewBinding {
    public final TextView author;
    public final TextView bookn;
    public final TextView bookn2;
    public final TextView bookname;
    public final TextView bq;
    public final TextView fl;
    public final TextView fx;
    public final TextView ip;
    public final TextView jy;
    public final ImageView photoView;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final TextView time;
    public final TextView xt;
    public final TextView zt;

    private BookLayoutBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ImageView imageView, RecyclerView recyclerView, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = linearLayout;
        this.author = textView;
        this.bookn = textView2;
        this.bookn2 = textView3;
        this.bookname = textView4;
        this.bq = textView5;
        this.fl = textView6;
        this.fx = textView7;
        this.ip = textView8;
        this.jy = textView9;
        this.photoView = imageView;
        this.recyclerView = recyclerView;
        this.time = textView10;
        this.xt = textView11;
        this.zt = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BookLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BookLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.book_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BookLayoutBinding bind(View view) {
        int i = R.id.author;
        TextView textView = (TextView) view.findViewById(R.id.author);
        if (textView != null) {
            i = R.id.bookn;
            TextView textView2 = (TextView) view.findViewById(R.id.bookn);
            if (textView2 != null) {
                i = R.id.bookn2;
                TextView textView3 = (TextView) view.findViewById(R.id.bookn2);
                if (textView3 != null) {
                    i = R.id.bookname;
                    TextView textView4 = (TextView) view.findViewById(R.id.bookname);
                    if (textView4 != null) {
                        i = R.id.bq;
                        TextView textView5 = (TextView) view.findViewById(R.id.bq);
                        if (textView5 != null) {
                            i = R.id.fl;
                            TextView textView6 = (TextView) view.findViewById(R.id.fl);
                            if (textView6 != null) {
                                i = R.id.fx;
                                TextView textView7 = (TextView) view.findViewById(R.id.fx);
                                if (textView7 != null) {
                                    i = R.id.ip;
                                    TextView textView8 = (TextView) view.findViewById(R.id.ip);
                                    if (textView8 != null) {
                                        i = R.id.jy;
                                        TextView textView9 = (TextView) view.findViewById(R.id.jy);
                                        if (textView9 != null) {
                                            i = R.id.photo_view;
                                            ImageView imageView = (ImageView) view.findViewById(R.id.photo_view);
                                            if (imageView != null) {
                                                i = R.id.recyclerView;
                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                                                if (recyclerView != null) {
                                                    i = R.id.time;
                                                    TextView textView10 = (TextView) view.findViewById(R.id.time);
                                                    if (textView10 != null) {
                                                        i = R.id.xt;
                                                        TextView textView11 = (TextView) view.findViewById(R.id.xt);
                                                        if (textView11 != null) {
                                                            i = R.id.zt;
                                                            TextView textView12 = (TextView) view.findViewById(R.id.zt);
                                                            if (textView12 != null) {
                                                                return new BookLayoutBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, imageView, recyclerView, textView10, textView11, textView12);
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
