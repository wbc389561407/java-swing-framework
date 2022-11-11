import component.*;

import javax.swing.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class Demo002 {

    public static void main(String[] args) {
        WFrame frame = WFrame.newInstance("测试二窗口");
        WPanel wPanel = WPanel.newInstance("p");
        WButton wButton1 = WButton.newInstance("btn11", "独立创建按钮");
        WLabel label1 = WLabel.newInstance("label1", "错误报告：");
        wPanel.bindParent(frame);
        wButton1.bindParent(wPanel);
        label1.bindParent(wPanel);



        WPanel wPanel1 = WPanel.newInstance("pp");
        WButton wButton = wPanel1.createWButton("btn2", "切换到第一个面板");
        wButton.bindClick(new WComponent() {
            @Override
            public void run() {
                wPanel1.remove();
                wPanel.bindParent(frame);
            }
        });

        wButton1.bindClick(new WComponent() {
            @Override
            public void run() {
                wPanel.remove();
                wPanel1.bindParent(frame);
            }
        });


    }
}
