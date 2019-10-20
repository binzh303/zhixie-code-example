package com.zhixie.factory.simpleFactory;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-17 18:50
 */
public class LenovoMouse implements Mouse {
    @Override
    public void getName() {
        System.out.println("这个是联想鼠标");
    }
}
