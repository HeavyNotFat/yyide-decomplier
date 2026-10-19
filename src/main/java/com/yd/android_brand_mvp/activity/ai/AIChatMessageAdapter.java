package com.yd.android_brand_mvp.activity.ai;

import android.content.ClipboardManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ItemAiMessageBinding;
import com.yd.android_brand_mvp.databinding.ItemUserMessageBinding;
import com.yd.android_brand_mvp.model.ai.AIChatMessageBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import io.noties.markwon.Markwon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIChatMessageAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0014J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/activity/ai/AIChatMessageAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/yd/android_brand_mvp/model/ai/AIChatMessageBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "markwon", "Lio/noties/markwon/Markwon;", "(Lio/noties/markwon/Markwon;)V", "delayedRunnables", "", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "onItemScrollListener", "Lcom/yd/android_brand_mvp/activity/ai/AIChatMessageAdapter$OnItemScrollListener;", "runnable", "scrollTime", "", "bindAiMessage", "", "holder", "item", "bindUserMessage", "convert", "onViewRecycled", "setOnItemScrollListener", "setTextPrint", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemAiMessageBinding;", "Companion", "OnItemScrollListener", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AIChatMessageAdapter extends BaseMultiItemQuickAdapter<AIChatMessageBean, BaseViewHolder> {
    public static final int ITEM_TYPE_AI = 2;
    public static final int ITEM_TYPE_USER = 1;
    private final List<Runnable> delayedRunnables;
    private final Handler handler;
    private final Markwon markwon;
    private OnItemScrollListener onItemScrollListener;
    private final Runnable runnable;
    private long scrollTime;

    /* JADX INFO: compiled from: AIChatMessageAdapter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/activity/ai/AIChatMessageAdapter$OnItemScrollListener;", "", "onItemScroll", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnItemScrollListener {
        void onItemScroll();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIChatMessageAdapter(Markwon markwon) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(markwon, "markwon");
        this.markwon = markwon;
        this.handler = new Handler(Looper.getMainLooper());
        this.delayedRunnables = new ArrayList();
        addItemType(1, R.layout.item_user_message);
        addItemType(2, R.layout.item_ai_message);
        this.runnable = new Runnable() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIChatMessageAdapter$9hYJp3DZV5pqjHNIplS3tVX1fUQ
            @Override // java.lang.Runnable
            public final void run() {
                AIChatMessageAdapter.runnable$lambda$8(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, AIChatMessageBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            bindUserMessage(holder, item);
        } else {
            if (itemViewType != 2) {
                return;
            }
            bindAiMessage(holder, item);
        }
    }

    private final void bindUserMessage(BaseViewHolder holder, AIChatMessageBean item) {
        ItemUserMessageBinding.bind(holder.itemView).tvMessage.setText(item.getContent());
    }

    private final void bindAiMessage(BaseViewHolder holder, AIChatMessageBean item) {
        final ItemAiMessageBinding itemAiMessageBindingBind = ItemAiMessageBinding.bind(holder.itemView);
        itemAiMessageBindingBind.tvTitle.setText(item.getTitle());
        GlideUtil.loadCircleImage(getContext(), item.getIcon(), itemAiMessageBindingBind.ivIcon);
        Group groupView = itemAiMessageBindingBind.groupView;
        Intrinsics.checkNotNullExpressionValue(groupView, "groupView");
        SimpleUtilsKt.remove(groupView);
        ProgressBar loadingProgressBar = itemAiMessageBindingBind.loadingProgressBar;
        Intrinsics.checkNotNullExpressionValue(loadingProgressBar, "loadingProgressBar");
        SimpleUtilsKt.show(loadingProgressBar);
        if (item.getCode() == 1) {
            Group groupView2 = itemAiMessageBindingBind.groupView;
            Intrinsics.checkNotNullExpressionValue(groupView2, "groupView");
            SimpleUtilsKt.show(groupView2);
            ProgressBar loadingProgressBar2 = itemAiMessageBindingBind.loadingProgressBar;
            Intrinsics.checkNotNullExpressionValue(loadingProgressBar2, "loadingProgressBar");
            SimpleUtilsKt.hide(loadingProgressBar2);
            item.setShow(true);
            itemAiMessageBindingBind.ctCopy.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIChatMessageAdapter$QoetdhTIwwMP3UgEPyBddWKX8b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AIChatMessageAdapter.bindAiMessage$lambda$4$lambda$1(itemAiMessageBindingBind, this, view);
                }
            });
            itemAiMessageBindingBind.ctStep.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIChatMessageAdapter$2RmUjvReexRz9ZNCzBBaF2DZyGA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AIChatMessageAdapter.bindAiMessage$lambda$4$lambda$2(itemAiMessageBindingBind, view);
                }
            });
            itemAiMessageBindingBind.ctGive.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIChatMessageAdapter$ZTUeuAfotZattdhmRz8rQX1WoM8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AIChatMessageAdapter.bindAiMessage$lambda$4$lambda$3(itemAiMessageBindingBind, view);
                }
            });
        } else if (item.getCode() == -1) {
            ProgressBar loadingProgressBar3 = itemAiMessageBindingBind.loadingProgressBar;
            Intrinsics.checkNotNullExpressionValue(loadingProgressBar3, "loadingProgressBar");
            SimpleUtilsKt.hide(loadingProgressBar3);
            Group groupView3 = itemAiMessageBindingBind.groupView;
            Intrinsics.checkNotNullExpressionValue(groupView3, "groupView");
            SimpleUtilsKt.hide(groupView3);
        }
        if (TextUtils.isEmpty(item.getContent())) {
            return;
        }
        TextView tvMessage = itemAiMessageBindingBind.tvMessage;
        Intrinsics.checkNotNullExpressionValue(tvMessage, "tvMessage");
        SimpleUtilsKt.show(tvMessage);
        if (!item.isShow()) {
            Intrinsics.checkNotNullExpressionValue(itemAiMessageBindingBind, "this");
            setTextPrint(item, itemAiMessageBindingBind);
        } else {
            this.markwon.setMarkdown(itemAiMessageBindingBind.tvMessage, item.getContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindAiMessage$lambda$4$lambda$1(ItemAiMessageBinding this_apply, AIChatMessageAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_apply.ctCopy.setChecked(!this_apply.ctCopy.isChecked());
        Object systemService = this$0.getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (this_apply.ctCopy.isChecked()) {
            clipboardManager.setText(this_apply.tvMessage.getText().toString());
        } else {
            clipboardManager.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindAiMessage$lambda$4$lambda$2(ItemAiMessageBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.ctStep.setChecked(!this_apply.ctStep.isChecked());
        this_apply.ctGive.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindAiMessage$lambda$4$lambda$3(ItemAiMessageBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.ctGive.setChecked(!this_apply.ctGive.isChecked());
        this_apply.ctStep.setChecked(false);
    }

    private final void setTextPrint(final AIChatMessageBean item, final ItemAiMessageBinding binding) {
        if (item.getCurrentIndex() >= item.getContent().length()) {
            if (item.getCode() == 1) {
                Group group = binding.groupView;
                Intrinsics.checkNotNullExpressionValue(group, "binding.groupView");
                SimpleUtilsKt.show(group);
                return;
            }
            return;
        }
        Markwon markwon = this.markwon;
        TextView textView = binding.tvMessage;
        String content = item.getContent();
        item.setCurrentIndex(item.getCurrentIndex() + 1);
        String strSubstring = content.substring(0, item.getCurrentIndex());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        markwon.setMarkdown(textView, strSubstring);
        binding.getRoot().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.activity.ai.-$$Lambda$AIChatMessageAdapter$jYciMlE_CgzVdPpGw7Y6tAV6Xn8
            @Override // java.lang.Runnable
            public final void run() {
                AIChatMessageAdapter.setTextPrint$lambda$5(this.f$0, item, binding);
            }
        }, 50L);
        binding.getRoot().postDelayed(this.runnable, 600L);
        binding.tvTextCount.setText("字数：" + item.getContent().length() + (char) 23383);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTextPrint$lambda$5(AIChatMessageAdapter this$0, AIChatMessageBean item, ItemAiMessageBinding binding) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        this$0.setTextPrint(item, binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        Iterator<T> it2 = this.delayedRunnables.iterator();
        while (it2.hasNext()) {
            this.handler.removeCallbacks((Runnable) it2.next());
        }
        this.delayedRunnables.clear();
        if (holder.getItemViewType() == 2) {
            ItemAiMessageBinding itemAiMessageBindingBind = ItemAiMessageBinding.bind(holder.itemView);
            Glide.with(getContext()).clear(itemAiMessageBindingBind.ivIcon);
            itemAiMessageBindingBind.tvMessage.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runnable$lambda$8(AIChatMessageAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this$0.scrollTime >= 600) {
            this$0.scrollTime = jCurrentTimeMillis;
            OnItemScrollListener onItemScrollListener = this$0.onItemScrollListener;
            if (onItemScrollListener != null) {
                onItemScrollListener.onItemScroll();
            }
        }
    }

    public final void setOnItemScrollListener(OnItemScrollListener onItemScrollListener) {
        Intrinsics.checkNotNullParameter(onItemScrollListener, "onItemScrollListener");
        this.onItemScrollListener = onItemScrollListener;
    }
}
