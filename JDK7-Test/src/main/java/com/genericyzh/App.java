package com.genericyzh;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Hello", "world!");
        String value = map.get("Hello");
    }
}
