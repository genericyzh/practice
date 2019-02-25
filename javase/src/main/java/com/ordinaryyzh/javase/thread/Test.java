package com.ordinaryyzh.javase.thread;

/**
 * @author OrdinaryYZH
 * @date 2018/3/22 23:45
 */

public class Test {

    static void f() {
        String s = "";
        s = s + 100;
    }

}

enum AccountType {
    SAVING, FIXED, CURRENT;

    private AccountType() {
        System.out.println("It is a account type");
    }
}

