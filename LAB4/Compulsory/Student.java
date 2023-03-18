package org.Compulsory;

public class Student implements Comparable<Student>{
    private String name;
    private int age;


    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return name.compareTo(other.name);
    }

}
