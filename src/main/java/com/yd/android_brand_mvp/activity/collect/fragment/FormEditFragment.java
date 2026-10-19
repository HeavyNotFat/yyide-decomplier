package com.yd.android_brand_mvp.activity.collect.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ViewCollectFormEditBinding;
import com.yd.android_brand_mvp.model.BaseBean;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.BaseArrayBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.StringUtils;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.form.FormComponentUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.math.BigDecimal;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: FormEditFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormEditFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormEditBinding;", "()V", "DECIMAL_DIGITS", "", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "peopleId", "", "showMaxLength", "typeStr", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormEditFragment extends BaseCollectFragment<ViewCollectFormEditBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int DECIMAL_DIGITS;
    private FormBaseBean formItemData;
    private String peopleId;
    private int showMaxLength;
    private String typeStr;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormEditFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormEditFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewCollectFormEditBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ViewCollectFormEditBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ViewCollectFormEditBinding;", 0);
        }

        public final ViewCollectFormEditBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewCollectFormEditBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewCollectFormEditBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ViewCollectFormEditBinding access$getBinding(FormEditFragment formEditFragment) {
        return (ViewCollectFormEditBinding) formEditFragment.getBinding();
    }

    public FormEditFragment() {
        super(AnonymousClass1.INSTANCE);
        this.typeStr = "";
        this.peopleId = "";
    }

    /* JADX INFO: compiled from: FormEditFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormEditFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "typeStr", "", "peopleId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(FormBaseBean dataBean, String typeStr) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            Intrinsics.checkNotNullParameter(typeStr, "typeStr");
            FormEditFragment formEditFragment = new FormEditFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            bundle.putString("type", typeStr);
            formEditFragment.setArguments(bundle);
            return formEditFragment;
        }

        public final Fragment newInstance(FormBaseBean dataBean, String typeStr, String peopleId) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            Intrinsics.checkNotNullParameter(typeStr, "typeStr");
            Intrinsics.checkNotNullParameter(peopleId, "peopleId");
            FormEditFragment formEditFragment = new FormEditFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            bundle.putString("type", typeStr);
            bundle.putString("peopleId", peopleId);
            formEditFragment.setArguments(bundle);
            return formEditFragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Bundle arguments = getArguments();
        this.formItemData = (FormBaseBean) GsonUtils.fromJson(arguments != null ? arguments.getString("data") : null, FormBaseBean.class);
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("type", "") : null;
        if (string == null) {
            string = "";
        }
        this.typeStr = string;
        Bundle arguments3 = getArguments();
        String string2 = arguments3 != null ? arguments3.getString("peopleId", "") : null;
        this.peopleId = string2 != null ? string2 : "";
        ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setHorizontallyScrolling(false);
        ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setMaxLines(Integer.MAX_VALUE);
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean != null) {
            this.DECIMAL_DIGITS = formBaseBean.getProps().getPrecision();
            int maxlength = formBaseBean.getProps().getMaxlength();
            this.showMaxLength = maxlength;
            if (maxlength > 0) {
                ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.showMaxLength)});
            }
            if (formBaseBean.getProps().getPlaceholder().length() > 0) {
                ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setHint(formBaseBean.getProps().getPlaceholder());
            }
            ((ViewCollectFormEditBinding) getBinding()).tvViewCollectFormEditName.setText(TransUtils.INSTANCE.transIntToString(formBaseBean.getSortNum()) + '.' + formBaseBean.getTitle());
            if (!formBaseBean.getProps().getRequired()) {
                TextView textView = ((ViewCollectFormEditBinding) getBinding()).tvViewCollectFormEditRequired;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormEditRequired");
                SimpleUtilsKt.remove(textView);
            }
            String value = formBaseBean.getValue();
            if (!(value == null || value.length() == 0)) {
                ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setText(formBaseBean.getValue());
            }
            String limitCondition = formBaseBean.getLimitCondition();
            switch (limitCondition.hashCode()) {
                case -1194461493:
                    if (limitCondition.equals("idCard")) {
                        this.typeStr = FormComponentUtil.NumberID;
                    }
                    break;
                case 96511:
                    if (limitCondition.equals("age")) {
                        this.typeStr = FormComponentUtil.NumberInput;
                    }
                    break;
                case 3079749:
                    if (limitCondition.equals("dept")) {
                        this.typeStr = FormComponentUtil.DeptPicker;
                    }
                    break;
                case 106642798:
                    if (limitCondition.equals("phone")) {
                        this.typeStr = FormComponentUtil.PhoneInput;
                    }
                    break;
                case 853620774:
                    if (limitCondition.equals("classes")) {
                        this.typeStr = FormComponentUtil.ClassPicker;
                    }
                    break;
            }
        }
        String str = this.typeStr;
        switch (str.hashCode()) {
            case -1909728799:
                if (str.equals(FormComponentUtil.NumberInput)) {
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setSingleLine();
                    if (this.DECIMAL_DIGITS > 0) {
                        ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setInputType(8194);
                    } else {
                        ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setInputType(2);
                    }
                }
                break;
            case -1821795772:
                if (str.equals(FormComponentUtil.NumberID)) {
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setSingleLine();
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setFilters(new InputFilter[]{new InputFilter.LengthFilter(18)});
                }
                break;
            case -1151522764:
                if (str.equals(FormComponentUtil.ClassPicker)) {
                    StringBuilder sb = new StringBuilder();
                    FormBaseBean formBaseBean2 = this.formItemData;
                    if (formBaseBean2 != null) {
                        Intrinsics.checkNotNull(formBaseBean2);
                        List valueList = (List) GsonUtils.fromJson(formBaseBean2.getValue(), new TypeToken<List<? extends BaseBean>>() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormEditFragment$initView$2$valueList$1
                        }.getType());
                        Intrinsics.checkNotNullExpressionValue(valueList, "valueList");
                        int i = 0;
                        for (Object obj : valueList) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            sb.append(((BaseBean) obj).getName());
                            if (i != valueList.size() - 1) {
                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            }
                            i = i2;
                        }
                    }
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setText(sb.toString());
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setClickable(false);
                }
                break;
            case 77090126:
                if (str.equals(FormComponentUtil.PhoneInput)) {
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setSingleLine();
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setInputType(2);
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                }
                break;
            case 637996686:
                if (str.equals(FormComponentUtil.MultipleCascader)) {
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setEnabled(false);
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setBackgroundResource(R.drawable.bg_grey_d8_r10);
                    String siteName = SpData.getSiteName();
                    Intrinsics.checkNotNullExpressionValue(siteName, "siteName");
                    String str2 = siteName;
                    if (str2.length() == 0) {
                        ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setText("学生无需填写此项");
                    } else {
                        ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setText(str2);
                    }
                }
                break;
            case 945911421:
                if (str.equals(FormComponentUtil.TextInput)) {
                    ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setSingleLine();
                }
                break;
        }
        EditText editText = ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.etViewCollectFormEdit");
        editText.addTextChangedListener(new TextWatcher() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.FormEditFragment$initView$$inlined$doOnTextChanged$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                if (charSequence == null) {
                }
                if (StringsKt.contains$default((CharSequence) charSequence.toString(), (CharSequence) ".", false, 2, (Object) null) && (charSequence.length() - 1) - StringsKt.indexOf$default((CharSequence) charSequence.toString(), ".", 0, false, 6, (Object) null) > this.this$0.DECIMAL_DIGITS) {
                    charSequence = charSequence.toString().subSequence(0, StringsKt.indexOf$default((CharSequence) charSequence.toString(), ".", 0, false, 6, (Object) null) + this.this$0.DECIMAL_DIGITS + 1);
                    FormEditFragment.access$getBinding(this.this$0).etViewCollectFormEdit.setText(charSequence);
                    FormEditFragment.access$getBinding(this.this$0).etViewCollectFormEdit.setSelection(charSequence.length());
                }
                String strSubstring = StringsKt.trim((CharSequence) charSequence.toString()).toString().substring(0);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                if (Intrinsics.areEqual(strSubstring, ".")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('0');
                    sb2.append((Object) charSequence);
                    charSequence = sb2.toString();
                    FormEditFragment.access$getBinding(this.this$0).etViewCollectFormEdit.setText(charSequence);
                    FormEditFragment.access$getBinding(this.this$0).etViewCollectFormEdit.setSelection(2);
                }
                if (!StringsKt.startsWith$default(charSequence.toString(), "0", false, 2, (Object) null) || StringsKt.trim((CharSequence) charSequence.toString()).toString().length() <= 1) {
                    return;
                }
                String strSubstring2 = charSequence.toString().substring(1, 2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                if (Intrinsics.areEqual(strSubstring2, ".")) {
                    return;
                }
                FormEditFragment.access$getBinding(this.this$0).etViewCollectFormEdit.setText(charSequence.subSequence(0, 1));
                FormEditFragment.access$getBinding(this.this$0).etViewCollectFormEdit.setSelection(1);
            }
        });
        ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormEditFragment$B9gYSRcEMbLNEVFubrryCKy1Jns
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                return FormEditFragment.initView$lambda$5(this.f$0, textView2, i3, keyEvent);
            }
        });
        ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormEditFragment$uWrR87rm8rTs6wk1LZZpvmJj2Kk
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                FormEditFragment.initView$lambda$7(this.f$0, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean initView$lambda$5(FormEditFragment this$0, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != 4) {
            return false;
        }
        FormBaseBean formBaseBean = this$0.formItemData;
        if (formBaseBean != null && formBaseBean.getProps().getRequired()) {
            String string = StringsKt.trim((CharSequence) ((ViewCollectFormEditBinding) this$0.getBinding()).etViewCollectFormEdit.getText().toString()).toString();
            if (Intrinsics.areEqual(formBaseBean.getName(), FormComponentUtil.NumberInput)) {
                string = new BigDecimal(string).setScale(this$0.DECIMAL_DIGITS).toString();
                Intrinsics.checkNotNullExpressionValue(string, "text.setScale(DECIMAL_DIGITS).toString()");
            }
            FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
            formVerifyBean.setStatus(true);
            FormBaseBean formBaseBean2 = this$0.formItemData;
            Intrinsics.checkNotNull(formBaseBean2);
            formVerifyBean.setSort(formBaseBean2.getSort());
            formVerifyBean.setDataValue(string);
            EventBus.getDefault().post(formVerifyBean);
        }
        ((ViewCollectFormEditBinding) this$0.getBinding()).etViewCollectFormEdit.clearFocus();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$7(FormEditFragment this$0, View view, boolean z) {
        FormBaseBean formBaseBean;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = StringsKt.trim((CharSequence) ((ViewCollectFormEditBinding) this$0.getBinding()).etViewCollectFormEdit.getText().toString()).toString();
        if (z) {
            return;
        }
        if ((string.length() > 0) && (formBaseBean = this$0.formItemData) != null && formBaseBean.getProps().getRequired()) {
            String string2 = StringsKt.trim((CharSequence) ((ViewCollectFormEditBinding) this$0.getBinding()).etViewCollectFormEdit.getText().toString()).toString();
            if (Intrinsics.areEqual(formBaseBean.getName(), FormComponentUtil.NumberInput)) {
                string2 = new BigDecimal(string2).setScale(this$0.DECIMAL_DIGITS).toString();
                Intrinsics.checkNotNullExpressionValue(string2, "textBig.setScale(DECIMAL_DIGITS).toString()");
            }
            FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
            formVerifyBean.setStatus(true);
            FormBaseBean formBaseBean2 = this$0.formItemData;
            Intrinsics.checkNotNull(formBaseBean2);
            formVerifyBean.setSort(formBaseBean2.getSort());
            formVerifyBean.setDataValue(string2);
            EventBus.getDefault().post(formVerifyBean);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment
    public FormVerifyBean readySubmit() {
        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean == null) {
            formVerifyBean.setStatus(false);
            formVerifyBean.setErrorMessage("数据为空");
            return formVerifyBean;
        }
        Intrinsics.checkNotNull(formBaseBean);
        if (formBaseBean.getProps().getRequired()) {
            Editable text = ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.etViewCollectFormEdit.text");
            if (text.length() == 0) {
                formVerifyBean.setStatus(false);
                formVerifyBean.setErrorMessage("填空必填项未填写");
                return formVerifyBean;
            }
        }
        if (!Intrinsics.areEqual(this.typeStr, FormComponentUtil.ClassPicker)) {
            String string = ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.getText().toString();
            String str = this.typeStr;
            switch (str.hashCode()) {
                case -1909728799:
                    if (str.equals(FormComponentUtil.NumberInput)) {
                        if (string.length() > 0) {
                            string = new BigDecimal(StringsKt.trim((CharSequence) ((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.getText().toString()).toString()).setScale(this.DECIMAL_DIGITS).toString();
                            Intrinsics.checkNotNullExpressionValue(string, "text.setScale(DECIMAL_DIGITS).toString()");
                        }
                    }
                    formVerifyBean.setDataValue(string);
                    break;
                case -1821795772:
                    if (str.equals(FormComponentUtil.NumberID)) {
                        if ((string.length() > 0) && !StringUtils.isIdCardNum(((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.getText().toString())) {
                            formVerifyBean.setStatus(false);
                            formVerifyBean.setErrorMessage("身份证格式不对");
                        }
                    }
                    formVerifyBean.setDataValue(string);
                    break;
                case 77090126:
                    if (str.equals(FormComponentUtil.PhoneInput)) {
                        if ((string.length() > 0) && !StringUtils.isMobileNumber(((ViewCollectFormEditBinding) getBinding()).etViewCollectFormEdit.getText().toString())) {
                            formVerifyBean.setStatus(false);
                            formVerifyBean.setErrorMessage("手机号码格式不对");
                        }
                    }
                    formVerifyBean.setDataValue(string);
                    break;
                case 637996686:
                    if (str.equals(FormComponentUtil.MultipleCascader)) {
                        String siteId = SpData.getSiteId();
                        String siteName = SpData.getSiteName();
                        Intrinsics.checkNotNullExpressionValue(siteId, "siteId");
                        Intrinsics.checkNotNullExpressionValue(siteName, "siteName");
                        string = GsonUtils.toJson(CollectionsKt.mutableListOf(new BaseArrayBean(siteId, siteName, false, 4, null)));
                        Intrinsics.checkNotNullExpressionValue(string, "toJson(valuePostListBean)");
                    }
                    formVerifyBean.setDataValue(string);
                    break;
                default:
                    formVerifyBean.setDataValue(string);
                    break;
            }
            return formVerifyBean;
        }
        formVerifyBean.setDataValue(null);
        FormBaseBean formBaseBean2 = this.formItemData;
        Intrinsics.checkNotNull(formBaseBean2);
        formVerifyBean.setSort(formBaseBean2.getSort());
        return formVerifyBean;
    }
}
