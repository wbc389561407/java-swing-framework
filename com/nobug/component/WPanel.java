package component;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class WPanel extends ComponentBase{


    /**
     * WPanel 组件库
     */
    private static final Map<String, WPanel> PANEL_MAP = new HashMap<>();




    /**
     * 新建对象
     * @param key WPanel 组件唯一 id
     * @return 新 WPanel 对象
     */
    public static WPanel newInstance(String key) {
        return new WPanel(key);
    }


    /**
     * 从 WPanel 组件库中获取对象
     * @param key WPanel 组件唯一 id
     * @return WPanel 对象
     */
    public static WPanel getInstance(String key) {
        return PANEL_MAP.get(key);
    }


    /**
     * 创建一个新按钮，显示在此面板上
     * @param key WButton 组件唯一 id
     * @param title 按钮名称
     * @return 新 WButton 对象
     */
    public WButton createWButton(String key,String title) {
        WButton wButton = WButton.newInstance(key, title);
        wButton.bindParent(this);
        return wButton;
    }


    /**
     * 创建一个新按钮，显示在此面板上
     * @param key WButton 组件唯一 id
     * @param title 按钮名称
     * @param wComponent 触发事件
     * @return 新 WButton 对象
     */
    public WButton createWButton(String key, String title, WComponent wComponent) {
        WButton wButton = WButton.newInstance(key, title, wComponent);
        wButton.bindParent(this);
        return wButton;
    }


    /**
     * 创建一个区域显示文字，并且绑定到当前面板上
     * @param key WLabel 库唯一 id
     * @return 新 WLabel 对象
     */
    public WLabel createWLabel(String key) {
        WLabel wLabel = WLabel.newInstance(key);
        wLabel.bindParent(this);
        return wLabel;
    }


    /**
     * 创建一个区域显示文字，并且绑定到当前面板上
     * @param key WLabel 库唯一 id
     * @param value 显示内容
     * @return 新 WLabel 对象
     */
    public WLabel createWLabel(String key, String value) {
        WLabel wLabel = WLabel.newInstance(key, value);
        wLabel.bindParent(this);
        return wLabel;
    }


    /**
     * 创建一个区域显示文字，并且绑定到当前面板上
     * @param key WLabel 库唯一 id
     * @param value 显示内容
     * @param size 字体大小
     * @return 新 WLabel 对象
     */
    public WLabel createWLabel(String key, String value, int size) {
        WLabel wLabel = WLabel.newInstance(key, value, size);
        wLabel.bindParent(this);
        return wLabel;
    }

    /**
     * 创建一个区域显示文字，并且绑定到当前面板上
     * @param key WLabel 库唯一 id
     * @param value 显示内容
     * @param size 字体大小
     * @param color 字体颜色
     * @return 新 WLabel 对象
     */
    public WLabel createWLabel(String key, String value, int size, Color color) {
        WLabel wLabel = WLabel.newInstance(key, value, size, color);
        wLabel.bindParent(this);
        return wLabel;
    }


    public void bindParent(ComponentBase container) {
        container.getObj().add(this.getObj());
    }


    private WPanel(String key){
        super(new WPanel());
        PANEL_MAP.put(key,this);
    }

    private WPanel() {

    }

    public WTextField createWTextField(String key) {
        WTextField wTextField = WTextField.newInstance(key);
        wTextField.bindParent(this);
        return wTextField;
    }


    public WTextField createWTextField(String key, int size) {
        WTextField wTextField = WTextField.newInstance(key, size);
        wTextField.bindParent(this);
        return wTextField;
    }


    public WTextField createWTextField(String key, String value, int size) {
        WTextField wTextField = WTextField.newInstance(key, value, size);
        wTextField.bindParent(this);
        return wTextField;
    }


}
