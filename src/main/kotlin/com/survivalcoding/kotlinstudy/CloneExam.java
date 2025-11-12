package com.survivalcoding.kotlinstudy;

public class CloneExam {
    public static void main(String[] args) {
        Person4 cloneable = new Person4(10);

        Person4 person5 = cloneable.clone();
    }
}

class Person4 implements Cloneable {
    private int age;

    public Person4(int age) {
        this.age = age;
    }

    public Person4 clone() {
        return new Person4(age);
    }
}
