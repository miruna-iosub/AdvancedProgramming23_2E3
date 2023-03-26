package src.main.java.org.homework;

public class Student implements Comparable<Student> {
    private String name;

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
    public String toString() {
        return "Student{" + "name=" + name + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Student other)) {
            return false;
        }
        return name.equals(other.name);
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }


}