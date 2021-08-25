package com.whq.mvc.base.io;

import org.junit.Test;

import java.io.*;

/**
 * @Description: objectStream测试
 * @Author: whq
 * @Date: 2021/8/24 21:46
 */
public class ObjectStreamTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private transient String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ObjectStreamTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    /**
     * @Description: 测试objectStream写出对象
     * @Author: whq
     * @Date: 2021/8/24 21:48
     */
    @Test
    public void testObjectStreamWrite() throws IOException {
        File file = new File("D:/target/objectStream.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        ObjectStreamTest obj1 = new ObjectStreamTest();
        obj1.setId(1);
        obj1.setName("wuhaiqiang");
        obj1.setDesc("desc");
        ObjectStreamTest obj2 = new ObjectStreamTest();
        obj2.setId(2);
        obj2.setName("ww");
        obj2.setDesc("desc");
        outputStream.writeObject(obj1);
        outputStream.writeObject(obj2);
        outputStream.close();
    }

    /**
     * @Description: 测试objectStream读取对象
     * @Author: whq
     * @Date: 2021/8/24 21:55
     */
    @Test
    public void testObjectStreamRead() throws IOException, ClassNotFoundException {
        File file = new File("D:/target/objectStream.txt");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Object obj1 = inputStream.readObject();
        System.out.println(obj1.getClass().getSimpleName());
        System.out.println(obj1);
        Object obj2 = inputStream.readObject();
        System.out.println(obj2.getClass().getSimpleName());
        System.out.println(obj2);
        inputStream.close();
    }
}
