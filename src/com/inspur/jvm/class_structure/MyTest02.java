package com.inspur.jvm.class_structure;

/**
 *I.-----------------------------------------------------------------------------------
 *  可重入锁:    一个线程获取到当前对象的(this)的锁,同样可以进入当前对象的另外一个用synchronized修饰的实例方法(同样是锁住的当前对象this),可重入锁是对单个线程来说的
 *  非可重入锁:  当一个线程A进入到synchronized修饰的实例方法时,没有退出!另外一个线程B同样访问当前的方法就不会进入了!往往会有两种结果
 *                  结果1:    线程B 阻塞
 *                  结果2:    线程B 自旋
 *
 * synchronized 如果修饰方法可以修改两种方法: 实例方法和静态方法
 * I.   如果修饰的是实例方法 代表给当前对象(this)加锁,并且synchronized锁实例方法是可重入锁!
 * II.  如果修饰的是静态方法 代表给当前对象的Class对象上锁,表示类锁!
 *
 * synchronized在方法内部的时候,经过编译后产生的助记符有两种:
 *      monitorenter
 *      monitorexit
 *II.-----------------------------------------------------------------------------------
 *从反编译后的Method中可以看出来
 *      1.非静态的成员变量是从构造方法<init>中完成最终赋值的!
 *      2.静态变量是从<clinit>中完成赋值的!
 */
public class MyTest02 {

    String str = "Welcome";
    private int x = 5;
    public static Integer in = 10;

    public static void main(String[] args){
        MyTest02 myTest02 = new MyTest02();
        myTest02.setX(8);
        in = 20;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    private synchronized void test1(String str){
        System.out.println("hello world test1 " + str);
    }

    private void test2(String str){
        synchronized (str) {
            System.out.println("hello world test2 " + str);
        }
    }

    private static synchronized void test3(String str){
        System.out.println("hello world test3 " + str);
    }

    private static void test4(String str){
        synchronized (str) {
            System.out.println("hello world test4 " + str);
        }
    }

}
