package com.whq.mvc.base.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 时间工具类
 * @Author: whq
 * @Date: 2021/9/9 15:37
 */
public class DateUtils {

    private static final transient Lock lock = new ReentrantLock();

    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<>();

    private static SimpleDateFormat getSdf(String pattern) {
        ThreadLocal<SimpleDateFormat> t1 = sdfMap.get(pattern);
        if (null == t1) {
            lock.lock();
            t1 = sdfMap.get(pattern);
            if (null == t1) {
                t1 = ThreadLocal.withInitial(() -> {
                    return new SimpleDateFormat(pattern);
                });
                sdfMap.put(pattern, t1);
            }
        }
        return t1.get();
    }

    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static Date parse(String dateStr,String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }
}
