package org.compulsory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Compulsory {
    public static void main(String[] args) {
        LinkedList<Student> studentsList = new LinkedList<>();
        TreeSet<Project> projectsTree = new TreeSet<>();

        var students = IntStream.rangeClosed(0, 2).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);

        Collections.addAll(studentsList, students);
        Collections.sort(studentsList);

        System.out.println("All students sorted:");
        for (Student s : students) {
            System.out.println(s.getName());
        }

        var projects = IntStream.rangeClosed(0, 2).mapToObj(i -> new Project("P" + i)).toArray(Project[]::new);

        Collections.addAll(projectsTree, projects);

        projectsTree.stream().sorted();

        System.out.println("All projects sorted:");
        for (Project p : projects) {
            System.out.println(p.getName());
        }
    }
}