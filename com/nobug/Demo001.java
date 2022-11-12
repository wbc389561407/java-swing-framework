import component.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-12
 */
public class Demo001 {
    public static void main(String[] args) {
        WFrame frame = WFrame.newInstance("很好");
        WPanel pp = frame.createWPanel("pp");

//        WPanel wPanel = WPanel.newInstance("p");

        WButton wButton = pp.createWButton("b", "aa",new WComponent() {
            @Override
            public void run() {
                System.out.println("点击了");
                WLabel k = WLabel.getInstance("k");
                k.remove();
            }
        });

        WLabel wLabel = pp.createWLabel("k", "32321");
        WLabel s = wLabel.createS("k1", "adaskdja");
        WLabel s1 = s.createS("k2", "dddddd");



    }
}
