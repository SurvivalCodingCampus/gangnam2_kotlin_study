package com.survivalcoding.kotlinstudy;

// int a = 10;


public class JavaMain {
    // 코드를 쓰는 순간 메모리에 10이 바로 올라가
    static int a = 10;
    public static void main(String[] args) {
        // primitive
        // 왜 존재? 성능향상 ..?
        int i = 10;
        Integer ii = 10;
        long ll = i;
        char c = 'a';
        char cc = 10;
        float f = 10f;
        double d = 10.0;
        boolean bb = true;

        // 강제로 구겨 넣기
        d = f;
        f = (float) d;

        // 객체
        String s = "hello world";


        int a = 10;
        int b = 5;

        int result = a > b ? a : b;

        for (int j = 0; j < 10; j++) ;

    }
}

class Person {
    private int age;
    private String name;

    // 생성자 1: age, name 둘 다 받는 경우
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // 생성자 2: name만 기본값으로 초기화하고 싶은 경우
    public Person() {
        this.name = "홍길동";
    }
}