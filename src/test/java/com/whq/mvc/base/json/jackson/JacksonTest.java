package com.whq.mvc.base.json.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: jackson测试
 * @Author: whq
 * @Date: 2021/9/5 16:44
 */
public class JacksonTest {

    @Test
    public void testJackson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson = "{\"brand\":\"Mercedes\",\"doors\":5}";
        Car car = objectMapper.readValue(carJson, Car.class);
        System.out.printf("car: %s\n", car.toString());
    }

    @Test
    public void testFromFile() throws IOException {
        File file = FileUtils.getFile("D:/target/carJson.txt");
        byte[] bytes = FileUtils.readFileToByteArray(file);
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(bytes, new TypeReference<Car>(){});
        System.out.printf("car: %s\n", car);
    }

    @Test
    public void testWriteJson() throws IOException {
        Car car = new Car("ad", 4);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(car);
        System.out.printf("json: %s\n",json);

        File file = FileUtils.getFile("D:/target/carJson.txt");
        FileOutputStream fos = FileUtils.openOutputStream(file, false);
        objectMapper.writeValue(fos,car);
        fos.close();
    }
}
