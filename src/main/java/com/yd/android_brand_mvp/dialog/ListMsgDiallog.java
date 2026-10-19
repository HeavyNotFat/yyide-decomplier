package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ListmsgAdapter4_2l;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yyide.facepass.database.FacePeople;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ListMsgDiallog extends BaseDialog {
    ListmsgAdapter4_2l adapter4_2l;
    Context context;
    List<FacePeople> list;
    TextView msg;
    public RecyclerView recyclerView;
    String str;

    public ListMsgDiallog(Context context, int i) {
        super(context, i);
        this.str = "设置串口成功,请重新启动";
    }

    public ListMsgDiallog(Context context, List<FacePeople> list) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.list = list;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.list_msg_layout);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyleview);
        this.adapter4_2l = new ListmsgAdapter4_2l(R.layout.face_item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        linearLayoutManager.setOrientation(1);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setAdapter(this.adapter4_2l);
        this.adapter4_2l.setList(this.list);
    }
}
