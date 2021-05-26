package com.example.objectmapper;

public class User {
    private String name;
    private int age;

    public User() {  }
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // get이 메소드명에서 빠져야함 그래야 objectmapper 가 이해한다.
//    public User getDefaultUser() {
//        return new User("default", 0);
//    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
