package com.ordinaryyzh.javase.thread.books.tij4._07juc._07Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author genericyzh
 * @date 2018/7/9 22:00
 */
public class ExchangerTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Exchanger<String> exchanger = new Exchanger<String>();
        service.execute(() -> {
            try {
                String data1 = "money";
                System.out.println("线程"
                        + Thread.currentThread().getName()
                        + "正在把数据" + data1 + "换出去");
                Thread.sleep((long) (Math.random() * 10000));
                String data2 = (String) exchanger.exchange(data1);
                System.out.println("线程"
                        + Thread.currentThread().getName()
                        + "换回数据为" + data2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        service.execute(() -> {
            try {
                String data1 = "drug";
                System.out.println("线程"
                        + Thread.currentThread().getName() + "正在把数据"
                        + data1 + "换出去");
                Thread.sleep((long) (Math.random() * 10000));
                String data2 = (String) exchanger.exchange(data1);
                System.out.println("线程"
                        + Thread.currentThread().getName() + "换回数据为"
                        + data2);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }
}
/* Output: (Sample)
线程pool-1-thread-1正在把数据money换出去
线程pool-1-thread-2正在把数据drug换出去
线程pool-1-thread-1换回数据为drug
线程pool-1-thread-2换回数据为money
*///:~