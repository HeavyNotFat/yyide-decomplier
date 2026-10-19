package com.yd.android_brand_mvp.landscape.message.adapter;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.LayoutAnnouncementBinding;
import com.yd.android_brand_mvp.model.MessageDetail;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.StringUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageNoticeNewAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageNoticeNewAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "mOnItemClick", "Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageNoticeNewAdapter$OnItemClick;", "convert", "", "holder", "item", "setOnItemClick", "OnItemClick", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageNoticeNewAdapter extends BaseQuickAdapter<MessageItemBean, BaseViewHolder> {
    private OnItemClick mOnItemClick;

    /* JADX INFO: compiled from: MessageNoticeNewAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/adapter/MessageNoticeNewAdapter$OnItemClick;", "", "itemClick", "", "item", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnItemClick {
        void itemClick(MessageItemBean item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean convert$lambda$0(View view) {
        return true;
    }

    public MessageNoticeNewAdapter() {
        super(R.layout.layout_announcement, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, final MessageItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        LayoutAnnouncementBinding layoutAnnouncementBindingBind = LayoutAnnouncementBinding.bind(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(layoutAnnouncementBindingBind, "bind(holder.itemView)");
        layoutAnnouncementBindingBind.tvAnnTitle.setText(item.getTitle());
        layoutAnnouncementBindingBind.tvIssueName.setText(item.getIdentityUserName());
        layoutAnnouncementBindingBind.tvIssueTime.setText(DateUtils.formatTime(item.getTimerDate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm"));
        if (item.getContentType() == 0) {
            layoutAnnouncementBindingBind.webview.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.adapter.-$$Lambda$MessageNoticeNewAdapter$TAGAQY6sF0sNkI8X9RDVbqR7cbU
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return MessageNoticeNewAdapter.convert$lambda$0(view);
                }
            });
            layoutAnnouncementBindingBind.webview.loadDataWithBaseURL(null, StringUtils.formatHtmlData(item.getContent()), "text/html", "utf-8", null);
            layoutAnnouncementBindingBind.img.setVisibility(8);
            layoutAnnouncementBindingBind.tvContent.setVisibility(0);
            layoutAnnouncementBindingBind.msglayout.setVisibility(0);
            layoutAnnouncementBindingBind.tvAnnTitle.setVisibility(0);
            layoutAnnouncementBindingBind.webview.setVisibility(0);
            layoutAnnouncementBindingBind.webview.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.landscape.message.adapter.-$$Lambda$MessageNoticeNewAdapter$du5XtRM9ImSdBM0dOcOGRsSbFP4
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return MessageNoticeNewAdapter.convert$lambda$1(this.f$0, item, view, motionEvent);
                }
            });
            return;
        }
        layoutAnnouncementBindingBind.webview.setVisibility(8);
        layoutAnnouncementBindingBind.tvAnnTitle.setVisibility(8);
        layoutAnnouncementBindingBind.msglayout.setVisibility(8);
        layoutAnnouncementBindingBind.img.setVisibility(0);
        layoutAnnouncementBindingBind.tvContent.setVisibility(8);
        if (item.getDetails() != null) {
            List<MessageDetail> details = item.getDetails();
            Intrinsics.checkNotNull(details);
            if (!details.isEmpty()) {
                Context context = getContext();
                List<MessageDetail> details2 = item.getDetails();
                Intrinsics.checkNotNull(details2);
                String coverImg = details2.get(0).getCoverImg();
                if (coverImg == null) {
                    coverImg = "";
                }
                GlideUtil.loadNomalImage(context, coverImg, layoutAnnouncementBindingBind.img);
            }
        }
        layoutAnnouncementBindingBind.img.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.adapter.-$$Lambda$MessageNoticeNewAdapter$pipOe6K5YkkwSapEB89J2EzZ-TA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageNoticeNewAdapter.convert$lambda$2(this.f$0, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean convert$lambda$1(MessageNoticeNewAdapter this$0, MessageItemBean item, View view, MotionEvent motionEvent) {
        OnItemClick onItemClick;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        boolean z = false;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            z = true;
        }
        if (z && (onItemClick = this$0.mOnItemClick) != null) {
            onItemClick.itemClick(item);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$2(MessageNoticeNewAdapter this$0, MessageItemBean item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        OnItemClick onItemClick = this$0.mOnItemClick;
        if (onItemClick != null) {
            onItemClick.itemClick(item);
        }
    }

    public final void setOnItemClick(OnItemClick mOnItemClick) {
        Intrinsics.checkNotNullParameter(mOnItemClick, "mOnItemClick");
        this.mOnItemClick = mOnItemClick;
    }
}
