package com.zhixie.factory.abstractFactory;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-18 13:46
 */
public class AcerKeyBoard implements KeyBoard {
    @Override
    public void getName() {
        System.out.println("这个是宏碁键盘");
    }
}
