package com.ordinaryyzh.creational.builder;

/**
 * 生成器接口，定义创建一个产品对象所需的各个部件的操作
 *
 * @author genericyzh
 * @date 2018/12/13 23:22
 */

public interface Builder {

    /**
     * 示意方法，构建某个部件
     */

    void buildPart();

}
