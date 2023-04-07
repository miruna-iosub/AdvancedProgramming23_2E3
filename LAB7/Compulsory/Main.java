package org.compulsory;

public class Main{ 
    public static void main(String[] args) {
        Exploration exploration = new Exploration(3, 2);
        exploration.startExploration();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exploration.stopExploration();
        System.out.println("Exploration has stopped.");
    }
}