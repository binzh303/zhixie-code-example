package com.zhixie.factory.simpleFactory;

/**
 * @Author zhbin
 * 简单工厂
 * @Description 鼠标工厂
 * @Date 2019-10-17 18:45
 */
public class MouseFactory {

    /**
     * 生产一个鼠标
     * @param i
     * @return
     */
     public Mouse createMouse(int i){

        Mouse mouse = null;
        switch (i){
            case 1:
                mouse = new LenovoMouse();
                break;
            case 2:
                mouse = new AcerMouse();
                break;
        }
        return mouse;
    }
}
