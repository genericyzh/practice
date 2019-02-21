package com.ordinaryyzh.javase.exception;

import java.io.IOException;

/**
 * @author genericyzh
 * @date 2018/3/22 14:07
 */
public class Test {

    private void fun0() throws IOException {
        throw new IOException("level 0 exception");
    }

    private void fun1() throws IOException {
        try {
            fun0();
        } catch (IOException e) {
            throw new IOException("level 1 exception", e);
        }
    }

    private void fun2() {
        try {
            fun1();
        } catch (IOException e) {
            throw new RuntimeException("level 2 exception", e);
        }
    }

    public static void main(String[] args) {
        try {
            new Test().fun2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
