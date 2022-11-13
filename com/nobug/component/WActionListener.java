package component;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;


/**
 * 监听器类
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-10
 */
public class WActionListener implements ActionListener {


    private static final ActionListener LISTENER = new WActionListener();


    private WActionListener(){

    }

    public static ActionListener getInstance() {
        return LISTENER;
    }

    public static final Map<Object, ComponentBase> LISTENER_MAP = new HashMap<>();

    public static void addActionListener(ComponentBase componentBase) {
        Container obj = componentBase.getObj();
        LISTENER_MAP.put(obj,componentBase);
        if(obj instanceof JButton){
            ((JButton) obj).addActionListener(LISTENER);
        }

        if(obj instanceof JTextField){
            ((JTextField) obj).addActionListener(LISTENER);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        //实现按钮点击后自动运行指定操作
        if(source instanceof JButton){
            LISTENER_MAP.get(source).run();
        }

        if(source instanceof JTextField){
            System.out.println(source);
        }


    }
}
