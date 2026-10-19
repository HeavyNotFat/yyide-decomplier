package com.yd.android_brand_mvp.landscape.book;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes4.dex */
public class BookFragmentPage extends BaseFragment {
    public static String BOOKBEAN = "BOOKBEAN";
    BookAdapter adapter;
    BookBd bookBd;
    String bookname;

    @BindView(R.id.grid)
    GridView grid;
    int pagenum;
    private String PARMRS_PAGE = "pagenum";
    private String PARMRS_NAME = "bookname";

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_bookpage, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BookAdapter bookAdapter = new BookAdapter();
        this.adapter = bookAdapter;
        this.grid.setAdapter((ListAdapter) bookAdapter);
        this.pagenum = getArguments().getInt(this.PARMRS_PAGE);
        this.bookname = getArguments().getString(this.PARMRS_NAME);
        getData();
        this.bookBd = new BookBd();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("Bookname");
        this.mActivity.registerReceiver(this.bookBd, intentFilter);
        this.grid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.book.BookFragmentPage.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                BookFragmentPage bookFragmentPage = BookFragmentPage.this;
                bookFragmentPage.getBookContent(bookFragmentPage.adapter.list.get(i).id);
            }
        });
    }

    void getBookContent(int i) {
        GetBookContentReq getBookContentReq = new GetBookContentReq();
        getBookContentReq.id = i;
        BaseApplication.getInstance().requestData(this, getBookContentReq, new listener(), new errorListener());
    }

    class listener implements Response.Listener<GetBookContentRsp> {
        listener() {
        }

        @Override // com.android.volley.Response.Listener
        public void onResponse(GetBookContentRsp getBookContentRsp) {
            if (getBookContentRsp.status != BaseConstant.REQUEST_SUCCES || getBookContentRsp.data.book == null) {
                return;
            }
            new Bundle().putString(BookFragmentPage.BOOKBEAN, JSON.toJSONString(getBookContentRsp.data.book));
            String jSONString = JSON.toJSONString(getBookContentRsp.data.book);
            int i = getBookContentRsp.data.book.bookUploadType;
            if (i == 0 || i == 1 || i == 2) {
                Intent intent = new Intent();
                intent.setClass(BookFragmentPage.this.mActivity, BookImageInfo.class);
                intent.putExtra("ss", jSONString);
                BookFragmentPage.this.startActivity(intent);
            }
        }
    }

    class errorListener implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
        }

        errorListener() {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mActivity.unregisterReceiver(this.bookBd);
    }

    void getData() {
        GetBookListByKeyReq getBookListByKeyReq = new GetBookListByKeyReq();
        getBookListByKeyReq.currentPage = this.pagenum;
        if (TextUtils.isEmpty(this.bookname)) {
            getBookListByKeyReq.key = "";
        } else {
            try {
                getBookListByKeyReq.key = URLEncoder.encode(this.bookname, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        getBookListByKeyReq.officeId = SpData.getSchoolId();
        BaseApplication.getInstance().requestData(this, getBookListByKeyReq, new dataListener(), new errorListener());
    }

    class dataListener implements Response.Listener<GetBookListByKeyRsp> {
        dataListener() {
        }

        @Override // com.android.volley.Response.Listener
        public void onResponse(GetBookListByKeyRsp getBookListByKeyRsp) {
            if (getBookListByKeyRsp.status == BaseConstant.REQUEST_SUCCES) {
                if (BookFragmentPage.this.pagenum == 1) {
                    if (getBookListByKeyRsp.data.bookList.size() == 0) {
                        ToastUtil.showBottomView(BookFragmentPage.this.requireContext(), "没有搜索到相关图书");
                    }
                    BookFragmentPage.this.adapter.notifyData(getBookListByKeyRsp.data.bookList);
                    return;
                }
                BookFragmentPage.this.adapter.notifyData(getBookListByKeyRsp.data.bookList);
            }
        }
    }

    public class BookBd extends BroadcastReceiver {
        public BookBd() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("Bookname")) {
                BookFragmentPage.this.bookname = intent.getStringExtra(AppMeasurementSdk.ConditionalUserProperty.NAME);
                BookFragmentPage.this.getData();
            }
        }
    }
}
