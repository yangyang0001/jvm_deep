package com.inspur.jvm.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2019/4/21.
 */
public class Client {

    public static void main(String[] args) {
        //这个参数在 ProxyGenerator 类中,这个类是sun.misc包下,直接查看源码就OK了
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        RealSubject rs = new RealSubject();
        InvocationHandler handler = new DynamicSubject(rs);
        Class<?> clazz = rs.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(), handler);

        subject.request();
    }
}
