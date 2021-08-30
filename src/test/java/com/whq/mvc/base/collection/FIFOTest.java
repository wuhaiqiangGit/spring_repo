package com.whq.mvc.base.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FIFOTest {

    @Test
    public void testFifo() {
        Map<String, String> fifoCache = new FIFOCache<String, String>(3);
        fifoCache.put("a", "a");
        fifoCache.put("b", "b");
        fifoCache.put("c", "c");
        fifoCache.put("d", "d");
        Set<Map.Entry<String, String>> entries = fifoCache.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.printf("key: %s value： %s\n", entry.getKey(), entry.getValue());
        }
    }
}
