package com.genericyzh.ninetynine_problems._01_lists;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

/**
 * Reverse a list
 * 翻转一个List
 */
public class P05 {

//    public static <T> List<T> reverse(List<T> list) {
//        if (list == null) {
//            throw new IllegalArgumentException("list can't be null");
//        }
//        Collections.reverse(list);
//        return list;
//    }

    /**
     * 使用Collections.reverse
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> reverse(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        Collections.reverse(list);
        return list;
    }

    public static <T> List<T> reverse_foreach(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }


    public static <T> List<T> reverse_IntStream(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        int size = list.size();
        return IntStream.iterate(size - 1, el -> el - 1).limit(size).mapToObj(list::get).collect(toList());
    }

    public static <T> List<T> reverse_customStream(ArrayDeque<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("list can't be null");
        }
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(list.descendingIterator(), Spliterator.ORDERED), false).collect(toList());
    }
}

