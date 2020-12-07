package com.deepblue.jvm.class_structure;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 针对与方法动态调用的过程,在JVM中方法区中建立了一种数据结构(vritual table 简称 vtable),来处理这种动态调用的过程！
 * 对于invokeinterface的使用,采用了interface table的方式进行动态查找的过程, (interface table 简称 itable)
 */
public class MyTest07 {

    public static void main(String[] args){
        Animal animal1 = new Animal();
        Animal animal2 = new Dog();

        animal1.test("aaa");
        animal1.test(new Date());

        System.out.println("------------------------------");

        animal2.test("ddd");
        animal2.test(new Date());

        /**
         * 分析:
         *      首先调用animal1中的两个方法,重载属于静态解析的,所以animal1中的方法两个方法得到调用
         *      其次是用animal2的调用,属于重写,重写属于动态解析的过程,从Dog实例中找到对应的两个方法
         * 所以:
         * the last result is :
         *
         *      animal str aaa
         *      animal date ....
         *      ------------------------------
         *      dog str ddd
         *      dog date ....
         *
         *
         */

    }
}

class Animal {
    public void test(String str){
        System.out.println("animal str " + str);
    }

    public void test(Date date){
        System.out.println("animal date " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }
}


class Dog extends Animal {
    @Override
    public void test(String str) {
        System.out.println("dog str " + str);
    }

    @Override
    public void test(Date date) {
        System.out.println("dog date " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }
}