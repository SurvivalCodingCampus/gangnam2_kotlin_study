package com.survivalcoding.kotlinstudy;

import java.util.function.Consumer;

public class LambdaJavaMain {
    public static void main(String[] args) {
        someMethod(new MyConsumer());

        // 익명 함소
        someMethod(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // 람다
        someMethod(s -> {
            System.out.println(s);
        });

        // 메서드 레퍼런스
        someMethod(System.out::println);
    }

    public static void someMethod(Consumer<String> function) {
        function.accept("Hello");
    }
}

interface MyInterface<T> {
    void myAction(T a);
}

class MyConsumer implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
