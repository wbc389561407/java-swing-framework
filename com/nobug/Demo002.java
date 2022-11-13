import component.*;

import java.awt.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-13
 */
public class Demo002 {
    public static void main(String[] args) {
        WFrame frame = WFrame.newInstance("Demo2");
        WPanel wPanel = WPanel.newInstance("p");
        WButton wButton = WButton.newInstance("bnt", "按键");
        wButton.bindClick(new WComponent() {
            @Override
            public void run() {
                System.out.println("点击了");
            }
        });
        WLabel wLabel = WLabel.newInstance("d", "asdasdasd",20, Color.RED);
//        WTextField wTextField = WTextField.newInstance("k", "aklasd", 2);
        WTextField s = WTextField.getInstance("s");
        s.setValue("sdasdasdasda");
        s.setSize(3);
//        wTextField.setValue("AAAA");


        wPanel.bindParent(frame);
        wButton.bindParent(wPanel);
        wLabel.bindParent(wPanel);
        s.bindParent(wPanel);
//        wTextField.bindParent(wPanel);



    }
}
