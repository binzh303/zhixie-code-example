package com.zhixie.factory.factory;

import com.zhixie.factory.simpleFactory.AcerMouse;
import com.zhixie.factory.simpleFactory.Mouse;

/**
 * @Author zhbin
 * @Description
 * @Date 2019-10-17 19:20
 */
public class AcerMouseFactory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new AcerMouse();
    }
}
