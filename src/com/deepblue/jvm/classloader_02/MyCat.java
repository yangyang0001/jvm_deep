package com.deepblue.jvm.classloader_02;

/**
 * Created by Administrator on 2019/4/16.
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat load is by " + this.getClass().getClassLoader());
    }

}
