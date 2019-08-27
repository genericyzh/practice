package com.ordinaryyzh.javase.innerclass.memberinnerclass;

/**
 * @author OrdinaryYZH
 * @date 2019/8/24 16:08
 */
public class Outer {
    private int a = 100;

    public class Inner {

        public static final int b = 1;

        // 不能有非final的static字段
//        public static int c = 1;

        public void innerMethod() {
            System.out.println("outer a " + a);
            Outer.this.action();
        }

        // 不能有static方法
//        public static void test() {
//        }
    }

    private void action() {
        System.out.println("action");
    }

    public void test() {
        Inner inner = new Inner();
        inner.innerMethod();
    }

}