package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.BookYwActivitySearchAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.dialog.BookDiallog;
import com.yd.android_brand_mvp.dialog.Pop2;
import com.yd.android_brand_mvp.model.BookassetsRsp;
import com.yd.android_brand_mvp.model.SearchBookRsp;
import com.yd.android_brand_mvp.model.YwBookRsp;
import com.yd.android_brand_mvp.model.ctrlNoRsp;
import com.yd.android_brand_mvp.presenter.YwPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.view.getTopsView;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragment_search extends BaseMvpFragment<YwPresenter> implements getTopsView {
    BookYwActivitySearchAdapter adapter;
    SearchBookRsp bean;
    String ctrNo;
    ctrlNoRsp ctrlNoRsp;

    @BindView(R.id.edit)
    EditText edit;

    @BindView(R.id.layout_info)
    LinearLayout layout_info;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.seach)
    FrameLayout seach;

    @BindView(R.id.tj)
    TextView tj;

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getTopsFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getTopsSuccess(List<YwBookRsp> list) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_yw_search, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        this.seach.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment_search.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BookYwFragment_search.this.bookLoadingDiallog.show();
                ((YwPresenter) BookYwFragment_search.this.mvpPresenter).searchBook(BookYwFragment_search.this.tj.getText().toString(), BookYwFragment_search.this.edit.getText().toString());
            }
        });
        this.tj.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment_search.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                new Pop2(BookYwFragment_search.this.mActivity, BookYwFragment_search.this.tj);
            }
        });
    }

    private void initView() {
        if (ScreenUtils.isLandscape()) {
            this.adapter = new BookYwActivitySearchAdapter(R.layout.ywactivitybook_item_search2);
            this.recyclerView.setLayoutManager(new GridLayoutManager(this.mActivity, SpData.isNight() ? 1 : 2));
        } else {
            this.adapter = new BookYwActivitySearchAdapter(R.layout.ywactivitybook_item_search2p);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
            linearLayoutManager.setOrientation(1);
            this.recyclerView.setLayoutManager(linearLayoutManager);
        }
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment_search.3
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                if (BookYwFragment_search.this.bean == null || BookYwFragment_search.this.bean.list.size() <= 0) {
                    return;
                }
                BookYwFragment_search bookYwFragment_search = BookYwFragment_search.this;
                bookYwFragment_search.ctrNo = bookYwFragment_search.bean.list.get(i).ctrlNo;
                BookYwFragment_search.this.bookLoadingDiallog.show();
                ((YwPresenter) BookYwFragment_search.this.mvpPresenter).getBookMsg(BookYwFragment_search.this.ctrNo);
            }
        });
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public YwPresenter createPresenter() {
        return new YwPresenter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getctrlNoSuccess(ctrlNoRsp ctrlnorsp) {
        if (SpData.getResponseCode() == BaseConstant.REQUEST_SUCCES2) {
            this.ctrlNoRsp = ctrlnorsp;
            ((YwPresenter) this.mvpPresenter).getBookMsgAssets(this.ctrNo);
            return;
        }
        ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getctrlNoFail(String str) {
        ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
        this.bookLoadingDiallog.dismiss();
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getBookassetsSuccess(List<BookassetsRsp> list) {
        this.bookLoadingDiallog.dismiss();
        if (SpData.getResponseCode() == BaseConstant.REQUEST_SUCCES2) {
            new BookDiallog(this.mActivity, this.ctrlNoRsp, list).show();
            return;
        }
        ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getBookassetsFail(String str) {
        ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
        this.bookLoadingDiallog.dismiss();
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void searchBookSuccess(SearchBookRsp searchBookRsp) {
        Log.e("TAG", "searchBookSuccess: " + JSON.toJSONString(searchBookRsp));
        this.bookLoadingDiallog.dismiss();
        if (SpData.getResponseCode() == BaseConstant.REQUEST_SUCCES2) {
            this.bean = searchBookRsp;
            this.adapter.setList(searchBookRsp.list);
            this.layout_info.setVisibility(searchBookRsp.list.size() > 0 ? 8 : 0);
            this.recyclerView.setVisibility(searchBookRsp.list.size() > 0 ? 0 : 8);
            return;
        }
        ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void searchBookFail(String str) {
        this.bookLoadingDiallog.dismiss();
        ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
    }
}
