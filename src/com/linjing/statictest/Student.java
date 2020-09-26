package com.linjing.statictest;

//static
public class Student {

    //静态变量（类变量），附属于类的
    private static int age;
    //非静态变量（成员变量），附属于对象的，需要先有对象
    private double score;

    //每个对象有各自的成员变量，但共享同一个静态变量。静态变量是对象的共享资源。

    //非静态代码块
    {

    }

    //静态代码块
    static {

    }

    //普通方法
    public void run() {
        go(); //非静态方法可以去调静态方法
    }

    //静态方法：类加载的时候分配内存
    public static void go() {
        //静态方法不能调用普通方法（即对象的方法），因为对象的方法在类加载的时候都还没普通方法
    }

    //main方法也是静态方法
    public static void main(String[] args) {
        Student s1 = new Student();

        //属性：
        System.out.println(s1.age);//对象里的属性
        System.out.println(s1.score);
        //静态变量对于类而言，在内存中只有一个，能被类中的所有实例去共享。
        System.out.println(Student.age);//静态变量：类变量
        //        System.out.println(Student.score);


        //方法：
        s1.run(); //对象的方法，需要先得到对象。
        Student.go(); //静态方法
        go(); //因为在当前这个类里面。
    }
}
