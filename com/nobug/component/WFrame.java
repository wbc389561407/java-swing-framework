package component;

import javax.swing.*;


/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class WFrame extends JFrame implements WComponent{


    private WFrame(){
        new WFrame("默认窗口");
    }

    public WFrame(String title){
        setTitle(title);
        setVisible(true);//设置界面的可见性
        setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗口关闭时的默认操作
    }


    public static WFrame getInstance(String title) {
        return frameMap.get(title);
    }

    public static WFrame newInstance(String title) {
        WFrame wFrame = new WFrame(title);
        wFrame.setBounds(WINDOWS_WIDTH/4,WINDOWS_HEIGHT/4,WINDOWS_WIDTH/2,WINDOWS_HEIGHT/2);
        frameMap.put(title,wFrame);
        return wFrame;
    }

    public WPanel createWPanel(String key) {
        WPanel wPanel = WPanel.newInstance(key);
        add(wPanel);
        wPanel.bindParent(this);
        return wPanel;
    }

    @Override
    public void run() {

    }

}
