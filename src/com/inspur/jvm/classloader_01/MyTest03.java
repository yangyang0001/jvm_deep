package com.inspur.jvm.classloader_01;

import java.util.UUID;

/**
 *  对于final类型的常量,因为是当前的常量是在运行期间确定的值,这样就会初始化MyParent.class文件
 *
 *  当final类型的常量str无法在编译期确认,那么这个值就不会初始化到调用类的常量池之中,这样就导致被调用的类进行初始化
 */
public class MyTest03 {

    public static void main(String[] args){
        System.out.println(MyParent3.str);
    }
}


class MyParent3 {
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static block");
    }
}