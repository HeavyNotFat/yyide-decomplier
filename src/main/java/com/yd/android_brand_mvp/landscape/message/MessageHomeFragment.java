package com.yd.android_brand_mvp.landscape.message;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.MessageHomeFragmentBinding;
import com.yd.android_brand_mvp.landscape.message.adapter.MessageCampusAdapter;
import com.yd.android_brand_mvp.landscape.message.adapter.MessageNewAdapter;
import com.yd.android_brand_mvp.landscape.message.adapter.MessageNoticeAdapter;
import com.yd.android_brand_mvp.landscape.message.adapter.MessagePosterAdapter;
import com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeViewModel;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.model.MessageListBean;
import com.yd.android_brand_mvp.observer.MinaListener;
import com.yd.android_brand_mvp.user.AnnouncementListActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yyide.facepass.AppExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageHomeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/MessageHomeFragment;", "Lcom/yd/android_brand_mvp/base/BaseFragment;", "Lcom/yd/android_brand_mvp/observer/MinaListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mArticleAdapter", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageNoticeAdapter;", "mFoundAdapter", "mMessageCampusAdapter", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageCampusAdapter;", "mMessageNewAdapter", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageNewAdapter;", "mMessageNoticeAdapter", "mMessagePosterAdapter", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessagePosterAdapter;", "newsIndex", "", "viewBinding", "Lcom/yd/android_brand_mvp/databinding/MessageHomeFragmentBinding;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageHomeViewModel;", "UpdataEvent", "", "id", "initAdapter", "initView", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "setData", "item", "Lcom/yd/android_brand_mvp/model/MessageListBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageHomeFragment extends BaseFragment implements MinaListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String TAG = MessageHomeFragment.class.getSimpleName();
    private MessageNoticeAdapter mArticleAdapter;
    private MessageNoticeAdapter mFoundAdapter;
    private MessageCampusAdapter mMessageCampusAdapter;
    private MessageNewAdapter mMessageNewAdapter;
    private MessageNoticeAdapter mMessageNoticeAdapter;
    private MessagePosterAdapter mMessagePosterAdapter;
    private int newsIndex;
    private MessageHomeFragmentBinding viewBinding;
    private MessageHomeViewModel viewModel;

    /* JADX INFO: compiled from: MessageHomeFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/MessageHomeFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/message/MessageHomeFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MessageHomeFragment newInstance() {
            return new MessageHomeFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MessageHomeFragmentBinding messageHomeFragmentBindingInflate = MessageHomeFragmentBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(messageHomeFragmentBindingInflate, "inflate(inflater)");
        this.viewBinding = messageHomeFragmentBindingInflate;
        if (messageHomeFragmentBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBindingInflate = null;
        }
        ConstraintLayout root = messageHomeFragmentBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (MessageHomeViewModel) new ViewModelProvider(this).get(MessageHomeViewModel.class);
        initView();
        initAdapter();
        initViewModel();
        MessageHomeViewModel messageHomeViewModel = this.viewModel;
        if (messageHomeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageHomeViewModel = null;
        }
        messageHomeViewModel.requestMessageHome();
    }

    private final void initView() {
        MessageHomeFragmentBinding messageHomeFragmentBinding = this.viewBinding;
        MessageHomeFragmentBinding messageHomeFragmentBinding2 = null;
        if (messageHomeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding = null;
        }
        messageHomeFragmentBinding.gankConstraintlayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageHomeFragment$2arm4Nk-8ufu5ccMZOvhhbh4tLg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageHomeFragment.initView$lambda$0(this.f$0, view);
            }
        });
        MessageHomeFragmentBinding messageHomeFragmentBinding3 = this.viewBinding;
        if (messageHomeFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding3 = null;
        }
        messageHomeFragmentBinding3.clnotice.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageHomeFragment$c3yU-L8oj69oQrOkKGwuRpZZuNQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageHomeFragment.initView$lambda$1(this.f$0, view);
            }
        });
        MessageHomeFragmentBinding messageHomeFragmentBinding4 = this.viewBinding;
        if (messageHomeFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding4 = null;
        }
        messageHomeFragmentBinding4.clfound.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageHomeFragment$g1sBBrTV-03ClThhRNu8mwabPeE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageHomeFragment.initView$lambda$2(this.f$0, view);
            }
        });
        MessageHomeFragmentBinding messageHomeFragmentBinding5 = this.viewBinding;
        if (messageHomeFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding5 = null;
        }
        messageHomeFragmentBinding5.clarticle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageHomeFragment$tMTuC_8eaFTaKEUWGCccKCl5qic
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageHomeFragment.initView$lambda$3(this.f$0, view);
            }
        });
        MessageHomeFragmentBinding messageHomeFragmentBinding6 = this.viewBinding;
        if (messageHomeFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding6 = null;
        }
        messageHomeFragmentBinding6.clCampus.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageHomeFragment$FAccwDaMfcKgkmBIhBQS63DK_G0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageHomeFragment.initView$lambda$4(this.f$0, view);
            }
        });
        MessageHomeFragmentBinding messageHomeFragmentBinding7 = this.viewBinding;
        if (messageHomeFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding7 = null;
        }
        messageHomeFragmentBinding7.clposter.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageHomeFragment$8PZXquIIspJM5l8r6f2Oz0O4GWE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageHomeFragment.initView$lambda$5(this.f$0, view);
            }
        });
        MessageHomeFragmentBinding messageHomeFragmentBinding8 = this.viewBinding;
        if (messageHomeFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding8 = null;
        }
        messageHomeFragmentBinding8.ivLeft.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageHomeFragment$pBASLUj8PdTPA17bYcBzGeyyySY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageHomeFragment.initView$lambda$6(this.f$0, view);
            }
        });
        MessageHomeFragmentBinding messageHomeFragmentBinding9 = this.viewBinding;
        if (messageHomeFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            messageHomeFragmentBinding2 = messageHomeFragmentBinding9;
        }
        messageHomeFragmentBinding2.ivRight.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageHomeFragment$ogo75jFQThhJypXwUDdboJblIc4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageHomeFragment.initView$lambda$7(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(MessageHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_NEWS);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(MessageHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_ANNOUNCEMENT);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(MessageHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_RECEIVE);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(MessageHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_ARTICLE);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(MessageHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_CAMPUSSTYLE);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(MessageHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) AnnouncementListActivity.class);
        intent.putExtra("type", AnnouncementListActivity.TYPE_POSTER);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(MessageHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.newsIndex - 1;
        this$0.newsIndex = i;
        if (i <= 0) {
            this$0.newsIndex = 0;
        }
        MessageHomeFragmentBinding messageHomeFragmentBinding = this$0.viewBinding;
        if (messageHomeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding = null;
        }
        messageHomeFragmentBinding.viewPager2.setCurrentItem(this$0.newsIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(MessageHomeFragment this$0, View view) {
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
        MessageHomeFragmentBinding messageHomeFragmentBinding = this$0.viewBinding;
        if (messageHomeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding = null;
        }
        messageHomeFragmentBinding.viewPager2.setCurrentItem(this$0.newsIndex);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (id == MinaConstants.Notice) {
            MessageHomeViewModel messageHomeViewModel = this.viewModel;
            if (messageHomeViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                messageHomeViewModel = null;
            }
            messageHomeViewModel.requestMessageHome();
        }
    }

    private final void initAdapter() {
        this.mMessageNewAdapter = new MessageNewAdapter();
        this.mMessageCampusAdapter = new MessageCampusAdapter();
        this.mMessagePosterAdapter = new MessagePosterAdapter();
        this.mMessageNoticeAdapter = new MessageNoticeAdapter();
        this.mArticleAdapter = new MessageNoticeAdapter();
        this.mFoundAdapter = new MessageNoticeAdapter();
        MessageHomeFragmentBinding messageHomeFragmentBinding = this.viewBinding;
        MessageHomeFragmentBinding messageHomeFragmentBinding2 = null;
        if (messageHomeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding = null;
        }
        messageHomeFragmentBinding.viewPager2.setOrientation(0);
        MessageHomeFragmentBinding messageHomeFragmentBinding3 = this.viewBinding;
        if (messageHomeFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding3 = null;
        }
        messageHomeFragmentBinding3.viewPager2.setAdapter(this.mMessageNewAdapter);
        MessageHomeFragmentBinding messageHomeFragmentBinding4 = this.viewBinding;
        if (messageHomeFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding4 = null;
        }
        messageHomeFragmentBinding4.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.yd.android_brand_mvp.landscape.message.MessageHomeFragment.initAdapter.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                AppExtKt.loge(this, "position" + position);
                MessageHomeFragmentBinding messageHomeFragmentBinding5 = null;
                if (position > 0) {
                    MessageHomeFragmentBinding messageHomeFragmentBinding6 = MessageHomeFragment.this.viewBinding;
                    if (messageHomeFragmentBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        messageHomeFragmentBinding6 = null;
                    }
                    messageHomeFragmentBinding6.ivLeft.setVisibility(0);
                } else {
                    MessageHomeFragmentBinding messageHomeFragmentBinding7 = MessageHomeFragment.this.viewBinding;
                    if (messageHomeFragmentBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        messageHomeFragmentBinding7 = null;
                    }
                    messageHomeFragmentBinding7.ivLeft.setVisibility(8);
                }
                MessageNewAdapter messageNewAdapter = MessageHomeFragment.this.mMessageNewAdapter;
                Intrinsics.checkNotNull(messageNewAdapter);
                if (messageNewAdapter.getData().size() > 0) {
                    MessageNewAdapter messageNewAdapter2 = MessageHomeFragment.this.mMessageNewAdapter;
                    Intrinsics.checkNotNull(messageNewAdapter2);
                    if (messageNewAdapter2.getData().size() - 1 != position) {
                        MessageHomeFragmentBinding messageHomeFragmentBinding8 = MessageHomeFragment.this.viewBinding;
                        if (messageHomeFragmentBinding8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        } else {
                            messageHomeFragmentBinding5 = messageHomeFragmentBinding8;
                        }
                        messageHomeFragmentBinding5.ivRight.setVisibility(0);
                        return;
                    }
                }
                MessageHomeFragmentBinding messageHomeFragmentBinding9 = MessageHomeFragment.this.viewBinding;
                if (messageHomeFragmentBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                } else {
                    messageHomeFragmentBinding5 = messageHomeFragmentBinding9;
                }
                messageHomeFragmentBinding5.ivRight.setVisibility(8);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setOrientation(0);
        MessageHomeFragmentBinding messageHomeFragmentBinding5 = this.viewBinding;
        if (messageHomeFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding5 = null;
        }
        messageHomeFragmentBinding5.campusRecyclerView.setLayoutManager(linearLayoutManager);
        MessageHomeFragmentBinding messageHomeFragmentBinding6 = this.viewBinding;
        if (messageHomeFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding6 = null;
        }
        messageHomeFragmentBinding6.campusRecyclerView.setAdapter(this.mMessageCampusAdapter);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(requireContext());
        linearLayoutManager2.setOrientation(0);
        MessageHomeFragmentBinding messageHomeFragmentBinding7 = this.viewBinding;
        if (messageHomeFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding7 = null;
        }
        messageHomeFragmentBinding7.posterRecyclerView.setLayoutManager(linearLayoutManager2);
        MessageHomeFragmentBinding messageHomeFragmentBinding8 = this.viewBinding;
        if (messageHomeFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding8 = null;
        }
        messageHomeFragmentBinding8.posterRecyclerView.setAdapter(this.mMessagePosterAdapter);
        MessageHomeFragmentBinding messageHomeFragmentBinding9 = this.viewBinding;
        if (messageHomeFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding9 = null;
        }
        messageHomeFragmentBinding9.noticeRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        MessageHomeFragmentBinding messageHomeFragmentBinding10 = this.viewBinding;
        if (messageHomeFragmentBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding10 = null;
        }
        messageHomeFragmentBinding10.noticeRecyclerView.setAdapter(this.mMessageNoticeAdapter);
        MessageHomeFragmentBinding messageHomeFragmentBinding11 = this.viewBinding;
        if (messageHomeFragmentBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding11 = null;
        }
        messageHomeFragmentBinding11.articleRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        MessageHomeFragmentBinding messageHomeFragmentBinding12 = this.viewBinding;
        if (messageHomeFragmentBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding12 = null;
        }
        messageHomeFragmentBinding12.articleRecyclerView.setAdapter(this.mArticleAdapter);
        MessageHomeFragmentBinding messageHomeFragmentBinding13 = this.viewBinding;
        if (messageHomeFragmentBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            messageHomeFragmentBinding13 = null;
        }
        messageHomeFragmentBinding13.foundRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        MessageHomeFragmentBinding messageHomeFragmentBinding14 = this.viewBinding;
        if (messageHomeFragmentBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            messageHomeFragmentBinding2 = messageHomeFragmentBinding14;
        }
        messageHomeFragmentBinding2.foundRecyclerView.setAdapter(this.mFoundAdapter);
        MessageNewAdapter messageNewAdapter = this.mMessageNewAdapter;
        Intrinsics.checkNotNull(messageNewAdapter);
        messageNewAdapter.setEmptyView(R.layout.item_min_null_layout_2_2);
        MessageCampusAdapter messageCampusAdapter = this.mMessageCampusAdapter;
        Intrinsics.checkNotNull(messageCampusAdapter);
        messageCampusAdapter.setEmptyView(R.layout.item_min_null_layout_2_2);
        MessagePosterAdapter messagePosterAdapter = this.mMessagePosterAdapter;
        Intrinsics.checkNotNull(messagePosterAdapter);
        messagePosterAdapter.setEmptyView(R.layout.item_min_null_layout_2_2);
        MessageNoticeAdapter messageNoticeAdapter = this.mMessageNoticeAdapter;
        Intrinsics.checkNotNull(messageNoticeAdapter);
        messageNoticeAdapter.setEmptyView(R.layout.item_min_null_layout_2_2);
        MessageNoticeAdapter messageNoticeAdapter2 = this.mArticleAdapter;
        Intrinsics.checkNotNull(messageNoticeAdapter2);
        messageNoticeAdapter2.setEmptyView(R.layout.item_min_null_layout_2_2);
        MessageNoticeAdapter messageNoticeAdapter3 = this.mFoundAdapter;
        Intrinsics.checkNotNull(messageNoticeAdapter3);
        messageNoticeAdapter3.setEmptyView(R.layout.item_min_null_layout_2_2);
    }

    private final void initViewModel() {
        MessageHomeViewModel messageHomeViewModel = this.viewModel;
        if (messageHomeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            messageHomeViewModel = null;
        }
        MutableLiveData<Result<MessageListBean>> messageHomeLiveData = messageHomeViewModel.getMessageHomeLiveData();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        final Function1<Result<? extends MessageListBean>, Unit> function1 = new Function1<Result<? extends MessageListBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.message.MessageHomeFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends MessageListBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends MessageListBean> it2) {
                String message;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (!Result.m598isSuccessimpl(it2.getValue())) {
                    String str = MessageHomeFragment.this.TAG;
                    Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                    if (thM594exceptionOrNullimpl == null || (message = thM594exceptionOrNullimpl.getMessage()) == null) {
                        message = "";
                    }
                    Log.e(str, message);
                    MessageListBean messageHomeCache = SpData.getMessageHomeCache();
                    if (messageHomeCache != null) {
                        MessageHomeFragment.this.setData(messageHomeCache);
                        return;
                    }
                    return;
                }
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                MessageListBean messageListBean = (MessageListBean) value;
                if (messageListBean != null) {
                    MessageHomeFragment messageHomeFragment = MessageHomeFragment.this;
                    SPUtils.getInstance().put(SpData.MESSAGE_HOME_BENA, JSON.toJSONString(messageListBean));
                    messageHomeFragment.setData(messageListBean);
                }
                MessageListBean messageHomeCache2 = SpData.getMessageHomeCache();
                if (messageListBean != null || messageHomeCache2 == null) {
                    return;
                }
                MessageHomeFragment.this.setData(messageHomeCache2);
            }
        };
        messageHomeLiveData.observe(fragmentActivityRequireActivity, new Observer() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$MessageHomeFragment$jfZmUWY0cZtVMhRz8lj7cxNRYk8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MessageHomeFragment.initViewModel$lambda$8(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    public final void setData(MessageListBean item) {
        MessageHomeFragmentBinding messageHomeFragmentBinding;
        MessageHomeFragmentBinding messageHomeFragmentBinding2 = null;
        if (item.getNewsList() == null) {
            messageHomeFragmentBinding = this.viewBinding;
            if (messageHomeFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                messageHomeFragmentBinding = null;
            }
            messageHomeFragmentBinding.ivRight.setVisibility(8);
        } else {
            List<MessageItemBean> newsList = item.getNewsList();
            Integer numValueOf = newsList != null ? Integer.valueOf(newsList.size()) : null;
            Intrinsics.checkNotNull(numValueOf);
            if (numValueOf.intValue() > 1) {
                MessageHomeFragmentBinding messageHomeFragmentBinding3 = this.viewBinding;
                if (messageHomeFragmentBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    messageHomeFragmentBinding3 = null;
                }
                messageHomeFragmentBinding3.ivRight.setVisibility(0);
            } else {
                messageHomeFragmentBinding = this.viewBinding;
                if (messageHomeFragmentBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    messageHomeFragmentBinding = null;
                }
                messageHomeFragmentBinding.ivRight.setVisibility(8);
            }
        }
        MessageNewAdapter messageNewAdapter = this.mMessageNewAdapter;
        Intrinsics.checkNotNull(messageNewAdapter);
        messageNewAdapter.setList(item.getNewsList());
        MessageHomeFragmentBinding messageHomeFragmentBinding4 = this.viewBinding;
        if (messageHomeFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            messageHomeFragmentBinding2 = messageHomeFragmentBinding4;
        }
        messageHomeFragmentBinding2.viewPager2.setCurrentItem(0);
        MessageCampusAdapter messageCampusAdapter = this.mMessageCampusAdapter;
        Intrinsics.checkNotNull(messageCampusAdapter);
        messageCampusAdapter.setList(item.getCampusStyleList());
        MessagePosterAdapter messagePosterAdapter = this.mMessagePosterAdapter;
        Intrinsics.checkNotNull(messagePosterAdapter);
        messagePosterAdapter.setList(item.getPosterList());
        MessageNoticeAdapter messageNoticeAdapter = this.mMessageNoticeAdapter;
        Intrinsics.checkNotNull(messageNoticeAdapter);
        messageNoticeAdapter.setList(item.getAnnouncementList());
        MessageNoticeAdapter messageNoticeAdapter2 = this.mArticleAdapter;
        Intrinsics.checkNotNull(messageNoticeAdapter2);
        messageNoticeAdapter2.setList(item.getArticleList());
        MessageNoticeAdapter messageNoticeAdapter3 = this.mFoundAdapter;
        Intrinsics.checkNotNull(messageNoticeAdapter3);
        messageNoticeAdapter3.setList(item.getReceiveList());
    }
}
