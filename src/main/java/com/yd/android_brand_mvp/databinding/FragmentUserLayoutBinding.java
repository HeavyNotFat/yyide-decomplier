package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUserLayoutBinding implements ViewBinding {
    public final FrameLayout content;
    public final ImageView img;
    public final TextView leaveBtn;
    public final ListView list;
    public final TextView name;
    private final FrameLayout rootView;
    public final TextView subjectName;
    public final TextView subjectName2;
    public final TextView subjectName3;
    public final TextView tableBtn;
    public final TextView teacherName;
    public final TextView tvClassName;

    private FragmentUserLayoutBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, TextView textView, ListView listView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = frameLayout;
        this.content = frameLayout2;
        this.img = imageView;
        this.leaveBtn = textView;
        this.list = listView;
        this.name = textView2;
        this.subjectName = textView3;
        this.subjectName2 = textView4;
        this.subjectName3 = textView5;
        this.tableBtn = textView6;
        this.teacherName = textView7;
        this.tvClassName = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUserLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUserLayoutBinding bind(View view) {
        int i = R.id.content;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
        if (frameLayout != null) {
            i = R.id.img;
            ImageView imageView = (ImageView) view.findViewById(R.id.img);
            if (imageView != null) {
                i = R.id.leave_btn;
                TextView textView = (TextView) view.findViewById(R.id.leave_btn);
                if (textView != null) {
                    i = R.id.list;
                    ListView listView = (ListView) view.findViewById(R.id.list);
                    if (listView != null) {
                        i = R.id.name;
                        TextView textView2 = (TextView) view.findViewById(R.id.name);
                        if (textView2 != null) {
                            i = R.id.subjectName;
                            TextView textView3 = (TextView) view.findViewById(R.id.subjectName);
                            if (textView3 != null) {
                                i = R.id.subjectName2;
                                TextView textView4 = (TextView) view.findViewById(R.id.subjectName2);
                                if (textView4 != null) {
                                    i = R.id.subjectName3;
                                    TextView textView5 = (TextView) view.findViewById(R.id.subjectName3);
                                    if (textView5 != null) {
                                        i = R.id.table_btn;
                                        TextView textView6 = (TextView) view.findViewById(R.id.table_btn);
                                        if (textView6 != null) {
                                            i = R.id.teacherName;
                                            TextView textView7 = (TextView) view.findViewById(R.id.teacherName);
                                            if (textView7 != null) {
                                                i = R.id.tv_class_name;
                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_class_name);
                                                if (textView8 != null) {
                                                    return new FragmentUserLayoutBinding((FrameLayout) view, frameLayout, imageView, textView, listView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
