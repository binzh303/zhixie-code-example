package com.zhixie.factory.simpleFactory;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-17 18:51
 */
public class AcerMouse implements Mouse {
    @Override
    public void getName() {
        System.out.println("这个是宏碁鼠标");
    }
}
