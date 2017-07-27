package utils;

import java.math.BigDecimal;

/**
 * Author joker
 * Created on 2017/7/26.
 * Description
 */
public class MathUtils {
    public static double add(double a, double b) {
        BigDecimal a2 = new BigDecimal(Double.toString(a));
        BigDecimal b2 = new BigDecimal(Double.toString(b));
        return a2.add(b2).doubleValue();
    }

    public static double sub(double a,double b){
        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal(Double.toString(b));
        return a1.subtract(b1).doubleValue();
    }

    public static double multiply(double a,double b){
        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal(Double.toString(b));
        return a1.multiply(b1).doubleValue();
    }

    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;
    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param a 被除数
     * @param b 除数
     * @return 两个参数的商
     */
    public static double div(double a,double b){
        return div(a,b,DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param a 被除数
     * @param b 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double a,double b,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal b1 = new BigDecimal(Double.toString(b));
        return a1.divide(b1,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     * @param a 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double a,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal a1 = new BigDecimal(Double.toString(a));
        BigDecimal one = new BigDecimal("1");
        return a1.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
