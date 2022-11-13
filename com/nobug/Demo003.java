import component.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-13
 */
public class Demo003 {

    public static void main(String[] args) {
        WFrame frame = WFrame.newInstance("窗口");
        WPanel wPanel = WPanel.newInstance("p");
        wPanel.bindParent(frame);
        WButton wButton = WButton.newInstance("bnt", "11按钮");
        wButton.bindClick(new WComponent() {
            @Override
            public void run() {
                System.out.println("点击");
            }
        });
        wButton.bindParent(wPanel);
        WButton wButton1 = WButton.newInstance("bnt1", "q按钮");
        wButton1.bindClick(new WComponent() {
            @Override
            public void run() {
                System.out.println("kkk");
            }
        });
        wButton1.bindParent(wPanel);

        WButton wButton11 = WButton.newInstance("bnt11", "q按钮1111111");
        wButton11.bindClick(new WComponent() {
            @Override
            public void run() {
                System.out.println("wButton11");
            }
        });
        wButton11.bindParent(wPanel);

        WTextField wTextField = WTextField.newInstance("da", "dsa", 20);
        wTextField.bindParent(wPanel);
    }
}
