package com.whq.mvc.base.io;

import org.junit.Test;

import java.io.*;

/**
 * @Description: io基本测试
 * @Author: whq
 * @Date: 2021/8/24 16:40
 */
public class IoTest {

    /**
     * @Description: outputstream写出文件
     * @Author: whq
     * @Date: 2021/8/24 16:43
     */
    @Test
    public void testWriteFile() throws IOException {
        String hello = new String("hello world");
        byte[] bytes = hello.getBytes();
        File file = new File("D:/target/test.txt");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
    }

    /**
     * @Description: inputstream读取文件
     * @Author: whq
     * @Date: 2021/8/24 16:46
     */
    @Test
    public void testReadFile() throws IOException {
        File file = new File("D:/target/test.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        int size = fis.read(bytes);
        System.out.println("文件大小：" + size);
        System.out.println("文件内容： " + new String(bytes, "UTF-8"));
    }

    /**
     * @Description: 拷贝文件
     * @Author: whq
     * @Date: 2021/8/24 17:13
     */
    @Test
    public void testCopyFile() throws IOException {
        String source = "D:/target/git.txt";
        String target = "D:/target/target.txt";

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(target);

        byte[] bytes = new byte[1024];
        int len;
        while (-1 != (len = fis.read(bytes))) {
            fos.write(bytes, 0, len);
        }
        fos.flush();

        fis.close();
        fos.close();
    }

    /**
     * @Description: 测试字符流writer
     * @Author: whq
     * @Date: 2021/8/24 17:31
     */
    @Test
    public void testWriter() throws IOException {
        String hello = new String("hello world");
        File file = new File("D:/target/target.txt");
        Writer writer = new FileWriter(file);
        writer.write(hello);
        writer.close();
    }

    /**
     * @Description: 测试字符流reader
     * @Author: whq
     * @Date: 2021/8/24 17:33
     */
    @Test
    public void testReader() throws IOException {
        File file = new File("D:/target/target.txt");
        FileReader reader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        int size = reader.read(chars);
        System.out.println("文件大小：" + size);
        System.out.println("文件内容： " + new String(chars));
        reader.close();
    }

    /**
     * @Description: 测试字节流转换为字符流
     * @Author: whq
     * @Date: 2021/8/24 17:38
     */
    @Test
    public void testConvertByteToChar() throws IOException {
        File file = new File("D:/target/target.txt");
        FileInputStream fis = new FileInputStream(file);
        Reader reader = new InputStreamReader(fis);
        char[] chars = new char[(int) file.length()];
        int size = reader.read(chars);
        System.out.println("文件大小：" + size);
        System.out.println("文件内容： " + new String(chars));
        reader.close();
        fis.close();
    }

    /**
     * @Description: 测试 File类
     * @Author: whq
     * @Date: 2021/8/24 17:43
     */
    @Test
    public void testFile() {
        File file = new File("D:/target/target.txt");
        boolean exists = file.exists(); //判断文件是否存在
        System.out.println("file exists: " + exists);
        File file1 = new File("D:/target/whq");
        if (!file1.exists()) {
            file1.mkdir();  //创建文件夹
        }
        if (file1.exists()) {
            file1.delete(); //删除文件
        }
        boolean renameTo = file.renameTo(new File("D:/target/target1.txt"));    //重命名文件
        System.out.println("renameTo: " + renameTo);

        boolean isDirectory = file.isDirectory();   //是否是目录
        System.out.println("isDirectory: " + isDirectory);

        File target = new File("D:/target/whq");
        String[] fileNames = target.list(); //列出文件名
        for (int i = 0; i < fileNames.length; i++) {
            System.out.println(fileNames[i]);
        }
    }

    /**
     * @Description: 测试随机读取文件
     * @Author: whq
     * @Date: 2021/8/24 18:11
     */
    @Test
    public void testRandomAccessFileRead() throws IOException {
        RandomAccessFile file = new RandomAccessFile("d:/target/target.txt", "rw");
        //移动读写指针
        file.seek(6);
        long pointerBegin = file.getFilePointer();
        System.out.println("pointerBegin: " + pointerBegin);
        byte[] bytes = new byte[1024];
        int size = file.read(bytes);
        long pointerEnd = file.getFilePointer();
        System.out.println("pointerEnd: " + pointerEnd);
        System.out.println(new String(bytes, 0, size, "UTF-8"));
        file.close();
    }

    /**
     * @Description: 测试随机写出文件
     * @Author: whq
     * @Date: 2021/8/24 18:20
     */
    @Test
    public void testRandomAccessFileWrite() throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:/target/target.txt", "rw");
        file.seek(6);
        String msg = "welcome to";
        long pointerBegin = file.getFilePointer();
        System.out.println("pointerBegin: " + pointerBegin);
        file.write(msg.getBytes());
        long pointerEnd = file.getFilePointer();
        System.out.println("pointerEnd: " + pointerEnd);
        file.close();
    }

