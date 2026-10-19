package com.yd.android_brand_mvp.dialog;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.VHUtil;

/* JADX INFO: loaded from: classes4.dex */
public class Pop2 extends PopupWindow {
    RoomAdapter adapter;
    Activity context;
    TextView textView;

    public Pop2(Activity activity, TextView textView) {
        this.context = activity;
        this.textView = textView;
        init();
    }

    private void init() {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.layout_pop_dialog1, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2, true);
        ListView listView = (ListView) viewInflate.findViewById(R.id.list);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.layout);
        RoomAdapter roomAdapter = new RoomAdapter();
        this.adapter = roomAdapter;
        listView.setAdapter((ListAdapter) roomAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.yd.android_brand_mvp.dialog.Pop2.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Pop2.this.textView.setText(Pop2.this.adapter.getItem(i) + "");
                popupWindow.dismiss();
            }
        });
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        int[] iArr = new int[2];
        popupWindow.showAsDropDown(this.textView, iArr[0], iArr[1] + 20);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.yd.android_brand_mvp.dialog.Pop2.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MinaEventManager.getInstance().notifyObserver(MinaConstants.updateBook);
                Pop2.this.dismiss();
            }
        });
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.dialog.Pop2.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return false;
            }
        });
        viewInflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.dialog.Pop2.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Pop2.this.dismiss();
                return false;
            }
        });
    }

    private class RoomAdapter extends BaseAdapter {
        int index;
        String[] list;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private RoomAdapter() {
            this.list = new String[]{"任意", "书名", "作者", "出版社"};
            this.index = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.list.length;
        }

        @Override // android.widget.Adapter
        public String getItem(int i) {
            return this.list[i];
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_xz_item, (ViewGroup) null);
            }
            ((TextView) VHUtil.ViewHolder.get(view, R.id.name)).setText(getItem(i) + "");
            return view;
        }

        public void notiyfData(int i) {
            this.index = i;
            notifyDataSetChanged();
        }
    }
}
