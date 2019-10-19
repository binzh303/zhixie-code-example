package com.zhixie.factory.abstractFactory;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-18 13:45
 */
public class LenovoKeyBoard implements KeyBoard {
    @Override
    public void getName() {
        System.out.println("这个是联想键盘");
    }
}
