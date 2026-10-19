package com.yd.android_brand_mvp.landscape;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.iotControl.DoorControlActivity;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.presenter.ClassInfoPresenter;
import com.yd.android_brand_mvp.utils.GPIOUtils;
import com.yd.android_brand_mvp.view.ClassInfoView;

/* JADX INFO: loaded from: classes4.dex */
public class Wlkz2_2L extends BaseMvpFragment<ClassInfoPresenter> implements ClassInfoView {
    private static String LAYOUT_TAG = "layout_tag";
    public static String SUO = "suo";
    wlkzBD bd;

    @BindView(R.id.flContent)
    ConstraintLayout content;

    @BindView(R.id.door)
    CheckedTextView door;
    private final Handler handler = new Handler();
    private final Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.Wlkz2_2L.1
        @Override // java.lang.Runnable
        public void run() {
            Wlkz2_2L.this.door.setChecked(false);
        }
    };

    @BindView(R.id.title)
    TextView title;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getDataSuccess(NewClassInfoRsp newClassInfoRsp) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getDataSuccess1(ClassesInfoBean classesInfoBean) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getFail1(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.ClassInfoView
    public void getWatchWordSuccess(NewWatchWordRsp newWatchWordRsp) {
    }

    public static Wlkz2_2L newInstance(String str, int i) {
        Wlkz2_2L wlkz2_2L = new Wlkz2_2L();
        Bundle bundle = new Bundle();
        bundle.putString(LAYOUT_TAG, str);
        bundle.putInt("time", i);
        wlkz2_2L.setArguments(bundle);
        return wlkz2_2L;
    }

    public class wlkzBD extends BroadcastReceiver {
        public wlkzBD() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Wlkz2_2L.SUO.equals(intent.getAction())) {
                GPIOUtils.INSTANCE.open(Wlkz2_2L.this.requireContext());
                Wlkz2_2L.this.door.setChecked(true);
                Wlkz2_2L.this.handler.removeCallbacks(Wlkz2_2L.this.runnable);
                Wlkz2_2L.this.handler.postDelayed(Wlkz2_2L.this.runnable, 5000L);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_wlkz_2_2l, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (getArguments() != null && "sbwlkz22".equals(getArguments().getString(LAYOUT_TAG))) {
            layoutParams.width = SizeUtils.dp2px(320.0f);
            layoutParams.height = SizeUtils.dp2px(424.0f);
            this.content.setLayoutParams(layoutParams);
        }
        int i = getArguments() != null ? getArguments().getInt("time") : 60;
        final int i2 = i != 0 ? i : 60;
        this.door.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.Wlkz2_2L.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                DoorControlActivity.INSTANCE.startGo(Wlkz2_2L.this.requireContext(), i2);
            }
        });
        this.bd = new wlkzBD();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SUO);
        if (getActivity() != null) {
            getActivity().registerReceiver(this.bd, intentFilter);
        }
        this.title.setText("物联控制");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public ClassInfoPresenter createPresenter() {
        return new ClassInfoPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.runnable);
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (this.mActivity != null) {
            this.mActivity.unregisterReceiver(this.bd);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
