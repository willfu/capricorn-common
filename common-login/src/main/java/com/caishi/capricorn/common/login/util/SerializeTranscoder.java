package com.caishi.capricorn.common.login.util;

import java.io.Closeable;

public abstract class SerializeTranscoder {
    public abstract byte[] serialize(Object value) throws Exception;

    public abstract Object deserialize(byte[] in) throws Exception;

    public void close(Closeable closeable) throws Exception {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
