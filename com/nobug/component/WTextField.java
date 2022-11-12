package component;

import javax.swing.*;
import java.awt.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class WTextField extends JTextField implements WComponent{

    private Container parent;

    public WTextField() {
        super();
    }

    public WTextField(String value) {
        super(value);
    }



    public static WTextField newInstance(String key) {
        return newInstance(key,null,0);
    }

    public static WTextField newInstance(String key, int size) {
        return newInstance(key,null,size);
    }

    public static WTextField newInstance(String key, String value,int size) {
        WTextField wTextField;
        if(value == null){
            wTextField = new WTextField();
        }else {
            wTextField = new WTextField(value);
        }
        int width = WINDOWS_WIDTH/2;
        int height = WINDOWS_HEIGHT/2;
        wTextField.setBounds(width/5,height/12,width/2,25+size);
        wTextField.setFont(new Font(null,1,20+size));
        textFieldMap.put(key,wTextField);
        wTextField.addActionListener(listener);
        return wTextField;
    }




    public void setS(WLabel component) {
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
}
