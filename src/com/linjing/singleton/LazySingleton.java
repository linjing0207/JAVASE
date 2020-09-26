package com.linjing.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazySingleton {

    //懒汉式单例模式
    //比较懒，在类加载时，不创建实例，因此类加载速度快，但运行时获取对象的速度慢

    //私有静态成员
    private volatile static LazySingleton instance = null;

    //私有构造器
    private LazySingleton() {
    }

    public static LazySingleton getInstance(){
        //双检锁/双重校验锁（DCL，即 double-checked locking）

        //第一层校验: 提高效率，避免不必要的同步；如果实例已经创建，就不必等锁了。
        if(instance == null){
            synchronized (LazySingleton.class){
                //第二层校验:
                //若没有第二层校验线程B在等锁的过程中，其实线程A已经创建好实例了，线程B进入同步方法，又重新创建了实例。
                if (instance == null)
                    //new并不是原子操作
                    instance = new LazySingleton();  //让这个在整个程序中只执行一次
                    //memory = allocate(); //1：分配对象的内存空间
                    //ctorInstance(memory); //2：初始化对象
                    //instance = memory; //3：设置instance指向刚分配的内存地址

                    //JVM的指令重排：132
                    //若线程B执行了1, 3, 还未执行2. 线程A在第一层校验的时候，获得的instance已经非空了，则返回instance。
                    //而此时的instance还没有初始化对象，只是一个虚无的地址。
                    //使用了volatile关键字, 可以避免指令重排。
            }
        }
        return instance;
    }

    //反射可以破坏单例
    public static void main(String[] args)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LazySingleton instance1 = LazySingleton.getInstance();
        //空参构造器
        Constructor<LazySingleton> declaredConstructor = LazySingleton.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true); //获得属性
        LazySingleton instance2 = declaredConstructor.newInstance();

        System.out.println(instance1 == instance2);
    }
}
