package com.yd.android_brand_mvp.landscape.university.music;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentUniversityMusicBinding;
import com.yd.android_brand_mvp.landscape.ClassScheduleFragment2_6L;
import com.yd.android_brand_mvp.landscape.SiteInfoFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UniversityMusicFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/music/UniversityMusicFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentUniversityMusicBinding;", "()V", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversityMusicFragment extends KTBaseFragment<FragmentUniversityMusicBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = "layoutTag";

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.music.UniversityMusicFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityMusicFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentUniversityMusicBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentUniversityMusicBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentUniversityMusicBinding;", 0);
        }

        public final FragmentUniversityMusicBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentUniversityMusicBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentUniversityMusicBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UniversityMusicFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: UniversityMusicFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/music/UniversityMusicFragment$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/university/music/UniversityMusicFragment;", "layoutTag", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return UniversityMusicFragment.LAYOUT_TAG;
        }

        public final UniversityMusicFragment newInstance(String layoutTag) {
            Intrinsics.checkNotNullParameter(layoutTag, "layoutTag");
            UniversityMusicFragment universityMusicFragment = new UniversityMusicFragment();
            Bundle bundle = new Bundle();
            bundle.putString(UniversityMusicFragment.INSTANCE.getLAYOUT_TAG(), layoutTag);
            universityMusicFragment.setArguments(bundle);
            return universityMusicFragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(LAYOUT_TAG) : null;
        if (string == null) {
            string = "";
        }
        getChildFragmentManager().beginTransaction().add(getBinding().containerView1.getId(), UniversityMusicTableFragment.INSTANCE.newInstance()).add(getBinding().containerView2.getId(), new ClassScheduleFragment2_6L()).add(getBinding().containerView3.getId(), SiteInfoFragment.INSTANCE.newInstance(string)).commit();
    }
}
