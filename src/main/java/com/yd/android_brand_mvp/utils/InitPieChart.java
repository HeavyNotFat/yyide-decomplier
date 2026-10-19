package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.google.android.gms.common.ConnectionResult;
import com.yd.android_brand_mvp.R;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class InitPieChart {
    public static void InitPieChart(Activity activity, PieChart pieChart) {
        pieChart.setUsePercentValues(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(0.0f, 0.0f, 0.0f, 0.0f);
        pieChart.setHoleRadius(50.0f);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setCenterTextColor(SkinCompatResources.getInstance().getColor(R.color.black3));
        pieChart.setRotationEnabled(false);
        pieChart.setHighlightPerTapEnabled(false);
        pieChart.setCenterTextSize(14.0f);
        pieChart.setDrawCenterText(true);
        pieChart.setRotationAngle(0.0f);
        pieChart.setTransparentCircleRadius(0.0f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(-1);
        pieChart.setTransparentCircleColor(-1);
        pieChart.setTransparentCircleAlpha(100);
        pieChart.getLegend().setEnabled(false);
        pieChart.setRotationAngle(0.0f);
        pieChart.setDrawSliceText(false);
        pieChart.highlightValues(null);
        pieChart.highlightValues(null);
        pieChart.animateX(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, Easing.EasingOption.EaseInOutQuad);
    }
}
