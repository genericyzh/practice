package com.ordinaryyzh.leetcode.string;

import java.util.*;

/**
 * https://leetcode.com/problems/simplify-path/description/
 *
 * @author genericyzh
 * @date 2017/10/20 23:54
 */
public class _12_SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        String[] split = path.split("/"); // ""也会被分出来 /home -> ""."home"
        for (int i = 0; i < split.length; i++) {
            if ("..".equals(split[i]) && !stack.isEmpty()) {
                stack.pollLast();
            } else if (!set.contains(split[i])) {
                stack.offer(split[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollFirst());
        }
        return "".equals(result.toString()) ? "/" : result.toString();
    }

    public static void main(String[] args) {
        _12_SimplifyPath simplifyPath = new _12_SimplifyPath();
//        String result = simplifyPath.simplifyPath("/a/./b/../../c/");
//        String result = simplifyPath.simplifyPath("/home/");
        String result = simplifyPath.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/");
        System.out.println(result);
    }

}
