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

        List<Project> projectListFirstStudent = new ArrayList<>(projects);

        List<Project> projectListSecondStudent = new ArrayList<>();
        projectListSecondStudent.add(projectListFirstStudent.get(0));
        projectListSecondStudent.add(projectListFirstStudent.get(1));

        List<Project> projectListThirdStudent = new ArrayList<>();
        projectListThirdStudent.add(projectListFirstStudent.get(2));

        problem.projectList.addAll(projectListFirstStudent);

        Problem.prefMap.put(students.get(0), projectListFirstStudent);
        Problem.prefMap.put(students.get(1), projectListSecondStudent);
        Problem.prefMap.put(students.get(2), projectListThirdStudent);

        System.out.println(problem);

        problem.studentList.stream().filter(s -> Problem.prefMap.get(s).size() < problem.averageNumOfPref(Problem.prefMap, problem.projectList)).forEach(System.out::println);

        problem.solvingAlgorithm(Problem.prefMap);
        System.out.println(problem.greedyMap);
    }
}