package util;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-13
 */
public class SystemUtil {
    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();


    /**
     * 获取电脑总内存大小
     * @return
     */
    public static long getTotalMemorySize() {
        double totalPhysicalMemorySize = osmxb.getTotalPhysicalMemorySize();
        return Math.round(totalPhysicalMemorySize / 1024 / 1024 / 1024);
    }

    /**
     * 获取运行占用 内存 单位 G
     * @return
     */
    public static String getNoFreePhysicalMemorySize() {
        return BigDecimalUtil.getInstance(String.valueOf(getTotalMemorySize())).subtract(getFreePhysicalMemorySize()).getStringVal(2);

    }


    /**
     * 当前空闲内存 单位 G
     * @return
     */
    public static String getFreePhysicalMemorySize() {
        double totalPhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        return  BigDecimalUtil.getInstance(totalPhysicalMemorySize).divide(1024)
                .divide(1024).divide(1024).getStringVal(2);
    }


    /**
     * 内存占用比例
     * @return
     */
    public static String memoryLoad() {
        double totalPhysicalMemorySize = osmxb.getTotalPhysicalMemorySize();
        double freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        return BigDecimalUtil.getInstance(totalPhysicalMemorySize).subtract(freePhysicalMemorySize)
                .divide(totalPhysicalMemorySize).multiply(100).getStringVal(2);
    }
}
