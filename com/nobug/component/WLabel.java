package component;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class WLabel extends ComponentBase {


    private final static Map<String, WLabel> LABEL_MAP = new HashMap<>();


    private WLabel(String key) {
        super(JLabel.class);
        LABEL_MAP.put(key,this);
    }

    public static WLabel newInstance(String key, String title) {
        return newInstance(key,title,20,Color.BLACK);
    }

    public static WLabel newInstance(String key, int size) {
        return newInstance(key,"",size,Color.BLACK);
    }

    public static WLabel newInstance(String key, String title, int size) {
        return newInstance(key,title,size,Color.BLACK);
    }

    public static WLabel newInstance(String key, String title, int size, Color color) {
        WLabel wLabel = new WLabel(key);
        JLabel obj = wLabel.getJLabel();
        obj.setText(title);
        int width = WINDOWS_WIDTH/2;
        int height = WINDOWS_HEIGHT/2;
        obj.setBounds(width/5,height/24,width,25+size);
        obj.setFont(new Font(null, 1, 20+size));
        obj.setForeground(color);
        return wLabel;
    }

    private JLabel getJLabel() {
        return getObj(JLabel.class);
    }


    public static WLabel getInstance(String key) {
        return LABEL_MAP.get(key);
    }


    public WLabel createS(String key, String title) {
        return createS(key, title, 20, Color.BLACK);
    }

    public WLabel createS(String key, int size) {
        return createS(key, "", size, Color.BLACK);
    }

    public WLabel createS(String key, String title, int size)  {
        return createS(key, title, size, Color.BLACK);
    }

    public WLabel createS(String key, String title, int size, Color color)  {
        WLabel wLabel = newInstance(key, title, size, color);
        wLabel.setAtS(this);
        wLabel.bindParent(this.parent);
        return wLabel;
    }


    public void clearText() {
        getJLabel().setText("");
    }


}
