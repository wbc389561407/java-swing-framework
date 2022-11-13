# java-swing-framework

#### 介绍
java是一个全能型的语言，但是桌面应用一直没有找到好用的框架，于是想着自己封装一下，让它变的更加简单。

#### 软件架构
基于 原生 jdk8 封装

#### 使用说明

1.  一句话创建窗口
```
WFrame wFrame = WFrame.newInstance("这个是一个窗口");
```
2.  在窗口上添加面板
```
WPanel panel = wFrame.createWPanel("Panel");
```
3.  在面板上添加一个标题
```
WLabel wLabel = panel.createWLabel("key1", "这是一个标题");
```
4.  在面板上添加一个输入框
```
WTextField wTextField = panel.createWTextField("TextField1", "这是一个输入框", 20);
```
5.  在面板上添加一个按键
```
WTextField wTextField = panel.createWTextField("TextField1", "这是一个输入框", 20);
```
6.  给按键绑定触发事件
```
        wButton.bindClick(new WComponent() {
            @Override
            public void run() {
                System.out.println("按键被点击了");
            }
        });
```

7.  检测电脑信息代码 根目录下 Test




