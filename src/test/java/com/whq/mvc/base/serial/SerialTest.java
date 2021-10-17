package com.whq.mvc.base.serial;

import org.junit.Test;

import java.io.*;

/**
 * @Description: 序列化测试
 * static属性不会被序列化，多次序列化一个相同的引用类型属性（比如对象）,如果对象属性修改，序列化不生效，
 * 因为序列化只有第一次操作会读取字节码
 * 使用transient修饰的属性，java序列化时，会忽略掉此字段
 * @Author: whq
 * @Date: 2021/10/5 21:23
 */
public class SerialTest {

    @Test
    public void testWriteObject() throws IOException {
        Person person = new Person(1, "wuhaiqiang");
        FileOutputStream fos = new FileOutputStream("D://target/person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            person.nickName = "jack";
            oos.writeObject(person);
        } finally {
            oos.close();
            fos.close();
        }
    }

    @Test
    public void testReadObject() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("D://target/person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person person = (Person) ois.readObject();
        System.out.printf("%s\n", person.nickName);
        System.out.printf("%s\n", person);
    }

    @Test
    public void testStringBuffer() {
        String name = "wuhaiqiang";
        StringBuffer sb = new StringBuffer(name).reverse();
        System.out.printf("sb: %s\n", sb.toString());
    }
}
