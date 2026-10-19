package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.BookTitileAdapter;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.user.BookYwActivity;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragmentL extends BaseFragment {
    BookTitileAdapter adapter;

    @BindView(R.id.content)
    FrameLayout content;

    @BindView(R.id.grid)
    GridView gridView;

    @BindView(R.id.ll_content)
    LinearLayout ll_content;
    String[] strs = {"图书检索", "热门借阅", "新书通报"};

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_ywbook, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        Bundle arguments = getArguments();
        if (arguments != null) {
            setFragment(arguments.getInt(FirebaseAnalytics.Param.INDEX));
        } else {
            setFragment(0);
        }
    }

    void initView() {
        BookTitileAdapter bookTitileAdapter = new BookTitileAdapter();
        this.adapter = bookTitileAdapter;
        this.gridView.setAdapter((ListAdapter) bookTitileAdapter);
        this.adapter.upData(this.strs);
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$BookYwFragmentL$0nte9P99C6JPS10iZyIAd4mHo20
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$initView$0$BookYwFragmentL(adapterView, view, i, j);
            }
        });
        this.ll_content.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$BookYwFragmentL$zN5zQSrZ0Tz0Ace0r6-g0UGrFAk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initView$1$BookYwFragmentL(view);
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$BookYwFragmentL(AdapterView adapterView, View view, int i, long j) {
        setFragment(i);
    }

    public /* synthetic */ void lambda$initView$1$BookYwFragmentL(View view) {
        goPermissionsActivity(BookYwActivity.class);
    }

    void setFragment(int i) {
        this.adapter.setPosition(i);
        FragmentManager childFragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag("1");
        Fragment fragmentFindFragmentByTag2 = childFragmentManager.findFragmentByTag("2");
        Fragment fragmentFindFragmentByTag3 = childFragmentManager.findFragmentByTag("3");
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag);
        }
        if (fragmentFindFragmentByTag2 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
        }
        if (fragmentFindFragmentByTag3 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag3);
        }
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    if (fragmentFindFragmentByTag3 == null) {
                        BookYwFragment_new bookYwFragment_new = new BookYwFragment_new();
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("isShow", getArguments() == null);
                        bookYwFragment_new.setArguments(bundle);
                        fragmentTransactionBeginTransaction.add(R.id.content, bookYwFragment_new, "3");
                    } else {
                        fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag3);
                    }
                }
            } else if (fragmentFindFragmentByTag2 == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, new BookYwFragment_hot(), "2");
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
            }
        } else if (fragmentFindFragmentByTag == null) {
            fragmentTransactionBeginTransaction.add(R.id.content, new BookYwFragment_search(), "1");
        } else {
            fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
