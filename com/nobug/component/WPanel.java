package component;

import javax.swing.*;
import java.awt.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class WPanel extends JPanel implements WComponent{

    private Container parent;


    public WPanel(){
        super(null);
    }

    public static WPanel newInstance(String key) {
        WPanel wPanel = new WPanel();
        panelMap.put(key,wPanel);
        return wPanel;
    }

    public static WPanel getInstance(String key) {
        return panelMap.get(key);
    }


    /**
     * 创建一个带监听的按钮
     * @param title
     * @return
     */
    public WButton createWButton(String key,String title) {
        WButton wButton = WButton.newInstance(key,title);
        wButton.bindParent(this);
        return wButton;
    }


    /**
     * 创建一个带监听的 绑定执行事件的按钮
     * @param title
     * @return
     */
    public WButton createWButton(String key,String title, WComponent wComponent) {
        WButton wButton = WButton.newInstance(key, title, wComponent);
        wButton.bindParent(this);
        return wButton;
    }


    public WLabel createWLabel(String key, String value) {
        WLabel wLabel = WLabel.newInstance(key, value);
        wLabel.bindParent(this);
        return wLabel;
    }

    public WLabel createWLabel(String key, String value, int size) {
        WLabel wLabel = WLabel.newInstance(key, value, size);
        wLabel.bindParent(this);
        return wLabel;
    }

    public WLabel createWLabel(String key, String value, int size, Color color) {
        WLabel wLabel = WLabel.newInstance(key, value, size, color);
        wLabel.bindParent(this);
        return wLabel;
    }


    @Override
    public void run() {

    }

    public void bindParent(Container container) {
        parent = container;
        container.add(this);
        container.revalidate();
    }

    public void remove() {
        parent.remove(this);
        parent.repaint();
    }


}
