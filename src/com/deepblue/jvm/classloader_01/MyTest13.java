package com.deepblue.jvm.classloader_01;

/**
 * Created by Administrator on 2019/4/15.
 */
public class MyTest13 {

    public static void main(String[] args){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
