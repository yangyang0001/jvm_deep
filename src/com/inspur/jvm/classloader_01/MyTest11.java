package com.inspur.jvm.classloader_01;

/**
 * Created by Administrator on 2019/4/15.
 */
public class MyTest11 {

    public static void main(String[] args){
        System.out.println(MyChild11.a);
        System.out.println("-------------------------------");
        MyChild11.doSometing();
    }
}

class MyParent11{
    public static int a = 3;

    static {
        System.out.println("MyParent11 static block");
    }

    public static void doSometing(){
        System.out.println("MyParent11 doSometing invoked");
    }
}

class MyChild11 extends MyParent11{
    static {
        System.out.println("MyChild11 static block");
    }
}