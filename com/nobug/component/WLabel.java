package component;

import javax.swing.*;
import java.awt.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class WLabel extends JLabel implements WComponent{

    private Container parent;


    public static WLabel newInstance(String key, String title) {
        return newInstance(key,title,20,Color.BLACK);
    }

    public static WLabel newInstance(String key, String title, int size) {
        return newInstance(key,title,size,Color.BLACK);
    }


    public static WLabel newInstance(String key, String title, int size, Color color) {
        WLabel wLabel = new WLabel();
        wLabel.setText(title);
        int width = WINDOWS_WIDTH/2;
        int height = WINDOWS_HEIGHT/2;
        wLabel.setBounds(width/5,height/24,width,25+size);
        wLabel.setFont(new Font(null, 1, 20+size));
        wLabel.setForeground(color);
        labelMap.put(key,wLabel);
        return wLabel;
    }

    public static WLabel getInstance(String label1) {
        return labelMap.get(label1);
    }


    public WLabel createWLabel(String title, int size) {
        return createWLabel(title,size,Color.black);
    }

    public WLabel createWLabel(String title, int size, Color color) {
        WLabel wLabel = new WLabel();
        wLabel.setText(title);
        int width = WINDOWS_WIDTH/2;
        int height = WINDOWS_HEIGHT/2;
        wLabel.setBounds(width/5,height/24,width/2,size);
        wLabel.setFont(new Font(null, 1, size));
        wLabel.setForeground(color);
        labelMap.put(title,wLabel);
        return wLabel;
    }


    public void setS(JComponent component) {
        setBounds(component.getX(),component.getY()+component.getHeight(),component.getWidth(),this.getFont().getSize());
    }

    @Override
    public void run() {

    }

    public void bindParent(Container container) {
        parent = container;
        container.add(this);
    }

    public void remove() {
        parent.remove(this);
        parent.repaint();
    }

    public void clearText() {
        this.setText("");
    }
}
