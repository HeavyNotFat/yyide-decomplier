package com.yd.android_brand_mvp.landscape;

import android.R;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.vise.utils.handler.HandlerUtil;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentPingNetworkBinding;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.ys.rkapi.MyManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: PingNetworkFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/PingNetworkFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentPingNetworkBinding;", "()V", "lines", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mAdapter", "Lcom/yd/android_brand_mvp/landscape/PingNetworkFragment$MyAdapter;", "addData", "", "data", "initView", "isValidIpAddress", "", "ip", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "ping", "readData", "Ljava/lang/Thread;", "inputStream", "Ljava/io/InputStream;", "refreshListView", "Companion", "MyAdapter", "MyViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PingNetworkFragment extends KTBaseFragment<FragmentPingNetworkBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ArrayList<String> lines;
    private MyAdapter mAdapter;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.PingNetworkFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: PingNetworkFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentPingNetworkBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentPingNetworkBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentPingNetworkBinding;", 0);
        }

        public final FragmentPingNetworkBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentPingNetworkBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentPingNetworkBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public PingNetworkFragment() {
        super(AnonymousClass1.INSTANCE);
        this.lines = new ArrayList<>();
    }

    /* JADX INFO: compiled from: PingNetworkFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/PingNetworkFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/PingNetworkFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PingNetworkFragment newInstance() {
            return new PingNetworkFragment();
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        getBinding().etIp.setText(MyManager.getInstance(this.mActivity).getDhcpIpAddress());
    }

    private final void initView() {
        TextView textView = getBinding().tvTesting;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTesting");
        SimpleUtilsKt.remove(textView);
        LinearLayoutCompat linearLayoutCompat = getBinding().llPingResult;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "binding.llPingResult");
        SimpleUtilsKt.remove(linearLayoutCompat);
        this.mAdapter = new MyAdapter();
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView = getBinding().recyclerView;
        MyAdapter myAdapter = this.mAdapter;
        if (myAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            myAdapter = null;
        }
        recyclerView.setAdapter(myAdapter);
        getBinding().tvPing.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$PingNetworkFragment$t7YIuh68xk_slu15o1vhsHYrB0U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PingNetworkFragment.initView$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(final PingNetworkFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadsKt.thread((31 & 1) != 0, (31 & 2) != 0 ? false : false, (31 & 4) != 0 ? null : null, (31 & 8) != 0 ? null : null, (31 & 16) != 0 ? -1 : 0, new Function0<Unit>() { // from class: com.yd.android_brand_mvp.landscape.PingNetworkFragment$initView$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() throws InterruptedException, IOException {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() throws InterruptedException, IOException {
                this.this$0.ping();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ping() throws InterruptedException, IOException {
        HandlerUtil.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$PingNetworkFragment$y9DWiGySWplG7ZKKksYGB439Uu4
            @Override // java.lang.Runnable
            public final void run() {
                PingNetworkFragment.ping$lambda$1(this.f$0);
            }
        });
        Editable text = getBinding().etIp.getText();
        Intrinsics.checkNotNullExpressionValue(text, "binding.etIp.text");
        String string = StringsKt.trim(text).toString();
        if (StringsKt.isBlank(string)) {
            HandlerUtil.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$PingNetworkFragment$gMG_eTb6Fz1dzHf4ksw505nIt-8
                @Override // java.lang.Runnable
                public final void run() {
                    PingNetworkFragment.ping$lambda$2(this.f$0);
                }
            });
            return;
        }
        HandlerUtil.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$PingNetworkFragment$bLXAamWxbOuyeVZKfI79nPRVOig
            @Override // java.lang.Runnable
            public final void run() {
                PingNetworkFragment.ping$lambda$3(this.f$0);
            }
        });
        Process processExec = Runtime.getRuntime().exec("ping -s 1016 -w 5 " + string);
        Thread data = readData(processExec.getInputStream());
        Thread data2 = readData(processExec.getErrorStream());
        data.join();
        data2.join();
        HandlerUtil.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$PingNetworkFragment$S4dAJGdNYCtTSVzk4WhmI10K6j8
            @Override // java.lang.Runnable
            public final void run() {
                PingNetworkFragment.ping$lambda$4(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ping$lambda$1(PingNetworkFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.getBinding().tvTesting;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTesting");
        SimpleUtilsKt.show(textView);
        LinearLayoutCompat linearLayoutCompat = this$0.getBinding().llPingResult;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "binding.llPingResult");
        SimpleUtilsKt.remove(linearLayoutCompat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ping$lambda$2(PingNetworkFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.requireContext(), "请输入IP", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ping$lambda$3(PingNetworkFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().tvPing.setEnabled(false);
        this$0.lines.clear();
        this$0.addData("Ping开始");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ping$lambda$4(PingNetworkFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            String str = this$0.lines.get(this$0.lines.size() - 2);
            Intrinsics.checkNotNullExpressionValue(str, "lines[lines.size - 2]");
            String str2 = this$0.lines.get(this$0.lines.size() - 1);
            Intrinsics.checkNotNullExpressionValue(str2, "lines[lines.size - 1]");
            String str3 = str2;
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null);
            TextView textView = this$0.getBinding().tvTesting;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTesting");
            SimpleUtilsKt.remove(textView);
            LinearLayoutCompat linearLayoutCompat = this$0.getBinding().llPingResult;
            Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "binding.llPingResult");
            SimpleUtilsKt.show(linearLayoutCompat);
            if (listSplit$default.size() > 2) {
                String strRemoveSuffix = StringsKt.removeSuffix((String) listSplit$default.get(0), (CharSequence) "packets transmitted");
                String strRemoveSuffix2 = StringsKt.removeSuffix((String) listSplit$default.get(1), (CharSequence) "received");
                String strRemoveSuffix3 = StringsKt.removeSuffix((String) listSplit$default.get(2), (CharSequence) "% packet loss");
                this$0.addData("发送" + strRemoveSuffix + " , 接收" + strRemoveSuffix + " ， " + strRemoveSuffix3 + " 丢包率");
                TextView textView2 = this$0.getBinding().tvPingData;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                StringBuilder sb = new StringBuilder();
                sb.append(strRemoveSuffix3);
                sb.append('%');
                String str4 = String.format("数据包：已发送=%s，已接收=%s，丢失-%s（%s丢失）", Arrays.copyOf(new Object[]{strRemoveSuffix, strRemoveSuffix2, strRemoveSuffix3, sb.toString()}, 4));
                Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
                textView2.setText(str4);
            }
            List listSplit$default2 = StringsKt.split$default((CharSequence) StringsKt.removeSuffix(StringsKt.removePrefix(str3, (CharSequence) "rtt min/avg/max/mdev = "), (CharSequence) " ms"), new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, false, 0, 6, (Object) null);
            if (listSplit$default2.size() > 2) {
                this$0.addData("最短" + ((String) listSplit$default2.get(0)) + "ms , 最长" + ((String) listSplit$default2.get(2)) + "ms ， 平均" + ((String) listSplit$default2.get(1)) + "ms ");
                TextView textView3 = this$0.getBinding().tvPingStatus;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str5 = String.format("往返行程的估计时间（以毫秒为单位）：最短=%sms，最长=%sms，平均=%sms", Arrays.copyOf(new Object[]{listSplit$default2.get(0), listSplit$default2.get(2), listSplit$default2.get(1)}, 3));
                Intrinsics.checkNotNullExpressionValue(str5, "format(format, *args)");
                textView3.setText(str5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this$0.addData("Ping结束");
        this$0.getBinding().tvPing.setEnabled(true);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.PingNetworkFragment$readData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PingNetworkFragment.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C03851 extends Lambda implements Function0<Unit> {
        final /* synthetic */ InputStream $inputStream;
        final /* synthetic */ PingNetworkFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03851(InputStream inputStream, PingNetworkFragment pingNetworkFragment) {
            super(0);
            this.$inputStream = inputStream;
            this.this$0 = pingNetworkFragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.$inputStream));
                final PingNetworkFragment pingNetworkFragment = this.this$0;
                try {
                    BufferedReader bufferedReader2 = bufferedReader;
                    while (true) {
                        final String line = bufferedReader2.readLine();
                        if (line != null) {
                            Intrinsics.checkNotNull(line);
                            HandlerUtil.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$PingNetworkFragment$readData$1$PClcqh13bSS7gx0IiFdYRni43F4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    PingNetworkFragment.C03851.invoke$lambda$2$lambda$1(pingNetworkFragment, line);
                                }
                            });
                        } else {
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(bufferedReader, null);
                            return;
                        }
                        final PingNetworkFragment pingNetworkFragment2 = this.this$0;
                        HandlerUtil.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$PingNetworkFragment$readData$1$h7T09ygd8W1Y_Cew09Hd-NXU69I
                            @Override // java.lang.Runnable
                            public final void run() {
                                PingNetworkFragment.C03851.invoke$lambda$3(pingNetworkFragment2, e);
                            }
                        });
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                final PingNetworkFragment pingNetworkFragment3 = this.this$0;
                HandlerUtil.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$PingNetworkFragment$readData$1$h7T09ygd8W1Y_Cew09Hd-NXU69I
                    @Override // java.lang.Runnable
                    public final void run() {
                        PingNetworkFragment.C03851.invoke$lambda$3(pingNetworkFragment3, e);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(PingNetworkFragment this$0, String lineTemp) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(lineTemp, "$lineTemp");
            this$0.addData(lineTemp);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3(PingNetworkFragment this$0, Exception e) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(e, "$e");
            this$0.addData("出现异常：" + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    private final Thread readData(InputStream inputStream) {
        return ThreadsKt.thread((31 & 1) != 0, (31 & 2) != 0 ? false : false, (31 & 4) != 0 ? null : null, (31 & 8) != 0 ? null : null, (31 & 16) != 0 ? -1 : 0, new C03851(inputStream, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addData(String data) {
        this.lines.add(data);
        refreshListView();
    }

    private final void refreshListView() {
        MyAdapter myAdapter = this.mAdapter;
        if (myAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            myAdapter = null;
        }
        myAdapter.notifyDataSetChanged();
        getBinding().recyclerView.scrollToPosition(this.lines.size() - 1);
    }

    private final boolean isValidIpAddress(String ip) {
        String str = ip;
        if (str == null || StringsKt.isBlank(str)) {
            return false;
        }
        return Pattern.compile("(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})(\\.(2(5[0-5]{1}|[0-4]\\d{1})|[0-1]?\\d{1,2})){3}").matcher(str).matches();
    }

    /* JADX INFO: compiled from: PingNetworkFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/PingNetworkFragment$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/yd/android_brand_mvp/landscape/PingNetworkFragment;Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        final /* synthetic */ PingNetworkFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyViewHolder(PingNetworkFragment pingNetworkFragment, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = pingNetworkFragment;
            View viewFindViewById = itemView.findViewById(R.id.text1);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.textView = (TextView) viewFindViewById;
        }

        public final TextView getTextView() {
            return this.textView;
        }

        public final void setTextView(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.textView = textView;
        }
    }

    /* JADX INFO: compiled from: PingNetworkFragment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/PingNetworkFragment$MyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yd/android_brand_mvp/landscape/PingNetworkFragment$MyViewHolder;", "Lcom/yd/android_brand_mvp/landscape/PingNetworkFragment;", "(Lcom/yd/android_brand_mvp/landscape/PingNetworkFragment;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        public MyAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            PingNetworkFragment pingNetworkFragment = PingNetworkFragment.this;
            View viewInflate = View.inflate(parent.getContext(), R.layout.simple_list_item_1, null);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(parent.context, …simple_list_item_1, null)");
            return new MyViewHolder(pingNetworkFragment, viewInflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.getTextView().setText((CharSequence) PingNetworkFragment.this.lines.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return PingNetworkFragment.this.lines.size();
        }
    }
}
