package com.yd.android_brand_mvp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.ttlock.bl.sdk.api.ExtendedBluetoothDevice;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.LockAddListItemBinding;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public class LockListAdapter extends RecyclerView.Adapter<DeviceViewHolder> {
    private static final int TIMEOUT = 5000;
    private Activity mContext;
    private onLockItemClick mListener;
    private LinkedList<ExtendedBluetoothDevice> mDataList = new LinkedList<>();
    private LinkedList<ExtendedBluetoothDevice> mAddStatusList = new LinkedList<>();
    private LinkedList<ExtendedBluetoothDevice> mNormalStatusList = new LinkedList<>();
    private long lastSyncTimeStamp = 0;

    public interface onLockItemClick {
        void onClick(ExtendedBluetoothDevice extendedBluetoothDevice);
    }

    public void setOnLockItemClick(onLockItemClick onlockitemclick) {
        this.mListener = onlockitemclick;
    }

    public LockListAdapter(Activity activity) {
        this.mContext = activity;
    }

    public synchronized void updateData(ExtendedBluetoothDevice extendedBluetoothDevice) {
        if (extendedBluetoothDevice != null) {
            if (extendedBluetoothDevice.isSettingMode()) {
                addOrSortLock(extendedBluetoothDevice, this.mAddStatusList);
                removeOtherStatusLock(extendedBluetoothDevice, this.mNormalStatusList);
            } else {
                addOrSortLock(extendedBluetoothDevice, this.mNormalStatusList);
                removeOtherStatusLock(extendedBluetoothDevice, this.mAddStatusList);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastSyncTimeStamp >= 800) {
                if (!this.mDataList.isEmpty()) {
                    this.mDataList.clear();
                }
                this.mDataList.addAll(0, this.mAddStatusList);
                this.mDataList.addAll(this.mNormalStatusList);
                notifyDataSetChanged();
                this.lastSyncTimeStamp = jCurrentTimeMillis;
            }
        }
    }

    private void addOrSortLock(ExtendedBluetoothDevice extendedBluetoothDevice, LinkedList<ExtendedBluetoothDevice> linkedList) {
        int size = linkedList.size();
        extendedBluetoothDevice.setDate(System.currentTimeMillis());
        if (size > 0) {
            ExtendedBluetoothDevice extendedBluetoothDevice2 = linkedList.get(0);
            boolean z = false;
            for (int i = 0; i < size; i++) {
                ExtendedBluetoothDevice extendedBluetoothDevice3 = linkedList.get(i);
                if (extendedBluetoothDevice.getAddress().equals(extendedBluetoothDevice3.getAddress())) {
                    if (i != 0 && extendedBluetoothDevice.getRssi() > extendedBluetoothDevice2.getRssi()) {
                        linkedList.remove(i);
                        linkedList.add(0, extendedBluetoothDevice);
                    } else {
                        extendedBluetoothDevice3.setDate(System.currentTimeMillis());
                        linkedList.set(i, extendedBluetoothDevice3);
                    }
                    z = true;
                } else if (System.currentTimeMillis() - extendedBluetoothDevice3.getDate() >= 5000) {
                    linkedList.remove(i);
                    size = linkedList.size();
                }
            }
            if (z) {
                return;
            }
            if (extendedBluetoothDevice.getRssi() > extendedBluetoothDevice2.getRssi()) {
                linkedList.add(0, extendedBluetoothDevice);
                return;
            } else {
                linkedList.add(extendedBluetoothDevice);
                return;
            }
        }
        linkedList.add(extendedBluetoothDevice);
    }

    private void removeOtherStatusLock(ExtendedBluetoothDevice extendedBluetoothDevice, LinkedList<ExtendedBluetoothDevice> linkedList) {
        if (linkedList.isEmpty()) {
            return;
        }
        int size = linkedList.size();
        int i = 0;
        while (i < size) {
            ExtendedBluetoothDevice extendedBluetoothDevice2 = linkedList.get(i);
            if (extendedBluetoothDevice2.getAddress().equals(extendedBluetoothDevice.getAddress()) || System.currentTimeMillis() - extendedBluetoothDevice2.getDate() >= 5000) {
                linkedList.remove(i);
                size--;
            }
            i++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DeviceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DeviceViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.lock_add_list_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DeviceViewHolder deviceViewHolder, int i) {
        deviceViewHolder.Bind(this.mDataList.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDataList.size();
    }

    class DeviceViewHolder extends RecyclerView.ViewHolder {
        LockAddListItemBinding itemBinding;

        public DeviceViewHolder(View view) {
            super(view);
            this.itemBinding = (LockAddListItemBinding) DataBindingUtil.bind(view);
        }

        public void Bind(final ExtendedBluetoothDevice extendedBluetoothDevice) {
            this.itemBinding.tvLockName.setText("门锁编号：" + extendedBluetoothDevice.getName());
            this.itemBinding.ivSettingMode.setVisibility(extendedBluetoothDevice.isSettingMode() ? 0 : 8);
            if (extendedBluetoothDevice.isSettingMode()) {
                this.itemBinding.lj.setVisibility(0);
                this.itemBinding.lj2.setVisibility(8);
            } else {
                this.itemBinding.lj.setVisibility(8);
                this.itemBinding.lj2.setVisibility(0);
            }
            if (extendedBluetoothDevice.isSettingMode()) {
                this.itemBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$LockListAdapter$DeviceViewHolder$_FXzlMYXXsFg6XkytAz8UNVMHL4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$Bind$0$LockListAdapter$DeviceViewHolder(extendedBluetoothDevice, view);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$Bind$0$LockListAdapter$DeviceViewHolder(ExtendedBluetoothDevice extendedBluetoothDevice, View view) {
            if (extendedBluetoothDevice.isSettingMode() && LockListAdapter.this.mListener != null) {
                LockListAdapter.this.mListener.onClick(extendedBluetoothDevice);
            }
        }
    }
}
