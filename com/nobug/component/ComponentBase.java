package component;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.peer.ComponentPeer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-12
 */
public class ComponentBase extends Container implements WComponent{

    private int lastX;

    private int lastY;

    private int lastWidth;

    private int lastHeight;

    public int getLastX() {
        return lastX;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    public int getLastWidth() {
        return lastWidth;
    }

    public void setLastWidth(int lastWidth) {
        this.lastWidth = lastWidth;
    }

    public int getLastHeight() {
        return lastHeight;
    }

    public void setLastHeight(int lastHeight) {
        this.lastHeight = lastHeight;
    }
//    /**
//     * 所有生成的组件 存组件 id 和 组件外壳
//     */
//    private static final Map<String, ComponentBase> CACHE_MAP = new HashMap<>();


    /**
     * 组件外壳
     */
    protected ComponentBase componentBase;

    /**
     * 组件本体
     */
    private Container obj;

    /**
     * 组件上级
     */
    protected ComponentBase parent;

    public ComponentBase() {
    }

    public ComponentBase(ComponentBase componentBase) {
        this.componentBase = componentBase;

        if(componentBase instanceof WFrame){
            obj = new JFrame();
        }

        if(componentBase instanceof WPanel){
            obj = new JPanel(null);
        }

        if(componentBase instanceof WButton){
            obj = new JButton();
        }

        if(componentBase instanceof WLabel){
            obj = new JLabel();
        }

        if(componentBase instanceof WTextField){
            obj = new JTextField();
        }


    }





    @Override
    public void run() {

    }

//    public <T>T getObj(Class<T> clazz) {
//        return (T) obj;
//    }


    public Container getObj() {
        return obj;
    }



    public void setAtS(ComponentBase componentBase) {
        Container component = componentBase.getObj();
        getObj().setBounds(component.getX(),component.getY()+component.getHeight(),component.getWidth(),getObj().getFont().getSize());
    }


//    public void bindParent(ComponentBase container) {
//        parent = container;
//        parent.add(obj);
//    }

    public void bindParent(ComponentBase container) {
        parent = container;
        parent.obj.add(obj);
        parent.obj.revalidate();
        parent.obj.repaint();
        // 设置父类的占用面积
        int x = parent.lastX;
        int y = parent.lastY;
        int width = WINDOWS_WIDTH/2;
        int height = obj.getFont().getSize()+25;
        setBounds(x, y, width, height); //向下添加
        parent.setLastX(x);
        parent.setLastY(y+obj.getHeight());
        parent.setLastWidth(width);
        parent.setLastHeight(height);
        System.out.println("相对上级的坐标位置");
        System.out.println("X:"+parent.getLastX());
        System.out.println("Y:"+parent.getLastY());
        System.out.println("宽:"+parent.getLastWidth());
        System.out.println("高:"+parent.getLastHeight());
    }


    public void remove() {
        if(parent != null){
            parent.remove(obj);
            parent.repaint();
        }
    }



    public static String getCaller()
    {
        int i;
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        for (i=0; i < stack.length; i++)
        {
            StackTraceElement ste=stack[i];
            System.out.println(ste.getClassName()+"."+ste.getMethodName()+"(...);");
            System.out.println(i+"--"+ste.getMethodName());
            System.out.println(i+"--"+ste.getFileName());
            System.out.println(i+"--"+ste.getLineNumber());
        }
        return null;
    }

    //获取实现类名
    public static String getClassName() {
        int i;
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        for (i=0; i < stack.length; i++) {
            StackTraceElement ste=stack[i];
            System.out.println(ste.getClassName()+"."+ste.getMethodName()+"(...);");
            System.out.println(i+"--"+ste.getMethodName());
            System.out.println(i+"--"+ste.getFileName());
            System.out.println(i+"--"+ste.getLineNumber());
            if(i==2){
                return ste.getClassName();
            }
        }
        return null;
    }

    /**
     * 获取调用者方法
     * @return
     */
    public static String getParentMethod() {
        String string = null;
        int i;
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        for (i=0; i < stack.length; i++) {
            StackTraceElement ste=stack[i];
//            System.out.println(ste.getClassName()+"."+ste.getMethodName()+"(...);");
//            System.out.println(i+"--"+ste.getMethodName());
//            System.out.println(i+"--"+ste.getFileName());
//            System.out.println(i+"--"+ste.getLineNumber());
            if(i==2){
                string = ste.getMethodName();
            }
        }
        return string;
    }




    private static final HashMap<Class, Class> classClassHashMap = new HashMap<>();
    static {
        classClassHashMap.put(Integer.class,int.class);
        classClassHashMap.put(Boolean.class,boolean.class);
        classClassHashMap.put(Double.class,double.class);
        classClassHashMap.put(Long.class,long.class);
        classClassHashMap.put(Byte.class,byte.class);
        classClassHashMap.put(Character.class,char.class);
        classClassHashMap.put(Short.class,short.class);
        classClassHashMap.put(Float.class,float.class);
    }

    /**
     * 执行 子类 同名方法
     * @param objs
     */
    protected void setReflection(Object ...objs) {

        Class[] classes = new Class[objs.length];

        for (int i = 0; i < objs.length; i++) {
            Class<?> aClass1 = objs[i].getClass();
            Class aClass2 = classClassHashMap.get(aClass1);
            if(aClass2 == null){
                classes[i] = aClass1;
            }else {
                classes[i] = aClass2;
            }
        }

        String parentMethod = getParentMethod();
        System.out.println("上级方法为："+parentMethod);
        try {
            Class<?> aClass = obj.getClass();
            Method setDefaultCloseOperation = aClass.getMethod(parentMethod, classes);
            setDefaultCloseOperation.invoke(obj,objs);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void setText(String title) {
        setReflection(title);
    }

    protected void setTitle(String title) {
        setReflection(title);
    }

    public void setVisible(boolean b) {
        setReflection(b);
    }

    protected void setDefaultCloseOperation(int exitOnClose) {
        setReflection(exitOnClose);
    }

    public void setBounds(int x, int y, int width, int height) {
        setReflection(x,y,width,height);
    }
    public void setFont(Font f) {
        setReflection(f);
    }

    public void setForeground(Color c) {
        setReflection(c);
    }


//    public void revalidate() {
//        obj.revalidate();
//    }
//
//    public void repaint() {
//        obj.repaint();
//    }
}
