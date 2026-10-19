package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hacknife.wifimanager.IWifi;
import com.yd.android_brand_mvp.R;
import java.util.ArrayList;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class WifiAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    private Context context;
    public ArrayList<IWifi> mData;
    private OnItemClickListener onItemClickListener;
    private RecyclerView recyclerView;

    public interface OnItemClickListener {
        void onItemClick(View view, int i);
    }

    public WifiAdapter(ArrayList<IWifi> arrayList, RecyclerView recyclerView) {
        this.mData = arrayList;
        this.recyclerView = recyclerView;
    }

    public void updateData(ArrayList<IWifi> arrayList) {
        this.mData = arrayList;
        for (int i = 0; i < this.mData.size(); i++) {
            Log.e("wick", this.mData.get(i).name());
        }
        Log.e("TAG", "  " + this.mData.size());
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wifi, viewGroup, false));
        this.context = viewGroup.getContext();
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.wifiIcon.setChecked(this.mData.get(i).level() <= -50);
        viewHolder.name.setText(this.mData.get(i).name());
        if (this.mData.get(i).isConnected()) {
            viewHolder.desc.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        }
        viewHolder.desc.setText(this.mData.get(i).description2());
        viewHolder.ll_wifi.setOnClickListener(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<IWifi> arrayList = this.mData;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int childAdapterPosition = this.recyclerView.getChildAdapterPosition(view);
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, childAdapterPosition);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView desc;
        RelativeLayout ll_wifi;
        TextView name;
        CheckedTextView wifiIcon;

        public ViewHolder(View view) {
            super(view);
            this.wifiIcon = (CheckedTextView) view.findViewById(R.id.ct_wifi);
            this.name = (TextView) view.findViewById(R.id.name);
            this.desc = (TextView) view.findViewById(R.id.desc);
            this.ll_wifi = (RelativeLayout) view.findViewById(R.id.ll_wifi);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
