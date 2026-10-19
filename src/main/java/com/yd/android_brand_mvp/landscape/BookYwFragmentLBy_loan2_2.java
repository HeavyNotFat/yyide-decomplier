package com.yd.android_brand_mvp.landscape;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.BookYwAdapter4_2l;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.dialog.BookDiallog;
import com.yd.android_brand_mvp.model.BookassetsRsp;
import com.yd.android_brand_mvp.model.SearchBookRsp;
import com.yd.android_brand_mvp.model.YwBookRsp;
import com.yd.android_brand_mvp.model.ctrlNoRsp;
import com.yd.android_brand_mvp.presenter.YwPresenter;
import com.yd.android_brand_mvp.user.BookYwActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.SpaceItemDecoration;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.view.getTopsView;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragmentLBy_loan2_2 extends BaseMvpFragment<YwPresenter> implements getTopsView {
    BookYwAdapter4_2l adapter;
    ctrlNoRsp bean;

    @BindView(R.id.bg)
    LinearLayout bg;
    String ctrNo;
    List<YwBookRsp> listbook;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.title)
    TextView title;
    String type;
    View view;

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void searchBookFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void searchBookSuccess(SearchBookRsp searchBookRsp) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook2_2_loan_l, viewGroup, false);
        this.view = viewInflate;
        return viewInflate;
    }

    public static BookYwFragmentLBy_loan2_2 newInstance(String str) {
        return new BookYwFragmentLBy_loan2_2(str);
    }

    public BookYwFragmentLBy_loan2_2() {
        this.type = "";
    }

    public BookYwFragmentLBy_loan2_2(String str) {
        this.type = "";
        this.type = str;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        setLayoutParams();
        ((YwPresenter) this.mvpPresenter).getTops("loan", "365", "", "", "");
    }

    void setLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if ("hbtsg223".contains(this.type)) {
            layoutParams.width = SizeUtils.dp2px(444.0f);
            layoutParams.height = SizeUtils.dp2px(292.0f);
        } else if ("sbtsg223".contains(this.type)) {
            layoutParams.width = SizeUtils.dp2px(320.0f);
            layoutParams.height = SizeUtils.dp2px(424.0f);
        }
        this.bg.setLayoutParams(layoutParams);
    }

    private void initView() {
        this.title.setText("图书馆");
        this.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragmentLBy_loan2_2.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SpData.getMsgType()) {
                    Intent intent = new Intent();
                    intent.setClass(BookYwFragmentLBy_loan2_2.this.mActivity, BookYwActivity.class);
                    intent.putExtra(BookYwActivity.idnex, "1");
                    BookYwFragmentLBy_loan2_2.this.startActivity(intent);
                    return;
                }
                ToastUtil.showBottomView(BookYwFragmentLBy_loan2_2.this.mActivity, "二级页面已禁用");
            }
        });
        if ("hbtsg223".contains(this.type)) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
            linearLayoutManager.setOrientation(0);
            this.recyclerView.addItemDecoration(new SpaceItemDecoration(44));
            this.recyclerView.setLayoutManager(linearLayoutManager);
        } else if ("sbtsg223".contains(this.type)) {
            this.recyclerView.setLayoutManager(new GridLayoutManager(this.mActivity, 2));
        }
        BookYwAdapter4_2l bookYwAdapter4_2l = new BookYwAdapter4_2l(R.layout.ywbook_item);
        this.adapter = bookYwAdapter4_2l;
        this.recyclerView.setAdapter(bookYwAdapter4_2l);
        this.adapter.setcolor(true);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragmentLBy_loan2_2.2
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                if (BookYwFragmentLBy_loan2_2.this.listbook == null || BookYwFragmentLBy_loan2_2.this.listbook.size() <= 0) {
                    return;
                }
                BookYwFragmentLBy_loan2_2 bookYwFragmentLBy_loan2_2 = BookYwFragmentLBy_loan2_2.this;
                bookYwFragmentLBy_loan2_2.ctrNo = bookYwFragmentLBy_loan2_2.listbook.get(i).ctrlNo;
                BookYwFragmentLBy_loan2_2.this.bookLoadingDiallog.show();
                ((YwPresenter) BookYwFragmentLBy_loan2_2.this.mvpPresenter).getBookMsg(BookYwFragmentLBy_loan2_2.this.ctrNo);
            }
        });
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
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

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getTopsSuccess(List<YwBookRsp> list) {
        Log.e("TAG", "getTopsSuccess: " + JSON.toJSONString(list));
        if (SpData.getResponseCode() == BaseConstant.REQUEST_SUCCES2) {
            this.listbook = list;
            SPUtils.getInstance().put(SpData.bookloan, JSON.toJSONString(list));
            this.adapter.setList(list);
        } else {
            ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
        }
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getTopsFail(String str) {
        if (SpData.getBookDataLoan() != null) {
            List<YwBookRsp> bookDataLoan = SpData.getBookDataLoan();
            this.listbook = bookDataLoan;
            this.adapter.setList(bookDataLoan);
        }
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getctrlNoSuccess(ctrlNoRsp ctrlnorsp) {
        if (SpData.getResponseCode() == BaseConstant.REQUEST_SUCCES2) {
            this.bean = ctrlnorsp;
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
            new BookDiallog(this.mActivity, this.bean, list).show();
            return;
        }
        ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getBookassetsFail(String str) {
        ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
        this.bookLoadingDiallog.dismiss();
    }
}
