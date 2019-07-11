package com.inspur.jvm.classloader_02;

/**
 * Created by Administrator on 2019/4/16.
 */
public class MyTest17 {

    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setFilePrefix("C:\\Users\\Administrator\\Desktop\\study_jvm\\");
        Class<?> clazz1 = loader1.loadClass("com.inspur.jvm.classloader_02.MySample");
//        Object object1 = clazz1.newInstance();
        System.out.println("clazz hasecode -------------:" + clazz1.hashCode());

    }
}
