package com.deepblue.jvm.classloader_02;

/**
 * Thread.currentThread().getContextClassLoader(),Thread.currentThread().setContextClassLoader()
 * 如果不调用Thread.currentThread().getContextClassLoader()  默认就是AppClassLoader作为当前线程上下文的类加载器!
 *
 * 为了解决有些类或接口的加载是用根类加载器或扩展类加载器来加载的,这样这些接口就无法满足SPI的要求,因此就提出了Thread.currentThread().setContextClassLoader()
 * 解决了当前的问题,这就打破了原始的双亲委派模式!
 */
public class MyTest24 {

    public static void main(String[] args){
//        System.out.println(Thread.currentThread().getContextClassLoader());
//        System.out.println(Thread.class.getClassLoader());
        String str1 = new String("abc");
        String str2 = "abc";
    }
}
