package com.caishi.capricorn.common.login.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListTranscoder<T extends Serializable> extends SerializeTranscoder {

    public List<T> deserialize(byte[] in) throws Exception{
        List<T> result = new ArrayList<T>();
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            if (in != null) {
                byteArrayInputStream = new ByteArrayInputStream(in);
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                while (true) {
                    T object = (T)objectInputStream.readObject();
                    if (object == null) {
                        break;
                    }
                    result.add(object);
                }
                objectInputStream.close();
                byteArrayInputStream.close();
            }
        } finally {
            close(objectInputStream);
            close(byteArrayInputStream);
        }
        return  result;
    }

    @Override
    public byte[] serialize(Object value) throws Exception {
        List<T> values = (List<T>) value;
        byte[] results = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            for (T obj : values) {
                objectOutputStream.writeObject(obj);
            }
            objectOutputStream.close();
            byteArrayOutputStream.close();
            results = byteArrayOutputStream.toByteArray();
        }finally {
            close(objectOutputStream);
            close(objectOutputStream);
        }
        return results;
    }
}
