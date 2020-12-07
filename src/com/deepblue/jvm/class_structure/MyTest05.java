package com.deepblue.jvm.class_structure;

/**
 *
 * 本程序充分说明了:重载就动态解析的过程! 重载是一种静态行为!
 *
 * 一个变量的类型分为    静态类型(声明类型) ,动态类型(引用类型)
 */
public class MyTest05 {

    //方法的重载是一种静态行为, 是在编译期可以完成的!
    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args){
        Grandpa grandpa1 = new Father();
        Grandpa grandpa2 = new Son();

        MyTest05 myTest05 = new MyTest05();

        myTest05.test(grandpa1);
        myTest05.test(grandpa2);
    }
}

class Grandpa{

}

class Father extends Grandpa {

}

class Son extends Father {

}
