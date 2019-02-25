package com.ordinaryyzh.javase.thread.books.sevenweek.day1._03Puzzle;

/**
 * @author OrdinaryYZH
 * @date 2018/6/27 0:55
 */
public class Puzzle3 {
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
            // answerReady可能不会变成true，代码运行后无法退出
            while (true) {
                if (!answerReady) {
                    System.out.println("The meaning of life is: " + answer);
                    break;
                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("answerReady is false");
            }
//            System.out.println("The meaning of life is: " + answer);
        }
    };

    public static void main(String[] args) throws InterruptedException {
        // 有机会跑出死循环的程序
        t1.start();
//        Thread.sleep(1); // 好像加了这句之后，t2都识别不出answerReady了，死循环
        t2.start();
//        t1.join();
//        t2.join();
    }
}
