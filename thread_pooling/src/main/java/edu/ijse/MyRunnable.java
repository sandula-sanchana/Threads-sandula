package edu.ijse;

public class MyRunnable implements Runnable{
    private String threadName;
    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + " is running");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " - Count: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted.");
        }
        System.out.println(threadName + " has finished execution.");
    }

    public static void main(String[] args) {

    }
}
