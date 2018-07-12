//: net/mindview/util/DaemonThreadFactory.java
package com.genericyzh.javase.thread.books.tij4._01base._08DaemonThread;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
} ///:~
