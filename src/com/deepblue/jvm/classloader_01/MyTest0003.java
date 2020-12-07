package com.deepblue.jvm.classloader_01;

import java.util.UUID;

/**
 * Created by Administrator on 2019/4/18.
 */
public class MyTest0003 {

    public static void main(String[] args){
        System.out.println(A.aa);
    }
}

interface A {

    public static String aa = UUID.randomUUID().toString();

    public static Thread thread = new Thread(){
        {
            System.out.println("Interface A instance block");
        }
    };
}