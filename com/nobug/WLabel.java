package com.test.win;

import javax.swing.*;

public class WLabel extends JLabel {

    public void setS(JComponent component) {
        setBounds(component.getX(),component.getY()+component.getHeight(),component.getWidth(),this.getFont().getSize());
    }
}
