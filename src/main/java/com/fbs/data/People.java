package com.fbs.data;

public class People {

    private String name;
    private String id;
    private String phoneNumber;
    private String country, city;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    private int age, height, weight;

    public People(String name, int age, int height, int weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  "Name : " + name + "\n" +
                "Age : " + age + "\n" +
                "Height : " + height + "\n" +
                "Weight : " + weight + "\n";
    }
}
