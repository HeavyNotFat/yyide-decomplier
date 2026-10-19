package com.yd.android_brand_mvp.landscape.cartoon;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.honor.fragment.HomeHonorFragment;
import com.yd.android_brand_mvp.banner.BannerImageFragment;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.CartoonMenuFragmentBinding;
import com.yd.android_brand_mvp.databinding.ItemCartoonMenuBinding;
import com.yd.android_brand_mvp.landscape.BookYwFragmentL;
import com.yd.android_brand_mvp.landscape.ClassScheduleFragment4_6L;
import com.yd.android_brand_mvp.landscape.cartoon.model.CartoonMenuViewModel;
import com.yd.android_brand_mvp.landscape.honor.HonorCartoonFragment;
import com.yd.android_brand_mvp.landscape.video.VideoFragment;
import com.yd.android_brand_mvp.model.LayoutListRsp;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CartoonMenuFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0011\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cartoon/CartoonMenuFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/CartoonMenuFragmentBinding;", "()V", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/LayoutListRsp$DataBean$LayoutClassSignDetailsEntityListBean;", "getList", "()Ljava/util/List;", "mBannerImageFragment", "Landroidx/fragment/app/Fragment;", "mBookYwFragmentL", "mClassScheduleFragment4_6L", "mHomeHonorFragment", "mHonorCartoonFragment", "mVideoFragment", "menuAdapter", "com/yd/android_brand_mvp/landscape/cartoon/CartoonMenuFragment$menuAdapter$1", "Lcom/yd/android_brand_mvp/landscape/cartoon/CartoonMenuFragment$menuAdapter$1;", "tagType", "", "viewModel", "Lcom/yd/android_brand_mvp/landscape/cartoon/model/CartoonMenuViewModel;", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "setFragment", RemoteMessageConst.Notification.TAG, "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CartoonMenuFragment extends KTBaseFragment<CartoonMenuFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DATA = "data";
    private final List<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean> list;
    private Fragment mBannerImageFragment;
    private Fragment mBookYwFragmentL;
    private Fragment mClassScheduleFragment4_6L;
    private Fragment mHomeHonorFragment;
    private Fragment mHonorCartoonFragment;
    private Fragment mVideoFragment;
    private final CartoonMenuFragment$menuAdapter$1 menuAdapter;
    private String tagType;
    private CartoonMenuViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.cartoon.CartoonMenuFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CartoonMenuFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, CartoonMenuFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, CartoonMenuFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/CartoonMenuFragmentBinding;", 0);
        }

        public final CartoonMenuFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return CartoonMenuFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ CartoonMenuFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.yd.android_brand_mvp.landscape.cartoon.CartoonMenuFragment$menuAdapter$1] */
    public CartoonMenuFragment() {
        super(AnonymousClass1.INSTANCE);
        this.tagType = "";
        this.list = new ArrayList();
        this.menuAdapter = new BaseQuickAdapter<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.cartoon.CartoonMenuFragment$menuAdapter$1
            {
                super(R.layout.item_cartoon_menu, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemCartoonMenuBinding itemCartoonMenuBindingBind = ItemCartoonMenuBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemCartoonMenuBindingBind, "bind(holder.itemView)");
                itemCartoonMenuBindingBind.tvMenuName.setText(item.descriptive);
                if (TextUtils.isEmpty(this.this$0.tagType) || !Intrinsics.areEqual(this.this$0.tagType, item.tag)) {
                    itemCartoonMenuBindingBind.constraintlayout.setBackgroundResource(R.color.transparent);
                } else {
                    itemCartoonMenuBindingBind.constraintlayout.setBackgroundResource(R.drawable.shape_while_top_left_20);
                }
                String str = item.tag;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -1223747053:
                            if (str.equals("hbkb46")) {
                                itemCartoonMenuBindingBind.ivCover.setImageResource(R.mipmap.icon_cartoon_menu_table_day);
                                break;
                            }
                            break;
                        case 551781217:
                            if (str.equals("hbbjsp46")) {
                                itemCartoonMenuBindingBind.ivCover.setImageResource(R.mipmap.icon_cartoon_menu_video);
                                break;
                            }
                            break;
                        case 551917679:
                            if (str.equals("hbbjxc46")) {
                                itemCartoonMenuBindingBind.ivCover.setImageResource(R.mipmap.icon_cartoon_menu_xc);
                                break;
                            }
                            break;
                        case 725755474:
                            if (str.equals("hbryq46")) {
                                itemCartoonMenuBindingBind.ivCover.setImageResource(R.mipmap.icon_cardoon_menu_honor);
                                break;
                            }
                            break;
                        case 727414160:
                            if (str.equals("hbtsg46")) {
                                itemCartoonMenuBindingBind.ivCover.setImageResource(R.mipmap.icon_cardoon_menu_book);
                                break;
                            }
                            break;
                        case 1181622539:
                            if (str.equals("hbxjsp46")) {
                                itemCartoonMenuBindingBind.ivCover.setImageResource(R.mipmap.icon_cardoon_menu_school_video);
                                break;
                            }
                            break;
                        case 1181759001:
                            if (str.equals("hbxjxc46")) {
                                itemCartoonMenuBindingBind.ivCover.setImageResource(R.mipmap.icon_cardoon_menu_capusm);
                                break;
                            }
                            break;
                        case 1189839089:
                            if (str.equals("hbxspj46")) {
                                itemCartoonMenuBindingBind.ivCover.setImageResource(R.mipmap.icon_cartoon_menu_comment);
                                break;
                            }
                            break;
                    }
                }
            }
        };
    }

    /* JADX INFO: compiled from: CartoonMenuFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cartoon/CartoonMenuFragment$Companion;", "", "()V", "DATA", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/cartoon/CartoonMenuFragment;", "bean", "Lcom/yd/android_brand_mvp/model/LayoutListRsp$DataBean$LayoutClassSignDetailsEntityListBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CartoonMenuFragment newInstance(LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean bean) {
            CartoonMenuFragment cartoonMenuFragment = new CartoonMenuFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", bean);
            cartoonMenuFragment.setArguments(bundle);
            return cartoonMenuFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (CartoonMenuViewModel) new ViewModelProvider(this).get(CartoonMenuViewModel.class);
        initView();
    }

    public final List<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean> getList() {
        return this.list;
    }

    private final void initView() {
        getBinding().menuRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().menuRecyclerView.setAdapter(this.menuAdapter);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("data") : null;
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.yd.android_brand_mvp.model.LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean");
        LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean layoutClassSignDetailsEntityListBean = (LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean) serializable;
        String str = layoutClassSignDetailsEntityListBean.layoutClassSignDetailsEntityList.get(0).tag;
        Intrinsics.checkNotNullExpressionValue(str, "it.layoutClassSignDetailsEntityList[0].tag");
        setFragment(str);
        setList(layoutClassSignDetailsEntityListBean.layoutClassSignDetailsEntityList);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.cartoon.-$$Lambda$CartoonMenuFragment$dcd5hctJqYFh3EzwH78LlEeYZeg
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CartoonMenuFragment.initView$lambda$1$lambda$0(this.f$0, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(CartoonMenuFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        String str = this$0.menuAdapter.getItem(i).tag;
        Intrinsics.checkNotNullExpressionValue(str, "menuAdapter.getItem(position).tag");
        this$0.setFragment(str);
        String str2 = this$0.menuAdapter.getItem(i).tag;
        Intrinsics.checkNotNullExpressionValue(str2, "menuAdapter.getItem(position).tag");
        this$0.tagType = str2;
        this$0.menuAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0163  */
    /* JADX WARN: Code duplicated, block: B:63:0x0167  */
    /* JADX WARN: Code duplicated, block: B:64:0x0184  */
    /* JADX WARN: Code duplicated, block: B:68:0x0194  */
    /* JADX WARN: Code duplicated, block: B:70:0x0198  */
    /* JADX WARN: Code duplicated, block: B:71:0x01b6  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void setFragment(String tag) {
        Fragment fragment;
        Fragment fragment2;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fm.beginTransaction()");
        if (TextUtils.isEmpty(this.tagType) || !Intrinsics.areEqual(this.tagType, tag)) {
            if (TextUtils.isEmpty(this.tagType)) {
                this.tagType = tag;
            }
            this.mBannerImageFragment = childFragmentManager.findFragmentByTag("1");
            this.mVideoFragment = childFragmentManager.findFragmentByTag("2");
            this.mClassScheduleFragment4_6L = childFragmentManager.findFragmentByTag("3");
            this.mHonorCartoonFragment = childFragmentManager.findFragmentByTag("4");
            this.mHomeHonorFragment = childFragmentManager.findFragmentByTag(ConversionUtil.conditionWithSeriesName);
            this.mBookYwFragmentL = childFragmentManager.findFragmentByTag(ConversionUtil.conditionWithCallNumber);
            Fragment fragment3 = this.mBannerImageFragment;
            if (fragment3 != null) {
                Intrinsics.checkNotNull(fragment3);
                fragmentTransactionBeginTransaction.hide(fragment3);
            }
            Fragment fragment4 = this.mVideoFragment;
            if (fragment4 != null) {
                Intrinsics.checkNotNull(fragment4);
                fragmentTransactionBeginTransaction.hide(fragment4);
            }
            Fragment fragment5 = this.mClassScheduleFragment4_6L;
            if (fragment5 != null) {
                Intrinsics.checkNotNull(fragment5);
                fragmentTransactionBeginTransaction.hide(fragment5);
            }
            Fragment fragment6 = this.mHonorCartoonFragment;
            if (fragment6 != null) {
                Intrinsics.checkNotNull(fragment6);
                fragmentTransactionBeginTransaction.hide(fragment6);
            }
            Fragment fragment7 = this.mHomeHonorFragment;
            if (fragment7 != null) {
                Intrinsics.checkNotNull(fragment7);
                fragmentTransactionBeginTransaction.hide(fragment7);
            }
            Fragment fragment8 = this.mBookYwFragmentL;
            if (fragment8 != null) {
                Intrinsics.checkNotNull(fragment8);
                fragmentTransactionBeginTransaction.hide(fragment8);
            }
            switch (tag.hashCode()) {
                case -1223747053:
                    if (tag.equals("hbkb46")) {
                        Fragment fragment9 = this.mClassScheduleFragment4_6L;
                        if (fragment9 != null) {
                            Intrinsics.checkNotNull(fragment9);
                            fragmentTransactionBeginTransaction.show(fragment9);
                        } else {
                            this.mClassScheduleFragment4_6L = new ClassScheduleFragment4_6L();
                            int id = getBinding().containerView.getId();
                            Fragment fragment10 = this.mClassScheduleFragment4_6L;
                            Intrinsics.checkNotNull(fragment10);
                            fragmentTransactionBeginTransaction.add(id, fragment10, "3");
                        }
                    }
                    break;
                case 551781217:
                    if (tag.equals("hbbjsp46")) {
                        fragment = this.mVideoFragment;
                        if (fragment == null) {
                            Intrinsics.checkNotNull(fragment);
                            fragmentTransactionBeginTransaction.show(fragment);
                        } else {
                            this.mVideoFragment = VideoFragment.newInstance(tag, 0);
                            int id2 = getBinding().containerView.getId();
                            Fragment fragment11 = this.mVideoFragment;
                            Intrinsics.checkNotNull(fragment11);
                            fragmentTransactionBeginTransaction.add(id2, fragment11, "2");
                        }
                    }
                    break;
                case 551917679:
                    if (tag.equals("hbbjxc46")) {
                        fragment2 = this.mBannerImageFragment;
                        if (fragment2 == null) {
                            Intrinsics.checkNotNull(fragment2);
                            fragmentTransactionBeginTransaction.show(fragment2);
                        } else {
                            this.mBannerImageFragment = BannerImageFragment.newInstance(tag);
                            int id3 = getBinding().containerView.getId();
                            Fragment fragment12 = this.mBannerImageFragment;
                            Intrinsics.checkNotNull(fragment12);
                            fragmentTransactionBeginTransaction.add(id3, fragment12, "1");
                        }
                    }
                    break;
                case 725755474:
                    if (tag.equals("hbryq46")) {
                        Fragment fragment13 = this.mHomeHonorFragment;
                        if (fragment13 != null) {
                            Intrinsics.checkNotNull(fragment13);
                            fragmentTransactionBeginTransaction.show(fragment13);
                        } else {
                            this.mHomeHonorFragment = HomeHonorFragment.INSTANCE.newInstance(tag);
                            int id4 = getBinding().containerView.getId();
                            Fragment fragment14 = this.mHomeHonorFragment;
                            Intrinsics.checkNotNull(fragment14);
                            fragmentTransactionBeginTransaction.add(id4, fragment14, ConversionUtil.conditionWithSeriesName);
                        }
                    }
                    break;
                case 727414160:
                    if (tag.equals("hbtsg46")) {
                        Fragment fragment15 = this.mBookYwFragmentL;
                        if (fragment15 != null) {
                            Intrinsics.checkNotNull(fragment15);
                            fragmentTransactionBeginTransaction.show(fragment15);
                        } else {
                            this.mBookYwFragmentL = new BookYwFragmentL();
                            int id5 = getBinding().containerView.getId();
                            Fragment fragment16 = this.mBookYwFragmentL;
                            Intrinsics.checkNotNull(fragment16);
                            fragmentTransactionBeginTransaction.add(id5, fragment16, ConversionUtil.conditionWithCallNumber);
                        }
                    }
                    break;
                case 1181622539:
                    if (tag.equals("hbxjsp46")) {
                        fragment = this.mVideoFragment;
                        if (fragment == null) {
                            Intrinsics.checkNotNull(fragment);
                            fragmentTransactionBeginTransaction.show(fragment);
                        } else {
                            this.mVideoFragment = VideoFragment.newInstance(tag, 0);
                            int id6 = getBinding().containerView.getId();
                            Fragment fragment17 = this.mVideoFragment;
                            Intrinsics.checkNotNull(fragment17);
                            fragmentTransactionBeginTransaction.add(id6, fragment17, "2");
                        }
                    }
                    break;
                case 1181759001:
                    if (tag.equals("hbxjxc46")) {
                        fragment2 = this.mBannerImageFragment;
                        if (fragment2 == null) {
                            Intrinsics.checkNotNull(fragment2);
                            fragmentTransactionBeginTransaction.show(fragment2);
                        } else {
                            this.mBannerImageFragment = BannerImageFragment.newInstance(tag);
                            int id7 = getBinding().containerView.getId();
                            Fragment fragment18 = this.mBannerImageFragment;
                            Intrinsics.checkNotNull(fragment18);
                            fragmentTransactionBeginTransaction.add(id7, fragment18, "1");
                        }
                    }
                    break;
                case 1189839089:
                    if (tag.equals("hbxspj46")) {
                        Fragment fragment19 = this.mHonorCartoonFragment;
                        if (fragment19 != null) {
                            Intrinsics.checkNotNull(fragment19);
                            fragmentTransactionBeginTransaction.show(fragment19);
                        } else {
                            this.mHonorCartoonFragment = HonorCartoonFragment.INSTANCE.newInstance(tag);
                            int id8 = getBinding().containerView.getId();
                            Fragment fragment20 = this.mHonorCartoonFragment;
                            Intrinsics.checkNotNull(fragment20);
                            fragmentTransactionBeginTransaction.add(id8, fragment20, "4");
                        }
                    }
                    break;
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        }
    }
}
