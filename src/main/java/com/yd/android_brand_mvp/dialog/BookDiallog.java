package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.BookYwAssetsAdatper;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.model.BookassetsRsp;
import com.yd.android_brand_mvp.model.ctrlNoRsp;
import com.yd.android_brand_mvp.utils.GlideUtil;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BookDiallog extends BaseDialog {
    TextView author;
    TextView bookn;
    TextView bookn2;
    TextView bookname;
    TextView bq;
    Context context;
    TextView fl;
    TextView fx;
    TextView ip;
    TextView jy;
    List<BookassetsRsp> list;
    ImageView photo_view;
    RecyclerView recyclerView;
    ctrlNoRsp rsp;
    String str;
    TextView time;
    TextView xt;
    TextView zt;

    public BookDiallog(Context context, int i) {
        super(context, i);
        this.str = "设置串口成功,请重新启动";
    }

    public BookDiallog(Context context, ctrlNoRsp ctrlnorsp, List<BookassetsRsp> list) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.rsp = ctrlnorsp;
        this.list = list;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.book_layout);
        this.bookname = (TextView) findViewById(R.id.bookname);
        this.bookn = (TextView) findViewById(R.id.bookn);
        this.bookn2 = (TextView) findViewById(R.id.bookn2);
        String str = this.rsp.title;
        if (str.length() > 13) {
            int length = str.length();
            this.bookn.setText(str.substring(0, 13));
            this.bookn2.setText(str.substring(13, length));
        } else {
            this.bookn.setText(this.rsp.title);
            this.bookn2.setText("");
        }
        this.photo_view = (ImageView) findViewById(R.id.photo_view);
        this.author = (TextView) findViewById(R.id.author);
        this.jy = (TextView) findViewById(R.id.jy);
        this.ip = (TextView) findViewById(R.id.ip);
        this.fl = (TextView) findViewById(R.id.fl);
        this.fx = (TextView) findViewById(R.id.fx);
        this.bq = (TextView) findViewById(R.id.bq);
        this.xt = (TextView) findViewById(R.id.xt);
        this.time = (TextView) findViewById(R.id.time);
        this.zt = (TextView) findViewById(R.id.zt);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        BookYwAssetsAdatper bookYwAssetsAdatper = new BookYwAssetsAdatper(R.layout.ywbook_assets_item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(1);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setAdapter(bookYwAssetsAdatper);
        bookYwAssetsAdatper.setList(this.list);
        GlideUtil.loadBook(this.context, this.rsp.photo, this.photo_view);
        this.bookname.setText(this.rsp.title + "");
        this.author.setText(this.rsp.author + "");
        this.jy.setText(this.rsp.loanCount + "");
        this.ip.setText(this.rsp.stdNum + "");
        this.fl.setText(this.rsp.clc + "");
        this.fx.setText(this.rsp.publisher + "");
        this.bq.setText(this.rsp.edition + "");
        this.time.setText(this.rsp.pubDate + "");
        this.zt.setText(this.rsp.subjects + "");
        this.xt.setText(this.rsp.medium + "");
    }
}
