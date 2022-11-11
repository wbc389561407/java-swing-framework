package component;


/**
 * 按钮触发事件接口 需要重写 run
 * @author 389561407@qq.com
 * @version 1.0
 * @since 2022-11-11
 */
public interface WButtonRun{

    WComponentCache pool = new WComponentCache();

    void run();

}
