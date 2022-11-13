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


    //操作的事件
    private WComponent wComponent;


//    private WTextField(String key, String value, int size) {
//        super(new WTextField());
//        JTextField jTextField = getJTextField();
//        jTextField.setText(value);
//        int width = WINDOWS_WIDTH/2;
//        int height = WINDOWS_HEIGHT/2;
//        jTextField.setBounds(width/5,height/12,width/2,25+size);
//        jTextField.setFont(new Font(null,1,20+size));
//        TEXT_FIELD_MAP.put(key,this);
//        WActionListener.put(jTextField,this);
//    }

    private WTextField(String key) {
        super(new WTextField());
        TEXT_FIELD_MAP.put(key,this);
    }

    private WTextField() {

    }


    /**
     * 创建新的文本框
     * @param key 组件库 WTextField 唯一 id
     * @return 新 WTextField
     */
    public static WTextField newInstance(String key) {
        return new WTextField(key);
    }


    /**
     * 创建新的文本框
     * @param key 组件库 WTextField 唯一 id
     * @param size 字体大小
     * @return 新 WTextField
     */
    public static WTextField newInstance(String key, int size) {
        WTextField wTextField = newInstance(key);
        wTextField.setSize(size);
        return wTextField;
    }


    /**
     * 创建新的文本框
     * @param key 组件库 WTextField 唯一 id
     * @param value WTextField 组件中内容
     * @param size 字体大小
     * @return 新 WTextField
     */
    public static WTextField newInstance(String key, String value, int size) {
        WTextField wTextField = newInstance(key);
        wTextField.setValue(value);
        wTextField.setSize(size);
        return wTextField;
    }

    /**
     * 优先从组件库中取，如果没有则创建新对象
     * @param key WTextField 唯一 id
     * @return WTextField对象
     */
    public static WTextField getInstance(String key) {
        WTextField wTextField = TEXT_FIELD_MAP.get(key);
        if(wTextField == null){
            wTextField = newInstance(key);
            wTextField.setSize(0);
        }
        return wTextField;
    }


    public void setSize(int size) {
        int width = WINDOWS_WIDTH/2;
        int height = WINDOWS_HEIGHT/2;
        setBounds(width/5,height/12,width/2,25+size);
        setFont(new Font(null,1,20+size));
    }

    public void setValue(String value) {
        setText(value);
    }


    public WTextField bindClick(WComponent wComponent) {
        this.wComponent = wComponent;
        WActionListener.addActionListener(this);
        return this;
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}
