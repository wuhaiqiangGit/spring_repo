package com.whq.mvc.base.serial;

public class Teacher {
    private int id;
    private String name;
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Teacher(int id, String name, Person person) {
        this.id = id;
        this.name = name;
        this.person = person;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
