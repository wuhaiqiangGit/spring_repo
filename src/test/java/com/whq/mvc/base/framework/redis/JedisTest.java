package com.whq.mvc.base.framework.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Tuple;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Description: jedis测试类
 * @Author: whq
 * @Date: 2021/9/2 16:30
 */
public class JedisTest {

    private JedisPoolConfig config;
    private JedisPool jedisPool;
    private Jedis jedis;

    @Before
    public void init() {
        config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        jedisPool = new JedisPool(config, "192.168.1.108", 6379, 2000);
        jedis = jedisPool.getResource();
    }

    @After
    public void after() {
        jedis.close();
        jedisPool.close();
    }

    @Test
    public void testString() {
        //字符串操作
        String value = jedis.get("money");
        System.out.printf("money: %s\n", value);
    }

    @Test
    public void testList() {
        //list类型
        jedis.lpush("myList", "a", "b", "c");
        jedis.rpush("myList", "e", "f", "g");
        String lpopVal = jedis.lpop("myList");
        System.out.printf("lpopVal: %s\n", lpopVal);
        List<String> myList = jedis.lrange("myList", 0, -1);
        for (int i = 0; i < myList.size(); i++) {
            System.out.printf("%s\n", myList.get(i));
        }
    }

    @Test
    public void testSet() {
        //set类型
        jedis.sadd("mySet", "a", "b", "c", "d");
        Set<String> mySet = jedis.smembers("mySet");
        Iterator<String> iterator = mySet.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.printf("%s\n", next);
        }
    }

    @Test
    public void testZset() {
        //zset类型
        jedis.zadd("myZset", 10.0d, "a");
        jedis.zadd("myZset", 10.1d, "b");
        jedis.zadd("myZset", 10.2d, "c");
        Set<Tuple> myZset = jedis.zrangeWithScores("myZset", 0, -1);
        Iterator<Tuple> iterator = myZset.iterator();
        while (iterator.hasNext()) {
            Tuple next = iterator.next();
            System.out.printf("%s\n", next);
        }
    }
}
