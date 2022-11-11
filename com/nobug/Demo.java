
import com.sun.management.OperatingSystemMXBean;
import component.*;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.util.Properties;

public class Demo {

    public static void main(String[] args) {
        WFrame frame = WComponentCache.createWFrame("检测电脑信息");
        WPanel panel = WComponentCache.createWPanel("主面板");
        frame.add(panel);

        WButton button = WComponentCache.createWButton("开始检测", new WComponent() {
            @Override
            public void run() {
                String osUser = System.getProperty("user.name");

                Properties props=System.getProperties(); //获得系统属性集
                String osName = props.getProperty("os.name"); //操作系统名称
                String osArch = props.getProperty("os.arch"); //操作系统构架
                String osVersion = props.getProperty("os.version"); //操作系统版本
                double v = memoryLoad();//当前内存占用

                System.out.println(osUser);
                System.out.println(osArch);
                System.out.println(osName);
                System.out.println(osVersion);

                WComponentCache.labelMap.get("1:").setText("1:登录用户为："+osUser);
                WComponentCache.labelMap.get("2:").setText("2:操作系统名称为："+osName);
                WComponentCache.labelMap.get("3:").setText("3:操作系统构架为："+osArch);
                WComponentCache.labelMap.get("4:").setText("4:操作系统版本为："+osVersion);
                WComponentCache.labelMap.get("5:").setText("5:当前内存占用为："+v+"%");
                Dimension dim = frame.getToolkit().getScreenSize();//获取桌面像素
                WComponentCache.labelMap.get("6:").setText("6:显示器宽度为："+ dim.width);
                WComponentCache.labelMap.get("7:").setText("7:显示器高度为："+ dim.height);


            }
        });

        WLabel wLabel = WComponentCache.createWLabel("电脑信息检测工具",30);

        WLabel wLabel11 = WComponentCache.createWLabel("检测报告如下：",25);
        wLabel11.setS(wLabel);


        WLabel wLabel1 = WComponentCache.createWLabel("1:",25,Color.RED);
        WLabel wLabel2 = WComponentCache.createWLabel("2:",25,Color.RED);
        WLabel wLabel3 = WComponentCache.createWLabel("3:",25,Color.RED);
        WLabel wLabel4 = WComponentCache.createWLabel("4:",25,Color.RED);
        WLabel wLabel5 = WComponentCache.createWLabel("5:",25,Color.RED);
        WLabel wLabel6 = WComponentCache.createWLabel("6:",25,Color.RED);
        WLabel wLabel7 = WComponentCache.createWLabel("7:",25,Color.RED);
        wLabel1.setS(wLabel11);
        wLabel2.setS(wLabel1);
        wLabel3.setS(wLabel2);
        wLabel4.setS(wLabel3);
        wLabel5.setS(wLabel4);
        wLabel6.setS(wLabel5);
        wLabel7.setS(wLabel6);
        panel.add(wLabel1);
        panel.add(wLabel2);
        panel.add(wLabel3);
        panel.add(wLabel4);
        panel.add(wLabel5);
        panel.add(wLabel6);
        panel.add(wLabel7);

        panel.add(button);
        panel.add(wLabel);
        panel.add(wLabel11);

        WTextField wTextField = WComponentCache.createWTextField("a", "321312312");
        wTextField.setS(wLabel7);


        frame.repaint();

    }

    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public static double memoryLoad() {
        double totalPhysicalMemorySize = osmxb.getTotalPhysicalMemorySize();
        double freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        double value = freePhysicalMemorySize/totalPhysicalMemorySize;
        int percentMemoryLoad = (int) ((1-value)*10000);
        return percentMemoryLoad*0.01;
    }
}
