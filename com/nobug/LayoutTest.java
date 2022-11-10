package com.test.win;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

/**
 * @author Tim
 * @Description
 * @create 2022-01-10 16:33
 */
public class LayoutTest extends JFrame{
    //创建类LayoutTest继承于类JFrame

    JButton btn1,btn2,btn3,btn4,btn5;
    JPanel mainPan;
    TextField textField;
    FlowLayout fLayout;//定义布局方式
    GridLayout gLayout;
    BorderLayout bLayout;
    CardLayout cLayout;
    JFrame frame = this;
    public LayoutTest(String layoutstyle){ //定义构造函数
        super("布局方式: "+layoutstyle);
        mainPan=new JPanel();
        fLayout=new FlowLayout(FlowLayout.LEFT);//创建4种布局方式的对象
        gLayout=new GridLayout(3,2);
        bLayout=new BorderLayout();
        cLayout=new CardLayout(10,10);
        if(layoutstyle.equals("fLayout")) //判断采用哪种布局方式
        mainPan.setLayout(fLayout);
        else if(layoutstyle.equals("gLayout"))
                mainPan.setLayout(gLayout);
        else if(layoutstyle.equals("bLayout"))
                mainPan.setLayout(bLayout);
        else if(layoutstyle.equals("cLayout"))
                mainPan.setLayout(cLayout);
        else
        System.out.println("布局方式输入错误!");
//        getContentPane().add(mainPan);
        this.add(mainPan);
        btn1=new JButton("检测本机电脑"); //创建5个按钮类的对象

        btn2=new JButton("按钮2");
        btn3=new JButton("按钮3");
        btn4=new JButton("按钮4");
        btn5=new JButton("按钮5");
        if(layoutstyle.equals("fLayout") || layoutstyle.equals("gLayout"))//定义FlowLayout或者CridLayout的布局方式
        {
            mainPan.add(btn1);
            mainPan.add(btn2);
            mainPan.add(btn3);
            mainPan.add(btn4);
            mainPan.add(btn5);
        }
        if(layoutstyle.equals("bLayout") || layoutstyle.equals("cLayout"))//定义BorderLayout或者CardLayout的布局方式
        {
            mainPan.add(btn1,"East");
            mainPan.add(btn2,"South");
            mainPan.add(btn3,"West");
            mainPan.add(btn4,"North");
            mainPan.add(BorderLayout.CENTER,btn5);
        }




//        setSize(500,500);//设置界面的宽度和高度
        Toolkit toolkit=getToolkit();
        Dimension dim = toolkit.getScreenSize(); 	//获取桌面像素
        int wide = (int)(dim.width*0.5);
        int height = (int)(dim.height*0.5);
        setBounds((dim.width-wide)/2,(dim.height-height)/2,wide,height);

        setVisible(true);//设置界面的可见性
        setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗口关闭时的默认操作
        mainPan.add(new JTextField("asd"));


        //        textField = new TextField();
//        mainPan.add(textField);
        btn1.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
//                textField.setText("9999");
//                String text = textField.getText();
                int wide = (int)(dim.width*0.25);
                int height = (int)(dim.height*0.25);
                btn5.setBounds(wide/2,height/2,wide,height);
//                mainPan.setLayout(gLayout);
//                revalidate();

            }
        });

    }
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        LayoutTest fLayout = new LayoutTest("fLayout");

        String osUser=System.getProperty("user.name");



        Properties props=System.getProperties(); //获得系统属性集
         String osName = props.getProperty("os.name"); //操作系统名称

        String osArch = props.getProperty("os.arch"); //操作系统构架
        String osVersion = props.getProperty("os.version"); //操作系统版本
        System.out.println(osArch);
        System.out.println(osName);
        System.out.println(osVersion);
        System.out.println(osUser);

//        new LayoutTest("gLayout");
//        new LayoutTest("bLayout");
//        new LayoutTest("cLayout");

    }


}
