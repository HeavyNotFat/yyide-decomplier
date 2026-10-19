package com.yd.android_brand_mvp.landscape;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.view.getTopsView;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragment4_2LBy_loan extends BaseMvpFragment<YwPresenter> implements getTopsView {
    BookYwAdapter4_2l adapter;
    ctrlNoRsp bean;

    @BindView(R.id.bg)
    RelativeLayout bg;

    @BindView(R.id.booktitle)
    TextView booktitle;
    String ctrNo;
    List<YwBookRsp> listbook;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
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
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook4_2_l, viewGroup, false);
        this.view = viewInflate;
        return viewInflate;
    }

    public static BookYwFragment4_2LBy_loan newInstance(String str) {
        return new BookYwFragment4_2LBy_loan(str);
    }

    public BookYwFragment4_2LBy_loan() {
    }

    public BookYwFragment4_2LBy_loan(String str) {
        this.type = str;
    }

    void setBg() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if ("hbtsgrm432".equals(this.type)) {
            this.bg.setBackground(SkinCompatResources.getInstance().getDrawable(R.drawable.book_43_ls));
            layoutParams.width = SizeUtils.dp2px(908.0f);
            layoutParams.height = SizeUtils.dp2px(444.0f);
        } else if ("hbtsgrm431".equals(this.type)) {
            this.bg.setBackground(SkinCompatResources.getInstance().getDrawable(R.drawable.book_43_hs));
            layoutParams.width = SizeUtils.dp2px(908.0f);
            layoutParams.height = SizeUtils.dp2px(444.0f);
        } else if ("sbtsgrm432".equals(this.type)) {
            this.bg.setBackground(SkinCompatResources.getInstance().getDrawable(R.drawable.sb_bookloan_63));
            layoutParams.width = SizeUtils.dp2px(1000.0f);
            layoutParams.height = SizeUtils.dp2px(424.0f);
        } else if ("sbtsgrm431".equals(this.type)) {
            this.bg.setBackground(SkinCompatResources.getInstance().getDrawable(R.drawable.sb_bookloan_63_hs));
            layoutParams.width = SizeUtils.dp2px(1000.0f);
            layoutParams.height = SizeUtils.dp2px(424.0f);
        }
        this.bg.setLayoutParams(layoutParams);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        this.booktitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment4_2LBy_loan.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SpData.getMsgType()) {
                    Intent intent = new Intent();
                    intent.setClass(BookYwFragment4_2LBy_loan.this.mActivity, BookYwActivity.class);
                    intent.putExtra(BookYwActivity.idnex, "1");
                    BookYwFragment4_2LBy_loan.this.startActivity(intent);
                    return;
                }
                ToastUtil.showBottomView(BookYwFragment4_2LBy_loan.this.mActivity, "二级页面已禁用");
            }
        });
        setBg();
        ((YwPresenter) this.mvpPresenter).getTops("loan", "365", "", "", "");
    }

    private void initView() {
        this.booktitle.setText(R.string.book_title_tab2);
        this.adapter = new BookYwAdapter4_2l(R.layout.ywbook_item);
        this.recyclerView.setLayoutManager(new GridLayoutManager(this.mActivity, 6));
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment4_2LBy_loan.2
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                if (BookYwFragment4_2LBy_loan.this.listbook == null || BookYwFragment4_2LBy_loan.this.listbook.size() <= 0) {
                    return;
                }
                BookYwFragment4_2LBy_loan bookYwFragment4_2LBy_loan = BookYwFragment4_2LBy_loan.this;
                bookYwFragment4_2LBy_loan.ctrNo = bookYwFragment4_2LBy_loan.listbook.get(i).ctrlNo;
                BookYwFragment4_2LBy_loan.this.bookLoadingDiallog.show();
                ((YwPresenter) BookYwFragment4_2LBy_loan.this.mvpPresenter).getBookMsg(BookYwFragment4_2LBy_loan.this.ctrNo);
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
            SPUtils.getInstance().put(SpData.bookloan, JSON.toJSONString(list));
            this.listbook = list;
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
