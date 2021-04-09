package cn.itcast.domain;

public class Child {
    String name;
    int age;


    @Override
    public String toString() {
        return "child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
