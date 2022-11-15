import component.*;

import javax.swing.*;
import java.io.IOException;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-13
 */
public class Test001 {
    public static void main(String[] args) {
        WFrame wFrame = WFrame.newInstance("关机程序");
        WPanel p = wFrame.createWPanel("p");
        WButton wButton = p.createWButton("bnt1", "关机");
        WLabel create = p.createWLabel("create");
        wButton.bindClick(new WComponent() {
            @Override
            public void run() {
                System.out.println("关机命令");
                try {
                    Runtime.getRuntime().exec("shutdown -s -t 10");
                    JOptionPane.showMessageDialog(null,"系统将在10秒后关机","系统提示！",1,new ImageIcon());

                  new Thread(() ->{
                    int num = 10;
                    while (true){
                        create.setValue("系统将在"+String.valueOf(num)+"秒后关机！！！");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        --num;
                        if(num==0){
                            return;
                        }
                    }
                  }).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        WButton wButton1 = p.createWButton("bnt1", "取消关机",new WComponent() {
            @Override
            public void run() {
                System.out.println("取消关机");
                try {
                    Runtime.getRuntime().exec("shutdown -a");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
