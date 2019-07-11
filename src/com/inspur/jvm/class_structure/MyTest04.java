package com.inspur.jvm.class_structure;

/**
 * 栈帧: (stack frame)
 *      栈帧是java虚拟机中帮助JVM进行方法调用和方法执行的数据结构。
 *
 *      栈帧既然是一种数据结构,内部封装了方法的局部变量表、操作数栈、动态链接、方法的返回地址等信息。
 *
 *      符号引用    直接引用
 *
 *      有一些符号引用是在编译期或第一次使用时就会转换成直接引用,这种转换称之为静态解析
 *      有一些符号引用是在每一次运行期才转换成直接引用,这种解析过程称之为动态链接!
 *
 */

/**
 * JVM中对方法的调用采用了5中指令或助记符来表示方法的调用：
 *  1.invokeinterface   :调用接口的某个方法,实际上是在运行期在进行决定到底是哪一个实现类实例的方法调用。
 *  2.invokestatic      :调用静态方法。
 *  3.invokespecial     :调用自己的私有方法,构造方法(<init>),父类中的方法。
 *  4.invokevirtual     :调用虚方法,运行期动态查找的过程。
 *  5.invokedynamic     :动态调用方法。
 *
 *
 *  对于以下四种方法的引用称之为非虚引用,这种非虚引用的都是静态解析!
 *      1.静态方法
 *      2.父类方法
 *      3.构造方法
 *      4.当前类中的私有方法
 */
public class MyTest04 {

    public static void test(){
        System.out.println("test invoked");
    }

    public static void main(String[] args){
        test();
    }
}
