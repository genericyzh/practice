package com.genericyzh.javase.thread.base.sevenweek.day1._03Puzzle;

/**
 * @author genericyzh
 * @date 2018/6/27 0:55
 */
public class Puzzle2 {
    static boolean answerReady = false;
    static int answer = 0;
    static Thread t1 = new Thread() {
        @Override
        public void run() {
            answer = 42;
            answerReady = true;
        }
    };
    static Thread t2 = new Thread() {
        @Override
        public void run() {
            // answerReady可能不会变成true，代码运行后无法退出，HB关系？？
            while (!answerReady) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("answerReady is false");
            }
            System.out.println("The meaning of life is: " + answer);
        }
    };

    public static void main(String[] args) throws InterruptedException {
        // 有机会跑出死循环的程序，但是没跑出来。。。暂时没看出跑不出来的问题20180627;跟Puzzle3的区别是while的条件
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
