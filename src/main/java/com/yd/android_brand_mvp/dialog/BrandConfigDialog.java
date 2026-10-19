package com.yd.android_brand_mvp.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseDialog;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.brand.BrandConfig;
import com.yd.android_brand_mvp.brand.BrandModelEnum;
import com.yd.android_brand_mvp.model.BrandConfigBean;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrandConfigDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/dialog/BrandConfigDialog;", "Lcom/yd/android_brand_mvp/base/BaseDialog;", "context", "Landroid/content/Context;", "theme", "", "(Landroid/content/Context;I)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BrandConfigDialog extends BaseDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandConfigDialog(Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.yd.android_brand_mvp.base.BaseDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_brand_config);
        BrandConfigBean brandConfigBean = (BrandConfigBean) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BRAND), BrandConfigBean.class);
        if (BrandConfig.brandModelEnum != null) {
            TextView textView = (TextView) findViewById(R.id.tvBrand);
            BrandModelEnum brandModelEnum = BrandConfig.brandModelEnum;
            textView.setText(brandModelEnum != null ? brandModelEnum.getModelName() : null);
            TextView textView2 = (TextView) findViewById(R.id.tvBrandModel);
            BrandModelEnum brandModelEnum2 = BrandConfig.brandModelEnum;
            textView2.setText(brandModelEnum2 != null ? brandModelEnum2.getModel() : null);
        }
        ((TextView) findViewById(R.id.tvCard)).setText(brandConfigBean.getCardReaderBrandCode());
        ((TextView) findViewById(R.id.tvFrequency)).setText(brandConfigBean.getCardReaderFrequencyCode());
        ((TextView) findViewById(R.id.tvSerial)).setText(brandConfigBean.getCardReaderSerialPortCode());
        ((TextView) findViewById(R.id.tvRotation)).setText("相机：" + brandConfigBean.getCameraAngleCode());
        ((TextView) findViewById(R.id.tvPreviewRotation)).setText("预览：" + brandConfigBean.getCameraPreviewCode());
    }
}
