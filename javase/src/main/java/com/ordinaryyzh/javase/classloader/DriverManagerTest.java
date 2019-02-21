package com.ordinaryyzh.javase.classloader;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * @author genericyzh
 * @date 2018/9/16 12:11
 */
public class DriverManagerTest {
    public static void main(String[] args) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        ClassLoader pcl = cl.getParent();
        System.out.println("当前类加载器；" + cl);
        System.out.println("父类加载器；" + pcl);
//        Thread.currentThread().setContextClassLoader(pcl);

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            System.out.println(driver);
        }
        System.out.println("finished");
    }
}
