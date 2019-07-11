package com.inspur.jvm.classloader_02;

/**
 * Created by Administrator on 2019/4/16.
 */
public class MySample {

    public MySample (){
        System.out.println("MySample load is by " + this.getClass().getClassLoader());
        new MyCat();
    }

}
