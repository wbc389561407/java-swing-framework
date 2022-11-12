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
public interface WComponentCache {


    //显示器的宽
    int WINDOWS_WIDTH = getWidth();

    static int getWidth() {
        return getDimension().width;
    }

    //显示器的高
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

}
