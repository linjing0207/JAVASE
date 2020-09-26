package com.linjing.singleton;

//饿汉模式
public class EagerSingleton {

    //饿汉式，从名字上也很好理解，就是“比较勤”，实例在初始化的时候就已经建好了，不管你有没有用到，都先建好了再说。
    //好处是没有线程安全的问题，坏处是浪费内存空间。

    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

}
