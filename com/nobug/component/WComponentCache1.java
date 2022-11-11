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
public interface WComponentCache1 {


    //显示器的宽
    int WIDTH = getWidth();
    int WINDOWS_WIDTH = getWidth();

    static int getWidth() {
        return getDimension().width;
    }

    //显示器的高
    int HEIGHT = getHeight();
    int WINDOWS_HEIGHT = getHeight();

    static int getHeight() {
        return getDimension().height;
    }

    static Dimension getDimension() {
        return Toolkit.getDefaultToolkit().getScreenSize();//获取桌面像素
    }

    WActionListener listener = new WActionListener();

    Map<String, WButton> buttonMap = new HashMap<>();

    Map<String, WFrame> frameMap = new HashMap<>();

    Map<String, WPanel> panelMap = new HashMap<>();

    Map<String, WTextField> textFieldMap = new HashMap<>();

    Map<String, WLabel> labelMap = new HashMap<>();


    /**
     * 创建一个带监听的按钮
     * @param title
     * @return
     */
    static WButton createWButton(String title) {
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
     * @param wComponent
     * @return
     */
    static WButton createWButton(String title, WComponent wComponent) {
        return createWButton(title).bindClick(wComponent);
    }




    static WPanel createWPanel(String title) {
        WPanel wPanel = new WPanel();
        panelMap.put(title,wPanel);

        return wPanel;
    }

    static WTextField createWTextField(String name, String value) {
        WTextField wTextField = new WTextField(value);
        int width = WIDTH/2;
        int height = HEIGHT/2;
        wTextField.setBounds(width/5,height/12,width/2,height/2);
        textFieldMap.put(name,wTextField);
        wTextField.addActionListener(listener);
        return wTextField;
    }


    static WLabel createWLabel(String title, int size) {
        return createWLabel(title,size,Color.black);
    }

    static WLabel createWLabel(String title, int size, Color color) {
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


    static WFrame createWFrame(String title) {
        WFrame wFrame = new WFrame(title);
        wFrame.setBounds(WIDTH/4,HEIGHT/4,WIDTH/2,HEIGHT/2);
        frameMap.put(title,wFrame);
        return wFrame;
    }

}
