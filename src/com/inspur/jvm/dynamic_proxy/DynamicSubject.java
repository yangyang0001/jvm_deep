package com.inspur.jvm.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/4/21.
 */
public class DynamicSubject implements InvocationHandler{

    private Object object;

    public DynamicSubject(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before invoked calling ...");

        method.invoke(this.object, args);

        System.out.println("after  invoked calling ...");

        return null;
    }
}
