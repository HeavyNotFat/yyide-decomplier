package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentLeaveBinding implements ViewBinding {
    public final YDEditText etContent;
    public final ListView list;
    public final RadioButton rb1;
    public final RadioButton rb2;
    public final RadioButton rb3;
    public final RecyclerView rcLeave;
    public final RadioGroup rgLab;
    private final LinearLayout rootView;
    public final TextView titleName;
    public final TextView tvEndTime;
    public final TextView tvStartTime;
    public final TextView tvSubmit;

    private FragmentLeaveBinding(LinearLayout linearLayout, YDEditText yDEditText, ListView listView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RecyclerView recyclerView, RadioGroup radioGroup, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.etContent = yDEditText;
        this.list = listView;
        this.rb1 = radioButton;
        this.rb2 = radioButton2;
        this.rb3 = radioButton3;
        this.rcLeave = recyclerView;
        this.rgLab = radioGroup;
        this.titleName = textView;
        this.tvEndTime = textView2;
        this.tvStartTime = textView3;
        this.tvSubmit = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLeaveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLeaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_leave, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLeaveBinding bind(View view) {
        int i = R.id.et_content;
        YDEditText yDEditText = (YDEditText) view.findViewById(R.id.et_content);
        if (yDEditText != null) {
            i = R.id.list;
            ListView listView = (ListView) view.findViewById(R.id.list);
            if (listView != null) {
                i = R.id.rb_1;
                RadioButton radioButton = (RadioButton) view.findViewById(R.id.rb_1);
                if (radioButton != null) {
                    i = R.id.rb_2;
                    RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.rb_2);
                    if (radioButton2 != null) {
                        i = R.id.rb_3;
                        RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.rb_3);
                        if (radioButton3 != null) {
                            i = R.id.rc_leave;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rc_leave);
                            if (recyclerView != null) {
                                i = R.id.rg_lab;
                                RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg_lab);
                                if (radioGroup != null) {
                                    i = R.id.title_Name;
                                    TextView textView = (TextView) view.findViewById(R.id.title_Name);
                                    if (textView != null) {
                                        i = R.id.tv_end_time;
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_end_time);
                                        if (textView2 != null) {
                                            i = R.id.tv_start_time;
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_start_time);
                                            if (textView3 != null) {
                                                i = R.id.tv_submit;
                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_submit);
                                                if (textView4 != null) {
                                                    return new FragmentLeaveBinding((LinearLayout) view, yDEditText, listView, radioButton, radioButton2, radioButton3, recyclerView, radioGroup, textView, textView2, textView3, textView4);
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
