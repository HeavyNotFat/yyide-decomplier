package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import com.yd.android_brand_mvp.presenter.WeatherPresenter;
import com.yd.android_brand_mvp.utils.WeatherUtils;
import com.yd.android_brand_mvp.view.WeatherView;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherFragment_2_1P extends BaseMvpFragment<WeatherPresenter> implements WeatherView {

    @BindView(R.id.site)
    TextView site;

    @BindView(R.id.tv_weather)
    ImageView tvWeather;

    @BindView(R.id.wd)
    TextView wd;

    @BindView(R.id.weathertext)
    TextView weathertext;

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseView
    public void hideLoading() {
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseView
    public void showError() {
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseView
    public void showLoading() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_weather_2_1, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((WeatherPresenter) this.mvpPresenter).getNewWeather();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public WeatherPresenter createPresenter() {
        return new WeatherPresenter(this);
    }

    private void setData() {
        NewWeatherBean newWeatherBean = (NewWeatherBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.WEATHER_NEW, NewWeatherBean.class);
        if (newWeatherBean != null) {
            this.wd.setText(String.format("%s-%s", newWeatherBean.getHighest(), newWeatherBean.getLowest()));
            this.weathertext.setText(newWeatherBean.getWeather());
            this.site.setText(String.format("%s-%s", newWeatherBean.getProvince(), newWeatherBean.getArea()));
            this.tvWeather.setImageDrawable(getResources().getDrawable(WeatherUtils.imgCodeP(newWeatherBean.getWeather())));
        }
    }

    @Override // com.yd.android_brand_mvp.view.WeatherView
    public void getWeatherSuccess(BaseResponse<NewWeatherBean> baseResponse) {
        if (baseResponse != null && baseResponse.getCode() == 0) {
            MMKV.defaultMMKV().encode(MMKVConstant.WEATHER_NEW, baseResponse.getData());
        }
        setData();
    }

    @Override // com.yd.android_brand_mvp.view.WeatherView
    public void getWeatherFail(String str) {
        setData();
    }
}
