package com.ordinaryyzh;

import java.util.HashMap;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(2);
        for (int i = 0; i < 32; i++) {
            map.put(i, i);
        }
    }

}
