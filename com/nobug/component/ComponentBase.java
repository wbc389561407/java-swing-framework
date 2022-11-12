package component;

import javax.swing.*;
import java.awt.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-12
 */
public class ComponentBase extends Container implements WComponent{

    private Container obj;

    protected Container parent;

    public ComponentBase(Class clazz) {
        if(clazz == WFrame.class){
            obj = new JFrame();
        }

        if(clazz == JPanel.class){
            obj = new JPanel(null);
        }

        if(clazz == JButton.class){
            obj = new JButton();
        }


        if(clazz == JLabel.class){
            obj = new JLabel();
        }

        if(clazz == JTextField.class){
            obj = new JTextField();
        }

    }


    @Override
    public void run() {

    }

    public <T>T getObj(Class<T> clazz) {
        return (T) obj;
    }


    public Container getObj() {
        return obj;
    }



    public void setAtS(ComponentBase componentBase) {
        Container component = componentBase.getObj();
        getObj().setBounds(component.getX(),component.getY()+component.getHeight(),component.getWidth(),getObj().getFont().getSize());
    }


    public void bindParent(Container container) {
        parent = container;
        parent.add(obj);
    }

    public void remove() {
        if(parent != null){
            parent.remove(obj);
            parent.repaint();
        }
    }

}
