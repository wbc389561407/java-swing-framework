package com.test.win;

import javax.swing.*;

public class WFrame extends JFrame{



    public WFrame(){
        new WFrame("默认窗口");
    }

    public WFrame(String title){
        setTitle(title);
        setVisible(true);//设置界面的可见性
        setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗口关闭时的默认操作
    }
}
