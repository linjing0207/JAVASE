package com.linjing.chainprogramming;

public class Test {

    public static void main(String[] args) {
        //链式编程
//        Student1 student = new Student1().setName("小猪佩奇").setAge(5);
        User user = new User.UserBuilder().setName("小猪佩奇").setAge(5).build();
    }
}
