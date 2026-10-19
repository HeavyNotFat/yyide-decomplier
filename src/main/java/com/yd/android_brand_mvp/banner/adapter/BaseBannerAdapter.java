package com.yd.android_brand_mvp.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.yd.android_brand_mvp.banner.holder.IBaseViewHolder;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseBannerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements IBaseViewHolder<T, VH> {
    private OnBannerListener mOnBannerListener;
    private VH mViewHolder;
    protected List<T> mDatas = new ArrayList();
    private int increaseCount = 2;

    public BaseBannerAdapter(List<T> list) {
        setDatas(list);
    }

    public void setDatas(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mDatas = list;
        notifyDataSetChanged();
    }

    public T getData(int i) {
        return this.mDatas.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH vh, int i) {
        this.mViewHolder = vh;
        final int realPosition = getRealPosition(i);
        onBindView(vh, this.mDatas.get(realPosition), realPosition, getRealCount(), i);
        if (this.mOnBannerListener != null) {
            vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.banner.adapter.-$$Lambda$BaseBannerAdapter$tJtcb8-ff161wr61gGK7qePKBqs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onBindViewHolder$0$BaseBannerAdapter(realPosition, view);
                }
            });
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public /* synthetic */ void lambda$onBindViewHolder$0$BaseBannerAdapter(int i, View view) {
        this.mOnBannerListener.OnBannerClick(this.mDatas.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getRealCount() > 1 ? getRealCount() + this.increaseCount : getRealCount();
    }

    public int getRealCount() {
        List<T> list = this.mDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getRealPosition(int i) {
        return BannerUtils.getRealPosition(this.increaseCount == 2, i, getRealCount());
    }

    public void setOnBannerListener(OnBannerListener onBannerListener) {
        this.mOnBannerListener = onBannerListener;
    }

    public VH getViewHolder() {
        return this.mViewHolder;
    }

    public void setIncreaseCount(int i) {
        this.increaseCount = i;
    }
}
