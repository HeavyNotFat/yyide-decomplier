package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.reflect.TypeToken;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.ttlock.bl.sdk.util.GsonUtil;
import com.yaoxiaowen.download.config.InnerConstant;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemBannerCustomBinding;
import com.yd.android_brand_mvp.databinding.ItemCustomTextBinding;
import com.yd.android_brand_mvp.landscape.video.SampleCoverVideo;
import com.yd.android_brand_mvp.model.BrandInfoBean;
import com.yd.android_brand_mvp.model.BrandSiteBean;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.home.CustomItemBean;
import com.yd.android_brand_mvp.model.home.CustomTextBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.widget.YDWebView;
import com.youth.banner.adapter.BannerAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: BannerCustomAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\"#B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J \u0010!\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/BannerCustomAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/yd/android_brand_mvp/model/home/CustomItemBean;", "Lcom/yd/android_brand_mvp/adapter/BannerCustomAdapter$BannerViewHolder;", "cx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getCx", "()Landroid/content/Context;", "mSampleCoverVideo", "Lcom/yd/android_brand_mvp/landscape/video/SampleCoverVideo;", "mVideoListener", "Lcom/yd/android_brand_mvp/adapter/BannerCustomAdapter$VideoListener;", "getBrandInfo", "", "webView", "Lcom/yd/android_brand_mvp/widget/YDWebView;", "getBrandSite", "getSampleCoverVideo", "onBindView", "holder", "data", "position", "", InnerConstant.Db.size, "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setVideoComplete", "text", "video", "BannerViewHolder", "VideoListener", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BannerCustomAdapter extends BannerAdapter<CustomItemBean, BannerViewHolder> {
    private final String TAG;
    private final Context cx;
    private SampleCoverVideo mSampleCoverVideo;
    private VideoListener mVideoListener;

    /* JADX INFO: compiled from: BannerCustomAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/BannerCustomAdapter$VideoListener;", "", "complete", "", "playError", "videoTime", "time", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface VideoListener {
        void complete();

        void playError();

        void videoTime(long time);
    }

    /* JADX INFO: compiled from: BannerCustomAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/BannerCustomAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemBannerCustomBinding;", "(Lcom/yd/android_brand_mvp/databinding/ItemBannerCustomBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/ItemBannerCustomBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemBannerCustomBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(ItemBannerCustomBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemBannerCustomBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerCustomAdapter(Context cx) {
        super(null);
        Intrinsics.checkNotNullParameter(cx, "cx");
        this.cx = cx;
        this.TAG = "BannerCustomAdapter";
    }

    public final Context getCx() {
        return this.cx;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemBannerCustomBinding itemBannerCustomBindingInflate = ItemBannerCustomBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemBannerCustomBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        this.mSampleCoverVideo = itemBannerCustomBindingInflate.videoItemPlayer;
        return new BannerViewHolder(itemBannerCustomBindingInflate);
    }

    public final void setVideoComplete(VideoListener mVideoListener) {
        Intrinsics.checkNotNullParameter(mVideoListener, "mVideoListener");
        this.mVideoListener = mVideoListener;
    }

    @Override // com.youth.banner.holder.IViewHolder
    public void onBindView(BannerViewHolder holder, CustomItemBean data, int position, int size) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        YDWebView yDWebView = holder.getBinding().wvItemBannerCustom;
        Intrinsics.checkNotNullExpressionValue(yDWebView, "holder.binding.wvItemBannerCustom");
        SimpleUtilsKt.remove(yDWebView);
        ImageView imageView = holder.getBinding().ivItemBannerCustom;
        Intrinsics.checkNotNullExpressionValue(imageView, "holder.binding.ivItemBannerCustom");
        SimpleUtilsKt.remove(imageView);
        LinearLayout linearLayout = holder.getBinding().linearLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "holder.binding.linearLayout");
        SimpleUtilsKt.remove(linearLayout);
        RecyclerView recyclerView = holder.getBinding().recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "holder.binding.recyclerView");
        SimpleUtilsKt.remove(recyclerView);
        SampleCoverVideo sampleCoverVideo = holder.getBinding().videoItemPlayer;
        Intrinsics.checkNotNullExpressionValue(sampleCoverVideo, "holder.binding.videoItemPlayer");
        SimpleUtilsKt.remove(sampleCoverVideo);
        Log.d("mCustomTextBean", "解析JSON = " + data.getSettingInfo());
        CustomTextBean customTextBean = (CustomTextBean) GsonUtils.fromJson(data.getSettingInfo(), CustomTextBean.class);
        Log.d("mCustomTextBean", "解析后对象 = " + GsonUtils.toJson(customTextBean));
        GlideUtil.loadCircleImage2(this.cx, SpData.getSchoolInfo2().data.schoolLogo, holder.getBinding().ivSchoolLogo);
        holder.getBinding().tvSchoolName.setText(SpData.getSchoolInfo2().data.schoolName);
        if (customTextBean != null) {
            if (customTextBean.getShowLogo()) {
                LinearLayout linearLayout2 = holder.getBinding().linearLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "holder.binding.linearLayout");
                SimpleUtilsKt.show(linearLayout2);
                if (!TextUtils.isEmpty(customTextBean.getTypeSetting())) {
                    String typeSetting = customTextBean.getTypeSetting();
                    int iHashCode = typeSetting.hashCode();
                    if (iHashCode != -1364013995) {
                        if (iHashCode != 3317767) {
                            if (iHashCode == 108511772 && typeSetting.equals(TtmlNode.RIGHT)) {
                                holder.getBinding().linearLayout.setGravity(GravityCompat.END);
                            }
                        } else if (typeSetting.equals(TtmlNode.LEFT)) {
                            holder.getBinding().linearLayout.setGravity(GravityCompat.START);
                        }
                    } else if (typeSetting.equals(TtmlNode.CENTER)) {
                        holder.getBinding().linearLayout.setGravity(17);
                    }
                }
            }
            GlideUtil.loadImage(this.cx, customTextBean.getBackground(), holder.getBinding().ivBk);
        }
        int type = data.getType();
        if (type == 1) {
            text(holder, data);
            return;
        }
        if (type == 2) {
            webView(holder, data);
            return;
        }
        if (type != 3) {
            if (type != 4) {
                return;
            }
            video(holder, data, position);
        } else {
            ImageView imageView2 = holder.getBinding().ivItemBannerCustom;
            Intrinsics.checkNotNullExpressionValue(imageView2, "holder.binding.ivItemBannerCustom");
            SimpleUtilsKt.show(imageView2);
            GlideUtil.loadImage(this.cx, data.getContent(), holder.getBinding().ivItemBannerCustom);
        }
    }

    private final void text(BannerViewHolder holder, CustomItemBean data) {
        RecyclerView recyclerView = holder.getBinding().recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "holder.binding.recyclerView");
        SimpleUtilsKt.show(recyclerView);
        holder.getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this.cx));
        holder.getBinding().recyclerView.setAdapter(new BaseQuickAdapter<CustomTextBean, BaseViewHolder>((List) GsonUtils.fromJson(data.getContent(), new TypeToken<List<? extends CustomTextBean>>() { // from class: com.yd.android_brand_mvp.adapter.BannerCustomAdapter$text$textList$1
        }.getType()), (CustomTextBean) GsonUtils.fromJson(data.getSettingInfo(), CustomTextBean.class)) { // from class: com.yd.android_brand_mvp.adapter.BannerCustomAdapter.text.1
            final /* synthetic */ CustomTextBean $textBean;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(R.layout.item_custom_text, TypeIntrinsics.asMutableList(list));
                this.$textBean = customTextBean;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder2, CustomTextBean item) {
                Intrinsics.checkNotNullParameter(holder2, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemCustomTextBinding itemCustomTextBindingBind = ItemCustomTextBinding.bind(holder2.itemView);
                Intrinsics.checkNotNullExpressionValue(itemCustomTextBindingBind, "bind(holder.itemView)");
                CustomTextBean customTextBean = this.$textBean;
                if (customTextBean != null && !TextUtils.isEmpty(customTextBean.getTypeSetting())) {
                    String typeSetting = customTextBean.getTypeSetting();
                    int iHashCode = typeSetting.hashCode();
                    if (iHashCode != -1364013995) {
                        if (iHashCode != 3317767) {
                            if (iHashCode == 108511772 && typeSetting.equals(TtmlNode.RIGHT)) {
                                itemCustomTextBindingBind.linearLayout.setGravity(GravityCompat.END);
                            }
                        } else if (typeSetting.equals(TtmlNode.LEFT)) {
                            itemCustomTextBindingBind.linearLayout.setGravity(GravityCompat.START);
                        }
                    } else if (typeSetting.equals(TtmlNode.CENTER)) {
                        itemCustomTextBindingBind.linearLayout.setGravity(17);
                    }
                }
                itemCustomTextBindingBind.tvText.setTextSize(Float.parseFloat(item.getFontSize()));
                itemCustomTextBindingBind.tvText.setTypeface(item.isBold() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                itemCustomTextBindingBind.tvText.setLineSpacing(itemCustomTextBindingBind.tvText.getLineSpacingExtra(), item.getRowPitch());
                itemCustomTextBindingBind.tvText.setText(item.getText());
            }
        });
    }

    private final void webView(final BannerViewHolder holder, CustomItemBean data) {
        YDWebView yDWebView = holder.getBinding().wvItemBannerCustom;
        Intrinsics.checkNotNullExpressionValue(yDWebView, "holder.binding.wvItemBannerCustom");
        SimpleUtilsKt.show(yDWebView);
        holder.getBinding().wvItemBannerCustom.getSettings().setJavaScriptEnabled(true);
        holder.getBinding().wvItemBannerCustom.getSettings().setSupportZoom(true);
        holder.getBinding().wvItemBannerCustom.getSettings().setCacheMode(-1);
        holder.getBinding().wvItemBannerCustom.getSettings().setDomStorageEnabled(true);
        holder.getBinding().wvItemBannerCustom.setWebViewClient(new WebViewClient() { // from class: com.yd.android_brand_mvp.adapter.BannerCustomAdapter.webView.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                BannerCustomAdapter bannerCustomAdapter = BannerCustomAdapter.this;
                YDWebView yDWebView2 = holder.getBinding().wvItemBannerCustom;
                Intrinsics.checkNotNullExpressionValue(yDWebView2, "holder.binding.wvItemBannerCustom");
                bannerCustomAdapter.getBrandInfo(yDWebView2);
                BannerCustomAdapter bannerCustomAdapter2 = BannerCustomAdapter.this;
                YDWebView yDWebView3 = holder.getBinding().wvItemBannerCustom;
                Intrinsics.checkNotNullExpressionValue(yDWebView3, "holder.binding.wvItemBannerCustom");
                bannerCustomAdapter2.getBrandSite(yDWebView3);
            }
        });
        holder.getBinding().wvItemBannerCustom.loadUrl(data.getContent());
    }

    private final void video(BannerViewHolder holder, CustomItemBean data, int position) {
        ImageView fullscreenButton;
        SampleCoverVideo sampleCoverVideo = holder.getBinding().videoItemPlayer;
        Intrinsics.checkNotNullExpressionValue(sampleCoverVideo, "holder.binding.videoItemPlayer");
        SimpleUtilsKt.show(sampleCoverVideo);
        HashMap map = new HashMap();
        map.put("ee", "33");
        new GSYVideoOptionBuilder().setIsTouchWiget(false).setIsTouchWigetFull(false).setUrl(data.getContent()).setHideKey(true).setVideoTitle("").setCacheWithPlay(true).setRotateViewAuto(false).setNeedShowWifiTip(false).setLockLand(true).setPlayTag(this.TAG).setPlayPosition(new Random().nextInt()).setMapHeadData(map).setShowFullAnimation(true).setNeedLockFull(true).setPlayPosition(position).build((StandardGSYVideoPlayer) this.mSampleCoverVideo);
        SampleCoverVideo sampleCoverVideo2 = this.mSampleCoverVideo;
        if (sampleCoverVideo2 != null) {
            sampleCoverVideo2.setPlayTag(this.TAG);
        }
        SampleCoverVideo sampleCoverVideo3 = this.mSampleCoverVideo;
        if (sampleCoverVideo3 != null) {
            sampleCoverVideo3.setPlayPosition(new Random().nextInt());
        }
        SampleCoverVideo sampleCoverVideo4 = this.mSampleCoverVideo;
        TextView titleTextView = sampleCoverVideo4 != null ? sampleCoverVideo4.getTitleTextView() : null;
        if (titleTextView != null) {
            titleTextView.setVisibility(8);
        }
        SampleCoverVideo sampleCoverVideo5 = this.mSampleCoverVideo;
        ImageView backButton = sampleCoverVideo5 != null ? sampleCoverVideo5.getBackButton() : null;
        if (backButton != null) {
            backButton.setVisibility(8);
        }
        SampleCoverVideo sampleCoverVideo6 = this.mSampleCoverVideo;
        ImageView fullscreenButton2 = sampleCoverVideo6 != null ? sampleCoverVideo6.getFullscreenButton() : null;
        if (fullscreenButton2 != null) {
            fullscreenButton2.setVisibility(8);
        }
        SampleCoverVideo sampleCoverVideo7 = this.mSampleCoverVideo;
        if (sampleCoverVideo7 != null && (fullscreenButton = sampleCoverVideo7.getFullscreenButton()) != null) {
            fullscreenButton.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$BannerCustomAdapter$SUFcjVoBIzJVYmdLw26Cg-dsfRA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BannerCustomAdapter.video$lambda$1(this.f$0, view);
                }
            });
        }
        SampleCoverVideo sampleCoverVideo8 = this.mSampleCoverVideo;
        if (sampleCoverVideo8 != null) {
            sampleCoverVideo8.setOnPlayState(new SampleCoverVideo.OnPlayState() { // from class: com.yd.android_brand_mvp.adapter.BannerCustomAdapter.video.2
                @Override // com.yd.android_brand_mvp.landscape.video.SampleCoverVideo.OnPlayState
                public void complete() {
                    VideoListener videoListener = BannerCustomAdapter.this.mVideoListener;
                    if (videoListener != null) {
                        videoListener.complete();
                    }
                    GSYVideoManager.instance().setNeedMute(false);
                }

                @Override // com.yd.android_brand_mvp.landscape.video.SampleCoverVideo.OnPlayState
                public void playing() {
                    SampleCoverVideo sampleCoverVideo9 = BannerCustomAdapter.this.mSampleCoverVideo;
                    if (sampleCoverVideo9 != null) {
                        long duration = sampleCoverVideo9.getDuration();
                        VideoListener videoListener = BannerCustomAdapter.this.mVideoListener;
                        if (videoListener != null) {
                            videoListener.videoTime(duration);
                        }
                    }
                }

                @Override // com.yd.android_brand_mvp.landscape.video.SampleCoverVideo.OnPlayState
                public void playError() {
                    VideoListener videoListener = BannerCustomAdapter.this.mVideoListener;
                    if (videoListener != null) {
                        videoListener.playError();
                    }
                }
            });
        }
        GSYVideoManager.instance().setNeedMute(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void video$lambda$1(BannerCustomAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SampleCoverVideo sampleCoverVideo = this$0.mSampleCoverVideo;
        if (sampleCoverVideo != null) {
            sampleCoverVideo.startWindowFullscreen(this$0.cx, true, true);
        }
    }

    /* JADX INFO: renamed from: getSampleCoverVideo, reason: from getter */
    public final SampleCoverVideo getMSampleCoverVideo() {
        return this.mSampleCoverVideo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object, java.lang.String] */
    public final void getBrandInfo(final YDWebView webView) {
        NewBrandLoginRsp.DataBean dataBean = SpData.NewUser().data;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str = "";
        objectRef.element = "";
        if (dataBean != null) {
            String str2 = dataBean.id;
            Intrinsics.checkNotNullExpressionValue(str2, "it.id");
            String str3 = dataBean.brandName;
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "it.brandName ?: \"\"");
            }
            String str4 = dataBean.classesId;
            if (str4 != null) {
                Intrinsics.checkNotNullExpressionValue(str4, "it.classesId ?: \"\"");
                str = str4;
            }
            ?? json = GsonUtil.toJson(new BrandInfoBean(str2, str3, str));
            Intrinsics.checkNotNullExpressionValue(json, "toJson(ben)");
            objectRef.element = json;
        }
        webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$BannerCustomAdapter$i9xvnSb0F5eZLnaPDID3NlunHDc
            @Override // java.lang.Runnable
            public final void run() {
                BannerCustomAdapter.getBrandInfo$lambda$3(objectRef, webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getBrandInfo$lambda$3(Ref.ObjectRef json, YDWebView webView) {
        Intrinsics.checkNotNullParameter(json, "$json");
        Intrinsics.checkNotNullParameter(webView, "$webView");
        LogUtils.i("getBrandInfo= " + ((String) json.element));
        webView.loadUrl("javascript:getBrandInfo('" + ((String) json.element) + "')");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object, java.lang.String] */
    public final void getBrandSite(final YDWebView webView) {
        NewBrandLoginRsp.DataBean dataBean = SpData.NewUser().data;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str = "";
        objectRef.element = "";
        if (dataBean != null) {
            String str2 = dataBean.siteId;
            Intrinsics.checkNotNullExpressionValue(str2, "it.siteId");
            String str3 = dataBean.siteName;
            if (str3 != null) {
                Intrinsics.checkNotNullExpressionValue(str3, "it.siteName ?: \"\"");
                str = str3;
            }
            ?? json = GsonUtil.toJson(new BrandSiteBean(str2, str));
            Intrinsics.checkNotNullExpressionValue(json, "toJson(ben)");
            objectRef.element = json;
        }
        webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$BannerCustomAdapter$VMbDqNwe9NzopANGgMpo3tDanlw
            @Override // java.lang.Runnable
            public final void run() {
                BannerCustomAdapter.getBrandSite$lambda$5(objectRef, webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getBrandSite$lambda$5(Ref.ObjectRef json, YDWebView webView) {
        Intrinsics.checkNotNullParameter(json, "$json");
        Intrinsics.checkNotNullParameter(webView, "$webView");
        LogUtils.i("getBrandSite= " + ((String) json.element));
        webView.loadUrl("javascript:getBrandSite('" + ((String) json.element) + "')");
    }
}
