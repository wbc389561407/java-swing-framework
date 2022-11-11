package component;

import javax.swing.*;
import java.awt.*;


/**
 * 基础按钮 创建需要定义名称和触发事件
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-10
 */
public class WButton extends JButton implements WComponent{

    private Container parent;

    private WComponent wComponent;

    public WButton(String title) {
        super(title);
    }

    public WButton(String title, WComponent wComponent) {
        super(title);
        this.wComponent = wComponent;
    }

    public static WButton getInstance(String key) {
        return buttonMap.get(key);
    }

    public WButton bindClick(WComponent wComponent) {
        this.wComponent = wComponent;
        return this;
    }


    public static WButton newInstance(String key, String title, WComponent wComponent) {
        WButton wButton = newInstance(key, title);
        wButton.bindClick(wComponent);
        buttonMap.put(key,wButton);
        return wButton;
    }


    public static WButton newInstance(String key,String title) {
        WButton wButton = new WButton(title);
        int width = WINDOWS_WIDTH/2;
        int height = WINDOWS_HEIGHT/2;
        wButton.setBounds(width/5,height*3/4,width/2,height/8);
        wButton.addActionListener(listener);
        buttonMap.put(key,wButton);
        return wButton;
    }


    @Override
    public void run() {
        if (wComponent != null) {
            wComponent.run();
        }
    }


    public void bindParent(Container container) {
        parent = container;
        container.add(this);
    }

    public void remove() {
        if(parent != null){
            parent.remove(this);
            parent.repaint();
        }
    }


    public void setS(WButton component) {
        setBounds(component.getX(),component.getY()+component.getHeight(),component.getWidth(),this.getFont().getSize());
    }
}
