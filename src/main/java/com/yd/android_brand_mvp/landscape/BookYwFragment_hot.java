package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.BookYwActivityhotAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.dialog.BookDiallog;
import com.yd.android_brand_mvp.dialog.Pop2;
import com.yd.android_brand_mvp.dialog.Pop3;
import com.yd.android_brand_mvp.dialog.Pop4;
import com.yd.android_brand_mvp.dialog.Pop5;
import com.yd.android_brand_mvp.model.BookassetsRsp;
import com.yd.android_brand_mvp.model.SearchBookRsp;
import com.yd.android_brand_mvp.model.YwBookRsp;
import com.yd.android_brand_mvp.model.ctrlNoRsp;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.presenter.YwPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.view.getTopsView;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BookYwFragment_hot extends BaseMvpFragment<YwPresenter> implements getTopsView {
    BookYwActivityhotAdapter adapter;
    ctrlNoRsp bean;
    String ctrNo;

    @BindView(R.id.flag)
    TextView flag;

    @BindView(R.id.flag2)
    TextView flag2;

    @BindView(R.id.flaglayout2)
    FrameLayout flaglayout2;

    @BindView(R.id.language)
    TextView language;
    List<YwBookRsp> listbook;
    public String[] listss = {"全部分类", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "X", "Z"};

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.time)
    TextView time;

    @BindView(R.id.type)
    TextView type;

    @BindView(R.id.typelayout)
    FrameLayout typelayout;

    @BindView(R.id.yz_layout)
    FrameLayout yz_layout;

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void getTopsFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void searchBookFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.getTopsView
    public void searchBookSuccess(SearchBookRsp searchBookRsp) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_yw_hot, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        ((YwPresenter) this.mvpPresenter).getTops("loan", this.time.getText().toString(), "", "", setType(this.type.getText().toString()));
        this.time.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment_hot.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                new Pop3(BookYwFragment_hot.this.mActivity, BookYwFragment_hot.this.time);
            }
        });
        this.flag.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment_hot.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                new Pop2(BookYwFragment_hot.this.mActivity, BookYwFragment_hot.this.flag);
            }
        });
        this.language.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment_hot.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                new Pop4(BookYwFragment_hot.this.mActivity, BookYwFragment_hot.this.language);
            }
        });
        this.type.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment_hot.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                new Pop5(BookYwFragment_hot.this.mActivity, BookYwFragment_hot.this.type);
            }
        });
        this.flaglayout2.setVisibility(8);
        this.yz_layout.setVisibility(8);
        MinaEventManager.getInstance().add(this);
    }

    String setType(String str) {
        String str2 = "";
        for (String str3 : this.listss) {
            if (str.contains(str3)) {
                str2 = str3;
            }
        }
        return str2;
    }

    private void initView() {
        if (ScreenUtils.isLandscape()) {
            this.adapter = new BookYwActivityhotAdapter(R.layout.ywactivitybook_item_search2);
            this.recyclerView.setLayoutManager(new GridLayoutManager(this.mActivity, SpData.isNight() ? 1 : 2));
        } else {
            this.adapter = new BookYwActivityhotAdapter(R.layout.ywactivitybook_item_search2p);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mActivity);
            linearLayoutManager.setOrientation(1);
            this.recyclerView.setLayoutManager(linearLayoutManager);
        }
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.BookYwFragment_hot.5
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                if (BookYwFragment_hot.this.listbook == null || BookYwFragment_hot.this.listbook.size() <= 0) {
                    return;
                }
                BookYwFragment_hot bookYwFragment_hot = BookYwFragment_hot.this;
                bookYwFragment_hot.ctrNo = bookYwFragment_hot.listbook.get(i).ctrlNo;
                BookYwFragment_hot.this.bookLoadingDiallog.show();
                ((YwPresenter) BookYwFragment_hot.this.mvpPresenter).getBookMsg(BookYwFragment_hot.this.ctrNo);
            }
        });
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.updateBook) {
            ((YwPresenter) this.mvpPresenter).getTops("loan", this.time.getText().toString(), "", "", setType(this.type.getText().toString()));
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MinaEventManager.getInstance().remove(this);
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
    public void getTopsSuccess(List<YwBookRsp> list) {
        Log.e("TAG", "getTopsSuccess: " + JSON.toJSONString(list));
        if (SpData.getResponseCode() == BaseConstant.REQUEST_SUCCES2) {
            this.listbook = list;
            this.adapter.setList(list);
            return;
        }
        ToastUtil.showBottomView(this.mActivity, SpData.getResponseCode() + FaceMsg.ServerError);
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
