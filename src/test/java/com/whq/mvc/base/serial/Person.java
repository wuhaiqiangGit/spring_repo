package com.whq.mvc.base.serial;

import java.io.Serializable;

public class Person implements Serializable {

    private final static long serialVersionUID = 1L;

    private int id;
    private transient String name;

    public static String nickName;

    public Person(int id, String name) {
        System.out.printf("构造方法执行");
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
