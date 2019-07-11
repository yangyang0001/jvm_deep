package com.inspur.jvm.class_structure;

/**
 * 本程序是对重写和重载的理解
 *
 * the last result is:
 *
 *      demo equals invoked
 *      the second line
 */
public class DynamicMethodTest {

    public static void main(String[] args){

        Object o1 = new Demo();
        Object o2 = new Demo();

        Demo o3 = new Demo();
        Demo o4 = new Demo();

        if(o1.equals(o2)){
            System.out.println("the first line");
        }

        if(o3.equals(o4)){
            System.out.println("the second line");
        }

    }

}

class Demo {
    public boolean equals (Demo demo){
        System.out.println("demo equals invoked");
        return true;
    }
}
