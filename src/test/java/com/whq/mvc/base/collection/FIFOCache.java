package com.whq.mvc.base.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: FIFO 替换策略的缓存，钩子方法实现
 * @Author: whq
 * @Date: 2021/8/30 10:48
 */
public class FIFOCache<K,V> extends LinkedHashMap<K,V> {

    private final int cacheSize;

    public FIFOCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
