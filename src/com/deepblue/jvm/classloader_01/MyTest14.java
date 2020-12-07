package com.deepblue.jvm.classloader_01;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by Administrator on 2019/4/15.
 */
public class MyTest14 {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        String resourceName = "com/inpsur/jvm/classloader_01/MyTest13.class";
        Enumeration<URL> urls =  classLoader.getResources(resourceName);

        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }
    }
}
