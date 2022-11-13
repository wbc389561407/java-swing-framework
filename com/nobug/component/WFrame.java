package component;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public class WFrame extends ComponentBase{

    /**
     * 所有生成的组件
     */
    private static final Map<String, WFrame> FRAME_MAP = new HashMap<>();


    /**
     * 新建对象
     * @return 新 WFrame 对象
     */
    public static WFrame newInstance() {
        return newInstance("默认窗口");
    }


    /**
     *  新建对象
     * @param title 标题
     * @return 新 WFrame 对象
     */
    public static WFrame newInstance(String title) {
        WFrame wFrame = new WFrame(title);
        wFrame.setTitle(title);
        wFrame.setVisible(true);//设置界面的可见性
        wFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭时的默认操作
        wFrame.setBounds(WINDOWS_WIDTH/4,WINDOWS_HEIGHT/4,WINDOWS_WIDTH/2,WINDOWS_HEIGHT/2);
        return wFrame;
    }


    /**
     *  从组件库中获取对象
     * @param title title 标题
     * @return WFrame对象
     */
    public static WFrame getInstance(String title) {
        WFrame wFrame = FRAME_MAP.get(title);
        if(wFrame == null){
            return newInstance(title);
        }else {
            return wFrame;
        }
    }


    /**
     * 在此对象下新建一个面板并且绑定到此对象下
     * @param key 面板组件唯一 id
     * @return 新 WPanel 对象
     */
    public WPanel createWPanel(String key) {
        WPanel wPanel = WPanel.newInstance(key);
        wPanel.bindParent(this);
        return wPanel;
    }



    private WFrame(String title){
        super(new WFrame());
        FRAME_MAP.put(title,this);
    }

    private WFrame(){
    }


}
