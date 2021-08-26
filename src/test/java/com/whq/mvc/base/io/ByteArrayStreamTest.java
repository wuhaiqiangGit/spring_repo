package com.whq.mvc.base.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: byteArrayStream测试
 * @Author: whq
 * @Date: 2021/8/26 16:09
 */
public class ByteArrayStreamTest {

    /**
     * @Description: 测试byteArrayInputStream
     * @Author: whq
     * @Date: 2021/8/26 16:10
     */
    @Test
    public void testByteArrayInputStream() throws IOException {
        String msg = "hello world";
        byte[] bytes = msg.getBytes("UTF-8");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int result = -1;
        while ((result = byteArrayInputStream.read()) != -1){
            System.out.print((char) result);
        }
        byteArrayInputStream.close();
    }

    /**
     * @Description: byteArrayOutputStream测试
     * @Author: whq
     * @Date: 2021/8/26 16:15
     */
    @Test
    public void testByteArrayOutputStream() throws IOException {
        String msg = "hello world";
        byte[] bytes = msg.getBytes("UTF-8");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bytes);

        FileOutputStream fos = new FileOutputStream("D:/target/target.txt");
        byteArrayOutputStream.writeTo(fos);
        fos.close();
        byteArrayOutputStream.close();
    }
}
