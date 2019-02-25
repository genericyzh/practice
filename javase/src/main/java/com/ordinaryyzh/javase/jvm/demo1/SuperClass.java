package com.ordinaryyzh.javase.jvm.demo1;

/**
 * @author OrdinaryYZH
 * @date 2018/3/19 14:03
 */
public class SuperClass extends SSClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

    public SuperClass() {
        System.out.println("init SuperClass");
    }
}
