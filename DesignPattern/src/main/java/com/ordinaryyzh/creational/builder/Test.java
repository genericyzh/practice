package com.ordinaryyzh.creational.builder;

/**
 * @author OrdinaryYZH
 * @date 2018/12/13 23:24
 */
public class Test {

    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Director director = new Director(concreteBuilder);
        director.construct();
        concreteBuilder.getResult();
    }

}
