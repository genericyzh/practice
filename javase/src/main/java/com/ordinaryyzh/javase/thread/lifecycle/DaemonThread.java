package com.ordinaryyzh.javase.thread.lifecycle;

/**
 * @author genericyzh
 * @date 2018/6/26 21:09
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Orz");
            }
        });
        thread.setDaemon(true); // Thread默认的daemon是false
        thread.start();
//        thread.join(); // 去掉注解后死循环，因为在等thread执行完再继续执行
    }
}
