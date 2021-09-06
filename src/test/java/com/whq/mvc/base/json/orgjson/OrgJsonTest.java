package com.whq.mvc.base.json.orgjson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

/**
 * @Description: org json测试
 * @Author: whq
 * @Date: 2021/9/5 10:57
 */
public class OrgJsonTest {

    @Test
    public void testOrgJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "wuhaiqiang");
        jsonObject.put("age", 26);
        System.out.printf("jsonObject: %s\n", jsonObject.toString());

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("a");
        jsonArray.put("b");
        jsonArray.put("c");
        System.out.printf("jsonArray: %s\n", jsonArray.toString());

        boolean hasKey = jsonObject.has("age");
        System.out.printf("hasKey: %s\n", hasKey);
    }
}
