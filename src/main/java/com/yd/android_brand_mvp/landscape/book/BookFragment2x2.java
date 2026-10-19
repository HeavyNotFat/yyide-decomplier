package com.yd.android_brand_mvp.landscape.book;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentBookBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BookFragment2x2.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/book/BookFragment2x2;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentBookBinding;", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BookFragment2x2 extends KTBaseFragment<FragmentBookBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final BookFragment2x2 newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.book.BookFragment2x2$1, reason: invalid class name */
    /* JADX INFO: compiled from: BookFragment2x2.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentBookBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentBookBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentBookBinding;", 0);
        }

        public final FragmentBookBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentBookBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentBookBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public BookFragment2x2() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: BookFragment2x2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/book/BookFragment2x2$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/book/BookFragment2x2;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BookFragment2x2 newInstance() {
            return new BookFragment2x2();
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().layout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.book.-$$Lambda$BookFragment2x2$we2RYNrW9yyhpLzygvlhXf8LTvg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BookFragment2x2.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(BookFragment2x2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BookActivity.Companion companion = BookActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext);
    }
}
