package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
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
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.view.getTopsView;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragmentLBy_new2 extends BaseMvpFragment<YwPresenter> implements getTopsView {
    BookYwAdapter4_2l adapter;
    ctrlNoRsp bean;

    @BindView(R.id.bg)
    RelativeLayout bg;
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
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook4_6_loan_l, viewGroup, false);
        this.view = viewInflate;
        return viewInflate;
    }

    public static BookYwFragmentLBy_new2 newInstance(String str) {
        return new BookYwFragmentLBy_new2(str);
    }

    public BookYwFragmentLBy_new2() {
    }

    public BookYwFragmentLBy_new2(String str) {
        this.type = str;
    }

    void setBg() {
        if ("hbtsgxs432".equals(this.type)) {
            this.bg.setBackground(SkinCompatResources.getInstance().getDrawable(R.drawable.book_43_ls));
        } else if ("hbtsgxs431".equals(this.type)) {
            this.bg.setBackground(SkinCompatResources.getInstance().getDrawable(R.drawable.book_43_hs));
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
    }

    private void initView() {
        this.adapter = new BookYwAdapter4_2l(R.layout.ywbook_item);
        this.recyclerView.setLayoutManager(new GridLayoutManager(this.mActivity, 6));
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragmentLBy_new2.1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                if (BookYwFragmentLBy_new2.this.listbook == null || BookYwFragmentLBy_new2.this.listbook.size() <= 0) {
                    return;
                }
                BookYwFragmentLBy_new2 bookYwFragmentLBy_new2 = BookYwFragmentLBy_new2.this;
                bookYwFragmentLBy_new2.ctrNo = bookYwFragmentLBy_new2.listbook.get(i).ctrlNo;
                BookYwFragmentLBy_new2.this.bookLoadingDiallog.show();
                ((YwPresenter) BookYwFragmentLBy_new2.this.mvpPresenter).getBookMsg(BookYwFragmentLBy_new2.this.ctrNo);
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
        ((YwPresenter) this.mvpPresenter).getTops("new", "365", "新书", "", "");
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
            SPUtils.getInstance().put(SpData.booknew, JSON.toJSONString(list));
            this.adapter.setList(list);
        } else {
            ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
        }
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getTopsFail(String str) {
        if (SpData.getBookDataNew() != null) {
            List<YwBookRsp> bookDataNew = SpData.getBookDataNew();
            this.listbook = bookDataNew;
            this.adapter.setList(bookDataNew);
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
