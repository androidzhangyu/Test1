package com.sanding.testsqlite.bean;

/**
 * Created by Administrator on 2017/8/5.
 */

public class Person {
    private int _id;
    private  String age;
    private  String name;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, String age, int _id) {
        this.name = name;
        this.age = age;
        this._id = _id;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "_id=" + _id +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
