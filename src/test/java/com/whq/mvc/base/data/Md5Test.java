package com.whq.mvc.base.data;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description: md5 hash算法测试
 * @Author: whq
 * @Date: 2021/9/1 16:01
 */
public class Md5Test {

    /**
     * @Description: jdk原生api
     * @Author: whq
     * @Date: 2021/9/1 16:06
     */
    public static String convertMd5(String str){
        if (null == str || "".equals(str)){
            return "";
        }
        String md5Str = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            byte[] digest = md5.digest();
            StringBuilder sb = new StringBuilder(64);
            for (int i = 0; i < digest.length; i++) {
                String hexStr = Integer.toHexString(digest[i] & 0xFF);
                if (hexStr.length() == 1){
                    sb.append("0");
                }
                sb.append(hexStr);
            }
            md5Str = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return md5Str;
    }

    @Test
    public void testMd5(){
        String md5Str = Md5Test.convertMd5("hello");
        System.out.printf("%s\n%d\n",md5Str,md5Str.length());
    }

    /**
     * @Description: lambda
     * 一个 Lambda 表达式可以有零个或多个参数
     * 参数的类型既可以明确声明，也可以根据上下文来推断。例如：(int a)与(a)效果相同
     * 所有参数需包含在圆括号内，参数之间用逗号相隔。例如：(a, b) 或 (int a, int b) 或 (String a, int b, float c)
     * 空圆括号代表参数集为空。例如：() -> 42
     * 当只有一个参数，且其类型可推导时，圆括号（）可省略。例如：a -> return a*a
     * Lambda 表达式的主体可包含零条或多条语句
     * 如果 Lambda 表达式的主体只有一条语句，花括号{}可省略。匿名函数的返回类型与该主体表达式一致
     * 如果 Lambda 表达式的主体包含一条以上语句，则表达式必须包含在花括号{}中（形成代码块）。
     *  匿名函数的返回类型与代码块的返回类型一致，若没有返回则为空
     * @Author: whq
     * @Date: 2021/9/1 20:28
     */
    @Test
    public void testFunInterface(){
        FunInterface funInterface = words -> {
            System.out.printf("%s\n",words);
        };
        funInterface.talk("hello");
    }
}
