package com.deepblue.jvm.classloader_01;

/**
 * 对于静态变量的调用而言,定义在父类中不会初始化子类
 *
 * -XX:+TraceClassLoading
 *
 * JVM的参数的格式(JVM参数的三种格式):
        -XX:+<option>		    表示开启JVM的option的选项
        -XX:-<option>		    表示关闭JVM的option的选项
        -XX:<option>=<value>	表示JVM选项赋值的情况

 *
 */
public class MyTest01 {

    public static String str = "mytest01";

    static {
//        System.out.println("this is MyTest01"); 这是后来自定义ClassLoader主动注释掉的,这里标注一下!(测试本程序的时候打开)
    }

    public static void main(String[] args){
//        System.out.println(Child.str);       //调用父类中静态变量只会初始化父类
        System.out.println(Child.str2);      //调用父类中静态变量只会初始化父类
        /**
         * System.out.println(Child.str2);推测结果如下:
         * 1.main方法的首次主动调用会初始化MyTest01
         *      MyTest01中的str=null
         *      System.out.println("this is MyTest01");
         *      str=mytest01
         * 2.首次主动调用,子类初始化触发父类初始化
         *      str=null
         *      System.out.println("this is Parent");
         *      str=parent
         * 3.初始化子类
         *      str=null
         *      System.out.println("this is Child");
         * 4.执行main方法中的打印
         *
         */


    }
}

class Parent {
    public static String str = "parent";

    static {
        System.out.println("this is Parent");
    }
}

class Child extends Parent {
    public static String str2 = "child";

    static {
        System.out.println("this is Child");
    }

}

