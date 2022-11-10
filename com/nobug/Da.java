package com.test.win;

import javax.swing.*;
import java.awt.*;

public class Da {
    public static void main(String[] args) {
        WFrame wFrame = JComponentPool.createWFrame("wbc");
        WPanel wPanel = JComponentPool.createWPanel("主面板");
        wFrame.add(wPanel);
        WPanel wPanel1 = JComponentPool.createWPanel("主面板1");
        WButton button = JComponentPool.createWButton("这是一个按钮",new WButtonRun() {
            @Override
            public void run() {
                System.out.println("点击触发");
                wFrame.remove(wPanel);
                wFrame.add(wPanel1);
                wFrame.revalidate();
            }
        });

        WButton button1 = JComponentPool.createWButton("点击",new WButtonRun() {
            @Override
            public void run() {
                System.out.println("点击触发");
                WFrame wbc = pool.frameMap.get("wbc");
                wbc.setBounds(500,500,200,200);
            }
        });
        button.setBounds(20,20,150,20);
        wPanel.add(button);
        button1.setBounds(180,20,150,20);
        wPanel.add(button1);
//
//        wPanel.add(button);
//

//
//        wPanel1.add(button1);


        WTextField wTextField = JComponentPool.createWTextField("name","dasdasdas");
        wTextField.setBounds(500,500,200,20);
        wPanel.add(wTextField);

//        WTextField wTextField1 = JComponentPool.createWTextField("name","fsddddddd");
//        wTextField1.setBounds(500,530,200,20);
//        wPanel.add(wTextField1);


        wFrame.repaint();

    }
}
