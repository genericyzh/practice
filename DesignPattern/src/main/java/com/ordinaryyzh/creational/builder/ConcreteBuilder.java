package com.ordinaryyzh.creational.builder;

/**
 * @author OrdinaryYZH
 * @date 2018/12/13 23:23
 * 具体的生成器实现对象
 */
public class ConcreteBuilder implements Builder {

    /**
     * 生成器最终构建的产品对象
     */

    private Product resultProduct;

    /**
     * 获取生成器最终构建的产品对象
     *
     * @return 生成器最终构建的产品对象
     */

    public Product getResult() {

        return resultProduct;

    }


    public void buildPart() {

        //构建某个部件的功能处理

    }

}

