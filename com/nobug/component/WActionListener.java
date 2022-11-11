package component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 监听器类
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-10
 */
public class WActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        //实现按钮点击后自动运行指定操作
        if(source instanceof WButton){
            ((WButton) source).run();
        }


    }
}
