package com.caishi.capricorn.common.search.utils;

import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

import java.util.Collection;

public class JestClientFactoryUtils {

    /**
     * get jest client factory
     */
    private volatile static JestClientFactory jestClientFactory = null;

    public final static JestClientFactory getJestClientFactory(Collection<String> urlCollection) {
        if (jestClientFactory == null) {
            synchronized (JestClientFactoryUtils.class) {
                JestClientFactory temp = jestClientFactory;
                if (temp == null) {
                    temp = new JestClientFactory();
                    temp.setHttpClientConfig(new HttpClientConfig.Builder(urlCollection).multiThreaded(true).build());
                    if (temp != null) {
                        jestClientFactory = temp;
                    }
                }
            }
        }
        return jestClientFactory;
    }
}