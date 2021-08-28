package com.whq.mvc.base.io.commonsio;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description: commons-io fileUtils测试
 * @Author: whq
 * @Date: 2021/8/26 17:51
 */
public class FileUtilsTest {

    /**
     * @Description: 查看磁盘容量
     * @Author: whq
     * @Date: 2021/8/26 17:52
     */
    @Test
    public void testMemory() throws IOException {
        FileSystem fileSystem = FileSystems.getDefault();
        for (FileStore fileStore : fileSystem.getFileStores()) {
            System.out.printf("磁盘【%s】总大小 -> %s , 剩余可用大小 -> %s\n",
                    fileStore.name(),
                    FileUtils.byteCountToDisplaySize(fileStore.getTotalSpace()),
                    FileUtils.byteCountToDisplaySize(fileStore.getUsableSpace()));
        }
    }

    /**
     * @Description: 将byte 转换为易读的单位
     * @Author: whq
     * @Date: 2021/8/26 17:59
     */
    @Test
    public void testByteDisplay() {
        String result = FileUtils.byteCountToDisplaySize(5 * 1024L);
        Assert.assertEquals(result, "5 KB");

        String result1 = FileUtils.byteCountToDisplaySize(5 * 1024 * 1024L);
        Assert.assertEquals(result1, "5 MB");

        String result2 = FileUtils.byteCountToDisplaySize(5 * 1024 * 1024 * 1024L);
        Assert.assertEquals(result2, "5 GB");
    }

    /**
     * @Description: 将泛型为File的集合转换为数组
     * @Author: whq
     * @Date: 2021/8/26 18:05
     */
    @Test
    public void testConvertFileCollectionToFileArray() {
        List<File> list = new ArrayList<>(8);
        list.add(new File("D:/target/target.txt"));
        list.add(new File("D:/target/target.txt"));
        list.add(new File("D:/target/target.txt"));
        File[] files = FileUtils.convertFileCollectionToFileArray(list);
        for (int i = 0; i < files.length; i++) {
            Assert.assertEquals(list.get(i), files[i]);
        }
    }

    /**
     * @Description: 查找指定目录下的所有文件
     * @Author: whq
     * @Date: 2021/8/26 20:47
     */
    @Test
    public void testListFiles() {
        String[] extensions = {"java", "txt"};
        //文件路径，文件扩展名，是否递归查找
        //Collection<File> files = FileUtils.listFiles(new File("D:/target"), extensions, true);

        Collection<File> files = FileUtils.listFiles(new File("D:/target"),
                FileFilterUtils.suffixFileFilter(".txt"), TrueFileFilter.INSTANCE);
        for (File file : files) {
            System.out.printf("文件：%s %s\n", file.getAbsolutePath(), file.getName());
        }
    }

    /**
     * @Description: 比较两个文件内容是否完全一致
     * @Author: whq
     * @Date: 2021/8/26 20:56
     */
    @Test
    public void testContentEquals() throws IOException {
        boolean result = FileUtils.contentEquals(new File("D:/target/randomAccessFile.txt"),
                new File("D:/target/randomAccessFileCopy.txt"));
        Assert.assertTrue(result);
    }

    /**
     * @Description: 测试拷贝文件
     * @Author: whq
     * @Date: 2021/8/26 21:01
     */
    @Test
    public void testCopyFile() throws IOException {
        FileUtils.copyFile(new File("D:/target/randomAccessFile.txt"),
                new File("D:/target/randomAccessFileCopy.txt"));
    }

    /**
     * @Description: 拷贝一个文件到输出流
     * @Author: whq
     * @Date: 2021/8/26 21:03
     */
    @Test
    public void testCopyFileToOutputStream() throws IOException {
        try (OutputStream out = System.out) {
            FileUtils.copyFile(new File("D:/target/randomAccessFile.txt"), out);
            String result = out.toString();
            System.out.printf("out: %s\n", result);
        }
    }

