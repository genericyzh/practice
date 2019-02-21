package com.ordinaryyzh.ninetynine_problems._01_lists;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/*
Find the last but one element of a list
 */
public class P02 {

//    public static <T> T secondLast(List<T> list) {
//        if (list.size() < 2) {
//            throw new NoSuchElementException("Can't find secondLast element from a list with less than 2 elements");
//        }
//        return list.get(list.size() - 2);
//    }

    public static <T> T secondLast(List<T> list) {
        if (list == null) {
            throw new NullPointerException("list为空");
        }
        if (list.size() < 2) {
            throw new NoSuchElementException("list长度小于2，不能找出倒数第二个元素");
        }
        return list.get(list.size() - 2);
    }

//    public static <T> T secondLastRecursion(LinkedList<T> list) {
//        if (list.size() < 2) {
//            throw new NoSuchElementException("Can't find secondLast element from a list with less than 2 elements");
//        }
//        if (list.size() == 2) {
//            return list.getFirst();
//        }
//        return secondLastRecursion(new LinkedList<>(list.subList(1, list.size())));
//
//    }

    public static <T> T secondLastRecursion(LinkedList<T> list) {
        if (list == null) {
            throw new NullPointerException("list为空");
        }
        if (list.size() < 2) {
            throw new NoSuchElementException("list长度小于2，不能找出倒数第二个元素");
        }
        if (list.size() == 2) {
            return list.getFirst();
        }
        return secondLastRecursion((new LinkedList<T>(list.subList(1, list.size()))));
    }
}
