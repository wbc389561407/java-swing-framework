package com.test.win;

import javax.swing.*;
import java.awt.*;

public class WFrame extends JFrame{

    //运行窗口大小 根据显示器大小 取其一半
    private int WIDTH;
    private int HEIGHT;

    public WFrame(){
        new WFrame("默认窗口");
    }

    public WFrame(String title){
        setTitle(title);
        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize(); 	//获取桌面像素
        this.WIDTH = dim.width/2;
        this.HEIGHT = dim.height/2;
        setBounds(WIDTH/2,HEIGHT/2,WIDTH,HEIGHT);
        setVisible(true);//设置界面的可见性
        setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗口关闭时的默认操作
    }
}
