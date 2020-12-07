package com.deepblue.jvm.classloader_01;

/**
 * 验证了new可以初始化
 *
 * 数组类型是JVM在运行期间生成的一种类型,并且创建一个数组不会被看做对内部内部类型的首次主动调用
 *
 * 数组类型往往表示为[Lcom.inspur.jvm.classloader_01.MyParent4
 *
 * 在JavaDoc中 数组被成为一种组件(component)包装类型,所谓组件就是数组去掉一个维度后的类型,且父类的类型为Object
 *
 * 助记符:
 * anewarray:   表示对引用类型数组的创建,并将数组的引用压入栈顶
 * newarray:    表示对原生数组的创建,并将引用压入栈顶
 *
 */
public class MyTest04 {

    public static void main(String[] args){
//        MyParent4 parent4 = new MyParent4();      //符合首次调用的new 会初始化对象

        MyParent4[] myParent4s = new MyParent4[1];  //不属于对MyParent4的7种情况的主动调用!
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        System.out.println("----------------------------------");

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        short[] shorts = new short[1];
        System.out.println(shorts.getClass());
        System.out.println(shorts.getClass().getSuperclass());

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());
        System.out.println(bytes.getClass().getSuperclass());

        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());
        System.out.println(booleans.getClass().getSuperclass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());
        System.out.println(chars.getClass().getSuperclass());

        System.out.println("----------------------------------");
        String[] strings = new String[1];
        System.out.println(strings.getClass());
        System.out.println(strings.getClass().getSuperclass());



    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}
