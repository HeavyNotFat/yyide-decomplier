package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.BookYwAdapter4_6l;
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
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragmenLBy_search2 extends BaseMvpFragment<YwPresenter> implements getTopsView {
    BookYwAdapter4_6l adapter;
    SearchBookRsp bean;

    @BindView(R.id.bg)
    RelativeLayout bg;
    String ctrNo;
    ctrlNoRsp ctrlNoRsp;

    @BindView(R.id.edit)
    EditText edit;

    @BindView(R.id.layout_info)
    LinearLayout layout_info;

    @BindView(R.id.msg)
    TextView msg;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.seach)
    FrameLayout seach;

    @BindView(R.id.tj)
    TextView tj;
    String type;
    View view;

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getTopsFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getTopsSuccess(List<YwBookRsp> list) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook_4_6_l2, viewGroup, false);
        this.view = viewInflate;
        return viewInflate;
    }

    public static BookYwFragmenLBy_search2 newInstance(String str) {
        return new BookYwFragmenLBy_search2(str);
    }

    public BookYwFragmenLBy_search2() {
    }

    public BookYwFragmenLBy_search2(String str) {
        this.type = str;
    }

    void setBg() {
        if ("hbtsg463".equals(this.type)) {
            this.bg.setBackground(SkinCompatResources.getInstance().getDrawable(R.drawable.book_46_hs));
            this.seach.setBackground(SkinCompatResources.getInstance().getDrawable(R.drawable.bg_book_tk3_hs));
            this.msg.setTextColor(SkinCompatResources.getInstance().getColor(R.color.book_color66));
        } else if ("hbtsg462".equals(this.type)) {
            this.bg.setBackground(SkinCompatResources.getInstance().getDrawable(R.drawable.book_46_ls));
            this.seach.setBackground(SkinCompatResources.getInstance().getDrawable(R.drawable.bg_book_tk3));
            this.msg.setTextColor(SkinCompatResources.getInstance().getColor(R.color.book_color667));
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.seach.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragmenLBy_search2.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BookYwFragmenLBy_search2.this.bookLoadingDiallog.show();
                ((YwPresenter) BookYwFragmenLBy_search2.this.mvpPresenter).searchBook(BookYwFragmenLBy_search2.this.tj.getText().toString(), BookYwFragmenLBy_search2.this.edit.getText().toString());
            }
        });
        initView();
        this.tj.setText("任意");
        this.tj.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragmenLBy_search2.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                new Pop2(BookYwFragmenLBy_search2.this.mActivity, BookYwFragmenLBy_search2.this.tj);
            }
        });
        this.edit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragmenLBy_search2.3
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent == null || keyEvent.getKeyCode() == 66) {
                }
                return true;
            }
        });
    }

    private void initView() {
        this.adapter = new BookYwAdapter4_6l(R.layout.ywbook_item);
        this.recyclerView.setLayoutManager(new GridLayoutManager(this.mActivity, 6));
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragmenLBy_search2.4
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                if (BookYwFragmenLBy_search2.this.bean == null || BookYwFragmenLBy_search2.this.bean.list.size() <= 0) {
                    return;
                }
                BookYwFragmenLBy_search2 bookYwFragmenLBy_search2 = BookYwFragmenLBy_search2.this;
                bookYwFragmenLBy_search2.ctrNo = bookYwFragmenLBy_search2.bean.list.get(i).ctrlNo;
                BookYwFragmenLBy_search2.this.bookLoadingDiallog.show();
                ((YwPresenter) BookYwFragmenLBy_search2.this.mvpPresenter).getBookMsg(BookYwFragmenLBy_search2.this.ctrNo);
            }
        });
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
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
        this.bookLoadingDiallog.dismiss();
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void searchBookSuccess(SearchBookRsp searchBookRsp) {
        this.bookLoadingDiallog.dismiss();
        Log.e("TAG", "searchBookSuccess: " + JSON.toJSONString(searchBookRsp));
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
