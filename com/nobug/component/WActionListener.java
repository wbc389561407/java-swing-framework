package component;

import javax.swing.*;
import javax.swing.event.EventListenerList;
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


    private static final WActionListener LISTENER = new WActionListener();


    private WActionListener(){

    }

    public static WActionListener getInstance() {
        return LISTENER;
    }

    public static final Map<Object, ComponentBase> LISTENER_MAP = new HashMap<>();

    public static void put(JComponent jComponent, ComponentBase componentBase) {
        LISTENER_MAP.put(jComponent,componentBase);
        if(jComponent instanceof JButton){
            ((JButton) jComponent).addActionListener(LISTENER);
        }

        if(jComponent instanceof JTextField){
            ((JTextField) jComponent).addActionListener(LISTENER);
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        //实现按钮点击后自动运行指定操作
        if(source instanceof JButton){
            LISTENER_MAP.get(source).run();
        }


    }
}
