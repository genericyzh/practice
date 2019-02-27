package com.ordinaryyzh.domain;

/**
 * @author OrdinaryYZH
 * @date 2019/2/27 22:22
 */
public class TestBean {

    private TestArrayBean testArrayBean;

    public TestArrayBean getTestArrayBean() {
        return testArrayBean;
    }

    public void setTestArrayBean(TestArrayBean testArrayBean) {
        this.testArrayBean = testArrayBean;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "testArrayBean=" + testArrayBean +
                '}';
    }
}
