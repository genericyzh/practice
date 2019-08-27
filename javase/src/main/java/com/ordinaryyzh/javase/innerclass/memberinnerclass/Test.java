package com.ordinaryyzh.javase.innerclass.memberinnerclass;

/**
 * @author OrdinaryYZH
 * @date 2019/8/25 0:54
 */
public class Test {

    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
    }

}
