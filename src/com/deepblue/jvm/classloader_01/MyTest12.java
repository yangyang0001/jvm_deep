package com.deepblue.jvm.classloader_01;

/**
 * ClassLoader.loadClass()并不满足初始化的7种首次主动调用的情况,所以不会初始化CL类
 * Class.forName()是7中对类的主动使用,可以进行初始化
 */
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("com.inpsur.jvm.classloader_01.CL");
        System.out.println(clazz);

        System.out.println("----------------------------------------------------");

        clazz = Class.forName("com.inpsur.jvm.classloader_01.CL");
        System.out.println(clazz);
    }
}

class CL {
    static {
        System.out.println("CL static block");
    }
}
