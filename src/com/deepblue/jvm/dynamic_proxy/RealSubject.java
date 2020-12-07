package com.deepblue.jvm.dynamic_proxy;

/**
 * Created by Administrator on 2019/4/21.
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("From real Subject");
    }
}
