package com.ordinaryyzh.creational;

/**
 * @author OrdinaryYZH
 * @date 2018/3/16 17:29
 */
public class Singleton3 {

    static {
        System.out.println(Holder.instance);
    }

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return Holder.instance;
    }

    // 主要是使用了 嵌套类可以访问外部类的静态属性和静态方法的特性
    private static class Holder {
        static {
            System.out.println("静态内部类被加载");
        }

        private static Singleton3 instance = new Singleton3();
    }

    public static void main(String[] args) {
        Singleton3 singleton3 = new Singleton3();
        System.out.println("华丽分割线");
        Singleton3 instance = Singleton3.getInstance();
    }
}
