package com.linjing.chainprogramming;

//链式编程 Chain Programming
public class Student {

    private String name;
    private int age;

    //set方法: 返回当前对象.
    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

}
