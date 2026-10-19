package com.yd.android_brand_mvp.model.custom;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* JADX INFO: compiled from: CustomJsonGroupBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/yd/android_brand_mvp/model/custom/CustomJsonGroupBean;", "", CMSAttributeTableGenerator.CONTENT_TYPE, "", "imageContent", "Lcom/yd/android_brand_mvp/model/custom/ImageContentBean;", "richTextContent", "Lcom/yd/android_brand_mvp/model/custom/RichTextContentBean;", "listContent", "Lcom/yd/android_brand_mvp/model/custom/ListContentBean;", "formContent", "Lcom/yd/android_brand_mvp/model/custom/FormContentBean;", "textContent", "Lcom/yd/android_brand_mvp/model/custom/TextContentBean;", "(ILcom/yd/android_brand_mvp/model/custom/ImageContentBean;Lcom/yd/android_brand_mvp/model/custom/RichTextContentBean;Lcom/yd/android_brand_mvp/model/custom/ListContentBean;Lcom/yd/android_brand_mvp/model/custom/FormContentBean;Lcom/yd/android_brand_mvp/model/custom/TextContentBean;)V", "getContentType", "()I", "getFormContent", "()Lcom/yd/android_brand_mvp/model/custom/FormContentBean;", "getImageContent", "()Lcom/yd/android_brand_mvp/model/custom/ImageContentBean;", "getListContent", "()Lcom/yd/android_brand_mvp/model/custom/ListContentBean;", "getRichTextContent", "()Lcom/yd/android_brand_mvp/model/custom/RichTextContentBean;", "getTextContent", "()Lcom/yd/android_brand_mvp/model/custom/TextContentBean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomJsonGroupBean {
    private final int contentType;
    private final FormContentBean formContent;
    private final ImageContentBean imageContent;
    private final ListContentBean listContent;
    private final RichTextContentBean richTextContent;
    private final TextContentBean textContent;

    public CustomJsonGroupBean() {
        this(0, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CustomJsonGroupBean copy$default(CustomJsonGroupBean customJsonGroupBean, int i, ImageContentBean imageContentBean, RichTextContentBean richTextContentBean, ListContentBean listContentBean, FormContentBean formContentBean, TextContentBean textContentBean, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = customJsonGroupBean.contentType;
        }
        if ((i2 & 2) != 0) {
            imageContentBean = customJsonGroupBean.imageContent;
        }
        ImageContentBean imageContentBean2 = imageContentBean;
        if ((i2 & 4) != 0) {
            richTextContentBean = customJsonGroupBean.richTextContent;
        }
        RichTextContentBean richTextContentBean2 = richTextContentBean;
        if ((i2 & 8) != 0) {
            listContentBean = customJsonGroupBean.listContent;
        }
        ListContentBean listContentBean2 = listContentBean;
        if ((i2 & 16) != 0) {
            formContentBean = customJsonGroupBean.formContent;
        }
        FormContentBean formContentBean2 = formContentBean;
        if ((i2 & 32) != 0) {
            textContentBean = customJsonGroupBean.textContent;
        }
        return customJsonGroupBean.copy(i, imageContentBean2, richTextContentBean2, listContentBean2, formContentBean2, textContentBean);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getContentType() {
        return this.contentType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImageContentBean getImageContent() {
        return this.imageContent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RichTextContentBean getRichTextContent() {
        return this.richTextContent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ListContentBean getListContent() {
        return this.listContent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FormContentBean getFormContent() {
        return this.formContent;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final TextContentBean getTextContent() {
        return this.textContent;
    }

    public final CustomJsonGroupBean copy(int contentType, ImageContentBean imageContent, RichTextContentBean richTextContent, ListContentBean listContent, FormContentBean formContent, TextContentBean textContent) {
        Intrinsics.checkNotNullParameter(imageContent, "imageContent");
        Intrinsics.checkNotNullParameter(richTextContent, "richTextContent");
        Intrinsics.checkNotNullParameter(listContent, "listContent");
        Intrinsics.checkNotNullParameter(formContent, "formContent");
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        return new CustomJsonGroupBean(contentType, imageContent, richTextContent, listContent, formContent, textContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomJsonGroupBean)) {
            return false;
        }
        CustomJsonGroupBean customJsonGroupBean = (CustomJsonGroupBean) other;
        return this.contentType == customJsonGroupBean.contentType && Intrinsics.areEqual(this.imageContent, customJsonGroupBean.imageContent) && Intrinsics.areEqual(this.richTextContent, customJsonGroupBean.richTextContent) && Intrinsics.areEqual(this.listContent, customJsonGroupBean.listContent) && Intrinsics.areEqual(this.formContent, customJsonGroupBean.formContent) && Intrinsics.areEqual(this.textContent, customJsonGroupBean.textContent);
    }

    public int hashCode() {
        return (((((((((this.contentType * 31) + this.imageContent.hashCode()) * 31) + this.richTextContent.hashCode()) * 31) + this.listContent.hashCode()) * 31) + this.formContent.hashCode()) * 31) + this.textContent.hashCode();
    }

    public String toString() {
        return "CustomJsonGroupBean(contentType=" + this.contentType + ", imageContent=" + this.imageContent + ", richTextContent=" + this.richTextContent + ", listContent=" + this.listContent + ", formContent=" + this.formContent + ", textContent=" + this.textContent + ')';
    }

    public CustomJsonGroupBean(int i, ImageContentBean imageContent, RichTextContentBean richTextContent, ListContentBean listContent, FormContentBean formContent, TextContentBean textContent) {
        Intrinsics.checkNotNullParameter(imageContent, "imageContent");
        Intrinsics.checkNotNullParameter(richTextContent, "richTextContent");
        Intrinsics.checkNotNullParameter(listContent, "listContent");
        Intrinsics.checkNotNullParameter(formContent, "formContent");
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        this.contentType = i;
        this.imageContent = imageContent;
        this.richTextContent = richTextContent;
        this.listContent = listContent;
        this.formContent = formContent;
        this.textContent = textContent;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public /* synthetic */ CustomJsonGroupBean(int i, ImageContentBean imageContentBean, RichTextContentBean richTextContentBean, ListContentBean listContentBean, FormContentBean formContentBean, TextContentBean textContentBean, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new ImageContentBean(null, 0L, false, null, 15, null) : imageContentBean, (i2 & 4) != 0 ? new RichTextContentBean(null, null, null, 0, null, false, false, false, 255, null) : richTextContentBean, (i2 & 8) != 0 ? new ListContentBean(null, null, 0, 0, 15, null) : listContentBean, (i2 & 16) != 0 ? new FormContentBean(null, null, 3, null) : formContentBean, (i2 & 32) != 0 ? new TextContentBean(null, 1, null) : textContentBean);
    }

    public final ImageContentBean getImageContent() {
        return this.imageContent;
    }

    public final RichTextContentBean getRichTextContent() {
        return this.richTextContent;
    }

    public final ListContentBean getListContent() {
        return this.listContent;
    }

    public final FormContentBean getFormContent() {
        return this.formContent;
    }

    public final TextContentBean getTextContent() {
        return this.textContent;
    }
}
