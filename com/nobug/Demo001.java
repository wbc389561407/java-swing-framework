import component.*;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class Demo001 {
    public static void main(String[] args) {


        WFrame frame = WFrame.newInstance("新电脑");

        WPanel wPanel = frame.createWPanel("wPanel");

        WButton wButton1 = wPanel.createWButton("btn1", "第一个按钮", new WComponent() {
            @Override
            public void run() {
                System.out.println("点击了");
                WButton wButton1 = WButton.buttonMap.get("btn2");
                wButton1.remove();

            }
        });


        WButton wButton2 = wPanel.createWButton("btn2", "第二个按钮", new WComponent() {
            @Override
            public void run() {
                System.out.println("点击了");
                WButton wButton1 = WButton.buttonMap.get("btn1");
                wButton1.remove();

            }
        });

        wButton1.setS(wButton2);


    }
}
