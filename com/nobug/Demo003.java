import component.WFrame;
import component.WLabel;
import component.WPanel;
import component.WTextField;
import util.Base64Util;
import util.PathUtil;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class Demo003 {

    public static void main(String[] args) {
        WFrame frame = WFrame.newInstance("解开密码，进入系统");
        WPanel p = frame.createWPanel("p");
        WLabel wLabel = p.createWLabel("password","请输入密码：",0);
        WLabel err = p.createWLabel("err","",50,Color.RED);
        err.setBounds(400,400,800,100);
        WTextField w =  WTextField.newInstance("key",20);
        w.bindParent(p);


        WPanel pp = WPanel.newInstance("pp");
        WLabel login = pp.createWLabel("login", "登录成功！");
        String path = Demo003.class.getResource("").getPath();
        File data = new File(PathUtil.getSafePath("data"));

        ImageIcon imageIcon = Base64Util.base64FileToImageIcon(data);

        login.setBounds(login.getX(),login.getY(),imageIcon.getIconWidth(),imageIcon.getIconHeight());
        login.setIcon(imageIcon);

        //监听密码
        new Thread(() ->{
            while (true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String text = w.getText();
                if(text.length()==4){
                    int i = ckPassword(text);
                    if(i==0){
                        //成功切换面板
                        System.out.println("成功切换面板");
                        p.remove();
                        pp.bindParent(frame);
                        return;
                    }else {
                        //失败给出提示
                        if(i>0){
                            err.setText("密码错误:大了");
                        }else {
                            err.setText("密码错误:小了");
                        }
                    }
                }else {
                    err.setText("");
                }
            }

        }).start();


    }

    private static int ckPassword(String text) {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int dayOfMonth = now.getDayOfMonth();
        String password = ""+hour+(minute+dayOfMonth);
        return Integer.parseInt(text)-Integer.parseInt(password);
    }


}
