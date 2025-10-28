package com.survivalcoding.kotlinstudy;

//int a = 10;

public class JavaMain {
    static final int a = 10;

    int b = a;

    public static void main(String[] args) {
        int i = 10;
        Integer ii = 10;

        long ll = i;
        char c = 'a';
        char cc = 10;
        float f = 10f;
        double d = 10.0;
        boolean bb = true;

        d = f;
        f = (float) d;

        String s = "hello world";

        int a = 10;
        int b = 5;

        int result = a > b ? a : b;

        for (int j = 0; j < 10; j++) {

        }
    }
}


class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
        name = "홍길동";
    }
}