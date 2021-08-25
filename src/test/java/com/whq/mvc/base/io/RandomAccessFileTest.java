package com.whq.mvc.base.io;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description: 测试多线程进行文件的写操作
 * @Author: whq
 * @Date: 2021/8/25 21:22
 */
public class RandomAccessFileTest {

    @Test
    public void testWrite() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("D:/target/randomAccessFile.txt", "rw");
        accessFile.setLength(18 * 5);
        accessFile.close();

        String s1 = "第一个字符串";
        String s2 = "第二个字符串";
        String s3 = "第三个字符串";
        String s4 = "第四个字符串";
        String s5 = "第五个字符串";

        new FileWriteThread(0,s1.getBytes("UTF-8")).start();
        new FileWriteThread(18*1,s2.getBytes("UTF-8")).start();
        new FileWriteThread(18*2,s3.getBytes("UTF-8")).start();
        new FileWriteThread(18*3,s4.getBytes("UTF-8")).start();
        new FileWriteThread(18*4,s5.getBytes("UTF-8")).start();
    }

    static class FileWriteThread extends Thread {

        private int skip;
        private byte[] content;

        public FileWriteThread(int skip, byte[] content) {
            this.skip = skip;
            this.content = content;
        }

        @Override
        public void run() {
            RandomAccessFile accessFile = null;
            try {
                accessFile = new RandomAccessFile("D:/target/randomAccessFile.txt", "rw");
                accessFile.seek(skip);
                accessFile.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    accessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
