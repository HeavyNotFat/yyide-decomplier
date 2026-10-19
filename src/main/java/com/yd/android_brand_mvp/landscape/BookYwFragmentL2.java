package com.yd.android_brand_mvp.landscape;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.BookTitileAdapter;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.user.BookYwActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragmentL2 extends BaseFragment {
    BookTitileAdapter adapter;

    @BindView(R.id.content)
    FrameLayout content;

    @BindView(R.id.grid)
    GridView gridView;

    @BindView(R.id.layout_bg)
    RelativeLayout layout_bg;

    @BindView(R.id.title)
    TextView title;
    String type;
    String[] strs = {"图书检索", "热门借阅", "新书通报"};
    public int index = 0;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_ywbook2, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        setLayoutParams();
        setFragment(0);
        this.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragmentL2.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SpData.getMsgType()) {
                    Intent intent = new Intent();
                    intent.setClass(BookYwFragmentL2.this.mActivity, BookYwActivity.class);
                    intent.putExtra(BookYwActivity.idnex, BookYwFragmentL2.this.index + "");
                    BookYwFragmentL2.this.startActivity(intent);
                    return;
                }
                ToastUtil.showBottomView(BookYwFragmentL2.this.mActivity, "二级页面已禁用");
            }
        });
    }

    public static BookYwFragmentL2 newInstance(String str) {
        return new BookYwFragmentL2(str);
    }

    public BookYwFragmentL2() {
    }

    public BookYwFragmentL2(String str) {
        this.type = str;
    }

    void initView() {
        this.title.setText("图书馆");
        BookTitileAdapter bookTitileAdapter = new BookTitileAdapter();
        this.adapter = bookTitileAdapter;
        this.gridView.setAdapter((ListAdapter) bookTitileAdapter);
        this.adapter.upData(this.strs);
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragmentL2.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BookYwFragmentL2.this.setFragment(i);
            }
        });
    }

    void setLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if ("hbtsg443".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(908.0f);
            layoutParams.height = SizeUtils.dp2px(604.0f);
        } else if ("hbtsg463".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(908.0f);
            layoutParams.height = SizeUtils.dp2px(916.0f);
        } else if ("sbtsg443".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(660.0f);
            layoutParams.height = SizeUtils.dp2px(868.0f);
        } else if ("sbtsg633".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(1000.0f);
            layoutParams.height = SizeUtils.dp2px(646.0f);
        } else if ("sbtsg663".equals(this.type)) {
            layoutParams.width = SizeUtils.dp2px(1000.0f);
            layoutParams.height = SizeUtils.dp2px(1290.0f);
        }
        this.layout_bg.setLayoutParams(layoutParams);
    }

    void setFragment(int i) {
        this.adapter.setPosition(i);
        this.index = i;
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
                        fragmentTransactionBeginTransaction.add(R.id.content, new BookYwFragmentLBy_new2(), "3");
                    } else {
                        fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag3);
                    }
                }
            } else if (fragmentFindFragmentByTag2 == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, new BookYwFragmentLBy_loan2(), "2");
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
            }
        } else if (fragmentFindFragmentByTag == null) {
            fragmentTransactionBeginTransaction.add(R.id.content, new BookYwFragmenLBy_search2(), "1");
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
