package com.deepblue.jvm.classloader_02;

import sun.misc.Launcher;

/**
 * 在运行期 一个java类是由该类的完全限定名binary name 和 用于加载该类的定义类加载器 所共同决定的!
 * 1.binary name    2.定义类加载器
 *
 *
 * 在Oracle的HotSpot中的sun.boot.class.path如果修改错了,会造成根类加载器无法加载所有的java.lang.* 提供的基础的类
 * 报出以下错误:
 *      Error occurred during initialization of VM
 *      java/lang/NoClassDefFoundError: java/lang/Object
 *
 * 提出疑问:AppClassLoader和ExtClassLoader是由哪个类加载器加载呢?
 * 1.JVM启动时由根类加载器加载java.lang.ClassLoader和其他相关的java平台类
 * 2.JVM启动时首先会初始化C++语言创建的BootStrapClassLoader(根类加载器或启动类加载器),启动类加载器和平台相关,由启动类加载器加载 ExtClassLoader和AppClassLoader
 * 3.启动类加载器负责整个加载过程!除了启动类加载器之外所有的ClassLoader都被实现为java类
 * 4.启动类加载器还负责加载JRE平台运行相关的一些基类,例如java.lang.Object,java.util.*等
 *
 *
 *
 * ClassLoader类javadoc中的重要方法的归纳总结:
 * I.ClassLoader.getSystemClassLoader()
 *      1.默认情况下是所有自定义类加载器的双亲,证明这个方法返回的就是AppClassLoader
 *      2.本方法返回的ClassLoader,同样会作为Thread.currentThread.getContextClassLoader
 *
 */
public class MyTest23 {

    public static void main(String[] args){
        //根类加载器的加载路径
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("---------------------------------------");

        //扩展类加载器加载的路径,这个只能打成jar 放在指定的目录下才能加载!
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("---------------------------------------");

        //应用类加载器的加载路径
        System.out.println(System.getProperty("java.class.path"));

        System.out.println("---------------------------------------");
        //打印出三种不同的类加载器
        ClassLoader myClassLoader = new MyTest16("myloader");
        ClassLoader appClassLoader = MyTest23.class.getClassLoader();
        ClassLoader extClassLoader = MyTest23.class.getClassLoader().getParent();
        ClassLoader bootClassLoader = MyTest23.class.getClassLoader().getParent().getParent();

        System.out.println(myClassLoader);
        System.out.println(appClassLoader);
        System.out.println(extClassLoader);
        System.out.println(bootClassLoader);

        System.out.println("---------------------------------------");
        //分别验证三种类加载器的加载器是什么
        System.out.println(myClassLoader.getClass().getClassLoader());
        System.out.println(appClassLoader.getClass().getClassLoader());
        System.out.println(extClassLoader.getClass().getClassLoader());

        System.out.println(Launcher.class.getClassLoader());
        System.out.println("---------------------------------------");
        System.out.println(ClassLoader.getSystemClassLoader());

        System.setProperty("java.system.class.loader","com.inspur.jvm.classloader_02.MyTest16");
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
    }
}
