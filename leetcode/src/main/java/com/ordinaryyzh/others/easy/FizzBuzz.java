package com.ordinaryyzh.others.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author genericyzh
 * @version 1.0
 * @date 2017/5/24 22:46
 */
public class FizzBuzz {
    /**
     * 方法一：直接用求余%
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf((i)));
            }
        }
        return list;
    }

    /**
     * 方法2：不使用求余
     * @param n
     * @return
     */
    public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                list.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                list.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                list.add("Buzz");
                buzz = 0;
            } else {
                list.add(String.valueOf((i)));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> strings = fizzBuzz.fizzBuzz2(16);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
