package com.caishi.capricorn.common.kafka.serialization;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * Created by user on 15/6/12.
 */
public class DefaultObjectSerializer implements Serializer<Object> {
    public void configure(Map<String, ?> map, boolean b) {

    }

    public byte[] serialize(String topic, Object object) {
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            bytes = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new SerializationException("Error when serializing object to byte[]", e);
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                throw new SerializationException("IO Exception when close object output stream after serialize to byte array", e);
            }
        }

        return bytes;
    }

    public void close() {

    }
}
