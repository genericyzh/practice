package com.ordinaryyzh.javase.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author genericyzh
 * @date 2018/3/27 18:47
 */
public class SecurityExceptionTest {

    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.replace(".", "/") + ".class";
                    InputStream is = getClass().getResourceAsStream("/" + fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (ClassNotFoundException e) {
                    throw new ClassNotFoundException(e.getMessage(), e);
                } catch (IOException e) {
                    throw new ClassNotFoundException(e.getMessage(), e);
                }
            }
        };
        Object obj = myLoader.loadClass("java.lang.String").newInstance();

        System.out.println(obj.getClass());
    }

}