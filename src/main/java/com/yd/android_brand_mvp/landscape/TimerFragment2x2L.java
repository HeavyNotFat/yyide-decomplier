package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.work.WorkRequest;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.TimerListAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.TimelistRsp;
import com.yd.android_brand_mvp.presenter.TimerPresenter;
import com.yd.android_brand_mvp.user.TimerActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.view.TimelistView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class TimerFragment2x2L extends BaseMvpFragment<TimerPresenter> implements TimelistView {
    private static String TYPE = "type";

    @BindView(R.id.layout_content)
    LinearLayout layout_content;

    @BindView(R.id.announRoll)
    Banner mBanner;
    TimerListAdapter mTimerListAdapter;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.title)
    TextView title;

    public static Fragment newInstance(String str) {
        TimerFragment2x2L timerFragment2x2L = new TimerFragment2x2L();
        Bundle bundle = new Bundle();
        bundle.putString(TYPE, str);
        timerFragment2x2L.setArguments(bundle);
        return timerFragment2x2L;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate;
        if (ScreenUtils.isLandscape()) {
            Bundle arguments = getArguments();
            if (arguments != null && "hbdjs23".equals(arguments.getString(TYPE))) {
                viewInflate = layoutInflater.inflate(R.layout.fragment_cartoon_timer_l2x3, viewGroup, false);
            } else if (arguments != null && "hbtimer24".equals(arguments.getString(TYPE))) {
                viewInflate = layoutInflater.inflate(R.layout.fragment_timer_l2x4, viewGroup, false);
            } else {
                viewInflate = layoutInflater.inflate(R.layout.fragment_timer_l2x2, viewGroup, false);
            }
        } else {
            viewInflate = layoutInflater.inflate(R.layout.fragment_timer_p2x2, viewGroup, false);
        }
        ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.title.setText(R.string.timer);
        this.mTimerListAdapter = new TimerListAdapter(this.mActivity);
        this.mBanner.addBannerLifecycleObserver(this).setStartPosition(1).setAdapter(this.mTimerListAdapter).isAutoLoop(true).setLoopTime(WorkRequest.MIN_BACKOFF_MILLIS).setIndicator(new CircleIndicator(requireContext())).setIndicatorGravity(1).setIndicatorSpace(BannerUtils.dp2px(10.0f)).setIndicatorNormalColor(SkinCompatResources.getInstance().getColor(R.color.gray)).setIndicatorSelectedColor(SkinCompatResources.getInstance().getColor(R.color.blue12)).setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f)).setIndicatorHeight(BannerUtils.dp2px(10.0f));
        this.mu.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$TimerFragment2x2L$dhamZY8010pMvTj42xcBMN7eGL8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$0$TimerFragment2x2L(view2);
            }
        });
        this.layout_content.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$TimerFragment2x2L$iKEhUc9sMdTD8g7rPIzQL75UoFA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$1$TimerFragment2x2L(view2);
            }
        });
        request();
    }

    public /* synthetic */ void lambda$onViewCreated$0$TimerFragment2x2L(View view) {
        request();
    }

    public /* synthetic */ void lambda$onViewCreated$1$TimerFragment2x2L(View view) {
        goPermissionsActivity(TimerActivity.class);
    }

    private void request() {
        ((TimerPresenter) this.mvpPresenter).getTimelist();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Timer || i == MinaConstants.netWork) {
            Log.i("UpdataEvent", "网络重连");
            request();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public TimerPresenter createPresenter() {
        return new TimerPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.TimelistView
    public void getDataSuccess(TimelistRsp timelistRsp) {
        LogUtils.i("timerModule" + JSON.toJSONString(timelistRsp));
        if (timelistRsp.code == 0) {
            SPUtils.getInstance().put(SpData.Timelist, GsonUtils.toJson(timelistRsp));
            if (timelistRsp.data != null && timelistRsp.data.size() > 0) {
                this.mu.setViewState(0);
                setView(timelistRsp);
            } else {
                this.mu.setViewState(2);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.view.TimelistView
    public void getFail(String str) {
        LogUtils.e("timerModule", str);
        this.mu.setViewState(1);
    }

    private void setView(TimelistRsp timelistRsp) {
        this.mBanner.setDatas(timelistRsp.data);
        this.mBanner.setVisibility(0);
    }
}
