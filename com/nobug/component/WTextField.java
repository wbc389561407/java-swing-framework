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
public class WTextField extends ComponentBase{


    private static final Map<String, WTextField> TEXT_FIELD_MAP = new HashMap<>();


    private WTextField(String key, String value, int size) {
        super(JTextField.class);
        JTextField jTextField = getJTextField();
        jTextField.setText(value);
        int width = WINDOWS_WIDTH/2;
        int height = WINDOWS_HEIGHT/2;
        jTextField.setBounds(width/5,height/12,width/2,25+size);
        jTextField.setFont(new Font(null,1,20+size));
        TEXT_FIELD_MAP.put(key,this);
        WActionListener.put(jTextField,this);
    }

    private JTextField getJTextField() {
        return getObj(JTextField.class);
    }


    public static WTextField newInstance(String key) {
        return newInstance(key,null,0);
    }

    public static WTextField newInstance(String key, int size) {
        return newInstance(key,null,size);
    }

    public static WTextField newInstance(String key, String value,int size) {
        WTextField wTextField = new WTextField(key, value,size);
        int width = WINDOWS_WIDTH/2;
        int height = WINDOWS_HEIGHT/2;
        wTextField.setBounds(width/5,height/12,width/2,25+size);
        wTextField.setFont(new Font(null,1,20+size));
        TEXT_FIELD_MAP.put(key,wTextField);
        return wTextField;
    }




    public void setS(WLabel component) {
        setBounds(component.getX(),component.getY()+component.getHeight(),component.getWidth(),this.getFont().getSize());
    }


}