    /**
     * @Description: 测试缓冲输入流
     * @Author: whq
     * @Date: 2021/8/24 20:27
     */
    @Test
    public void testBufferedInputStream() throws IOException {
        File file = new File("D:/target/target.txt");
        InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 2 * 1024);
        byte[] bytes = new byte[(int) file.length()];
        int size = bufferedInputStream.read(bytes);
        System.out.println(new String(bytes, "UTF-8"));
        bufferedInputStream.close();
    }

    /**
     * @Description: 测试缓冲输出流
     * @Author: whq
     * @Date: 2021/8/24 20:32
     */
    @Test
    public void testBufferedOutputStream() throws IOException {
        File file = new File("D:/target/target.txt");
        OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 2 * 1014);
        String out = "bufferedOutputStream";
        bufferedOutputStream.write(out.getBytes());
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    /**
     * @Description: 测试缓冲流copy文件
     * @Author: whq
     * @Date: 2021/8/24 20:35
     */
    @Test
    public void testBufferedCopy() throws IOException {
        String source = "D:/target/target.txt";
        String target = "D:/target/targetCopy.txt";

        InputStream bis = new BufferedInputStream(new FileInputStream(source), 2 * 1024);
        OutputStream bos = new BufferedOutputStream(new FileOutputStream(target), 2 * 1024);
        byte[] bytes = new byte[1024];
        int len;
        while (-1 != (len = bis.read(bytes))) {
            bos.write(bytes, 0, len);
        }
        bos.flush();

        bos.close();
        bis.close();
    }

    /**
     * @Description: 测试缓冲字符流
     * @Author: whq
     * @Date: 2021/8/24 21:05
     */
    @Test
    public void testBufferedReader() throws IOException {
        File file = new File("D:/target/target.txt");
        Reader bufferedReader = new BufferedReader(new FileReader(file), 2 * 1024);
        char[] chars = new char[(int) file.length()];
        int size = bufferedReader.read(chars);
        System.out.println(new String(chars));
        bufferedReader.close();
    }

    /** 
     * @Description: 测试缓冲字符流
     * @Author: whq
     * @Date: 2021/8/24 21:11
     */
    @Test
    public void testBufferedWriter() throws IOException {
        File file = new File("D:/target/target.txt");
        Writer bufferedWriter = new BufferedWriter(new FileWriter(file), 2 * 2014);
        String out = "bufferedWriter";
        bufferedWriter.write(out);
        
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /**
     * @Description: 测试字符缓冲流readline
     * @Author: whq
     * @Date: 2021/8/24 21:12
     */
    @Test
    public void testBufferedReaderReadLine() throws IOException {
        File file = new File("D:/target/target.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = null;
        while (null != (line = bufferedReader.readLine())){
            if ("exit".equals(line)){
                break;
            }
            System.out.println(line);
        }
        bufferedReader.close();
    }

}
