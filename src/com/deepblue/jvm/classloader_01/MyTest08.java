package com.deepblue.jvm.classloader_01;

import java.util.Random;

/**
 * final的理解,即对常量的理解
 */
public class MyTest08 {

    public static void main(String[] args){
        System.out.println(FinalTest.x);
    }
}

class FinalTest {

    public static final int x = new Random().nextInt(10);

    static {
        System.out.println("FinalTest static block");
    }
}
