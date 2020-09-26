package com.linjing.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//枚举本身也是一个class类。
//可以防止反射构建。
public enum EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args)
        throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        System.out.println(instance1 == instance2);

        //其实枚举类EnumSingleton，没有空参构造器
        //构造器：EnumSingleton(String s, int i)
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton instance3 = declaredConstructor.newInstance();
        System.out.println(instance1 == instance3);

    }
}
