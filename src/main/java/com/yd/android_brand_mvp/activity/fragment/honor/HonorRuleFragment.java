package com.yd.android_brand_mvp.activity.fragment.honor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.HonorRuleFragmentBinding;
import com.yd.android_brand_mvp.databinding.ItemHonorRuleChildBinding;
import com.yd.android_brand_mvp.model.honor.HonorRuleGroup;
import com.yyide.chatim_pro.activity.honor.viewmodel.HonorRuleViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorRuleFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorRuleFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/HonorRuleFragmentBinding;", "()V", "mAdapter", "com/yd/android_brand_mvp/activity/fragment/honor/HonorRuleFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorRuleFragment$mAdapter$1;", "viewModel", "Lcom/yyide/chatim_pro/activity/honor/viewmodel/HonorRuleViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "setRuleList", "dataList", "", "Lcom/yd/android_brand_mvp/model/honor/HonorRuleGroup;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorRuleFragment extends KTBaseFragment<HonorRuleFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HonorRuleFragment$mAdapter$1 mAdapter;
    private HonorRuleViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.honor.HonorRuleFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorRuleFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, HonorRuleFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, HonorRuleFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/HonorRuleFragmentBinding;", 0);
        }

        public final HonorRuleFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return HonorRuleFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ HonorRuleFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.yd.android_brand_mvp.activity.fragment.honor.HonorRuleFragment$mAdapter$1] */
    public HonorRuleFragment() {
        super(AnonymousClass1.INSTANCE);
        this.mAdapter = new BaseQuickAdapter<HonorRuleGroup, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorRuleFragment$mAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, HonorRuleGroup item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemHonorRuleChildBinding itemHonorRuleChildBindingBind = ItemHonorRuleChildBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemHonorRuleChildBindingBind, "bind(holder.itemView)");
                itemHonorRuleChildBindingBind.tvName.setText((holder.getAdapterPosition() + 1) + ". " + item.getProjectName());
                TextView textView = itemHonorRuleChildBindingBind.tvScore;
                StringBuilder sb = new StringBuilder();
                sb.append(item.getMinScore());
                sb.append('~');
                sb.append(item.getMaxScore());
                sb.append((char) 20998);
                textView.setText(sb.toString());
                itemHonorRuleChildBindingBind.tvScore.setTextColor(getContext().getResources().getColor(R.color.purple2));
            }
        };
    }

    /* JADX INFO: compiled from: HonorRuleFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorRuleFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorRuleFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HonorRuleFragment newInstance() {
            return new HonorRuleFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (HonorRuleViewModel) new ViewModelProvider(this).get(HonorRuleViewModel.class);
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        setEmptyView(R.layout.layout_empty);
    }

    public final void setRuleList(List<HonorRuleGroup> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        setList(dataList);
    }
}
