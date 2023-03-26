package src.main.java.org.homework;

import java.util.*;

public class Problem {
    public static Map<Student, List<Project>> prefMap = new HashMap<>();
    public Map<Student, Project> greedyMap = new HashMap();
    public List<Project> projectList = new ArrayList();
    public List<Student> studentList = new ArrayList();

    public Problem() {}

    public void addProject(List projectList) {
        projectList.add(projectList);
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void addPreferences(Student student, List projList) {
        prefMap.put(student, projList);
    }
    public void addStudentsProject(Student student, Project project) {
        greedyMap.put(student, project);
    }
    public void solvingAlgorithm(Map<Student, List<Project>> prefMap) {
        for (Map.Entry<Student, List<Project>> entry : prefMap.entrySet()) {
            int count = 0;
            if (greedyMap.isEmpty()) {
                addStudentsProject(entry.getKey(), entry.getValue().get(count));
            }
            while (count < entry.getValue().size()) {
                if (greedyMap.containsValue(entry.getValue().get(count))) {
                    count++;
                } else {
                    addStudentsProject(entry.getKey(), entry.getValue().get(count));
                }
            }
        }
    }

    public double averageNumOfPref(Map<Student, List<Project>> map, List<Project> projectsList) {
        double average = 0;
        for (Map.Entry<Student, List<Project>> entry : map.entrySet())
            average += entry.getValue().size();
        average = average/projectsList.size();
        return average;
    }

    @Override
    public String toString() {
        return "Problem{" + "studentList=" + studentList + ", projectList=" + projectList + '}';
    }
}