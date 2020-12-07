package com.deepblue.jvm.classloader_01;

/**
 * Created by Administrator on 2019/4/15.
 */
public class MyTest10 {

    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args){

        MyParent10 myParent10;

        System.out.println("-----------------------------------");

        myParent10 = new MyParent10();

        System.out.println("-----------------------------------");

        System.out.println(myParent10.a);

        System.out.println("-----------------------------------");

        System.out.println(MyChild10.b);

        /**
         * 代码分析:
         * 1.首先main()所在的类进行初始化
         *      MyTest10 static block
         * -----------------------------------
         * 2.new MyParent10(),进行当前类的初始化
         *      MyParent10 static block
         *-----------------------------------
         * 3.打印实例中的最终a的静态变量值为3
         *      3
         *-----------------------------------
         * 4.对MyChild10进行静态变量的访问,需要初始化,因为父类已经被初始化,所以这里只对当前类进行初始化
         *      MyChild10 static block
         * 5.打印MyChild10中静态变量经过初始化后的值4
         *      4
         * the result is
         *
         *
         * MyTest10 static block
         * -----------------------------------
         * MyParent10 static block
         * -----------------------------------
         * 3
         * -----------------------------------
         * MyChild10 static block
         * -----------------------------------
         * 4
         *
         *
         *
         */

    }

}

class MyParent10{
    public static int a = 3;

    static {
        System.out.println("MyParent10 static block");
    }
}

class MyChild10 extends MyParent10 {
    public static int b = 4;

    static {
        System.out.println("MyChild10 static block");
    }
}
