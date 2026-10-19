package com.yd.android_brand_mvp.activity.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.databinding.FragmentClassModeBinding;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.utils.SpData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassModeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/ClassModeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "data", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO;", "viewBinding", "Lcom/yd/android_brand_mvp/databinding/FragmentClassModeBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassModeFragment extends Fragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private KBRsp2.DataDTO.TimetableListDTO data;
    private FragmentClassModeBinding viewBinding;

    @JvmStatic
    public static final ClassModeFragment newInstance(KBRsp2.DataDTO.TimetableListDTO timetableListDTO) {
        return INSTANCE.newInstance(timetableListDTO);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.data = (KBRsp2.DataDTO.TimetableListDTO) arguments.getSerializable("data");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClassModeBinding fragmentClassModeBindingInflate = FragmentClassModeBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(fragmentClassModeBindingInflate, "inflate(layoutInflater)");
        this.viewBinding = fragmentClassModeBindingInflate;
        if (fragmentClassModeBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentClassModeBindingInflate = null;
        }
        ConstraintLayout root = fragmentClassModeBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String strSubstring;
        List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> teacherList;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        KBRsp2.DataDTO.TimetableListDTO timetableListDTO = this.data;
        if (timetableListDTO != null) {
            if (timetableListDTO.teacherList == null || (teacherList = timetableListDTO.teacherList) == null) {
                strSubstring = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(teacherList, "teacherList");
                Iterator<T> it2 = teacherList.iterator();
                strSubstring = "";
                while (it2.hasNext()) {
                    strSubstring = ((KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO) it2.next()).name + ',';
                }
            }
            if (!TextUtils.isEmpty(strSubstring)) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            NewClassInfoRsp newClassInfoRsp = SpData.getNewClassInfoRsp();
            FragmentClassModeBinding fragmentClassModeBinding = null;
            if ((newClassInfoRsp != null ? newClassInfoRsp.data : null) != null) {
                FragmentClassModeBinding fragmentClassModeBinding2 = this.viewBinding;
                if (fragmentClassModeBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    fragmentClassModeBinding2 = null;
                }
                TextView textView = fragmentClassModeBinding2.tvClassName;
                String str = newClassInfoRsp.data.classesName;
                textView.setText(str != null ? str : "");
            }
            FragmentClassModeBinding fragmentClassModeBinding3 = this.viewBinding;
            if (fragmentClassModeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentClassModeBinding3 = null;
            }
            fragmentClassModeBinding3.tvClassTime.setText(timetableListDTO.subjectName + (char) 65288 + timetableListDTO.startTime + '-' + timetableListDTO.endTime + (char) 65289);
            FragmentClassModeBinding fragmentClassModeBinding4 = this.viewBinding;
            if (fragmentClassModeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                fragmentClassModeBinding = fragmentClassModeBinding4;
            }
            fragmentClassModeBinding.tvTeacherName.setText(strSubstring);
        }
    }

    /* JADX INFO: compiled from: ClassModeFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/ClassModeFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/fragment/ClassModeFragment;", "data", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ClassModeFragment newInstance(KBRsp2.DataDTO.TimetableListDTO data) {
            ClassModeFragment classModeFragment = new ClassModeFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", data);
            classModeFragment.setArguments(bundle);
            return classModeFragment;
        }
    }
}
