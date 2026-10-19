package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentTimeclock4Binding;
import com.yd.android_brand_mvp.databinding.FragmentTimeclockBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeClockFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/TimeClockFragment;", "Lcom/yd/android_brand_mvp/base/BaseFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimeClockFragment extends BaseFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE = "type";

    /* JADX INFO: compiled from: TimeClockFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/TimeClockFragment$Companion;", "", "()V", "TYPE", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/TimeClockFragment;", RemoteMessageConst.Notification.TAG, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TimeClockFragment newInstance(String tag) {
            TimeClockFragment timeClockFragment = new TimeClockFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", tag);
            timeClockFragment.setArguments(bundle);
            return timeClockFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string != null && string.hashCode() == -1223501102 && string.equals("hbsj23")) {
            ConstraintLayout root = FragmentTimeclock4Binding.inflate(getLayoutInflater()).getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "{\n                Fragme…later).root\n            }");
            return root;
        }
        FrameLayout root2 = FragmentTimeclockBinding.inflate(getLayoutInflater()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "{\n                Fragme…later).root\n            }");
        return root2;
    }
}
