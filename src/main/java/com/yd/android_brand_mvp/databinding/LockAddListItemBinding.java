package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LockAddListItemBinding extends ViewDataBinding {
    public final ImageView ivSettingMode;
    public final TextView lj;
    public final TextView lj2;
    public final TextView tvLockName;

    protected LockAddListItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.ivSettingMode = imageView;
        this.lj = textView;
        this.lj2 = textView2;
        this.tvLockName = textView3;
    }

    public static LockAddListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LockAddListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LockAddListItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.lock_add_list_item, viewGroup, z, obj);
    }

    public static LockAddListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LockAddListItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LockAddListItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.lock_add_list_item, null, false, obj);
    }

    public static LockAddListItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LockAddListItemBinding bind(View view, Object obj) {
        return (LockAddListItemBinding) bind(obj, view, R.layout.lock_add_list_item);
    }
}
