package com.deepblue.jvm.classloader_01;

/**
 * User: YANG
 * Date: 2019/5/10-10:07
 * Description: No Description
 */
public class MyTest_0003 {
    public static void main(String[] args){
        System.out.println(YANG.a);
    }
}

class YANG {
    public static int a = 10;
    static {
        System.out.println("YANG");
    }
}
