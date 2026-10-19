package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.blankj.utilcode.util.SPUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.utils.VHUtil;

/* JADX INFO: loaded from: classes4.dex */
public class SeirPortDiallog extends BaseDialog implements View.OnClickListener {
    serialAdapter adapter;
    TextView cancel;
    Context context;
    ListView list;
    TextView now_text;
    TextView ok;
    String[] str;

    public SeirPortDiallog(Context context, int i) {
        super(context, i);
    }

    public SeirPortDiallog(Context context) {
        this(context, R.style.shareDialog);
        this.context = context;
        this.str = context.getResources().getStringArray(R.array.Serial_item);
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_seirport_landscape);
        this.cancel = (TextView) findViewById(R.id.cancel);
        this.ok = (TextView) findViewById(R.id.ok);
        this.list = (ListView) findViewById(R.id.list);
        this.now_text = (TextView) findViewById(R.id.now_text);
        this.ok.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        serialAdapter serialadapter = new serialAdapter();
        this.adapter = serialadapter;
        this.list.setAdapter((ListAdapter) serialadapter);
        String strValueOf = String.valueOf(SPUtils.getInstance().getString("serialPort", BaseConstant.SPORT3));
        this.now_text.setText("当前串口：" + strValueOf);
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.SeirPortDiallog.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SeirPortDiallog.this.adapter.notifydata(i);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel) {
            cancel();
            return;
        }
        if (id != R.id.ok) {
            return;
        }
        String strValueOf = null;
        if (this.adapter.index != -1) {
            serialAdapter serialadapter = this.adapter;
            strValueOf = String.valueOf(serialadapter.getItem(serialadapter.index));
            Log.e("TAG", "onClick: " + strValueOf);
        }
        if (strValueOf == null) {
            Toast.makeText(this.context, "请设置串口", 0).show();
            return;
        }
        SPUtils.getInstance().put("serialPort", strValueOf);
        Log.e("设置串口", "onClick: " + strValueOf);
        new MsgDiallog(this.context, "设置串口成功，请重新启动").show();
        cancel();
    }

    class serialAdapter extends BaseAdapter {
        int index = -1;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        serialAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SeirPortDiallog.this.str.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return SeirPortDiallog.this.str[i];
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.seirport_item, (ViewGroup) null, false);
            }
            CheckedTextView checkedTextView = (CheckedTextView) VHUtil.ViewHolder.get(view, R.id.item);
            checkedTextView.setText(String.valueOf(getItem(i)));
            if (this.index == i) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return view;
        }

        void notifydata(int i) {
            this.index = i;
            notifyDataSetChanged();
        }
    }
}
