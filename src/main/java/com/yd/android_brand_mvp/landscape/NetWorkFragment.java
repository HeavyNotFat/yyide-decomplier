package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.model.EventBean;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes4.dex */
public class NetWorkFragment extends BaseFragment {

    @BindView(R.id.btn_close)
    LinearLayout btn_close;

    @BindView(R.id.content)
    FrameLayout content;
    public int position = -1;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tvTest)
    TextView tvTest;

    @BindView(R.id.type)
    TextView type;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return ScreenUtils.isLandscape() ? layoutInflater.inflate(R.layout.network_layout_l, viewGroup, false) : layoutInflater.inflate(R.layout.network_layout, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setTab(Integer.parseInt(getArguments().getString(FirebaseAnalytics.Param.INDEX)));
        EventBus.getDefault().register(this);
        this.btn_close.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.NetWorkFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                NetWorkFragment.this.getFragmentManager().popBackStackImmediate();
            }
        });
        this.type.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$NetWorkFragment$eQ0QTvHioU-d4aKFdwV6tRSb3SQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$0$NetWorkFragment(view2);
            }
        });
        this.tvTest.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$NetWorkFragment$bWEHVsVbhO6ElPgfm84xVe4IgH8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$1$NetWorkFragment(view2);
            }
        });
        if ("net".equals(getArguments().getString("hide"))) {
            this.type.setVisibility(4);
            this.tvTest.setVisibility(4);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$0$NetWorkFragment(View view) {
        if (this.position == 0) {
            setTab(1);
        } else {
            setTab(0);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$1$NetWorkFragment(View view) {
        setTab(2);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventBean eventBean) {
        if (eventBean != null) {
            int i = eventBean.Event;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    void setTab(int i) {
        this.position = i;
        FragmentManager childFragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag("0");
        Fragment fragmentFindFragmentByTag2 = childFragmentManager.findFragmentByTag("1");
        Fragment fragmentFindFragmentByTag3 = childFragmentManager.findFragmentByTag("2");
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag);
        }
        if (fragmentFindFragmentByTag2 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
        }
        if (fragmentFindFragmentByTag3 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag3);
        }
        if (i == 0) {
            if (fragmentFindFragmentByTag == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, new WIfiFragment(), "0");
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag);
            }
            this.title.setText("无线网");
            this.type.setText("切换以太网");
        } else if (i == 1) {
            if (fragmentFindFragmentByTag2 == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, new EtherNetFragment(), "1");
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
            }
            this.title.setText("以太网");
            this.type.setText("切换无线网");
        } else if (i == 2) {
            if (fragmentFindFragmentByTag3 == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, new PingNetworkFragment(), "2");
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag3);
            }
            this.title.setText("网络测试");
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
