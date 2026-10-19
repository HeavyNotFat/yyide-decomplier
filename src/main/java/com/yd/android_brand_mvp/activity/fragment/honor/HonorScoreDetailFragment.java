package com.yd.android_brand_mvp.activity.fragment.honor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentHonorScoreDetailBinding;
import com.yd.android_brand_mvp.databinding.ItemHonorRuleChildBinding;
import com.yyide.chatim_pro.model.honor.DetailList;
import com.yyide.chatim_pro.model.honor.HonorScoreDetailBean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorScoreDetailFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorScoreDetailFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHonorScoreDetailBinding;", "()V", "mAdapter", "com/yd/android_brand_mvp/activity/fragment/honor/HonorScoreDetailFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorScoreDetailFragment$mAdapter$1;", "mHonorScoreDetailBean", "Lcom/yyide/chatim_pro/model/honor/HonorScoreDetailBean;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorScoreDetailFragment extends KTBaseFragment<FragmentHonorScoreDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HonorScoreDetailFragment$mAdapter$1 mAdapter;
    private HonorScoreDetailBean mHonorScoreDetailBean;

    @JvmStatic
    public static final HonorScoreDetailFragment newInstance(HonorScoreDetailBean honorScoreDetailBean) {
        return INSTANCE.newInstance(honorScoreDetailBean);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreDetailFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorScoreDetailFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHonorScoreDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHonorScoreDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHonorScoreDetailBinding;", 0);
        }

        public final FragmentHonorScoreDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHonorScoreDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHonorScoreDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreDetailFragment$mAdapter$1] */
    public HonorScoreDetailFragment() {
        super(AnonymousClass1.INSTANCE);
        this.mAdapter = new BaseQuickAdapter<DetailList, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorScoreDetailFragment$mAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, DetailList item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemHonorRuleChildBinding itemHonorRuleChildBindingBind = ItemHonorRuleChildBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemHonorRuleChildBindingBind, "bind(holder.itemView)");
                itemHonorRuleChildBindingBind.tvName.setText(item.getSort() + ". " + item.getProjectName());
                Double writeScore = item.getWriteScore();
                Intrinsics.checkNotNull(writeScore);
                if (writeScore.doubleValue() > 0.0d) {
                    TextView textView = itemHonorRuleChildBindingBind.tvScore;
                    StringBuilder sb = new StringBuilder();
                    sb.append('+');
                    sb.append(item.getWriteScore());
                    sb.append((char) 20998);
                    textView.setText(sb.toString());
                    itemHonorRuleChildBindingBind.tvScore.setTextColor(getContext().getResources().getColor(R.color.purple2));
                    return;
                }
                TextView textView2 = itemHonorRuleChildBindingBind.tvScore;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(item.getWriteScore());
                sb2.append((char) 20998);
                textView2.setText(sb2.toString());
                itemHonorRuleChildBindingBind.tvScore.setTextColor(getContext().getResources().getColor(R.color.red_FD4F45));
            }
        };
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mHonorScoreDetailBean = (HonorScoreDetailBean) arguments.getSerializable("data");
        }
        initView();
    }

    /* JADX INFO: compiled from: HonorScoreDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorScoreDetailFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorScoreDetailFragment;", "mHonorScoreDetailBean", "Lcom/yyide/chatim_pro/model/honor/HonorScoreDetailBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HonorScoreDetailFragment newInstance(HonorScoreDetailBean mHonorScoreDetailBean) {
            Intrinsics.checkNotNullParameter(mHonorScoreDetailBean, "mHonorScoreDetailBean");
            HonorScoreDetailFragment honorScoreDetailFragment = new HonorScoreDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", mHonorScoreDetailBean);
            honorScoreDetailFragment.setArguments(bundle);
            return honorScoreDetailFragment;
        }
    }

    private final void initView() {
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        TextView textView = getBinding().tvScore;
        HonorScoreDetailBean honorScoreDetailBean = this.mHonorScoreDetailBean;
        textView.setText(String.valueOf(honorScoreDetailBean != null ? honorScoreDetailBean.getScore() : null));
        HonorScoreDetailFragment$mAdapter$1 honorScoreDetailFragment$mAdapter$1 = this.mAdapter;
        HonorScoreDetailBean honorScoreDetailBean2 = this.mHonorScoreDetailBean;
        honorScoreDetailFragment$mAdapter$1.setList(honorScoreDetailBean2 != null ? honorScoreDetailBean2.getDetailList() : null);
    }
}
