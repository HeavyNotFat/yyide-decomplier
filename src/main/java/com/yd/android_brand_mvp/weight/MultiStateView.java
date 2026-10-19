package com.yd.android_brand_mvp.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.yd.android_brand_mvp.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class MultiStateView extends FrameLayout {
    public static final int VIEW_STATE_CONTENT = 0;
    public static final int VIEW_STATE_EMPTY = 2;
    public static final int VIEW_STATE_ERROR = 1;
    public static final int VIEW_STATE_LOADING = 3;
    private View mContentView;
    private View mEmptyView;
    private View mErrorView;
    private LayoutInflater mInflater;
    private View mLoadingView;
    private int mViewState;
    public OnErrorClicklistener onErrorClicklistener;

    public interface OnErrorClicklistener {
        void reload();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewState {
    }

    public void reload() {
    }

    public MultiStateView(Context context) {
        this(context, null);
    }

    public MultiStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewState = 0;
        init(attributeSet);
    }

    public MultiStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mViewState = 0;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.mInflater = LayoutInflater.from(getContext());
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MultiStateView);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        if (resourceId > -1) {
            View viewInflate = this.mInflater.inflate(resourceId, (ViewGroup) this, false);
            this.mLoadingView = viewInflate;
            addView(viewInflate, viewInflate.getLayoutParams());
        }
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        if (resourceId2 > -1) {
            View viewInflate2 = this.mInflater.inflate(resourceId2, (ViewGroup) this, false);
            this.mEmptyView = viewInflate2;
            addView(viewInflate2, viewInflate2.getLayoutParams());
        }
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        if (resourceId3 > -1) {
            View viewInflate3 = this.mInflater.inflate(resourceId3, (ViewGroup) this, false);
            this.mErrorView = viewInflate3;
            addView(viewInflate3, viewInflate3.getLayoutParams());
            this.mErrorView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.weight.MultiStateView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MultiStateView.this.onErrorClicklistener != null) {
                        MultiStateView.this.onErrorClicklistener.reload();
                    }
                }
            });
        }
        int i = typedArrayObtainStyledAttributes.getInt(3, 0);
        if (i == 0) {
            this.mViewState = 0;
        } else if (i == 1) {
            this.mViewState = 1;
        } else if (i == 2) {
            this.mViewState = 2;
        } else if (i == 3) {
            this.mViewState = 3;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setOnErrorClicklistener(OnErrorClicklistener onErrorClicklistener) {
        this.onErrorClicklistener = onErrorClicklistener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mContentView == null) {
            throw new IllegalArgumentException("Content view is not defined");
        }
        setView();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (isValidContentView(view)) {
            this.mContentView = view;
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (isValidContentView(view)) {
            this.mContentView = view;
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (isValidContentView(view)) {
            this.mContentView = view;
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (isValidContentView(view)) {
            this.mContentView = view;
        }
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        if (isValidContentView(view)) {
            this.mContentView = view;
        }
        super.addView(view, i, i2);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (isValidContentView(view)) {
            this.mContentView = view;
        }
        return super.addViewInLayout(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (isValidContentView(view)) {
            this.mContentView = view;
        }
        return super.addViewInLayout(view, i, layoutParams, z);
    }

    public View getView(int i) {
        if (i == 0) {
            return this.mContentView;
        }
        if (i == 1) {
            return this.mErrorView;
        }
        if (i == 2) {
            return this.mEmptyView;
        }
        if (i != 3) {
            return null;
        }
        return this.mLoadingView;
    }

    public int getViewState() {
        return this.mViewState;
    }

    public void setViewState(int i) {
        if (i != this.mViewState) {
            this.mViewState = i;
            setView();
        }
    }

    private void setView() {
        int i = this.mViewState;
        if (i == 1) {
            View view = this.mErrorView;
            if (view == null) {
                throw new NullPointerException("Error View");
            }
            view.setVisibility(0);
            View view2 = this.mLoadingView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.mContentView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = this.mEmptyView;
            if (view4 != null) {
                view4.setVisibility(8);
                return;
            }
            return;
        }
        if (i == 2) {
            View view5 = this.mEmptyView;
            if (view5 == null) {
                throw new NullPointerException("Empty View");
            }
            view5.setVisibility(0);
            View view6 = this.mLoadingView;
            if (view6 != null) {
                view6.setVisibility(8);
            }
            View view7 = this.mErrorView;
            if (view7 != null) {
                view7.setVisibility(8);
            }
            View view8 = this.mContentView;
            if (view8 != null) {
                view8.setVisibility(8);
                return;
            }
            return;
        }
        if (i == 3) {
            View view9 = this.mLoadingView;
            if (view9 == null) {
                throw new NullPointerException("Loading View");
            }
            view9.setVisibility(0);
            View view10 = this.mContentView;
            if (view10 != null) {
                view10.setVisibility(8);
            }
            View view11 = this.mErrorView;
            if (view11 != null) {
                view11.setVisibility(8);
            }
            View view12 = this.mEmptyView;
            if (view12 != null) {
                view12.setVisibility(8);
                return;
            }
            return;
        }
        View view13 = this.mContentView;
        if (view13 == null) {
            throw new NullPointerException("Content View");
        }
        view13.setVisibility(0);
        View view14 = this.mLoadingView;
        if (view14 != null) {
            view14.setVisibility(8);
        }
        View view15 = this.mErrorView;
        if (view15 != null) {
            view15.setVisibility(8);
        }
        View view16 = this.mEmptyView;
        if (view16 != null) {
            view16.setVisibility(8);
        }
    }

    private boolean isValidContentView(View view) {
        View view2 = this.mContentView;
        return ((view2 != null && view2 != view) || view == this.mLoadingView || view == this.mErrorView || view == this.mEmptyView) ? false : true;
    }

    public void setViewForState(View view, int i, boolean z) {
        if (i == 0) {
            View view2 = this.mContentView;
            if (view2 != null) {
                removeView(view2);
            }
            this.mContentView = view;
            addView(view);
        } else if (i == 1) {
            View view3 = this.mErrorView;
            if (view3 != null) {
                removeView(view3);
            }
            this.mErrorView = view;
            addView(view);
        } else if (i == 2) {
            View view4 = this.mEmptyView;
            if (view4 != null) {
                removeView(view4);
            }
            this.mEmptyView = view;
            addView(view);
        } else if (i == 3) {
            View view5 = this.mLoadingView;
            if (view5 != null) {
                removeView(view5);
            }
            this.mLoadingView = view;
            addView(view);
        }
        if (z) {
            setViewState(i);
        }
    }

    public void setViewForState(View view, int i) {
        setViewForState(view, i, false);
    }

    public void setViewForState(int i, int i2, boolean z) {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getContext());
        }
        setViewForState(this.mInflater.inflate(i, (ViewGroup) this, false), i2, z);
    }

    public void setViewForState(int i, int i2) {
        setViewForState(i, i2, false);
    }
}
