package com.deepblue.jvm.classloader_01;

/**
 * Created by Administrator on 2019/4/16.
 */
public class MyTest_0002 {

    public static void main(String[] args){


    }
}

class MyParent12 {

    public void sayHello(){
        System.out.println("Hello world MyParent12");
    }

}

class MyChild12 extends  MyParent12 {
    public void sayHello(){
        System.out.println("Hello world MyChild12");
    }
}
