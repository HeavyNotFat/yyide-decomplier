package com.yd.android_brand_mvp.activity.collect.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.utils.LunarCalendar;
import com.bigkoo.pickerview.view.TimePickerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ViewCollectFormDateBinding;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: FormDateFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormDateFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormDateBinding;", "()V", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "selectTime", "Ljava/util/Calendar;", "timeView", "Lcom/bigkoo/pickerview/view/TimePickerView;", "initTimeSelectView", "", "type", "", "timeFormat", "", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormDateFragment extends BaseCollectFragment<ViewCollectFormDateBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FormBaseBean formItemData;
    private Calendar selectTime;
    private TimePickerView timeView;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormDateFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormDateFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewCollectFormDateBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ViewCollectFormDateBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ViewCollectFormDateBinding;", 0);
        }

        public final ViewCollectFormDateBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewCollectFormDateBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewCollectFormDateBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX INFO: compiled from: FormDateFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormDateFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(FormBaseBean dataBean) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            FormDateFragment formDateFragment = new FormDateFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            formDateFragment.setArguments(bundle);
            return formDateFragment;
        }
    }

    public FormDateFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Bundle arguments = getArguments();
        FormBaseBean formBaseBean = (FormBaseBean) GsonUtils.fromJson(arguments != null ? arguments.getString("data") : null, FormBaseBean.class);
        this.formItemData = formBaseBean;
        if (formBaseBean != null) {
            ((ViewCollectFormDateBinding) getBinding()).tvViewCollectFormDateName.setText(TransUtils.INSTANCE.transIntToString(formBaseBean.getSortNum()) + '.' + formBaseBean.getTitle());
            if (!formBaseBean.getProps().getRequired()) {
                TextView textView = ((ViewCollectFormDateBinding) getBinding()).tvViewCollectFormDateRequired;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormDateRequired");
                SimpleUtilsKt.remove(textView);
            }
            initTimeSelectView(TransUtils.INSTANCE.getShowTimeTypeArray(formBaseBean.getProps().getFormat()), TransUtils.INSTANCE.getShowTimeToRightFormat(formBaseBean.getProps().getFormat()));
            String value = formBaseBean.getValue();
            if (!(value == null || value.length() == 0)) {
                ((ViewCollectFormDateBinding) getBinding()).tvViewCollectFormDate.setText(formBaseBean.getValue());
                ImageView imageView = ((ViewCollectFormDateBinding) getBinding()).ivViewCollectFormDateDel;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormDateDel");
                SimpleUtilsKt.show(imageView);
                ((ViewCollectFormDateBinding) getBinding()).ivViewCollectFormDate.setImageResource(R.mipmap.icon_date_select);
            }
        }
        ((ViewCollectFormDateBinding) getBinding()).clViewCollectFormDate.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateFragment$jbDdlY3fp0GDVySDMKi89OSnNnU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormDateFragment.initView$lambda$1(this.f$0, view);
            }
        });
        ((ViewCollectFormDateBinding) getBinding()).ivViewCollectFormDateDel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateFragment$Sb-lXFA7Q0FKTee2FOQEme7D5yA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormDateFragment.initView$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FormDateFragment this$0, View view) {
        TimePickerView timePickerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.selectTime != null || (timePickerView = this$0.timeView) == null) {
            return;
        }
        timePickerView.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(FormDateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectTime = null;
        ImageView imageView = ((ViewCollectFormDateBinding) this$0.getBinding()).ivViewCollectFormDateDel;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormDateDel");
        SimpleUtilsKt.remove(imageView);
        ((ViewCollectFormDateBinding) this$0.getBinding()).ivViewCollectFormDate.setImageResource(R.mipmap.icon_date_not_select);
        ((ViewCollectFormDateBinding) this$0.getBinding()).tvViewCollectFormDate.setText("");
    }

    static /* synthetic */ void initTimeSelectView$default(FormDateFragment formDateFragment, boolean[] zArr, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "yyyy-MM-dd HH:mm";
        }
        formDateFragment.initTimeSelectView(zArr, str);
    }

    private final void initTimeSelectView(boolean[] type, final String timeFormat) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.set(LunarCalendar.MIN_YEAR, 0, 1);
        calendar2.set(2119, 11, 31);
        this.timeView = new TimePickerBuilder(requireContext(), new OnTimeSelectListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateFragment$BNdPHjphfMg4PrYS6BbSk3PHVUM
            @Override // com.bigkoo.pickerview.listener.OnTimeSelectListener
            public final void onTimeSelect(Date date, View view) {
                FormDateFragment.initTimeSelectView$lambda$4(this.f$0, timeFormat, date, view);
            }
        }).setDate(Calendar.getInstance()).setType(type).setRangDate(calendar, calendar2).setTextColorCenter(SimpleUtilsKt.asColor(R.color.purple2)).setDividerColor(SimpleUtilsKt.asColor(R.color.purple2)).setLabel("年", "月", "日", "时", "分", "秒").setLayoutRes(R.layout.time_select, new CustomListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateFragment$BFVyqB9pbvsOhGpoG6BibtyHJek
            @Override // com.bigkoo.pickerview.listener.CustomListener
            public final void customLayout(View view) {
                FormDateFragment.initTimeSelectView$lambda$7(this.f$0, view);
            }
        }).isCenterLabel(false).isDialog(true).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initTimeSelectView$lambda$4(FormDateFragment this$0, String timeFormat, Date date, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(timeFormat, "$timeFormat");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this$0.selectTime = calendar;
        ((ViewCollectFormDateBinding) this$0.getBinding()).tvViewCollectFormDate.setText(DateUtils.getDate(date, timeFormat));
        ImageView imageView = ((ViewCollectFormDateBinding) this$0.getBinding()).ivViewCollectFormDateDel;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormDateDel");
        SimpleUtilsKt.show(imageView);
        ((ViewCollectFormDateBinding) this$0.getBinding()).ivViewCollectFormDate.setImageResource(R.mipmap.icon_date_select);
        FormBaseBean formBaseBean = this$0.formItemData;
        if (formBaseBean != null && formBaseBean.getProps().getRequired()) {
            FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
            formVerifyBean.setStatus(true);
            FormBaseBean formBaseBean2 = this$0.formItemData;
            Intrinsics.checkNotNull(formBaseBean2);
            formVerifyBean.setSort(formBaseBean2.getSort());
            formVerifyBean.setDataValue(((ViewCollectFormDateBinding) this$0.getBinding()).tvViewCollectFormDate.getText().toString());
            EventBus.getDefault().post(formVerifyBean);
        }
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$7(final FormDateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Button button = (Button) view.findViewById(R.id.btnCancel);
        Button button2 = (Button) view.findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateFragment$iDynDiXS9_lXcE9-R4wasHkziAg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FormDateFragment.initTimeSelectView$lambda$7$lambda$5(this.f$0, view2);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormDateFragment$v9GNg-z5fZRe5j88mP-AeQd0VLg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FormDateFragment.initTimeSelectView$lambda$7$lambda$6(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$7$lambda$5(FormDateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$7$lambda$6(FormDateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        if (timePickerView != null) {
            timePickerView.returnData();
        }
    }

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
            CharSequence text = ((ViewCollectFormDateBinding) getBinding()).tvViewCollectFormDate.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.tvViewCollectFormDate.text");
            if (text.length() == 0) {
                formVerifyBean.setStatus(false);
                formVerifyBean.setErrorMessage("日期必填项未填写");
                return formVerifyBean;
            }
        }
        FormBaseBean formBaseBean2 = this.formItemData;
        Intrinsics.checkNotNull(formBaseBean2);
        formVerifyBean.setSort(formBaseBean2.getSort());
        formVerifyBean.setDataValue(((ViewCollectFormDateBinding) getBinding()).tvViewCollectFormDate.getText().toString());
        return formVerifyBean;
    }
}
