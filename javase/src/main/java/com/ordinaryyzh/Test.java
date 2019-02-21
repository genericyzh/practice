package com.ordinaryyzh;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author genericyzh
 * @date 2018/3/27 18:47
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            if (next.equals("1")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

}

