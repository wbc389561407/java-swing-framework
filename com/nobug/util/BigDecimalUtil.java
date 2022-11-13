package util;

import java.math.BigDecimal;

/**
 * @author wangbingchen
 * @Description
 * @create 2021-08-10 15:01
 */
public class BigDecimalUtil {


    //计算默认精度
    private Integer DEFAULT_DIV_SCALE_100 = 100;

    //计算结果存储
    private BigDecimal bigDecimal;

    private BigDecimalUtil(){}

    //构造方法
    private BigDecimalUtil(String val){
        this.bigDecimal = new BigDecimal(val);
    }

    //对外构建方法
    public static BigDecimalUtil getInstance(String val){
        return new BigDecimalUtil(val);
    }
    //对外构建方法
    public static BigDecimalUtil getInstance(double val){
        return new BigDecimalUtil(Double.toString(val));
    }

    //设置除数精度
    public BigDecimalUtil setScale(Integer scale){
        if (scale <= 0) {
            throw new IllegalArgumentException("设置的精度不能小于等于0");
        }
        this.DEFAULT_DIV_SCALE_100 = scale;
        return this;
    }

    //除法默认 保留小数点100位
    public BigDecimalUtil divide(double val) {
        this.bigDecimal = this.bigDecimal.divide(BigDecimal.valueOf(val), DEFAULT_DIV_SCALE_100, BigDecimal.ROUND_HALF_EVEN);
        return this;
    }

    //加法 保留小数点100位
    public BigDecimalUtil add(double val) {
        this.bigDecimal = this.bigDecimal.add(BigDecimal.valueOf(val));
        return this;
    }

    //加法 保留小数点100位
    public BigDecimalUtil add(String val) {
        this.bigDecimal = this.bigDecimal.add(new BigDecimal(val));
        return this;
    }

    //减法 保留小数点100位
    public BigDecimalUtil subtract(double val) {
        this.bigDecimal = this.bigDecimal.subtract(BigDecimal.valueOf(val));
        return this;
    }

    //减法 保留小数点100位
    public BigDecimalUtil subtract(String val) {
        this.bigDecimal = this.bigDecimal.subtract(new BigDecimal(val));
        return this;
    }

    //乘法 保留小数点100位
    public BigDecimalUtil multiply(double val) {
        this.bigDecimal = this.bigDecimal.multiply(BigDecimal.valueOf(val));
        return this;
    }

    //乘法 保留小数点100位
    public BigDecimalUtil multiply(String val) {
        this.bigDecimal = this.bigDecimal.multiply(new BigDecimal(val));
        return this;
    }




    //取为 String 类型的结果
    public String getStringVal(){
        return this.bigDecimal.toString();
    }

    //取为 String 类型的结果 可以指定 保留的小数点
    public String getStringVal(int scale){
        if (scale == 0) {
            throw new IllegalArgumentException("除数不能为0");
        }
        return this.bigDecimal.divide(BigDecimal.valueOf(1), scale, BigDecimal.ROUND_HALF_EVEN).toString();
    }

    //取为 Double 类型的结果
    public Double getDoubleVal(){
        return this.bigDecimal.doubleValue();
    }
    //取为 Double 类型的结果 可以指定 保留的小数点
    public Double getDoubleVal(int scale){
        if (scale == 0) {
            throw new IllegalArgumentException("除数不能为0");
        }
        return this.bigDecimal.divide(BigDecimal.valueOf(1), scale, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }

    //取为 Integer 类型的结果
    public Integer getIntegerVal(){
        return this.bigDecimal.intValue();
    }
    //取为 Float 类型的结果
    public Float getFloatValue(){
        return this.bigDecimal.floatValue();
    }
    //取为 Long 类型的结果
    public Long getLongValue(){
        return this.bigDecimal.longValue();
    }

    public static void main(String[] args) {
        // 计算 100 除以 3 并且保留 2位小数 得到 Double 结果
        Double doubleVal = BigDecimalUtil.getInstance("100").divide(3).getDoubleVal(2);
        System.out.println(doubleVal);
        // 计算 800 除以 6 并且保留 4位小数 得到 String 结果
        String stringVal = BigDecimalUtil.getInstance(12.31).divide(6).getStringVal(4);
        System.out.println(stringVal);

        //详细说明 使用 BigDecimalUtil.getInstance() 初始化计算数字，可传 String参数或者 double 参数
        // 接着调用
        // 加 add()
        // 减 subtract()
        // 乘 multiply()
        // 除 divide()
        // 最后调用 getDoubleVal() getStringVal() getIntegerVal() 等方法 获取对应数据类型结果
        //其中 getStringVal() 和 getDoubleVal() 可传 int 参数 为保留的小数位数
        // setScale() 方法可以设置保留指定小数位数 后继续计算
        //

        System.out.println(BigDecimalUtil.getInstance(800).divide(3).multiply(3).getStringVal(2));

    }

}