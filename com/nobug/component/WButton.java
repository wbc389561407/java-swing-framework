package component;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


/**
 * 基础按钮 创建需要定义名称和触发事件
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-10
 */
public class WButton extends ComponentBase{


    private static final Map<String, WButton> BUTTON_MAP = new HashMap<>();

    //操作的事件
    private WComponent wComponent;

    private WButton(String key) {
        super(new WButton());
        BUTTON_MAP.put(key,this);
    }

    private WButton() {

    }


    public static WButton getInstance(String key) {
        return BUTTON_MAP.get(key);
    }

    public WButton bindClick(WComponent wComponent) {
        this.wComponent = wComponent;
        WActionListener.addActionListener(this);
        return this;
    }


    public static WButton newInstance(String key, String title, WComponent wComponent) {
        WButton wButton = newInstance(key, title);
        wButton.bindClick(wComponent);
        return wButton;
    }


    public static WButton newInstance(String key,String title) {
        WButton wButton = new WButton(key);
        wButton.setText(title);
        int width = WINDOWS_WIDTH/2;
        int height = WINDOWS_HEIGHT/2;
        wButton.setBounds(width/5,height*3/4,width/2,height/8);
        return wButton;
    }


    @Override
    public void run() {
        if (wComponent != null) {
            wComponent.run();
        }
    }

}
