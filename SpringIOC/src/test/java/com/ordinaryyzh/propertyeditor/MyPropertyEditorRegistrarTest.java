package com.ordinaryyzh.propertyeditor;

import com.ordinaryyzh.domain.Circle;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author OrdinaryYZH
 * @date 2019/2/21 21:22
 */
public class MyPropertyEditorRegistrarTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("propertyeditor-applicationcontext.xml");
        Circle circle = ctx.getBean("circle", Circle.class);
        Assert.assertEquals(1, circle.getPoint().getX());
        Assert.assertEquals(2, circle.getPoint().getY());
    }

}