package com.ordinaryyzh.javase.innerclass;

/**
 * @author OrdinaryYZH
 * @date 2019/3/15 22:23
 */
public class Outer {

    private int z = 1;

    public AnonInner getAnonInner(final int x) {
        final int y = 5;
        return new AnonInner() {
            @Override
            public int add() {
                z = 2;
                return x + y;
            }
        };
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        AnonInner anonInner = outer.getAnonInner(4);
        int result = anonInner.add();
        System.out.println(result);
        System.out.println(outer.z);
    }

}

