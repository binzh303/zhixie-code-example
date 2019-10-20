package com.zhixie.factory.abstractFactory;

import com.zhixie.factory.simpleFactory.LenovoMouse;
import com.zhixie.factory.simpleFactory.Mouse;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-18 13:47
 */
public class LenovoFactory implements Factory {
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new LenovoKeyBoard();
    }
}
