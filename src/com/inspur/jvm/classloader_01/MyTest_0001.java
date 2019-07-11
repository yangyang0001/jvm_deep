package com.inspur.jvm.classloader_01;

import java.util.UUID;

/**
 * Created by Administrator on 2019/4/16.
 */
public class MyTest_0001 {

    public static void main(String[] args){

        System.out.println(DDDD.aa);
        /**
         * 分析:
         * 1.DDDD.aa中的aa属性属于常量类型,但是编译期间不能确认是多少,所以必须进行初始化对AAAA
         * 2.DDDD中没有直接定义的静态变量的访问所以不对DDDD进行初始化
         *
         * the result is
         *
         * AAAA instance block
         * UUID.randomUUID().toString()
         */

    }
}

interface AAAA{

    public static String aa = UUID.randomUUID().toString();

    public static Thread thread = new Thread(){
        {
            System.out.println("AAAA instance block");
        }
    };
}

interface BBBB extends AAAA {

    public static String bb = "BBBB";

    public static Thread thread = new Thread(){
        {
            System.out.println("BBBB instance block");
        }
    };

}

class CCCC implements BBBB {

    public static String cc = "CCCC";

    static {
        System.out.println("CCCC static block");
    }
}

class DDDD extends  CCCC {

    public static String dd = "DDDD";

    static {
        System.out.println("DDDD static block");
    }

}
