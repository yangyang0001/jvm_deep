package com.deepblue.jvm.classloader_02;

/**
 * Created by Administrator on 2019/4/17.
 */
public class MyTest25 implements Runnable {

    private Thread thread;

    public MyTest25(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.class.getClassLoader());
        ClassLoader classLoader = this.thread.getContextClassLoader();
        thread.setContextClassLoader(classLoader);

        System.out.println("classloader class: ----------------:" + classLoader.getClass());
        System.out.println("classloader parent class: ---------:" + classLoader.getParent().getClass());
    }

    public static void main(String[] args){
        MyTest25 myTest25 = new MyTest25();
        /**
         * 分析:
         * 1.因为有main方法,所以会加载, 连接, 初始化 MyTest25  加载根据双亲委托模型,首先使用AppClassLoader加载MyTest25
         *
         * 2.如果没有调用Thread.currentThread().setContextClassLoader()方法,默认的ContextClassLoader就是AppClassLoader
         *
         * the last result is
         *      AppClassLoader
         *      ExtClassLoader
         *
         */
    }
}
