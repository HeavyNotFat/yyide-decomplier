package com.yd.android_brand_mvp.network.interceptor;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GsonIntAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/network/interceptor/GsonIntAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "read", "jsonReader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Integer;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Integer;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GsonIntAdapter extends TypeAdapter<Integer> {
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter out, Integer value) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read */
    public Integer read2(JsonReader jsonReader) throws IOException {
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return 0;
        }
        return Integer.valueOf(jsonReader.nextInt());
    }
}
