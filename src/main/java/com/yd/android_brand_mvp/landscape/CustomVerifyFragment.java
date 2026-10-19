package com.yd.android_brand_mvp.landscape;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.activity.YDWebViewActivity;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.databinding.VertifyFragmentBinding;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomVerifyFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/CustomVerifyFragment;", "Lcom/yd/android_brand_mvp/base/BaseFragment;", "()V", "TITLE", "", "URL", "binding", "Lcom/yd/android_brand_mvp/databinding/VertifyFragmentBinding;", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomVerifyFragment extends BaseFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS = "path";
    private static final String PARAMS2 = "type";
    private static final String PARAMS3 = "title";
    private static final String PARAMS4 = "imgUrl";
    private static final String PARAMS5 = "time";
    private VertifyFragmentBinding binding;
    private final String URL = "url";
    private final String TITLE = "title";

    /* JADX INFO: compiled from: CustomVerifyFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/CustomVerifyFragment$Companion;", "", "()V", "PARAMS", "", "PARAMS2", "PARAMS3", "PARAMS4", "PARAMS5", "newInstance", "Landroidx/fragment/app/Fragment;", "url", "type", "title", "imgUrl", "time", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Landroidx/fragment/app/Fragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String url, String type, String title, String imgUrl, Integer time) {
            CustomVerifyFragment customVerifyFragment = new CustomVerifyFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CustomVerifyFragment.PARAMS, url);
            bundle.putString(CustomVerifyFragment.PARAMS2, type);
            bundle.putString(CustomVerifyFragment.PARAMS3, title);
            bundle.putString(CustomVerifyFragment.PARAMS4, imgUrl);
            bundle.putInt(CustomVerifyFragment.PARAMS5, time != null ? time.intValue() : -1);
            customVerifyFragment.setArguments(bundle);
            return customVerifyFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VertifyFragmentBinding vertifyFragmentBindingInflate = VertifyFragmentBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(vertifyFragmentBindingInflate, "inflate(layoutInflater)");
        this.binding = vertifyFragmentBindingInflate;
        if (vertifyFragmentBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vertifyFragmentBindingInflate = null;
        }
        FrameLayout root = vertifyFragmentBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(PARAMS3, "");
            arguments.getString(PARAMS2, "");
            VertifyFragmentBinding vertifyFragmentBinding = this.binding;
            if (vertifyFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vertifyFragmentBinding = null;
            }
            vertifyFragmentBinding.top.title.setText(string);
        }
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        VertifyFragmentBinding vertifyFragmentBinding = null;
        String string = arguments != null ? arguments.getString(PARAMS4, "") : null;
        FragmentActivity activity = getActivity();
        VertifyFragmentBinding vertifyFragmentBinding2 = this.binding;
        if (vertifyFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vertifyFragmentBinding2 = null;
        }
        GlideUtil.loadPlaceholderImage(activity, string, vertifyFragmentBinding2.imageview);
        VertifyFragmentBinding vertifyFragmentBinding3 = this.binding;
        if (vertifyFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vertifyFragmentBinding = vertifyFragmentBinding3;
        }
        vertifyFragmentBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$CustomVerifyFragment$k7yMExSUokpwvzlcKVCFb4WVEcs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomVerifyFragment.initView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(CustomVerifyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle arguments = this$0.getArguments();
        String string = arguments != null ? arguments.getString(PARAMS, "") : null;
        Bundle arguments2 = this$0.getArguments();
        String string2 = arguments2 != null ? arguments2.getString(PARAMS3, "") : null;
        Bundle arguments3 = this$0.getArguments();
        Integer numValueOf = arguments3 != null ? Integer.valueOf(arguments3.getInt(PARAMS5, -1)) : null;
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) YDWebViewActivity.class);
        if (numValueOf != null && numValueOf.intValue() > 0) {
            intent.putExtra(PARAMS5, numValueOf.intValue());
        }
        intent.putExtra(this$0.URL, string);
        intent.putExtra(this$0.TITLE, string2);
        this$0.goPermissionsActivity(intent);
    }
}
