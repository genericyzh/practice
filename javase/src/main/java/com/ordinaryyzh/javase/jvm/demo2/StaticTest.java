package com.ordinaryyzh.javase.jvm.demo2;

/**
 * @author OrdinaryYZH
 * @date 2018/3/19 17:55
 * 参考：http://blog.csdn.net/u013256816/article/details/50837863
 */
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
}
