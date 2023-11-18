package org.main;

public class Human {
    private int age;
    private String  name;


    public Human(int age, String name){
        this.age = age;
        this.name = name;

    }
    public void print(){
        System.out.println("age = " + age );
        System.out.println("name = " + name + "\n");

    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
