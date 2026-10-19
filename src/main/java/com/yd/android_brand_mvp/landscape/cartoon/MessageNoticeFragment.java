package com.yd.android_brand_mvp.landscape.cartoon;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.MessageNoticeCartoonFragmentBinding;
import com.yd.android_brand_mvp.landscape.cartoon.adapter.CartoonMessageNoticeAdapter;
import com.yd.android_brand_mvp.landscape.cartoon.model.MessageNoticeViewModel;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import com.yd.android_brand_mvp.user.AnnouncementListActivity;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageNoticeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cartoon/MessageNoticeFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/MessageNoticeCartoonFragmentBinding;", "()V", "mAdapter", "Lcom/yd/android_brand_mvp/landscape/cartoon/adapter/CartoonMessageNoticeAdapter;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/cartoon/model/MessageNoticeViewModel;", "UpdataEvent", "", "id", "", "initModel", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "setData", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageNoticeFragment extends KTBaseFragment<MessageNoticeCartoonFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CartoonMessageNoticeAdapter mAdapter;
    private MessageNoticeViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.cartoon.MessageNoticeFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageNoticeFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, MessageNoticeCartoonFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, MessageNoticeCartoonFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/MessageNoticeCartoonFragmentBinding;", 0);
        }

        public final MessageNoticeCartoonFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return MessageNoticeCartoonFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ MessageNoticeCartoonFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ MessageNoticeCartoonFragmentBinding access$getBinding(MessageNoticeFragment messageNoticeFragment) {
        return messageNoticeFragment.getBinding();
    }

    public MessageNoticeFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: MessageNoticeFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/cartoon/MessageNoticeFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/cartoon/MessageNoticeFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MessageNoticeFragment newInstance() {
            return new MessageNoticeFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (MessageNoticeViewModel) new ViewModelProvider(this).get(MessageNoticeViewModel.class);
        initView();
        initModel();
    }

    private final void initView() {
        getBinding().mu.setViewState(2);
        getBinding().gankImageview4.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.cartoon.-$$Lambda$MessageNoticeFragment$4I35RCkKnwXz0fKSQHMTbzlv8cs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageNoticeFragment.initView$lambda$0(this.f$0, view);
            }
        });
        MessageNoticeViewModel messageNoticeViewModel = this.viewModel;
        if (messageNoticeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageNoticeViewModel = null;
        }
        messageNoticeViewModel.getAnnouncement(AnnouncementListActivity.TYPE_ANNOUNCEMENT, 1);
        getBinding().mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.cartoon.-$$Lambda$MessageNoticeFragment$wEiqdp8Xx70cm9v08tLK6AXsS1c
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public final void reload() {
                MessageNoticeFragment.initView$lambda$1(this.f$0);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this.mAdapter = new CartoonMessageNoticeAdapter(contextRequireContext, null);
        getBinding().noticeBanner.addBannerLifecycleObserver(this).setStartPosition(1).setAdapter(this.mAdapter).isAutoLoop(true).setLoopTime(5000L).setIndicator(new CircleIndicator(requireContext())).setIndicatorGravity(1).setIndicatorSpace(BannerUtils.dp2px(6.0f)).setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray)).setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue12)).setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f)).setIndicatorHeight(BannerUtils.dp2px(10.0f));
        CartoonMessageNoticeAdapter cartoonMessageNoticeAdapter = this.mAdapter;
        if (cartoonMessageNoticeAdapter != null) {
            cartoonMessageNoticeAdapter.setItemClick(new CartoonMessageNoticeAdapter.ItemClick() { // from class: com.yd.android_brand_mvp.landscape.cartoon.MessageNoticeFragment.initView.3
                @Override // com.yd.android_brand_mvp.landscape.cartoon.adapter.CartoonMessageNoticeAdapter.ItemClick
                public void onItemClick() {
                    MessageNoticeFragment.this.goPermissionsActivity(AnnouncementListActivity.class);
                }
            });
        }
        getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.cartoon.-$$Lambda$MessageNoticeFragment$-T8nbaUCSD9RDHwfWYwEWBlVEQI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageNoticeFragment.initView$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(MessageNoticeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.goPermissionsActivity(AnnouncementListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(MessageNoticeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MessageNoticeViewModel messageNoticeViewModel = this$0.viewModel;
        if (messageNoticeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageNoticeViewModel = null;
        }
        messageNoticeViewModel.getAnnouncement(AnnouncementListActivity.TYPE_ANNOUNCEMENT, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(MessageNoticeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.goPermissionsActivity(AnnouncementListActivity.class);
    }

    private final void initModel() {
        MessageNoticeViewModel messageNoticeViewModel = this.viewModel;
        if (messageNoticeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageNoticeViewModel = null;
        }
        final Function1<Result<? extends getNoticeRsp.DataDTO>, Unit> function1 = new Function1<Result<? extends getNoticeRsp.DataDTO>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.cartoon.MessageNoticeFragment.initModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends getNoticeRsp.DataDTO> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends getNoticeRsp.DataDTO> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (!Result.m598isSuccessimpl(it2.getValue())) {
                    MessageNoticeFragment.this.setData();
                    return;
                }
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                getNoticeRsp.DataDTO dataDTO = (getNoticeRsp.DataDTO) value;
                SPUtils.getInstance().put(SpData.Announcement5, JSON.toJSONString(it2));
                if ((dataDTO != null ? dataDTO.list : null) == null || dataDTO.list.size() <= 0) {
                    MessageNoticeFragment.this.setData();
                } else {
                    MessageNoticeFragment.access$getBinding(MessageNoticeFragment.this).mu.setViewState(0);
                    MessageNoticeFragment.access$getBinding(MessageNoticeFragment.this).noticeBanner.setDatas(dataDTO.list);
                }
            }
        };
        messageNoticeViewModel.getNoticeLiveData().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.landscape.cartoon.-$$Lambda$MessageNoticeFragment$Zg6piZhwyGQMKeQdmhMY4z9Eql0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MessageNoticeFragment.initModel$lambda$3(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initModel$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData() {
        if (SpData.getAnnouncement5() != null && SpData.getAnnouncement5().data != null && SpData.getAnnouncement5().data.list != null && SpData.getAnnouncement5().data.list.size() > 0) {
            getBinding().mu.setViewState(0);
            getBinding().noticeBanner.setDatas(SpData.getAnnouncement5().data.list);
        } else {
            getBinding().mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (id == MinaConstants.Notice) {
            MessageNoticeViewModel messageNoticeViewModel = this.viewModel;
            if (messageNoticeViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                messageNoticeViewModel = null;
            }
            messageNoticeViewModel.getAnnouncement(AnnouncementListActivity.TYPE_ANNOUNCEMENT, 1);
        }
    }
}
