package com.whq.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试threadLocal controller
 */
@Controller
@RequestMapping("/threadLocal")
public class TestThreadLocalController {
    private ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);


    @RequestMapping("/test01")
    public void test01(@RequestParam("userId") Integer userId){
        String before = Thread.currentThread().getName() + ":"  + currentUser.get();
        currentUser.set(userId);
        Map map;
        try {
            String after = Thread.currentThread().getName() + ":" + currentUser.get();
            map = new HashMap<String,Integer>();
            map.put("before",before);
            map.put("after",after);
        } finally {
            currentUser.remove();
        }
        System.out.println(map);
    }

}
