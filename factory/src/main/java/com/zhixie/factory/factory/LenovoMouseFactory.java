package com.zhixie.factory.factory;

import com.zhixie.factory.simpleFactory.LenovoMouse;
import com.zhixie.factory.simpleFactory.Mouse;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-17 19:19
 */
public class LenovoMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }
}
