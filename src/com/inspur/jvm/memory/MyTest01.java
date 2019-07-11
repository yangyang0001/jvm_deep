package com.inspur.jvm.memory;

/**
 * JVM内存空间的介绍:
 *     1.本地方法栈
 *     2.java虚拟机栈(Stack Frame Collection就是栈帧集合)
 *     3.方法区
 *          3.1方法区中的运行时常量池
 *     4.堆(Heap)
 *     5.程序计数器
 *     6.直接内存(Direct Memory)
 */
public class MyTest01 {

    public static void main(String[] args) throws Exception{
        Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("com.inspur.jvm.memory.MyTest01");
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getName());
    }
}
