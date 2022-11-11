package component;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;



/**
 * 组件库 所有组件都存在这里
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class WComponentCache{

    //显示器的宽
    public static int WIDTH;
    //显示器的高
    public static int HEIGHT;

    public static WActionListener listener = new WActionListener();

    public static Map<String, WButton> buttonMap = new HashMap<>();

    public static Map<String, WFrame> frameMap = new HashMap<>();

    public static Map<String, WPanel> panelMap = new HashMap<>();

    public static Map<String, WTextField> textFieldMap = new HashMap<>();

    public static Map<String, WLabel> labelMap = new HashMap<>();


    /**
     * 创建一个带监听的按钮
     * @param title
     * @return
     */
    public static WButton createWButton(String title) {
        WButton wButton = new WButton(title);
        int width = WIDTH/2;
        int height = HEIGHT/2;
        wButton.setBounds(width/5,height*3/4,width/2,height/8);
        wButton.addActionListener(listener);
        buttonMap.put(title,wButton);
        return wButton;
    }


    /**
     * 创建一个带监听的按钮 和 绑定 监听事件
     * @param title
     * @param wButtonRun
     * @return
     */
    public static WButton createWButton(String title, WButtonRun wButtonRun) {
        return createWButton(title).bindClick(wButtonRun);
    }


    public static WFrame createWFrame(String title) {
        WFrame wFrame = new WFrame(title);
        Dimension dim = wFrame.getToolkit().getScreenSize();//获取桌面像素
        WIDTH = dim.width;
        HEIGHT = dim.height;
        wFrame.setBounds(WIDTH/4,HEIGHT/4,WIDTH/2,HEIGHT/2);
        frameMap.put(title,wFrame);
        return wFrame;
    }

    public static WPanel createWPanel(String title) {
        WPanel wPanel = new WPanel();
        panelMap.put(title,wPanel);
        return wPanel;
    }

    public static WTextField createWTextField(String name, String value) {
        WTextField wTextField = new WTextField(value);
        int width = WIDTH/2;
        int height = HEIGHT/2;
        wTextField.setBounds(width/5,height/12,width/2,height/2);
        textFieldMap.put(name,wTextField);
        return wTextField;
    }


    public static WLabel createWLabel(String title, int size) {
        return createWLabel(title,size,Color.black);
    }

    public static WLabel createWLabel(String title, int size, Color color) {
        WLabel wLabel = new WLabel();
        wLabel.setText(title);
        int width = WIDTH/2;
        int height = HEIGHT/2;
        wLabel.setBounds(width/5,height/24,width/2,size);
        wLabel.setFont(new Font(null, 1, size));
        wLabel.setForeground(color);
        labelMap.put(title,wLabel);
        return wLabel;
    }
}
