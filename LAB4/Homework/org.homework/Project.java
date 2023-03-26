package src.main.java.org.homework;

public class Project implements Comparable<Project> {
    private String name;

    public Project(String name) {
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
        return "Project{" + "name=" + name + '}';
    }

    @Override
    public int compareTo(Project other) {
        return this.name.compareTo(other.getName());
    }
}