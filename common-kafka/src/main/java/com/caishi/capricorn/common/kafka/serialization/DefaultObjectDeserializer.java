package com.caishi.capricorn.common.kafka.serialization;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * Created by user on 15/6/12.
 */
public class DefaultObjectDeserializer implements Deserializer<Object> {
    public void configure(Map<String, ?> map, boolean b) {

    }

    public Object deserialize(String s, byte[] bytes) {
        Object obj = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            obj = (Object) objectInputStream.readObject();
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to object", e);
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                throw new SerializationException("IO Exception when close object input stream after deserialize to object", e);
            }
        }

        return obj;
    }

    public void close() {

    }
}

