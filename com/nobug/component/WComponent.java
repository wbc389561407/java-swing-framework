package component;

/**
 * 按钮触发事件接口 需要重写 run
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public interface WComponent extends WComponentCache1{

    //重写 run 在被点击时触发
    void run();

}
