package com.caishi.capricorn.common.login.util;

import java.io.*;

public class ObjectsTranscoder<T extends Serializable> extends SerializeTranscoder {

    @Override
    public byte[] serialize(Object value) throws Exception {
        byte[] result = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            T obj = (T) value;
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            result = byteArrayOutputStream.toByteArray();
        } finally {
            close(objectOutputStream);
            close(byteArrayOutputStream);
        }
        return result;
    }

    @Override
    public Object deserialize(byte[] in) throws Exception {
        T result = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            if (in != null) {
                byteArrayInputStream = new ByteArrayInputStream(in);
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                result = (T) objectInputStream.readObject();
                objectInputStream.close();
                byteArrayInputStream.close();
            }
        }finally {
            close(objectInputStream);
            close(byteArrayInputStream);
        }
        return result;
    }
}
