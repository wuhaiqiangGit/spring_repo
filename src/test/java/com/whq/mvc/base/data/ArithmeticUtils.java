package com.whq.mvc.base.data;

import java.math.BigDecimal;

/**
 * @Description: 用于高精度处理常用的数学运算
 * @Author: whq
 * @Date: 2021/8/28 15:15
 */
public class ArithmeticUtils {

    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    /**
     * @Description: 提供精确的加法运算
     * @Author: whq
     * @Date: 2021/8/28 15:17
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    public static BigDecimal add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2);
    }

    /**
     * @Description: 加法运算，保留scale位小数，四舍五入
     * @Author: whq
     * @Date: 2021/8/28 17:32
     */
    public static String add(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * @Description: 精确的减法
     * @Author: whq
     * @Date: 2021/8/28 17:37
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * @Description: 精确的减法
     * @Author: whq
     * @Date: 2021/8/28 17:40
     */
    public static BigDecimal sub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2);
    }

    /**
     * @Description: 精确的减法
     * @Author: whq
     * @Date: 2021/8/28 17:43
     */
    public static String sub(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * @Description: 精确的乘法
     * @Author: whq
     * @Date: 2021/8/28 17:46
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * @Description: 精确的乘法
     * @Author: whq
     * @Date: 2021/8/28 17:49
     */
    public static BigDecimal mul(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2);
    }

    /**
     * @Description: 精确的乘法
     * @Author: whq
     * @Date: 2021/8/28 17:54
     */
    public static double mul(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }

        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @Description: 精确的除法
     * @Author: whq
     * @Date: 2021/8/28 17:57
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * @Description: 精确的除法
     * @Author: whq
     * @Date: 2021/8/28 17:57
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /** 
     * @Description: 精确的乘法 
     * @Author: whq
     * @Date: 2021/8/28 18:04
     */
    public static String div(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * @Description: 精确的四舍五入方法
     * @Author: whq
     * @Date: 2021/8/28 18:07
     */
    public static double round(double v1,int scale){
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        return b1.setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @Description: 精确的四舍五入方法
     * @Author: whq
     * @Date: 2021/8/28 18:07
     */
    public static String round(String v1,int scale){
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        return b1.setScale(scale,BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * @Description: 取余数
     * @Author: whq
     * @Date: 2021/8/28 18:11
     */
    public static double remainder(double v1,double v2,int scale){
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.remainder(b2).setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @Description: 比较大小方法
     * @Author: whq
     * @Date: 2021/8/28 18:18
     */
    public static boolean compare(String v1,String v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int compareResult = b1.compareTo(b2);
        boolean result;
        if (compareResult >= 0){
            result = true;
        }else {
            result = false;
        }
        return result;
    }
}
