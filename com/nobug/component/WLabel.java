package component;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class WLabel extends ComponentBase {

    //所有生成的组件
    private final static Map<String, WLabel> LABEL_MAP = new HashMap<>();


    /**
     * 构造方法
     * @param key
     */
    private WLabel(String key) {
        super(new WLabel());
        LABEL_MAP.put(key,this);
    }

    private WLabel() {

    }

    /**
     * 新建一个对象
     * @param key 组件唯一 id
     * @return WLabel对象
     */
    public static WLabel newInstance(String key) {
        return newInstance(key,"",20,Color.BLACK);
    }


    /**
     * 新建一个对象
     * @param key 组件唯一 id
     * @param title 显示内容
     * @return WLabel对象
     */
    public static WLabel newInstance(String key, String title) {
        return newInstance(key,title,20,Color.BLACK);
    }

    /**
     * 新建一个对象
     * @param key 组件唯一 id
     * @param size 字体大小
     * @return WLabel对象
     */
    public static WLabel newInstance(String key, int size) {
        return newInstance(key,"",size,Color.BLACK);
    }

    /**
     * 新建一个对象
     * @param key 组件唯一 id
     * @param title 显示内容
     * @param size 字体大小
     * @return WLabel对象
     */
    public static WLabel newInstance(String key, String title, int size) {
        return newInstance(key,title,size,Color.BLACK);
    }

    /**
     *
     * @param key 组件唯一 id
     * @param title 显示内容
     * @param size 字体大小
     * @param color 字体颜色
     * @return WLabel对象
     */
    public static WLabel newInstance(String key, String title, int size, Color color) {
        WLabel wLabel = new WLabel(key);
        wLabel.setValue(title);
        int width = WINDOWS_WIDTH/2;
        int height = WINDOWS_HEIGHT/2;
        wLabel.setBounds(width/5,height/24,width,25+size);
        wLabel.setFont(new Font(null, 1, 20+size));
        wLabel.setForeground(color);
        return wLabel;
    }

    public void setValue(String title) {
        setText(title);
    }


    /**
     * 通过 key 从组件库中获取对象
     * @param key 组件唯一 id
     * @return WLabel对象
     */
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



}
