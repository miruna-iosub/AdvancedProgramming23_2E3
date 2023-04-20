package org.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exploration {
    private static List<Robot> robots =  new ArrayList<>();
    private TimeKeeper timekeeper;
    private ExplorationMap explorationMap;
    private SharedMemory sharedMemory;
    public Exploration(int n, int numRobots) {
        explorationMap = new ExplorationMap(n);
        sharedMemory = new SharedMemory(n * n);
        robots = new ArrayList<>();
        for (int i = 1; i <= numRobots; i++) {
            Robot robot = new Robot("Robot" + i, explorationMap, sharedMemory);
            robots.add(robot);
        }
    }

    //method used to launch the thread for each Robot
    public void startExploration() {
        TimeKeeper timekeeper = new TimeKeeper(100);
        Thread th = new Thread(timekeeper);
        th.start();

        for (Robot robot : robots) {
            Thread t = new Thread(robot);
            t.start();
        }
    }

    public void stopExploration() {
        for (Robot robot : robots) {
            robot.setRunning(false);
        }
    }
    public static void main(String[] args) {
        Exploration exploration = new Exploration(3, 2);
        //exploration.startExploration();

        Scanner scanner = new Scanner(System.in);
        String command = "";
        System.out.println("Enter a command: (start, pause <robot name> <time>)");

        while (!command.equals("exit")) {
            command = scanner.nextLine();

            if (command.equals("start")) {
                exploration.startExploration();
                for (Robot robot : robots) {
                    robot.setRunning(true);
                }
            } else if (command.startsWith("pause")) {
                String[] tokens = command.split(" ");
                if (tokens.length == 3) {
                    String robotName = tokens[1];
                    int pauseTime = Integer.parseInt(tokens[2]);
                    for (Robot robot : robots) {
                        if (robot.getName().equals(robotName)) {
                            robot.setRunning(false);
                            try {
                                Thread.sleep(pauseTime * 1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            robot.setRunning(true);
                        }
                    }
                }
            }
        }

        exploration.stopExploration();

        for(Robot robot : robots){
            System.out.println(robot.getName() + " added " + robot.getTokensNumber() + " tokens.");
        }
        System.out.println("Exploration has stopped");
    }
}
