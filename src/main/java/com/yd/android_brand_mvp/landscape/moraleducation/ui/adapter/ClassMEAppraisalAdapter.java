package com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tim.uikit.utils.SoftKeyBoardUtil;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ClassMeAppraisalAdapterItemBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.SecondIndicatorModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.SubAppraisalScoreParamModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ClassMEAppraisalAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001b\u001cB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ClassMEAppraisalAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ClassMEAppraisalAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "mKey", "", "mClassMEIndicatorModels", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/SecondIndicatorModel;", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V", "mCurrentEditText", "Landroid/widget/EditText;", "getMCurrentEditText", "()Landroid/widget/EditText;", "setMCurrentEditText", "(Landroid/widget/EditText;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassMEAppraisalAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Map<Integer, SubAppraisalScoreParamModel>> mRecordScoreMap = new LinkedHashMap();
    private final List<SecondIndicatorModel> mClassMEIndicatorModels;
    private final Context mContext;
    private EditText mCurrentEditText;
    private final String mKey;

    public ClassMEAppraisalAdapter(Context mContext, String mKey, List<SecondIndicatorModel> mClassMEIndicatorModels) {
        Map<Integer, SubAppraisalScoreParamModel> linkedHashMap;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mKey, "mKey");
        Intrinsics.checkNotNullParameter(mClassMEIndicatorModels, "mClassMEIndicatorModels");
        this.mContext = mContext;
        this.mKey = mKey;
        this.mClassMEIndicatorModels = mClassMEIndicatorModels;
        int i = 0;
        for (Object obj : mClassMEIndicatorModels) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SecondIndicatorModel secondIndicatorModel = (SecondIndicatorModel) obj;
            if (mRecordScoreMap.get(this.mKey) == null) {
                linkedHashMap = new LinkedHashMap();
                mRecordScoreMap.put(this.mKey, linkedHashMap);
            } else {
                Map<Integer, SubAppraisalScoreParamModel> map = mRecordScoreMap.get(this.mKey);
                Intrinsics.checkNotNull(map);
                linkedHashMap = map;
            }
            if (linkedHashMap.get(Integer.valueOf(i)) == null) {
                linkedHashMap.put(Integer.valueOf(i), new SubAppraisalScoreParamModel(secondIndicatorModel.getMScoreStandardId(), secondIndicatorModel.getMInitializeScore(), ""));
            }
            i = i2;
        }
        Context context = this.mContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        View decorView = ((Activity) context).getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "mContext as Activity).window.decorView");
        SoftKeyBoardUtil.SoftKeyboardStateHelper(decorView, new SoftKeyBoardUtil.SoftKeyboardStateListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.ClassMEAppraisalAdapter.2
            @Override // com.tencent.qcloud.tim.uikit.utils.SoftKeyBoardUtil.SoftKeyboardStateListener
            public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            }

            @Override // com.tencent.qcloud.tim.uikit.utils.SoftKeyBoardUtil.SoftKeyboardStateListener
            public void onSoftKeyboardClosed() {
                EditText mCurrentEditText = ClassMEAppraisalAdapter.this.getMCurrentEditText();
                Object tag = mCurrentEditText != null ? mCurrentEditText.getTag() : null;
                if (tag instanceof View.OnFocusChangeListener) {
                    ((View.OnFocusChangeListener) tag).onFocusChange(ClassMEAppraisalAdapter.this.getMCurrentEditText(), false);
                }
            }
        });
    }

    public final EditText getMCurrentEditText() {
        return this.mCurrentEditText;
    }

    public final void setMCurrentEditText(EditText editText) {
        this.mCurrentEditText = editText;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ClassMeAppraisalAdapterItemBinding classMeAppraisalAdapterItemBindingInflate = ClassMeAppraisalAdapterItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(classMeAppraisalAdapterItemBindingInflate, "inflate(\n            Lay…          false\n        )");
        ConstraintLayout root = classMeAppraisalAdapterItemBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new ViewHolder(this, root);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, com.yd.android_brand_mvp.landscape.moraleducation.model.SubAppraisalScoreParamModel] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Map<Integer, SubAppraisalScoreParamModel> linkedHashMap;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final SecondIndicatorModel secondIndicatorModel = this.mClassMEIndicatorModels.get(position);
        if (mRecordScoreMap.get(this.mKey) == null) {
            linkedHashMap = new LinkedHashMap();
            mRecordScoreMap.put(this.mKey, linkedHashMap);
        } else {
            Map<Integer, SubAppraisalScoreParamModel> map = mRecordScoreMap.get(this.mKey);
            Intrinsics.checkNotNull(map);
            linkedHashMap = map;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = linkedHashMap.get(Integer.valueOf(position));
        if (objectRef.element == 0) {
            objectRef.element = new SubAppraisalScoreParamModel(secondIndicatorModel.getMScoreStandardId(), secondIndicatorModel.getMInitializeScore(), "");
            linkedHashMap.put(Integer.valueOf(position), objectRef.element);
        }
        holder.getMTvAppraisal().setText(secondIndicatorModel.getMScoreStandard());
        if (!TextUtils.isEmpty(((SubAppraisalScoreParamModel) objectRef.element).getScoreValue())) {
            holder.getMEtScore().setText(((SubAppraisalScoreParamModel) objectRef.element).getScoreValue());
        } else {
            holder.getMEtScore().setText(secondIndicatorModel.getMInitializeScore());
            ((SubAppraisalScoreParamModel) objectRef.element).setScoreValue(secondIndicatorModel.getMInitializeScore());
        }
        if (!TextUtils.isEmpty(((SubAppraisalScoreParamModel) objectRef.element).getRemark())) {
            holder.getMEtRemarks().setText(((SubAppraisalScoreParamModel) objectRef.element).getRemark());
        }
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.-$$Lambda$ClassMEAppraisalAdapter$_H-guBtCTyRpTQw5-QSOvEk5vGI
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ClassMEAppraisalAdapter.onBindViewHolder$lambda$1(this.f$0, objectRef, secondIndicatorModel, holder, view, z);
            }
        };
        holder.getMEtScore().setOnFocusChangeListener(onFocusChangeListener);
        holder.getMEtScore().setTag(onFocusChangeListener);
        holder.getMIvMinusScore().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.-$$Lambda$ClassMEAppraisalAdapter$fBOwh8bN2KtFRJvQQk6jKhTOwiY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClassMEAppraisalAdapter.onBindViewHolder$lambda$2(holder, secondIndicatorModel, objectRef, view);
            }
        });
        holder.getMIvAddScore().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.-$$Lambda$ClassMEAppraisalAdapter$IofXhmYJQG9QISS6pBtuHM09IEs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClassMEAppraisalAdapter.onBindViewHolder$lambda$3(holder, secondIndicatorModel, objectRef, view);
            }
        });
        holder.getMEtRemarks().addTextChangedListener(new TextWatcher() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.ClassMEAppraisalAdapter.onBindViewHolder.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    objectRef.element.setRemark(editable.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onBindViewHolder$lambda$1(ClassMEAppraisalAdapter this$0, Ref.ObjectRef subAppraisalScoreParamModel, SecondIndicatorModel classMEIndicatorModel, ViewHolder holder, View view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(subAppraisalScoreParamModel, "$subAppraisalScoreParamModel");
        Intrinsics.checkNotNullParameter(classMEIndicatorModel, "$classMEIndicatorModel");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) view;
        this$0.mCurrentEditText = editText;
        if (z) {
            return;
        }
        String string = editText.getText().toString();
        if ((string.length() == 0) || Intrinsics.areEqual(string, ".")) {
            ((SubAppraisalScoreParamModel) subAppraisalScoreParamModel.element).setScoreValue(classMEIndicatorModel.getMInitializeScore());
            holder.getMEtScore().setText(classMEIndicatorModel.getMInitializeScore());
            return;
        }
        float f = Float.parseFloat(string);
        if (f < Float.parseFloat(classMEIndicatorModel.getMScoreRangeMin())) {
            float f2 = Float.parseFloat(classMEIndicatorModel.getMScoreRangeMin());
            ((SubAppraisalScoreParamModel) subAppraisalScoreParamModel.element).setScoreValue(String.valueOf(f2));
            holder.getMEtScore().setText(String.valueOf(f2));
        } else if (f > Float.parseFloat(classMEIndicatorModel.getMScoreRangeMax())) {
            float f3 = Float.parseFloat(classMEIndicatorModel.getMScoreRangeMax());
            ((SubAppraisalScoreParamModel) subAppraisalScoreParamModel.element).setScoreValue(String.valueOf(f3));
            holder.getMEtScore().setText(String.valueOf(f3));
        } else {
            if (Intrinsics.areEqual(string, ((SubAppraisalScoreParamModel) subAppraisalScoreParamModel.element).getScoreValue())) {
                return;
            }
            float f4 = Float.parseFloat(string);
            float f5 = Float.parseFloat(classMEIndicatorModel.getMMinScoreUnit());
            float fRoundToInt = MathKt.roundToInt(f4 / f5) * f5;
            ((SubAppraisalScoreParamModel) subAppraisalScoreParamModel.element).setScoreValue(String.valueOf(fRoundToInt));
            holder.getMEtScore().setText(String.valueOf(fRoundToInt));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onBindViewHolder$lambda$2(ViewHolder holder, SecondIndicatorModel classMEIndicatorModel, Ref.ObjectRef subAppraisalScoreParamModel, View view) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(classMEIndicatorModel, "$classMEIndicatorModel");
        Intrinsics.checkNotNullParameter(subAppraisalScoreParamModel, "$subAppraisalScoreParamModel");
        float f = Float.parseFloat(holder.getMEtScore().getText().toString()) - Float.parseFloat(classMEIndicatorModel.getMMinScoreUnit());
        if (f < Float.parseFloat(classMEIndicatorModel.getMScoreRangeMin())) {
            f = Float.parseFloat(classMEIndicatorModel.getMScoreRangeMin());
        }
        holder.getMEtScore().setText(String.valueOf(f));
        ((SubAppraisalScoreParamModel) subAppraisalScoreParamModel.element).setScoreValue(String.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onBindViewHolder$lambda$3(ViewHolder holder, SecondIndicatorModel classMEIndicatorModel, Ref.ObjectRef subAppraisalScoreParamModel, View view) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(classMEIndicatorModel, "$classMEIndicatorModel");
        Intrinsics.checkNotNullParameter(subAppraisalScoreParamModel, "$subAppraisalScoreParamModel");
        float f = Float.parseFloat(holder.getMEtScore().getText().toString()) + Float.parseFloat(classMEIndicatorModel.getMMinScoreUnit());
        if (f > Float.parseFloat(classMEIndicatorModel.getMScoreRangeMax())) {
            f = Float.parseFloat(classMEIndicatorModel.getMScoreRangeMax());
        }
        holder.getMEtScore().setText(String.valueOf(f));
        ((SubAppraisalScoreParamModel) subAppraisalScoreParamModel.element).setScoreValue(String.valueOf(f));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mClassMEIndicatorModels.size();
    }

    /* JADX INFO: compiled from: ClassMEAppraisalAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ClassMEAppraisalAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ClassMEAppraisalAdapter;Landroid/view/View;)V", "mEtRemarks", "Landroid/widget/EditText;", "getMEtRemarks", "()Landroid/widget/EditText;", "setMEtRemarks", "(Landroid/widget/EditText;)V", "mEtScore", "getMEtScore", "setMEtScore", "mIvAddScore", "Landroid/widget/ImageView;", "getMIvAddScore", "()Landroid/widget/ImageView;", "setMIvAddScore", "(Landroid/widget/ImageView;)V", "mIvMinusScore", "getMIvMinusScore", "setMIvMinusScore", "mTvAppraisal", "Landroid/widget/TextView;", "getMTvAppraisal", "()Landroid/widget/TextView;", "setMTvAppraisal", "(Landroid/widget/TextView;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private EditText mEtRemarks;
        private EditText mEtScore;
        private ImageView mIvAddScore;
        private ImageView mIvMinusScore;
        private TextView mTvAppraisal;
        final /* synthetic */ ClassMEAppraisalAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ClassMEAppraisalAdapter classMEAppraisalAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = classMEAppraisalAdapter;
            View viewFindViewById = itemView.findViewById(R.id.tv_appraisal_title);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.tv_appraisal_title)");
            this.mTvAppraisal = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.iv_minus_score);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.iv_minus_score)");
            this.mIvMinusScore = (ImageView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.et_score);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "itemView.findViewById(R.id.et_score)");
            this.mEtScore = (EditText) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.iv_add_score);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "itemView.findViewById(R.id.iv_add_score)");
            this.mIvAddScore = (ImageView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.et_remarks);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "itemView.findViewById(R.id.et_remarks)");
            this.mEtRemarks = (EditText) viewFindViewById5;
        }

        public final TextView getMTvAppraisal() {
            return this.mTvAppraisal;
        }

        public final void setMTvAppraisal(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTvAppraisal = textView;
        }

        public final ImageView getMIvMinusScore() {
            return this.mIvMinusScore;
        }

        public final void setMIvMinusScore(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mIvMinusScore = imageView;
        }

        public final EditText getMEtScore() {
            return this.mEtScore;
        }

        public final void setMEtScore(EditText editText) {
            Intrinsics.checkNotNullParameter(editText, "<set-?>");
            this.mEtScore = editText;
        }

        public final ImageView getMIvAddScore() {
            return this.mIvAddScore;
        }

        public final void setMIvAddScore(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mIvAddScore = imageView;
        }

        public final EditText getMEtRemarks() {
            return this.mEtRemarks;
        }

        public final void setMEtRemarks(EditText editText) {
            Intrinsics.checkNotNullParameter(editText, "<set-?>");
            this.mEtRemarks = editText;
        }
    }

    /* JADX INFO: compiled from: ClassMEAppraisalAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R)\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/adapter/ClassMEAppraisalAdapter$Companion;", "", "()V", "mRecordScoreMap", "", "", "", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/SubAppraisalScoreParamModel;", "getMRecordScoreMap", "()Ljava/util/Map;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Map<Integer, SubAppraisalScoreParamModel>> getMRecordScoreMap() {
            return ClassMEAppraisalAdapter.mRecordScoreMap;
        }
    }
}
