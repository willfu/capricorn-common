package com.caishi.capricorn.common.search.client;

import com.caishi.capricorn.common.search.utils.JestClientFactoryUtils;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import java.util.Collection;
import java.util.HashSet;

public class JestClientGenerator extends JestClientFactory {

    /**
     * constructors
     *
     * @param serverUrls server url collection
     */
    public JestClientGenerator(String serverUrls) {
        setServerUrls(serverUrls);
    }

    /**
     * server url collection
     */
    private String serverUrls;

    public String getServerUrls() {
        return serverUrls;
    }

    public void setServerUrls(String serverUrls) {
        this.serverUrls = serverUrls;
    }

    /**
     * get JestClientFactory
     *
     * @return JestClientFactory instance
     */
    public JestClientFactory getJestClientFactory() {
        String[] serverUrlArray;
        if (serverUrls == null || (serverUrls = serverUrls.replace(" ", "")).isEmpty() || (serverUrlArray = getServerUrls().split(",")).length == 0) {
            return null;
        }

        Collection<String> serverUrlCollection = new HashSet<>();
        for (String serverUrl : serverUrlArray) {
            serverUrlCollection.add(serverUrl);
        }

        JestClientFactory jestClientFactory = JestClientFactoryUtils.getJestClientFactory(serverUrlCollection);
        return jestClientFactory;
    }

    /**
     * get JestClient
     *
     * @return JestClient instance
     */
    public JestClient getJestClient() {
        JestClientFactory jestClientFactory = getJestClientFactory();
        if (jestClientFactory == null) {
            return null;
        }
        JestClient jestClient = jestClientFactory.getObject();
        return jestClient;
    }
}