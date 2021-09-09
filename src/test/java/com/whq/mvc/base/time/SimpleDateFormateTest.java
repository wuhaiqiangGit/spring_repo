package com.whq.mvc.base.time;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: SimpleDateFormate线程不安全测试
 * @Author: whq
 * @Date: 2021/9/9 15:22
 */
public class SimpleDateFormateTest {

    @Test
    public void testFormate() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (; ; ) {
            executor.execute(() -> {
                try {
                    String dateString = sdf.format(new Date(Math.abs(new Random().nextLong())));
                    System.out.printf("%s\n", dateString);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            });
        }
    }
}
