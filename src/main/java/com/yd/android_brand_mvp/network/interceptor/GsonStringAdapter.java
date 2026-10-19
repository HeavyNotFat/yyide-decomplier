package com.yd.android_brand_mvp.network.interceptor;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GsonStringAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/network/interceptor/GsonStringAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "read", "jsonReader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GsonStringAdapter extends TypeAdapter<String> {
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter out, String value) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public String read2(JsonReader jsonReader) throws IOException {
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return "";
        }
        String strNextString = jsonReader.nextString();
        Intrinsics.checkNotNullExpressionValue(strNextString, "jsonReader.nextString()");
        return strNextString;
    }
}
