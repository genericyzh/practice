package com.ordinaryyzh.javase.jvm.demo1;

/**
 * @author OrdinaryYZH
 * @date 2018/3/19 14:03
 */
public class SubClass extends SuperClass
{
    static
    {
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass()
    {
        System.out.println("init SubClass");
    }
}