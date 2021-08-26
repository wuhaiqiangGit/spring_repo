package com.whq.mvc.base.io;

import org.junit.Test;

import java.io.*;

/**
 * @Description: dateStream测试
 * @Author: whq
 * @Date: 2021/8/26 16:33
 */
public class DataStreamTest {

    /**
     * @Description: 测试dataInputStream
     * @Author: whq
     * @Date: 2021/8/26 16:34
     */
    @Test
    public void testDataInputStream() throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("D:/target/dataStream.txt"));
        out.writeBoolean(true);
        out.writeByte((byte) 0x41);
        out.writeChar((char) 0x4243);
        out.writeShort((short) 0x4445);
        out.writeInt(0x123);
        out.writeLong(0x1234);
        out.writeUTF("abcd中");
        out.close();

    }

    /**
     * @Description: 测试dataOutputStream
     * @Author: whq
     * @Date: 2021/8/26 16:35
     */
    @Test
    public void testDataOutputStream() throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("D:/target/dataStream.txt"));
        System.out.printf("readBoolean():%s\n", in.readBoolean());
        System.out.printf("readByte():0x%s\n", byteToHexString(in.readByte()));
        System.out.printf("readChar():0x%s\n", charToHexString(in.readChar()));
        System.out.printf("readShort():0x%s\n", shortToHexString(in.readShort()));
        System.out.printf("readInt():0x%s\n", Integer.toHexString(in.readInt()));
        System.out.printf("readLong():0x%s\n", Long.toHexString(in.readLong()));
        System.out.printf("readUTF():%s\n", in.readUTF());
        in.close();
    }

    // 打印byte对应的16进制的字符串
    private String byteToHexString(byte val) {
        return Integer.toHexString(val & 0xff);
    }

    // 打印char对应的16进制的字符串
    private String charToHexString(char val) {
        return Integer.toHexString(val);
    }

    // 打印short对应的16进制的字符串
    private String shortToHexString(short val) {
        return Integer.toHexString(val & 0xffff);
    }
}
