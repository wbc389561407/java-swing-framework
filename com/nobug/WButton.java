package com.test.win;

import javax.swing.*;



/**
 * 基础按钮 创建需要定义名称和触发事件
 * @author wangbingchen
 * @since 2022-11-10
 **/
public class WButton extends JButton {

    private WButtonRun wButtonRun = new WButtonRunDefault();

    public WButton(){
        super();
    }

    public WButton(String title) {
        super(title);
    }

    public WButton(String title, WButtonRun wButtonRun) {
        super(title);
        this.wButtonRun = wButtonRun;
    }

    public WButton bindClick(WButtonRun wButtonRun) {
        this.wButtonRun = wButtonRun;
        return this;
    }

    public WButtonRun getWButtonRun() {
        return wButtonRun;
    }

}
