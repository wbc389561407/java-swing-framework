
import com.sun.management.OperatingSystemMXBean;
import component.*;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.util.Properties;

public class Demo004 {

    public static void main(String[] args) {
        WFrame frame = WFrame.newInstance("检测电脑信息");
        WPanel panel = frame.createWPanel("主面板");

        WLabel wLabel = panel.createWLabel("电脑信息检测工具", "电脑信息检测工具", 30);
        WLabel wLabelb = wLabel.createS("检测报告如下：","检测报告如下：", 25);
        WLabel wLabel1 = wLabelb.createS("wLabel1","",25,Color.RED);
        WLabel wLabel2 = wLabel1.createS("wLabel2","",25,Color.RED);
        WLabel wLabel3 = wLabel2.createS("wLabel3","",25,Color.RED);
        WLabel wLabel4 = wLabel3.createS("wLabel4","",25,Color.RED);
        WLabel wLabel5 = wLabel4.createS("wLabel5","",25,Color.RED);
        WLabel wLabel6 = wLabel5.createS("wLabel6","",25,Color.RED);
        WLabel wLabel7 = wLabel6.createS("wLabel7","",25,Color.RED);


        WButton wButton = panel.createWButton("bnt1", "检测系统数据", new WComponent() {
            @Override
            public void run() {
                String osUser = System.getProperty("user.name");

                Properties props = System.getProperties(); //获得系统属性集
                String osName = props.getProperty("os.name"); //操作系统名称
                String osArch = props.getProperty("os.arch"); //操作系统构架
                String osVersion = props.getProperty("os.version"); //操作系统版本
                double v = memoryLoad();//当前内存占用

                WLabel.getInstance("wLabel1").setText("登录用户为：" + osUser);
                WLabel.getInstance("wLabel2").setText("操作系统名称为：" + osName);
                WLabel.getInstance("wLabel3").setText("操作系统构架为：" + osArch);
                WLabel.getInstance("wLabel4").setText("操作系统版本为：" + osVersion);
                WLabel.getInstance("wLabel5").setText("当前内存占用为：" + v + "%");
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//获取桌面像素
                WLabel.getInstance("wLabel6").setText("显示器宽度为：" + dim.width);
                WLabel.getInstance("wLabel7").setText("显示器高度为：" + dim.height);

            }
        });

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
