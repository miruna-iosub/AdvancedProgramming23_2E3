package src.main.java.org.homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Homework {
    public static void main(String[] args) {
        Problem problem = new Problem();
        Faker faker = new Faker();

        var listStudents = IntStream.rangeClosed(0, 2).mapToObj(i -> new Student(faker.name().fullName())).toArray(Student[]::new);

        List<Student> students = new LinkedList<>();
        Collections.addAll(students, listStudents);

        problem.studentList.add(students.get(0));
        problem.studentList.add(students.get(1));
        problem.studentList.add(students.get(2));

        var projectsList = IntStream.rangeClosed(0, 2).mapToObj(i -> new Project(faker.app().name())).toArray(Project[]::new);
        Set<Project> projects = new TreeSet<>();
        Collections.addAll(projects, projectsList);

        List<Project> projectList = new ArrayList<>(projects);

        List<Project> projectList1 = new ArrayList<>();
        projectList1.add(projectList.get(0));
        projectList1.add(projectList.get(1));

        List<Project> projectList2 = new ArrayList<>();
        projectList2.add(projectList.get(2));

        problem.projectList.addAll(projectList);

        Problem.prefMap.put(students.get(0), projectList);
        Problem.prefMap.put(students.get(1), projectList1);
        Problem.prefMap.put(students.get(2), projectList2);

        System.out.println(problem);

        problem.studentList.stream().filter(s -> Problem.prefMap.get(s).size() < problem.averageNumOfPref(Problem.prefMap, problem.projectList)).forEach(System.out::println);

        problem.solvingAlgorithm(Problem.prefMap);
        System.out.println(problem.greedyMap);
    }
}