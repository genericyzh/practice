package com.ordinaryyzh.javase.thread.memoryvisibility;

/**
 * @author OrdinaryYZH
 * @date 2018/6/27 12:45
 */
public class Main extends Thread {
    private static boolean flag = false;

    @Override
    public void run() {
        while (!flag) {
            //System.out.flush();
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        try {
            m.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
