package com.test.win;


/**
 * 按钮触发事件接口 需要重写 run
 * @author wangbingchen
 * @since 2022-11-10
 **/
public interface WButtonRun{

    JComponentPool pool = new JComponentPool();

    void run();

}
