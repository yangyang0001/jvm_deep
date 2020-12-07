package com.deepblue.jvm.classloader_01;

/**
 * Created by Administrator on 2019/4/15.
 */
public class MyTest09 {

    static {
        System.out.println("MyTest09 static block");
    }

    public static void main(String[] args){
        System.out.println(MyChild9.b);
        /**
         * 推测结果:
         * 1.首先main方法是初始化的条件, 运行静态代码块
         *      MyTest09 static block
         * 2.其次主动调用类MyChild9的静态变量,进行初始化,这有满足子类初始化(必须满足所有父类已经被初始化)
         *      MyParent9 static block
         *      MyChild9 static block
         * 3.最后打出MyChild9中静态变量的值9
         *
         * -------------the result is
         * MyTest09 static block
         * MyParent9 static block
         * MyChild9 static block
         * 9
         */
    }


}

class MyParent9{
    public static int a = 3;

    static {
        System.out.println("MyParent9 static block");
    }
}

class MyChild9 extends MyParent9 {
    public static int b = 9;
    static {
        System.out.println("MyChild9 static block");
    }
}
