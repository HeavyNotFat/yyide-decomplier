package com.yd.android_brand_mvp.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.reflect.TypeToken;
import com.ttlock.bl.sdk.util.GsonUtil;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemBannerCustomBinding;
import com.yd.android_brand_mvp.databinding.ItemCustomTextBinding;
import com.yd.android_brand_mvp.landscape.video.RecyclerItemNormalHolder;
import com.yd.android_brand_mvp.landscape.video.SampleCoverVideo;
import com.yd.android_brand_mvp.landscape.video.ViewPagerAdapter;
import com.yd.android_brand_mvp.model.BrandInfoBean;
import com.yd.android_brand_mvp.model.BrandSiteBean;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.model.home.CustomItemBean;
import com.yd.android_brand_mvp.model.home.CustomTextBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TextViewLinesUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.widget.YDWebView;
import com.yyide.facepass.AppExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: BannerCustomAdapter2.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0016\u0010\u001a\u001a\u00020\f2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0010\u0010\u001c\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\bH\u0002J(\u0010 \u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/BannerCustomAdapter2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemDataList", "", "Lcom/yd/android_brand_mvp/model/home/CustomItemBean;", "onVideoPlay", "Lcom/yd/android_brand_mvp/landscape/video/ViewPagerAdapter$OnNext;", "getBrandInfo", "", "webView", "Lcom/yd/android_brand_mvp/widget/YDWebView;", "getBrandSite", "getDataList", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setListData", "data", "setOnNext", "text", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemBannerCustomBinding;", "video", "Lcom/yd/android_brand_mvp/landscape/video/RecyclerItemNormalHolder;", "OnNext", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BannerCustomAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CustomItemBean> itemDataList;
    private ViewPagerAdapter.OnNext onVideoPlay;

    /* JADX INFO: compiled from: BannerCustomAdapter2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/BannerCustomAdapter2$OnNext;", "", "next", "", FirebaseAnalytics.Param.INDEX, "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnNext {
        void next(int index);
    }

    public BannerCustomAdapter2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemBannerCustomBinding itemBannerCustomBindingInflate = ItemBannerCustomBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemBannerCustomBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new RecyclerItemNormalHolder(this.context, itemBannerCustomBindingInflate.getRoot(), false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<CustomItemBean> list = this.itemDataList;
        Intrinsics.checkNotNull(list);
        CustomItemBean customItemBean = list.get(position);
        ItemBannerCustomBinding itemBannerCustomBindingBind = ItemBannerCustomBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemBannerCustomBindingBind, "bind(holder.itemView)");
        YDWebView yDWebView = itemBannerCustomBindingBind.wvItemBannerCustom;
        Intrinsics.checkNotNullExpressionValue(yDWebView, "binding.wvItemBannerCustom");
        SimpleUtilsKt.remove(yDWebView);
        ImageView imageView = itemBannerCustomBindingBind.ivItemBannerCustom;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivItemBannerCustom");
        SimpleUtilsKt.remove(imageView);
        LinearLayout linearLayout = itemBannerCustomBindingBind.linearLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.linearLayout");
        SimpleUtilsKt.remove(linearLayout);
        RecyclerView recyclerView = itemBannerCustomBindingBind.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        SimpleUtilsKt.remove(recyclerView);
        SampleCoverVideo sampleCoverVideo = itemBannerCustomBindingBind.videoItemPlayer;
        Intrinsics.checkNotNullExpressionValue(sampleCoverVideo, "binding.videoItemPlayer");
        SimpleUtilsKt.remove(sampleCoverVideo);
        Log.d("mCustomTextBean", "解析JSON = " + customItemBean.getSettingInfo());
        CustomTextBean customTextBean = (CustomTextBean) GsonUtils.fromJson(customItemBean.getSettingInfo(), CustomTextBean.class);
        Log.d("mCustomTextBean", "解析后对象 = " + GsonUtils.toJson(customTextBean));
        GlideUtil.loadCircleImage2(this.context, SpData.getSchoolInfo2().data.schoolLogo, itemBannerCustomBindingBind.ivSchoolLogo);
        itemBannerCustomBindingBind.tvSchoolName.setText(SpData.getSchoolInfo2().data.schoolName);
        if (customTextBean != null) {
            if (customTextBean.getShowLogo()) {
                LinearLayout linearLayout2 = itemBannerCustomBindingBind.linearLayout;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.linearLayout");
                SimpleUtilsKt.show(linearLayout2);
                if (!TextUtils.isEmpty(customTextBean.getTypeSetting())) {
                    String typeSetting = customTextBean.getTypeSetting();
                    int iHashCode = typeSetting.hashCode();
                    if (iHashCode != -1364013995) {
                        if (iHashCode != 3317767) {
                            if (iHashCode == 108511772 && typeSetting.equals(TtmlNode.RIGHT)) {
                                itemBannerCustomBindingBind.linearLayout.setGravity(GravityCompat.END);
                            }
                        } else if (typeSetting.equals(TtmlNode.LEFT)) {
                            itemBannerCustomBindingBind.linearLayout.setGravity(GravityCompat.START);
                        }
                    } else if (typeSetting.equals(TtmlNode.CENTER)) {
                        itemBannerCustomBindingBind.linearLayout.setGravity(17);
                    }
                }
            }
            GlideUtil.loadImage(this.context, customTextBean.getBackground(), itemBannerCustomBindingBind.ivBk);
        }
        int type = customItemBean.getType();
        if (type == 1) {
            text(itemBannerCustomBindingBind, customItemBean);
            return;
        }
        if (type == 2) {
            webView(itemBannerCustomBindingBind, customItemBean);
            return;
        }
        if (type != 3) {
            if (type != 4) {
                return;
            }
            video((RecyclerItemNormalHolder) holder, itemBannerCustomBindingBind, customItemBean, position);
        } else {
            ImageView imageView2 = itemBannerCustomBindingBind.ivItemBannerCustom;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivItemBannerCustom");
            SimpleUtilsKt.show(imageView2);
            GlideUtil.loadImage(this.context, customItemBean.getContent(), itemBannerCustomBindingBind.ivItemBannerCustom);
        }
    }

    private final void text(ItemBannerCustomBinding binding, CustomItemBean data) {
        List list = (List) GsonUtils.fromJson(data.getContent(), new TypeToken<List<? extends CustomTextBean>>() { // from class: com.yd.android_brand_mvp.adapter.BannerCustomAdapter2$text$textList$1
        }.getType());
        CustomTextBean customTextBean = (CustomTextBean) GsonUtils.fromJson(data.getSettingInfo(), CustomTextBean.class);
        if (list == null || list.size() != 1) {
            return;
        }
        CustomTextBean customTextBean2 = (CustomTextBean) CollectionsKt.first(list);
        if (customTextBean != null && !TextUtils.isEmpty(customTextBean.getTypeSetting())) {
            String typeSetting = customTextBean.getTypeSetting();
            int iHashCode = typeSetting.hashCode();
            if (iHashCode != -1364013995) {
                if (iHashCode != 3317767) {
                    if (iHashCode == 108511772 && typeSetting.equals(TtmlNode.RIGHT)) {
                        binding.tvText.setGravity(GravityCompat.END);
                    }
                } else if (typeSetting.equals(TtmlNode.LEFT)) {
                    binding.tvText.setGravity(GravityCompat.START);
                }
            } else if (typeSetting.equals(TtmlNode.CENTER)) {
                binding.tvText.setGravity(17);
            }
        }
        binding.tvText.setTextSize(Float.parseFloat(customTextBean2.getFontSize()));
        binding.tvText.setTypeface(customTextBean2.isBold() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        binding.tvText.setLineSpacing(Float.parseFloat(customTextBean2.getFontSize()), customTextBean2.getRowPitch());
        binding.tvText.setText(customTextBean2.getText());
        if (TextViewLinesUtil.getTextViewLines(binding.tvText, ScreenUtils.getScreenWidth()) > 1) {
            TextView textView = binding.tvText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvText");
            SimpleUtilsKt.remove(textView);
            RecyclerView recyclerView = binding.recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
            SimpleUtilsKt.show(recyclerView);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
            binding.recyclerView.setAdapter(new BaseQuickAdapter<CustomTextBean, BaseViewHolder>(list, customTextBean) { // from class: com.yd.android_brand_mvp.adapter.BannerCustomAdapter2.text.2
                final /* synthetic */ CustomTextBean $textBean;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(R.layout.item_custom_text, TypeIntrinsics.asMutableList(list));
                    this.$textBean = customTextBean;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.chad.library.adapter.base.BaseQuickAdapter
                public void convert(BaseViewHolder holder, CustomTextBean item) {
                    Intrinsics.checkNotNullParameter(holder, "holder");
                    Intrinsics.checkNotNullParameter(item, "item");
                    ItemCustomTextBinding itemCustomTextBindingBind = ItemCustomTextBinding.bind(holder.itemView);
                    Intrinsics.checkNotNullExpressionValue(itemCustomTextBindingBind, "bind(holder.itemView)");
                    CustomTextBean customTextBean3 = this.$textBean;
                    if (customTextBean3 != null && !TextUtils.isEmpty(customTextBean3.getTypeSetting())) {
                        String typeSetting2 = customTextBean3.getTypeSetting();
                        int iHashCode2 = typeSetting2.hashCode();
                        if (iHashCode2 != -1364013995) {
                            if (iHashCode2 != 3317767) {
                                if (iHashCode2 == 108511772 && typeSetting2.equals(TtmlNode.RIGHT)) {
                                    itemCustomTextBindingBind.tvText.setGravity(GravityCompat.END);
                                }
                            } else if (typeSetting2.equals(TtmlNode.LEFT)) {
                                itemCustomTextBindingBind.tvText.setGravity(GravityCompat.START);
                            }
                        } else if (typeSetting2.equals(TtmlNode.CENTER)) {
                            itemCustomTextBindingBind.tvText.setGravity(17);
                        }
                    }
                    itemCustomTextBindingBind.view.getLayoutParams().height = (int) ((Float.parseFloat(item.getFontSize()) * item.getRowPitch()) - Float.parseFloat(item.getFontSize()));
                    itemCustomTextBindingBind.tvText.setTextSize(Float.parseFloat(item.getFontSize()));
                    itemCustomTextBindingBind.tvText.setTypeface(item.isBold() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
                    itemCustomTextBindingBind.tvText.setLineSpacing(Float.parseFloat(item.getFontSize()), item.getRowPitch());
                    itemCustomTextBindingBind.tvText.setText(item.getText());
                }
            });
            return;
        }
        RecyclerView recyclerView2 = binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        SimpleUtilsKt.remove(recyclerView2);
        TextView textView2 = binding.tvText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvText");
        SimpleUtilsKt.show(textView2);
    }

    private final void webView(final ItemBannerCustomBinding binding, CustomItemBean data) {
        YDWebView yDWebView = binding.wvItemBannerCustom;
        Intrinsics.checkNotNullExpressionValue(yDWebView, "binding.wvItemBannerCustom");
        SimpleUtilsKt.show(yDWebView);
        binding.wvItemBannerCustom.getSettings().setJavaScriptEnabled(true);
        binding.wvItemBannerCustom.getSettings().setSupportZoom(true);
        binding.wvItemBannerCustom.getSettings().setCacheMode(-1);
        binding.wvItemBannerCustom.getSettings().setDomStorageEnabled(true);
        binding.wvItemBannerCustom.setWebViewClient(new WebViewClient() { // from class: com.yd.android_brand_mvp.adapter.BannerCustomAdapter2.webView.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                BannerCustomAdapter2 bannerCustomAdapter2 = BannerCustomAdapter2.this;
                YDWebView yDWebView2 = binding.wvItemBannerCustom;
                Intrinsics.checkNotNullExpressionValue(yDWebView2, "binding.wvItemBannerCustom");
                bannerCustomAdapter2.getBrandInfo(yDWebView2);
                BannerCustomAdapter2 bannerCustomAdapter3 = BannerCustomAdapter2.this;
                YDWebView yDWebView3 = binding.wvItemBannerCustom;
                Intrinsics.checkNotNullExpressionValue(yDWebView3, "binding.wvItemBannerCustom");
                bannerCustomAdapter3.getBrandSite(yDWebView3);
            }
        });
        binding.wvItemBannerCustom.loadUrl(data.getContent());
    }

    private final void video(RecyclerItemNormalHolder holder, ItemBannerCustomBinding binding, CustomItemBean data, final int position) {
        SampleCoverVideo sampleCoverVideo = binding.videoItemPlayer;
        Intrinsics.checkNotNullExpressionValue(sampleCoverVideo, "binding.videoItemPlayer");
        SimpleUtilsKt.show(sampleCoverVideo);
        holder.setRecyclerBaseAdapter(this);
        VideoListBean.DataBean dataBean = new VideoListBean.DataBean();
        dataBean.url = data.getContent();
        holder.onBind(position, dataBean);
        holder.getPlayer().setOnPlayState(new SampleCoverVideo.OnPlayState() { // from class: com.yd.android_brand_mvp.adapter.BannerCustomAdapter2.video.1
            @Override // com.yd.android_brand_mvp.landscape.video.SampleCoverVideo.OnPlayState
            public void playError() {
            }

            @Override // com.yd.android_brand_mvp.landscape.video.SampleCoverVideo.OnPlayState
            public void playing() {
            }

            @Override // com.yd.android_brand_mvp.landscape.video.SampleCoverVideo.OnPlayState
            public void complete() {
                List list = BannerCustomAdapter2.this.itemDataList;
                Intrinsics.checkNotNull(list);
                list.size();
                List list2 = BannerCustomAdapter2.this.itemDataList;
                Intrinsics.checkNotNull(list2);
                int size = list2.size();
                int i = position;
                int i2 = size == i + 1 ? 0 : i + 1;
                ViewPagerAdapter.OnNext onNext = BannerCustomAdapter2.this.onVideoPlay;
                if (onNext != null) {
                    onNext.next(i2);
                }
            }
        });
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
        webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$BannerCustomAdapter2$5RDhjz2XQU66XG2Wmj37cqJvjwU
            @Override // java.lang.Runnable
            public final void run() {
                BannerCustomAdapter2.getBrandInfo$lambda$3(this.f$0, objectRef, webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getBrandInfo$lambda$3(BannerCustomAdapter2 this$0, Ref.ObjectRef json, YDWebView webView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(json, "$json");
        Intrinsics.checkNotNullParameter(webView, "$webView");
        AppExtKt.loge(this$0, "getBrandInfo= " + ((String) json.element));
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
        webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.adapter.-$$Lambda$BannerCustomAdapter2$_YIVWIUT9E2EDev0bPEnhmZxqrs
            @Override // java.lang.Runnable
            public final void run() {
                BannerCustomAdapter2.getBrandSite$lambda$5(this.f$0, objectRef, webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getBrandSite$lambda$5(BannerCustomAdapter2 this$0, Ref.ObjectRef json, YDWebView webView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(json, "$json");
        Intrinsics.checkNotNullParameter(webView, "$webView");
        AppExtKt.loge(this$0, "getBrandSite= " + ((String) json.element));
        webView.loadUrl("javascript:getBrandSite('" + ((String) json.element) + "')");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<CustomItemBean> list = this.itemDataList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void setOnNext(ViewPagerAdapter.OnNext onVideoPlay) {
        this.onVideoPlay = onVideoPlay;
    }

    public final void setListData(List<CustomItemBean> data) {
        this.itemDataList = data;
        notifyDataSetChanged();
    }

    public final List<CustomItemBean> getDataList() {
        return this.itemDataList;
    }
}
