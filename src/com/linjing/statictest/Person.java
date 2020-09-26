package com.linjing.statictest;

public class Person {

    private static int a = 0; //静态成员变量
    private int b = 1; //非静态成员变量, 普通变量ß

    //非静态代码块（匿名代码块）：赋初始值
    //程序在执行的时候，不能主动调用这块代码；只有在创建对象的时候，才能自动创建这块代码。在构造器之前。
    {
        System.out.println("匿名代码块"); //2
    }

    //只执行一次！！！
    //静态代码块（匿名代码块）：初始化数据
    //类加载的时候执行
    static {
        System.out.println("静态代码块");  //1
    }

    public Person() {
        System.out.println("构造器");  //3
    }

    public static void func1(){
        System.out.println("静态方法.");
        System.out.println("静态成员变量: " + a);
    }

    public void func2(){
        System.out.println("普通方法.");
        System.out.println("普通成员变量: " + b);
    }

    public static void main(String[] args) {
        //不new对象, 在当前类中的main方法里, 只会执行1
//        Person.func1();

        System.out.println("=====");
        //new了对象, 才会去执行非静态代码块2+构造器3
        new Person().func2();


    }
}
