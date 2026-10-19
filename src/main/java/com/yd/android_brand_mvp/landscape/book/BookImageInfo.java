package com.yd.android_brand_mvp.landscape.book;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseActivity;
import com.yd.android_brand_mvp.view.HackyViewPager2;
import com.yd.android_brand_mvp.view.LoadBitmapTask;
import com.yd.android_brand_mvp.view.PageFlipView;
import java.util.ArrayList;
import uk.co.senab.photoview.PhotoViewAttacher;

/* JADX INFO: loaded from: classes4.dex */
public class BookImageInfo extends BaseActivity implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private static final int FLING_MIN_DISTANCE = 10;
    private static final int FLING_MIN_VELOCITY = 0;
    PhotoAdapter3 adapter;

    @BindView(R.id.back)
    TextView back;

    @BindView(R.id.back_layout)
    FrameLayout back_layout;
    GetBookContentRsp.DataBean.BookBean bookBean;

    @BindView(R.id.layout)
    FrameLayout layout;

    @BindView(R.id.layout_ll)
    FrameLayout layoutLl;
    GestureDetector mGestureDetector;
    PageFlipView mPageFlipView;

    @BindView(R.id.page)
    FrameLayout page;

    @BindView(R.id.pager)
    HackyViewPager2 pager;

    @BindView(R.id.setting)
    TextView setting;

    @BindView(R.id.title)
    TextView title;
    FrameLayout toplayout;

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_book_image2);
        ButterKnife.bind(this);
        this.bookBean = (GetBookContentRsp.DataBean.BookBean) JSON.parseObject(getIntent().getStringExtra("ss"), GetBookContentRsp.DataBean.BookBean.class);
        this.layout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.book.BookImageInfo.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BookImageInfo.this.toplayout.getVisibility() == 0) {
                    BookImageInfo.this.toplayout.setVisibility(8);
                } else {
                    BookImageInfo.this.toplayout.setVisibility(0);
                }
            }
        });
        this.adapter = new PhotoAdapter3(new TapListener());
        this.toplayout = (FrameLayout) findViewById(R.id.toplayout);
        this.pager.setAdapter(this.adapter);
        this.pager.setNoScroll(true);
        PageFlipView pageFlipView = new PageFlipView(this);
        this.mPageFlipView = pageFlipView;
        this.page.addView(pageFlipView);
        this.mGestureDetector = new GestureDetector(this);
        this.title.setText(this.bookBean.bookName);
        if (this.bookBean.bookUploadType == 0) {
            setListData();
        }
        this.toplayout.setVisibility(8);
        this.layoutLl.setOnTouchListener(this);
        this.layoutLl.setLongClickable(true);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LoadBitmapTask.get(this).start();
        this.mPageFlipView.onResume();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mPageFlipView.onPause();
        LoadBitmapTask.get(this).stop();
    }

    void setListData() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < this.bookBean.bookTotalPage) {
            i++;
            arrayList.add(String.format(getResources().getString(R.string.bookStr), this.bookBean.bookFile, String.valueOf(i)));
        }
        this.adapter.notifyData(arrayList);
    }

    void setItemData(GetBookContentRsp.DataBean.BookBean.ChapterListBean chapterListBean) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < chapterListBean.chapterTotalPage) {
            i++;
            arrayList.add(String.format(getResources().getString(R.string.bookStr), chapterListBean.chapterFile, String.valueOf(i)));
        }
        this.adapter.notifyData(arrayList);
        this.pager.setCurrentItem(0);
    }

    @OnClick({R.id.back, R.id.setting, R.id.back_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131361948 */:
                finish();
                break;
            case R.id.back_layout /* 2131361949 */:
                finish();
                break;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    class TapListener implements View.OnClickListener {
        TapListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int count = BookImageInfo.this.adapter.getCount();
            int currentItem = BookImageInfo.this.pager.getCurrentItem();
            int id = view.getId();
            if (id != R.id.left_view) {
                if (id == R.id.right_view && currentItem < count) {
                    BookImageInfo.this.pager.setCurrentItem(currentItem + 1);
                    return;
                }
                return;
            }
            if (currentItem == 0 || currentItem >= count) {
                return;
            }
            BookImageInfo.this.pager.setCurrentItem(currentItem - 1);
        }
    }

    private class photoTapListener implements PhotoViewAttacher.OnPhotoTapListener {
        private photoTapListener() {
        }

        @Override // uk.co.senab.photoview.PhotoViewAttacher.OnPhotoTapListener
        public void onPhotoTap(View view, float f, float f2) {
            int count = BookImageInfo.this.adapter.getCount();
            int currentItem = BookImageInfo.this.pager.getCurrentItem();
            int id = view.getId();
            if (id != R.id.left_view) {
                if (id == R.id.right_view && currentItem < count) {
                    BookImageInfo.this.pager.setCurrentItem(currentItem + 1);
                    return;
                }
                return;
            }
            if (currentItem == 0 || currentItem >= count) {
                return;
            }
            BookImageInfo.this.pager.setCurrentItem(currentItem - 1);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Log.e("TAG", "onFling: ");
        if (motionEvent.getX() - motionEvent2.getX() > 10.0f) {
            Log.e("TAG", "left: ");
            return false;
        }
        if (motionEvent2.getX() - motionEvent.getX() <= 10.0f) {
            return false;
        }
        Log.e("TAG", "right: ");
        return false;
    }
}
