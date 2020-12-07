package com.deepblue.jvm.classloader_02;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/4/17.
 */
public class MyTest20 {

    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");
        Class<?> clazz1 = loader1.loadClass("com.deepblue.jvm.classloader_02.MyPerson");

        MyTest16 loader2 = new MyTest16("loader2");
        Class<?> clazz2 = loader2.loadClass("com.deepblue.jvm.classloader_02.MyPerson");

        System.out.println(clazz1 == clazz2);
        System.out.println(loader1.getParent() == loader2.getParent());

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);



        /**
         * 分析:
         * loader1.loadClass(),双亲委派给AppClassLoader加载MyPerson.class
         * loader2.loadClass(),双亲委派给AppClassLoader加载MyPerson.class,
         * 发现已经被加载所以clazz2和clazz1是同一个class
         * the last result is
         *      true
         *      true
         *
         */

    }
}
