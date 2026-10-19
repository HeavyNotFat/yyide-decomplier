package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.db.AddressBookFragment;
import com.yd.android_brand_mvp.db.ConversationFragment3;

/* JADX INFO: loaded from: classes4.dex */
public class UserCenterMessageFragment extends BaseFragment {

    @BindView(R.id.btn1)
    CheckedTextView btn1;

    @BindView(R.id.btn2)
    CheckedTextView btn2;
    Unbinder unbinder;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_message, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
    }

    private void initView() {
        setTab(0);
        this.btn1.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.UserCenterMessageFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserCenterMessageFragment.this.setTab(0);
            }
        });
        this.btn2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.UserCenterMessageFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserCenterMessageFragment.this.setTab(1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTab(int i) {
        this.btn1.setChecked(false);
        this.btn2.setChecked(false);
        FragmentManager childFragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(String.valueOf(this.btn1.getId()));
        Fragment fragmentFindFragmentByTag2 = childFragmentManager.findFragmentByTag(String.valueOf(this.btn2.getId()));
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag);
        }
        if (fragmentFindFragmentByTag2 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
        }
        if (i == 0) {
            if (fragmentFindFragmentByTag == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, new ConversationFragment3(), String.valueOf(this.btn1.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag);
            }
            this.btn1.setChecked(true);
        } else if (i == 1) {
            if (fragmentFindFragmentByTag2 == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, AddressBookFragment.INSTANCE.newInstance(), String.valueOf(this.btn2.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
            }
            this.btn2.setChecked(true);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
