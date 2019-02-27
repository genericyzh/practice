package com.ordinaryyzh.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author OrdinaryYZH
 * @date 2019/2/27 22:22
 */
public class TestArrayBean {
    private List integers = new ArrayList();

    public List getIntegers() {
        return integers;
    }

    public void setIntegers(List integers) {
        this.integers = integers;
    }

    @Override
    public String toString() {
        return "TestArrayBean{" +
                "integers=" + integers +
                '}';
    }
}
