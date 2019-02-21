package com.ordinaryyzh.javase.thread.memoryvisibility;

/**
 * @author genericyzh
 * @date 2018/6/27 12:24
 */
public class Game {

    public static void main(String[] args) throws InterruptedException {
        // Game begun! Init goalNotifier thread
        GoalNotifier goalNotifier = new GoalNotifier();
        Thread goalNotifierThread = new Thread(goalNotifier);
        goalNotifierThread.start();

        // After 3s
        Thread.sleep(100);
        // Goal !!!
        goalNotifier.setGoal(true);
    }
}

class GoalNotifier implements Runnable {
    public boolean goal = false;

    public boolean isGoal() {
        return goal;
    }

    public void setGoal(boolean goal) {
        this.goal = goal;
    }

    @Override
    public void run() {
        while (true) {
            if (isGoal()) {
                System.out.println("Goal !!!!!!");

                // Tell the referee the ball is in.
                // ...

                // reset goal flag
                setGoal(false);
            }
        }
    }
}