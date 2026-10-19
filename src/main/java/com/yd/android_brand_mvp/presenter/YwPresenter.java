package com.yd.android_brand_mvp.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.BookassetsRsp;
import com.yd.android_brand_mvp.model.SearchBean;
import com.yd.android_brand_mvp.model.SearchBookRsp;
import com.yd.android_brand_mvp.model.YwBookRsp;
import com.yd.android_brand_mvp.model.ctrlNoRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.view.getTopsView;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class YwPresenter extends BasePresenter<getTopsView> {
    public YwPresenter(getTopsView gettopsview) {
        attachView(gettopsview);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0038  */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void getTops(String str, String str2, String str3, String str4, String str5) {
        byte b;
        String str6;
        String str7;
        int iHashCode = str2.hashCode();
        byte b2 = 0;
        if (iHashCode != 21608) {
            if (iHashCode != 24180) {
                if (iHashCode == 26376 && str2.equals("月")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (str2.equals("年")) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (str2.equals("周")) {
            b = 0;
        } else {
            b = -1;
        }
        String str8 = "365";
        if (b == 0) {
            str8 = ConversionUtil.conditionWithBookType;
        } else if (b == 1) {
            str8 = "30";
        }
        String str9 = str8;
        if (str3.equals("全部文献") || TextUtils.isEmpty(str3)) {
            str6 = "";
        } else {
            switch (str3.hashCode()) {
                case 710440:
                    if (!str3.equals("图书")) {
                        b2 = -1;
                    }
                    break;
                case 815283:
                    if (!str3.equals("报纸")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 839371:
                    if (!str3.equals("期刊")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 1174835613:
                    if (!str3.equals("非书资料")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                str7 = "0";
            } else if (b2 == 1) {
                str7 = "1";
            } else if (b2 == 2) {
                str7 = "2";
            } else if (b2 != 3) {
                str6 = str3;
            } else {
                str7 = "3";
            }
            str6 = str7;
        }
        String str10 = str4.equals("全部语种") ? "" : str4;
        String str11 = (TextUtils.isEmpty(str5) || str5.equals("全部分类")) ? "" : str5;
        Log.e("TAG", "getTops参数: " + JSON.toJSONString(str9));
        Log.e("TAG", "getTops参数: " + JSON.toJSONString(str6));
        Log.e("TAG", "getTops参数: " + JSON.toJSONString(str10));
        Log.e("TAG", "getTops参数: " + JSON.toJSONString(str11));
        addSubscription(this.bookApiStores.getTops(str, str9, str6, str10, str11), new ApiCallback<List<YwBookRsp>>() { // from class: com.yd.android_brand_mvp.presenter.YwPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str12) {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(List<YwBookRsp> list) {
                ((getTopsView) YwPresenter.this.mvpView).getTopsSuccess(list);
            }
        });
    }

    public void getBookMsg(String str) {
        addSubscription(this.bookApiStores.getBookMsg(str), new ApiCallback<ctrlNoRsp>() { // from class: com.yd.android_brand_mvp.presenter.YwPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(ctrlNoRsp ctrlnorsp) {
                ((getTopsView) YwPresenter.this.mvpView).getctrlNoSuccess(ctrlnorsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((getTopsView) YwPresenter.this.mvpView).getctrlNoFail(str2);
            }
        });
    }

    public void getBookMsgAssets(String str) {
        addSubscription(this.bookApiStores.getBookMsgAssets(str), new ApiCallback<List<BookassetsRsp>>() { // from class: com.yd.android_brand_mvp.presenter.YwPresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(List<BookassetsRsp> list) {
                ((getTopsView) YwPresenter.this.mvpView).getBookassetsSuccess(list);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((getTopsView) YwPresenter.this.mvpView).getBookassetsFail(str2);
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    public void searchBook(String str, String str2) {
        SearchBean.AA aa = new SearchBean.AA();
        switch (str) {
            case "任意":
                aa.any = str2;
                break;
            case "书名":
                aa.title = str2;
                break;
            case "作者":
                aa.author = str2;
                break;
            case "出版社":
                aa.publisher = str2;
                break;
            case "标准书号":
                aa.stdNum = str2;
                break;
            case "索书号":
                aa.callNo = str2;
                break;
            case "中图分类":
                aa.clc = str2;
                break;
            case "主题词":
                aa.subject = str2;
                break;
        }
        SearchBean searchBean = new SearchBean();
        SearchBean.BB bb = new SearchBean.BB();
        if (aa.equals("任意")) {
            searchBean.query = aa;
        } else {
            searchBean.query = aa;
            searchBean.tag = bb;
            searchBean.offset = "0";
            searchBean.rows = "100";
        }
        addSubscription(this.bookApiStores.searchBook(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(searchBean))), new ApiCallback<SearchBookRsp>() { // from class: com.yd.android_brand_mvp.presenter.YwPresenter.4
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(SearchBookRsp searchBookRsp) {
                ((getTopsView) YwPresenter.this.mvpView).searchBookSuccess(searchBookRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((getTopsView) YwPresenter.this.mvpView).searchBookFail(str3);
            }
        });
    }
}
