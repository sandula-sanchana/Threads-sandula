package edu.ijse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            MyRunnable myRunnable = new MyRunnable("work thred"+i);
            executorService.execute(myRunnable);
        }
        executorService.shutdown();
    }
}