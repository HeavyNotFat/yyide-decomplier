package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.WeatherAdapter2;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.model.NewWeatherItemBean;
import com.yd.android_brand_mvp.model.NewWeatherListBean;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherDiallog extends BaseDialog {
    TextView close;
    Context context;
    GridView grid;
    TextView info;
    TextView wd;

    public WeatherDiallog(Context context, int i) {
        super(context, i);
    }

    public WeatherDiallog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_weather);
        WeatherAdapter2 weatherAdapter2 = new WeatherAdapter2();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(17);
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
        window.setAttributes(attributes);
        this.info = (TextView) findViewById(R.id.info);
        this.close = (TextView) findViewById(R.id.close);
        this.wd = (TextView) findViewById(R.id.wd);
        GridView gridView = (GridView) findViewById(R.id.grid);
        this.grid = gridView;
        gridView.setAdapter((ListAdapter) weatherAdapter2);
        TimeUtil.stampToDate(System.currentTimeMillis());
        this.close.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.dialog.WeatherDiallog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WeatherDiallog.this.cancel();
            }
        });
        NewWeatherListBean newWeatherListBean = (NewWeatherListBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.WEATHER_LIST_NEW, NewWeatherListBean.class);
        if (newWeatherListBean != null) {
            List<NewWeatherItemBean> list = newWeatherListBean.getList();
            weatherAdapter2.notifyData(list);
            if (list == null || list.size() <= 0) {
                return;
            }
            NewWeatherItemBean newWeatherItemBean = list.get(0);
            String str = newWeatherListBean.getProvince() + newWeatherListBean.getArea();
            this.info.setText(str + " " + newWeatherItemBean.getWeather() + "  " + newWeatherItemBean.getLowest() + " - " + newWeatherItemBean.getHighest());
            this.wd.setText(newWeatherItemBean.getReal());
        }
    }
}
