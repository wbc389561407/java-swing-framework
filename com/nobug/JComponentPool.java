package com.test.win;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 组件库 所有组件都存在这里
 * @author wangbingchen
 * @since 2022-11-10
 **/
public class JComponentPool {

    public static WActionListener listener = new WActionListener();

    public static Map<String,WButton> buttonMap = new HashMap<>();

    public static Map<String,WFrame> frameMap = new HashMap<>();

    public static Map<String,WPanel> panelMap = new HashMap<>();

    public static Map<String,WTextField> textFieldMap = new HashMap<>();


    /**
     * 创建一个带监听的按钮
     * @param title
     * @return
     */
    public static WButton createWButton(String title) {
        WButton wButton = new WButton(title);
        wButton.addActionListener(listener);
        buttonMap.put(title,wButton);
        return wButton;
    }


    /**
     * 创建一个带监听的按钮 和 绑定 监听事件
     * @param title
     * @param wButtonRun
     * @return
     */
    public static WButton createWButton(String title, WButtonRun wButtonRun) {
        return createWButton(title).bindClick(wButtonRun);
    }


    public static WFrame createWFrame(String title) {
        WFrame wFrame = new WFrame(title);
        frameMap.put(title,wFrame);
        return wFrame;
    }

    public static WPanel createWPanel(String title) {
        WPanel wPanel = new WPanel();
        panelMap.put(title,wPanel);
        return wPanel;
    }

    public static WTextField createWTextField(String name, String value) {
        WTextField wTextField = new WTextField(value);
        textFieldMap.put(name,wTextField);
        return wTextField;
    }
}
