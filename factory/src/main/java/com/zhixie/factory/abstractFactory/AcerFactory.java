package com.zhixie.factory.abstractFactory;

import com.zhixie.factory.simpleFactory.AcerMouse;
import com.zhixie.factory.simpleFactory.Mouse;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-18 13:48
 */
public class AcerFactory implements Factory {
    @Override
    public Mouse createMouse() {
        return new AcerMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new AcerKeyBoard();
    }
}
