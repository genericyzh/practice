package com.genericyzh.javase.thread.base.sevenweek.day1._01HelloWorld;

/**
 * @author genericyzh
 * @date 2018/6/27 13:57
 */
public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello from new thread");
            }
        };

        myThread.start();
        Thread.yield(); // 通知调度器：当前线程让出对处理器的占用
        System.out.println("Hello from main thread");
        myThread.join(); // main线程等待myThread线程结束
    }
}
