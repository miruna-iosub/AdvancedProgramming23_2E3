package org.homework;

//Daemon class which returns time keeping of an exploration
public class TimeKeeper extends Thread {
    int timeLeft;

    public TimeKeeper(int seconds) {
        this.timeLeft = seconds;
    }

    @Override
    public void run() {
        while (timeLeft > 0) {
            try {
                Thread.sleep(1000);
                timeLeft--;
                if(timeLeft < 30 && timeLeft % 10 == 0) System.out.println(timeLeft + " seconds left");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}