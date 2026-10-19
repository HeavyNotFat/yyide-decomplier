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
public final class DialogLibraryDetailsLayoutBinding implements ViewBinding {
    public final TextView adress;
    public final TextView author;
    public final TextView bookn;
    public final TextView bookn2;
    public final TextView bookname;
    public final TextView fl;
    public final TextView fx;
    public final TextView ip;
    public final TextView lx;

    /* JADX INFO: renamed from: no, reason: collision with root package name */
    public final TextView f2006no;
    public final ImageView photoView;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final TextView stuas;
    public final TextView time;
    public final TextView xt;

    private DialogLibraryDetailsLayoutBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, ImageView imageView, RecyclerView recyclerView, TextView textView11, TextView textView12, TextView textView13) {
        this.rootView = linearLayout;
        this.adress = textView;
        this.author = textView2;
        this.bookn = textView3;
        this.bookn2 = textView4;
        this.bookname = textView5;
        this.fl = textView6;
        this.fx = textView7;
        this.ip = textView8;
        this.lx = textView9;
        this.f2006no = textView10;
        this.photoView = imageView;
        this.recyclerView = recyclerView;
        this.stuas = textView11;
        this.time = textView12;
        this.xt = textView13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogLibraryDetailsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogLibraryDetailsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_library_details_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogLibraryDetailsLayoutBinding bind(View view) {
        int i = R.id.adress;
        TextView textView = (TextView) view.findViewById(R.id.adress);
        if (textView != null) {
            i = R.id.author;
            TextView textView2 = (TextView) view.findViewById(R.id.author);
            if (textView2 != null) {
                i = R.id.bookn;
                TextView textView3 = (TextView) view.findViewById(R.id.bookn);
                if (textView3 != null) {
                    i = R.id.bookn2;
                    TextView textView4 = (TextView) view.findViewById(R.id.bookn2);
                    if (textView4 != null) {
                        i = R.id.bookname;
                        TextView textView5 = (TextView) view.findViewById(R.id.bookname);
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
                                        i = R.id.lx;
                                        TextView textView9 = (TextView) view.findViewById(R.id.lx);
                                        if (textView9 != null) {
                                            i = R.id.no;
                                            TextView textView10 = (TextView) view.findViewById(R.id.no);
                                            if (textView10 != null) {
                                                i = R.id.photo_view;
                                                ImageView imageView = (ImageView) view.findViewById(R.id.photo_view);
                                                if (imageView != null) {
                                                    i = R.id.recyclerView;
                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                                                    if (recyclerView != null) {
                                                        i = R.id.stuas;
                                                        TextView textView11 = (TextView) view.findViewById(R.id.stuas);
                                                        if (textView11 != null) {
                                                            i = R.id.time;
                                                            TextView textView12 = (TextView) view.findViewById(R.id.time);
                                                            if (textView12 != null) {
                                                                i = R.id.xt;
                                                                TextView textView13 = (TextView) view.findViewById(R.id.xt);
                                                                if (textView13 != null) {
                                                                    return new DialogLibraryDetailsLayoutBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, imageView, recyclerView, textView11, textView12, textView13);
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
