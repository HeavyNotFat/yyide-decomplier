package com.yd.android_brand_mvp.utils;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public class CardUtils55 {
    private static CardUtils55 instance;
    private ArrayList<Integer> B4_HEAD = new ArrayList<>();
    private ArrayList<Integer> B5_HEAD = new ArrayList<>();
    private ArrayList<Integer> B8_HEAD = new ArrayList<>();
    private ArrayList<Integer> CC_HEAD = new ArrayList<>();
    private ArrayList<Integer> CD_LIST = new ArrayList<>();

    public static CardUtils55 getInstance() {
        if (instance == null) {
            instance = new CardUtils55();
        }
        return instance;
    }

    private CardUtils55() {
        Collections.addAll(this.B4_HEAD, 2, 9);
        Collections.addAll(this.B5_HEAD, 2, 10);
        Collections.addAll(this.B8_HEAD, 2, 13);
        Collections.addAll(this.CC_HEAD, 85, 170);
    }

    private int getCheckCode(int i, int i2) {
        int iIntValue = this.CD_LIST.get(i).intValue();
        while (true) {
            i++;
            if (i > i2) {
                return iIntValue;
            }
            iIntValue ^= this.CD_LIST.get(i).intValue();
        }
    }

    private String convertCardNo(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        while (i <= i2) {
            sb.append(String.format("%02X", this.CD_LIST.get(i)));
            i++;
        }
        return String.valueOf(Long.parseLong(sb.toString(), 16));
    }

    public String getCardNo(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            while (i < i2) {
                this.CD_LIST.add(Integer.valueOf(bArr[i] & 255));
                i++;
            }
        }
        int iLastIndexOfSubList = Collections.lastIndexOfSubList(this.CD_LIST, this.B4_HEAD);
        if (iLastIndexOfSubList >= 0 && iLastIndexOfSubList + 9 <= this.CD_LIST.size() && this.CD_LIST.get(iLastIndexOfSubList + 8).intValue() == 3) {
            int i3 = iLastIndexOfSubList + 6;
            if (getCheckCode(iLastIndexOfSubList + 1, i3) == this.CD_LIST.get(iLastIndexOfSubList + 7).intValue()) {
                String strConvertCardNo = convertCardNo(iLastIndexOfSubList + 3, i3);
                this.CD_LIST.clear();
                return strConvertCardNo;
            }
        }
        int iLastIndexOfSubList2 = Collections.lastIndexOfSubList(this.CD_LIST, this.B5_HEAD);
        if (iLastIndexOfSubList2 >= 0 && iLastIndexOfSubList2 + 10 <= this.CD_LIST.size() && this.CD_LIST.get(iLastIndexOfSubList2 + 9).intValue() == 3) {
            int i4 = iLastIndexOfSubList2 + 7;
            if (getCheckCode(iLastIndexOfSubList2 + 1, i4) == this.CD_LIST.get(iLastIndexOfSubList2 + 8).intValue()) {
                String strConvertCardNo2 = convertCardNo(iLastIndexOfSubList2 + 3, i4);
                this.CD_LIST.clear();
                return strConvertCardNo2;
            }
        }
        int iLastIndexOfSubList3 = Collections.lastIndexOfSubList(this.CD_LIST, this.CC_HEAD);
        if (iLastIndexOfSubList3 < 0) {
            return null;
        }
        int i5 = iLastIndexOfSubList3 + 7;
        if (i5 <= this.CD_LIST.size()) {
            int i6 = iLastIndexOfSubList3 + 2;
            int i7 = iLastIndexOfSubList3 + 5;
            if (getCheckCode(i6, i7) == this.CD_LIST.get(iLastIndexOfSubList3 + 6).intValue()) {
                String strConvertCardNo3 = convertCardNo(i6, i7);
                this.CD_LIST.clear();
                return strConvertCardNo3;
            }
        }
        if (i5 > this.CD_LIST.size()) {
            return null;
        }
        int i8 = iLastIndexOfSubList3 + 2;
        int i9 = iLastIndexOfSubList3 + 8;
        if (getCheckCode(i8, i9) != this.CD_LIST.get(iLastIndexOfSubList3 + 9).intValue()) {
            return null;
        }
        String strConvertCardNo4 = convertCardNo(i8, i9);
        this.CD_LIST.clear();
        return strConvertCardNo4;
    }
}
