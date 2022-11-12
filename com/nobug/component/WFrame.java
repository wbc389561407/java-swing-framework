package component;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class WFrame extends ComponentBase{


    private static final Map<String, WFrame> FRAME_MAP = new HashMap<>();


    private JFrame getJFrame() {
        return getObj(JFrame.class);
    }

    private WFrame(String title){
        super(WFrame.class);
        FRAME_MAP.put(title,this);
    }



    public static WFrame newInstance() {
        return newInstance("默认窗口");
    }

    public static WFrame newInstance(String title) {
        WFrame wFrame = new WFrame(title);
        JFrame jFrame = wFrame.getJFrame();
        jFrame.setTitle(title);
        jFrame.setVisible(true);//设置界面的可见性
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭时的默认操作
        jFrame.setBounds(WINDOWS_WIDTH/4,WINDOWS_HEIGHT/4,WINDOWS_WIDTH/2,WINDOWS_HEIGHT/2);
        return wFrame;
    }

    public static WFrame getInstance(String title) {
        return FRAME_MAP.get(title);
    }


    public WPanel createWPanel(String key) {
        WPanel wPanel = WPanel.newInstance(key);
        wPanel.bindParent(this.getObj());
        return wPanel;
    }


}
