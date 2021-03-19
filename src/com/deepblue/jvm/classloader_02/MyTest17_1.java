package com.deepblue.jvm.classloader_02;

/**
 *
 *  关于命名空间的解释:(特别重要)
        1.	子加载器可以访问父加载器加载的类
        2.	父加载器不可以访问子加载器加载的类
 */
public class MyTest17_1 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setFilePrefix("C:\\Users\\Administrator\\Desktop\\study_jvm\\");
        Class<?> clazz1 = loader1.loadClass("com.deepblue.jvm.classloader_02.MySample");
        Object object1 = clazz1.newInstance();
        System.out.println("clazz hasecode --------------------:" + clazz1.hashCode());
        /**
         * I.删除掉classpath中的MySample.class和MyCat.class文件,filePrefix中有这两个文件
         * 分析:
         * 1.首先创建一个ClassLoader 命名为loader1
         * 2.loader1.loadClass()方法执行,首先双亲委派给AppClassLoader进行加载,但是没有找到,只能到有当前的loader1对象执行findClass进行加载MySample
         *   会执行MyTest16中的findClass()方法中的两行语句
         *      System.out.println("findClass invoked className -------:" + name);
         *      System.out.println("classLoader name ------------------:" + classLoaderName);
         * 3.执行newInstance
         *      System.out.println("MySample load is by " + this.getClass().getClassLoader());
         *      new MyCat();
         * 4.因执行new MyCat()所以会首先加载,连接,初始化 这里的加载是由加载MySample.class的类加载器loader1加载的,双亲委派AppClassLoader,没有找到;所以执行loader1中的
         *   findClass()方法
         *      System.out.println("findClass invoked className -------:" + name);
         *      System.out.println("classLoader name ------------------:" + classLoaderName);
         *      System.out.println("MyCat load is by " + this.getClass().getClassLoader());
         *
         * the last result is
         *      findClass invoked className -------:com.deepblue.jvm.classloader_02.MySample
         *      classLoader name ------------------:loader1
         *      MySample load is by loader1
         *      findClass invoked className -------:com.deepblue.jvm.classloader_02.MyCat
         *      classLoader name ------------------:loader1
         *      MyCat load is by loader1
         *      clazz hasecode --------------------:
         *
         *
         *
         *
         *
         * II.删除掉classpath中的MyCat.class文件,但是要保留MySample.class
         * 1.首先创建一个ClassLoader 命名为loader1
         * 2.loader1.loadClass()方法执行,首先双亲委派给AppClassLoader进行加载,classpath中有MySample.class可以加载,不会执行MyTest16中的findClass()方法中的两行语句
         * 3.执行newInstance
         *      System.out.println("MySample load is by " + this.getClass().getClassLoader());
         *      new MyCat();
         * 4.因执行new MyCat()所以会首先加载,连接,初始化 这里的加载是由加载MySample.class的类加载的,AppClassLoader没有加载到
         *   会抛出异常!
         *
         *
         *
         *
         * III.删除掉classpath中的MySample.class文件,但是要保留MyCat.class
         * 1.首先创建一个ClassLoader 命名为loader1
         * 2.loader1.loadClass()方法执行,首先双亲委派给AppClassLoader进行加载,classpath中没有MySample.class,有loader1进行加载,会执行MyTest16中的findClass()方法中的两行语句
         *      System.out.println("findClass invoked className -------:" + name);
         *      System.out.println("classLoader name ------------------:" + classLoaderName);
         * 3.执行newInstance
         *      System.out.println("MySample load is by " + this.getClass().getClassLoader());
         *      new MyCat();
         * 4.因执行new MyCat()所以会首先加载,连接,初始化 这里的加载是由加载MySample.class的类加载器loader1加载的,双亲委派给AppClassLoader进行加载
         *   不会执行loader1中的findClass(),执行MyCat的构造执行以下语句
         *      System.out.println("MyCat load is by " + this.getClass().getClassLoader());
         *the last result is
         *
         *      findClass invoked className -------:com.deepblue.jvm.classloader_02.MySample
         *      classLoader name ------------------:loader1
         *      MySample load is by loader1
         *      MyCat load is by sun.misc.Launcher$AppClassLoader@75b84c92
         *      clazz hasecode --------------------:
         */

    }
}