    /**
     * @Description: 拷贝一个文件到输入流，也相当于拷贝文件了
     * @Author: whq
     * @Date: 2021/8/26 21:08
     */
    @Test
    public void testCopyFileToInputStream() throws IOException {
        try (InputStream in = new FileInputStream("D:/target/randomAccessFile.txt")) {
            FileUtils.copyInputStreamToFile(in, new File("D:/target/randomAccessFileCopy.txt"));
        }
    }

    /**
     * @Description: 拷贝文件到目录下
     * @Author: whq
     * @Date: 2021/8/26 21:11
     */
    @Test
    public void testCopyFileToDirectory() throws IOException {
        FileUtils.copyFileToDirectory(new File("D:/target/randomAccessFile.txt"),
                new File("D:/target/tt"));
    }

    /**
     * @Description: 拷贝url到文件
     * @Author: whq
     * @Date: 2021/8/26 21:13
     */
    @Test
    public void testCopyURLtoFile() throws IOException {
        URL url = new URL("https://avatar.csdn.net/D/8/D/3_justry_deng.jpg");
        FileUtils.copyURLToFile(url, new File("D:/target/test.jpg"));
    }

    /**
     * @Description: 测试删除目录
     * @Author: whq
     * @Date: 2021/8/26 21:16
     */
    @Test
    public void testClearDirectory() throws IOException {
        //删除目录内文件，不删除目录
        FileUtils.cleanDirectory(new File("D:/target/tt"));
        //删除目录
        FileUtils.deleteDirectory(new File("D:/target/tt"));
    }

    /**
     * @Description: 测试目录包含文件
     * @Author: whq
     * @Date: 2021/8/26 21:19
     */
    @Test
    public void testDirectoryContains() throws IOException {
        boolean result = FileUtils.directoryContains(new File("D:/target"),
                new File("D:/target/tt/randomAccessFileCopy.txt"));
        Assert.assertTrue(result);
    }

    /**
     * @Description: 测试文件大小size
     * @Author: whq
     * @Date: 2021/8/26 21:22
     */
    @Test
    public void testFileSize() {
        File file = FileUtils.getFile("D:/target/randomAccessFile.txt");
        long size = FileUtils.sizeOf(file);
        System.out.printf("文件大小：%s 字节\n", size);
    }

    /**
     * @Description: 测试文件转换流
     * @Author: whq
     * @Date: 2021/8/26 21:25
     */
    @Test
    public void testFileToStream() throws IOException {
        //读取文件转换成输入流
        FileInputStream fis = FileUtils.openInputStream(new File("D:/target/randomAccessFile.txt"));
        //读取文件转换成输出流
        FileOutputStream fos = FileUtils.openOutputStream(new File("D:/target/randomAccessFile.txt"));
        //将文件读入字节数组
        byte[] bytes = FileUtils.readFileToByteArray(new File("D:/target/randomAccessFile.txt"));
        String result = FileUtils.readFileToString(new File("D:/target/randomAccessFile.txt"),
                StandardCharsets.UTF_8);
        System.out.printf("result：%s\n", result);
    }

    /**
     * @Description: 测试readline
     * @Author: whq
     * @Date: 2021/8/26 21:32
     */
    @Test
    public void testReadLine() throws IOException {
        List<String> lines = FileUtils.readLines(new File("D:/target/randomAccessFile.txt"),
                StandardCharsets.UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            System.out.printf("%s\n", lines.get(i));
        }
    }

    /**
     * @Description: 测试写内容到文件
     * @Author: whq
     * @Date: 2021/8/26 21:35
     */
    @Test
    public void testWriteStringToFile() throws IOException {
        FileUtils.writeStringToFile(new File("D:/target/randomAccessFile.txt"),"wuhaiqiang",
                Charset.forName("UTF-8"),false);

        List<String> lines = new ArrayList<>();
        lines.add(new String("i am the one"));
        lines.add(new String("hero"));
        FileUtils.writeLines(new File("D:/target/randomAccessFile.txt"),
                lines, "\n", false);
    }
}
