package org.fbs.user_generator_v2.data;

public class People {

    private String name;
    private String id;
    private int age, height, weight;

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
    public String getId() {
        return id;
    }

    public People(String name, int age, int height, int weight, String id){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Name : " + name + "\n" +
                "Age : " + age + "\n" +
                "Height : " + height + "\n" +
                "Weight : " + weight + "\n";
    }
}
