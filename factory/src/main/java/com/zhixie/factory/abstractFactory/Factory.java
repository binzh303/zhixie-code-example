package com.zhixie.factory.abstractFactory;

import com.zhixie.factory.simpleFactory.Mouse;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-18 13:47
 */
public interface Factory {

    Mouse createMouse();

    KeyBoard createKeyBoard();
}
