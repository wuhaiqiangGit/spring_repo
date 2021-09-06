package com.whq.mvc.base.framework.redis.mq;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description: redis工具类
 * @Author: whq
 * @Date: 2021/9/4 18:33
 */
public final class JedisPoolUtils {

    private static JedisPool pool = null;
    private static final String HOST = "192.168.1.108";
    private static final int PORT = 6379;

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(8);
        poolConfig.setMaxTotal(8);
        pool = new JedisPool(poolConfig, HOST, PORT, 2000);
    }

    public static Jedis getJedisInstance() {
        return pool.getResource();
    }
}
