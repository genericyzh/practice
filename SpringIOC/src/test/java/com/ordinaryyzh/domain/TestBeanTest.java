package com.ordinaryyzh.domain;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author OrdinaryYZH
 * @date 2019/2/27 22:26
 */
public class TestBeanTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("nestedBean-applicationcontext.xml");
        TestBean bean = ctx.getBean("bean", TestBean.class);
        System.out.println(bean);
    }

}