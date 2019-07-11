package com.inspur.jvm.classloader_01;

/**
 * ClassLoader源码解析
 */
public class MyTest15 {

    public static void main(String[] args){

        String[] strings = new String[2];
        Class<?> clazz = strings.getClass();
        System.out.println(clazz.getClassLoader());             //这个null是根类加载器

        System.out.println("---------------------");

        MyTest15[] myTest15s = new MyTest15[1];
        System.out.println(myTest15s.getClass().getClassLoader());
        System.out.println("---------------------");

        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());   //这个null,表示没有classLoader

    }
    /**
     * 非原生类型的数组的类加载器 为 数组内数据类型的类加载器
     * 原生类型的数组的类加载器 为 null
     */
}
