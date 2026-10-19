package com.yd.android_brand_mvp.landscape.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lxj.xpopup.XPopup;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.MessageHomeFragmentNewBinding;
import com.yd.android_brand_mvp.landscape.message.adapter.MessageAdapter;
import com.yd.android_brand_mvp.landscape.message.adapter.MessageCampusNewAdapter;
import com.yd.android_brand_mvp.landscape.message.adapter.MessageNewAdapter;
import com.yd.android_brand_mvp.landscape.message.adapter.MessageNoticeNewAdapter;
import com.yd.android_brand_mvp.landscape.message.adapter.MessagePosterNewAdapter;
import com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeNewViewModel;
import com.yd.android_brand_mvp.model.MessageDetail;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.observer.MinaListener;
import com.yd.android_brand_mvp.portrait.activity.MessageDetailsPActivity;
import com.yd.android_brand_mvp.user.AnnouncementListActivity;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.weight.ImageShowPopup;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: compiled from: MessageFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0016\u0010.\u001a\u00020 2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u000201H\u0002J(\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020100002\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00105\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/MessageFragment;", "Lcom/yd/android_brand_mvp/base/BaseFragment;", "Lcom/yd/android_brand_mvp/observer/MinaListener;", "()V", "ANNOUNCEMENT", "", "ARTICLE", "CAMPUSSTYLE", "NEWS", "POSTER", "RECEIVE", "TAG", "kotlin.jvm.PlatformType", "mArticleAdapter", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageAdapter;", "mFoundAdapter", "mMessageCampusAdapter", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageCampusNewAdapter;", "mMessageNewAdapter", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageNewAdapter;", "mMessageNoticeAdapter", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageNoticeNewAdapter;", "mMessagePosterAdapter", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessagePosterNewAdapter;", "newsIndex", "", "type", "viewBinding", "Lcom/yd/android_brand_mvp/databinding/MessageHomeFragmentNewBinding;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageHomeNewViewModel;", "UpdataEvent", "", "id", "initAdapter", "initView", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "setData", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "showImageDialog", "item", "splitList", "groupSize", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageFragment extends BaseFragment implements MinaListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE = "type";
    private MessageAdapter mArticleAdapter;
    private MessageAdapter mFoundAdapter;
    private MessageCampusNewAdapter mMessageCampusAdapter;
    private MessageNewAdapter mMessageNewAdapter;
    private MessageNoticeNewAdapter mMessageNoticeAdapter;
    private MessagePosterNewAdapter mMessagePosterAdapter;
    private int newsIndex;
    private MessageHomeFragmentNewBinding viewBinding;
    private MessageHomeNewViewModel viewModel;
    private final String TAG = MessageFragment.class.getSimpleName();
    private String type = AnnouncementListActivity.TYPE_ANNOUNCEMENT;
    private final String ANNOUNCEMENT = AnnouncementListActivity.TYPE_ANNOUNCEMENT;
    private final String NEWS = AnnouncementListActivity.TYPE_NEWS;
    private final String RECEIVE = AnnouncementListActivity.TYPE_RECEIVE;
    private final String ARTICLE = AnnouncementListActivity.TYPE_ARTICLE;
    private final String CAMPUSSTYLE = AnnouncementListActivity.TYPE_CAMPUSSTYLE;
    private final String POSTER = AnnouncementListActivity.TYPE_POSTER;

    /* JADX INFO: compiled from: MessageFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/MessageFragment$Companion;", "", "()V", "TYPE", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/message/MessageFragment;", "type", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MessageFragment newInstance(String type) {
            MessageFragment messageFragment = new MessageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            messageFragment.setArguments(bundle);
            return messageFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MessageHomeFragmentNewBinding messageHomeFragmentNewBindingInflate = MessageHomeFragmentNewBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(messageHomeFragmentNewBindingInflate, "inflate(inflater)");
        this.viewBinding = messageHomeFragmentNewBindingInflate;
        if (messageHomeFragmentNewBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBindingInflate = null;
        }
        ConstraintLayout root = messageHomeFragmentNewBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (MessageHomeNewViewModel) new ViewModelProvider(this).get(MessageHomeNewViewModel.class);
        initView();
        initAdapter();
        initViewModel();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void initView() {
        MessageHomeNewViewModel messageHomeNewViewModel;
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding = this.viewBinding;
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding2 = null;
        if (messageHomeFragmentNewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding = null;
        }
        messageHomeFragmentNewBinding.clNew.setVisibility(8);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding3 = this.viewBinding;
        if (messageHomeFragmentNewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding3 = null;
        }
        messageHomeFragmentNewBinding3.clnotice.setVisibility(8);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding4 = this.viewBinding;
        if (messageHomeFragmentNewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding4 = null;
        }
        messageHomeFragmentNewBinding4.clCampus.setVisibility(8);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding5 = this.viewBinding;
        if (messageHomeFragmentNewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding5 = null;
        }
        messageHomeFragmentNewBinding5.clarticle.setVisibility(8);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding6 = this.viewBinding;
        if (messageHomeFragmentNewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding6 = null;
        }
        messageHomeFragmentNewBinding6.clposter.setVisibility(8);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding7 = this.viewBinding;
        if (messageHomeFragmentNewBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding7 = null;
        }
        messageHomeFragmentNewBinding7.clfound.setVisibility(8);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding8 = this.viewBinding;
        if (messageHomeFragmentNewBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding8 = null;
        }
        messageHomeFragmentNewBinding8.muPoster.setViewState(2);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding9 = this.viewBinding;
        if (messageHomeFragmentNewBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding9 = null;
        }
        messageHomeFragmentNewBinding9.muCampus.setViewState(2);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string != null) {
            switch (string.hashCode()) {
                case -1337145237:
                    if (string.equals("sbxxfbgg44")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding10 = this.viewBinding;
                        if (messageHomeFragmentNewBinding10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding10 = null;
                        }
                        messageHomeFragmentNewBinding10.clnotice.setVisibility(0);
                        this.type = this.ANNOUNCEMENT;
                    }
                    break;
                case -1337120315:
                    if (string.equals("sbxxfbhb22")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding11 = this.viewBinding;
                        if (messageHomeFragmentNewBinding11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding11 = null;
                        }
                        messageHomeFragmentNewBinding11.clposter.setVisibility(0);
                        this.type = this.POSTER;
                    }
                    break;
                case -1336772433:
                    if (string.equals("sbxxfbsw22")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding12 = this.viewBinding;
                        if (messageHomeFragmentNewBinding12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding12 = null;
                        }
                        messageHomeFragmentNewBinding12.clfound.setVisibility(0);
                        this.type = this.RECEIVE;
                    }
                    break;
                case -1336650386:
                    if (string.equals("sbxxfbwz22")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding13 = this.viewBinding;
                        if (messageHomeFragmentNewBinding13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding13 = null;
                        }
                        messageHomeFragmentNewBinding13.clarticle.setVisibility(0);
                        this.type = this.ARTICLE;
                    }
                    break;
                case -1336623416:
                    if (string.equals("sbxxfbxw42")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding14 = this.viewBinding;
                        if (messageHomeFragmentNewBinding14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding14 = null;
                        }
                        messageHomeFragmentNewBinding14.clNew.setVisibility(0);
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding15 = this.viewBinding;
                        if (messageHomeFragmentNewBinding15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding15 = null;
                        }
                        messageHomeFragmentNewBinding15.clNew.getLayoutParams().width = SizeUtils.dp2px(660.0f);
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding16 = this.viewBinding;
                        if (messageHomeFragmentNewBinding16 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding16 = null;
                        }
                        messageHomeFragmentNewBinding16.clNew.getLayoutParams().height = SizeUtils.dp2px(424.0f);
                        this.type = this.NEWS;
                    }
                    break;
                case -1336623354:
                    if (string.equals("sbxxfbxw62")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding17 = this.viewBinding;
                        if (messageHomeFragmentNewBinding17 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding17 = null;
                        }
                        messageHomeFragmentNewBinding17.clNew.setVisibility(0);
                        this.type = this.NEWS;
                    }
                    break;
                case -1336621494:
                    if (string.equals("sbxxfbxy42")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding18 = this.viewBinding;
                        if (messageHomeFragmentNewBinding18 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding18 = null;
                        }
                        messageHomeFragmentNewBinding18.clCampus.setVisibility(0);
                        this.type = this.CAMPUSSTYLE;
                    }
                    break;
                case 824503256:
                    if (string.equals("hbxxfbgg24")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding19 = this.viewBinding;
                        if (messageHomeFragmentNewBinding19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding19 = null;
                        }
                        messageHomeFragmentNewBinding19.clnotice.setVisibility(0);
                        this.type = this.ANNOUNCEMENT;
                    }
                    break;
                case 824503258:
                    if (string.equals("hbxxfbgg26")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding20 = this.viewBinding;
                        if (messageHomeFragmentNewBinding20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding20 = null;
                        }
                        messageHomeFragmentNewBinding20.clnotice.setVisibility(0);
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding21 = this.viewBinding;
                        if (messageHomeFragmentNewBinding21 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding21 = null;
                        }
                        messageHomeFragmentNewBinding21.clnotice.getLayoutParams().height = SizeUtils.dp2px(916.0f);
                        this.type = this.ANNOUNCEMENT;
                    }
                    break;
                case 824528302:
                    if (string.equals("hbxxfbhb42")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding22 = this.viewBinding;
                        if (messageHomeFragmentNewBinding22 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding22 = null;
                        }
                        messageHomeFragmentNewBinding22.clposter.setVisibility(0);
                        this.type = this.POSTER;
                    }
                    break;
                case 824876122:
                    if (string.equals("hbxxfbsw22")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding23 = this.viewBinding;
                        if (messageHomeFragmentNewBinding23 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding23 = null;
                        }
                        messageHomeFragmentNewBinding23.clfound.setVisibility(0);
                        this.type = this.RECEIVE;
                    }
                    break;
                case 824998169:
                    if (string.equals("hbxxfbwz22")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding24 = this.viewBinding;
                        if (messageHomeFragmentNewBinding24 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding24 = null;
                        }
                        messageHomeFragmentNewBinding24.clarticle.setVisibility(0);
                        this.type = this.ARTICLE;
                    }
                    break;
                case 825025079:
                    if (string.equals("hbxxfbxw24")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding25 = this.viewBinding;
                        if (messageHomeFragmentNewBinding25 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding25 = null;
                        }
                        messageHomeFragmentNewBinding25.clNew.setVisibility(0);
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding26 = this.viewBinding;
                        if (messageHomeFragmentNewBinding26 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding26 = null;
                        }
                        messageHomeFragmentNewBinding26.clNew.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding27 = this.viewBinding;
                        if (messageHomeFragmentNewBinding27 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding27 = null;
                        }
                        messageHomeFragmentNewBinding27.clNew.getLayoutParams().height = SizeUtils.dp2px(604.0f);
                        this.type = this.NEWS;
                    }
                    break;
                case 825025141:
                    if (string.equals("hbxxfbxw44")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding28 = this.viewBinding;
                        if (messageHomeFragmentNewBinding28 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding28 = null;
                        }
                        messageHomeFragmentNewBinding28.clNew.setVisibility(0);
                        this.type = this.NEWS;
                    }
                    break;
                case 825027061:
                    if (string.equals("hbxxfbxy42")) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding29 = this.viewBinding;
                        if (messageHomeFragmentNewBinding29 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding29 = null;
                        }
                        messageHomeFragmentNewBinding29.clCampus.setVisibility(0);
                        this.type = this.CAMPUSSTYLE;
                    }
                    break;
                case 1081516067:
                    if (string.equals("hbtzgg25")) {
                        this.type = this.ANNOUNCEMENT;
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding30 = this.viewBinding;
                        if (messageHomeFragmentNewBinding30 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding30 = null;
                        }
                        messageHomeFragmentNewBinding30.clnotice.setVisibility(0);
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding31 = this.viewBinding;
                        if (messageHomeFragmentNewBinding31 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding31 = null;
                        }
                        messageHomeFragmentNewBinding31.clnotice.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding32 = this.viewBinding;
                        if (messageHomeFragmentNewBinding32 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding32 = null;
                        }
                        messageHomeFragmentNewBinding32.clnotice.getLayoutParams().height = SizeUtils.dp2px(760.0f);
                    }
                    break;
            }
        }
        MessageHomeNewViewModel messageHomeNewViewModel2 = this.viewModel;
        if (messageHomeNewViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageHomeNewViewModel = null;
        } else {
            messageHomeNewViewModel = messageHomeNewViewModel2;
        }
        MessageHomeNewViewModel.requestMessageHome$default(messageHomeNewViewModel, this.type, 0, 0, 6, null);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding33 = this.viewBinding;
        if (messageHomeFragmentNewBinding33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding33 = null;
        }
        messageHomeFragmentNewBinding33.clNew.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$Bgx5tcZZVKr7cRmMTt26urc8usY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageFragment.initView$lambda$0(this.f$0, view);
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding34 = this.viewBinding;
        if (messageHomeFragmentNewBinding34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding34 = null;
        }
        messageHomeFragmentNewBinding34.clfound.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$3_geHAVe08M-EEK_82ayhj_vXTo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageFragment.initView$lambda$1(this.f$0, view);
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding35 = this.viewBinding;
        if (messageHomeFragmentNewBinding35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding35 = null;
        }
        messageHomeFragmentNewBinding35.clarticle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$QXbuqqrBbukVFiQ1-Sa4p_PgkfU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageFragment.initView$lambda$2(this.f$0, view);
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding36 = this.viewBinding;
        if (messageHomeFragmentNewBinding36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding36 = null;
        }
        messageHomeFragmentNewBinding36.clCampus.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$bnOy4VY09F8h8DULmEwZMxT6-fo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageFragment.initView$lambda$3(this.f$0, view);
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding37 = this.viewBinding;
        if (messageHomeFragmentNewBinding37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding37 = null;
        }
        messageHomeFragmentNewBinding37.clposter.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$mUavU86nTzqKUaChnqEpXioT6dY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageFragment.initView$lambda$4(this.f$0, view);
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding38 = this.viewBinding;
        if (messageHomeFragmentNewBinding38 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding38 = null;
        }
        messageHomeFragmentNewBinding38.top2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$rzvhhoPGc-NBhMduzLrP9T2h8Kg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageFragment.initView$lambda$5(this.f$0, view);
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding39 = this.viewBinding;
        if (messageHomeFragmentNewBinding39 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding39 = null;
        }
        messageHomeFragmentNewBinding39.ivLeft.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$LyFegWwdKV6uN5hoLrnIBckld3s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageFragment.initView$lambda$6(this.f$0, view);
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding40 = this.viewBinding;
        if (messageHomeFragmentNewBinding40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding40 = null;
        }
        messageHomeFragmentNewBinding40.ivRight.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$Qd0B-HxK9d6n0bXClxPipisa16A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageFragment.initView$lambda$7(this.f$0, view);
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding41 = this.viewBinding;
        if (messageHomeFragmentNewBinding41 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding41 = null;
        }
        messageHomeFragmentNewBinding41.tvNoticeUp.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$_H3-CnCO6a_tmGQeQioD9bX-mh8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageFragment.initView$lambda$8(this.f$0, view);
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding42 = this.viewBinding;
        if (messageHomeFragmentNewBinding42 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            messageHomeFragmentNewBinding2 = messageHomeFragmentNewBinding42;
        }
        messageHomeFragmentNewBinding2.tvNoticeNext.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$MAFQqSW-bObutZHp6smKjzmv8Sg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageFragment.initView$lambda$9(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(MessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_NEWS);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(MessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_RECEIVE);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(MessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_ARTICLE);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(MessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_CAMPUSSTYLE);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(MessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_POSTER);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(MessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_ANNOUNCEMENT);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(MessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.newsIndex - 1;
        this$0.newsIndex = i;
        if (i <= 0) {
            this$0.newsIndex = 0;
        }
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding = this$0.viewBinding;
        if (messageHomeFragmentNewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding = null;
        }
        messageHomeFragmentNewBinding.viewPager2.setCurrentItem(this$0.newsIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(MessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.newsIndex + 1;
        this$0.newsIndex = i;
        MessageNewAdapter messageNewAdapter = this$0.mMessageNewAdapter;
        Intrinsics.checkNotNull(messageNewAdapter);
        if (i > messageNewAdapter.getData().size()) {
            MessageNewAdapter messageNewAdapter2 = this$0.mMessageNewAdapter;
            Intrinsics.checkNotNull(messageNewAdapter2);
            this$0.newsIndex = messageNewAdapter2.getData().size();
        }
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding = this$0.viewBinding;
        if (messageHomeFragmentNewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding = null;
        }
        messageHomeFragmentNewBinding.viewPager2.setCurrentItem(this$0.newsIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(MessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.newsIndex - 1;
        this$0.newsIndex = i;
        if (i <= 0) {
            this$0.newsIndex = 0;
        }
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding = this$0.viewBinding;
        if (messageHomeFragmentNewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding = null;
        }
        messageHomeFragmentNewBinding.noticeViewPager2.setCurrentItem(this$0.newsIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(MessageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.newsIndex + 1;
        this$0.newsIndex = i;
        MessageNoticeNewAdapter messageNoticeNewAdapter = this$0.mMessageNoticeAdapter;
        Intrinsics.checkNotNull(messageNoticeNewAdapter);
        if (i >= messageNoticeNewAdapter.getData().size()) {
            MessageNoticeNewAdapter messageNoticeNewAdapter2 = this$0.mMessageNoticeAdapter;
            Intrinsics.checkNotNull(messageNoticeNewAdapter2);
            this$0.newsIndex = messageNoticeNewAdapter2.getData().size();
        }
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding = this$0.viewBinding;
        if (messageHomeFragmentNewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding = null;
        }
        messageHomeFragmentNewBinding.noticeViewPager2.setCurrentItem(this$0.newsIndex);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (id == MinaConstants.Notice) {
            MessageHomeNewViewModel messageHomeNewViewModel = this.viewModel;
            if (messageHomeNewViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                messageHomeNewViewModel = null;
            }
            MessageHomeNewViewModel.requestMessageHome$default(messageHomeNewViewModel, this.type, 0, 0, 6, null);
        }
    }

    private final void initAdapter() {
        Banner startPosition;
        Banner adapter;
        Banner bannerIsAutoLoop;
        Banner loopTime;
        Banner indicator;
        Banner indicatorGravity;
        Banner indicatorSpace;
        Banner indicatorNormalColor;
        Banner indicatorSelectedColor;
        Banner indicatorWidth;
        Banner startPosition2;
        Banner adapter2;
        Banner bannerIsAutoLoop2;
        Banner loopTime2;
        Banner indicator2;
        Banner indicatorGravity2;
        Banner indicatorSpace2;
        Banner indicatorNormalColor2;
        Banner indicatorSelectedColor2;
        Banner indicatorWidth2;
        this.mMessageNewAdapter = new MessageNewAdapter();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding = null;
        this.mMessageCampusAdapter = new MessageCampusNewAdapter(contextRequireContext, null);
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        this.mMessagePosterAdapter = new MessagePosterNewAdapter(contextRequireContext2, null);
        this.mMessageNoticeAdapter = new MessageNoticeNewAdapter();
        this.mArticleAdapter = new MessageAdapter();
        this.mFoundAdapter = new MessageAdapter();
        MessageNoticeNewAdapter messageNoticeNewAdapter = this.mMessageNoticeAdapter;
        if (messageNoticeNewAdapter != null) {
            messageNoticeNewAdapter.setOnItemClick(new MessageNoticeNewAdapter.OnItemClick() { // from class: com.yd.android_brand_mvp.landscape.message.MessageFragment.initAdapter.1
                @Override // com.yd.android_brand_mvp.landscape.message.adapter.MessageNoticeNewAdapter.OnItemClick
                public void itemClick(MessageItemBean item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    if (ScreenUtils.isLandscape()) {
                        Intent intent = new Intent(MessageFragment.this.getContext(), (Class<?>) AnnouncementListActivity.class);
                        intent.putExtra("type", AnnouncementListActivity.TYPE_ANNOUNCEMENT);
                        intent.putExtra("id", item.getId());
                        MessageFragment.this.goPermissionsActivity(intent);
                        return;
                    }
                    if (MessageFragment.this.secondaryPagePermissions()) {
                        MessageDetailsPActivity.Companion companion = MessageDetailsPActivity.INSTANCE;
                        Context contextRequireContext3 = MessageFragment.this.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                        companion.start(contextRequireContext3, AnnouncementListActivity.TYPE_ANNOUNCEMENT, item);
                    }
                }
            });
        }
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding2 = this.viewBinding;
        if (messageHomeFragmentNewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding2 = null;
        }
        messageHomeFragmentNewBinding2.viewPager2.setOrientation(0);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding3 = this.viewBinding;
        if (messageHomeFragmentNewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding3 = null;
        }
        messageHomeFragmentNewBinding3.viewPager2.setAdapter(this.mMessageNewAdapter);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding4 = this.viewBinding;
        if (messageHomeFragmentNewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding4 = null;
        }
        messageHomeFragmentNewBinding4.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.yd.android_brand_mvp.landscape.message.MessageFragment.initAdapter.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                MessageFragment.this.newsIndex = position;
                AppExtKt.loge(this, "position" + position);
                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding5 = null;
                if (position > 0) {
                    MessageHomeFragmentNewBinding messageHomeFragmentNewBinding6 = MessageFragment.this.viewBinding;
                    if (messageHomeFragmentNewBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        messageHomeFragmentNewBinding6 = null;
                    }
                    messageHomeFragmentNewBinding6.ivLeft.setVisibility(0);
                } else {
                    MessageHomeFragmentNewBinding messageHomeFragmentNewBinding7 = MessageFragment.this.viewBinding;
                    if (messageHomeFragmentNewBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        messageHomeFragmentNewBinding7 = null;
                    }
                    messageHomeFragmentNewBinding7.ivLeft.setVisibility(8);
                }
                if (MessageFragment.this.mMessageNewAdapter != null) {
                    MessageNewAdapter messageNewAdapter = MessageFragment.this.mMessageNewAdapter;
                    Intrinsics.checkNotNull(messageNewAdapter);
                    if (messageNewAdapter.getData().size() > 0) {
                        MessageNewAdapter messageNewAdapter2 = MessageFragment.this.mMessageNewAdapter;
                        Intrinsics.checkNotNull(messageNewAdapter2);
                        if (messageNewAdapter2.getData().size() - 1 != position) {
                            MessageHomeFragmentNewBinding messageHomeFragmentNewBinding8 = MessageFragment.this.viewBinding;
                            if (messageHomeFragmentNewBinding8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            } else {
                                messageHomeFragmentNewBinding5 = messageHomeFragmentNewBinding8;
                            }
                            messageHomeFragmentNewBinding5.ivRight.setVisibility(0);
                            return;
                        }
                    }
                    MessageHomeFragmentNewBinding messageHomeFragmentNewBinding9 = MessageFragment.this.viewBinding;
                    if (messageHomeFragmentNewBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    } else {
                        messageHomeFragmentNewBinding5 = messageHomeFragmentNewBinding9;
                    }
                    messageHomeFragmentNewBinding5.ivRight.setVisibility(8);
                }
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding5 = this.viewBinding;
        if (messageHomeFragmentNewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding5 = null;
        }
        messageHomeFragmentNewBinding5.noticeViewPager2.setOrientation(0);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding6 = this.viewBinding;
        if (messageHomeFragmentNewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding6 = null;
        }
        messageHomeFragmentNewBinding6.noticeViewPager2.setAdapter(this.mMessageNoticeAdapter);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding7 = this.viewBinding;
        if (messageHomeFragmentNewBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding7 = null;
        }
        MessageFragment messageFragment = this;
        Banner bannerAddBannerLifecycleObserver = messageHomeFragmentNewBinding7.bannerCampus.addBannerLifecycleObserver(messageFragment);
        if (bannerAddBannerLifecycleObserver != null && (startPosition2 = bannerAddBannerLifecycleObserver.setStartPosition(1)) != null && (adapter2 = startPosition2.setAdapter(this.mMessageCampusAdapter)) != null && (bannerIsAutoLoop2 = adapter2.isAutoLoop(true)) != null && (loopTime2 = bannerIsAutoLoop2.setLoopTime(5000L)) != null && (indicator2 = loopTime2.setIndicator(new CircleIndicator(requireContext()))) != null && (indicatorGravity2 = indicator2.setIndicatorGravity(1)) != null && (indicatorSpace2 = indicatorGravity2.setIndicatorSpace(BannerUtils.dp2px(10.0f))) != null && (indicatorNormalColor2 = indicatorSpace2.setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray))) != null && (indicatorSelectedColor2 = indicatorNormalColor2.setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue12))) != null && (indicatorWidth2 = indicatorSelectedColor2.setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f))) != null) {
            indicatorWidth2.setIndicatorHeight(BannerUtils.dp2px(10.0f));
        }
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding8 = this.viewBinding;
        if (messageHomeFragmentNewBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding8 = null;
        }
        Banner bannerAddBannerLifecycleObserver2 = messageHomeFragmentNewBinding8.bannerPoster.addBannerLifecycleObserver(messageFragment);
        if (bannerAddBannerLifecycleObserver2 != null && (startPosition = bannerAddBannerLifecycleObserver2.setStartPosition(1)) != null && (adapter = startPosition.setAdapter(this.mMessagePosterAdapter)) != null && (bannerIsAutoLoop = adapter.isAutoLoop(true)) != null && (loopTime = bannerIsAutoLoop.setLoopTime(5000L)) != null && (indicator = loopTime.setIndicator(new CircleIndicator(requireContext()))) != null && (indicatorGravity = indicator.setIndicatorGravity(1)) != null && (indicatorSpace = indicatorGravity.setIndicatorSpace(BannerUtils.dp2px(10.0f))) != null && (indicatorNormalColor = indicatorSpace.setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray))) != null && (indicatorSelectedColor = indicatorNormalColor.setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue12))) != null && (indicatorWidth = indicatorSelectedColor.setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f))) != null) {
            indicatorWidth.setIndicatorHeight(BannerUtils.dp2px(10.0f));
        }
        MessageCampusNewAdapter messageCampusNewAdapter = this.mMessageCampusAdapter;
        if (messageCampusNewAdapter != null) {
            messageCampusNewAdapter.setItemClick(new MessageCampusNewAdapter.ItemClick() { // from class: com.yd.android_brand_mvp.landscape.message.MessageFragment.initAdapter.3
                @Override // com.yd.android_brand_mvp.landscape.message.adapter.MessageCampusNewAdapter.ItemClick
                public void onItemClick(MessageItemBean mMessageItemBean) {
                    Intrinsics.checkNotNullParameter(mMessageItemBean, "mMessageItemBean");
                    if (MessageFragment.this.secondaryPagePermissions()) {
                        if (ScreenUtils.isLandscape()) {
                            AnnouncementListActivity.start(MessageFragment.this.requireContext(), AnnouncementListActivity.TYPE_CAMPUSSTYLE, mMessageItemBean.getId());
                            return;
                        }
                        MessageDetailsPActivity.Companion companion = MessageDetailsPActivity.INSTANCE;
                        Context contextRequireContext3 = MessageFragment.this.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                        companion.start(contextRequireContext3, AnnouncementListActivity.TYPE_CAMPUSSTYLE, mMessageItemBean);
                    }
                }
            });
        }
        MessagePosterNewAdapter messagePosterNewAdapter = this.mMessagePosterAdapter;
        if (messagePosterNewAdapter != null) {
            messagePosterNewAdapter.setItemClick(new MessagePosterNewAdapter.ItemClick() { // from class: com.yd.android_brand_mvp.landscape.message.MessageFragment.initAdapter.4
                @Override // com.yd.android_brand_mvp.landscape.message.adapter.MessagePosterNewAdapter.ItemClick
                public void onItemClick(MessageItemBean item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    MessageFragment.this.showImageDialog(item);
                }
            });
        }
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding9 = this.viewBinding;
        if (messageHomeFragmentNewBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding9 = null;
        }
        messageHomeFragmentNewBinding9.bannerPoster.setOnBannerListener(new OnBannerListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$b7W81y-lPyeGYyZZCg4ug3ow1kY
            @Override // com.youth.banner.listener.OnBannerListener
            public final void OnBannerClick(Object obj, int i) {
                MessageFragment.initAdapter$lambda$10(this.f$0, obj, i);
            }
        });
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding10 = this.viewBinding;
        if (messageHomeFragmentNewBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding10 = null;
        }
        messageHomeFragmentNewBinding10.articleRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding11 = this.viewBinding;
        if (messageHomeFragmentNewBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding11 = null;
        }
        messageHomeFragmentNewBinding11.articleRecyclerView.setAdapter(this.mArticleAdapter);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding12 = this.viewBinding;
        if (messageHomeFragmentNewBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding12 = null;
        }
        messageHomeFragmentNewBinding12.foundRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding13 = this.viewBinding;
        if (messageHomeFragmentNewBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            messageHomeFragmentNewBinding = messageHomeFragmentNewBinding13;
        }
        messageHomeFragmentNewBinding.foundRecyclerView.setAdapter(this.mFoundAdapter);
        MessageNewAdapter messageNewAdapter = this.mMessageNewAdapter;
        if (messageNewAdapter != null) {
            messageNewAdapter.setEmptyView(R.layout.item_min_null_layout_2_2);
        }
        MessageNoticeNewAdapter messageNoticeNewAdapter2 = this.mMessageNoticeAdapter;
        if (messageNoticeNewAdapter2 != null) {
            messageNoticeNewAdapter2.setEmptyView(R.layout.item_min_null_layout_2_2);
        }
        MessageAdapter messageAdapter = this.mArticleAdapter;
        if (messageAdapter != null) {
            messageAdapter.setEmptyView(R.layout.item_min_null_layout_2_2);
        }
        MessageAdapter messageAdapter2 = this.mFoundAdapter;
        if (messageAdapter2 != null) {
            messageAdapter2.setEmptyView(R.layout.item_min_null_layout_2_2);
        }
        MessageNewAdapter messageNewAdapter2 = this.mMessageNewAdapter;
        if (messageNewAdapter2 != null) {
            messageNewAdapter2.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$V_dNVfGQaZfeqsZSNNbAfwTO2wc
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    MessageFragment.initAdapter$lambda$12(this.f$0, baseQuickAdapter, view, i);
                }
            });
        }
        MessageNoticeNewAdapter messageNoticeNewAdapter3 = this.mMessageNoticeAdapter;
        if (messageNoticeNewAdapter3 != null) {
            messageNoticeNewAdapter3.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$m34DrIGjCK5Q_y4_mihP0SJE-5g
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    MessageFragment.initAdapter$lambda$14(this.f$0, baseQuickAdapter, view, i);
                }
            });
        }
        MessageAdapter messageAdapter3 = this.mArticleAdapter;
        if (messageAdapter3 != null) {
            messageAdapter3.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$TU0vedJEqsFfC_GZMTLKj4S7Dsw
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    MessageFragment.initAdapter$lambda$16(this.f$0, baseQuickAdapter, view, i);
                }
            });
        }
        MessageAdapter messageAdapter4 = this.mFoundAdapter;
        if (messageAdapter4 != null) {
            messageAdapter4.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$9WHVPazPp9ettOhis0E_VS7l1d0
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    MessageFragment.initAdapter$lambda$18(this.f$0, baseQuickAdapter, view, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$10(MessageFragment this$0, Object obj, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.secondaryPagePermissions()) {
            AnnouncementListActivity.start(this$0.requireContext(), AnnouncementListActivity.TYPE_POSTER, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$12(MessageFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        MessageItemBean item;
        MessageItemBean item2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this$0.secondaryPagePermissions()) {
            if (ScreenUtils.isLandscape()) {
                Context contextRequireContext = this$0.requireContext();
                MessageNewAdapter messageNewAdapter = this$0.mMessageNewAdapter;
                AnnouncementListActivity.start(contextRequireContext, AnnouncementListActivity.TYPE_NEWS, (messageNewAdapter == null || (item2 = messageNewAdapter.getItem(i)) == null) ? null : item2.getId());
                return;
            }
            MessageNewAdapter messageNewAdapter2 = this$0.mMessageNewAdapter;
            if (messageNewAdapter2 == null || (item = messageNewAdapter2.getItem(i)) == null) {
                return;
            }
            MessageDetailsPActivity.Companion companion = MessageDetailsPActivity.INSTANCE;
            Context contextRequireContext2 = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            companion.start(contextRequireContext2, AnnouncementListActivity.TYPE_NEWS, item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$14(MessageFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        MessageItemBean item;
        MessageItemBean item2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this$0.secondaryPagePermissions()) {
            if (ScreenUtils.isLandscape()) {
                Context contextRequireContext = this$0.requireContext();
                MessageNoticeNewAdapter messageNoticeNewAdapter = this$0.mMessageNoticeAdapter;
                AnnouncementListActivity.start(contextRequireContext, AnnouncementListActivity.TYPE_ANNOUNCEMENT, (messageNoticeNewAdapter == null || (item2 = messageNoticeNewAdapter.getItem(i)) == null) ? null : item2.getId());
                return;
            }
            MessageNoticeNewAdapter messageNoticeNewAdapter2 = this$0.mMessageNoticeAdapter;
            if (messageNoticeNewAdapter2 == null || (item = messageNoticeNewAdapter2.getItem(i)) == null) {
                return;
            }
            MessageDetailsPActivity.Companion companion = MessageDetailsPActivity.INSTANCE;
            Context contextRequireContext2 = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            companion.start(contextRequireContext2, AnnouncementListActivity.TYPE_ANNOUNCEMENT, item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$16(MessageFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        MessageItemBean item;
        MessageItemBean item2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this$0.secondaryPagePermissions()) {
            if (ScreenUtils.isLandscape()) {
                Context contextRequireContext = this$0.requireContext();
                MessageAdapter messageAdapter = this$0.mArticleAdapter;
                AnnouncementListActivity.start(contextRequireContext, AnnouncementListActivity.TYPE_ARTICLE, (messageAdapter == null || (item2 = messageAdapter.getItem(i)) == null) ? null : item2.getId());
                return;
            }
            MessageAdapter messageAdapter2 = this$0.mArticleAdapter;
            if (messageAdapter2 == null || (item = messageAdapter2.getItem(i)) == null) {
                return;
            }
            MessageDetailsPActivity.Companion companion = MessageDetailsPActivity.INSTANCE;
            Context contextRequireContext2 = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            companion.start(contextRequireContext2, AnnouncementListActivity.TYPE_ARTICLE, item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$18(MessageFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        MessageItemBean item;
        MessageItemBean item2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this$0.secondaryPagePermissions()) {
            if (ScreenUtils.isLandscape()) {
                Context contextRequireContext = this$0.requireContext();
                MessageAdapter messageAdapter = this$0.mFoundAdapter;
                AnnouncementListActivity.start(contextRequireContext, AnnouncementListActivity.TYPE_RECEIVE, (messageAdapter == null || (item2 = messageAdapter.getItem(i)) == null) ? null : item2.getId());
                return;
            }
            MessageAdapter messageAdapter2 = this$0.mFoundAdapter;
            if (messageAdapter2 == null || (item = messageAdapter2.getItem(i)) == null) {
                return;
            }
            MessageDetailsPActivity.Companion companion = MessageDetailsPActivity.INSTANCE;
            Context contextRequireContext2 = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            companion.start(contextRequireContext2, AnnouncementListActivity.TYPE_RECEIVE, item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showImageDialog(MessageItemBean item) {
        String coverImg;
        List<MessageDetail> details = item.getDetails();
        String contentImg = "";
        if (details != null) {
            if (ScreenUtils.isLandscape()) {
                if ((!details.isEmpty()) && details.size() > 1) {
                    coverImg = details.get(1).getCoverImg();
                    contentImg = coverImg;
                }
            } else if (!details.isEmpty()) {
                coverImg = details.get(0).getCoverImg();
                contentImg = coverImg;
            }
        }
        if (TextUtils.isEmpty(contentImg)) {
            contentImg = item.getContentImg();
        }
        new XPopup.Builder(this.mActivity).asCustom(new ImageShowPopup(this.mActivity, contentImg)).show();
    }

    private final void initViewModel() {
        MessageHomeNewViewModel messageHomeNewViewModel = this.viewModel;
        if (messageHomeNewViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageHomeNewViewModel = null;
        }
        SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> messageHomeLiveData = messageHomeNewViewModel.getMessageHomeLiveData();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        final Function1<Result<? extends BasePageResponse<List<MessageItemBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<MessageItemBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.message.MessageFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<MessageItemBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<MessageItemBean>>> it2) {
                String message;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (!Result.m598isSuccessimpl(it2.getValue())) {
                    String str = MessageFragment.this.TAG;
                    Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                    if (thM594exceptionOrNullimpl == null || (message = thM594exceptionOrNullimpl.getMessage()) == null) {
                        message = "";
                    }
                    Log.i(str, message);
                    List<MessageItemBean> messageHomeCache = SpData.getMessageHomeCache("message_" + MessageFragment.this.type);
                    if (messageHomeCache != null) {
                        MessageFragment.this.setData(messageHomeCache);
                        return;
                    }
                    return;
                }
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                BasePageResponse basePageResponse = (BasePageResponse) value;
                if (basePageResponse != null) {
                    MessageFragment messageFragment = MessageFragment.this;
                    List list = (List) basePageResponse.getList();
                    if (list != null) {
                        messageFragment.setData(list);
                    }
                    SPUtils.getInstance().put("message_" + messageFragment.type, JSON.toJSONString(basePageResponse.getList()));
                }
                List<MessageItemBean> messageHomeCache2 = SpData.getMessageHomeCache("message_" + MessageFragment.this.type);
                if (basePageResponse != null || messageHomeCache2 == null) {
                    return;
                }
                MessageFragment.this.setData(messageHomeCache2);
            }
        };
        messageHomeLiveData.observe(fragmentActivityRequireActivity, new Observer() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageFragment$W71wA3kOfO_bPLSMManjJIM8ACE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MessageFragment.initViewModel$lambda$20(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$20(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData(List<MessageItemBean> list) {
        int i;
        int i2 = 3;
        if (ScreenUtils.isLandscape()) {
            i = 3;
        } else {
            i2 = 2;
            i = 1;
        }
        String str = this.type;
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding = null;
        if (Intrinsics.areEqual(str, this.NEWS)) {
            if (list.size() > 1) {
                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding2 = this.viewBinding;
                if (messageHomeFragmentNewBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    messageHomeFragmentNewBinding2 = null;
                }
                messageHomeFragmentNewBinding2.ivRight.setVisibility(0);
            } else {
                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding3 = this.viewBinding;
                if (messageHomeFragmentNewBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    messageHomeFragmentNewBinding3 = null;
                }
                messageHomeFragmentNewBinding3.ivLeft.setVisibility(4);
            }
            MessageNewAdapter messageNewAdapter = this.mMessageNewAdapter;
            Intrinsics.checkNotNull(messageNewAdapter);
            messageNewAdapter.setList(list);
            MessageHomeFragmentNewBinding messageHomeFragmentNewBinding4 = this.viewBinding;
            if (messageHomeFragmentNewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                messageHomeFragmentNewBinding = messageHomeFragmentNewBinding4;
            }
            messageHomeFragmentNewBinding.viewPager2.setCurrentItem(0);
            return;
        }
        if (Intrinsics.areEqual(str, this.ANNOUNCEMENT)) {
            MessageNoticeNewAdapter messageNoticeNewAdapter = this.mMessageNoticeAdapter;
            Intrinsics.checkNotNull(messageNoticeNewAdapter);
            messageNoticeNewAdapter.setList(list);
            MessageHomeFragmentNewBinding messageHomeFragmentNewBinding5 = this.viewBinding;
            if (messageHomeFragmentNewBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                messageHomeFragmentNewBinding5 = null;
            }
            messageHomeFragmentNewBinding5.tvNoticeNext.setVisibility(0);
            MessageHomeFragmentNewBinding messageHomeFragmentNewBinding6 = this.viewBinding;
            if (messageHomeFragmentNewBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                messageHomeFragmentNewBinding6 = null;
            }
            messageHomeFragmentNewBinding6.tvNoticeUp.setVisibility(0);
            if (list.size() > 1) {
                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding7 = this.viewBinding;
                if (messageHomeFragmentNewBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    messageHomeFragmentNewBinding7 = null;
                }
                messageHomeFragmentNewBinding7.tvNoticeNext.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding8 = this.viewBinding;
                if (messageHomeFragmentNewBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    messageHomeFragmentNewBinding8 = null;
                }
                messageHomeFragmentNewBinding8.tvNoticeNext.setClickable(true);
            } else {
                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding9 = this.viewBinding;
                if (messageHomeFragmentNewBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    messageHomeFragmentNewBinding9 = null;
                }
                messageHomeFragmentNewBinding9.tvNoticeNext.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding10 = this.viewBinding;
                if (messageHomeFragmentNewBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    messageHomeFragmentNewBinding10 = null;
                }
                messageHomeFragmentNewBinding10.tvNoticeNext.setClickable(false);
            }
            MessageHomeFragmentNewBinding messageHomeFragmentNewBinding11 = this.viewBinding;
            if (messageHomeFragmentNewBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                messageHomeFragmentNewBinding11 = null;
            }
            messageHomeFragmentNewBinding11.tvNoticeNumber.setVisibility(0);
            String str2 = "1/" + list.size();
            Log.d(this.TAG, "pageNumber = " + str2);
            MessageHomeFragmentNewBinding messageHomeFragmentNewBinding12 = this.viewBinding;
            if (messageHomeFragmentNewBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                messageHomeFragmentNewBinding12 = null;
            }
            messageHomeFragmentNewBinding12.tvNoticeNumber.setText(str2);
            MessageHomeFragmentNewBinding messageHomeFragmentNewBinding13 = this.viewBinding;
            if (messageHomeFragmentNewBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                messageHomeFragmentNewBinding = messageHomeFragmentNewBinding13;
            }
            messageHomeFragmentNewBinding.noticeViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.yd.android_brand_mvp.landscape.message.MessageFragment.setData.1
                /* JADX WARN: Code duplicated, block: B:34:0x00e4  */
                /* JADX WARN: Code duplicated, block: B:36:0x00ec  */
                /* JADX WARN: Code duplicated, block: B:39:0x0105  */
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int position) {
                    MessageHomeFragmentNewBinding messageHomeFragmentNewBinding14;
                    MessageHomeFragmentNewBinding messageHomeFragmentNewBinding15;
                    super.onPageSelected(position);
                    AppExtKt.loge(this, "position" + position);
                    MessageHomeFragmentNewBinding messageHomeFragmentNewBinding16 = null;
                    if (position > 0) {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding17 = MessageFragment.this.viewBinding;
                        if (messageHomeFragmentNewBinding17 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding17 = null;
                        }
                        messageHomeFragmentNewBinding17.tvNoticeUp.setVisibility(0);
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding18 = MessageFragment.this.viewBinding;
                        if (messageHomeFragmentNewBinding18 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding18 = null;
                        }
                        messageHomeFragmentNewBinding18.tvNoticeUp.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding19 = MessageFragment.this.viewBinding;
                        if (messageHomeFragmentNewBinding19 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding19 = null;
                        }
                        messageHomeFragmentNewBinding19.tvNoticeUp.setClickable(true);
                    } else {
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding20 = MessageFragment.this.viewBinding;
                        if (messageHomeFragmentNewBinding20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding20 = null;
                        }
                        messageHomeFragmentNewBinding20.tvNoticeUp.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding21 = MessageFragment.this.viewBinding;
                        if (messageHomeFragmentNewBinding21 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                            messageHomeFragmentNewBinding21 = null;
                        }
                        messageHomeFragmentNewBinding21.tvNoticeUp.setClickable(false);
                    }
                    if (MessageFragment.this.mMessageNoticeAdapter != null) {
                        MessageNoticeNewAdapter messageNoticeNewAdapter2 = MessageFragment.this.mMessageNoticeAdapter;
                        Intrinsics.checkNotNull(messageNoticeNewAdapter2);
                        if (messageNoticeNewAdapter2.getData().size() > 0) {
                            MessageNoticeNewAdapter messageNoticeNewAdapter3 = MessageFragment.this.mMessageNoticeAdapter;
                            Intrinsics.checkNotNull(messageNoticeNewAdapter3);
                            if (messageNoticeNewAdapter3.getData().size() - 1 != position) {
                                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding22 = MessageFragment.this.viewBinding;
                                if (messageHomeFragmentNewBinding22 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                                    messageHomeFragmentNewBinding22 = null;
                                }
                                messageHomeFragmentNewBinding22.tvNoticeNext.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding23 = MessageFragment.this.viewBinding;
                                if (messageHomeFragmentNewBinding23 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                                    messageHomeFragmentNewBinding23 = null;
                                }
                                messageHomeFragmentNewBinding23.tvNoticeNext.setClickable(true);
                            } else {
                                messageHomeFragmentNewBinding14 = MessageFragment.this.viewBinding;
                                if (messageHomeFragmentNewBinding14 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                                    messageHomeFragmentNewBinding14 = null;
                                }
                                messageHomeFragmentNewBinding14.tvNoticeNext.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                                messageHomeFragmentNewBinding15 = MessageFragment.this.viewBinding;
                                if (messageHomeFragmentNewBinding15 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                                    messageHomeFragmentNewBinding15 = null;
                                }
                                messageHomeFragmentNewBinding15.tvNoticeNext.setClickable(false);
                            }
                        } else {
                            messageHomeFragmentNewBinding14 = MessageFragment.this.viewBinding;
                            if (messageHomeFragmentNewBinding14 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                                messageHomeFragmentNewBinding14 = null;
                            }
                            messageHomeFragmentNewBinding14.tvNoticeNext.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black11));
                            messageHomeFragmentNewBinding15 = MessageFragment.this.viewBinding;
                            if (messageHomeFragmentNewBinding15 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                                messageHomeFragmentNewBinding15 = null;
                            }
                            messageHomeFragmentNewBinding15.tvNoticeNext.setClickable(false);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(position + 1);
                        sb.append('/');
                        MessageNoticeNewAdapter messageNoticeNewAdapter4 = MessageFragment.this.mMessageNoticeAdapter;
                        Intrinsics.checkNotNull(messageNoticeNewAdapter4);
                        sb.append(messageNoticeNewAdapter4.getData().size());
                        String string = sb.toString();
                        Log.d(MessageFragment.this.TAG, "onPageScrolled pageNumber = " + string);
                        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding24 = MessageFragment.this.viewBinding;
                        if (messageHomeFragmentNewBinding24 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        } else {
                            messageHomeFragmentNewBinding16 = messageHomeFragmentNewBinding24;
                        }
                        messageHomeFragmentNewBinding16.tvNoticeNumber.setText(string);
                    }
                }
            });
            return;
        }
        if (Intrinsics.areEqual(str, this.ARTICLE)) {
            MessageAdapter messageAdapter = this.mArticleAdapter;
            Intrinsics.checkNotNull(messageAdapter);
            messageAdapter.setList(list);
            return;
        }
        if (Intrinsics.areEqual(str, this.RECEIVE)) {
            MessageAdapter messageAdapter2 = this.mFoundAdapter;
            Intrinsics.checkNotNull(messageAdapter2);
            messageAdapter2.setList(list);
            return;
        }
        if (Intrinsics.areEqual(str, this.CAMPUSSTYLE)) {
            if (list.size() > 0) {
                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding14 = this.viewBinding;
                if (messageHomeFragmentNewBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    messageHomeFragmentNewBinding14 = null;
                }
                messageHomeFragmentNewBinding14.muCampus.setViewState(0);
                MessageHomeFragmentNewBinding messageHomeFragmentNewBinding15 = this.viewBinding;
                if (messageHomeFragmentNewBinding15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                } else {
                    messageHomeFragmentNewBinding = messageHomeFragmentNewBinding15;
                }
                messageHomeFragmentNewBinding.bannerCampus.setDatas(splitList(list, i2));
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(str, this.POSTER) || list.size() <= 0) {
            return;
        }
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding16 = this.viewBinding;
        if (messageHomeFragmentNewBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentNewBinding16 = null;
        }
        messageHomeFragmentNewBinding16.muPoster.setViewState(0);
        MessageHomeFragmentNewBinding messageHomeFragmentNewBinding17 = this.viewBinding;
        if (messageHomeFragmentNewBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            messageHomeFragmentNewBinding = messageHomeFragmentNewBinding17;
        }
        messageHomeFragmentNewBinding.bannerPoster.setDatas(splitList(list, i));
    }

    public final List<List<MessageItemBean>> splitList(List<MessageItemBean> list, int groupSize) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        int i = ((size + groupSize) - 1) / groupSize;
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 * groupSize;
            i2++;
            arrayList.add(list.subList(i3, RangesKt.coerceAtMost(i2 * groupSize, size)));
        }
        return arrayList;
    }
}
