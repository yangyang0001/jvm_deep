package com.deepblue.jvm.classloader_02;

/**
 * Created by Administrator on 2019/4/17.
 */
public class MyTest18 {

    public static void main(String[] args){
        //不同的类加载器加载的路径是不一样的

        //根类加载器的加载路径
        System.out.println(System.getProperty("sun.boot.class.path"));
        //扩展类加载器加载的路径,这个只能打成jar 放在指定的目录下才能加载!
        System.out.println(System.getProperty("java.ext.dirs"));
        //应用类加载器的加载路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
