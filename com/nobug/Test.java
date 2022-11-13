import com.sun.management.OperatingSystemMXBean;
import component.*;
import util.BigDecimalUtil;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.util.Properties;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-13
 */
public class Test {
    public static void main(String[] args) {
        WFrame wFrame = WFrame.newInstance("电脑基本信息检测");
        WPanel panel = wFrame.createWPanel("Panel");
        WLabel wLabel = panel.createWLabel("key1", "点击按钮检测一下你的电脑信息吧！");
        WTextField wTextField = panel.createWTextField("TextField1", "", 20);
        WButton wButton = panel.createWButton("Button", "清空输入框");
        WLabel wLabel1 = panel.createWLabel("wLabel1");
        WLabel wLabel2 = panel.createWLabel("wLabel2");
        WLabel wLabel3 = panel.createWLabel("wLabel3");
        WLabel wLabel4 = panel.createWLabel("wLabel4");
        WLabel wLabel5 = panel.createWLabel("wLabel5");
        WLabel wLabel6 = panel.createWLabel("wLabel6");
        WLabel wLabel7 = panel.createWLabel("wLabel7");
        WLabel wLabel8 = panel.createWLabel("wLabel8");
        wButton.bindClick(new WComponent() {
            @Override
            public void run() {
                String osUser = System.getProperty("user.name");
                Properties props=System.getProperties(); //获得系统属性集
                String osName = props.getProperty("os.name"); //操作系统名称
                String osArch = props.getProperty("os.arch"); //操作系统构架
                String osVersion = props.getProperty("os.version"); //操作系统版本
                WLabel.getInstance("wLabel1").setValue("当前登录用户："+osUser);
                WLabel.getInstance("wLabel2").setValue("操作系统名称："+osName);
                WLabel.getInstance("wLabel3").setValue("操作系统构架："+osArch);
                WLabel.getInstance("wLabel4").setValue("操作系统版本："+osVersion);
                WLabel.getInstance("wLabel5").setValue("当前内存占用："+memoryLoad()+"%");
                long totalMemorySize = getTotalMemorySize();
                WLabel.getInstance("wLabel6").setValue("您的运行内存为："+totalMemorySize+"G");
                WLabel.getInstance("wLabel7").setValue("当前空闲内存为："+getFreePhysicalMemorySize()+"G");
                WLabel.getInstance("wLabel8").setValue("当前使用内存为："+getNoFreePhysicalMemorySize()+"G");
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//获取桌面像素

                String value = "屏幕宽"+dim.getWidth()+"     屏幕高"+dim.getHeight();
                wTextField.setValue(value);
            }
        });
    }

    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public static long getTotalMemorySize() {
        double totalPhysicalMemorySize = osmxb.getTotalPhysicalMemorySize();
        return Math.round(totalPhysicalMemorySize / 1024 / 1024 / 1024);
    }


    public static String getNoFreePhysicalMemorySize() {
        return BigDecimalUtil.getInstance(String.valueOf(getTotalMemorySize())).subtract(getFreePhysicalMemorySize()).getStringVal(2);

    }


    public static String getFreePhysicalMemorySize() {
        double totalPhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        return  BigDecimalUtil.getInstance(totalPhysicalMemorySize).divide(1024)
                .divide(1024).divide(1024).getStringVal(2);
    }


    public static String memoryLoad() {
        double totalPhysicalMemorySize = osmxb.getTotalPhysicalMemorySize();
        double freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        return BigDecimalUtil.getInstance(totalPhysicalMemorySize).subtract(freePhysicalMemorySize)
                .divide(totalPhysicalMemorySize).multiply(100).getStringVal(2);
    }
}
