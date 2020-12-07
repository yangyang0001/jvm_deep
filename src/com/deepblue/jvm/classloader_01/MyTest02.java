package com.deepblue.jvm.classloader_01;

/**
 *  final类型的常量在编译的阶段直接翻译为调用者常量池中的一部分了,直接变为确定的常量值了,不会触发Parent2的初始化了
 *  反编译Class文件的命令:javap -c MyTest2.class
 *
 *  助记符:
 *  ldc         表示将int, float 或 String 类型的常量值从常量池推送到栈顶
 *  bipush      表示将单字节(-128 - 127)的常量值推送至栈顶
 *  sipush      表示将短整形常量值(-32768 - 32767)推送至栈顶
 *  iconst_1    表示将int类型的1推送至栈顶(iconst_m1,iconst_0 - iconst_5)
 */
public class MyTest02 {

    public static void main(String[] args){
        System.out.println(Parent2.a);
    }
}

class Parent2 {

    public static final String str = "hello world";

    public static final short s = 7;

    public static final int a = 2;

    static {
        System.out.println("Parent2 static block");
    }

}

