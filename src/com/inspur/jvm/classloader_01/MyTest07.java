package com.inspur.jvm.classloader_01;

/**
 * Created by Administrator on 2019/4/15.
 */
public class MyTest07 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("java.lang.String");
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader);
        System.out.println("-------------------------------");

        Class clazz1 = Class.forName("com.inpsur.jvm.classloader_01.Sample");
        System.out.println(clazz1.getClassLoader());
        System.out.println(clazz1.getClassLoader().getParent());
        System.out.println(clazz1.getClassLoader().getParent().getParent());

    }
}

class Sample {

}
