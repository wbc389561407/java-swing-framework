package com.test.win;

import javax.swing.*;
import java.awt.*;



/**
 * 运行类
 * @author wangbingchen
 * @since 2022-11-10
 **/
public class LocalRun extends JFrame {

    //运行窗口大小 根据显示器大小 取其一半
    private int WIDTH;
    private int HEIGHT;

    JPanel mainPan;

    public LocalRun(String title){
        setTitle(title);
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize(); 	//获取桌面像素
        this.WIDTH = dim.width/2;
        this.HEIGHT = dim.height/2;
        setBounds(WIDTH/2,HEIGHT/2,WIDTH,HEIGHT);


        mainPan= new JPanel();

        mainPan.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(mainPan);
        WButton wButton1 = JComponentPool.createWButton("检测本机信息").bindClick(new WButtonRun() {
            @Override
            public void run() {
                WButton wButton1 = pool.buttonMap.get("检测本机信息");
                wButton1.setText("检测本机信息");
                wButton1.setBounds(0,0,0,0);
            }
        });

        WButton wButton = JComponentPool.createWButton("修改第一个按钮名称", new WButtonRun() {
            @Override
            public void run() {
                WButton wButton1 = pool.buttonMap.get("检测本机信息");
                wButton1.setBounds(500,300,100,20);
                wButton1.setText("asdasda");
            }
        });

        mainPan.add(wButton1);
        mainPan.add(wButton);
//        jButton.setBounds(1000,1000,10,10);


    }



    public static void main(String[] args) {
        LocalRun localRun = new LocalRun("本地检测工具");
        localRun.setVisible(true);//设置界面的可见性
        localRun.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗口关闭时的默认操作

    }


}
