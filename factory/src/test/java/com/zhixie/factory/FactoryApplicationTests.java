package com.zhixie.factory;

import com.zhixie.factory.abstractFactory.AcerFactory;
import com.zhixie.factory.abstractFactory.LenovoFactory;
import com.zhixie.factory.factory.AcerMouseFactory;
import com.zhixie.factory.factory.LenovoMouseFactory;
import com.zhixie.factory.simpleFactory.Mouse;
import com.zhixie.factory.simpleFactory.MouseFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FactoryApplicationTests {

    @Test
    void contextLoads() {

        MouseFactory factory = new MouseFactory();
        Mouse mouse = factory.createMouse(2);
        mouse.getName();
    }


    @Test
    void demo(){

        LenovoMouseFactory lenovoMouseFactory = new LenovoMouseFactory();
        Mouse lenovoMouse = lenovoMouseFactory.createMouse();
        lenovoMouse.getName();


        AcerMouseFactory acerMouseFactory = new AcerMouseFactory();
        Mouse acerMouse = acerMouseFactory.createMouse();
        acerMouse.getName();
    }

    @Test
    void abstractF(){

        LenovoFactory lenovoFactory = new LenovoFactory();
        lenovoFactory.createKeyBoard().getName();
        lenovoFactory.createMouse().getName();

        AcerFactory acerFactory = new AcerFactory();
        acerFactory.createKeyBoard().getName();
        acerFactory.createMouse().getName();
    }
}
