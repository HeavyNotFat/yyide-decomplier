package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewCollectFormLocationBinding implements ViewBinding {
    public final ConstraintLayout clViewCollectFormLocation;
    public final ConstraintLayout clViewCollectFormLocationArea;
    public final ConstraintLayout clViewCollectFormLocationCity;
    public final ConstraintLayout clViewCollectFormLocationProvince;
    public final EditText etViewCollectFormLocationAddress;
    private final ConstraintLayout rootView;
    public final TextView tvViewCollectFormLocationArea;
    public final TextView tvViewCollectFormLocationAreaTip;
    public final TextView tvViewCollectFormLocationCity;
    public final TextView tvViewCollectFormLocationCityTip;
    public final TextView tvViewCollectFormLocationName;
    public final TextView tvViewCollectFormLocationProvince;
    public final TextView tvViewCollectFormLocationProvinceTip;
    public final TextView tvViewCollectFormLocationRequired;

    private ViewCollectFormLocationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, EditText editText, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.clViewCollectFormLocation = constraintLayout2;
        this.clViewCollectFormLocationArea = constraintLayout3;
        this.clViewCollectFormLocationCity = constraintLayout4;
        this.clViewCollectFormLocationProvince = constraintLayout5;
        this.etViewCollectFormLocationAddress = editText;
        this.tvViewCollectFormLocationArea = textView;
        this.tvViewCollectFormLocationAreaTip = textView2;
        this.tvViewCollectFormLocationCity = textView3;
        this.tvViewCollectFormLocationCityTip = textView4;
        this.tvViewCollectFormLocationName = textView5;
        this.tvViewCollectFormLocationProvince = textView6;
        this.tvViewCollectFormLocationProvinceTip = textView7;
        this.tvViewCollectFormLocationRequired = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_location, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormLocationBinding bind(View view) {
        int i = R.id.cl_view_collect_form_location;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_view_collect_form_location);
        if (constraintLayout != null) {
            i = R.id.cl_view_collect_form_location_area;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_view_collect_form_location_area);
            if (constraintLayout2 != null) {
                i = R.id.cl_view_collect_form_location_city;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_view_collect_form_location_city);
                if (constraintLayout3 != null) {
                    i = R.id.cl_view_collect_form_location_province;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.cl_view_collect_form_location_province);
                    if (constraintLayout4 != null) {
                        i = R.id.et_view_collect_form_location_address;
                        EditText editText = (EditText) view.findViewById(R.id.et_view_collect_form_location_address);
                        if (editText != null) {
                            i = R.id.tv_view_collect_form_location_area;
                            TextView textView = (TextView) view.findViewById(R.id.tv_view_collect_form_location_area);
                            if (textView != null) {
                                i = R.id.tv_view_collect_form_location_area_tip;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_location_area_tip);
                                if (textView2 != null) {
                                    i = R.id.tv_view_collect_form_location_city;
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_view_collect_form_location_city);
                                    if (textView3 != null) {
                                        i = R.id.tv_view_collect_form_location_city_tip;
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_view_collect_form_location_city_tip);
                                        if (textView4 != null) {
                                            i = R.id.tv_view_collect_form_location_name;
                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_view_collect_form_location_name);
                                            if (textView5 != null) {
                                                i = R.id.tv_view_collect_form_location_province;
                                                TextView textView6 = (TextView) view.findViewById(R.id.tv_view_collect_form_location_province);
                                                if (textView6 != null) {
                                                    i = R.id.tv_view_collect_form_location_province_tip;
                                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_view_collect_form_location_province_tip);
                                                    if (textView7 != null) {
                                                        i = R.id.tv_view_collect_form_location_required;
                                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_view_collect_form_location_required);
                                                        if (textView8 != null) {
                                                            return new ViewCollectFormLocationBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, editText, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
