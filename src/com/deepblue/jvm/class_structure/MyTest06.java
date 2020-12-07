package com.deepblue.jvm.class_structure;

/**
 * 方法重写,完全是动态的过程,这和重载是完全不同的方式!
 */
public class MyTest06 {

    public static void main(String[] args){
        Fruit fruit1 = new Apple();
        Fruit fruit2 = new Orange();

        fruit1.test();
        fruit2.test();

        fruit1 = new Orange();
        fruit1.test();
    }
}


class Fruit {
    public void test () {
        System.out.println("fruit");
    }
}

class Apple extends  Fruit {
    @Override
    public void test() {
        System.out.println("apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("orange");
    }
}