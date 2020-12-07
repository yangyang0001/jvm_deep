package com.deepblue.jvm.classloader_02;

import java.lang.reflect.Method;

/**
 * 本程序抛出异常!重新理解类加载器的命名空间
 * 1.子类加载器可以访问父加载器加载的类
 * 2.父加载器 不可以访问子加载器加载的类
 * 3.不同命名空间的类是不可见的!
 */
public class MyTest21 {

    public static void main(String[] args) throws Exception{

        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setFilePrefix("C:\\Users\\Administrator\\Desktop\\study_jvm\\");
        Class<?> clazz1 = loader1.loadClass("com.deepblue.jvm.classloader_02.MyPerson");

        MyTest16 loader2 = new MyTest16("loader2");
        loader1.setFilePrefix("C:\\Users\\Administrator\\Desktop\\study_jvm\\");
        Class<?> clazz2 = loader2.loadClass("com.deepblue.jvm.classloader_02.MyPerson");

        System.out.println(clazz1 == clazz2);
        System.out.println(loader1.getParent() == loader2.getParent());

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
//        method.invoke(object1, object2);



        /**
         * 分析:
         * loader1.loadClass(),双亲委派给AppClassLoader加载MyPerson.class
         * loader2.loadClass(),双亲委派给AppClassLoader加载MyPerson.class,
         * 发现已经被加载所以clazz2和clazz1是同一个class
         * the last result is
         *      true
         *      true
         *
         *
         * 删除掉classpath下的MyPerson.class后的结果:
         * 分析:
         * 1.首先loader1.loadClass(),委派双亲AppClassLoader加载MyPerson.class,没有找到只能自己加载了
         *      System.out.println("findClass invoked className -------:" + name);
         *      System.out.println("classLoader name ------------------:" + classLoaderName);
         * 2.loader2.loadClass(),委派双亲AppClassLoader加载MyPerson.class,没有找到只能自己加载了
         *      System.out.println("findClass invoked className -------:" + name);
         *      System.out.println("classLoader name ------------------:" + classLoaderName);
         * 3.不同的loader加载,造成class不同
         *
         * the last result is
         *      false
         *      true
         */
    }
}
