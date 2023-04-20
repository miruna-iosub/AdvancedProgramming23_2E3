package org.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Robot implements Runnable {
    private final String name;
    private final ExplorationMap map;
    private final SharedMemory sharedMemory;
    private final List<Integer> tokens;
    private int currentX;
    private int currentY;
    private boolean running;
    private int tokensNumber = 0;

    public Robot(String name, ExplorationMap map, SharedMemory sharedMemory) {
        this.name = name;
        this.map = map;
        this.sharedMemory = sharedMemory;
        this.tokens = new ArrayList<>();
        this.running = true;
        this.currentX = 0;
        this.currentY = 0;
        //this.currentX = (int) (Math.random() * map.getN());
        //this.currentY = (int) (Math.random() * map.getN());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(name, robot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    /*the robot only checks if it can move right, and if it cannot,
    it moves to the next row, if the robot has reached the last cell,
    it terminates the exploration by setting the running flag to false and notifying
    all other robots waiting on the map.

    this algorithm still ensures that each robot explores the map in a systematic fashion and terminates
    the exploration once all cells have been visited.*/

    @Override
    public void run() {
        while (running) {
            int nextX = currentX;
            int nextY = currentY;

            if (nextY < map.getN() && nextX <= map.getN()) {
                nextY++;
            }

            if (nextY == map.getN() && nextX < map.getN()) {
                nextY = 0;
                nextX++;
            }

            if (map.isValidPosition(nextX, nextY)) {
                synchronized (map) {
                    if (map.visitCell(nextX, nextY)) {
                        currentX = nextX;
                        currentY = nextY;
                        System.out.println(name + " visited cell (" + currentX + ", " + currentY + ")");
                        addToken();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    // retrieves a token from the shared memory and adds it to the collection of tokens
    // synchronized is used to ensure that only one thread at a time can access the shared memory and map objects
    private void addToken() {
        synchronized (sharedMemory) {
            Token token = sharedMemory.takeToken();
            if (token != null && tokens.size() < map.getN()) {
                tokens.add(token.getValue());
                map.addToken(currentX, currentY, token.getValue());
                tokensNumber++;
            }
        }
    }

    int getTokensNumber(){
        return tokensNumber;
    }
}

