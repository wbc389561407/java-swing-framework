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
public class WPanel extends ComponentBase{

    private static final Map<String, WPanel> panelMap = new HashMap<>();


    public WPanel(String key){
        super(JPanel.class);
        panelMap.put(key,this);
    }

    public static WPanel newInstance(String key) {
        return new WPanel(key);
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
        WButton wButton = WButton.newInstance(key, title);
        wButton.bindParent(this.getObj());
        return wButton;
    }


    /**
     * 创建一个带监听的 绑定执行事件的按钮
     * @param title
     * @return
     */
    public WButton createWButton(String key, String title, WComponent wComponent) {
        WButton wButton = WButton.newInstance(key, title, wComponent);
        wButton.bindParent(this.getObj());
        return wButton;
    }


    public WLabel createWLabel(String key, String value) {
        WLabel wLabel = WLabel.newInstance(key, value);
        wLabel.bindParent(this.getObj());
        return wLabel;
    }

    public WLabel createWLabel(String key, String value, int size) {
        WLabel wLabel = WLabel.newInstance(key, value, size);
        wLabel.bindParent(this.getObj());
        return wLabel;
    }

    public WLabel createWLabel(String key, String value, int size, Color color) {
        WLabel wLabel = WLabel.newInstance(key, value, size, color);
        wLabel.bindParent(this.getObj());
        return wLabel;
    }


}
