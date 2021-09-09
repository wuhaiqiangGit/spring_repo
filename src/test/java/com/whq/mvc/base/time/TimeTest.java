package com.whq.mvc.base.time;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 时间类测试
 * @Author: whq
 * @Date: 2021/9/9 10:17
 */
public class TimeTest {

    @Test
    public void testDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
        String dateString = sdf.format(date);
        System.out.printf("dateString: %s\n", dateString);
    }

    @Test
    public void testCalendar() {
        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH) + 1;
        int day = instance.get(Calendar.DATE);
        int hour = instance.get(Calendar.HOUR_OF_DAY);
        int minute = instance.get(Calendar.MINUTE);
        int second = instance.get(Calendar.SECOND);
        System.out.printf("time: %s-%s-%s %s:%s:%s\n", year, month, day, hour, minute, second);

        instance.add(Calendar.MONTH, 1);

        Date time = instance.getTime();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.printf("time: %s\n", sdf.format(time));
    }

    @Test
    public void testDateUtils() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                String dateStr = DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
                System.out.printf("%s\n", dateStr);
            });
        }
        executor.shutdown();
    }

    @Test
    public void testLocalTime() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("%d:%d:%d\n", year, month, day);

        LocalDate date = LocalDate.of(2021, 9, 10);
        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataStr = date.format(dfm);

        System.out.printf("%s\n", dataStr);
    }
}
