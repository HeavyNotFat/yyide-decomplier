package com.yd.android_brand_mvp.user.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import butterknife.BindView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;

/* JADX INFO: loaded from: classes4.dex */
public class UserLeaveFragment extends BaseFragment {

    @BindView(R.id.tab1)
    CheckedTextView tab1;

    @BindView(R.id.tab2)
    CheckedTextView tab2;

    @BindView(R.id.tab3)
    CheckedTextView tab3;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.user_leave_layout, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.tab1.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.user.fragment.UserLeaveFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                UserLeaveFragment.this.tab1.setChecked(true);
                UserLeaveFragment.this.tab2.setChecked(false);
                UserLeaveFragment.this.tab3.setChecked(false);
            }
        });
        this.tab2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.user.fragment.UserLeaveFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                UserLeaveFragment.this.tab1.setChecked(false);
                UserLeaveFragment.this.tab2.setChecked(true);
                UserLeaveFragment.this.tab3.setChecked(false);
            }
        });
        this.tab3.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.user.fragment.UserLeaveFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                UserLeaveFragment.this.tab1.setChecked(false);
                UserLeaveFragment.this.tab2.setChecked(false);
                UserLeaveFragment.this.tab3.setChecked(true);
            }
        });
    }
}
