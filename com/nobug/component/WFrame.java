package component;

import javax.swing.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
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
