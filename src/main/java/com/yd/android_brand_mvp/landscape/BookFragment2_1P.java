package com.yd.android_brand_mvp.landscape;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity2;

/* JADX INFO: loaded from: classes4.dex */
public class BookFragment2_1P extends BaseFragment {

    @BindView(R.id.book_layout)
    FrameLayout book_layout;
    String url = "https://demo.flyread.com.cn/";
    View view;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_book_2_1_p, viewGroup, false);
        this.view = viewInflate;
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.book_layout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookFragment2_1P.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SpData.getMsgType()) {
                    BookFragment2_1P.this.startActivity(new Intent(BookFragment2_1P.this.mActivity, (Class<?>) StudentCheackActivity2.class));
                } else {
                    ToastUtil.showBottomView(BookFragment2_1P.this.mActivity, "二级页面已禁用");
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
