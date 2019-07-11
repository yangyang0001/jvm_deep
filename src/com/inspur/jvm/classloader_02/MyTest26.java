package com.inspur.jvm.classloader_02;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 如果不做任何的设置,那么线程的上下文的类加载器就是AppClassLoader加载器
 * 线程上下文的类加载器的使用过程(获取 -> 使用 -> 还原) 以下是伪代码的体现形式,以后使用的话必须遵循这个规则
 *
 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();    //获取
 * try{
 *     Thread.currentThread().setContextClassLoader(targetContextClassLoader);  //使用
 *     myMethod();
 * } catch(ex){
 *
 * } finally {
 *     Thread.currentThread().setContextClassLoader(classLoader);               //还原
 * }
 *
 * 在myMethod()中会调用Thread.currentThread().getClassLoader()来加载某些类!
 * ContextClassLoader的作用就是为了破坏java原生的双亲委派加载机制!
 * 当高层的类加载实例化或访问一些低层的 类加载器 加载的类的时候, 必须修改当前的类加载器的类型,
 * 这时候就必须调用Thread.currentThread().setContextClassLoader(底层类加载器),来访问或实例化低层类加载器加载的类,使用完成后还原上下文类加载器
 *
 */
public class MyTest26 {

    public static void main(String[] args){

        /**
         * 下面一句话就是为了验证线程上下文ClassLoader的改变带来了效果
         */
//        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();

        while(iterator.hasNext()){
            Driver driver = iterator.next();
            System.out.println("driverClass -------------------------:" + driver.getClass() + "; " +
                               "driverClassLoader -------------------:" + driver.getClass().getClassLoader());
            System.out.println("=======================================================================================");
        }
        //没有对Thread.currentThread().setContextLoader()做任何设置,这里就是AppClassLoader
        System.out.println("contextClassLoader ------------------:" + Thread.currentThread().getContextClassLoader());
        //java.util 包中的类,有根类加载器 或 启动类加载器 加载!
        System.out.println("ServiceLoader classLoader -----------:" + ServiceLoader.class.getClassLoader());
    }

}
