import component.*;

import java.awt.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-12
 */
public class Demo001 {
    public static void main(String[] args) {
        WFrame frame = WFrame.newInstance("很好");

        WPanel wPanel = WPanel.newInstance("p");
        wPanel.bindParent(frame);


        WButton wButton = wPanel.createWButton("b", "aa",new WComponent() {
            @Override
            public void run() {
                System.out.println("点击了");
            }
        });

        WLabel wLabel = wPanel.createWLabel("q", "sdassdasd",20, Color.RED);

//
//        WLabel wLabel = pp.createWLabel("k", "32321");
//        WLabel s = wLabel.createS("k1", "adaskdja");
//        WLabel s1 = s.createS("k2", "dddddd");
        WTextField key = WTextField.newInstance("key", "999", 20);
        WTextField text = WTextField.newInstance("text");
        text.bindParent(wPanel);


    }
}
