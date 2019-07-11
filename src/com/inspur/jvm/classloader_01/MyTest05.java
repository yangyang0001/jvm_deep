package com.inspur.jvm.classloader_01;

import java.util.Random;

/**
 * 1.当一个接口在初始化的时候,父接口不初始化
 * 2.当一个类初始化的时候,其父接口不初始化
 */
public class MyTest05 {

    public static void main(String[] args){
        System.out.println(MyChild5.param);
    }

}

interface  MyParent5 {

    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5 初始化完成!");
        }
    };

}

interface MyChild5 extends MyParent5 {

    public static int param = new Random().nextInt(3);

    public static Thread thread = new Thread(){
        {
            System.out.println("MyChild5 初始化完成!");
        }
    };

}
