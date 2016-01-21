package com.caishi.capricorn.common.search;

import com.caishi.capricorn.common.search.client.JestClientGenerator;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class JestClientGeneratorTest extends TestCase {
    @Test
    public void testGetJestClientFactory(){
        JestClientGenerator jestClientGenerator = new JestClientGenerator("http://10.1.1.121:9200");
        JestClientFactory jestClientFactory = jestClientGenerator.getJestClientFactory();
        Assert.assertNotNull(jestClientFactory);
        JestClient jestClient = jestClientGenerator.getJestClient();
        Assert.assertNotNull(jestClient);
    }
}
