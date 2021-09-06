package com.whq.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试threadLocal controller
 */
@Controller
@RequestMapping(value = "/threadLocal")
public class TestThreadLocalController {
    private ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/test01")
    public void test01(@RequestBody Map<String,Object> param){
        String before = Thread.currentThread().getName() + ":"  + currentUser.get();
        //currentUser.set(userId);
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
